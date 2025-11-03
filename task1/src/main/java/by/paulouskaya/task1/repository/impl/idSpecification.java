package by.paulouskaya.task1.repository.impl;

import by.paulouskaya.task1.entity.WordArray;
import by.paulouskaya.task1.repository.Specification;

public class idSpecification implements Specification {
	
	private long id;
	
	public idSpecification(long id) {
		this.id = id;
	}

	@Override
	public boolean specify(WordArray wordarray) {
		return id == wordarray.getId();
	}

}
