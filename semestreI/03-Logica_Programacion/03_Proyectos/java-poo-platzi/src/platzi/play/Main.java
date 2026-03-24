package platzi.play;

import platzi.play.contenido.Pelicula;

public class Main {
    public static void main(String[] args){
        System.out.println("PLATZI PLAY");

        Pelicula pelicula = new Pelicula();
        pelicula.titulo = "Harry Popote";
        pelicula.anioEstreno = 2001;
        pelicula.genero = "Fantasia";
        pelicula.calificar(5.0);

        System.out.println(pelicula.obtenerFichaTecnica());
    }
}
