package semana_11_17_Mayo.ejercicio9;

import java.util.Comparator;

public class ComparadorMandoPorPrecio implements Comparator<MandoADistancia> {

    /*Comparador por el precio*/
    @Override
    public int compare(MandoADistancia m1, MandoADistancia m2) {
        if (m1.getPrecio() < m2.getPrecio()) {
            return -1;
        } else if (m1.getPrecio() > m2.getPrecio()) {
            return 1;
        }

        return 0;
    }
}
