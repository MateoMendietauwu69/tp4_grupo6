package ar.edu.unju.escmi.tp4.ejercicio5;

import java.time.LocalDate;

public class Producto {
        private String desc;
    private double precio;
    private LocalDate fechven;

    public Producto (String desc, double precio, LocalDate fechven){
        this.desc = desc;
        this.precio = precio;
        this.fechven = fechven;
    }

    public String getdesc (){
        return desc;
    }

    public double getprecio (){
        return precio;
    }

    public LocalDate getfech (){
        return fechven;
    }

    public void setdesc (String desc){
        this.desc = desc;
    }

    public void setprecio (double precio){
        this.precio = precio;
    }

    public void setfech (LocalDate fechven){
        this.fechven = fechven;
    }

    public String info(){
        return "Descripción: " + desc + " | Precio: " + precio + " | Fecha de vencimiento: " + fechven;
    }
}
