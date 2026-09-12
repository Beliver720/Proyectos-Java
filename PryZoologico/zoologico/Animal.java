package zoologico;
import java.util.*;;
public class Animal {
    private String nombre;
    private String especie;
    private String habitat;
    private String alimentacion;
    private boolean peligroExtincion;

    public Animal(String nombre, String especie, String habitat, String alimentacion, boolean peligroExtincion) {
        this.nombre = nombre;
        this.especie = especie;
        this.habitat = habitat;
        this.alimentacion = alimentacion;
        this.peligroExtincion = peligroExtincion;
    }
    public static Animal solicitarDatosAnimal() {
        Scanner tec = new Scanner(System.in);

        System.out.print("Ingrese el nombre del animal: ");
        String nombre = tec.nextLine().toUpperCase();

        System.out.print("Ingrese la especie del animal: ");
        String especie = tec.nextLine().toUpperCase();

        System.out.print("Ingrese el hábitat del animal: ");
        String habitat = tec.nextLine().toUpperCase();
        System.out.print("Ingrese la alimentación del animal: ");
        String alimentacion = tec.nextLine().toUpperCase();

        System.out.print("¿Está en peligro de extinción? (true/false): ");
        boolean peligroExtincion = tec.nextBoolean();

        return new Animal(nombre, especie, habitat, alimentacion, peligroExtincion);
    }
    public String getNombre() {

        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public String getHabitat() {
        return habitat;
    }

    public String getAlimentacion() {
        return alimentacion;
    }

    public boolean isPeligroExtincion() {
        return peligroExtincion;
    }

    public String toString() {
        return nombre + " es un " + especie + " que vive en " + habitat + ". Se alimenta de " + alimentacion + ".";
    }

}
