package by.paulouskaya.task1.repository.impl;

import by.paulouskaya.task1.entity.WordArray;
import by.paulouskaya.task1.exception.WordArrayException;
import by.paulouskaya.task1.repository.Specification;
import by.paulouskaya.task1.service.impl.WordArrayServiceImpl;

public class greaterMaxWordSpesificationImpl implements Specification {

	private int maxLength;
	private WordArrayServiceImpl wordArrayServiceImpl = new WordArrayServiceImpl();
	
	public greaterMaxWordSpesificationImpl(int maxLength) {
		this.maxLength = maxLength;
	}
	@Override
	public boolean specify(WordArray wordArray) throws WordArrayException {
		String maxWord = wordArrayServiceImpl.findMaxWord(wordArray);
	    return (maxWord.length() > maxLength);
	}
}
