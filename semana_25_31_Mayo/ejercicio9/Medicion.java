package semana_25_31.ejercicio9;

public class Medicion implements Comparable {

    private int temperatura, humedad, presion;

    public Medicion(int temperatura, int humedad, int presion) {
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.presion = presion;
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
