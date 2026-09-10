package ar.edu.unju.escmi.tp4.ejercicio6;

public class Libro implements Comparable<Libro>{
    private String isbn;
    private String titulo;
    private int cantidadPaginas;
    private String autor;

    public Libro() {
    }

    public Libro(String isbn, String titulo, int cantidadPaginas, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void mostrarDatos() {
        System.out.println("----------------------------------------");
        System.out.println("ISBN: " + isbn);
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Cantidad de Páginas: " + cantidadPaginas);
        System.out.println("----------------------------------------");
    }

    public int compareTo(Libro otroLibro) {
        return this.titulo.compareToIgnoreCase(otroLibro.getTitulo());
    }
}
