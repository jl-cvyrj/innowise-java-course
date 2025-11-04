package by.paulouskaya.task1.repository;

import java.util.ArrayList;
import java.util.List;

import by.paulouskaya.task1.entity.WordArray;
import by.paulouskaya.task1.exception.WordArrayException;

import java.util.Comparator;

public class WordArrayRepository {
	
	private static WordArrayRepository instance;
	private final List<WordArray> wordArrays = new ArrayList<>();
	
	private WordArrayRepository() {}
	
	public static WordArrayRepository getInstance() {
        if (instance == null) {
            instance = new WordArrayRepository();
        }
        return instance;
    }

	public boolean addWordArray(WordArray wordArray) {	
		return wordArrays.add(wordArray);
	}

	public boolean deleteWordArray(WordArray wordArray) {		
		return wordArrays.remove(wordArray);
	}

	public List<WordArray> sortWordArray(Comparator<? super WordArray> comparator)  {
		List<WordArray> wordArraysCopy = new ArrayList<>(wordArrays);
		wordArraysCopy.sort(comparator);
		return wordArraysCopy;
	}

	public List<WordArray> query(WordArraySpecification specification) throws WordArrayException {
		List<WordArray> list = new ArrayList<>();
		for (WordArray current : wordArrays) {
			if(specification.specify(current)) {
				list.add(current);			}
		}
		return list;
	}

}
