package semana_11_17_Mayo.ejercicio10;

public interface Movible {
    //Esta interfaz solo se va a implementar en las clases de piezas que sean movibles

    /*Indica si es posible mover la pieza a las coordenadas que se le indican*/
    boolean esMovible(int x, int y);

    /*Mueve si es posible la pieza a las coordenadas que se le indican, si no es posible no aplicará ningún cambio a la pieza*/
    void mover(int x, int y);
}
