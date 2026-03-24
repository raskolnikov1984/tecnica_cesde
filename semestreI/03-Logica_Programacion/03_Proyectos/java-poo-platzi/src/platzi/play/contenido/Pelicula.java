package platzi.play.contenido;

public class Pelicula {
    public String titulo;
    public String description;
    public int duracion;
    public String genero;
    public int anioEstreno;
    public double calificacion;
    public boolean disponible;

    public void reproducir(){
        System.out.println("Reproduciendo " + titulo);
    }

    public String obtenerFichaTecnica(){
        return titulo + " (" + anioEstreno + ")\n" +
                "Genero: " + genero + "\n" + "Calificacion: " + calificacion + "/5";
    }

    public void calificar(double calificacion) {
        if(calificacion >=0 && calificacion <=5){
            this.calificacion = calificacion;
        }
    }
}
