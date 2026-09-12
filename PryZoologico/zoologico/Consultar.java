package zoologico;
import java.sql.*;
import java.util.Scanner;

public class Consultar {
    public static void consulta(Connection con){
        Scanner tec = new Scanner(System.in);
        Statement stmt;
        ResultSet rs;
        int id, n_doc;
        System.out.println("Ingrese su numero de documento");
        n_doc = tec.nextInt();
        String name, tipo_doc;
        String sql = "SELECT * FROM registro_p WHERE `numero de documento` = '"+n_doc+"'";
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) { // Verifica si hay resultados (si el número de documento existe)
                int docBase = rs.getInt("numero de documento"); // Número de documento en la base de datos
                id = rs.getInt("ID");
                name = rs.getString("Nombre");
                tipo_doc = rs.getString("Tipo de documento");

                System.out.println("ID: "+id+"  Nombre: "+name+"  Tipo de documento: "+tipo_doc+"  N° Documento: "+n_doc);
                
                // Validar si el número de documento ingresado es igual al de la base de datos
                if (n_doc == docBase) {
                    rs.getString("Nombre");
                    
                    
                }
                
                
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
        
        
    }
}
            
            


    
