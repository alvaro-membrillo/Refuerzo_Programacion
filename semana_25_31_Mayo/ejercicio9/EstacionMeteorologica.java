package semana_25_31.ejercicio9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EstacionMeteorologica {

    private List<Medicion> listaMedicion = new ArrayList<>();
    private Coordenadas coordenadas; //determina la localización de la estacion

    /*Como el constructor recibe el nombre del fichero binario vamos a pasarlo como objeto de tipo String, no de tipo File*/
    public EstacionMeteorologica(String nombreFicheroMediciones, Coordenadas coordenadas) {
        try {
            File ficheroMediciones = new File(nombreFicheroMediciones);
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("datos.dat")));

            Coordenadas aux = (Coordenadas) ois.readObject();

            while (aux != null) {
                //listaMedicion.add(aux);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        this.coordenadas = coordenadas;
    }

    public ArrayList<Medicion> addMedicion (Medicion medicion) {
        ArrayList<Medicion> listaMedicion = new ArrayList<>();
        //Añadimos la medición dentro de la lista de mediciones
        listaMedicion.add(medicion);
        return listaMedicion;
    }

    /*public int ordenaTemperaturas() {

    }*/
}
