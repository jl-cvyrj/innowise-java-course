package by.paulouskaya.task1.filereader.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import static org.junit.jupiter.api.Assertions.*;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import by.paulouskaya.task1.exception.WordArrayException;

public class WordArrayReaderImplTest {

    final WordArrayReaderImpl readerWordArray = new WordArrayReaderImpl();

    @Test
    public void testReadFile_EmptyPathThrowsException() {
        try {
            readerWordArray.readWordArrayFile("");
            fail("Expected WordArrayException for empty path");
        } catch (WordArrayException e) {
        }
    }

    @Test
    public void testReadFile_BlankPathThrowsException() {
        try {
            readerWordArray.readWordArrayFile("   ");
            fail("Expected WordArrayException for blank path");
        } catch (WordArrayException e) {
        }
    }

    @Test
    public void testReadFile_NonExistentFileThrowsException() {
        try {
            readerWordArray.readWordArrayFile("nonexistent.txt");
            fail("Expected WordArrayException for non-existent file");
        } catch (WordArrayException e) {
        }
    }

    @Test
    public void testReadFile_EmptyFileThrowsException(@TempDir Path tempDir) {
        Path emptyFile = tempDir.resolve("empty.txt");
        try {
            Files.createFile(emptyFile);
        } catch (IOException e) {
            fail("Failed to create empty file");
        }
        try {
            readerWordArray.readWordArrayFile(emptyFile.toString());
            fail("Expected WordArrayException for empty file");
        } catch (WordArrayException e) {
        }
    }

    @Test
    public void testReadFile_FileWithOnlyBlankLinesThrowsException(@TempDir Path tempDir) {
        Path testFile = tempDir.resolve("test.txt");
        try {
            Files.write(testFile, List.of("", "   ", "\t"));
        } catch (IOException e) {
            fail("Failed to create test file");
        }
        
        try {
            readerWordArray.readWordArrayFile(testFile.toString());
            fail("Expected WordArrayException for file with only blank lines");
        } catch (WordArrayException e) {
        }
    }

    @Test
    public void testReadFile_ValidFileReturnsCorrectSize(@TempDir Path tempDir) throws WordArrayException {
        Path testFile = tempDir.resolve("test.txt");
        try {
            Files.write(testFile, List.of("hello world", "java programming", "test data"));
        } catch (IOException e) {
            fail("Failed to create test file");
        }
        List<String> result = readerWordArray.readWordArrayFile(testFile.toString());
        int expected = 3;
        int actual = result.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testReadFile_ValidFileReturnsCorrectThirdLine(@TempDir Path tempDir) throws WordArrayException {
        Path testFile = tempDir.resolve("test.txt");
        try {
            Files.write(testFile, List.of("hello world", "java programming", "test data"));
        } catch (IOException e) {
            fail("Failed to create test file");
        }
        List<String> result = readerWordArray.readWordArrayFile(testFile.toString());
        String expected = "test data";
        String actual = result.get(2);
        assertEquals(expected, actual);
    }

    @Test
    public void testReadFile_FileWithBlankLinesReturnsCorrectSize(@TempDir Path tempDir) throws WordArrayException {
        Path testFile = tempDir.resolve("test.txt");
        try {
            Files.write(testFile, List.of("first line", "", "   ", "last line"));
        } catch (IOException e) {
            fail("Failed to create test file");
        }
        List<String> result = readerWordArray.readWordArrayFile(testFile.toString());
        int expected = 2;
        int actual = result.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testReadFile_FileWithBlankLinesReturnsLastLine(@TempDir Path tempDir) throws WordArrayException {
        Path testFile = tempDir.resolve("test.txt");
        try {
            Files.write(testFile, List.of("first line", "", "   ", "last line"));
        } catch (IOException e) {
            fail("Failed to create test file");
        }
        List<String> result = readerWordArray.readWordArrayFile(testFile.toString());
        String expected = "last line";
        String actual = result.get(1);
        assertEquals(expected, actual);
    }

    @Test
    public void testReadFile_SingleLineFileReturnsCorrectContent(@TempDir Path tempDir) throws WordArrayException {
        Path testFile = tempDir.resolve("test.txt");
        try {
            Files.write(testFile, List.of("single line"));
        } catch (IOException e) {
            fail("Failed to create test file");
        }
        List<String> result = readerWordArray.readWordArrayFile(testFile.toString());
        String expected = "single line";
        String actual = result.get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void testReadFile_FileWithSpecialCharactersReturnsFirstLine(@TempDir Path tempDir) throws WordArrayException {
        Path testFile = tempDir.resolve("test.txt");
        try {
            Files.write(testFile, List.of("line with @ symbols", "another line"));
        } catch (IOException e) {
            fail("Failed to create test file");
        }
        List<String> result = readerWordArray.readWordArrayFile(testFile.toString());
        String expected = "line with @ symbols";
        String actual = result.get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void testReadFile_FileWithSpacesAtEndsReturnsCorrectSize(@TempDir Path tempDir) throws WordArrayException {
        Path testFile = tempDir.resolve("test.txt");
        try {
            Files.write(testFile, List.of("  line with spaces  ", "another line"));
        } catch (IOException e) {
            fail("Failed to create test file");
        }
        List<String> result = readerWordArray.readWordArrayFile(testFile.toString());
        int expected = 2;
        int actual = result.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testReadFile_FileWithSpacesAtEndsReturnsFirstLine(@TempDir Path tempDir) throws WordArrayException {
        Path testFile = tempDir.resolve("test.txt");
        try {
            Files.write(testFile, List.of("  line with spaces  ", "another line"));
        } catch (IOException e) {
            fail("Failed to create test file");
        }
        List<String> result = readerWordArray.readWordArrayFile(testFile.toString());
        String expected = "  line with spaces  ";
        String actual = result.get(0);
        assertEquals(expected, actual);
    }
    
}