package modelo;

public class Estudiante {
    private String nombre;
    private String carnet;

    public Estudiante(String nombre, String carnet) {
        this.nombre = nombre;
        this.carnet = carnet;
    }

    public String getNombre() { return nombre; }
    public String getCarnet() { return carnet; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCarnet(String carnet) { this.carnet = carnet; }
}