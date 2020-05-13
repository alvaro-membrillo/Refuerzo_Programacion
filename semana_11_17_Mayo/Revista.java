package semana_11_17_Mayo.ejercicio6;

public class Revista extends Publicacion {
    /*Extiende de la clase Publicacion para compartir sus atributos, también implementamos la interfaz Prestable para
    * compartir los atributos que hemos indicado en ella*/

    private int numero;

    public Revista(int isbn, String titulo, int anyo, int numero) {
        //Añadimos los atributos de la clase padre --> Publicación
        super(isbn, titulo, anyo);
        this.numero = numero; // + el atributo propio de la clase Revista
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    /*Como las revistas no se prestan, no implementamos la interfaz Prestable*/

    @Override
    /*Para mostrar toda la informacion de la revista hacemos uso del metodo toString de la clase
    padre dentro del metodo toString de la clase Revista*/
    public String toString() {
        return super.toString()+"Revista{" +
                "numero=" + numero +
                '}';
    }
}
