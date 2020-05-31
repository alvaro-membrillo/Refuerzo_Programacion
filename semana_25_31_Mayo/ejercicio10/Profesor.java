package semana_25_31.ejercicio10;

public class Profesor {

    private String nombre;
    private String dni;
    private String profesion;
    private int idDepartamento;

    public Profesor(String nombre, String dni, String profesion, int idDepartamento) {
        this.nombre = nombre;
        this.dni = dni;
        this.profesion = profesion;
        this.idDepartamento = idDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "nombre='" + nombre + '\'' +
                ", dni=" + dni +
                ", profesion='" + profesion + '\'' +
                ", idDepartamento=" + idDepartamento +
                '}';
    }
}
