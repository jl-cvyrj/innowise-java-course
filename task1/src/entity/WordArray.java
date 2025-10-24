package entity;

import java.util.Arrays;

public class WordArray {
	
	private static final int default_capacity = 20;
	private String[] words;
	private int size;
	
	protected WordArray() {
		this.words = new String[default_capacity];
		this.size = 0;
	}
	
	public void addWord(String word) {
		if (this.size >= this.words.length) {
			this.words = Arrays.copyOf(this.words, this.words.length * 2);
		}
		this.words[this.size++] = word;
	}
	
	public String[] getWords() {
		return this.words;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void setWords(String[] words) {
		this.words = words;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
}
