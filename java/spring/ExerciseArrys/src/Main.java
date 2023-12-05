import controller.ArrayImplementation;
import controller.interfaces.IArrayImplement;

public class Main {
    public static void main(String[] args) {

        IArrayImplement iArrayImplement = new ArrayImplementation();

        Integer[] array = new Integer[5];

        Integer[] newArray = iArrayImplement.insertDataArray(array);
        System.out.println("########################################################3");
        iArrayImplement.deletePositionArray(newArray);
    }
}