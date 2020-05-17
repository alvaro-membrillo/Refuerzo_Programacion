package semana_11_17_Mayo.ejercicio9.tipos_de_mando;

import semana_11_17_Mayo.ejercicio9.InterfazVelocidad;
import semana_11_17_Mayo.ejercicio9.MandoADistancia;

import java.util.Objects;

public class MandoAspiradora extends MandoADistancia implements InterfazVelocidad {

    private int velocidad;

    public MandoAspiradora(String modelo, float anchura, float altura, float precio) {
        super(modelo, anchura, altura, precio);
        this.velocidad = 4; //Por defecto tendra 4 de velocidad
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
        MandoAspiradora that = (MandoAspiradora) o;
        return getVelocidad() == that.getVelocidad();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getVelocidad());
    }

    @Override
    public String toString() {
        return super.toString()+"MandoAspiradora{" +
                "velocidad=" + velocidad +
                '}';
    }


    /*la velocidad de se baja o se sube de uno en uno, cada vez que se llama al metodo*/
    @Override
    public void subirVelocidad() {
        this.velocidad++;
    }

    @Override
    public void bajarVelocidad() {
        this.velocidad--;
    }
}
