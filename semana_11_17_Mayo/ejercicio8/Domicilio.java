package semana_11_17_Mayo.ejercicio8;

import java.util.Objects;

public class Domicilio {

    //Atributos
    private String nombreVia;
    private int numero;
    private String localizacion;
    private int cp;

    //Constructor para instanciar la clase domicilio
    public Domicilio(String nombreVia, int numero, String localizacion, int cp) {
        this.nombreVia = nombreVia;
        this.numero = numero;
        this.localizacion = localizacion;
        this.cp = cp;
    }

    /*Getters y setters de los atributos*/
    public String getNombreVia() {
        return nombreVia;
    }

    public void setNombreVia(String nombreVia) {
        this.nombreVia = nombreVia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    /*Con este metodo podemos comparar si dos Domicilios son iguales o no*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Domicilio domicilio = (Domicilio) o;
        return getNumero() == domicilio.getNumero() &&
                getCp() == domicilio.getCp() &&
                Objects.equals(getNombreVia(), domicilio.getNombreVia()) &&
                Objects.equals(getLocalizacion(), domicilio.getLocalizacion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombreVia(), getNumero(), getLocalizacion(), getCp());
    }

    //Para mostrar la informacion de un domicilio
    @Override
    public String toString() {
        return "Domicilio{" +
                "nombreVia='" + nombreVia + '\'' +
                ", numero=" + numero +
                ", localizacion='" + localizacion + '\'' +
                ", cp=" + cp +
                '}';
    }
}
