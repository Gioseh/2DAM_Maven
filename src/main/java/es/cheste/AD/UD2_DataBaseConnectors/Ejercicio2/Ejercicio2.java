package es.cheste.AD.UD2_DataBaseConnectors.Ejercicio2;

import es.cheste.AD.UD2_DataBaseConnectors.JDBC_create_table.ConexionBD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio2 {
    public static void main(String[] args) {
        ConexionBD conexionBD = new ConexionBD();
        recuperarCpClientes(conexionBD);
        conexionBD.desconectar();
    }

    private static void recuperarCpClientes(ConexionBD conexion) {


        try(Statement stmt = conexion.getConnection().createStatement()) {

            ResultSet rs = stmt.executeQuery("select clientes.CP from clientes");

            int cp;
            String cpString;

            while (rs.next()) {
                cp = rs.getInt("CP");
                //cpString = rs.getString("CP");
                System.out.println(cp);
            }



        } catch (SQLException e) {
            System.err.println("SQL código específico: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }


}
