package semana_4_10_Mayo.ejercicio1;

public class Avion {

    /*Declaración de atributos*/
    private String aerolinea;
    private float longitud;
    private String modelo;
    //He indicado los valores de este atributo en una clase enum aparte
    private ModoVuelo modoVuelo;

    //Constructor
    public Avion(String aerolinea, float longitud, String modelo, ModoVuelo modoVuelo) {
        this.aerolinea = aerolinea;
        this.longitud = longitud;
        this.modelo = modelo;
        this.modoVuelo = modoVuelo;
    }

    /*Metodos sobre el comportamiento que tienen los objetos de tipo Avion*/
    public void despegar () {
        System.out.println("Saliendo del aeropuerto");
    }

    public void aterrizar () {
        System.out.println("Tomando tierra");
    }

    public void volar () {
        System.out.println("Volando, altura estimada"+(Math.random()*150-80));
    }

    /*Inserción de los métodos getters (para acceder a los valores de
    atributos privados desde otras clases) y setters (para cambiar los valores de
    los atributos privados desde otras clases)*/
    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public ModoVuelo getModoVuelo() {
        return modoVuelo;
    }

    public void setModoVuelo(ModoVuelo modoVuelo) {
        modoVuelo = modoVuelo;
    }

    /*Metodo toString para representar los valores de los objetos generados
    a traves del constructor de la clase Avion*/
    @Override
    public String toString() {
        return "Avion{" +
                "aerolinea='" + aerolinea + '\'' +
                ", longitud=" + longitud +
                ", modelo='" + modelo + '\'' +
                ", ModoVuelo=" + modoVuelo +
                '}';
    }
}
