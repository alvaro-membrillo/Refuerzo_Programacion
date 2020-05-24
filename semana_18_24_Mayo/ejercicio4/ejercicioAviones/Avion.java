package semana_18_24_Mayo.ejercicio4.ejercicioAviones;

import java.util.Arrays;
import java.util.Objects;

public class Avion {

    /*Declaración de atributos*/
    //Ejercicio 1
    private String aerolinea;
    private float longitud;
    private String modelo;
    //He indicado los valores de este atributo en una clase enum aparte
    private ModoVuelo modoVuelo;

    //private Avion[] listaAviones; //Creamos una lista de aviones

    //Ejercicio 2
    /*Creamos un contador para llevar la cuenta del numero de aviones creados.
    * Es estático porque así nos aseguramos que el valor no va a iniciarse de nuevo cada vez que llamemos
    * al constructor sino que va a variar segun las operaciones que le indiquemos dentro.*/
    private static int numAviones = 0;


    //Constructor
    public Avion(String aerolinea, float longitud, String modelo, ModoVuelo modoVuelo) {
        this.aerolinea = aerolinea;
        this.longitud = longitud;
        this.modelo = modelo;
        this.modoVuelo = modoVuelo;
        //Sumamos previamente el numero de aviones y los mostramos
        System.out.println("Se han creado "+(++numAviones)+" aviones");
    }

    /*Metodos sobre el comportamiento que tienen los objetos de tipo Avion*/
    public void despegar() {
        System.out.println("Saliendo del aeropuerto");
    }

    public void aterrizar() {
        System.out.println("Tomando tierra");
    }

    public void volar() {
        System.out.println("Volando, altura estimada" + (Math.random() * 150 - 80));
    }


    /*Metodo del ejercicio 4 tercera semana de mayo*/
    /*public boolean addaaaaAvion (Avion avion) {
        //Comprobamos si la lista esta vacia
        if (listaAviones == null) {
            /*Si no hay aviones, inicializamos la lista con un espacio*/
            /*listaAviones = new Avion[1];
        } else {*/
            /*En este caso el numero de aviones es superior a la capacidad de la lista, por lo que tenemos que redimensionarla*/
            /*if (numAviones > listaAviones.length) {
                //Creamos una lista auxiliar con la capacidad de almacenar un avión más
                Avion[] aux = Arrays.copyOf(listaAviones, ++numAviones);
                //Almacenamos los aviones que ya teniamos en la lista más un espacio para almacenar un avión más
                listaAviones = aux;

            } else { //Cuando ya tenemos varios aviones en la lista vamos a buscar si el avion que queremos meter ya esta en la lista
                /*Recorremos la lista de aviones en busca de aviones repetidos*/
                /*for (Avion a : listaAviones) {
                    if (avion.equals(a)) { //Si el avion que hemos pasado por parametro es igual a un avion de la lista
                        return false; //Salimos del programa porque no se pueden añadir aviones repetidos
                    } else { //Cuando no hay aviones repetidos intentamos meter un nuevo avion
                        //Guardamos el avion en la lista que hemos creado
                        listaAviones[numAviones] = avion;
                        numAviones++; //Sumamos un avion más en el contador
                        return true;
                    }
                }

            }

        }

        return false;
    }*/



    /*public Avion[] addAvion (Avion avion) {
        //Comprobamos si la lista esta vacia
        if (listaAviones == null) {
            /*Si no hay aviones, inicializamos la lista con un espacio*/
            /*listaAviones = new Avion[1];
        } else {
            /*En este caso el numero de aviones es superior a la capacidad de la lista, por lo que tenemos que redimensionarla*/
            /*if (numAviones > listaAviones.length) {
                //Creamos una lista auxiliar con la capacidad de almacenar un avión más
                Avion[] aux = Arrays.copyOf(listaAviones, ++numAviones);
                //Almacenamos los aviones que ya teniamos en la lista más un espacio para almacenar un avión más
                listaAviones = aux;

            } else { //Cuando ya tenemos varios aviones en la lista vamos a buscar si el avion que queremos meter ya esta en la lista
                /*Recorremos la lista de aviones en busca de aviones repetidos*/
                /*for (Avion a : listaAviones) {
                    if (avion.equals(a)) { //Si el avion que hemos pasado por parametro es igual a un avion de la lista
                        break;
                    } else { //Cuando no hay aviones repetidos intentamos meter un nuevo avion
                        //Guardamos el avion en la lista que hemos creado
                        listaAviones[numAviones] = avion;
                        numAviones++; //Sumamos un avion más en el contador
                        return listaAviones;
                    }
                }

            }

        }

        return listaAviones;
    }*/



    /*Inserción de los métodos getters (para acceder a los valores de
    atributos privados desde otras clases) y setters (para cambiar los valores de
    los atributos privados desde otras clases)*/
    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public ModoVuelo getModoVuelo() {
        return modoVuelo;
    }

    public void setModoVuelo(ModoVuelo modoVuelo) {
        modoVuelo = modoVuelo;
    }

    /*Ejercicio 2*/

    public static int getNumAviones() {
        return numAviones;
    }

    public static void setNumAviones(int numAviones) {
        Avion.numAviones = numAviones;
    }


    /*Método equals*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avion avion = (Avion) o;
        return Float.compare(avion.getLongitud(), getLongitud()) == 0 &&
                Objects.equals(getAerolinea(), avion.getAerolinea()) &&
                Objects.equals(getModelo(), avion.getModelo()) &&
                getModoVuelo() == avion.getModoVuelo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAerolinea(), getLongitud(), getModelo(), getModoVuelo());
    }

    /*Metodo toString para representar los valores de los objetos generados
            a traves del constructor de la clase Avion*/
    @Override
    public String toString() {
        return "Avion{" +
                "aerolinea='" + aerolinea + '\'' +
                ", longitud=" + longitud +
                ", modelo='" + modelo + '\'' +
                ", ModoVuelo=" + modoVuelo +
                '}';
    }
}
