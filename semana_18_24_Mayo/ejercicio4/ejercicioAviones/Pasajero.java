package semana_18_24_Mayo.ejercicio4.ejercicioAviones;

import java.util.Objects;

public class Pasajero {
    //Definicion de atributos
    //Ejercicio 1
    private String nombre;
    private String direccion;
    private int numPasaporte;
    /*En este caso vamos a definir los valores que puede tomar la variable enum
     * estado dentro de esta misma clase*/
    private Estado estado;

    //Ejercicio 2
    private static int numPasajeros;

    //Constructor
    public Pasajero(String nombre, String direccion, int numPasaporte) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.numPasaporte = numPasaporte;
        System.out.println("Se han creado "+(++numPasajeros)+" pasajeros");
    }

    /*Metodos sobre el comportamiento de los pasajeros*/
    public void embarcar(Avion avion) {
        System.out.println("Embarcando al avion --> " + avion);
    }

    public void sonreir() {
        System.out.println(" :D ");
    }

    public void andar() {
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /*Ejercicio 2*/

    public static int getNumPasajeros() {
        return numPasajeros;
    }

    public static void setNumPasajeros(int numPasajeros) {
        Pasajero.numPasajeros = numPasajeros;
    }

    /*----------*/

    /*Metodo equals*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pasajero pasajero = (Pasajero) o;
        return getNumPasaporte() == pasajero.getNumPasaporte() &&
                Objects.equals(getNombre(), pasajero.getNombre()) &&
                Objects.equals(getDireccion(), pasajero.getDireccion()) &&
                getEstado() == pasajero.getEstado();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getDireccion(), getNumPasaporte(), getEstado());
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
