package by.paulouskaya.task1.comparator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlphabeticalComparatorTest {
	
	final AlphabeticalComparator alphabeticalComparator = new AlphabeticalComparator();
	
	@Test
	public void testAlphabeticalComparatorCompare_rightOrder() {
		String word1 = "action";
		String word2 = "celebrate";
		int expected = -1;
		int actual = alphabeticalComparator.compare(word1, word2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testAlphabeticalComparatorCompare_sameWords() {
		String word1 = "moon";
		String word2 = "moon";
		int expected = 0;
		int actual = alphabeticalComparator.compare(word1, word2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testAlphabeticalComparatorCompare_reverseOrder() {
		String word1 = "wings";
		String word2 = "sunny";
		int expected = 1;
		int actual = alphabeticalComparator.compare(word1, word2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testAlphabeticalComparatorCompare_oneEmptyString() {
		String word1 = "";
		String word2 = "celebrate";
		int expected = -1;
		int actual = alphabeticalComparator.compare(word1, word2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testAlphabeticalComparatorCompare_twoEmptyString() {
		String word1 = "";
		String word2 = "";
		int expected = 0;
		int actual = alphabeticalComparator.compare(word1, word2);
		assertEquals(expected, actual);
	}
}
