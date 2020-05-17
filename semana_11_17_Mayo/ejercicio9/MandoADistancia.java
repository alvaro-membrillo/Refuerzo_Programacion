package semana_11_17_Mayo.ejercicio9;

import java.util.Objects;

public abstract class MandoADistancia implements Comparable<MandoADistancia> {

    private String modelo;
    private float anchura, altura, precio;
    private Estado estado;

    public MandoADistancia(String modelo, float anchura, float altura, float precio) {
        this.modelo = modelo;
        this.anchura = anchura;
        this.altura = altura;
        this.precio = precio;
        this.estado = Estado.APAGADO;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public float getAnchura() {
        return anchura;
    }

    public void setAnchura(float anchura) {
        this.anchura = anchura;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public float getSuperficie() {
        return altura * anchura;
    }

    public boolean apagar() {
        this.estado = Estado.APAGADO;
        return false;
    }

    public boolean encender() {
        this.estado = Estado.ENCENDIDO;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MandoADistancia that = (MandoADistancia) o;
        return Float.compare(that.getAnchura(), getAnchura()) == 0 &&
                Float.compare(that.getAltura(), getAltura()) == 0 &&
                Float.compare(that.getPrecio(), getPrecio()) == 0 &&
                Objects.equals(getModelo(), that.getModelo()) &&
                getEstado() == that.getEstado();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getModelo(), getAnchura(), getAltura(), getPrecio(), getEstado());
    }

    @Override
    public String toString() {
        return "MandoADistancia{" +
                "modelo='" + modelo + '\'' +
                ", anchura=" + anchura +
                ", altura=" + altura +
                ", precio=" + precio +
                ", estado=" + estado +
                '}';
    }

    /*Comparador por defecto (el de superficies)*/
    @Override
    public int compareTo(MandoADistancia mandoADistancia) {
        if (mandoADistancia == null) {
            return 1;
        } else {
            float superficie1 = this.altura * this.anchura;
            float superficie2 = mandoADistancia.altura * mandoADistancia.anchura;

            if (superficie1 < superficie2) {
                return -1;
            } else if (superficie1 > superficie2) {
                return 1;
            }
        }

        return 0; //Son iguales
    }
}
