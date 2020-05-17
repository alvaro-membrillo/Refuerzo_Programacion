package semana_11_17_Mayo.ejercicio8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ArrayList<Vivienda> listaViviendas = new ArrayList<>();

        Persona p1 = new Persona(1,"Ramon");
        List<Oferta> listaOfertas1 = new ArrayList<>();
        Vivienda v1 = new Vivienda(534,2014,new Domicilio("ejemplo",51,"Madrid",142),
                p1,TipoVivienda.CASA,false,listaOfertas1);

        Inmobiliaria i = new Inmobiliaria(listaViviendas);

        i.altaVivienda(v1);

        i.altaOfertaVivienda(v1,new Oferta(p1,300000));
        i.altaOfertaVivienda(v1,new Oferta(p1,250000));
        i.altaOfertaVivienda(v1,new Oferta(p1,550000));

        /*Ordenamos las ofertas de forma ascendente, como se nos pide por defecto*/
        Collections.sort(listaOfertas1);

        for (Oferta o : listaOfertas1) {
            System.out.println(o.getImporte());
        }


        /*Eliminamos las ofertas de la vivienda v1 y volvemos a mostrar la lista*/
        i.bajaVivienda(v1);
        System.out.println(v1.getListaOfertas());
    }
}
