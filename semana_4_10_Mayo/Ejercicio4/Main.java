package semana_4_10_Mayo.ejercicio4;

public class Main {
    public static void main(String[] args) {

        //Instanciamos dos objetos de la clase vuelo
        Vuelo v1 = new Vuelo(new Avion("Airbus",50,"A400M",ModoVuelo.MANUAL),"15/04/2020",
                "Barajas","San Pablo");

        Vuelo v2 = new Vuelo(new Avion("Boeing",60,"767",ModoVuelo.PILOTO_AUTOMÁTICO),
                "02/03/2019","El Prat","Aeropuerto de Palma de Mallorca");

        Vuelo v3 = new Vuelo(new Avion("Ejemplo",70,"7657",ModoVuelo.CRUCERO),
                "02/03/2020","Barajas","Bilbao");

        Vuelo v4 = new Vuelo(new Avion("Boeing",40,"767",ModoVuelo.PILOTO_AUTOMÁTICO),
                "06/07/2020","Ibiza","Barajas");


        Aeropuerto a1 = new Aeropuerto("Barajas");
        Aeropuerto a2 = new Aeropuerto("El Prat");


        a1.addVuelos(v1);
        a1.addVuelos(v3);
        a1.addVuelos(v3);

        a1.delVuelos(v3);
        System.out.println(a1.toString());

        a1.mostrarVuelos("15/04/2020");
    }
}
