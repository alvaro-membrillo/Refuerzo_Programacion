package semana_11_17_Mayo.ejercicio10.piezas;

import semana_11_17_Mayo.ejercicio10.Color;
import semana_11_17_Mayo.ejercicio10.Movible;
import semana_11_17_Mayo.ejercicio10.PiezaTablero;

public class PiezaDamas extends PiezaTablero implements Movible {

    /*Es instanciable y movible, las piezas de damas se pueden mover por el tablero*/

    public PiezaDamas(int posicionX, int posicionY, Color color) {
        super(posicionX, posicionY, color);
    }

    @Override
    public boolean esMovible(int x, int y) {
        /*Una pieza de damas se puede mover solo diagonalmente en todas las direcciones*/
        if (y < 9 && y > 0 && x < 9 && x > 0) { //Comprobar los limites del tablero
            /*Condiciones para el desplazamiento diagonal en ambas direcciones*/
            if (this.getPosicionX() - x == this.getPosicionY() - y || x + y == this.getPosicionY() + this.getPosicionX()) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    @Override
    public void mover(int x, int y) {
        if (esMovible(x,y)) { //Cambiamos el valor de la posicion
            posicionX = x;
            posicionY = y;
        } else {
            System.out.println("No se puede mover a esa posicion");
        }
    }

}
