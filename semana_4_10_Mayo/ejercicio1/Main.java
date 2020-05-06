package semana_4_10_Mayo.ejercicio1;

public class Main {
    public static void main(String[] args) {

        //Creación de objetos de la clase Avión
        Avion a1 = new Avion("Boeing",70,"Hércules",ModoVuelo.PILOTO_AUTOMÁTICO);
        Avion a2 = new Avion("Airbus",80,"A400M",ModoVuelo.CRUCERO);

        Pasajero p1 = new Pasajero("Arturo","direccion 1",1);
        Pasajero p2 = new Pasajero("Claudia","direccion 2",15);
        Pasajero p3 = new Pasajero("Marta","direccion 3",3);
        Pasajero p4 = new Pasajero("Sancho","direccion 4",2);
        Pasajero p5 = new Pasajero("Idris","direccion 5",7);

        //Aqui vamos a aplicar los metodos sobre los objetos que hemos creado anteriormente
        a1.despegar();
        a2.aterrizar();

        System.out.println();

        p1.andar();
        p2.sonreir();
        p3.embarcar(a2);
        System.out.println("El nombre del cuarto pasajero es "+p4.getNombre());
        System.out.println("Informacion almacenada sobre el quinto pasajero: "+p5.toString());

    }
}
