package semana_11_17_Mayo.ejercicio9;

import semana_11_17_Mayo.ejercicio9.tipos_de_mando.MandoAireAcondicionado;
import semana_11_17_Mayo.ejercicio9.tipos_de_mando.MandoAspiradora;
import semana_11_17_Mayo.ejercicio9.tipos_de_mando.MandoMiniCadena;
import semana_11_17_Mayo.ejercicio9.tipos_de_mando.MandoTV;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<MandoADistancia> mandos = new ArrayList<>();

        /*mostrar la lista ordenada por precios y por superficie (anchura*altura)*/
        mandos.add(new MandoTV("Samsung", 5, 10, 8));
        mandos.add(new MandoAireAcondicionado("Daikin", 4, 8, 5));
        mandos.add(new MandoAspiradora("Xiaomi1", 3, 3, 10));
        mandos.add(new MandoMiniCadena("Panasonic", 5, 10, 50));
        mandos.add(new MandoTV("Xiaomi2", 5, 9, 15));
        mandos.add(new MandoAspiradora("chvweihfa", 5, 10, 20));
        mandos.add(new MandoAspiradora("A",10,15,300));
        mandos.add(new MandoAspiradora("B", 5, 20, 20));
        mandos.add(new MandoAspiradora("Sony", 5, 10, 30));
        mandos.add(new MandoAspiradora("LG", 3, 9, 2));


        /*Mostramos la lista de mandos*/
        for (MandoADistancia m : mandos) {
            System.out.println(m.getSuperficie());
        }
        System.out.println();
        Collections.sort(mandos); //Ordenamos por superficie (interfaz Comparable)

        for (MandoADistancia m : mandos) {
            System.out.println(m.getSuperficie());
        }

        System.out.println();
        /*Ordenamos por precio (interfaz Comparator)*/
        Collections.sort(mandos, new ComparadorMandoPorPrecio());

        for (MandoADistancia m : mandos) {
            System.out.println(m.getPrecio());
        }

    }
}
