package service.implementation;

import array.persistence.ArrayImplementation;
import array.persistence.implementation.IArrayRepository;
import service.IArrayService;

public class ArrayServiceImplementation implements IArrayService{
    
    private final IArrayRepository iArrayRepository;

    public ArrayServiceImplementation() {
        this.iArrayRepository = new ArrayImplementation();
    }

    @Override
    public Integer[] insertElement(Integer[] array) {
        return iArrayRepository.insertElement(array);
    }

    @Override
    public Integer[] deleteElement(Integer[] array) {
        return iArrayRepository.deleteElement(array);
    }
    
}
