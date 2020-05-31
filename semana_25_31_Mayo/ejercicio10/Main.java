package semana_25_31.ejercicio10;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Creamos los profesores
        Profesor p1 = new Profesor("Juan Diego","247326L","profesor",1);
        Profesor p2 = new Profesor("Teresa","247226L","profesor",2);
        Profesor p3 = new Profesor("Chema","247227L","profesor",1);

        Departamento d1 = new Departamento(1); //Creamos un departamento

        List<Profesor> profesores = new ArrayList<>(); //Creamos la lista de profesores

        profesores.add(p1); //Añadimos el primer profesor a la lista

        //Creamos el instituto
        Instituto i = new Instituto("Alixar",1,"ficheroInstituto");

        i.anadeDepto(d1); //Añadimos dentro del instituto el departamento que hemos creado

    }
}
