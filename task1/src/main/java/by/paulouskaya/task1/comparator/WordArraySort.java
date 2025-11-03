package by.paulouskaya.task1.comparator;

import java.util.Comparator;

import by.paulouskaya.task1.entity.WordArray;

public class WordArraySort implements Comparator<WordArray> {

	@Override
	public int compare(WordArray o1, WordArray o2) {
		return o1.getSize() - o2.getSize();
	}
	

}
