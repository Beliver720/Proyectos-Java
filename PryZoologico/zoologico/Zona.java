package zoologico;

import java.util.ArrayList;
import java.util.List;

public class Zona {
    private String nombre;
    private List<Animal> animales;

    public Zona(String nombre) {
        this.nombre = nombre;
        this.animales = new ArrayList<>();
    }

    public void agregarAnimal(Animal animal) {
        animales.add(animal);
    }

    public void mostrarAnimales() {
        System.out.println("Zona " + nombre + " contiene los siguientes animales:");
        for (Animal animal : animales) {
            System.out.println("- " + animal);
        }
    }
}


