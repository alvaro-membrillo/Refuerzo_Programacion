package semana_11_17_Mayo.ejercicio8;

import java.util.Collections;
import java.util.Objects;

public class Oferta implements Comparable<Oferta> {

    private Persona persona;
    private float importe;

    public Oferta(Persona persona, float importe) {
        this.persona = persona;
        this.importe = importe;
    }


    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Oferta oferta = (Oferta) o;
        return Float.compare(oferta.getImporte(), getImporte()) == 0 &&
                Objects.equals(getPersona(), oferta.getPersona());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPersona(), getImporte());
    }

    @Override
    public String toString() {
        return "Oferta{" +
                "persona=" + persona +
                ", importe=" + importe +
                '}';
    }

    @Override
    public int compareTo(Oferta o) {
        /*Ordenación natural para cuando vamos a ordenar las ofertas --> forma ascendente*/
        if (this.importe < o.importe) { //Si el importe de la oferta es menor de la que le pasamos por parámetro
            return -1;
        } else if (this.importe > o.importe) {
            return 1;
        }

        return 0; //Este caso solo se va a dar cuando sean iguales
    }
}
