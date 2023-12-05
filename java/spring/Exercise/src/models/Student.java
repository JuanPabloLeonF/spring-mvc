package models;

public class Student {
    
    private String nameStudent;
    private Materia materia;

    public Student() {
    }

    public Student(String nameStudent, Materia materia) {
        this.nameStudent = nameStudent;
        this.materia = materia;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Student{" + "nameStudent=" + nameStudent + ", materia=" + materia + '}';
    }
}
