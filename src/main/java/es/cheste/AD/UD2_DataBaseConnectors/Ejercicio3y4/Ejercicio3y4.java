package es.cheste.AD.UD2_DataBaseConnectors.Ejercicio3y4;

import es.cheste.AD.UD2_DataBaseConnectors.JDBC_create_table.ConexionBD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio3y4 {
    public static void main(String[] args) {
        ConexionBD conexionBD = new ConexionBD();
        recuperarCpClientesInverso(conexionBD);
        obtenerFilasClientes(conexionBD);
        conexionBD.desconectar();
    }

    private static void recuperarCpClientesInverso(ConexionBD conexion) {


        try(Statement stmt = conexion.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_READ_ONLY);) {

            ResultSet rs = stmt.executeQuery("select clientes.CP from clientes");

            String cpString;

            rs.afterLast();
            while (rs.previous()) {
                cpString = rs.getString("CP");
                System.out.println(cpString);
            }



        } catch (SQLException e) {
            System.err.println("SQL código específico: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    private static void obtenerFilasClientes(ConexionBD conexion) {


        try(Statement stmt = conexion.getConnection().createStatement()) {

            ResultSet rs = stmt.executeQuery("select * from clientes");

            rs.last();
            int filas = rs.getRow();

            System.out.println("Numero de filas : " + filas);



        } catch (SQLException e) {
            System.err.println("SQL código específico: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

}
