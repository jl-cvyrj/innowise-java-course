package by.paulouskaya.task1.parser;

import java.util.List;

public interface WordArrayParser {
	
	String WORDS_DATA_REGEX = "[ ;,./|\\\\!?]+";
	
	public List<String[]> parseText (List<String> listString);
}
