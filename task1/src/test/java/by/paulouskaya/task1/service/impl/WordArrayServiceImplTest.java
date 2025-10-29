package by.paulouskaya.task1.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import by.paulouskaya.task1.entity.WordArray;
import by.paulouskaya.task1.exception.WordArrayException;

public class WordArrayServiceImplTest {

    private WordArrayServiceImpl service;
    private WordArray wordArray;

    @BeforeEach
    public void setUp() {
        service = new WordArrayServiceImpl();
        wordArray = new WordArray();
    }

    @Test
    public void testFindMaxWord() throws WordArrayException {
        wordArray.addWord("apple");
        wordArray.addWord("banana");
        wordArray.addWord("kiwi");

        String result = service.findMaxWord(wordArray);

        assertEquals("banana", result);
    }

    @Test
    public void testFindMaxWordWithOneWord() throws WordArrayException {
        wordArray.addWord("single");

        String result = service.findMaxWord(wordArray);

        assertEquals("single", result);
    }

    @Test
    public void testFindMaxWordWithEmptyArray() {
        assertThrows(WordArrayException.class, () -> {
            service.findMaxWord(wordArray);
        });
    }

    @Test
    public void testFindMinWord() throws WordArrayException {
        wordArray.addWord("apple");
        wordArray.addWord("banana");
        wordArray.addWord("kiwi");

        String result = service.findMinWord(wordArray);

        assertEquals("kiwi", result);
    }

    @Test
    public void testFindMinWordWithSameLength() throws WordArrayException {
        wordArray.addWord("cat");
        wordArray.addWord("dog");
        wordArray.addWord("fox");

        String result = service.findMinWord(wordArray);

        assertEquals("cat", result);
    }

    @Test
    public void testReplaceIfOneSymb() throws WordArrayException {
        wordArray.addWord("a");
        wordArray.addWord("hello");
        wordArray.addWord("b");
        wordArray.addWord("world");

        service.replaceIfOneSymb(wordArray);

        String[] words = wordArray.getWords();
        assertEquals("aa", words[0]);
        assertEquals("hello", words[1]);
        assertEquals("bb", words[2]);
        assertEquals("world", words[3]);
    }

    @Test
    public void testReplaceIfOneSymbNoSingleCharWords() throws WordArrayException {
        wordArray.addWord("hello");
        wordArray.addWord("world");

        service.replaceIfOneSymb(wordArray);

        String[] words = wordArray.getWords();
        assertEquals("hello", words[0]);
        assertEquals("world", words[1]);
    }

    @Test
    public void testFindMediumWord() throws WordArrayException {
        wordArray.addWord("a");       
        wordArray.addWord("cat");     
        wordArray.addWord("elephant"); 

        String result = service.findMediumWord(wordArray);

        assertEquals("cat", result);
    }

    @Test
    public void testFindMediumWordWithEvenCount() throws WordArrayException {
        wordArray.addWord("a");      
        wordArray.addWord("be");     
        wordArray.addWord("cat");  
        wordArray.addWord("deer");   

        String result = service.findMediumWord(wordArray);

        assertEquals("cat", result);
    }

    @Test
    public void testSumWords() throws WordArrayException {
        wordArray.addWord("Hello");
        wordArray.addWord("World");
        wordArray.addWord("!");

        String result = service.sumWords(wordArray);

        assertEquals("Hello World ! ", result);
    }

    @Test
    public void testSumWordsSingleWord() throws WordArrayException {
        wordArray.addWord("Alone");

        String result = service.sumWords(wordArray);

        assertEquals("Alone ", result);
    }

    @Test
    public void testCountPositiveWords() {
        wordArray.addWord("apple");  
        wordArray.addWord("orange");  
        wordArray.addWord("banana");  
        wordArray.addWord("umbrella");
        wordArray.addWord("cherry");  

        int result = service.countPositiveWords(wordArray);

        assertEquals(3, result); 
    }

    @Test
    public void testCountPositiveWordsEmpty() {

        int result = service.countPositiveWords(wordArray);

        assertEquals(0, result);
    }

    @Test
    public void testCountNegativeWords() {
        wordArray.addWord("apple");   
        wordArray.addWord("banana"); 
        wordArray.addWord("cherry");  
        wordArray.addWord("dog");    
        wordArray.addWord("elephant");

        int result = service.countNegativeWords(wordArray);

        assertEquals(3, result);
    }

    @Test
    public void testCountNegativeWordsCaseSensitive() {
        wordArray.addWord("Apple");   
        wordArray.addWord("banana"); 

        int result = service.countNegativeWords(wordArray);

        assertEquals(1, result); 
    }
}