package by.paulouskaya.task1.warehouse;

import java.util.HashMap;
import java.util.Map;

import by.paulouskaya.task1.entity.WordArrayParameters;

public class WordArrayWarehouse {

		private static WordArrayWarehouse instance;
		private final Map<Long, WordArrayParameters> WordArrayParametersMap = new HashMap<>();

	WordArrayWarehouse() {
	}
	
	public static WordArrayWarehouse getInstance() {
        if (instance == null) {
            instance = new WordArrayWarehouse();
        }
        return instance;
    }
	
	public void put(long id, WordArrayParameters wordArrayParameters) {
		WordArrayParametersMap.put(id, wordArrayParameters);
	}
}
