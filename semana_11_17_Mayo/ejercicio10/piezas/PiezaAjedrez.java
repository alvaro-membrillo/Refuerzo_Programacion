package semana_11_17_Mayo.ejercicio10.piezas;

import semana_11_17_Mayo.ejercicio10.Color;
import semana_11_17_Mayo.ejercicio10.PiezaTablero;

public abstract class PiezaAjedrez extends PiezaTablero {

    /*Es una pieza móvil (se puede mover por el tablero), es abstracta porque no queremos crear piezas de ajedrez,
    * solo vamos a crear reinas en este programa (la clase Reina es la hija de esta clase)*/

    public PiezaAjedrez(int posicionX, int posicionY, Color color) {
        super(posicionX, posicionY, color);
    }

}
