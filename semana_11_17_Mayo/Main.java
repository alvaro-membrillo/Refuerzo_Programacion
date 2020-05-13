package semana_11_17_Mayo.ejercicio6;

public class Main {
    public static void main(String[] args) {

        /*Creamos los objetos necesarios*/
        Libro l1 = new Libro(1,"La vuelta al mundo en 80 dias",1872);
        Libro l2 = new Libro(3,"Cien años de soledad",1967);

        Revista r1 = new Revista(2,"Forbes",1917,70);
        Revista r2 = new Revista(4,"Science",1880,50);

        l1.presta(); //Prestamos el primer libro
        System.out.println(l1.toString());

        System.out.println(l2.toString()); //Mostramos el segundo libro

        l1.devuelve(); //Devolvemos el primer libro
        System.out.println(l1.toString());

        System.out.println(r1.getNumero()); //Motramos el numero de la primera revista
        System.out.println(r2.toString()); //Mostramos la informacion de la segunda revista

        System.out.println("¿"+l1.getTitulo()+" está prestado? --> "+l1.estaPrestado()); //Comprobamos si esta prestado

    }
}
