package es.cheste.AD.UD2_DataBaseConnectors.TablaFcturas;

import es.cheste.AD.UD2_DataBaseConnectors.EjemploPreparedStmt.ConexionBD;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class TablaFacturas {
    private static final Logger LOGGER = LogManager.getRootLogger();

    public static void main(String[] args) {

        ConexionBD conexion = new ConexionBD();
        Connection con = conexion.getConnection();
        //crearTablaFacturas(con);
        //crearTablaLineaFacturas(con);
        //insertarLineasFacturas(con);
        delimiter(con);
        conexion.desconectar();
    }

    private static void crearTablaFacturas(Connection conexion) {

        String sql = "CREATE TABLE FACTURAS(NUM_FACTURA INTEGER AUTO_INCREMENT NOT NULL, DNI_CLIENTE CHAR(9) NOT NULL, PRIMARY KEY (NUM_FACTURA), FOREIGN KEY FK_FACT_DNI_CLIENTES(DNI_CLIENTE) REFERENCES clientes(DNI))";
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

    private static void crearTablaLineaFacturas(Connection conexion) {

        String sql = "CREATE TABLE LINEAS_FACTURAS(NUM_FACTURA INTEGER NOT NULL, LINEA_FACTURA SMALLINT NOT NULL, CONCEPTO VARCHAR(32) NOT NULL , CANTIDAD SMALLINT NOT NULL , PRIMARY KEY (NUM_FACTURA, LINEA_FACTURA), FOREIGN KEY FK_LINEAFACT_NUM_FACTURA(NUM_FACTURA) REFERENCES facturas(NUM_FACTURA))";
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

    private static void insertarLineasFacturas(Connection conexion) {
        try (PreparedStatement sInsertFact = conexion.prepareStatement("INSERT INTO FACTURAS(DNI_CLIENTE) VALUES (?)",PreparedStatement.RETURN_GENERATED_KEYS);
        PreparedStatement sInsertLineasFact = conexion.prepareStatement("INSERT INTO LINEAS_FACTURAS(NUM_FACTURA, LINEA_FACTURA, CONCEPTO, CANTIDAD) VALUES (?,?,?,?);");){
            conexion.setAutoCommit(false);

            int i =1;
            sInsertFact.setString(i++,"78901234x");
            sInsertFact.executeUpdate();
            ResultSet rs = sInsertFact.getGeneratedKeys();
            rs.next();
            int numFact = rs.getInt(1);

            int lineaFact = 1;
            i = 1;
            sInsertLineasFact.setInt(i++,numFact);
            sInsertLineasFact.setInt(i++,lineaFact++);
            sInsertLineasFact.setString(i++,"TUERCAS");
            sInsertLineasFact.setInt(i++,25);
            sInsertLineasFact.executeUpdate();

            i = 1;
            sInsertLineasFact.setInt(i++,numFact);
            sInsertLineasFact.setInt(i++,lineaFact++);
            sInsertLineasFact.setString(i++,"TORNILLOS");
            sInsertLineasFact.setInt(i++,250);
            sInsertLineasFact.executeUpdate();

            conexion.commit();
        } catch (SQLException e) {
            muestraErrorSQL(e);
            try{
                conexion.rollback();
                System.err.println("Se hace ROLLBACK");
            } catch (Exception ex) {
                System.err.println("Error haciendo ROLLBACK");
                ex.printStackTrace(System.err);
            }

        }
    }

    private static void delimiter(Connection conexion) {
        try(CallableStatement callableStatement = conexion.prepareCall("{call listado_parcial_clientes(?,?)}")) {
            callableStatement.setString(1,"78901234x");
            callableStatement.setInt(2,0);
            callableStatement.registerOutParameter(2,java.sql.Types.VARCHAR);

            callableStatement.execute();

            ResultSet rs = callableStatement.getResultSet();

            int inout_long = callableStatement.getInt(2);
            System.out.println("-> inout_long: "+inout_long);
            int nCli = 0;

            while(rs.next()) {
                System.out.println("[" + (++nCli) + "]: ");
                System.out.println("DNI: "+rs.getString("DNI"));
                System.out.println("APELLIDOS: "+rs.getString("APELLIDOS"));
            }

        } catch (SQLException e) {
            muestraErrorSQL(e);
        } catch (Exception e){
            e.printStackTrace(System.err);
        }
    }

    public static void muestraErrorSQL(SQLException e){
        System.err.println("SQL ERROR mensaje: "+e.getMessage());
        System.err.println("SQL Estado: "+e.getSQLState());
        System.err.println("SQL código especifico: "+e.getErrorCode());
    }
}


