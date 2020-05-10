package semana_4_10_Mayo.ejercicio5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        /*- Tenemos que insertar los datos de un ciudadano concreto
        * - Añadir una salida a un ciudadano para una fecha determinada (Compra, Deporte, Paseo)
        * - Comprobar un numero de salida de un ciudadano en una fecha determinada
        * - Mostrar la multa correspondiente a cada ciudadano (600€ por el numero de visitas del mismo tipo sin
        * contar la primera salida por un motivo concreto)*/

        Salida[] s1 = new Salida[0];
        Salida[] s2 = new Salida[0];

        Ciudadano c1 = new Ciudadano(1,"Alvaro");
        Ciudadano c2 = new Ciudadano(2,"Raúl");

        c1.addSalida(new Salida(MotivoSalida.PASEO,"15/03/2020"));

        c2.addSalida(new Salida(MotivoSalida.PASEO,"15/03/2020"));
        c2.addSalida(new Salida(MotivoSalida.PASEO,"15/03/2020"));

        System.out.println("Numero de salidas de "+c1.getNombre()+" para la fecha 15/03/2020 --> "+c1.salidasPorFecha("15/03/2020"));

        c1.multar("15/03/2020");
        c2.multar("15/03/2020");

        System.out.println(Arrays.toString(c1.getSalidas()));

    }
}
