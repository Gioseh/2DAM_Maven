package es.cheste.AD.UD2_DataBaseConnectors.Ejercicio1;

import es.cheste.AD.UD2_DataBaseConnectors.JDBC_create_table.ConexionBD;

import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio1 {
    public static void main(String[] args) {
        ConexionBD conexionBD = new ConexionBD();
        borrarClientes(conexionBD);
        actualizarClientes(conexionBD);
        conexionBD.desconectar();
    }

    private static void borrarClientes(ConexionBD conexion) {


        try(Statement stmt = conexion.getConnection().createStatement()) {



            int nFil = stmt.executeUpdate(
                    "DELETE FROM clientes WHERE clientes.DNI='09876543K';"
            );

            System.out.println(nFil + " Filas eliminadas.");

        } catch (SQLException e) {
            System.err.println("SQL código específico: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    private static void actualizarClientes(ConexionBD conexion) {


        try(Statement stmt = conexion.getConnection().createStatement()) {



            int nFil = stmt.executeUpdate(
                    "UPDATE clientes SET clientes.APELLIDOS='ROJAS' WHERE clientes.APELLIDOS='HOJAS';"
            );

            System.out.println(nFil + " Filas actualizadas.");

        } catch (SQLException e) {
            System.err.println("SQL código específico: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}
