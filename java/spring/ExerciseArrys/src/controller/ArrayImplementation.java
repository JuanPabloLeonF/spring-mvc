package controller;

import controller.interfaces.IArrayImplement;

import java.util.Scanner;

import static java.lang.System.out;

public class ArrayImplementation implements IArrayImplement {

    @Override
    public Integer[] insertDataArray(Integer[] array) {

        Scanner scannerData = new Scanner(System.in);

        for (int i = 0; i < array.length; i++) {
            out.print("Inserte el numero en el campo " + i + " :");
            array[i] = scannerData.nextInt();
        }

        //scannerData.close();
        return array;
    }

    @Override
    public Integer[] deletePositionArray(Integer[] array) {

        Scanner scannerPositionDelete = new Scanner(System.in);

        showArray(array);

        out.print("Digite el numero de la posicion que desea eliminar: ");
        Integer positionDelete = scannerPositionDelete.nextInt();

        if (!validationArray(positionDelete, array)) {
            return array;
        }

        Integer[] newArray = new Integer[array.length - 1];

        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != positionDelete) {
                newArray[j++] = array[i];
            }
        }

        showArray(newArray);

        scannerPositionDelete.close();

        return newArray;
    }

    private static void showArray(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            out.println("Posicion: " + i + " elemento = " + array[i]);
        }
    }

    private static Boolean validationArray(Integer positionDelete, Integer[] array) {
        if (positionDelete >= array.length || positionDelete < 0) {
            out.println("Lo siento la posicion es invalida");
            return false;
        }
        return false;
    }
}
