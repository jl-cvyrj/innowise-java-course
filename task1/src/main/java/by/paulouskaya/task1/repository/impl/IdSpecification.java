package by.paulouskaya.task1.repository.impl;

import by.paulouskaya.task1.entity.WordArray;
import by.paulouskaya.task1.repository.WordArraySpecification;

public class IdSpecification implements WordArraySpecification {
	
	private long id;
	
	public IdSpecification(long id) {
		this.id = id;
	}

	@Override
	public boolean specify(WordArray wordarray) {
		return id == wordarray.getId();
	}

}
