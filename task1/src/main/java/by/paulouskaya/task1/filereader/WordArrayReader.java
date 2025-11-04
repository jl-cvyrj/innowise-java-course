package by.paulouskaya.task1.filereader;

import java.util.List;
import by.paulouskaya.task1.exception.WordArrayException;

public interface WordArrayReader {
	
	String WORDS_DATA_REGEX = "[ ;,./|\\\\!?]+";
	String DATA_DIRECTORY = "data";
	
	public List <String> readWordArrayFile(String path) throws WordArrayException;
}
