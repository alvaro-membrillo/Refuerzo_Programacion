package semana_11_17_Mayo.ejercicio9.tipos_de_mando;

import semana_11_17_Mayo.ejercicio9.InterfazVolumen;
import semana_11_17_Mayo.ejercicio9.MandoADistancia;

import java.util.Objects;

public class MandoTV extends MandoADistancia implements InterfazVolumen {

    private int volumen;
    private String canal;

    public MandoTV(String modelo, float anchura, float altura, float precio) {
        super(modelo, anchura, altura, precio);
        this.volumen = 40; //Valores por defecto de volumen y canal
        this.canal = "Antena 3";
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MandoTV mandoTV = (MandoTV) o;
        return getVolumen() == mandoTV.getVolumen() &&
                Objects.equals(getCanal(), mandoTV.getCanal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getVolumen(), getCanal());
    }

    @Override
    public String toString() {
        return super.toString()+"MandoTV{" +
                "volumen=" + volumen +
                ", canal='" + canal + '\'' +
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
