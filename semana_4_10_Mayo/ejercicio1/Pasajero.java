package semana_4_10_Mayo.ejercicio1;

public class Pasajero {
    //Definicion de atributos
    private String nombre;
    private String direccion;
    private int numPasaporte;
    /*En este caso vamos a definir los valores que puede tomar la variable enum
    * estado dentro de esta misma clase*/
    private Estado estado;

    //Constructor
    public Pasajero(String nombre, String direccion, int numPasaporte) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.numPasaporte = numPasaporte;
    }

    /*Metodos sobre el comportamiento de los pasajeros*/
    public void embarcar (Avion avion) {
        System.out.println("Embarcando al avion --> "+avion);
    }

    public void sonreir () {
        System.out.println(" :D ");
    }

    public void andar () {
        System.out.println("Andando");
    }


    /*Métodos getters y setters*/
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumPasaporte() {
        return numPasaporte;
    }

    public void setNumPasaporte(int numPasaporte) {
        this.numPasaporte = numPasaporte;
    }

    /*Método toString para representar el objeto*/
    @Override
    public String toString() {
        return "Pasajero{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", numPasaporte=" + numPasaporte +
                '}';
    }
}
