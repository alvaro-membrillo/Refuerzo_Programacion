package semana_11_17_Mayo.ejercicio8;

import java.util.*;

public class Vivienda extends Inmueble {

    private Persona persona;
    private TipoVivienda tipoVivienda; //Enum con el tipo de vivienda
    private boolean disponibilidad; //Si la vivienda esta disponible o no
    private List<Oferta> listaOfertas; //lista de ofertas de cada vivienda

    public Vivienda(int refCat, int anyo, Domicilio domicilio, Persona persona, TipoVivienda tipoVivienda, boolean disponibilidad, List<Oferta> listaOfertas) {
        super(refCat, anyo, domicilio);
        this.persona = persona;
        this.tipoVivienda = tipoVivienda;
        this.disponibilidad = disponibilidad;
        this.listaOfertas = listaOfertas;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public TipoVivienda getTipoVivienda() {
        return tipoVivienda;
    }

    public void setTipoVivienda(TipoVivienda tipoVivienda) {
        this.tipoVivienda = tipoVivienda;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public List<Oferta> getListaOfertas() {
        return listaOfertas;
    }

    public void setListaOfertas(List<Oferta> listaOfertas) {
        this.listaOfertas = listaOfertas;
    }



    @Override
    public boolean equals(Object o) {
        /*Esta línea de código no nos vale porque queremos que dos viviendas sean iguales solo cuando tengan la misma
        * referencia catastral*/
        //if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Vivienda vivienda = (Vivienda) o;
        if (this.getRefCat() == (vivienda.getRefCat())) { //Dos viviendas son iguales si tienen la misma referencia catastral
            return true;
        }
        return isDisponibilidad() == vivienda.isDisponibilidad() &&
                Objects.equals(getPersona(), vivienda.getPersona()) &&
                getTipoVivienda() == vivienda.getTipoVivienda() &&
                Objects.equals(getListaOfertas(), vivienda.getListaOfertas());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPersona(), getTipoVivienda(), isDisponibilidad(), getListaOfertas());
    }

    @Override
    public String toString() {
        return "Vivienda{" +
                "persona=" + persona +
                ", tipoVivienda=" + tipoVivienda +
                ", disponibilidad=" + disponibilidad +
                ", listaOfertas=" + listaOfertas +
                '}';
    }


}
