package zoologico;

import java.sql.SQLException;

public class Registrar_animal {
    public static void Registrar(){
        try {
            Zoologico zoo = new Zoologico();
            Animal animal = Animal.solicitarDatosAnimal();
            zoo.asignarZona(animal);
            System.out.println("Registro Exitoso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

        
}