package ar.edu.unju.escmi.tp4.ejercicio4;

public class Cliente {
	private String dni;
    private String nombre;
    private String tipoCliente;

    // Constructor
    public Cliente(String dni, String nombre, String tipoCliente) {
        this.dni = dni;
        this.nombre = nombre;
        this.tipoCliente = tipoCliente;
    }

    // Getters y Setters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    @Override
    public String toString() {
        return "Cliente [DNI=" + dni + ", Nombre=" + nombre + ", Tipo=" + tipoCliente + "]";
    }
}