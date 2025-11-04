package by.paulouskaya.task1.repository.impl;

import by.paulouskaya.task1.entity.WordArray;
import by.paulouskaya.task1.exception.WordArrayException;
import by.paulouskaya.task1.repository.WordArraySpecification;
import by.paulouskaya.task1.service.impl.WordArrayServiceImpl;

public class IntervalMediumWordSpesificationImpl implements WordArraySpecification {

	private long minMediumWord, maxMediumWord;
	private WordArrayServiceImpl wordArrayServiceImpl = new WordArrayServiceImpl();
	
	public IntervalMediumWordSpesificationImpl(long min, long max) {
        this.minMediumWord = min;
        this.maxMediumWord = max;
    }
	
	@Override
	public boolean specify(WordArray wordarray) throws WordArrayException {
	    String mediumWord = wordArrayServiceImpl.findMediumWord(wordarray);
	    return (minMediumWord < mediumWord.length() && maxMediumWord > mediumWord.length());
	}

}
