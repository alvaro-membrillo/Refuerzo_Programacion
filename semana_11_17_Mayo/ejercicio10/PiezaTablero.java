package semana_11_17_Mayo.ejercicio10;

import java.util.Objects;

public abstract class PiezaTablero implements Comparable<PiezaTablero> { //Interfaz que compara por defecto las posiciones de Y

    /*Los atributos de posicion van a ser publicos para poder acceder a ellos facilmente desde otras clases*/
    public int posicionX, posicionY;
    private Color color;

    public PiezaTablero(int posicionX, int posicionY, Color color) {
        /*Creamos las piezas del tablero*/
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.color = color;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PiezaTablero that = (PiezaTablero) o;
        return getPosicionX() == that.getPosicionX() &&
                getPosicionY() == that.getPosicionY() &&
                getColor() == that.getColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPosicionX(), getPosicionY(), getColor());
    }

    @Override
    public String toString() {
        return "PiezaTablero{" +
                "posicionX=" + posicionX +
                ", posicionY=" + posicionY +
                ", color=" + color +
                '}';
    }

    /*Método compareTo por defecto (interfaz Comparable), basado en la posicion Y*/
    @Override
    public int compareTo(PiezaTablero p) {
        if (p == null) {
            return 1;
        } else {
            if (this.posicionY < p.posicionY) { //Ordenamos las piezas segun su posicion Y
                return -1;
            } else if (this.posicionY > p.posicionY) {
                return 1;
            }
        }

        return 0;
    }
}
