package zoologico;

import java.sql.*;


public class Main {

    public static Connection conectarBD(String bd){
        Connection conexion;

        String host = "jdbc:mysql://localhost/";
        String user = "root";
        String pass = "";
        System.out.println("Conectando...");

        try {
            conexion = DriverManager.getConnection(host+bd, user, pass);
            System.out.println("Conexion exitosa");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
            
        }
        return conexion;
    }
    

    public static void main(String[] args) {
        Connection cs = conectarBD("zoologico");
        
        Menu.gestion_menu(cs);
        
        
}
}
