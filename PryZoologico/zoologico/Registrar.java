package zoologico;
import java.sql.*;
import java.util.Scanner;

public class Registrar {
    public static void Registro_user(Connection con){
        Scanner tec = new Scanner(System.in);
        String name;
        String tipodocumento;
        int n_doc;
        
        String TD [] = {"NIT", "CC", "TI"};
        boolean validInput = false;

        // Solicitar el nombre
        System.out.println("Ingrese su nombre:");
        name = tec.nextLine();

        // Solicitar el tipo de documento y validar que sea correcto
        do {
            System.out.println("Ingrese el tipo de documento (NIT, CC, TI):");
            tipodocumento = tec.nextLine().toUpperCase(); // Convertir a mayúsculas para comparar

            // Verificar si el tipo de documento ingresado está en la lista TD
            for (String tipo : TD) {
                if (tipo.equals(tipodocumento)) {
                    validInput = true; // Si es válido, salir del bucle
                    break;
                }
            }

            if (!validInput) {
                System.out.println("Tipo de documento no válido. Intente nuevamente.");
            }
        } while (!validInput);
        System.out.println("Ingrese su numero de documento: ");
        n_doc = tec.nextInt();
        String sql = "Insert Into registro_p(Nombre,`Tipo de documento`, `numero de documento`) values('"+name+"', '"+tipodocumento+"','"+n_doc+"')";
        Statement stmt;
        int result;
        
        try {
            stmt = con.createStatement();
            result = stmt.executeUpdate(sql);
            System.out.println("Registro Exitoso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    

    }
    

}

