package by.paulouskaya.task1.observer.impl;

import by.paulouskaya.task1.entity.WordArray;
import by.paulouskaya.task1.entity.WordArrayParameters;
import by.paulouskaya.task1.exception.WordArrayException;
import by.paulouskaya.task1.observer.WordArrayObserver;
import by.paulouskaya.task1.warehouse.WordArrayWarehouse;

public class WordArrayObserverImpl implements WordArrayObserver{

	@Override
	public void wordArrayUpdate(WordArray wordArray) throws WordArrayException {
		WordArrayWarehouse warehouse = WordArrayWarehouse.getInstance();
		WordArrayParameters parameters = new WordArrayParameters(wordArray);
		warehouse.put(wordArray.getId(), parameters);
	}

}
