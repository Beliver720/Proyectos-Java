package zoologico;
import java.sql.*;

public class eliminar {
    public static void eliminarUsuario(Connection con, int n_doc) {
        String sql = "DELETE FROM registro_p WHERE `numero de documento` = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, n_doc);
            int res = pstmt.executeUpdate();
            if (res == 1) {
                System.out.println("Se borró al usuario con número de documento: " + n_doc);
            } else {
                System.out.println("El usuario con número de documento: " + n_doc + " no existe");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
    public static void Elimina_animal(Connection con) {
        Animal animal = Animal.solicitarDatosAnimal();
        String n_animal = animal.getNombre();
        
        String sql = "DELETE FROM animales WHERE LOWER(nombre) = LOWER(?)"; // Insensible a mayúsculas
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, n_animal);
            int res = pstmt.executeUpdate();
            if (res == 1) {
                System.out.println("Se eliminó el animal: " + n_animal);
            } else {
                System.out.println("El animal: " + n_animal + " no existe");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
