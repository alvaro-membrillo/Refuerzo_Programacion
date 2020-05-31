package semana_25_31.ejercicio7;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //Scanner para preguntarle al usuario la palabra a buscar
        Scanner sc = new Scanner(System.in);

        //En la clave vamos a almacenar las palabras en español, y en el valor su traducción al inglés
        Map<String, String> diccionario = new HashMap<>();

        //Llenamos el diccionario con palabras y sus traducciones
        diccionario.put("caliente", "hot");
        diccionario.put("rojo", "red");
        diccionario.put("ardiente", "hot");
        diccionario.put("verde", "green");
        diccionario.put("agujetas", "stiff");
        diccionario.put("abrasador", "hot");
        diccionario.put("hierro", "iron");
        diccionario.put("grande", "big");

        String palabra; //Palabra de la que queremos buscar sus sinónimos


        do {
            System.out.print("Introduzca una palabra y le daré los sinónimos: ");
            palabra = sc.nextLine(); //Pedimos al usuario una palabra para buscar

            if (diccionario.containsKey(palabra)) { //Si la palabra está dentro de la lista de claves
                getSinonimos(diccionario, palabra); //Llamamos al metodo para obtener sus sinónimos

            } else { //Si la palabra no está dentro de la lista mostramos el mensaje de error
                System.out.println("No conozco sinónimos de esa palabra");
            }

            //Se repite el bucle mientras la palabra sea diferente a "salir"
        } while (!palabra.equals("salir"));

    }

    //Le pasamos la palabra de la que queremos buscar sus sinónimos por parámetro y el diccionario
    public static void getSinonimos(Map<String, String> diccionario, String palabra) {
        //Declaramos la lista donde guardaremos los sinónimos de la palabra que estamos buscando
        ArrayList<String> sinonimos = new ArrayList<>();

        String traduccion = diccionario.get(palabra); //Guardamos la traducción de la palabra que le hemos pasado

        //Guardamos en un conjunto de String todas las claves que hay dentro del diccionario
        Set<String> claves = diccionario.keySet();
        for (String c : claves) { //Recorremos cada clave dentro del diccionario
            //Entra cuando la clave no es igual a la palabra que le hemos pasado por parámetro
            if (!c.equals(palabra)) {
                String sinonimo = diccionario.get(c); //guardamos como sinónimos las traducciones de las palabras que recorremos

                /*Entramos cuando el sinonimo (el valor de la clave que estamos recorriendo) sea igual a la traducción
                 * de la palabra que estamos buscando*/
                if (sinonimo.equals(traduccion)) {
                    sinonimos.add(c); //añadimos aquellas palabras cuya traducción coincide con la que buscamos
                }
            }
        }

        //Al final mostramos el conjunto de sinónimos que hemos encontrado
        System.out.print("Sinónimos de " + palabra + ": ");

        /*Recorremos la lista de sinónimos para mostrarla como aparece en el ejemplo*/
        for (int i = 0; i < sinonimos.size(); i++) {
            if (sinonimos.size() > 1) { //Cuando haya varios sinónimos dentro de la lista
                if (i != sinonimos.size() - 1) { //Mientras no sea el ultimo elemento de la lista ponemos coma despues
                    System.out.print(sinonimos.get(i) + ", ");
                } else { //cuando sea el ultimo elemento de la lista
                    /*Ésta parte del código se pone para no mostrar la última palabra con una coma al final*/
                    System.out.println(sinonimos.get(i));
                }

            } else { //Cuando solo haya un sinónimo se muestra sin más
                System.out.println(sinonimos.get(i));
            }
        }
    }

}
