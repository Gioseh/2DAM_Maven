package es.cheste.AD.UD2_DataBaseConnectors.TablaFcturas;

import es.cheste.AD.UD2_DataBaseConnectors.EjemploPreparedStmt.ConexionBD;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TablaFacturas {
    private static final Logger LOGGER = LogManager.getRootLogger();

    public static void main(String[] args) {

        ConexionBD conexion = new ConexionBD();
        Connection con = conexion.getConnection();
        //crearTablaFacturas(con);
        crearTablaLineaFacturas(con);
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
}


