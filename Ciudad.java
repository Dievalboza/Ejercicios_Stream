


public class Ciudad {

    int idCiudad;
    String nombreCiudad;
    int nroPoblacion;
    String codCiudad;

    public Ciudad(int idCiudad, String nombreCiudad, int nroPoblacion, String codCiudad) {
        this.idCiudad = idCiudad;
        this.nombreCiudad = nombreCiudad;
        this.nroPoblacion = nroPoblacion;
        this.codCiudad = codCiudad;
    }

    public int getNroPoblacion() {
        return nroPoblacion;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public String getCodCiudad() {
        return codCiudad;
    }

    @Override
    public String toString() {
        return nombreCiudad + " (" + nroPoblacion + ")";
    }
}

