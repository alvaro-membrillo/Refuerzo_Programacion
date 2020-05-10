package semana_4_10_Mayo.ejercicio4;

import java.util.Arrays;
import java.util.Objects;

public class Aeropuerto {

    //Declaración de atributos
    private String nombre;
    private Vuelo[] vuelos;

    private int numVuelos = 0; //Con esta variable vamos a controlar la cantidad de vuelos que se producen por aeropuerto

    //Constructor
    public Aeropuerto(String nombre) {
        this.nombre = nombre;
        this.numVuelos = 0; //En el momento de instanciar un objeto de la clase Aeropuerto no tiene todavía vuelos
    }

    /*Métodos para definir el comportamiento*/
    /*Añadir vuelos al aeropuerto (hay que comprobar que el vuelo sale del
    mismo aeropuerto al que los estamos añadiendo)*/
    public void addVuelos(Vuelo v) {
        //Si el nombre del aeropuerto es igual al aeropuerto de origen del vuelo lo podemos añadir
        if (this.nombre.equals(v.getAeropuertoOrigen())) {
            boolean repetido = false;
            /*Primero inicializamos el array de vuelos*/
            if (numVuelos == 0) {
                vuelos = new Vuelo[1]; //Asignamos un tamaño al array de vuelos
                vuelos[0] = v; //Igualamos la primera posicion del array al primer valor
                numVuelos++; //Sumamos un vuelo al numero de vuelos
            } else { //Cuando se ha inicializado la lista de vuelos se accede a esta parte del codigo (la segunda vez que llamemos a este metodo)

                for (int i = 0; i < vuelos.length; i++) { //Recorremos la lista de vuelos
                    if (vuelos[i].equals(v)) { //Si coincide con el que queremos añadir
                        System.out.println("Ese vuelo ya existe");
                        repetido = true; //Estará repetido
                    }
                }

                if (!repetido) { //En caso de que no esté repetido lo añadimos
                    /*Creamos un array auxiliar con un espacio más para vuelos y los vuelos que teniamos en el array vuelos*/
                    Vuelo[] aux = Arrays.copyOf(vuelos, ++numVuelos);

                    //Como hay un espacio más se puede añadir el nuevo vuelo en la ultima posicion (correspondiente al numero de vuelos)
                    aux[numVuelos - 1] = v;
                    vuelos = aux; //Igualamos el array vuelos al auxiliar para redimensionarlo
                }
            }

        } else { //Mostramos mensaje de error si el origen no corresponde con el aeropuerto
            System.out.println("No se puede añadir porque no parten del mismo aeropuerto");
        }
    }

    /*Eliminar vuelos de un aeropuerto, hay que comprobar que el vuelo existe*/
    public boolean delVuelos(Vuelo v) {
        //Primero vamos a comprobar si el array contiene elementos o no
        if (this.vuelos == null) {
            System.out.println("No hay vuelos");
            return false; //devolvemos false (salimos del metodo porque no hay vuelos para borrar)
        } else { //Si existen vuelos dentro del array
            for (int i = 0; i < vuelos.length; i++) { //Recorremos el bucle en busca del vuelo que hemos pasado por parámetro
                if (vuelos[i].equals(v)) { //Si encontramos el elemento lo eliminamos

                    if (i == vuelos.length - 1) { //Si es el último elemento de la lista
                        //Redimensionamos el array de vuelos para quitarle el ultimo elemento
                        Vuelo[] aux = Arrays.copyOf(vuelos, vuelos.length - 1);
                        vuelos = aux;
                    } else { //En otro caso tenemos que desplazar los valores siguientes machacando el vuelo que vamos a borrar
                        for (int j = i; j < vuelos.length; j++) {
                            vuelos[j] = vuelos[j + 1]; //Cada elemento sera igual al siguiente
                        }
                        //Redimensionamos el array de vuelos para ajustar el tamaño al numero de elementos finales
                        Vuelo[] aux = Arrays.copyOf(vuelos, vuelos.length - 1);
                        vuelos = aux;
                    }

                }
            }

        }

        return true;
    }

    /*Mostrar los vuelos de una determinada fecha que se pasa como parámetro, si no hay vuelos para ese dia se muestra
     * un mensaje*/
    public void mostrarVuelos(String fecha) {
        int diferente = 0; //Guardamos la candidad de vuelos con fecha diferente a la pasada por parámetro
        Vuelo[] aux = new Vuelo[vuelos.length]; //Creamos un array auxiliar donde guardaremos solo los vuelos que coincidan con la fecha

        if (this.vuelos == null) { //Si no hay vuelos no podemos mostrar nada
            System.out.println("La lista está vacia");
        } else {
            for (int i = 0; i < vuelos.length; i++) { //Recorremos la lista de vuelos
                if (this.vuelos[i].getFecha().equals(fecha)) { //Si el vuelo coincide con la fecha que estamos buscando

                    aux[i] = vuelos[i]; //Insertamos los elementos con la fecha que buscamos dentro del array auxiliar

                } else { //Si no coincide el vuelo con la fecha habra un elemento diferente mas
                    diferente++;
                    System.out.println("No hay vuelos para ese día");
                }
            }
            /*Redimensionamos el array original pasandole los vuelos con la fecha que buscamos pero con otro tamaño,
            * estamos teniendo en cuenta la cantidad de elementos diferentes para redimensionarlo correctamente*/
            vuelos = Arrays.copyOf(aux, aux.length - diferente); //Al nuevo tamaño hay que quitarle todos los elementos que no coinciden

            System.out.println(Arrays.toString(vuelos)); //Mostramos la lista de vuelos
        }

    }

    /*Getters y setters*/
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Vuelo[] getVuelos() {
        return vuelos;
    }

    public void setVuelos(Vuelo[] vuelos) {
        this.vuelos = vuelos;
    }

    public int getNumVuelos() {
        return numVuelos;
    }

    public void setNumVuelos(int numVuelos) {
        this.numVuelos = numVuelos;
    }

    //Equal

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aeropuerto that = (Aeropuerto) o;
        return getNumVuelos() == that.getNumVuelos() &&
                Objects.equals(getNombre(), that.getNombre()) &&
                Arrays.equals(getVuelos(), that.getVuelos());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getNombre(), getNumVuelos());
        result = 31 * result + Arrays.hashCode(getVuelos());
        return result;
    }

    //toString

    @Override
    public String toString() {
        return "Aeropuerto{" +
                "nombre='" + nombre + '\'' +
                ", vuelos=" + Arrays.toString(vuelos) +
                ", numVuelos=" + numVuelos +
                '}';
    }
}
