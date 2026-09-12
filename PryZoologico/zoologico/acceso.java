package zoologico;

import java.sql.*;
import java.util.Scanner;

public class acceso {
    public static void acess(Connection con){
        ResultSet rs;
        Statement stmt;
        Scanner tec = new Scanner(System.in);
        int n_doc;
        System.out.println("Ingreso su numero de documento: ");
        n_doc = tec.nextInt();
        String sql = "SELECT * FROM registro_p Where `numero de documento` = '"+n_doc+"'";
        try {
           stmt = con.createStatement();
           rs = stmt.executeQuery(sql);
           if (rs.next()) { // Verifica si hay resultados (si el número de documento existe)
            int docBase = rs.getInt("numero de documento"); // Número de documento en la base de datos

            // Validar si el número de documento ingresado es igual al de la base de datos
            if (n_doc == docBase) {
                String name = rs.getString("Nombre");
                String tipoDocumento = rs.getString("Tipo de documento");

                System.out.println("Acceso concedido.");
                System.out.println("Nombre: " + name + ", Tipo de documento: " + tipoDocumento + ", N° Documento: " + docBase);
                eliminar.eliminarUsuario(con, n_doc);
            }
        } else {
            // Si no se encuentra ningún resultado en la base de datos
            System.out.println("Número de documento no encontrado.");
        }

    } catch (SQLException e) {
        System.out.println("Error en la consulta: " + e.getMessage());
    }
    
    
    }
}
