package by.paulouskaya.task1.entity;

import java.util.Arrays;
import java.util.Objects;

import by.paulouskaya.task1.exception.WordArrayException;
import by.paulouskaya.task1.observer.WordArrayObservable;
import by.paulouskaya.task1.observer.WordArrayObserver;
import by.paulouskaya.task1.observer.impl.WordArrayObserverImpl;
import by.paulouskaya.task1.util.WordArrayGeneratorId;

public class WordArray implements WordArrayObservable {

	private final long id;
	private static final WordArrayGeneratorId idGenerator = new WordArrayGeneratorId();
	private static final int DEFAULT_CAPACITY = 100;
	private String[] words;
	private WordArrayObserver observer;
	
	public WordArray() {
        this.id = idGenerator.generateId();
        this.words = new String[DEFAULT_CAPACITY];
    }
	
	public long getId() {
		return this.id;
	}
	
	public String[] getWords() {
        return this.words.clone();
    }
	
	public int getSize() {
        int count = 0;
        for (String word : words) {
            if (word != null) {
                count++;
            } else {
            	return count;
            }
        }
        return count;
    }
	
	public int getData() {
        int count = 0;
        for (String word : words) {
            if (word != null) {
                count++;
            } else {
            	return count;
            }
        }
        return count;
    }
	
	public void setWords(String[] words) throws WordArrayException {
		this.words = words.clone();
		notifyObservers();
	}
	
	public void setSize(int size) throws WordArrayException {
	    if (size > DEFAULT_CAPACITY) {
	        throw new WordArrayException("New size exceeds maximum capacity: " + DEFAULT_CAPACITY);
	    }
	    
	    int currentActualSize = getSize();
	    if (size < currentActualSize) {
	        throw new WordArrayException(
	            "New size " + size + " is smaller than current number of words " + currentActualSize
	        );
	    }
	    
	    this.words = Arrays.copyOf(this.words, size);
		notifyObservers();
	}
	
	public void addWord(String word) throws WordArrayException {
        int currentSize = getSize();
        if (currentSize >= DEFAULT_CAPACITY) {
            throw new WordArrayException("WordArray is full. Maximum capacity: " + DEFAULT_CAPACITY);
        }
        this.words[currentSize] = word;
		notifyObservers();
    }
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("WordArray [wordArrayID=")
	      .append(id)
	      .append(", words=")
	      .append(Arrays.toString(words))
	      .append(", size=")
	      .append(getSize())
	      .append("]");
	    return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(words);
		result = prime * result + Objects.hash(id);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordArray other = (WordArray) obj;
		return id == other.id && Arrays.equals(words, other.words);
	}

	@Override
	public void attach(WordArrayObserverImpl observer) throws WordArrayException {
		this.observer = observer;
	}

	@Override
	public void detach(WordArrayObserverImpl observer) {
		this.observer = null;
	}

	@Override
	public void notifyObservers() throws WordArrayException {
		if (observer != null) {
			observer.wordArrayUpdate(this);
		}
	}
	
}
