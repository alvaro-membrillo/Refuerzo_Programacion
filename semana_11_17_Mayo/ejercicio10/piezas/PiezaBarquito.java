package semana_11_17_Mayo.ejercicio10.piezas;

import semana_11_17_Mayo.ejercicio10.Color;
import semana_11_17_Mayo.ejercicio10.PiezaTablero;

public class PiezaBarquito extends PiezaTablero {
    /*Es instanciable pero no se pueden mover, por eso no vamos a implementar la interfaz Movible*/

    public PiezaBarquito(int posicionX, int posicionY, Color color) {
        super(posicionX, posicionY, color);
    }



}
