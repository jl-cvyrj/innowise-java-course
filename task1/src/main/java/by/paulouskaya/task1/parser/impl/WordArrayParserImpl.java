package by.paulouskaya.task1.parser.impl;

import java.util.ArrayList;
import java.util.List;

import by.paulouskaya.task1.parser.WordArrayParser;

public class WordArrayParserImpl implements WordArrayParser {
	
	@Override
	public List<String[]> parseText(List<String> listString) {
		List<String[]> listWordArray = new ArrayList<String[]>();
		for (String line : listString) {
			String[] splitWords = line.split(WORDS_DATA_REGEX);
			listWordArray.add(splitWords);
		}
		return listWordArray;
	}
}
