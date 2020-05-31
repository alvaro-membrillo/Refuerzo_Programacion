package semana_25_31.ejercicio6;

import java.util.Objects;

public class Carta {

    private String numero; //Guarda el nombre de la carta
    private String figura; //espada, oro

    public Carta(String numero, String figura) {
        this.figura = figura;
        this.numero = numero;
    }

    public String getFigura() {
        return figura;
    }

    public void setFigura(String figura) {
        this.figura = figura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carta carta = (Carta) o;
        return Objects.equals(numero, carta.numero) &&
                Objects.equals(getFigura(), carta.getFigura());
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, getFigura());
    }

    @Override
    public String toString() {
        return numero + figura;
    }
}
