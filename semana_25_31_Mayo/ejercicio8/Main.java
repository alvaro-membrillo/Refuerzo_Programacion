package semana_25_31.ejercicio8;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Igual que el ejercicio 7 pero se pueden introducir nuevas palabras con sus correspondientes sinónimos
        //Si una palabra no está se sugiere al usuario insertar su traducción en inglés y se almacena
        Scanner sc = new Scanner(System.in); //Scanner para preguntarle al usuario la palabra a buscar

        //Creamos el diccionario donde se guardan las palabras con sus traducciones
        Map<String, String> diccionario = new HashMap<>(); // K:español, V:ingles

        //Insertamos los valores dentro del diccionario
        diccionario.put("caliente", "hot");
        diccionario.put("rojo", "red");
        diccionario.put("ardiente", "hot");
        diccionario.put("verde", "green");
        diccionario.put("agujetas", "stiff");
        diccionario.put("abrasador", "hot");
        diccionario.put("hierro", "iron");
        diccionario.put("grande", "big");

        String palabra = ""; //Declaramos la palabra que el usuario va a indicar

        /*Mientras la palabra sea diferente a "salir"*/
        while (!palabra.equals("salir")) {
            System.out.print("Inserta una palabra: "); //Pedimos al usuario la palabra y su traduccion
            palabra = sc.nextLine();
            System.out.print("¿Cuál es su traducción?: ");
            String traduccion = sc.nextLine();

            /*Detectamos si la palabra que le hemos pasado está dentro del diccionario y al mismo tiempo si su traduccion
             * existe dentro para poder incluirla*/
            if (!diccionario.containsKey(palabra) && diccionario.containsValue(traduccion)) { //cuando no exista la palabra pero si su traduccion
                System.out.println("La palabra '"+palabra+"' no está dentro del diccionario, sin embargo su traducción coincide con otra");
                System.out.println("¿Quieres insertar esta nueva palabra como sinónimo? (S/N)");
                char res = sc.nextLine().charAt(0); //Guardamos la respuesta a la pregunta como un carácter

                if (res == 'S') { //Insertamos la nueva palabra dentro del diccionario
                    diccionario.put(palabra, traduccion);
                } else if (res == 'N') { //No insertamos la nueva palabra dentro del diccionario
                    break; //Salimos del bucle
                } else {
                    System.out.println("Ésa opción no existe");
                }

            } else if (!diccionario.containsKey(palabra) && !diccionario.containsValue(traduccion)) {
                /*Cuando la palabra no esta ni tampoco su traducción*/
                System.out.println("Esta palabra no existe, tampoco su traduccion");
                System.out.println("¿Quieres insertarla dentro del diccionario? (S/N)");

                char opcion = sc.nextLine().charAt(0);

                if (opcion == 'S') { //Insertamos la palabra
                    diccionario.put(palabra, traduccion);
                } else if (opcion == 'N') { //No insertamos la palabra
                    break;
                } else {
                    System.out.println("Ésa opción no existe");
                }
            }
        }

        //Al final mostramos el diccionario completo
        System.out.println(diccionario);

    }

}
