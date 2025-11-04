package by.paulouskaya.task1.factory;

import by.paulouskaya.task1.entity.WordArray;
import by.paulouskaya.task1.exception.WordArrayException;

public interface WordArrayFactory {
    
    WordArray createEmptyWordArray();
    
    WordArray createWordArrayFromArray(String[] words) throws WordArrayException;
    
}