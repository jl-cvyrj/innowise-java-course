package by.paulouskaya.task1.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import by.paulouskaya.task1.exception.WordArrayException;
import by.paulouskaya.task1.factory.impl.WordArrayFactoryImpl;

public class WordArrayTest {
	
    final WordArrayFactoryImpl factoryWordArray = new WordArrayFactoryImpl(); 
	
	@Test
    public void testAddWord() throws WordArrayException {
        WordArray wordArray = factoryWordArray.createEmptyWordArray();
        
        wordArray.addWord("hello");
        wordArray.addWord("world");
        
        int expected = 2;
        int actual = wordArray.getSize();
        assertEquals(expected, actual);
    }
	
	@Test
	public void testGetWords() throws WordArrayException {
        WordArray wordArray = factoryWordArray.createEmptyWordArray();
	    
	    wordArray.addWord("hello");
	    wordArray.addWord("world");
	    
	    String[] expected = new String[]{"hello", "world"};
	    String[] actual = wordArray.getWords();
	    assertArrayEquals(expected, actual);
	}
	
}
