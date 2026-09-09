package ar.edu.unju.escmi.tp4.ejercicio2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
        HashMap<String, Empleado> empleadosMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("\nMENU");
            System.out.println("1. Alta de empleado");
            System.out.println("2. Mostrar empleados");
            System.out.println("3. Eliminar empleado");
            System.out.println("4. Consultar los datos de un empleado");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); 
            } else {
                System.out.println("La opcion no es valida, ingrese un número");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese DNI: ");
                    String dni = scanner.nextLine();
                    
                    System.out.print("Ingrese Nombre: ");
                    String nombre = scanner.nextLine();
                    
                    System.out.print("Ingrese Apellido: ");
                    String apellido = scanner.nextLine();
                    
                    System.out.print("Ingrese Sueldo: ");
                    double sueldo = scanner.nextDouble();
                    
                    System.out.print("Ingrese Categoría (ej: A): ");
                    char categoria = scanner.next().toUpperCase().charAt(0);
                    scanner.nextLine(); 

                    String clave = dni + categoria;

                    Empleado nuevoEmpleado = new Empleado(dni, nombre, apellido, sueldo, categoria);
                    empleadosMap.put(clave, nuevoEmpleado);

                    System.out.println("Empleado registrado correctamente con la clave: " + clave);
                    break;

                case 2:
                    if (empleadosMap.isEmpty()) {
                        System.out.println("No hay empleados registrados");
                    } else {
                        System.out.println("\nLista de empleados:");
                        Iterator<Map.Entry<String, Empleado>> iterator = empleadosMap.entrySet().iterator();
                        
                        while (iterator.hasNext()) {
                            Map.Entry<String, Empleado> entry = iterator.next();
                            System.out.println("Clave: " + entry.getKey() + " -> Valor: " + entry.getValue());
                        }
                    }
                    break;

                case 3:

                    System.out.print("Ingrese la clave del empleado a eliminar (ej: 20310458A): ");
                    String claveEliminar = scanner.nextLine();

                    if (empleadosMap.containsKey(claveEliminar)) {
                        empleadosMap.remove(claveEliminar);
                        System.out.println("El empleado se elimino correctament");
                    } else {
                        System.out.println("La clave ingresada no existe");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese la clave del empleado a consultar (ej: 20310458A): ");
                    String claveBuscar = scanner.nextLine();

                    if (empleadosMap.containsKey(claveBuscar)) {
                        Empleado emp = empleadosMap.get(claveBuscar);
                        System.out.println("Datos del empleado:");
                        System.out.println(emp);
                    } else {
                        System.out.println("La clave ingresada no existe");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del programa");
                    break;

                default:
                    System.out.println("No es valido, intente de nuevo");
                    break;
            }
        }

        scanner.close();
    }
}