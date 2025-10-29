package by.paulouskaya.task1.service.impl;

import java.util.Arrays;
import by.paulouskaya.task1.comparator.WordLengthComparator;
import by.paulouskaya.task1.entity.WordArray;
import by.paulouskaya.task1.service.WordArrayService;
import by.paulouskaya.task1.exception.WordArrayException;

public class WordArrayServiceImpl implements WordArrayService {

	public String findMaxWord(WordArray wordArray) throws WordArrayException {
		
		String[] allWords = wordArray.getWords();
		if (allWords.length == 0) {
			throw new WordArrayException("array is empty");
		}
		
		String firstWord = allWords[0];
		String maxWord = firstWord;
		int maxWordLength = firstWord.length();
		for (String currentWord : allWords) {
			int currentWordLenght = currentWord.length();
			if (currentWordLenght > maxWordLength) {
				maxWordLength = currentWordLenght;
				maxWord = currentWord;
			}
		}
		return maxWord;
	}
	
	public String findMinWord(WordArray wordArray) throws WordArrayException {
		
		String[] allWords = wordArray.getWords();
		if (allWords.length == 0) {
			throw new WordArrayException("array is empty");
		}
		
		String firstWord = allWords[0];
		String minWord = firstWord;
		int minWordLength = firstWord.length();
		for (String currentWord : allWords) {
			int currentWordLenght = currentWord.length();
			if (currentWordLenght < minWordLength) {
				minWordLength = currentWordLenght;
				minWord = currentWord;
			}
		}
		return minWord;
	}
	
	//replace word from 1 symbol with a word with 2 same symbols
	public void replaceIfOneSymb(WordArray wordArray) throws WordArrayException {
		
		String[] allWords = wordArray.getWords();
		if (allWords.length == 0) {
			throw new WordArrayException("array is empty");
		}
		
		for (int i = 0; i < allWords.length; i++) {
			if (allWords[i].length() == 1) {
				allWords[i] += allWords[i];
			}
		}
		wordArray.setWords(allWords);
	}
	
	public String findMediumWord(WordArray wordArray) throws WordArrayException {
		
		String[] allWords = wordArray.getWords();
		if (allWords.length == 0) {
			throw new WordArrayException("array is empty");
		}
		
		String[] sortedWords = allWords;
		Arrays.sort(sortedWords, new WordLengthComparator());
		int mediumPos = sortedWords.length / 2;
		return sortedWords[mediumPos];
	}
	
	public String sumWords(WordArray wordArray) throws WordArrayException {
		
		String[] allWords = wordArray.getWords();
		if (allWords.length == 0) {
			throw new WordArrayException("array is empty");
		}
		
		String text = "";
		for (String word : wordArray.getWords()) {
			text += word;
			text += " ";
		}
		return text;
	}
	
	static final char[] positive = {'a', 'e', 'i', 'o', 'u', 'y'};
	static final char[] negative = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 
			'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z'};
	
	public int countPositiveWords(WordArray wordArray) {
		int positiveWords = 0;
		String[] words = wordArray.getWords();
		for (String word : words) {
			char[] wordChars = word.toCharArray();
			for (char symb : positive) {
				if (wordChars[0] == symb) {
					positiveWords ++;
				}
			}
		}
		return positiveWords;
	}
	
	public int countNegativeWords(WordArray wordArray) {
		int negativeWords = 0;
		String[] words = wordArray.getWords();
		for (String word : words) {
			char[] wordChars = word.toCharArray();
			for (char symb : negative) {
				if (wordChars[0] == symb) {
					negativeWords ++;
				}
			}
		}
		return negativeWords;
	}
}
