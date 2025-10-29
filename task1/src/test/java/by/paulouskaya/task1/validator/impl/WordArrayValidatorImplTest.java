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
    public void testIsWordArrayCorrect_WordArray() {
        assertFalse(validator.isWordArrayCorrect((WordArray) null));
        
        wordArray = new WordArray();
        assertFalse(validator.isWordArrayCorrect(wordArray));
        
        wordArray.addWord("hello");
        wordArray.addWord("world");
        assertTrue(validator.isWordArrayCorrect(wordArray));
        
        wordArray = new WordArray();
        wordArray.addWord("invalid@word");
        assertFalse(validator.isWordArrayCorrect(wordArray));
    }

    @Test
    public void testIsWordArrayCorrect_StringArray() {
        assertFalse(validator.isWordArrayCorrect((String[]) null));
        assertFalse(validator.isWordArrayCorrect(new String[]{}));
        assertTrue(validator.isWordArrayCorrect(new String[]{"hello"}));
        assertTrue(validator.isWordArrayCorrect(new String[]{"hello", "world"}));
        assertFalse(validator.isWordArrayCorrect(new String[]{"invalid#word"}));
        assertFalse(validator.isWordArrayCorrect(new String[]{"valid", "invalid@word"}));
    }

    @Test
    public void testIsWordArrayCorrect_String() {
        assertFalse(validator.isWordArrayCorrect((String) null));
        assertFalse(validator.isWordArrayCorrect(""));
        assertFalse(validator.isWordArrayCorrect("   "));
        assertTrue(validator.isWordArrayCorrect("hello"));
        assertTrue(validator.isWordArrayCorrect("hello world"));
        assertTrue(validator.isWordArrayCorrect("hello    world"));
        assertTrue(validator.isWordArrayCorrect("hello\tworld"));
        assertFalse(validator.isWordArrayCorrect("hello@world"));
        assertFalse(validator.isWordArrayCorrect("valid invalid$word"));
    }

    @Test
    public void testIsWordArrayCorrect_SpecialCharacters() {
        assertTrue(validator.isWordArrayCorrect(new String[]{"hello123"}));
        assertTrue(validator.isWordArrayCorrect(new String[]{"well-known"}));
        assertTrue(validator.isWordArrayCorrect(new String[]{"don't"}));
        assertFalse(validator.isWordArrayCorrect(new String[]{"hello@world"}));
        assertFalse(validator.isWordArrayCorrect(new String[]{"test#"}));
        assertFalse(validator.isWordArrayCorrect(new String[]{"word$"}));
    }
}