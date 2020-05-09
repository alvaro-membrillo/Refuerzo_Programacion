package semana_4_10_Mayo.ejercicio3;

public class Main {
    public static void main(String[] args) {

        //Instanciamos dos objetos de la clase vuelo
        Vuelo v1 = new Vuelo(new Avion("Airbus",50,"A400M",ModoVuelo.MANUAL),"15/04/2020",
                "San Pablo","Barajas");

        Vuelo v2 = new Vuelo(new Avion("Being",60,"767",ModoVuelo.PILOTO_AUTOMÁTICO),
                "02/03/2019","El Prat","Aeropuerto de Palma de Mallorca");

        //Creamos los pasajeros
        Pasajero p1 = new Pasajero("Arturo","direccion 1",1);
        Pasajero p2 = new Pasajero("Claudia","direccion 2",15);
        Pasajero p3 = new Pasajero("Marta","direccion 3",3);
        Pasajero p4 = new Pasajero("Sancho","direccion 4",2);
        Pasajero p5 = new Pasajero("Idris","direccion 5",7);
        Pasajero p6 = new Pasajero("Julian","direccion 6",50);
        Pasajero p7 = new Pasajero("Javier","direccion 7",23);
        Pasajero p8 = new Pasajero("Lucía","direccion 8",16);
        Pasajero p9 = new Pasajero("Ana","direccion 9",24);
        Pasajero p10 = new Pasajero("Alberto","direccion 10",9);

        //Añadimos los pasajeros a los vuelos
        v1.addPassenger(p1);
        v1.addPassenger(p2);
        v1.addPassenger(p3);
        v1.addPassenger(p4);
        v1.addPassenger(p5);

        //Utilizamos los metodos dentro de los vuelos
        v1.delPassenger(15);
        v1.listPassengers();

        v2.addPassenger(p5);
        v2.addPassenger(p6);
        v2.addPassenger(p7);
        v2.addPassenger(p8);
        v2.addPassenger(p9);

        v2.delPassenger(105);
        v2.listPassengers();
    }
}
