package Model;

public class Vehiculo {
    private String nombre;
    private int anio;
    private double precio;
    private double kilometros;
    private String color;
    private String marca;
    public Vehiculo(String nombre, int anio, double precio, double kilometros, String color, String marca) {
        this.nombre = nombre;
        this.anio = anio;
        this.precio = precio;
        this.kilometros = kilometros;
        this.color = color;
        this.marca = marca;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getAnio() {
        return anio;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public double getKilometros() {
        return kilometros;
    }
    public void setKilometros(double kilometros) {
        this.kilometros = kilometros;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
}
