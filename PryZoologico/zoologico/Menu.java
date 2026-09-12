package zoologico;
import java.util.*;
import java.sql.*;

public class Menu {
    public static void menu(){
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("                                     MENU                                ");
        System.out.println("Seleccione lo que desea realizar:");
        System.out.println("\n1. Gestion Usuarios"+ "\n2. Gestion Animales"+"\n3. Salir");
    }
    public static void gestion_menu(Connection bd){
        Scanner tec = new Scanner(System.in);
        while (true) {
        menu();
        int opcion;
       
        opcion = tec.nextInt();

        if (opcion ==1){
            System.out.println("\n1. Registrar Usuario"+"\n2. Verificar Acceso al Zoologico"+
        "\n3. Consultar"+"\n4. regresar");
        int opc;
        opc = tec.nextInt();
        if (opc == 1) {
            Registrar.Registro_user(bd);
            tec.nextLine();
        }else if (opc == 2){
            acceso.acess(bd);
            tec.nextLine();
        }else if (opc == 3){
            Consultar.consulta(bd);
            tec.nextLine();
        }else if (opc == 4){
            menu();
        }
    }else if(opcion==2){
        System.out.println("\n1. Registra animal"+"\n2. Eliminar animal"+"\n3. Regresar");
        int opc;
        opc = tec.nextInt();
        if(opc == 1){
            Registrar_animal.Registrar();
            tec.nextLine();
        }else if (opc ==2){
            eliminar.Elimina_animal(bd);
        }else if (opc ==3){
        menu();
         }
        }else if (opcion == 3){
            System.out.println("Hasta luego...");
            break;
        }else{
            tec.nextLine();
            System.out.println("Opción inválida, por favor intente de nuevo.");
        }
    }
    }
}
