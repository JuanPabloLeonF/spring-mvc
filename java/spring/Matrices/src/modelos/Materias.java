package modelos;

public class Materias {
    
    private String nombre;
    private Double notas;

    public Materias() {
    }

    public Materias(String nombre, Double notas) {
        this.nombre = nombre;
        this.notas = notas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getNotas() {
        return notas;
    }

    public void setNotas(Double notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "Materias{" + "nombre=" + nombre + ", notas=" + notas + '}';
    }
}
