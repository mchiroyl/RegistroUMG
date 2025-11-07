# Sistema de Registro de Estudiantes UMG

Sistema de inscripción de estudiantes desarrollado con Java siguiendo el patrón de diseño MVC (Modelo-Vista-Controlador). Este proyecto permite gestionar el registro de estudiantes en diferentes cursos, simulando una interfaz web mediante generación de páginas HTML.

## Información del Proyecto

- **Estudiante:** Marvin Chiroy Lopreto
- **Carnet:** 2890-22-20336
- **Curso:** Análisis de Sistema II
- **Código del Curso:** 2890
- **Repositorio:** [https://github.com/mchiroyl/RegistroUMG](https://github.com/mchiroyl/RegistroUMG)

## Tecnologías

- Java 11+
- Maven 3.6+
- Patrón de Diseño MVC (Modelo-Vista-Controlador)
- HTML para visualización de datos

## Estructura del Proyecto

```
RegistroUMG/
├── src/
│   └── main/
│       └── java/
│           ├── Main.java              # Punto de entrada
│           ├── modelo/                # Capa de datos
│           │   ├── Estudiante.java
│           │   ├── Curso.java
│           │   ├── Inscripcion.java
│           │   └── BaseDatosSimulada.java
│           ├── vista/                 # Capa de presentación
│           │   └── VistaHTML.java
│           └── controlador/           # Capa de lógica
│               └── Controlador.java
├── pom.xml                           # Configuración Maven
├── .gitignore                        # Archivos ignorados por Git
└── README.md                         # Este archivo
```

## Requisitos

- Java Development Kit (JDK) 11 o superior
- Apache Maven 3.6 o superior

## Instalación

1. Clonar el repositorio:
```bash
git clone <url-del-repositorio>
cd RegistroUMG
```

2. Compilar el proyecto:
```bash
mvn clean compile
```

## Ejecución

Ejecutar el programa con Maven:
```bash
mvn exec:java
```

## Compilar JAR

Para generar un archivo JAR ejecutable:
```bash
mvn clean package
```

El archivo JAR se generará en `target/RegistroUMG-1.0-SNAPSHOT.jar`

## Descripción

El sistema permite registrar inscripciones de estudiantes a cursos mediante una arquitectura MVC bien estructurada. Implementa:

- **Modelo:** Entidades de dominio (Estudiante, Curso, Inscripción)
- **Vista:** Generación de páginas HTML para visualización de datos
- **Controlador:** Lógica de negocio y coordinación entre capas
- **Base de Datos Simulada:** Almacenamiento en memoria con ArrayList

## Funcionalidades

- ✓ Registro de estudiantes con información personal
- ✓ Creación y gestión de cursos disponibles
- ✓ Inscripción de estudiantes en cursos
- ✓ Visualización de datos en formato HTML
- ✓ Arquitectura escalable y mantenible siguiendo MVC
- ✓ Validación de datos básica

## Ejemplo de Uso

Al ejecutar el programa, se registran estudiantes, cursos e inscripciones a través del controlador. El sistema genera automáticamente una página HTML mostrando todas las inscripciones registradas en el sistema.

## Autor

**Marvin Chiroy Lopreto**
Estudiante de Ingeniería en Sistemas
Universidad Mariano Gálvez de Guatemala

## Licencia

Proyecto académico - Universidad Mariano Gálvez de Guatemala © 2024
