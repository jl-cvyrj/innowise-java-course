package by.paulouskaya.task1.util.impl;

import by.paulouskaya.task1.util.IdGenerator;

public class IdGeneratorImpl implements IdGenerator {
    private long currentId = 0;
    
    @Override
    public synchronized long generateId() {
        return ++currentId;
    }
}