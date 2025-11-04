package by.paulouskaya.task1.entity;

import java.util.Objects;

import by.paulouskaya.task1.exception.WordArrayException;
import by.paulouskaya.task1.service.impl.WordArrayServiceImpl;

public class WordArrayParameters {
	
	private final String maxWord;
    private final String minWord;
    private final String middleWord;
    private final String sumWord;
    private final WordArrayServiceImpl wordArrayService = new WordArrayServiceImpl();
    
    public WordArrayParameters(WordArray wordArray) throws WordArrayException {
    	this.maxWord = wordArrayService.findMaxWord(wordArray);
    	this.minWord = wordArrayService.findMinWord(wordArray);
    	this.middleWord = wordArrayService.findMediumWord(wordArray);
    	this.sumWord = wordArrayService.sumWords(wordArray);
    }
    
    public String getMaxWord() {
        return maxWord;
    }
    
    public String getMinWord() {
        return minWord;
    }
    
    public String getMiddleWord() {
        return middleWord;
    }
    
    public String getSumWord() {
        return sumWord;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WordArrayParameters [maxWord=");
		builder.append(maxWord);
		builder.append(", minWord=");
		builder.append(minWord);
		builder.append(", middleWord=");
		builder.append(middleWord);
		builder.append("]");
		return builder.toString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maxWord == null) ? 0 : maxWord.hashCode());
		result = prime * result + ((middleWord == null) ? 0 : middleWord.hashCode());
		result = prime * result + ((minWord == null) ? 0 : minWord.hashCode());
		result = prime * result + ((sumWord == null) ? 0 : sumWord.hashCode());
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
		WordArrayParameters other = (WordArrayParameters) obj;
		return Objects.equals(maxWord, other.maxWord) && Objects.equals(middleWord, other.middleWord)
				&& Objects.equals(minWord, other.minWord) && Objects.equals(sumWord, other.sumWord);
	}
}
