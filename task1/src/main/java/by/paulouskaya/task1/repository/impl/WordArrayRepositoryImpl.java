package by.paulouskaya.task1.repository.impl;

import java.util.ArrayList;
import java.util.List;

import by.paulouskaya.task1.entity.WordArray;
import by.paulouskaya.task1.exception.WordArrayException;

import java.util.Comparator;
import by.paulouskaya.task1.repository.Specification;
import by.paulouskaya.task1.repository.WordArrayRepository;

public class WordArrayRepositoryImpl implements WordArrayRepository{
	
	private List<WordArray> wordArrays = new ArrayList<>();

	@Override
	public boolean addWordArray(WordArray wordArray) {
		return wordArrays.add(wordArray);
	}

	@Override
	public boolean deleteWordArray(WordArray wordArray) {
		return wordArrays.remove(wordArray);
	}

	@Override
	public void sortWordArray(Comparator<? super WordArray> comparator) {
		wordArrays.sort(comparator);
	}

	@Override
	public List<WordArray> query(Specification specification) throws WordArrayException {
		List<WordArray> list = new ArrayList<>();
		for (WordArray current : wordArrays) {
			if(specification.specify(current)) {
				list.add(current);			}
		}
		return list;
	}

}
