package by.paulouskaya.task1.comparator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReverseAlphabeticalComparatorTest {
	
	final ReverseAlphabeticalComparator reverseAlphabeticalComparator = new ReverseAlphabeticalComparator();
	
	@Test
	public void testReverseAlphabeticalComparatorCompare_reverseOrder() {
		String word1 = "action";
		String word2 = "celebrate";
		int expected = 1;
		int actual = reverseAlphabeticalComparator.compare(word1, word2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testReverseAlphabeticalComparatorCompare_sameWords() {
		String word1 = "moon";
		String word2 = "moon";
		int expected = 0;
		int actual = reverseAlphabeticalComparator.compare(word1, word2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testReverseAlphabeticalComparatorCompare_rightOrder() {
		String word1 = "wings";
		String word2 = "sunny";
		int expected = -1;
		int actual = reverseAlphabeticalComparator.compare(word1, word2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testReverseAlphabeticalComparatorCompare_oneEmptyString() {
		String word1 = "";
		String word2 = "celebrate";
		int expected = 1;
		int actual = reverseAlphabeticalComparator.compare(word1, word2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testReverseAlphabeticalComparatorCompare_twoEmptyString() {
		String word1 = "";
		String word2 = "";
		int expected = 0;
		int actual = reverseAlphabeticalComparator.compare(word1, word2);
		assertEquals(expected, actual);
	}
}
