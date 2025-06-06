package JuanAdolfo_20210297;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    private static LinkedList<Producto> productos = new LinkedList<Producto>();
    private static boolean response;
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
            do{
                System.out.print("¿Qué acción desea realizar? ");
                option = tryParseInt(sc.next());
                sc.nextLine();
                if(option != 1 && option != 2 && option != 3 && option != 4 && option != 5) System.out.println("Por favor, ingrese un valor válido (1-5)");
            }while(option != 1 && option != 2 && option != 3 && option != 4 && option != 5);
            response = option != 5;
            Menu(option);
        }while(response);
    }
    private static void Menu(int option){
        switch(option){
        case 1:
            if(productos.isEmpty()){
                System.out.println("No hay productos!! Asegúrese de agregar alguno de antemano con la opción número 2.");
                System.out.println();
            }else{
                int orden = 1;
                for(Producto producto : productos){
                    System.out.println(orden + ". ID: " + producto.getId() + "; Nombre: " + producto.getNombre() + "; Precio: $" + producto.getPrecio());
                    orden++;
                }
                System.out.println();
            }
            break;
        case 2:
            String name;
            float price;
            Scanner scCase2 = new Scanner(System.in);
            System.out.println("Ingrese la información del producto!!");
            System.out.print("Nombre: ");
            name = scCase2.nextLine();
            do{
                System.out.print("Precio: $");
                price = tryParseFloat(scCase2.next());
                int aux = (int)(price*100);
                price = (float)(aux/100d);
                scCase2.nextLine();
                if(price <= 0) System.out.println("Por favor, ingrese un precio válido");
            }while(price <= 0);
            int id = productos.size()+1;
            Producto newProduct = new Producto(id, name, price);
            productos.add(newProduct);
            System.out.println("La inserción ha sido exitosa!! Puede consultarlo en la opción 1.");
            System.out.println();
            break;
        case 3:
            if(productos.isEmpty()){
                System.out.println("No hay productos!! Asegúrese de agregar alguno de antemano con la opción número 2.");
            }else{
                boolean update = false;
                Scanner scCase3 = new Scanner(System.in);
                System.out.print("Ingrese el ID del producto a actualizar: ");
                int updateId = tryParseInt(scCase3.next());
                scCase3.nextLine();
                for(Producto producto : productos){
                    if(producto.getId() == updateId){
                        int updateOption = 0;
                        do{
                            System.out.println("1. Nombre");
                            System.out.println("2. Precio");
                            System.out.print("¿Qué es lo que desea actualizar del producto? ");
                            updateOption = tryParseInt(scCase3.next());
                            if(updateOption != 2 && updateOption != 1) System.out.println("Ingrese una opción válida porfis.");
                        }while(updateOption != 2 && updateOption != 1);
                        switch(updateOption){
                            case 1:
                                System.out.print("Nuevo nombre: ");
                                String newName = scCase3.nextLine();
                                producto.setNombre(newName);
                                update = true;
                                break;
                            case 2:
                                float newPrice;
                                do{
                                    System.out.print("Nuevo precio: $");
                                    newPrice = tryParseFloat(scCase3.next());
                                    int aux = (int)(newPrice*100);
                                    newPrice = (float)(aux/100d);
                                    scCase3.nextLine();
                                    producto.setPrecio(newPrice);
                                    if(newPrice <= 0) System.out.println("Por favor, ingrese un precio válido");
                                }while(newPrice <= 0);
                                update = true;
                                break;
                        }
                        System.out.println("Actualización exitosa!!");
                        System.out.println();
                    }
                }
                if(update == false){
                    System.out.println("No se pudo actualizar por una u otra razón :(");
                    System.out.println();
                }
            }
            break;
        case 4:
            if(productos.isEmpty()){
                System.out.println("No hay productos!! Asegúrese de agregar alguno de antemano con la opción número 2.");
            }else{
                boolean delete = false;
                Scanner scCase4 = new Scanner(System.in);
                System.out.print("Ingrese el ID del producto a actualizar: ");
                int deleteId = tryParseInt(scCase4.next());
                scCase4.nextLine();
                for(Producto producto : productos){
                    if(producto.getId() == deleteId){
                        productos.remove(producto);
                        System.out.println("Producto eliminado exitosamente!! Ya estuvo.");
                        System.out.println();
                        delete = true;
                    }
                }
                if(delete = false){
                    System.out.println("No se pudo realizar la eliminación por una u otra razón.");
                    System.out.println();
                }
            }
            break;
        case 5:
            System.out.println("Entendido. Baiiiii.");
            break;
    }
    }
    public static int tryParseInt(String value){
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e){
            return 0;
        }
    }
    public static float tryParseFloat(String value){
        try {
            return Float.parseFloat(value);
        } catch (NumberFormatException e){
            return 0;
        }
    }
}