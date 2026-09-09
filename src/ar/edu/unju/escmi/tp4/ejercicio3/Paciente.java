package ar.edu.unju.escmi.tp4.ejercicio3;

public class Paciente implements Comparable<Paciente> {
    private String dni;
    private String nombre;
    private String apellido;
    private int numeroHistoriaClinica;
    private String obraSocial;

    public Paciente() {
    }

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNumeroHistoriaClinica() {
        return numeroHistoriaClinica;
    }

    public void setNumeroHistoriaClinica(int numeroHistoriaClinica) {
        this.numeroHistoriaClinica = numeroHistoriaClinica;
    }

    public String getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }

    @Override
    public int compareTo(Paciente otro) {
        return Integer.compare(this.numeroHistoriaClinica, otro.numeroHistoriaClinica);
    }

    @Override
    public String toString() {
        return "Paciente [DNI=" + dni + ", Nombre=" + nombre + ", Apellido=" + apellido
                + ", Historia Clínica=" + numeroHistoriaClinica + ", Obra Social=" + obraSocial + "]";
    }
}
