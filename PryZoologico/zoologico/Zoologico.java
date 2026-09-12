package zoologico;

import java.util.*;
import java.sql.*;

public class Zoologico {
    private Map<String, Zona> zonas;
    private Connection connection;

    public Zoologico() throws SQLException {
        zonas = new HashMap<>();
        zonas.put("norte", new Zona("Norte"));
        zonas.put("sur", new Zona("Sur"));
        zonas.put("este", new Zona("Este"));
        zonas.put("oeste", new Zona("Oeste"));
        
        // Conectar a la base de datos
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoologico", "root", "");
    }

    public void asignarZona(Animal animal) {
    String zonaAsignada;
        if ("SELVA".equals(animal.getHabitat()) || animal.isPeligroExtincion()) {
            zonaAsignada = "Norte";
            zonas.get("norte").agregarAnimal(animal);
        } else if ("DESIERTO".equals(animal.getHabitat())) {
            zonaAsignada = "Sur";
            zonas.get("sur").agregarAnimal(animal);
        } else if ("SABANAS".equals(animal.getHabitat())) {
            zonaAsignada = "Este";
            zonas.get("este").agregarAnimal(animal);
        } else {
            zonaAsignada = "Oeste";
            zonas.get("oeste").agregarAnimal(animal);
        }
        guardarAnimalEnBD(animal, zonaAsignada);
    }

    private void guardarAnimalEnBD(Animal animal, String zona) {
        String sql = "INSERT INTO animales (nombre, especie, habitat, alimentacion, peligro_extincion, zona)" +  "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, animal.getNombre());
            statement.setString(2, animal.getEspecie());
            statement.setString(3, animal.getHabitat());
            statement.setString(4, animal.getAlimentacion());
            statement.setBoolean(5, animal.isPeligroExtincion());
            statement.setString(6, zona);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mostrarZoologico() {
        for (Zona zona : zonas.values()) {
            zona.mostrarAnimales();
        }
    }

    public void cerrarConexion() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    