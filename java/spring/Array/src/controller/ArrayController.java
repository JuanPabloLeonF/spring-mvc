package controller;

import service.IArrayService;
import service.implementation.ArrayServiceImplementation;

public class ArrayController {
    
    private final IArrayService iArrayService;
    
    public ArrayController() {
        this.iArrayService = new ArrayServiceImplementation();
    }
    
    public Integer[] insertElement(Integer[] array) {
        return iArrayService.insertElement(array);
    }
    
    public Integer[] deleteElement(Integer[] array) {
        return iArrayService.deleteElement(array);
    }
}
