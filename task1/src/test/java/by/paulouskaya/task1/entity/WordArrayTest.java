package by.paulouskaya.task1.entity;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import by.paulouskaya.task1.entity.WordArray;
import by.paulouskaya.task1.exception.WordArrayException;

public class WordArrayTest {
	
	@Test
	public void testAddWord(String word) {
		 WordArray wordArray = new WordArray();
		 
		 wordArray.addWord("hello");
		 wordArray.addWord("world");
		    
		 assertEquals(2, wordArray.getSize());
		 assertArrayEquals(new String[]{"hello", "world"}, wordArray.getWords());
	}
}
