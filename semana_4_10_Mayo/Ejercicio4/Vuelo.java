package semana_4_10_Mayo.ejercicio4;

import java.util.Arrays;
import java.util.Objects;

public class Vuelo {

    /*Atributos*/
    private Avion avion; //Instanciamos un objeto de la clase Avion
    private String fecha; //Aqui también se puede usar el tipo de dato Calendar
    private String aeropuertoOrigen;
    private String aeropuertoDestino;
    private int numPasajeros = 0; //Aqui se almacena la cantidad de pasajeros que vamos a crear
    private Pasajero[] pasajeros; //Creamos la lista de pasajeros


    /*Constructor*/
    /*A partir del constructor instanciamos los objetos de ésta clase (Vuelo)*/
    public Vuelo(Avion avion, String fecha, String aeropuertoOrigen, String aeropuertoDestino) { //Lista de parámetros que le pasamos
        //this se utiliza para hacer referencia a los parametros de la clase, que se igualan a los valores pasados por parámetro
        this.avion = avion;
        this.fecha = fecha;
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.aeropuertoDestino = aeropuertoDestino;
    }

    /*Métodos customizados (los metodos que no generamos automáticamente)*/
    //es un método tipo void porque no queremos que devuelva ningún valor, solo informamos de su funcionamiento con mensajes
    public void addPassenger(Pasajero pasajero) { //Para añadir un pasajero al vuelo

        /*Este atributo boolean sirve para controlar si los pasajeros pasados por parámetros son iguales o no a algún
         * elemento de la lista*/
        boolean noIgual = true; //Se inicializa como true porque damos por hecho que no es igual

        /*Como hemos sumado un pasajero entra dentro de la condicion y añade ese pasajero en la primera posición*/
        if (numPasajeros == 0) { //No hay pasajeros en un primer momento
            this.pasajeros = new Pasajero[1]; //Inicializamos la lista de pasajeros con un espacio
            this.pasajeros[0] = pasajero; //En la primera posicion metemos el primer pasajero
            numPasajeros++; //Sumamos el numero de pasajeros, en este caso hay 1 solo
            System.out.println("Se ha introducido el pasajero"); //Mostramos el mensaje
        } else { //Este codigo se ejecuta cuando hemos inicializado la lista de pasajeros
            /*Recorremos el array en busca de pasajeros que podamos comparar con el que hemos indicado en el parámetro*/
            for (int i = 0; i < this.pasajeros.length; i++) {
                //Si un pasajero de la lista es igual al pasado por parámetro:
                if (this.pasajeros[i].equals(pasajero)) {
                    System.out.println("Es igual a otro pasajero de la lista"); //Mostramos el mensaje
                    noIgual = false; //Como es igual (está repetido) el atributo booleano es falso
                    //Salimos del bucle porque no nos interesa seguir buscando en la lista, con que se repita una vez no nos vale
                    break;
                }
            }

            /*Fuera del bucle que recorre la lista vamos a trabajar con los pasajeros que no estan repetidos en la lista,
             * lo ponemos fuera porque necesitamos recorrer toda la lista para comprobar si esta repetido o no*/

            //Esta condicion equivale a "noIgual == true", solo entrará si no se ha encontrado un numero igual en la lista
            if (noIgual) {
                /*Como vamos a insertar el numero dentro de la lista tenemos que añadir un espacio más para un nuevo elemento.
                Redimensionamos el array de pasajeros mediante un vector auxiliar*/
                //A través de la función Arrays.copyOf copiamos los valores de la lista pasajeros y le añadimos un espacio más
                Pasajero[] aux = Arrays.copyOf(pasajeros, ++numPasajeros);
                /*Los arrays empiezan en la posicion 0, por eso tenemos que insertar el último pasajero en la posición final - 1,
                 * ésto mismo se puede hacer con aux.length-1, pero he decidido seguir usando la variable numPasajeros*/
                aux[numPasajeros - 1] = pasajero;

                /*Cuando ya hemos redimensionado con el vector auxiliar podemos igualar el vector pasajeros al nuevo
                 * vector auxiliar que conserva los pasajeros anteriores más el nuevo*/
                pasajeros = aux;
                System.out.println("Se ha introducido el pasajero"); //Mostramos el mensaje
            }
        }

    }

    /*Método para borrar pasajeros de la lista mediante el numero de pasaporte del mismo*/
    public boolean delPassenger(int numPasaporte) {
        boolean encontrado = false; //Variable para controlar si se encuentra o no al pasajero que buscamos

        for (int i = 0; i < pasajeros.length; i++) { //Recorremos la lista de pasajeros
            /*Si el numero de pasaporte del pasajero que se esta buscando coincide con el numero de pasaporte de
             * que hemos pasado por parámetro lo tenemos que eliminar*/
            if (this.pasajeros[i].getNumPasaporte() == numPasaporte) {
                encontrado = true; //Hemos encontrado el pasajero, mostramos el pasajero y lo eliminamos
                System.out.println("Hemos encontrado el pasajero con el pasaporte: " + this.pasajeros[i].getNumPasaporte() + '\n' +
                        "En la posicion: " + (i + 1));

                /*Para borrar un elemento de un array tenemos que redimensionar la lista de forma que el elemento posterior
                 * al eliminado ocupa el lugar de éste y los siguientes los de su anterior y así sucesivamente, después
                 * redimensionamos la lista para quitar el espacio sobrante*/
                //En el bucle no podemos llegar al último elemento porque la operacion saldria de los elementos de la lista
                for (int j = i; j < pasajeros.length - 1; j++) { //Empezamos en la posicion del pasajero que hemos encontrado
                    pasajeros[j] = pasajeros[j + 1]; //El elemento pasa a tener el valor del siguiente elemento en la lista
                }

                //Redimensionamos para eliminar el espacio sobrante fuera del bucle, manteniendo los demás pasajeros
                pasajeros = Arrays.copyOf(pasajeros, pasajeros.length - 1);

                System.out.println("Pasajero eliminado"); //Mostramos el mensaje informativo

                /*Como en la lista no pueden existir dos pasajeros con el mismo pasaporte, una vez eliminamos ese
                 pasajero salimos del recorrido del bucle*/
                return true;
            }
        }

        if (!encontrado) { //Si no hemos encontrado el pasajero en toda la lista mostramos mensaje de error
            System.out.println("No existe el pasajero con numero de pasaporte: " + numPasaporte);
        }

        return false;
    }

    public void listPassengers() {
        for (int i = 0; i < pasajeros.length; i++) { //Recorremos la lista de pasajeros
            System.out.println(pasajeros[i].toString()); //Mostramos los atributos de cada elemento de la lista
        }
    }


    /*Métodos getters y setters de todos los atributos*/

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getAeropuertoOrigen() {
        return aeropuertoOrigen;
    }

    public void setAeropuertoOrigen(String aeropuertoOrigen) {
        this.aeropuertoOrigen = aeropuertoOrigen;
    }

    public String getAeropuertoDestino() {
        return aeropuertoDestino;
    }

    public void setAeropuertoDestino(String aeropuertoDestino) {
        this.aeropuertoDestino = aeropuertoDestino;
    }

    public Pasajero[] getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(Pasajero[] pasajeros) {
        this.pasajeros = pasajeros;
    }

    public int getNumPasajeros() {
        return numPasajeros;
    }

    public void setNumPasajeros(int numPasajeros) {
        this.numPasajeros = numPasajeros;
    }

    /*Método Equals*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vuelo vuelo = (Vuelo) o;
        return getNumPasajeros() == vuelo.getNumPasajeros() &&
                Objects.equals(getAvion(), vuelo.getAvion()) &&
                Objects.equals(getFecha(), vuelo.getFecha()) &&
                Objects.equals(getAeropuertoOrigen(), vuelo.getAeropuertoOrigen()) &&
                Objects.equals(getAeropuertoDestino(), vuelo.getAeropuertoDestino()) &&
                Arrays.equals(getPasajeros(), vuelo.getPasajeros());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getAvion(), getFecha(), getAeropuertoOrigen(), getAeropuertoDestino(), getNumPasajeros());
        result = 31 * result + Arrays.hashCode(getPasajeros());
        return result;
    }

    /*Metodo toString para representar los valores del objeto*/

    @Override
    public String toString() {
        return "Vuelo{" +
                "avion=" + avion +
                ", fecha='" + fecha + '\'' +
                ", aeropuertoOrigen='" + aeropuertoOrigen + '\'' +
                ", aeropuertoDestino='" + aeropuertoDestino + '\'' +
                ", numPasajeros=" + numPasajeros +
                ", pasajeros=" + Arrays.toString(pasajeros) +
                '}'+'\n';
    }
}
