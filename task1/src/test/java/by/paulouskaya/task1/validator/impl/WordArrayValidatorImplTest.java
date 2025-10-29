package by.paulouskaya.task1.validator.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import by.paulouskaya.task1.entity.WordArray;
import by.paulouskaya.task1.validator.WordArrayValidator;

public class WordArrayValidatorImplTest {

    private WordArrayValidator validator;
    private WordArray wordArray;

    @BeforeEach
    public void setUp() {
        validator = new WordArrayValidatorImpl();
        wordArray = new WordArray();
    }

    @Test
    public void testIsWordArrayCorrect_WordArray_Null() {
        assertFalse(validator.isWordArrayCorrect((WordArray) null));
    }

    @Test
    public void testIsWordArrayCorrect_WordArray_Empty() {
        assertFalse(validator.isWordArrayCorrect(wordArray));
    }

    @Test
    public void testIsWordArrayCorrect_WordArray_Valid() {
        wordArray.addWord("hello");
        wordArray.addWord("world");
        assertTrue(validator.isWordArrayCorrect(wordArray));
    }

    @Test
    public void testIsWordArrayCorrect_WordArray_InvalidSymbols() {
        wordArray.addWord("invalid@word");
        assertFalse(validator.isWordArrayCorrect(wordArray));
    }

    @Test
    public void testIsWordArrayCorrect_StringArray_Null() {
        assertFalse(validator.isWordArrayCorrect((String[]) null));
    }

    @Test
    public void testIsWordArrayCorrect_StringArray_Empty() {
        assertFalse(validator.isWordArrayCorrect(new String[]{}));
    }

    @Test
    public void testIsWordArrayCorrect_StringArray_SingleValid() {
        assertTrue(validator.isWordArrayCorrect(new String[]{"hello"}));
    }

    @Test
    public void testIsWordArrayCorrect_StringArray_MultipleValid() {
        assertTrue(validator.isWordArrayCorrect(new String[]{"hello", "world"}));
    }

    @Test
    public void testIsWordArrayCorrect_StringArray_SingleInvalid() {
        assertFalse(validator.isWordArrayCorrect(new String[]{"invalid#word"}));
    }

    @Test
    public void testIsWordArrayCorrect_StringArray_MixedValidInvalid() {
        assertFalse(validator.isWordArrayCorrect(new String[]{"valid", "invalid@word"}));
    }
    @Test
    public void testIsWordArrayCorrect_String_MultipleWords() {
        assertTrue(validator.isWordArrayCorrect("hello world"));
    }

    @Test
    public void testIsWordArrayCorrect_String_MultipleSpaces() {
        assertTrue(validator.isWordArrayCorrect("hello    world"));
    }

    @Test
    public void testIsWordArrayCorrect_String_InvalidSymbols() {
        assertFalse(validator.isWordArrayCorrect("hello@world"));
    }

    @Test
    public void testIsWordArrayCorrect_String_MixedValidInvalid() {
        assertFalse(validator.isWordArrayCorrect("valid invalid$word"));
    }

    @Test
    public void testIsWordArrayCorrect_SpecialCharacters_Numbers() {
        assertTrue(validator.isWordArrayCorrect(new String[]{"hello123"}));
    }

}