package modelo;

import java.util.ArrayList;
import java.util.List;

public class BaseDatosSimulada {
    private static List<Inscripcion> listaInscripciones = new ArrayList<>();

    public static void agregarInscripcion(Inscripcion inscripcion) {
        listaInscripciones.add(inscripcion);
    }

    public static List<Inscripcion> obtenerInscripciones() {
        return listaInscripciones;
    }
}