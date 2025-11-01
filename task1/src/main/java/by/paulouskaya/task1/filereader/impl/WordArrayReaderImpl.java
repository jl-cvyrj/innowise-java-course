package by.paulouskaya.task1.filereader.impl;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import by.paulouskaya.task1.exception.WordArrayException;
import by.paulouskaya.task1.filereader.WordArrayReader;

public class WordArrayReaderImpl implements WordArrayReader {

	@Override
	public List <String> readWordArrayFile(String path) throws WordArrayException {
		if (path == null || path.isBlank()) {
			throw new WordArrayException("file doesn't exist");
		}
		List <String> arraysStringList = new ArrayList<>();;
		try {
			BufferedReader reader = new BufferedReader (new FileReader(path));
			String line;
			while ((line = reader.readLine()) != null) {
				if (!line.isBlank()) {
					arraysStringList.add(line);
				}
			}
			reader.close();
			if (arraysStringList.isEmpty()) {
				throw new WordArrayException("file is empty");
			}
			return arraysStringList;
		} catch (IOException e) {
			throw new WordArrayException("file error");
		}
	}
}
