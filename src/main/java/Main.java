import controlador.Controlador;
import modelo.BaseDatosSimulada;
import modelo.Inscripcion;
import com.google.gson.Gson;
import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        port(8080);

        // Configurar carpeta de archivos estáticos
        staticFiles.location("/public");

        Gson gson = new Gson();

        // Ruta para mostrar el formulario
        get("/", (req, res) -> {
            res.type("text/html; charset=UTF-8");
            return getFormularioHTML();
        });

        // Ruta para procesar la inscripción
        post("/inscribir", (req, res) -> {
            res.type("application/json; charset=UTF-8");

            String nombreEstudiante = req.queryParams("nombreEstudiante");
            String carnetEstudiante = req.queryParams("carnetEstudiante");
            String nombreCurso = req.queryParams("nombreCurso");
            String codigoCurso = req.queryParams("codigoCurso");

            Controlador controlador = new Controlador();
            controlador.procesarInscripcion(nombreEstudiante, carnetEstudiante, nombreCurso, codigoCurso);

            return gson.toJson(new Respuesta(true, "Inscripción realizada exitosamente"));
        });

        // Ruta para obtener todas las inscripciones
        get("/inscripciones", (req, res) -> {
            res.type("application/json; charset=UTF-8");
            return gson.toJson(BaseDatosSimulada.obtenerInscripciones());
        });

        System.out.println("Servidor iniciado en http://localhost:8080");
    }

    private static String getFormularioHTML() {
        return "<!DOCTYPE html>\n" +
                "<html lang='es'>\n" +
                "<head>\n" +
                "    <meta charset='UTF-8'>\n" +
                "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>\n" +
                "    <title>Sistema de Registro UMG</title>\n" +
                "    <style>\n" +
                "        * {\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "            box-sizing: border-box;\n" +
                "        }\n" +
                "        body {\n" +
                "            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\n" +
                "            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);\n" +
                "            min-height: 100vh;\n" +
                "            display: flex;\n" +
                "            justify-content: center;\n" +
                "            align-items: center;\n" +
                "            padding: 20px;\n" +
                "        }\n" +
                "        .container {\n" +
                "            background: white;\n" +
                "            border-radius: 20px;\n" +
                "            box-shadow: 0 20px 60px rgba(0,0,0,0.3);\n" +
                "            max-width: 900px;\n" +
                "            width: 100%;\n" +
                "            overflow: hidden;\n" +
                "        }\n" +
                "        .header {\n" +
                "            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);\n" +
                "            color: white;\n" +
                "            padding: 30px;\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "        .header h1 {\n" +
                "            font-size: 2em;\n" +
                "            margin-bottom: 10px;\n" +
                "        }\n" +
                "        .content {\n" +
                "            padding: 40px;\n" +
                "        }\n" +
                "        .form-group {\n" +
                "            margin-bottom: 25px;\n" +
                "        }\n" +
                "        label {\n" +
                "            display: block;\n" +
                "            margin-bottom: 8px;\n" +
                "            color: #333;\n" +
                "            font-weight: 600;\n" +
                "        }\n" +
                "        input {\n" +
                "            width: 100%;\n" +
                "            padding: 12px 15px;\n" +
                "            border: 2px solid #e0e0e0;\n" +
                "            border-radius: 8px;\n" +
                "            font-size: 16px;\n" +
                "            transition: all 0.3s;\n" +
                "        }\n" +
                "        input:focus {\n" +
                "            outline: none;\n" +
                "            border-color: #667eea;\n" +
                "            box-shadow: 0 0 0 3px rgba(102, 126, 234, 0.1);\n" +
                "        }\n" +
                "        button {\n" +
                "            width: 100%;\n" +
                "            padding: 15px;\n" +
                "            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);\n" +
                "            color: white;\n" +
                "            border: none;\n" +
                "            border-radius: 8px;\n" +
                "            font-size: 18px;\n" +
                "            font-weight: 600;\n" +
                "            cursor: pointer;\n" +
                "            transition: transform 0.2s;\n" +
                "        }\n" +
                "        button:hover {\n" +
                "            transform: translateY(-2px);\n" +
                "            box-shadow: 0 5px 20px rgba(102, 126, 234, 0.4);\n" +
                "        }\n" +
                "        button:active {\n" +
                "            transform: translateY(0);\n" +
                "        }\n" +
                "        .inscripciones {\n" +
                "            margin-top: 40px;\n" +
                "            padding-top: 40px;\n" +
                "            border-top: 2px solid #e0e0e0;\n" +
                "        }\n" +
                "        .inscripciones h2 {\n" +
                "            color: #333;\n" +
                "            margin-bottom: 20px;\n" +
                "        }\n" +
                "        .inscripcion-item {\n" +
                "            background: #f8f9fa;\n" +
                "            padding: 15px;\n" +
                "            border-radius: 8px;\n" +
                "            margin-bottom: 10px;\n" +
                "            border-left: 4px solid #667eea;\n" +
                "        }\n" +
                "        .mensaje {\n" +
                "            padding: 15px;\n" +
                "            border-radius: 8px;\n" +
                "            margin-bottom: 20px;\n" +
                "            display: none;\n" +
                "        }\n" +
                "        .mensaje.exito {\n" +
                "            background: #d4edda;\n" +
                "            color: #155724;\n" +
                "            border: 1px solid #c3e6cb;\n" +
                "        }\n" +
                "        .mensaje.error {\n" +
                "            background: #f8d7da;\n" +
                "            color: #721c24;\n" +
                "            border: 1px solid #f5c6cb;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class='container'>\n" +
                "        <div class='header'>\n" +
                "            <h1>🎓 Sistema de Registro UMG</h1>\n" +
                "            <p>Inscripción de Estudiantes</p>\n" +
                "        </div>\n" +
                "        <div class='content'>\n" +
                "            <div id='mensaje' class='mensaje'></div>\n" +
                "            \n" +
                "            <form id='formularioInscripcion'>\n" +
                "                <div class='form-group'>\n" +
                "                    <label for='nombreEstudiante'>Nombre del Estudiante:</label>\n" +
                "                    <input type='text' id='nombreEstudiante' name='nombreEstudiante' required>\n" +
                "                </div>\n" +
                "                \n" +
                "                <div class='form-group'>\n" +
                "                    <label for='carnetEstudiante'>Carnet del Estudiante:</label>\n" +
                "                    <input type='text' id='carnetEstudiante' name='carnetEstudiante' required>\n" +
                "                </div>\n" +
                "                \n" +
                "                <div class='form-group'>\n" +
                "                    <label for='nombreCurso'>Nombre del Curso:</label>\n" +
                "                    <input type='text' id='nombreCurso' name='nombreCurso' required>\n" +
                "                </div>\n" +
                "                \n" +
                "                <div class='form-group'>\n" +
                "                    <label for='codigoCurso'>Código del Curso:</label>\n" +
                "                    <input type='text' id='codigoCurso' name='codigoCurso' required>\n" +
                "                </div>\n" +
                "                \n" +
                "                <button type='submit'>Inscribir Estudiante</button>\n" +
                "            </form>\n" +
                "            \n" +
                "            <div class='inscripciones'>\n" +
                "                <h2>📋 Inscripciones Registradas</h2>\n" +
                "                <div id='listaInscripciones'></div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    \n" +
                "    <script>\n" +
                "        function cargarInscripciones() {\n" +
                "            fetch('/inscripciones')\n" +
                "                .then(response => response.json())\n" +
                "                .then(data => {\n" +
                "                    const lista = document.getElementById('listaInscripciones');\n" +
                "                    if (data.length === 0) {\n" +
                "                        lista.innerHTML = '<p style=\"color: #666;\">No hay inscripciones registradas.</p>';\n" +
                "                    } else {\n" +
                "                        lista.innerHTML = data.map(inscripcion => \n" +
                "                            `<div class='inscripcion-item'>\n" +
                "                                <strong>${inscripcion.estudiante.nombre}</strong> (${inscripcion.estudiante.carnet})<br>\n" +
                "                                📚 ${inscripcion.curso.nombre} - Código: ${inscripcion.curso.codigo}\n" +
                "                            </div>`\n" +
                "                        ).join('');\n" +
                "                    }\n" +
                "                });\n" +
                "        }\n" +
                "        \n" +
                "        function mostrarMensaje(texto, tipo) {\n" +
                "            const mensaje = document.getElementById('mensaje');\n" +
                "            mensaje.textContent = texto;\n" +
                "            mensaje.className = 'mensaje ' + tipo;\n" +
                "            mensaje.style.display = 'block';\n" +
                "            setTimeout(() => {\n" +
                "                mensaje.style.display = 'none';\n" +
                "            }, 5000);\n" +
                "        }\n" +
                "        \n" +
                "        document.getElementById('formularioInscripcion').addEventListener('submit', function(e) {\n" +
                "            e.preventDefault();\n" +
                "            \n" +
                "            const formData = new FormData(this);\n" +
                "            const params = new URLSearchParams(formData);\n" +
                "            \n" +
                "            fetch('/inscribir', {\n" +
                "                method: 'POST',\n" +
                "                body: params\n" +
                "            })\n" +
                "            .then(response => response.json())\n" +
                "            .then(data => {\n" +
                "                if (data.exito) {\n" +
                "                    mostrarMensaje(data.mensaje, 'exito');\n" +
                "                    this.reset();\n" +
                "                    cargarInscripciones();\n" +
                "                } else {\n" +
                "                    mostrarMensaje(data.mensaje, 'error');\n" +
                "                }\n" +
                "            })\n" +
                "            .catch(error => {\n" +
                "                mostrarMensaje('Error al procesar la inscripción', 'error');\n" +
                "            });\n" +
                "        });\n" +
                "        \n" +
                "        // Cargar inscripciones al iniciar\n" +
                "        cargarInscripciones();\n" +
                "    </script>\n" +
                "</body>\n" +
                "</html>";
    }

    static class Respuesta {
        boolean exito;
        String mensaje;

        Respuesta(boolean exito, String mensaje) {
            this.exito = exito;
            this.mensaje = mensaje;
        }
    }
}
