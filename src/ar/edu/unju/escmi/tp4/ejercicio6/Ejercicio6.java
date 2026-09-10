package ar.edu.unju.escmi.tp4.ejercicio6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        ArrayList<Libro> listaLibros = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n===== MENÚ DE OPCIONES =====");
            System.out.println("1 – Alta de Libro");
            System.out.println("2 – Mostrar libros");
            System.out.println("3 – Buscar y mostrar un libro");
            System.out.println("4 – Ordenar libros");
            System.out.println("5 – Modificar datos de un libro");
            System.out.println("6 – Eliminar un libro");
            System.out.println("7 – Salir");
            System.out.print("Ingrese una opción: ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = 0;
            }

            switch (opcion) {
                case 1:
                    Libro nuevoLibro = new Libro();

                    System.out.print("Ingrese el ISBN: ");
                    nuevoLibro.setIsbn(scanner.nextLine());

                    System.out.print("Ingrese el título: ");
                    nuevoLibro.setTitulo(scanner.nextLine());

                    System.out.print("Ingrese el autor: ");
                    nuevoLibro.setAutor(scanner.nextLine());

                    System.out.print("Ingrese la cantidad de páginas: ");
                    int paginas = Integer.parseInt(scanner.nextLine());
                    nuevoLibro.setCantidadPaginas(paginas);

                    listaLibros.add(nuevoLibro);
                    System.out.println("¡Libro agregado con éxito!");
                    break;

                case 2:
                    if (listaLibros.isEmpty()) {
                        System.out.println("No hay libros registrados en la lista.");
                    } else {
                        System.out.println("\n*** LISTA DE LIBROS ***");
                        for (Libro libro : listaLibros) {
                            libro.mostrarDatos();
                        }
                    }
                    break;

                case 3:
                    if (listaLibros.isEmpty()) {
                        System.out.println("La lista está vacía.");
                        break;
                    }
                    System.out.print("Ingrese el ISBN a buscar: ");
                    String isbnBuscar = scanner.nextLine();
                    
                    Libro libroEncontrado = buscarPorIsbn(listaLibros, isbnBuscar);
                    if (libroEncontrado != null) {
                        libroEncontrado.mostrarDatos();
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;

                case 4:
                    if (listaLibros.isEmpty()) {
                        System.out.println("No hay libros para ordenar.");
                    } else {
                        Collections.sort(listaLibros);
                        System.out.println("Libros ordenados por título exitosamente.");
                    }
                    break;

                case 5:
                    if (listaLibros.isEmpty()) {
                        System.out.println("La lista está vacía.");
                        break;
                    }
                    System.out.print("Ingrese el ISBN del libro a modificar: ");
                    String isbnModificar = scanner.nextLine();

                    Libro libroAModificar = buscarPorIsbn(listaLibros, isbnModificar);
                    if (libroAModificar != null) {
                        System.out.println("Datos actuales del libro:");
                        libroAModificar.mostrarDatos();

                        System.out.println("Ingrese los nuevos datos:");
                        System.out.print("Nuevo título: ");
                        libroAModificar.setTitulo(scanner.nextLine());

                        System.out.print("Nuevo autor: ");
                        libroAModificar.setAutor(scanner.nextLine());

                        System.out.print("Nueva cantidad de páginas: ");
                        libroAModificar.setCantidadPaginas(Integer.parseInt(scanner.nextLine()));

                        System.out.println("¡Datos actualizados correctamente!");
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;

                case 6:
                    if (listaLibros.isEmpty()) {
                        System.out.println("La lista está vacía.");
                        break;
                    }
                    System.out.print("Ingrese el ISBN del libro a eliminar: ");
                    String isbnEliminar = scanner.nextLine();

                    Libro libroAEliminar = buscarPorIsbn(listaLibros, isbnEliminar);
                    if (libroAEliminar != null) {
                        listaLibros.remove(libroAEliminar);
                        System.out.println("¡Libro eliminado exitosamente!");
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;

                case 7:
                    System.out.println("¡Programa finalizado!");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 7);

        scanner.close();
    }

    private static Libro buscarPorIsbn(ArrayList<Libro> libros, String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equalsIgnoreCase(isbn)) {
                return libro;
            }
        }
        return null;
    }
}
