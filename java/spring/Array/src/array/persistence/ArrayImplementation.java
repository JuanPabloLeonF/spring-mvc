package array.persistence;

import array.persistence.implementation.IArrayRepository;
import java.util.Scanner;

public class ArrayImplementation implements IArrayRepository {

    @Override
    public Integer[] insertElement(Integer[] array) {

        Scanner scannerElement = new Scanner(System.in);

        for (int i = 0; i < array.length; i++) {
            System.out.print("Digite el elemento: ");
            array[i] = scannerElement.nextInt();
        }
        return array;
    }

    @Override
    public Integer[] deleteElement(Integer[] array) {
        
        showArray(array);
        
        Scanner scannerPosition = new Scanner(System.in);
        
        System.out.print("Digite la posicion que deseas eliminar: ");
        Integer deletePosition = scannerPosition.nextInt();
        
        if (deletePosition < 0 || deletePosition >= array.length) {
            System.out.println("Posicion no existe en el array.");
            return array;
        }

        Integer[] newArray = new Integer[array.length - 1];

        for (int i = 0, j = 0; i < array.length; i++) {

            if (i != deletePosition) {
                newArray[j++] = array[i];
            }
        } 
        showArray(newArray);
        
        return newArray;
    }
    
    private static void showArray(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Posicion: " + i + " elemento = " + array[i]);
        }
    }
}
