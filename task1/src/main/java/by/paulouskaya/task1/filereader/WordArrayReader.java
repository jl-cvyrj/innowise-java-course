package by.paulouskaya.task1.filereader;

import java.util.List;
import by.paulouskaya.task1.exception.WordArrayException;

public interface WordArrayReader {
	
	public static final String WORDS_DATA_REGEX = "[ ;,./|\\\\!?]+";
	
	public List <String> readFile(String path) throws WordArrayException;
}
