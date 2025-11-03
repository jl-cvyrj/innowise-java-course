package by.paulouskaya.task1.validator.impl;

import by.paulouskaya.task1.entity.WordArray;
import by.paulouskaya.task1.validator.WordArrayValidator;

public class WordArrayValidatorImpl implements WordArrayValidator {
	
	public boolean isWordArrayCorrect(WordArray wordArray) {
		String[] words = wordArray.getWords();
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
}