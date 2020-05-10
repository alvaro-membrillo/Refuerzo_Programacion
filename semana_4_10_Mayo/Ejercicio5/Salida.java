package semana_4_10_Mayo.ejercicio5;

import java.util.Objects;

public class Salida {

    /*Atributos*/
    private MotivoSalida motivoSalida; //Razón por la que ha salido
    private String fechaSalida;

    /*Constructor*/
    public Salida(MotivoSalida motivoSalida, String fechaSalida) {
        this.motivoSalida = motivoSalida;
        this.fechaSalida = fechaSalida;
    }

    /*Getters y setters*/
    public MotivoSalida getMotivoSalida() {
        return motivoSalida;
    }

    public void setMotivoSalida(MotivoSalida motivoSalida) {
        this.motivoSalida = motivoSalida;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    /*Equals*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salida salida = (Salida) o;
        return getMotivoSalida() == salida.getMotivoSalida() &&
                Objects.equals(getFechaSalida(), salida.getFechaSalida());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMotivoSalida(), getFechaSalida());
    }

    /*ToString*/
    @Override
    public String toString() {
        return "Salida{" +
                "motivoSalida=" + motivoSalida +
                ", fechaSalida='" + fechaSalida + '\'' +
                '}';
    }
}
