package by.paulouskaya.task1.filereader.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.io.TempDir;
import static org.junit.jupiter.api.Assertions.*;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import by.paulouskaya.task1.exception.WordArrayException;

public class WordArrayReaderImplTest {

    private WordArrayReaderImpl reader;

    @BeforeEach
    public void setUp() {
        reader = new WordArrayReaderImpl();
    }

    @Test
    public void testReadFile_NullPathThrowsException() {
        assertThrows(WordArrayException.class, () -> reader.readFile(null));
    }

    @Test
    public void testReadFile_EmptyPathThrowsException() {
        assertThrows(WordArrayException.class, () -> reader.readFile(""));
    }

    @Test
    public void testReadFile_BlankPathThrowsException() {
        assertThrows(WordArrayException.class, () -> reader.readFile("   "));
    }

    @Test
    public void testReadFile_NonExistentFileThrowsException() {
        assertThrows(WordArrayException.class, () -> reader.readFile("nonexistent.txt"));
    }

    @Test
    public void testReadFile_EmptyFileThrowsException(@TempDir Path tempDir) throws IOException {
        Path emptyFile = tempDir.resolve("empty.txt");
        Files.createFile(emptyFile);
        assertThrows(WordArrayException.class, () -> reader.readFile(emptyFile.toString()));
    }

    @Test
    public void testReadFile_ValidFileReturnsCorrectSize(@TempDir Path tempDir) throws IOException {
        Path testFile = tempDir.resolve("test.txt");
        Files.write(testFile, List.of("hello world", "java programming", "test data"));
        List<String> result = reader.readFile(testFile.toString());
        assertEquals(3, result.size());
    }

    @Test
    public void testReadFile_ValidFileReturnsCorrectFirstLine(@TempDir Path tempDir) throws IOException {
        Path testFile = tempDir.resolve("test.txt");
        Files.write(testFile, List.of("hello world", "java programming", "test data"));
        List<String> result = reader.readFile(testFile.toString());
        assertEquals("hello world", result.get(0));
    }

    @Test
    public void testReadFile_ValidFileReturnsCorrectSecondLine(@TempDir Path tempDir) throws IOException {
        Path testFile = tempDir.resolve("test.txt");
        Files.write(testFile, List.of("hello world", "java programming", "test data"));
        List<String> result = reader.readFile(testFile.toString());
        assertEquals("java programming", result.get(1));
    }

    @Test
    public void testReadFile_ValidFileReturnsCorrectThirdLine(@TempDir Path tempDir) throws IOException {
        Path testFile = tempDir.resolve("test.txt");
        Files.write(testFile, List.of("hello world", "java programming", "test data"));
        List<String> result = reader.readFile(testFile.toString());
        assertEquals("test data", result.get(2));
    }

    @Test
    public void testReadFile_FileWithBlankLinesReturnsCorrectSize(@TempDir Path tempDir) throws IOException {
        Path testFile = tempDir.resolve("test.txt");
        Files.write(testFile, List.of("first line", "", "   ", "last line"));
        List<String> result = reader.readFile(testFile.toString());
        assertEquals(2, result.size());
    }

    @Test
    public void testReadFile_FileWithBlankLinesReturnsFirstLine(@TempDir Path tempDir) throws IOException {
        Path testFile = tempDir.resolve("test.txt");
        Files.write(testFile, List.of("first line", "", "   ", "last line"));
        List<String> result = reader.readFile(testFile.toString());
        assertEquals("first line", result.get(0));
    }

    @Test
    public void testReadFile_FileWithBlankLinesReturnsLastLine(@TempDir Path tempDir) throws IOException {
        Path testFile = tempDir.resolve("test.txt");
        Files.write(testFile, List.of("first line", "", "   ", "last line"));
        List<String> result = reader.readFile(testFile.toString());
        assertEquals("last line", result.get(1));
    }

    @Test
    public void testReadFile_FileWithOnlyBlankLinesThrowsException(@TempDir Path tempDir) throws IOException {
        Path testFile = tempDir.resolve("test.txt");
        Files.write(testFile, List.of("", "   ", "\t"));
        assertThrows(WordArrayException.class, () -> reader.readFile(testFile.toString()));
    }

    @Test
    public void testReadFile_SingleLineFileReturnsCorrectSize(@TempDir Path tempDir) throws IOException {
        Path testFile = tempDir.resolve("test.txt");
        Files.write(testFile, List.of("single line"));
        List<String> result = reader.readFile(testFile.toString());
        assertEquals(1, result.size());
    }

    @Test
    public void testReadFile_SingleLineFileReturnsCorrectContent(@TempDir Path tempDir) throws IOException {
        Path testFile = tempDir.resolve("test.txt");
        Files.write(testFile, List.of("single line"));
        List<String> result = reader.readFile(testFile.toString());
        assertEquals("single line", result.get(0));
    }

    @Test
    public void testReadFile_FileWithSpecialCharactersReturnsCorrectSize(@TempDir Path tempDir) throws IOException {
        Path testFile = tempDir.resolve("test.txt");
        Files.write(testFile, List.of("line with @ symbols", "another line"));
        List<String> result = reader.readFile(testFile.toString());
        assertEquals(2, result.size());
    }

    @Test
    public void testReadFile_FileWithSpecialCharactersReturnsFirstLine(@TempDir Path tempDir) throws IOException {
        Path testFile = tempDir.resolve("test.txt");
        Files.write(testFile, List.of("line with @ symbols", "another line"));
        List<String> result = reader.readFile(testFile.toString());
        assertEquals("line with @ symbols", result.get(0));
    }

    @Test
    public void testReadFile_FileWithSpacesAtEndsReturnsCorrectSize(@TempDir Path tempDir) throws IOException {
        Path testFile = tempDir.resolve("test.txt");
        Files.write(testFile, List.of("  line with spaces  ", "another line"));
        List<String> result = reader.readFile(testFile.toString());
        assertEquals(2, result.size());
    }

    @Test
    public void testReadFile_FileWithSpacesAtEndsReturnsFirstLine(@TempDir Path tempDir) throws IOException {
        Path testFile = tempDir.resolve("test.txt");
        Files.write(testFile, List.of("  line with spaces  ", "another line"));
        List<String> result = reader.readFile(testFile.toString());
        assertEquals("  line with spaces  ", result.get(0));
    }
}