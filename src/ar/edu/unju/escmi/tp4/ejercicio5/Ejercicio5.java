package ar.edu.unju.escmi.tp4.ejercicio5;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ejercicio5 {
    public static void main (String [] args ) {
        TreeMap<Integer, Producto> productos = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        int op;
        do{
            System.out.println("-----Menú-----");
            System.out.println(" 1 - Alta de producto");
            System.out.println(" 2 - Mostrar productos");
            System.out.println(" 3 . Buscar un producto");
            System.out.println(" 4 - Eliminar un producto");
            System.out.println(" 5 - Salir");
            System.out.println("Ingrese una opción: ");
            if(scanner.hasNextInt()){
                op = scanner.nextInt();
                scanner.nextLine();
            }else{
                System.out.println("Ingrese un número válido");
                scanner.nextLine();
                continue;
            }
            switch(op){
                case 1:
                    System.out.println("Ingrese clave del producto (número entero): ");
                    int cl = scanner.nextInt();
                    scanner.nextLine();
                    if(productos.containsKey(cl))System.out.println("Ya existe un producto con esa clave")
                    else{
                        System.out.println("Ingrese descripción del producto: ");
                        String desc = scanner.nextLine();
                        System.out.println("Ingrese el precio");
                        double precio = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("Ingrese año de vencimiento: ");
                        int a = scanner.nextInt();
                        System.out.println("Ingrese mes de vencimiento: ");
                        int m = scanner.nextInt();
                        System.out.println("Ingrese día de vencimiento: ");
                        int d = scanner.nextInt();
                        scanner.nextLine();
                        LocalDate fechv = LocalDate.of(a, m, d);
                        Producto nuevoProducto = new Producto(desc, precio, fechv);
                        productos.put(cl, nuevoProducto);
                        System.out.println("Producto Guardado");
                    }
                    break;
                case 2:
                    if(productos.isEmpty()) System.out.println("El TreeMap está vacío");
                    else{
                        System.out.println("---------LISTA DE PRODUCTOS--------");
                        Iterator<Map.Entry<Integer, Producto>> iterator = productos.entrySet().iterator();
                        while(iterator.hasNext()){
                            Map.Entry<Integer, Producto> entrada = iterator.next();
                            System.out.println("Clave: " + entrada.getKey() + " -> " + entrada.getValue());
                        }
                    }
                    break;
                case 3:
                    System.out.println("Ingreseclave del producto a buscar: ");
                    int clave1 = scanner.nextInt();
                    scanner.nextLine();
                    if(productos.containsKey(clave1)){
                        Producto p = productos.get(clave1);
                        System.out.println("Producto : " + clave1 + " | " + p);
                    }else System.out.println("No se encontró el producto");
                    break;
                case 4:
                    System.out.println("Ingrese clave del producto a eliminar: ");
                    int clave2 = scanner.nextInt();
                    scanner.nextLine();
                    if(productos.containsKey(clave2)){
                        productos.remove(clave2);
                        System.out.println("Producto " + clave2 + " eliminado");
                    }else System.out.println("No se encontró el producto ");
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }while(op!= 5);
        scanner.close();
    }
}
