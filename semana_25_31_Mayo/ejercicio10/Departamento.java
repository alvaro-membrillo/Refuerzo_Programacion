package semana_25_31.ejercicio10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Departamento {

    private List<Profesor> listaProfesores; //Creamos la lista de profesores del departamento
    private int id;

    //El contructor recibe el id del departamento
    public Departamento(int id) {
        this.id = id;
        this.listaProfesores = new ArrayList<>(); //y se crea la lista de profesores dentro
    }

    public List<Profesor> getListaProfesores() {
        return listaProfesores;
    }

    public void setListaProfesores(List<Profesor> listaProfesores) {
        this.listaProfesores = listaProfesores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //Dos departamentos son iguales cuando coinciden sus identificadores
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departamento that = (Departamento) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
