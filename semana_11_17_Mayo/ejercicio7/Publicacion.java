package semana_11_17_Mayo.ejercicio7;

import java.util.Calendar;
import java.util.Objects;

public abstract class Publicacion extends ObjetoInventario { //Trasladamos a esta clase los atributos de la clase ObjetoInventario

    /*La clase Publicación es padre de las clases Revista y Libro, como no queremos instanciar objetos de la clase
    * Publicación, tenemos que hacerla de tipo abtracta*/

    //Aqui almacenamos los atributos que compartirán las clases hijas.
    private int isbn;
    private String titulo;
    private int anyo;

    //Al ser una clase abstracta, a pesar de que tenga contructor no se pueden crear directamente objetos de tipo Publicacion
    public Publicacion(int isbn, String titulo, int anyo, String fechaCompra) {
        super(fechaCompra);
        this.isbn = isbn;
        this.titulo = titulo;
        this.anyo = anyo;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publicacion that = (Publicacion) o;
        return getIsbn() == that.getIsbn() &&
                getAnyo() == that.getAnyo() &&
                Objects.equals(getTitulo(), that.getTitulo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIsbn(), getTitulo(), getAnyo());
    }

    @Override
    public String toString() {
        return super.toString()+"Publicacion{" +
                "isbn=" + isbn +
                ", titulo='" + titulo + '\'' +
                ", anyo=" + anyo +
                '}';
    }
}
