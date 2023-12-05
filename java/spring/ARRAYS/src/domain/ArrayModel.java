package domain;

import java.util.Scanner;

public class ArrayModel {

    public static void getNotesArry(Person[] persons) {

        Scanner scannerId = new Scanner(System.in);
        Scanner scannerName = new Scanner(System.in);
        Scanner scannerNotes = new Scanner(System.in);
        Scanner scannerLongitudNotes = new Scanner(System.in);
        
        System.out.print("Digite el numero de notas: ");
        Integer longNotes = scannerLongitudNotes.nextInt();
        Double[] notes = new Double[longNotes];

        for (int i = 0; i < persons.length; i++) {

            System.out.println("digite el id: ");
            Long id = scannerId.nextLong();
            System.out.println("digite el nombre: ");
            String name = scannerName.nextLine();

            if (notes.length == longNotes) {
                for (int j = 0; j < notes.length; j++) {

                    System.out.print("digite la nota numero " + j + " :");
                    notes[j] = scannerNotes.nextDouble();
                }
            }

            persons[i] = new Person(id, name, notes);
        }
    }

    public static void showNotesArry(Person[] persons) {
        for (Person person : persons) {
            System.out.print("Persona = [" + " id: "+ person.getIdPerson() + " Nombre: " + person.getName());
            getNotesPerson(person);
        } 
    }
    
    private static void getNotesPerson(Person persons) {
        
        for (Double note : persons.getNotes()) {
            System.out.println(" [Notas = " + note + " ] ]");
        }
    }
}
