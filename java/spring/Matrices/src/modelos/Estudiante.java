package modelos;

public class Estudiante {

    private String nombre;
    private Materias materia;

    public Estudiante() {
    }

    public Estudiante(String nombre, Materias materia) {
        this.nombre = nombre;
        this.materia = materia;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Materias getMateria() {
        return materia;
    }

    public void setMateria(Materias materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "nombre=" + nombre + ", materia=" + materia + '}';
    } 
}
