package by.paulouskaya.task1.service.impl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import by.paulouskaya.task1.entity.WordArray;
import by.paulouskaya.task1.exception.WordArrayException;
import by.paulouskaya.task1.factory.impl.WordArrayFactoryImpl;

public class WordArrayServiceTest {

    final WordArrayServiceImpl serviceWordArray = new WordArrayServiceImpl();
    final WordArrayFactoryImpl factoryWordArray = new WordArrayFactoryImpl();

    @Test
    public void testFindMaxWord() throws WordArrayException {
        String[] words = new String[] {"apple", "banana", "kiwi"};
        WordArray wordArray = factoryWordArray.createWordArrayFromArray(words);
        String expected = "banana";
        String actual = serviceWordArray.findMaxWord(wordArray);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindMaxWordWithOneWord() throws WordArrayException {
        String[] words = new String[] {"single"};
        WordArray wordArray = factoryWordArray.createWordArrayFromArray(words);
        String expected = "single";
        String actual = serviceWordArray.findMaxWord(wordArray);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindMaxWordWithEmptyArray() {
        WordArray wordArray = factoryWordArray.createWordArrayFromArray(new String[]{});
        try {
            serviceWordArray.findMaxWord(wordArray);
            fail("WordArrayException expected");
        } catch (WordArrayException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testFindMinWord() throws WordArrayException {
        String[] words = new String[] {"apple", "banana", "kiwi"};
        WordArray wordArray = factoryWordArray.createWordArrayFromArray(words);
        String expected = "kiwi";
        String actual = serviceWordArray.findMinWord(wordArray);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindMinWordWithSameLength() throws WordArrayException {
        String[] words = new String[] {"cat", "dog", "fox"};
        WordArray wordArray = factoryWordArray.createWordArrayFromArray(words);
        String expected = "cat";
        String actual = serviceWordArray.findMinWord(wordArray);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testFindMinWordWithEmptyArray() {
        WordArray wordArray = factoryWordArray.createWordArrayFromArray(new String[]{});
        try {
            serviceWordArray.findMinWord(wordArray);            
            fail("WordArrayException expected");
        } catch (WordArrayException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testReplaceIfOneSymb() throws WordArrayException {
        String[] words = new String[] {"a", "hello", "b", "world"};
        WordArray wordArray = factoryWordArray.createWordArrayFromArray(words);
        
        serviceWordArray.replaceIfOneSymb(wordArray);
        
        String[] expected = new String[] {"aa", "hello", "bb", "world"};
        String[] actual = wordArray.getWords();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testReplaceIfOneSymbNoSingleCharWords() throws WordArrayException {
        String[] words = new String[] {"hello", "world"};
        WordArray wordArray = factoryWordArray.createWordArrayFromArray(words);
        
        serviceWordArray.replaceIfOneSymb(wordArray);
        
        String[] expected = new String[] {"hello", "world"};
        String[] actual = wordArray.getWords();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindMediumWord() throws WordArrayException {
        String[] words = new String[] {"a", "cat", "elephant"};
        WordArray wordArray = factoryWordArray.createWordArrayFromArray(words);
        String expected = "cat";
        String actual = serviceWordArray.findMediumWord(wordArray);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindMediumWordWithEvenCount() throws WordArrayException {
        String[] words = new String[] {"a", "be", "cat", "deer"};
        WordArray wordArray = factoryWordArray.createWordArrayFromArray(words);
        String expected = "cat";
        String actual = serviceWordArray.findMediumWord(wordArray);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testFindMediumWordWithEmptyArray() {
        WordArray wordArray = factoryWordArray.createWordArrayFromArray(new String[]{});
        try {
            serviceWordArray.findMediumWord(wordArray);
            fail("WordArrayException expected");
        } catch (WordArrayException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testSumWords() throws WordArrayException {
        String[] words = new String[] {"Hello", "World", "!"};
        WordArray wordArray = factoryWordArray.createWordArrayFromArray(words);
        String expected = "Hello World !";
        String actual = serviceWordArray.sumWords(wordArray);
        assertEquals(expected, actual);
    }

    @Test
    public void testSumWordsSingleWord() throws WordArrayException {
        String[] words = new String[] {"Alone"};
        WordArray wordArray = factoryWordArray.createWordArrayFromArray(words);
        String expected = "Alone";
        String actual = serviceWordArray.sumWords(wordArray);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSumWordWithEmptyArray() {
        WordArray wordArray = factoryWordArray.createWordArrayFromArray(new String[]{});
        try {
            serviceWordArray.sumWords(wordArray);
            fail("WordArrayException expected");
        } catch (WordArrayException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testCountPositiveWords() {
        String[] words = new String[] {"apple", "orange", "banana", "umbrella", "cherry"};
        WordArray wordArray = factoryWordArray.createWordArrayFromArray(words);
        int expected = 3;
        int actual = serviceWordArray.countPositiveWords(wordArray);
        assertEquals(expected, actual);
    }

    @Test
    public void testCountPositiveWordsEmpty() {
        WordArray wordArray = factoryWordArray.createWordArrayFromArray(new String[]{});
        int expected = 0;
        int actual = serviceWordArray.countPositiveWords(wordArray);
        assertEquals(expected, actual);
    }

    @Test
    public void testCountNegativeWords() {
        String[] words = new String[] {"apple", "banana", "cherry", "dog", "elephant"};
        WordArray wordArray = factoryWordArray.createWordArrayFromArray(words);
        int expected = 3;
        int actual = serviceWordArray.countNegativeWords(wordArray);
        assertEquals(expected, actual);
    }

    @Test
    public void testCountNegativeWordsCaseSensitive() {
        String[] words = new String[] {"Apple", "banana"};
        WordArray wordArray = factoryWordArray.createWordArrayFromArray(words);
        int expected = 1;
        int actual = serviceWordArray.countNegativeWords(wordArray);
        assertEquals(expected, actual);
    }
}