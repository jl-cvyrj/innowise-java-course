package by.paulouskaya.task1.util.impl;

import by.paulouskaya.task1.util.WordArrayGeneratorId;

public class WordArrayGenerateIdImpl implements WordArrayGeneratorId {
	
	public static long nextId = 1;
	@Override
	public synchronized long generateId() {
		return nextId++;
	}
}
