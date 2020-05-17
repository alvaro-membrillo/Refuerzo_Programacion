package semana_11_17_Mayo.ejercicio10.piezas.ajedrez;

import semana_11_17_Mayo.ejercicio10.Color;
import semana_11_17_Mayo.ejercicio10.Movible;
import semana_11_17_Mayo.ejercicio10.piezas.PiezaAjedrez;

public class Reina extends PiezaAjedrez implements Movible {

    public Reina(int posicionX, int posicionY, Color color) {
        super(posicionX, posicionY, color);
    }

    /*Con éste método vamos a comprobar si se puede mover la reina a la posicion que le pasamos por parámetro*/
    @Override
    public boolean esMovible(int x, int y) {

        if (y < 9 && y > 0 && x < 9 && x > 0) {
            if (this.getPosicionY() == y || this.getPosicionX() == x //Condiciones para movimientos vertical y horizontal
                    || this.getPosicionX() - x == this.getPosicionY() - y /*Condiciones para movimientos diagonales*/
                    || x + y == this.getPosicionY() + this.getPosicionX()) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    @Override
    public void mover(int x, int y) {

        if (esMovible(x,y)) { //Si se puede mover a esa posicion que le pasamos podemos moverlo
            /*cambiamos los valores de las posiciones a los que le hemos pasado por parámetros*/
            this.posicionX = x;
            this.posicionY = y;
        } else {
            System.out.println("No se puede mover");
        }

    }
}
