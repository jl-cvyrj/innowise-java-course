package by.paulouskaya.task1.validator.impl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import by.paulouskaya.task1.entity.WordArray;
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
    public void testIsWordArrayCorrect_WordArray_Valid() {
        WordArray wordArray = factoryWordArray.createWordArrayFromArray(new String[]{"hello", "world"});
        assertTrue(validatorWordArray.isWordArrayCorrect(wordArray));
    }

    @Test
    public void testIsWordArrayCorrect_WordArray_InvalidSymbols() {
        WordArray wordArray = factoryWordArray.createWordArrayFromArray(new String[]{"invalid@word"});
        assertFalse(validatorWordArray.isWordArrayCorrect(wordArray));
    }

    @Test
    public void testIsWordArrayCorrect_StringArray_Null() {
        assertFalse(validatorWordArray.isWordArrayCorrect((String[]) null));
    }

    @Test
    public void testIsWordArrayCorrect_StringArray_Empty() {
        assertFalse(validatorWordArray.isWordArrayCorrect(new String[]{}));
    }

    @Test
    public void testIsWordArrayCorrect_StringArray_Valid() {
        assertTrue(validatorWordArray.isWordArrayCorrect(new String[]{"hello", "world"}));
    }

    @Test
    public void testIsWordArrayCorrect_StringArray_Invalid() {
        assertFalse(validatorWordArray.isWordArrayCorrect(new String[]{"valid", "invalid@word"}));
    }

    @Test
    public void testIsWordArrayCorrect_String_Valid() {
        assertTrue(validatorWordArray.isWordArrayCorrect("hello world"));
    }

    @Test
    public void testIsWordArrayCorrect_String_Invalid() {
        assertFalse(validatorWordArray.isWordArrayCorrect("hello@world"));
    }

    @Test
    public void testIsWordArrayCorrect_SpecialCharacters_Numbers() {
        assertTrue(validatorWordArray.isWordArrayCorrect(new String[]{"hello123"}));
    }
}