package controller;

import crud.IStudentController;
import models.Student;

public class StudentImplementation implements IStudentController{

    @Override
    public Double calculateParcent70(Student student) {
        
        Double result = 0.0;
        
        for (Double note: student.getMateria().getListNotes()) {
            result += note;
        }
       
        return (result*0.7)/student.getMateria().getListNotes().size();
    }

    @Override
    public Double calculateParcent30(Student student) {
        return student.getMateria().getFinalNote()*0.3;
    }
}
