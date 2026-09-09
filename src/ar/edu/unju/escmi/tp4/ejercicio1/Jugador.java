package ar.edu.unju.escmi.tp4.ejercicio1;

public class Jugador {
    private int dni;
    private String nombre;
    private String equipo;
    private String nacionalidad;
    private float estatura;

    public Jugador(int dni, String nombre, String equipo, String nacionalidad, float estatura)
    {
        this.dni=dni;
        this.nombre=nombre;
        this.equipo=equipo;
        this.nacionalidad=nacionalidad;
        this.estatura=estatura;
    }

    public void mostrarInfo()
    {
        System.out.println();
        System.out.println("NOMBRE: " + nombre);
        System.out.println("DNI: " + dni);
        System.out.println("EQUIPO: " + equipo);
        System.out.println("NACIONALIDAD: " + nacionalidad);
        System.out.println("ESTATURA: " +  estatura);
        System.out.println();
    }
    
    public int getDni()
    {
        return dni;
    }

    public void modificarDatos(String nombre, String equipo, String nacionalidad, float estatura)
    {
        this.nombre=nombre;
        this.equipo=equipo;
        this.nacionalidad=nacionalidad;
        this.estatura=estatura;
    }
}
