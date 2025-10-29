package by.paulouskaya.task1.entity;

import java.util.Arrays;
import by.paulouskaya.task1.util.WordArrayGeneratorId;
import by.paulouskaya.task1.util.impl.WordArrayGenerateIdImpl;

public class WordArray {

	private final long wordArrayID;
	private static final WordArrayGeneratorId idGenerator = new WordArrayGenerateIdImpl();
	private static final int DEFAULT_CAPACITY = 20;
	private String[] words;
	private int size;
	
	public WordArray() {
        this.wordArrayID = idGenerator.generateId();
        this.words = new String[DEFAULT_CAPACITY];
        this.size = 0;
    }
	
	public void addWord(String word) {
		if (this.size >= this.words.length) {
			this.words = Arrays.copyOf(this.words, this.words.length * 2);
		}
		this.words[this.size++] = word;
	}
	
	public String[] getWords() {
		return this.words.clone();
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void setWords(String[] words) {
		this.words = words.clone();
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
}
