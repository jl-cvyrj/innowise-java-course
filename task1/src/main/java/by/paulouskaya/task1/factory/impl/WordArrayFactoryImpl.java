package by.paulouskaya.task1.factory.impl;

import by.paulouskaya.task1.entity.WordArray;
import by.paulouskaya.task1.factory.WordArrayFactory;

public class WordArrayFactoryImpl implements WordArrayFactory {
    
    private static final String DEFAULT_DELIMITER = "[\\s ;,./|\\\\!?]+";
    
    @Override
    public WordArray createEmptyWordArray() {
        return new WordArray();
    }
    
    @Override
    public WordArray createWordArrayFromString(String text) {
        if (text == null || text.isBlank()) {
            return createEmptyWordArray();
        }
        
        WordArray wordArray = new WordArray();
        String[] words = text.split(DEFAULT_DELIMITER);
        
        for (String word : words) {
            if (!word.isBlank()) {
                wordArray.addWord(word.trim());
            }
        }
        
        return wordArray;
    }
    
    @Override
    public WordArray createWordArrayFromArray(String[] words) {
        WordArray wordArray = new WordArray();
        
        if (words != null) {
            for (String word : words) {
                if (word != null && !word.isBlank()) {
                    wordArray.addWord(word.trim());
                }
            }
        }
        
        return wordArray;
    }
    
    @Override
    public WordArray createWordArrayFromText(String text, String delimiter) {
        if (text == null || text.isBlank()) {
            return createEmptyWordArray();
        }
        
        WordArray wordArray = new WordArray();
        String[] words = text.split(delimiter);
        
        for (String word : words) {
            if (!word.isBlank()) {
                wordArray.addWord(word.trim());
            }
        }
        
        return wordArray;
    }
}