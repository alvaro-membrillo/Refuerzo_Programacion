package semana_11_17_Mayo.ejercicio9.tipos_de_mando;

import semana_11_17_Mayo.ejercicio9.InterfazVolumen;
import semana_11_17_Mayo.ejercicio9.MandoADistancia;

import java.util.Objects;

public class MandoMiniCadena extends MandoADistancia implements InterfazVolumen {

    private int volumen;

    public MandoMiniCadena(String modelo, float anchura, float altura, float precio) {
        super(modelo, anchura, altura, precio);
        this.volumen = 30; //Valor del volumen por defecto
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MandoMiniCadena that = (MandoMiniCadena) o;
        return getVolumen() == that.getVolumen();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getVolumen());
    }

    @Override
    public String toString() {
        return super.toString()+"MandoMiniCadena{" +
                "volumen=" + volumen +
                '}';
    }

    @Override
    public void subirVolumen(int volumen) {
        this.volumen += volumen;
    }

    @Override
    public void bajarVolumen(int volumen) {
        this.volumen -= volumen;
    }
}
