
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


public class Main {

        
        public static Map<String, Optional<Ciudad>> ciudadesMasPobladasPorContinente(List<Pais> paises) {
    return paises.stream()
        .flatMap(p -> p.getCiudades().stream()) // Convertimos la lista de ciudades por país en un solo flujo de ciudades
        .collect(Collectors.groupingBy(Ciudad::getCodCiudad, // Agrupamos por el código del continente
                Collectors.maxBy(Comparator.comparingInt(Ciudad::getNroPoblacion)))); // Encontramos la ciudad con la mayor población en cada continente
}
public static Optional<Ciudad> ciudadMasPoblada(List<Pais> paises) {
        return paises.stream()
            .flatMap(p -> p.getCiudades().stream()) // Todas las ciudades en un solo flujo
            .max(Comparator.comparingInt(Ciudad::getNroPoblacion)); // Elegimos la ciudad con mayor población
    }
    public static List<Pelicula> peliculasConDramaYComedia(List<Pelicula> peliculas) {
        return peliculas.stream()
            .filter(p -> {
                List<String> nombresGeneros = p.getGeneros().stream()
                    .map(Genero::getNombreGenero)
                    .collect(Collectors.toList());
                return nombresGeneros.size() == 2 && nombresGeneros.contains("Drama") && nombresGeneros.contains("Comedia");
            })
            .collect(Collectors.toList());
    }
    public static List<Pais> ordenarPaisesPorNumeroDeCiudades(List<Pais> paises) {
        return paises.stream()
            .sorted((p1, p2) -> Integer.compare(p2.getCiudades().size(), p1.getCiudades().size())) // Orden descendente
            .collect(Collectors.toList());
    }
     public static List<Pais> ordenarPaisesPorPoblacionAscendente(List<Pais> paises) {
        return paises.stream()
            .sorted(Comparator.comparingInt(Pais::getNroPoblacion)) // Orden ascendente por población
            .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        // Ejemplo de datos
        List<Ciudad> ciudades1 = Arrays.asList(
            new Ciudad(1, "Lima", 3000000, "AMERICA"),
            new Ciudad(2, "Huancayo", 1580000, "AMERICA")
        );
        List<Ciudad> ciudades2 = Arrays.asList(
            new Ciudad(3, "Tokyo", 12000000, "ASIA"),
            new Ciudad(4, "Kobe", 15000000, "ASIA")
        );
        List<Ciudad> ciudades3 = Arrays.asList(
            new Ciudad(5, "Barcelona", 3000000, "EUROPA")
        );

        Pais pais1 = new Pais("P1", "Peru", "AMERICA", 123456.0, 1, 10000000, ciudades1);
        Pais pais2 = new Pais("P2", "Japon", "ASIA", 234567.0, 2, 25000000, ciudades2);
        Pais pais3 = new Pais("P3", "España", "EUROPA", 345678.0, 3, 5000000, ciudades3);

        List<Pais> paises = Arrays.asList(pais1, pais2, pais3);

        // Llamadas a las funciones

        // Solución 1
        System.out.println("Ciudades más pobladas por continente:");
        ciudadesMasPobladasPorContinente(paises).forEach((continente, ciudad) ->
            System.out.println(continente + ": " + ciudad.orElse(null))
        );

        // Solución 2
        System.out.println("\nCiudad más poblada de todos los continentes:");
        System.out.println(ciudadMasPoblada(paises).orElse(null));

        // Películas de ejemplo
        Genero drama = new Genero(1, "Drama");
        Genero comedia = new Genero(2, "Comedia");
        Genero accion = new Genero(3, "Acción");

        List<Pelicula> peliculas = Arrays.asList(
            new Pelicula(1, "Pelicula1", 2020, "A", Arrays.asList(drama, comedia), new ArrayList<>()),
            new Pelicula(2, "Pelicula2", 2021, "B", Arrays.asList(drama, accion), new ArrayList<>())
        );

        // Solución 3
        System.out.println("\nPelículas con Drama y Comedia solamente:");
        peliculasConDramaYComedia(peliculas).forEach(System.out::println);

        // Solución 4
        System.out.println("\nPaíses ordenados por número de ciudades:");
        ordenarPaisesPorNumeroDeCiudades(paises).forEach(p -> System.out.println(p.getNombrePais()));

        // Solución 5
        System.out.println("\nPaíses ordenados por población en orden ascendente:");
        ordenarPaisesPorPoblacionAscendente(paises).forEach(p -> System.out.println(p.getNombrePais()));
    }
}
