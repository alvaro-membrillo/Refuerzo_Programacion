package semana_25_31.ejercicio10;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class Instituto {

    //Creamos el conjunto de los departamentos de cada instituto
    private Set<Departamento> departamentos = new LinkedHashSet<>();
    private String nombre;
    private int codigo;

    public Instituto(String nombre, int codigo, String nombreFicheroProfesores) {
        //Damos valor al nombre y código del instituto
        this.nombre = nombre;
        this.codigo = codigo;
        //Creamos el fichero que contiene los profesores del instituto
        File ficheroProfesores = new File(nombreFicheroProfesores + ".dat");

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ficheroProfesores));

            Profesor aux = (Profesor) ois.readObject(); //Leemos el fichero de profesores
            while (aux != null) {
                //Creamos un departamento con el mismo código que el departamento del profesor
                Departamento d = new Departamento(aux.getIdDepartamento());

                if (contieneDepto(d)) { //Comparamos el departamento que hemos creado con los que hay dentro de la lista
                    /*Del departamento que estamos buscando, obtenemos la lista de profesores, en esa lista metemos el
                     * profesor que estamos recorriendo*/
                    for (Profesor p : d.getListaProfesores()) {
                        d.getListaProfesores().add(p);
                    }

                } else { //Cuando no existe el departamento dentro del instituto
                    d.getListaProfesores().add(aux); //Añadimos el profesor dentro del departamento
                    departamentos.add(d); //y añadimos el departamento directamente
                }
            }

            //Guardamos los profesores dentro del fichero
            guardarProfesoresEnFichero(nombreFicheroProfesores+".dat");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    /*Tenemos que recorrer el fichero con los profesores, por cada profesor vamos a comprobar si su departamento
     * estaba o no incluido en el instituto. Si estaba incluido vamos a añadir el profesor en el departamento correspondiente.
     * Si no está incluido ese departamento, lo creamos, insertamos el profesor y añadimos ese departamento dentro de la lista
     * de departamentos del instituto*/

    /*Devuelve true si hay un departamento igual que otro (usando metodo equals que compara objetos Departamento)*/
    public boolean contieneDepto(Departamento d) {
        for (Departamento de : departamentos) {
            if (de.equals(d)) {
                return true;
            }
        }

        return false;
    }

    public Departamento getDepartamento(Departamento d) {
        return d; //Devolvemos el departamento
    }

    //Si no existe el dapartamento lo añadimos
    public boolean anadeDepto(Departamento d) {
        //Siempre que el departamento no esté dentro de la lista de departamentos lo añadimos
        if (!contieneDepto(d)) {
            departamentos.add(d);
            return true;
        }

        return false;
    }

    //Guardamos los profesores dentro del fichero
    public void guardarProfesoresEnFichero(String nomFichero) {
        File ficheroProfesores = new File(nomFichero + ".dat"); //Creamos el fichero de los profesores

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ficheroProfesores));

            //Recorremos todos los departamentos dentro del conjunto de departamentos
            for (Departamento d : departamentos) {
                /*Vamos guardando dentro de la lista de profesores todos los que vamos encontrando en cada departamento*/
                Set<Profesor> profesores = (Set<Profesor>) d.getListaProfesores();
                //Escribimos el conjunto de los profesores dentro del fichero
                oos.writeObject(profesores);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
