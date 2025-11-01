package by.paulouskaya.task1.comparator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WordLengthComparatorTest {
	
	final WordLengthComparator wordLengthComparator = new WordLengthComparator();
	
	@Test
	public void testWordLengthComparatorCompare_rightOrder() {
		String word1 = "i";
		String word2 = "celebrate";
		int expected = -1;
		int actual = wordLengthComparator.compare(word1, word2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testWordLengthComparatorCompare_sameLenght() {
		String word1 = "star";
		String word2 = "moon";
		int expected = 0;
		int actual = wordLengthComparator.compare(word1, word2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testAWordLengthComparatorCompare_reverseOrder() {
		String word1 = "programming";
		String word2 = "wings";
		int expected = 1;
		int actual = wordLengthComparator.compare(word1, word2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testWordLengthComparatorCompare_oneEmptyString() {
		String word1 = "";
		String word2 = "celebrate";
		int expected = -1;
		int actual = wordLengthComparator.compare(word1, word2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testAWordLengthComparatorCompare_twoEmptyString() {
		String word1 = "";
		String word2 = "";
		int expected = 0;
		int actual = wordLengthComparator.compare(word1, word2);
		assertEquals(expected, actual);
	}
}
