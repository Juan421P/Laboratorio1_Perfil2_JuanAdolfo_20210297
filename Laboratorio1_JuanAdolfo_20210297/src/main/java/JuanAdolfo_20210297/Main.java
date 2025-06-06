package JuanAdolfo_20210297;

import java.util.Scanner;

public class Main {
    private boolean response;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;
        do{
            System.out.println("**********************************");
            System.out.println("****** GESTIÓN DE PRODUCTOS ******");
            System.out.println("**********************************");
            System.out.println();
            System.out.println("1. Consultar productos");
            System.out.println("2. Añadir productos");
            System.out.println("3. Actualizar productos");
            System.out.println("4. Eliminar productos");
            System.out.println("5. Salir");
            System.out.print("¿Qué acción desea realizar? ");
            option = tryParseInt(sc.next());
            while(option != 1 || option != 2 || option != 3 || option !=4){
                System.out.println();
            }
        }while(response);
    }
    public static int tryParseInt(String value){
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e){
            return 0;
        }
    }
}