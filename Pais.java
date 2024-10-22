
import java.util.List;

public class Pais {

    String codigo;
    String nombrePais;
    String nombreContinente;
    double areaPoblacion;
    int capital;
    int nroPoblacion;
    List<Ciudad> ciudades;

    public Pais(String codigo, String nombrePais, String nombreContinente, double areaPoblacion, int capital, int nroPoblacion, List<Ciudad> ciudades) {
        this.codigo = codigo;
        this.nombrePais = nombrePais;
        this.nombreContinente = nombreContinente;
        this.areaPoblacion = areaPoblacion;
        this.capital = capital;
        this.nroPoblacion = nroPoblacion;
        this.ciudades = ciudades;
    }

    public String getNombreContinente() {
        return nombreContinente;
    }

    public int getNroPoblacion() {
        return nroPoblacion;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    
}