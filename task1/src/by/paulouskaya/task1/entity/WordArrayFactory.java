package by.paulouskaya.task1.entity;

public class WordArrayFactory {
	
	public WordArray createFromStaticAr(String[] staticStrings) {
		WordArray words = new WordArray();
		for (String word : staticStrings) {
			words.addWord(word);
		}
		return words;
	}
}
