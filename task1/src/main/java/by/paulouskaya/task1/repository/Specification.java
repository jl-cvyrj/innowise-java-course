package by.paulouskaya.task1.repository;

import by.paulouskaya.task1.entity.WordArray;
import by.paulouskaya.task1.exception.WordArrayException;

public interface Specification {

	public boolean specify(WordArray wordArray) throws WordArrayException;
}

