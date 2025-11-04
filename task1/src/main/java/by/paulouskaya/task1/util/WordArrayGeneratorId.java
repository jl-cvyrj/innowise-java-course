package by.paulouskaya.task1.util;

public class WordArrayGeneratorId {
	
	public static long nextId = 1;
	public long generateId() {
		return nextId++;
	}
}
