package by.paulouskaya.task1.filereader.impl;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import by.paulouskaya.task1.exception.WordArrayException;
import by.paulouskaya.task1.filereader.WordArrayReader;

public class WordArrayReaderImpl implements WordArrayReader {

	@Override
	public List <String> readWordArrayFile(String fileName) throws WordArrayException {
		
		Path filePath = Paths.get(DATA_DIRECTORY, fileName);
		
		if (!Files.exists(filePath)) {
			throw new WordArrayException("file doesn't exist");
		}
		
		List <String> arraysStringList = new ArrayList<>();
		try {			
			arraysStringList = Files.readAllLines(filePath);
			if (arraysStringList.isEmpty()) {
				throw new WordArrayException("file is empty");
			}
			return arraysStringList;
		} catch (IOException e) {
			throw new WordArrayException("file error");
		}
	}
}
