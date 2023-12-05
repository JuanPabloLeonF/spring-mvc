
import controller.ArrayController;

public class Array {

    public static void main(String[] args) {
        
        ArrayController arrayController = new ArrayController();
        
        Integer[] array = new Integer[5];
        
        arrayController.insertElement(array);
        arrayController.deleteElement(array);
    } 
}
