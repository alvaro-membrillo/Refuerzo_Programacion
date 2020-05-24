package semana_18_24_Mayo.ejercicio4;

import semana_18_24_Mayo.ejercicio4.ejercicioAviones.Avion;
import semana_18_24_Mayo.ejercicio4.ejercicioAviones.ModoVuelo;
import semana_18_24_Mayo.ejercicio4.ejercicioAviones.Pasajero;

import java.io.*;
import java.util.Arrays;

public class Main {

    /*Declaramos las variables para controlar aviones y pasajeros de forma estática, para que sean visibles en la clase
    * y conserven su valor cada vez que se modifiquen*/
    static Avion[] listaAviones = new Avion[1];
    static int numAviones = 0;
    static int numPasajeros = 0;
    static Pasajero[] listaPasajero = new Pasajero[1];

    static File ficheroAviones = new File("ficheroAviones.dat"); //Creamos el fichero de aviones

    static boolean existeFicheroAviones = false;
    static boolean existeFicheroPasajeros = false;

    public static void main(String[] args) {
        /*Usando arrays, craer un programa para dar de alta y de baja aviones y pasajeros.
         * Al inicio del programa se tienen que cargar desde el disco los aviones y pasasajeros almacenados en los ficheros
         * binarios "aviones.dat" y "pasajeros.dat" y se mostrará el menú. Al salir del programa se volverán a guardar de nuevo
         * en el disco.*/

        //Leemos el fichero de aviones para ver si tiene aviones dentro
        readFicheroAviones(ficheroAviones);

        for (Avion a : listaAviones) { //Mostramos el contenido del fichero
            System.out.println(a);
        }

        //File ficheroPasajeros = new File("ficheroPasajeros.dat"); //Creamos el fichero de pasajeros

        //Avion[] listaAviones = new Avion[1]; //Creamos la lista de aviones
        Avion a1 = new Avion("Airbus", 15, "ejemplo", ModoVuelo.PILOTO_AUTOMÁTICO); //Creamos un avion

        //1- Alta Avion
        addAvion(listaAviones, a1); //Damos de alta un avion
        addFicheroAviones(listaAviones, ficheroAviones); //Guardamos esa lista dentro del fichero de aviones

        //2- Baja Avion
        //3- Alta pasajero
        //4- Baja pasajero
        //5- Mostrar aviones por pantalla
        for (int i = 0; i < listaAviones.length; i++) {
            System.out.println(listaAviones[i]);
        }

        //6- Mostrar pasajeros por pantalla

    }

    //Con este método vamos a comprobar si existe el fichero o no, y si está nulo o tiene contenido.
    public void sensorFichero(File fichero) {
        if (fichero.exists()) { //Si existe el fichero
            existeFicheroAviones = true;
        } else {
            existeFicheroAviones = false;
        }
    }

    //Metodo para añadir un avion al que le pasamos la lista y el avion que queremos añadir
    public static boolean addAvion(Avion[] listaAviones, Avion avion) {
        //Comprobamos si la lista esta vacia
        if (listaAviones == null) {
            /*Si no hay aviones, inicializamos la lista con un espacio*/
            listaAviones[numAviones] = avion;//Insertamos el avion en la lista

            numAviones++; //Como hemos añadido un avion sumamos al contador
            return true;
        } else { //Cuando la lista no está vacía
            /*En este caso el numero de aviones es superior a la capacidad de la lista, por lo que tenemos que redimensionarla*/
            if (numAviones > listaAviones.length) {
                //Creamos una lista auxiliar con la capacidad de almacenar un avión más
                Avion[] aux = Arrays.copyOf(listaAviones, ++numAviones);
                //Almacenamos los aviones que ya teniamos en la lista más un espacio para almacenar un avión más
                listaAviones = aux;

            } else { //Cuando ya tenemos varios aviones en la lista vamos a buscar si el avion que queremos meter ya esta en la lista
                /*Recorremos la lista de aviones en busca de aviones repetidos*/
                for (Avion a : listaAviones) {
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
    }

    //Creamos este metodo para añadir la lista de aviones dentro del fichero de aviones
    static public void addFicheroAviones(Avion[] aviones, File ficheroAviones) {
        try { //Escribimos la lista de aviones dentro del fichero de aviones
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ficheroAviones));
            oos.writeObject(aviones); //Escribimos el array de aviones

            oos.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static public void readFicheroAviones(File ficheroAviones) {
        try {
            /*Leemos el fichero de aviones, dentro de éste leemos los objetos que contenga*/
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ficheroAviones));
            ois.readObject();

            if (ois.readObject() != null) { //Si hay contenido dentro del fichero
                //Almacenamos dentro de nuestra lista de aviones los aviones que tenga dentro
                listaAviones = (Avion[]) ois.readObject();
                //Hay que hacer un casting del objeto para indicar que se trata de un array de aviones
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
