package semana_11_17_Mayo.ejercicio7;

public class Libro extends Publicacion implements Prestable {
    //Extiende de la clase Publicacion para compartir sus atributos, también implementamos la interfaz Prestable para añadir sus atributos

    //Éste atributo es propio y exclusivo de esta clase
    private boolean prestado;

    public Libro(int isbn, String titulo, int anyo, String fechaCompra) {
        super(isbn, titulo, anyo, fechaCompra);
        this.prestado = false;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    /*Implementamos los metodos declarados en la interaz Prestable*/
    @Override
    public boolean presta() {
        prestado = true; //Cambiamos el valor de prestado a true
        return prestado; //Y lo devolvemos, porque el metodo es para prestar el libro
    }

    @Override
    public boolean devuelve() {
        prestado = false; //Al devolver el libro ya no estaria prestado
        return prestado;
    }

    @Override
    public boolean estaPrestado() {
        return prestado; //Devuelve el estado del libro (si está prestado o no)
    }

    @Override
    /*Tenemos que recurrir a la clase toString de publicación y añadirle la informacion exclusiva del libro (valor del atributo "prestado")*/
    public String toString() {
        return super.toString()+"Libro{" +
                "prestado=" + prestado +
                '}';
    }

}
