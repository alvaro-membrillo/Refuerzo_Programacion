package semana_4_10_Mayo.ejercicio1y2;

public class Main {
    public static void main(String[] args) {

        //Creación de objetos de la clase Avión
        Avion a1 = new Avion("Boeing",70,"Hércules", ModoVuelo.PILOTO_AUTOMÁTICO);
        Avion a2 = new Avion("Airbus",80,"A400M", ModoVuelo.CRUCERO);
        Avion a3 = new Avion("Airbus",60,"A500M", ModoVuelo.MANUAL);
        Avion a4 = new Avion("Airbus",100,"B400M", ModoVuelo.MANUAL);
        Avion a5 = new Avion("Airbus",90,"A400J", ModoVuelo.CRUCERO);

        //Creación de objetos de la clase Pasajero
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

        //Aqui vamos a aplicar los metodos sobre los objetos que hemos creado anteriormente
        a1.despegar();
        a2.aterrizar();

        System.out.println(); //Para poner espaciado en la consola

        //Probamos los métodos que hemos creado
        p1.andar();
        p2.sonreir();
        p3.embarcar(a2);
        /*Estos metodos se muestran a través del metodo System.out.println porque devuelven un entero y de esta forma
        se escribe en pantalla*/
        System.out.println("El nombre del cuarto pasajero es "+p4.getNombre());
        System.out.println("Informacion almacenada sobre el quinto pasajero: "+p5.toString());

        /*Podemos saber el numero de aviones que se han creado con tan solo mostrar el metodo get del numero de aviones
        * de cualquier objeto de tipo avion, porque al ser estático no se ha reiniciado su valor, se ha ido sumando
        * cada vez que hemos creado un objeto nuevo*/
        System.out.println('\n'+"Número de aviones que se han creado: "+a1.getNumAviones());

        /*Lo mismo pasa con los pasajeros*/
        System.out.println("Numero de pasajeros que se han creado: "+p3.getNumPasajeros());

        /*En este caso he decidido mostrar el numero de objetos creados mediante un atributo contador y el
        método getter del mismo, tambien he modificado el constructor para que cada vez que se crea un objeto muestre
        la cantidad de objetos creados*/

    }
}
