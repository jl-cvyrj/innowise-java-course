package by.paulouskaya.task1.repository;

import java.util.Comparator;
import java.util.List;

import by.paulouskaya.task1.entity.WordArray;
import by.paulouskaya.task1.exception.WordArrayException;

public interface WordArrayRepository {
	
	public boolean addWordArray(WordArray wordArray);
	public boolean deleteWordArray(WordArray wordArray);
	public List<WordArray> query (Specification specification) throws WordArrayException;
	public void sortWordArray(Comparator<? super WordArray> c);
	
}

