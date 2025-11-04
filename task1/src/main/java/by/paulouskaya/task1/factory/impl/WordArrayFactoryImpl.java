package by.paulouskaya.task1.factory.impl;

import by.paulouskaya.task1.entity.WordArray;
import by.paulouskaya.task1.exception.WordArrayException;
import by.paulouskaya.task1.factory.WordArrayFactory;

public class WordArrayFactoryImpl implements WordArrayFactory {
    
    @Override
    public WordArray createEmptyWordArray() {
        return new WordArray();
    }
    
    @Override
    public WordArray createWordArrayFromArray(String[] words) throws WordArrayException {
        WordArray wordArray = new WordArray();
        if (words != null) {
            for (String word : words) {
                if (word != null && !word.isBlank()) {
                    wordArray.addWord(word.trim());
                }
            }
        } else {
        	createEmptyWordArray();
        }
        return wordArray;
    }
}