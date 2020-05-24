package semana_18_24_Mayo.ejercicio2;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DecimalFormat formato = new DecimalFormat("#.00"); //Definimos un formato de dos decimales
        Scanner sc = new Scanner(System.in);

        File fichero = new File("ejercicio2.txt");
        //te devuelve el valor en bytes, cada byte corresponde con el numero de caracteres que hay dentro del fichero
        System.out.println(fichero.length());

        System.out.println("Inserta la medida que vas a utilizar: ");
        /*Las medidas a utilizar pueden ser B (bytes), K (kbytes) o m (MBytes)*/
        char unidad = sc.nextLine().charAt(0); //Para recibir el primer caracter de las unidades.

        if (unidad == 'b' || unidad == 'B') { //Has elegido bytes
            System.out.println("Unidad elegida --> bytes");

        } else if (unidad == 'k' || unidad == 'K') { //Has elegido kbytes
            System.out.println("Unidad elegida --> kbytes");

        } else if (unidad == 'm' || unidad == 'M') { //Has elegido MBytes
            System.out.println("Unidad elegida --> MBytes");

        } else {
            System.out.println("Ésa medida no está disponible");
        }

        System.out.println("Inserta un tamaño para dividir el archivo");
        float tamanoPartes = sc.nextInt(); //El tamaño de cada parte puede ser decimal

        //El numero de partes puede ser decimal
        float numPartes = fichero.length() / tamanoPartes; //Con esta operacion calculamos el numero de partes

        //Usamos el formato de dos decimales
        System.out.println(formato.format(numPartes)); //Te devuelve el numero de partes correspondientes con el tamaño indicado

        try { /*Ahora vamos a leer el fichero*/
            BufferedReader br = new BufferedReader(new FileReader(fichero));
            String linea = ""; //Valor de la linea del fichero
            String textoCompleto = ""; //Valor de todas las lineas del fichero

            //Leemos todas las lineas del fichero y las guardamos en una sola cadena de texto
            while ((linea = br.readLine()) != null) {
                //Se va actualizando el valor del texto hasta que se acabe el fichero
                textoCompleto += linea;
            }

            int contadorPartes = 1; //Contador del numero de partes

            String contenidoParte = ""; //Texto que corresponde a cada parte

            for (int i = 0; i < textoCompleto.length(); i++) { //Recorremos el texto del fichero que hemos almacenado
                //Vamos insertando caracter por caracter en cada parte que creamos
                contenidoParte += textoCompleto.charAt(i);

                /*Cuando el contenido dentro de una parte sea igual al tamaño que debe tener cada parte entra en esta condicion*/
                if (contenidoParte.length() == tamanoPartes) {
                    //Usamos ésta variable para insertar el nombre del fichero correspondiente a cada parte
                    String nombreArchivo = "parte"+contadorPartes+"_.txt";
                    BufferedWriter bw = new BufferedWriter(new FileWriter(new File(nombreArchivo))); //Crea el archivo

                    bw.write(contenidoParte); //Escribo el contenido de la parte dentro del archivo

                    contadorPartes++; //Avanza el contador del numero de partes

                    contenidoParte = ""; //La variable "parte", se vacía para volver a llenarse después en la siguiente parte
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
