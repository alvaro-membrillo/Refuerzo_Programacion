package semana_11_17_Mayo.ejercicio10;

import semana_11_17_Mayo.ejercicio10.piezas.PiezaBarquito;
import semana_11_17_Mayo.ejercicio10.piezas.PiezaDamas;
import semana_11_17_Mayo.ejercicio10.piezas.ajedrez.Reina;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        //Creamos dos reinas
        Reina reinaBlanca = new Reina(2,5,Color.BLANCO);
        Reina reinaNegra = new Reina(2,3,Color.NEGRO);

        //Creamos una lista de reinas y las metemos
        ArrayList<Reina> reinas = new ArrayList<>();
        reinas.add(reinaBlanca);
        reinas.add(reinaNegra);

        for (Reina r : reinas) { //Mostramos las reinas por el orden de entrada
            System.out.println(r);
        }
        System.out.println();

        //Ordenamos las reinas por el orden por defecto (en base a su posicion Y, como hemos indicado en la interfaz Comparable)
        Collections.sort(reinas);

        for (Reina r : reinas) {
            System.out.println(r);
        }

        /*Creamos el resto de piezas sean movibles o no*/
        PiezaDamas damaBlanca = new PiezaDamas(4,6,Color.BLANCO);
        PiezaDamas damaNegra = new PiezaDamas(7,6,Color.NEGRO);

        PiezaBarquito submarino = new PiezaBarquito(2,6,Color.NEGRO);
        PiezaBarquito fragata = new PiezaBarquito(7,7,Color.BLANCO);
        PiezaBarquito buque = new PiezaBarquito(4,5,Color.NEGRO);

        /*Creamos una lista de piezas en general y las metemos*/
        ArrayList<PiezaTablero> piezasJuegos = new ArrayList<>();

        piezasJuegos.add(reinaBlanca);
        piezasJuegos.add(reinaNegra);
        piezasJuegos.add(damaBlanca);
        piezasJuegos.add(damaNegra);
        piezasJuegos.add(submarino);
        piezasJuegos.add(fragata);
        piezasJuegos.add(buque);

        Collections.sort(piezasJuegos); //Ordenamos la lista de piezas y la mostramos

        for (PiezaTablero p : piezasJuegos) {
            System.out.println(p);
        }
    }
}
