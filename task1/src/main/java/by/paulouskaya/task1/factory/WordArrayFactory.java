package by.paulouskaya.task1.factory;

import by.paulouskaya.task1.entity.WordArray;

public interface WordArrayFactory {
    
    WordArray createEmptyWordArray();
    
    WordArray createWordArrayFromString(String text);
    
    WordArray createWordArrayFromArray(String[] words);
    
    WordArray createWordArrayFromText(String text, String delimiter);
}