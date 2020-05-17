package semana_11_17_Mayo.ejercicio8;

import java.util.Objects;

public class Inmueble {

    private int refCat;
    private int anyo;
    private Domicilio domicilio;

    public Inmueble(int refCat, int anyo, Domicilio domicilio) {
        this.refCat = refCat;
        this.anyo = anyo;
        this.domicilio = domicilio;
    }

    public int getRefCat() {
        return refCat;
    }

    public void setRefCat(int refCat) {
        this.refCat = refCat;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inmueble inmueble = (Inmueble) o;
        return getAnyo() == inmueble.getAnyo() &&
                Objects.equals(getRefCat(), inmueble.getRefCat()) &&
                Objects.equals(getDomicilio(), inmueble.getDomicilio());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRefCat(), getAnyo(), getDomicilio());
    }

    @Override
    public String toString() {
        return "Inmueble{" +
                "refCat='" + refCat + '\'' +
                ", anyo=" + anyo +
                ", domicilio=" + domicilio +
                '}';
    }
}
