package semana_4_10_Mayo.ejercicio5;

import java.util.Arrays;
import java.util.Objects;

public class Ciudadano {
    /*Atributos*/
    private int id; //identificacion del ciudadano
    private String nombre;
    private Salida[] salidas; //Lista de veces que ha salido

    /*Constructor*/

    public Ciudadano(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    //Métodos
    /*Para añadir una salida de un ciudadano*/
    public void addSalida(Salida salida) { //Tenemos que indicar el motivo y la fecha

        //Antes hay que comprobar si hay salidas o no
        if (salidas == null) {
            //Inicializo la lista de salidas
            salidas = new Salida[1];
            salidas[0] = salida; //Meto la salida en la primera posicion

        } else { //Si ya hay alguna salida en la lista de salidas

            boolean repetido = true; //Para saber si esta repetida o no

            for (int i = 0; i < salidas.length; i++) { //Recorremos la lista de salidas
                if (salidas[i].equals(salida)) {
                    System.out.println("Ésta salida ya está incluida dentro de la lista de salidas para este ciudadano");
                } else {
                    repetido = false; //No está repetido en la lista
                }
            }

            if (!repetido) { //Si no hay salidas repetidas vamos a insertarla dentro de la lista de salidas del ciudadano
                /*Antes tenemos que crear un vector auxiliar para redimensionar la lista con un espacio más*/
                Salida[] aux = Arrays.copyOf(salidas, salidas.length + 1);

                aux[salidas.length] = salida; //Metemos la nueva salida en la última posicion

                salidas = aux; //Actualizamos la lista igualándola a la lista auxiliar que hemos creado
            }
        }

    }

    /*Conocer la cantidad de salidas para una determinada fecha*/
    public int salidasPorFecha(String fecha) {
        int numSalidas = 0; //Creamos un contador para las salidas de ese dia

        for (int i = 0; i < salidas.length; i++) {
            if (salidas[i].getFechaSalida().equals(fecha)) { //Si la fecha de la salida es igual a la que estamos buscando
                numSalidas++; //Aumenta el numero de salidas para ese dia
            }
        }

        return numSalidas; //Devuelve el numero de salidas para esa fecha
    }

    /*Atributo para multar al ciudadano*/
    public void multar(String fecha) {
        /*Atributos*/
        int multa = 600; //Precio de la multa

        //Contadores para cada tipo de salida
        int numPaseos = 0;
        int numDeportes = 0;
        int numCompras = 0;

        int numSalidasIlegales = 0; //numero de salidas multables

        if (salidas == null) {
            System.out.println("Este ciudadano no ha salido");
        } else {
            for (int i = 0; i < salidas.length; i++) { //Recorremos la lista de salidas del ciudadano
                if (salidas[i].getFechaSalida().equals(fecha)) { //Si la salida corresponde con la misma fecha podemos contarlas
                    if (salidas[i].getMotivoSalida().equals(MotivoSalida.PASEO)) { //salidas para paseos
                        numPaseos++; //Aumentamos el numero de paseos
                        /*Comprobamos el numero de paseos ilegales, cada ciudadano tiene derecho a un paseo por dia,
                        lo mismo con el resto de motivos*/
                        if (numPaseos < 1) {
                            numSalidasIlegales++;
                        }
                    }

                    if (salidas[i].getMotivoSalida().equals(MotivoSalida.DEPORTE)) { //salidas para deporte
                        numDeportes++;
                        if (numDeportes < 1) {
                            numSalidasIlegales++;
                        }
                    }

                    if (salidas[i].getMotivoSalida().equals(MotivoSalida.COMPRA)) { //salidas para compras
                        numCompras++;
                        if (numCompras < 1) {
                            numSalidasIlegales++;
                        }
                    }
                }
            }

            if (numSalidasIlegales == 0) {
                System.out.println("El ciudadano "+getNombre()+" no ha realizado salidas ilegales");
            } else {
                System.out.println("El ciudadano "+getNombre()+" tiene "+(multa*numSalidasIlegales)+" € de multa");
            }
        }

    }



    /*Getters y setters*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Salida[] getSalidas() {
        return salidas;
    }

    public void setSalidas(Salida[] salidas) {
        this.salidas = salidas;
    }

    /*equals*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ciudadano ciudadano = (Ciudadano) o;
        return getId() == ciudadano.getId() &&
                Objects.equals(getNombre(), ciudadano.getNombre()) &&
                Arrays.equals(getSalidas(), ciudadano.getSalidas());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId(), getNombre());
        result = 31 * result + Arrays.hashCode(getSalidas());
        return result;
    }

    /*toString*/

    @Override
    public String toString() {
        return "Ciudadano{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' + '\n' +
                ", salida=" + Arrays.toString(salidas) +
                '}';
    }
}
