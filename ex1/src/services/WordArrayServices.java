package services;

import entity.WordArray;

import java.util.Arrays;
import comparators.WordLengthComparator;

public class WordArrayServices {
	
	private WordArray wordArray;
	
	public WordArrayServices(WordArray wordArray) {
		this.wordArray = wordArray;
	}
	
	public String findMaxWord() {
		String firstWord = wordArray.getWords()[0];
		String maxWord = firstWord;
		int maxWordLength = firstWord.length();
		for (String word : wordArray.getWords()) {
			int currentWordLenght = word.length();
			if (currentWordLenght > maxWordLength) {
				maxWordLength = currentWordLenght;
				maxWord = word;
			}
		}
		return maxWord;
	}
	
	public String findMinWord() {
		String firstWord = wordArray.getWords()[0];
		String minWord = firstWord;
		int minWordLength = firstWord.length();
		for (String word : wordArray.getWords()) {
			int currentWordLenght = word.length();
			if (currentWordLenght < minWordLength) {
				minWordLength = currentWordLenght;
				minWord = word;
			}
		}
		return minWord;
	}
	
	//replace word from 1 symbol with a word with 2 same symbols
	public void replaceIfOneSymb() {
		String[] words = wordArray.getWords();
		for (int i = 0; i < words.length; i++) {
			if (words[i].length() == 1) {
				words[i] += words[i];
			}
		}
		wordArray.setWords(words);
	}
	
	public String findMediumWord() {
		String[] sortedWords = wordArray.getWords();
		Arrays.sort(sortedWords, new WordLengthComparator());
		int mediumPos = sortedWords.length / 2;
		return sortedWords[mediumPos];
	}
	
	public String sumWords() {
		String text = "";
		for (String word : wordArray.getWords()) {
			text += word;
		}
		return text;
	}
	
	static final char[] positive = {'a', 'e', 'i', 'o', 'u', 'y'};
	static final char[] negative = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 
			'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z'};
	
	public int countPositiveWords() {
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
	
	public int countNegativeWords() {
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
