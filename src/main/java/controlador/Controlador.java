package controlador;

import modelo.Curso;
import modelo.Estudiante;
import modelo.Inscripcion;
import modelo.BaseDatosSimulada;

public class Controlador {

    public Controlador() {
    }

    public void procesarInscripcion(String nombreEstudiante, String carnetEstudiante,
                                   String nombreCurso, String codigoCurso) {
        // Crear el estudiante
        Estudiante estudiante = new Estudiante(nombreEstudiante, carnetEstudiante);

        // Crear el curso
        Curso curso = new Curso(codigoCurso, nombreCurso);

        // Crear la inscripción
        Inscripcion inscripcion = new Inscripcion(estudiante, curso);

        // Agregar a la base de datos simulada
        BaseDatosSimulada.agregarInscripcion(inscripcion);

        // Log en consola
        System.out.println("Inscripción completada:");
        System.out.println("Estudiante: " + estudiante.getNombre() + ", Carnet: " + estudiante.getCarnet());
        System.out.println("Curso: " + curso.getNombre() + ", Código del curso: " + curso.getCodigo());

        System.out.println("---- Total de inscripciones: " + BaseDatosSimulada.obtenerInscripciones().size() + " ----");
    }
}