package semana_18_24_Mayo.ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static int totalLineas;
    static int numCoincidencias;

    public static void main(String[] args) throws IOException {
        /*Programa que recibe un nombre de un fichero de texto y una cadena.
         * Tenemos que mostrar si el fichero existe, si la cadena existe y cuantas veces aparece dicha cadena*/
        Scanner sc = new Scanner(System.in);

        //Al poner File con el nombre creamos el fichero, vamos leer directamente como si existiese ese fichero

        /*Indicamos el nombre del archivo y la cadena que queremos buscar*/
        System.out.print("Inserta el nombre del fichero: ");
        String nombreFichero = sc.nextLine();

        File fichero = new File(nombreFichero); //Creamos el objeto de tipo fichero con el nombre que le hemos indicado anteriormente

        System.out.print("Inserta la cadena que quieres buscar: ");
        String cadena = sc.nextLine();


        //Llamamos al metodo buscarPalabra, al que le pasamos dos parámetros
        buscarPalabra(fichero, cadena);

    }

    //Le pasamos el fichero y la palabra que buscamos dentro del mismo
    public static void buscarPalabra(File archivo, String palabra) {
        try {
            if (archivo.exists()) { //Si existe el archivo
                BufferedReader br = new BufferedReader(new FileReader(archivo));

                String linea;

                while ((linea = br.readLine()) != null) {
                    totalLineas++;
                    String[] palabras = linea.split(" ");

                    for (int i = 0; i < palabras.length; i++) {
                        if (palabras[i].equals(palabra)) {
                            numCoincidencias++;
                        }
                    }
                }

                if (numCoincidencias == 0) {
                    System.out.println("No existe esa palabra dentro del fichero");
                } else {
                    System.out.println("Se ha encontrado la palabra " + palabra + " " + numCoincidencias + " veces en el fichero");
                }

            } else { //Cuando no exista el fichero mostramos el mensaje
                System.out.println("No existe ese fichero");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
