package by.paulouskaya.task1.comparator;

import java.util.Comparator;

public class ReverseAlphabeticalComparator implements Comparator<String> {
    
    @Override
    public int compare(String word1, String word2) {
        return word2.compareTo(word1);
    }
}