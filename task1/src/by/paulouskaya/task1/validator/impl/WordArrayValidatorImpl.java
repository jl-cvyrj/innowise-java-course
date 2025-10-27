package by.paulouskaya.task1.validator.impl;

import by.paulouskaya.task1.entity.WordArray;
import by.paulouskaya.task1.validator.WordArrayValidator;

public class WordArrayValidatorImpl implements WordArrayValidator {
	
	public boolean isWordArrayCorrect(WordArray wordArray) {
		String[] words = wordArray.getWords();
		if(words == null || words.length == 0) {
			return false;
		}
		return isWordArrayCorrect(words);
	}
	
	public boolean isWordArrayCorrect(String[] words) {
		
		if(words == null || words.length == 0) {
			return false;
		}
		
		for (String word : words) {
			if (!word.matches(WORDS_VALID_SYMBOLS)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isWordArrayCorrect(String text) {
		
		if(text == null || text.isBlank()) {
			return false;
		}
		
		String[] splitWords = text.split(WORDS_DATA_REGEX);
		return isWordArrayCorrect(splitWords);
	}
}
