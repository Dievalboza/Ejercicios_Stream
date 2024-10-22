
import java.util.List;

public class Pelicula {

    int idPelicula;
    String tituloPelicula;
    int year;
    String ranking;
    List<Genero> generos;
    List<Director> directores;

    public Pelicula(int idPelicula, String tituloPelicula, int year, String ranking, List<Genero> generos, List<Director> directores) {
        this.idPelicula = idPelicula;
        this.tituloPelicula = tituloPelicula;
        this.year = year;
        this.ranking = ranking;
        this.generos = generos;
        this.directores = directores;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    @Override
    public String toString() {
        return tituloPelicula;
    }

}