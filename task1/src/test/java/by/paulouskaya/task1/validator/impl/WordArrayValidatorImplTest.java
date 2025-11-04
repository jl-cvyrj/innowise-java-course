package by.paulouskaya.task1.validator.impl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import by.paulouskaya.task1.entity.WordArray;
import by.paulouskaya.task1.exception.WordArrayException;
import by.paulouskaya.task1.factory.impl.WordArrayFactoryImpl;

public class WordArrayValidatorImplTest {

    final WordArrayValidatorImpl validatorWordArray = new WordArrayValidatorImpl();
    final WordArrayFactoryImpl factoryWordArray = new WordArrayFactoryImpl();

    @Test
    public void testIsWordArrayCorrect_WordArray_Null() {
        assertFalse(validatorWordArray.isWordArrayCorrect((WordArray) null));
    }

    @Test
    public void testIsWordArrayCorrect_WordArray_Empty() {
        WordArray wordArray = factoryWordArray.createEmptyWordArray();
        assertFalse(validatorWordArray.isWordArrayCorrect(wordArray));
    }

    @Test
    public void testIsWordArrayCorrect_WordArray_Valid() throws WordArrayException {
        WordArray wordArray = factoryWordArray.createWordArrayFromArray(new String[]{"hello", "world"});
        assertTrue(validatorWordArray.isWordArrayCorrect(wordArray));
    }

    @Test
    public void testIsWordArrayCorrect_WordArray_InvalidSymbols() throws WordArrayException {
        WordArray wordArray = factoryWordArray.createWordArrayFromArray(new String[]{"invalid@word"});
        assertFalse(validatorWordArray.isWordArrayCorrect(wordArray));
    }
   
}