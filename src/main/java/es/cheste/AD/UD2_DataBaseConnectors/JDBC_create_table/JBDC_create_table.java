package es.cheste.AD.UD2_DataBaseConnectors.JDBC_create_table;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JBDC_create_table {

    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final String FILENAME = "src/main/resources/AD/UD2_DataBaseConnectors/JDBC_create_table/application.properties";

    public static void main(String[] args) {

        ConexionBD conexion = new ConexionBD();
        //crearTablaEmpresa(conexion); //Crea la tabla empresa
        insertarClientes(conexion);  //Inserta los empleados
        conexion.desconectar();
    }

    private static void crearTablaEmpresa(ConexionBD conexion) {

        String sql = "CREATE TABLE CLIENTES(DNI CHAR(9) NOT NULL, APELLIDOS VARCHAR(32) NOT NULL, CP CHAR(5), PRIMARY KEY (DNI))";
        if(conexion == null) {
            LOGGER.error("No hay conexión con base de datos, no se puede ejecutar la consulta.");
            System.out.println("No hay conexión con base de datos, no se puede ejecutar la consulta.");
            return;
        }

        try (Statement stmt = conexion.getConnection().createStatement()){

            stmt.execute(sql);

        } catch (Exception e) {
            LOGGER.error("Error al consultar empleados", e);
        }
    }

    private static void insertarClientes(ConexionBD conexion) {


        try(Statement stmt = conexion.getConnection().createStatement()) {

            int nFil = stmt.executeUpdate(
                    "INSERT INTO CLIENTES (DNI, APELLIDOS, CP) VALUES " +
                            "('78901234X','NADALES','44126'), " +
                            "('89012345E','HOJAS',NULL), " +
                            "('56789012B','SAMPER','29730'), " +
                            "('09876543K','LAMIQUIZ',NULL);"
            );

            System.out.println(nFil + " Filas insertadas.");

        } catch (SQLException e) {
            System.err.println("SQL código específico: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}
