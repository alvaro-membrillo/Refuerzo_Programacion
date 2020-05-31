package semana_25_31.ejercicio6;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Creamos una lista con las cartas de la baraja
        HashMap<Carta, Integer> baraja = new HashMap(); //Contiene la Carta y los puntos asociados a la carta
        ArrayList<Carta> listaCartas = new ArrayList<>(); //Lista con las cartas aleatorias

        int contadorPuntos = 0; //Contador total de los puntos de las cartas aleatorias

        //creamos las cartas
        Carta c1 = new Carta("as", " de oro");
        Carta c2 = new Carta("dos", " de copas");
        Carta c3 = new Carta("tres", " de bastos");

        //Metemos las cartas en la baraja junto a sus puntos
        baraja.put(c1, 11);
        baraja.put(c2, 0);
        baraja.put(c3, 10);

        //Almacenamos las cartas del mapa dentro de la lista de cartas
        for (Carta c : listaCartas) {
            listaCartas.add(c);
        }


        mostrar(listaCartas); //Mostramos las cartas antes de mezclarlas

        Collections.shuffle(listaCartas); //Mezclamos la baraja
        System.out.println();

        mostrar(listaCartas); //Mostramos las cartas una vez se han mezclado

    }

    public static void mostrar(List<Carta> listaCartas) {
        for (Carta c : listaCartas) {
            System.out.print(c + " ");
        }
    }

}
