package ar.edu.unju.escmi.tp4.ejercicio4;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ejercicio4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        Set<Cliente> clientes = new HashSet<>();
        int opcion = 0;

        do {
            System.out.println("\n--- MENÚ DE OPCIONES ---");
            System.out.println("1 - Crear cliente");
            System.out.println("2 - Mostrar todos los clientes");
            System.out.println("3 - Mostrar los datos de un cliente (por DNI)");
            System.out.println("4 - Mostrar todos los clientes ocasionales y la cantidad");
            System.out.println("5 - Mostrar todos los clientes frecuentes y la cantidad");
            System.out.println("6 - Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = 0;
            }

            switch (opcion) {
                case 1:
                    System.out.println("\n--- ALTA DE CLIENTE ---");
                    System.out.print("Ingrese DNI: ");
                    String dni = scanner.nextLine();

                    System.out.print("Ingrese Nombre: ");
                    String nombre = scanner.nextLine();

                    String tipo = "";
                    int opcionTipo = 0;
                    while (opcionTipo != 1 && opcionTipo != 2) {
                        System.out.println("Seleccione tipo de cliente:");
                        System.out.println("1 - Ocasional");
                        System.out.println("2 - Frecuente");
                        System.out.print("Opción: ");
                        try {
                            opcionTipo = Integer.parseInt(scanner.nextLine());
                            if (opcionTipo == 1) {
                                tipo = "ocasional";
                            } else if (opcionTipo == 2) {
                                tipo = "frecuente";
                            } else {
                                System.out.println("Opción inválida. Ingrese 1 o 2.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Debe ingresar un número entero (1 o 2).");
                        }
                    }

        
                    Cliente cliente = new Cliente(dni, nombre, tipo);
                    clientes.add(cliente);
                    System.out.println("Cliente registrado con éxito.");
                    break;

                case 2:
                    System.out.println("\n--- LISTA DE TODOS LOS CLIENTES ---");
                    if (clientes.isEmpty()) {
                        System.out.println("La lista de clientes está vacía.");
                    } else {
                        clientes.stream().forEach(System.out::println);
                    }
                    break;

                case 3:
                    System.out.println("\n--- BÚSQUEDA DE CLIENTE POR DNI ---");
                    if (clientes.isEmpty()) {
                        System.out.println("La lista de clientes está vacía.");
                    } else {
                        System.out.print("Ingrese el DNI a buscar: ");
                        String dniBuscar = scanner.nextLine();

                        // busqueda
                        boolean encontrado = clientes.stream()
                                .filter(c -> c.getDni().equals(dniBuscar))
                                .peek(System.out::println)
                                .findFirst()
                                .isPresent();

                        if (!encontrado) {
                            System.out.println("No se encontró el dni");
                        }
                    }
                    break;

                case 4:
                    System.out.println("\n--- CLIENTES OCASIONALES ---");
                    // filter()
                    clientes.stream()
                            .filter(c -> c.getTipoCliente().equalsIgnoreCase("ocasional"))
                            .forEach(System.out::println);

                    // filter() y count()
                    long cantidadOcasionales = clientes.stream()
                            .filter(c -> c.getTipoCliente().equalsIgnoreCase("ocasional"))
                            .count();

                    System.out.println("Cantidad total de clientes ocasionales: " + cantidadOcasionales);
                    break;

                case 5:
                    System.out.println("\n--- CLIENTES FRECUENTES ---");
                    // mostrar
                    clientes.stream()
                            .filter(c -> c.getTipoCliente().equalsIgnoreCase("frecuente"))
                            .forEach(System.out::println);

                    // obtener cantidad
                    long cantidadFrecuentes = clientes.stream()
                            .filter(c -> c.getTipoCliente().equalsIgnoreCase("frecuente"))
                            .count();

                    System.out.println("Cantidad total de clientes frecuentes: " + cantidadFrecuentes);
                    break;

                case 6:
                    System.out.println("¡Programa finalizado!");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 6);

        scanner.close();

	}

}
