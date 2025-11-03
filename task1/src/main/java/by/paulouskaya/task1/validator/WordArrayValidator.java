package by.paulouskaya.task1.validator;

import by.paulouskaya.task1.entity.WordArray;

public interface WordArrayValidator {
	
	public static final String WORDS_VALID_SYMBOLS = "\\p{L}+";
	
	public boolean isWordArrayCorrect(WordArray wordArray);
}
