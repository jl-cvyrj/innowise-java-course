package by.paulouskaya.task1.observer;

import by.paulouskaya.task1.exception.WordArrayException;
import by.paulouskaya.task1.observer.impl.WordArrayObserverImpl;

public interface WordArrayObservable {
	void attach(WordArrayObserverImpl observer) throws WordArrayException;
	void detach(WordArrayObserverImpl observer);
	void notifyObservers() throws WordArrayException;
}
