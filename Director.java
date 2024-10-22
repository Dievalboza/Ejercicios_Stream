
import java.util.List;

public class Director {

    int idDirector;
    String nombreDirector;
    List<String> premios;

    public Director(int idDirector, String nombreDirector, List<String> premios) {
        this.idDirector = idDirector;
        this.nombreDirector = nombreDirector;
        this.premios = premios;
    }


}