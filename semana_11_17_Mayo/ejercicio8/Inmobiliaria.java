package semana_11_17_Mayo.ejercicio8;

import java.util.ArrayList;
import java.util.Objects;

public class Inmobiliaria {

    private ArrayList<Vivienda> listaViviendas; //Lista de viviendas

    //Constructor para instanciar objetos de la clase Inmobiliaria
    public Inmobiliaria(ArrayList<Vivienda> listaViviendas) {
        this.listaViviendas = listaViviendas;
    }

    //Método para poner a disposicion una vivienda concreta que se le pasa por parámetro
    public void altaVivienda(Vivienda v) {
        /*Si dentro de la lista está la vivienda*/
        if (listaViviendas.contains(v)) {
            v.setDisponibilidad(true); //Pasamos si atributo disponible a true (está disponible)
            System.out.println("Se ha modificado el estado de la vivienda a true");
        } else {
            listaViviendas.add(v);
            v.setDisponibilidad(true);
            System.out.println("Se ha añadido la vivienda y está disponible");
        }

    }

    /*Para una vivienda concreta añadimos una oferta más*/
    public void altaOfertaVivienda (Vivienda v, Oferta o) {

        if (v.getListaOfertas().contains(o)) {
            System.out.println("Esa oferta ya existe "+o);
        } else {
            System.out.println("Añadimos la oferta "+o);
            v.getListaOfertas().add(o);
        }
    }


    public void bajaVivienda(Vivienda v) {

        if (listaViviendas.contains(v)) {
            v.setDisponibilidad(false); //Ya no está disponible la vivienda
            System.out.println("Se ha eliminado las ofertas de la vivienda con referencia catastral --> "+v.getRefCat());
            v.getListaOfertas().removeAll(v.getListaOfertas());
        } else {
            System.out.println("Esa vivienda no está en la lista");
        }
    }





    public ArrayList<Vivienda> getListaViviendas() {
        return listaViviendas;
    }

    public void setListaViviendas(ArrayList<Vivienda> listaViviendas) {
        this.listaViviendas = listaViviendas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inmobiliaria that = (Inmobiliaria) o;
        return Objects.equals(getListaViviendas(), that.getListaViviendas());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getListaViviendas());
    }

    @Override
    public String toString() {
        return "Inmobiliaria{" +
                "listaViviendas=" + listaViviendas +
                '}';
    }
}
