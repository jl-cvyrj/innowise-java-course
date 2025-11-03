package by.paulouskaya.task1.repository.impl;

import by.paulouskaya.task1.entity.WordArray;
import by.paulouskaya.task1.repository.Specification;

public class intervalSizeSpecificationImpl implements Specification {
	
	private long minId, maxId;
	
	public intervalSizeSpecificationImpl(long minId, long maxId) {
		this.minId = minId;
		this.maxId = maxId;
	}

	@Override
	public boolean specify(WordArray wordArray) {
		return (minId < wordArray.getSize() && maxId > wordArray.getSize());
	}

}
