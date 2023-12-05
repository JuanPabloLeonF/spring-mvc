package arrays;

import domain.ArrayModel;
import domain.Person;

public class Arrays {
    public static void main(String[] args) {
        
//        String[] array = new String[5];
//        ArrayModel.getNotesArry(array);
//        ArrayModel.showNotesArry(array);
        
        Person[] persons = new Person[2];
        
        ArrayModel.getNotesArry(persons);
        ArrayModel.showNotesArry(persons);
    }
}
