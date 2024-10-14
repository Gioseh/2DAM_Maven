package es.cheste.AD.UD2_DataBaseConnectors.EjemploPreparedStmt;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class EjemploPreparedStmt {
    private static final Logger LOGGER = LogManager.getRootLogger();

    public static void main(String[] args) {

        ConexionBD conexion = new ConexionBD();
        Connection con = conexion.getConnection();
        //insertPrepared(con);
        //crearTablaClientes1(con);
        insertTransacciones(con);
        conexion.desconectar();
    }

    private static void crearTablaClientes1(Connection conexion) {

        String sql = "CREATE TABLE CLIENTES1(DNI CHAR(9) NOT NULL, APELLIDOS VARCHAR(32) NOT NULL, CP CHAR(5), PRIMARY KEY (DNI))";
        if(conexion == null) {
            LOGGER.error("No hay conexión con base de datos, no se puede ejecutar la consulta.");
            System.out.println("No hay conexión con base de datos, no se puede ejecutar la consulta.");
            return;
        }

        try (Statement stmt = conexion.createStatement()){

            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            LOGGER.error("Error al crear la tabla clientes1", e);
        }
    }

    private static void insertTransacciones(Connection conexion) {
        try(PreparedStatement sInsert = conexion.prepareStatement("INSERT INTO clientes1(DNI, APELLIDOS, CP) VALUES (?,?,?);");) {

            conexion.setAutoCommit(false);

            int i=0;
            sInsert.setString(++i,"54320198V");
            sInsert.setString(++i,"CARVAJAL");
            sInsert.setString(++i,"10109");
            sInsert.executeUpdate();

            sInsert.setString(i = 1,"76543210S");
            sInsert.setString(++i,"MARQUEZ");
            sInsert.setString(++i,"46987");
            sInsert.executeUpdate();

            sInsert.setString(i = 1,"56789012B");
            sInsert.setString(++i,"SAMPER");
            sInsert.setString(++i, "35153");
            sInsert.executeUpdate();

            conexion.commit();


        } catch (SQLException e) {
            muestraErrorSQL(e);

            try{

                conexion.rollback();
                System.err.println("Se hace ROLLBACK");

            }catch (SQLException ex){
                System.err.println("ERROR haciendo ROLLBACK");
                muestraErrorSQL(ex);
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    private static void insertPrepared(ConexionBD conexion) {

        try(PreparedStatement sInsert = conexion.getConnection().prepareStatement("INSERT INTO clientes(DNI, APELLIDOS, CP) VALUES (?,?,?);");) {


            sInsert.setString(1,"78901234X");
            sInsert.setString(2,"NADALES");
            sInsert.setInt(3,44126);
            sInsert.executeUpdate();

            int i = 1;
            sInsert.setString(i++,"76543210S");
            sInsert.setString(i++,"MARQUEZ");
            sInsert.setNull(i++,Types.INTEGER);
            sInsert.executeUpdate();

            i=1;
            sInsert.setString(i++,"56789012B");
            sInsert.setString(i++,"SAMPER");
            sInsert.setInt(i++, 29730);
            sInsert.executeUpdate();




        } catch (SQLException e) {
            muestraErrorSQL(e);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    public static void muestraErrorSQL(SQLException e){
        System.err.println("SQL ERROR mensaje: "+e.getMessage());
        System.err.println("SQL Estado: "+e.getSQLState());
        System.err.println("SQL código especifico: "+e.getErrorCode());
    }
}



