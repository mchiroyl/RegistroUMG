# Sistema de Registro de Estudiantes UMG

Sistema de inscripción de estudiantes desarrollado con Java siguiendo el patrón de diseño MVC (Modelo-Vista-Controlador).

## Información del Proyecto

- **Estudiante:** Marvin Chiroy Lopreto
- **Carnet:** 2890-22-20336
- **Curso:** Análisis de Sistema II
- **Código del Curso:** 2890

## Tecnologías

- Java 11
- Maven 3.x
- Patrón MVC

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

El sistema permite registrar inscripciones de estudiantes a cursos. Implementa:

- **Modelo:** Entidades de dominio (Estudiante, Curso, Inscripción)
- **Vista:** Simulación de interfaz HTML
- **Controlador:** Lógica de negocio y coordinación
- **Base de Datos Simulada:** Almacenamiento en memoria con ArrayList

## Licencia

Proyecto académico - Universidad Mariano Gálvez de Guatemala
