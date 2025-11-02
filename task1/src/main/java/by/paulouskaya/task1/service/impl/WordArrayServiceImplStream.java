package by.paulouskaya.task1.service.impl;

import java.util.Arrays;
import java.util.Comparator;
import by.paulouskaya.task1.entity.WordArray;
import by.paulouskaya.task1.service.WordArrayService;
import by.paulouskaya.task1.exception.WordArrayException;

public class WordArrayServiceImplStream implements WordArrayService {

    public String findMaxWord(WordArray wordArray) throws WordArrayException {
        return Arrays.stream(wordArray.getWords())
                .max(Comparator.comparingInt(String::length))
                .orElseThrow(() -> new WordArrayException("array is empty"));
    }
    
    public String findMinWord(WordArray wordArray) throws WordArrayException {
        return Arrays.stream(wordArray.getWords())
                .min(Comparator.comparingInt(String::length))
                .orElseThrow(() -> new WordArrayException("array is empty"));
    }
    
    //replace word from 1 symbol with a word with 2 same symbols
    public void replaceIfOneSymb(WordArray wordArray) throws WordArrayException {
        String[] words = wordArray.getWords();
        if (words.length == 0) {
            throw new WordArrayException("array is empty");
        }
        
        String[] replacedWords = Arrays.stream(words)
                .map(word -> word.length() == 1 ? word + word : word)
                .toArray(String[]::new);
        wordArray.setWords(replacedWords);
    }
    
    public String findMediumWord(WordArray wordArray) throws WordArrayException {
        String[] words = wordArray.getWords();
        if (words.length == 0) {
            throw new WordArrayException("array is empty");
        }
        
        return Arrays.stream(words)
                .sorted(Comparator.comparingInt(String::length))
                .skip(words.length / 2)
                .findFirst()
                .orElseThrow(() -> new WordArrayException("array is empty"));
    }
    
    public String sumWords(WordArray wordArray) throws WordArrayException {
        String[] words = wordArray.getWords();
        if (words.length == 0) {
            throw new WordArrayException("array is empty");
        }
        
        return Arrays.stream(words)
                .reduce((word1, word2) -> word1 + " " + word2)
                .orElse("");
    }
    
    static final String POSITIVE_STR = "aeiouy";
    static final String NEGATIVE_STR = "bcdfghjklmnpqrstvwxz";
    
    public int countPositiveWords(WordArray wordArray) {
        return (int) Arrays.stream(wordArray.getWords())
                .filter(word -> !word.isEmpty())
                .map(word -> Character.toLowerCase(word.charAt(0)))
                .filter(character -> POSITIVE_STR.contains(String.valueOf(character)))
                .count();
    }
    
    public int countNegativeWords(WordArray wordArray) {
        return (int) Arrays.stream(wordArray.getWords())
                .filter(word -> !word.isEmpty())
                .map(word -> Character.toLowerCase(word.charAt(0)))
                .filter(character -> NEGATIVE_STR.contains(String.valueOf(character)))
                .count();
    }
    
}