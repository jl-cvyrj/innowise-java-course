package filereader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordArrayReader {
	public String[] ReadWardArray() {
		List<String> allWords = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader (new FileReader ("input.txt"));
			String str;
			while((str = reader.readLine()) != null) {
				String[] splits = str.split(" ;,./|\\!?");
				for (String s : splits) {
					allWords.add(s);
				}
			}
			reader.close();
			String[] primeryWords = allWords.toArray(new String[0]);
			return primeryWords;
		} catch (FileNotFoundException e) {
			System.out.println("file doesn't exist");
			return new String[0];
		} catch (IOException e) {
			System.out.println("file error exist");
			return new String[0];
		}
	}
}
