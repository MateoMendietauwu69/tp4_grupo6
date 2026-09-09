package ar.edu.unju.escmi.tp4.ejercicio3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Paciente> pacientes = new TreeSet<>();
        int opcion;

        do {
            System.out.println("\n===== MENU DE OPCIONES =====");
            System.out.println("1 Alta de paciente.");
            System.out.println("2 Mostrar todos los pacientes.");
            System.out.println("3 Mostrar el paciente que se encuentra en la mitad de la lista.");
            System.out.println("4 Mostrar el primer paciente de la lista.");
            System.out.println("5 Mostrar el último paciente de la lista.");
            System.out.println("6 Filtrar por historia clínica.");
            System.out.println("7 Salir.");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    Paciente paciente = new Paciente();
                    System.out.print("Ingrese DNI: ");
                    paciente.setDni(scanner.nextLine());
                    System.out.print("Ingrese Nombre: ");
                    paciente.setNombre(scanner.nextLine());
                    System.out.print("Ingrese Apellido: ");
                    paciente.setApellido(scanner.nextLine());
                    System.out.print("Ingrese Número de Historia Clínica: ");
                    paciente.setNumeroHistoriaClinica(scanner.nextInt());
                    scanner.nextLine();
                    System.out.print("Ingrese Obra Social: ");
                    paciente.setObraSocial(scanner.nextLine());
                    pacientes.add(paciente);
                    System.out.println("Paciente agregado exitosamente.");
                    break;

                case 2:
                    if (pacientes.isEmpty()) {
                        System.out.println("No hay pacientes registrados.");
                    } else {
                        System.out.println("\n--- Lista de Pacientes ---");
                        pacientes.stream().forEach(p -> System.out.println(p));
                    }
                    break;

                case 3:
                    if (pacientes.isEmpty()) {
                        System.out.println("No hay pacientes registrados.");
                    } else {
                        int mitad = pacientes.size() / 2;
                        List<Paciente> lista = new ArrayList<>(pacientes);
                        System.out.println("\n--- Paciente en la mitad de la lista (posición " + mitad + ") ---");
                        System.out.println(lista.get(mitad));
                    }
                    break;

                case 4:
                    if (pacientes.isEmpty()) {
                        System.out.println("No hay pacientes registrados.");
                    } else {
                        System.out.println("\n--- Primer Paciente ---");
                        System.out.println(pacientes.first());
                    }
                    break;

                case 5:
                    if (pacientes.isEmpty()) {
                        System.out.println("No hay pacientes registrados.");
                    } else {
                        System.out.println("\n--- Último Paciente ---");
                        System.out.println(pacientes.last());
                    }
                    break;

                case 6:
                    if (pacientes.isEmpty()) {
                        System.out.println("No hay pacientes registrados.");
                    } else {
                        System.out.print("Ingrese número de historia clínica para filtrar: ");
                        int numFiltro = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("\n--- Pacientes con historia clínica superior a " + numFiltro + " ---");
                        pacientes.stream()
                                .filter(p -> p.getNumeroHistoriaClinica() > numFiltro)
                                .forEach(p -> System.out.println(p));
                    }
                    break;

                case 7:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 7);

        scanner.close();
    }
}
