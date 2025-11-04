package by.paulouskaya.task1.util;

public class WordArrayGeneratorId {
	
	public static long nextId = 1;
	public synchronized long generateId() {
		return nextId++;
	}
}
