package semana_11_17_Mayo.ejercicio9.tipos_de_mando;

import semana_11_17_Mayo.ejercicio9.InterfazVelocidad;
import semana_11_17_Mayo.ejercicio9.MandoADistancia;
import semana_11_17_Mayo.ejercicio9.Modo;

import java.util.Objects;

public class MandoAireAcondicionado extends MandoADistancia implements InterfazVelocidad {

    private Modo modo;
    private float temperatura;
    private int velocidad;


    public MandoAireAcondicionado(String modelo, float anchura, float altura, float precio) {
        super(modelo, anchura, altura, precio);
        this.modo = modo.FRIO;
        this.temperatura = 25; //Valores por defecto de velocidad y temperatura
        this.velocidad = 3;
    }

    public Modo getModo() {
        return modo;
    }

    public void setModo(Modo modo) {
        this.modo = modo;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MandoAireAcondicionado that = (MandoAireAcondicionado) o;
        return Float.compare(that.getTemperatura(), getTemperatura()) == 0 &&
                getVelocidad() == that.getVelocidad() &&
                getModo() == that.getModo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getModo(), getTemperatura(), getVelocidad());
    }

    @Override
    public String toString() {
        return super.toString()+"MandoAireAcondicionado{" +
                "modo=" + modo +
                ", temperatura=" + temperatura +
                ", velocidad=" + velocidad +
                '}';
    }

    @Override
    public void subirVelocidad() {
        this.velocidad++;
    }

    @Override
    public void bajarVelocidad() {
        this.velocidad--;
    }
}
