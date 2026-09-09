package ar.edu.unju.escmi.tp4.ejercicio1;

import java.util.Scanner;
import java.util.ArrayList;

public class Ejercicio1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Jugador> jugadores = new ArrayList<>();
        int dni, eliminar, modificar;
        String nombre, equipo, nacionalidad; 
        float estatura;
        boolean encontrado=false;
        char opcion='0';

        while(opcion!='7')
        {
            System.out.println("1. Alta de jugador");
            System.out.println("2. Modificar los datos de un jugador");
            System.out.println("3. Eliminar un jugador");
            System.out.println("4. Mostrar todos los jugadores");
            System.out.println("5. Mostrar la cantidad de jugadores en la lista");
            System.out.println("6. Limpiar toda la lista de jugadores");
            System.out.println("7. Salir");
            System.out.print("Ingresa la opcion: ");
            opcion=scanner.next().charAt(0);
            switch (opcion) {
                case '1':
                    System.out.println();
                    System.out.println("//CREAR NUEVO PERSONAJE//");
                    System.out.println();
                    scanner.nextLine();
                    System.out.print("Ingrese el nombre: ");
                    nombre=scanner.nextLine();
                    do{
                        encontrado=false;
                        System.out.print("Ingrese el DNI: ");
                        dni=scanner.nextInt();
                        scanner.nextLine();
                        for(int i=0; i<jugadores.size() && encontrado!=true; i++)
                        {
                            if(dni==jugadores.get(i).getDni())
                            {
                                encontrado=true;
                                System.out.println("Ese DNI ya esta ocupado por otro jugador, ingrese otro");
                            }
                        }
                    }while(encontrado==true);
                    encontrado=false;
                    System.out.print("Ingrese el equipo: ");
                    equipo=scanner.nextLine();
                    System.out.print("Ingrese la nacionalidad: ");
                    nacionalidad=scanner.next();
                    System.out.print("Ingrese la estatura en metros: ");
                    estatura=scanner.nextFloat();
                    Jugador jugador=new Jugador(dni,nombre,equipo,nacionalidad,estatura);
                    jugadores.add(jugador);
                    System.out.println();
                    System.out.println("//SE CREO UN NUEVO JUGADOR CORRECTAMENTE//");
                    System.out.println();
                    System.out.println();
                    break;
                case '2':
                    if(jugadores.size()>0)
                    {
                        System.out.println();
                        System.out.print("Ingrese el DNI del jugador a modificar: ");
                        modificar=scanner.nextInt();
                        for(int j=0; j<jugadores.size() && encontrado!=true; j++)
                        {
                            if(modificar==jugadores.get(j).getDni())
                            {
                                System.out.println("// MODIFICAR JUGADOR " + jugadores.get(j).getDni() + " //");
                                System.out.println();
                                System.out.println("DATOS ACTUALES:");
                                jugadores.get(j).mostrarInfo();
                                System.out.println("INGRESE LOS NUEVOS DATOS:");
                                System.out.println();
                                scanner.nextLine();
                                System.out.print("Ingrese el nuevo nombre: ");
                                nombre=scanner.nextLine();
                                System.out.print("Ingrese el nuevo equipo: ");
                                equipo=scanner.nextLine();
                                System.out.print("Ingrese la nueva nacionalidad: ");
                                nacionalidad=scanner.next();
                                System.out.print("Ingrese la nueva estatura en metros: ");
                                estatura=scanner.nextFloat();
                                System.out.println();
                                jugadores.get(j).modificarDatos(nombre, equipo, nacionalidad, estatura);
                                System.out.println("//SE MODIFICO AL JUGADOR CORRECTAMENTE//");
                                System.out.println();
                                System.out.println();
                                encontrado=true;
                            }
                        }
                        if(encontrado==false)
                        {
                            System.out.println();
                            System.out.println("No se encontro a un jugador con el DNI " + modificar);
                            System.out.println();
                        }
                        encontrado=false;
                    }
                    else
                    {   System.out.println();
                        System.out.println("No hay ningun jugador en la lista");
                        System.out.println();
                    }
                    break;
                case '3':
                    if(jugadores.size()>0)
                    {
                        System.out.print("Ingresa el DNI del jugador a eliminar: ");
                        eliminar=scanner.nextInt();
                        for(int i=0; i<jugadores.size() && encontrado!=true; i++)
                        {
                            if(eliminar==jugadores.get(i).getDni())
                            {
                                System.out.println();
                                System.out.println("Se elimino al jugador DNI " + jugadores.get(i).getDni());
                                System.out.println();
                                jugadores.remove(i);
                                encontrado=true;
                            }
                        }
                        if(encontrado==false)
                        {
                            System.out.println();
                            System.out.println("No se encontro a un jugador con el DNI " + eliminar);
                            System.out.println();
                        }
                        encontrado=false;
                    }
                    else
                    {   System.out.println();
                        System.out.println("No hay ningun jugador en la lista");
                        System.out.println();
                    }
                    break;
                case '4':
                    if(jugadores.size()>0)
                    {   
                        System.out.println();
                        System.out.println("// LISTA DE JUGADORES //");
                        for(int i=0; i<jugadores.size(); i++)
                            jugadores.get(i).mostrarInfo();
                    }
                    else
                    {   System.out.println();
                        System.out.println("No hay ningun jugador en la lista");
                        System.out.println();
                    }
                    break;
                case '5':
                    if(jugadores.size()>0)
                    {   System.out.println();
                        System.out.println("Hay " + jugadores.size() + " jugadores en la lista");
                        System.out.println();
                    } 
                    else
                    {   System.out.println();
                        System.out.println("No hay ningun jugador en la lista");
                        System.out.println();
                    }
                    break;
                case '6':
                    if(jugadores.size()>0)
                    {   
                        jugadores.clear();
                        System.out.println();
                        System.out.println("Se limpio toda la lista de jugadores");
                        System.out.println();
                    } 
                    else
                    {   System.out.println();
                        System.out.println("No hay ningun jugador en la lista");
                        System.out.println();
                    }
                    break;
                case '7':
                    break;
                default:
                    System.out.println();
                    System.out.println(opcion + " no es una opcion");
                    System.out.println();
                    break;
            }
        }
        scanner.close();
    }
}
