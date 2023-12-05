
import controller.StudentImplementation;
import crud.IStudentController;
import java.util.ArrayList;
import java.util.List;
import models.Materia;
import models.Student;


public class Exercise {

    public static void main(String[] args) {
        
        List<Double> listNotes = new ArrayList<>();
        listNotes.add(3.0);
        listNotes.add(4.5);
        listNotes.add(5.0);
        
        
        Materia materia = new Materia("Español", listNotes, 4.5);
        
        Student student = new Student("Juan", materia);
        
        IStudentController iStudentController = new StudentImplementation();
        
        System.out.println("70% = " + iStudentController.calculateParcent70(student));
        System.out.println("30% = " + iStudentController.calculateParcent30(student));
    }   
}
