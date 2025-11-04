package by.paulouskaya.task1.observer;

import by.paulouskaya.task1.entity.WordArray;
import by.paulouskaya.task1.exception.WordArrayException;

public interface WordArrayObserver {
	void wordArrayUpdate(WordArray wordArray) throws WordArrayException;
}
