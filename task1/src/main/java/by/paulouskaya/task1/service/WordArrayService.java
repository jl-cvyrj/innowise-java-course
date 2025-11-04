package by.paulouskaya.task1.service;

import by.paulouskaya.task1.entity.WordArray;
import by.paulouskaya.task1.exception.WordArrayException;

public interface WordArrayService {
	
	String POSITIVE_STR = "aeiouy";
	String NEGATIVE_STR = "bcdfghjklmnpqrstvwxz";
	
	public String findMaxWord(WordArray wordArray) throws WordArrayException;
	
	public String findMinWord(WordArray wordArray) throws WordArrayException;
	
	//replaces a word from 1 symbol with a word with 2 same symbols
	public void replaceIfOneSymb(WordArray wordArray) throws WordArrayException;
	
	public String findMediumWord(WordArray wordArray) throws WordArrayException;
	
	public String sumWords(WordArray wordArray) throws WordArrayException;
	
	public int countPositiveWords(WordArray wordArray);
	
	public int countNegativeWords(WordArray wordArray);
	
}
