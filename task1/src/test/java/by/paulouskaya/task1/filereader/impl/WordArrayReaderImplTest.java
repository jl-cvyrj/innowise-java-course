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
    public void testReadFile_NullPath() {
        assertThrows(WordArrayException.class, () -> {
            reader.readFile(null);
        });
    }

    @Test
    public void testReadFile_EmptyPath() {
        assertThrows(WordArrayException.class, () -> {
            reader.readFile("");
        });
    }

    @Test
    public void testReadFile_BlankPath() {
        assertThrows(WordArrayException.class, () -> {
            reader.readFile("   ");
        });
    }

    @Test
    public void testReadFile_NonExistentFile() {
        assertThrows(WordArrayException.class, () -> {
            reader.readFile("nonexistent.txt");
        });
    }

    @Test
    public void testReadFile_EmptyFile(@TempDir Path tempDir) throws IOException {
        Path emptyFile = tempDir.resolve("empty.txt");
        Files.createFile(emptyFile);

        assertThrows(WordArrayException.class, () -> {
            reader.readFile(emptyFile.toString());
        });
    }

    @Test
    public void testReadFile_ValidFileWithMultipleLines(@TempDir Path tempDir) throws IOException {
        Path testFile = tempDir.resolve("test.txt");
        Files.write(testFile, List.of("hello world", "java programming", "test data"));

        List<String> result = reader.readFile(testFile.toString());

        assertEquals(3, result.size());
        assertEquals("hello world", result.get(0));
        assertEquals("java programming", result.get(1));
        assertEquals("test data", result.get(2));
    }

    @Test
    public void testReadFile_FileWithBlankLines(@TempDir Path tempDir) throws IOException {
        Path testFile = tempDir.resolve("test.txt");
        Files.write(testFile, List.of("first line", "", "   ", "last line"));

        List<String> result = reader.readFile(testFile.toString());

        assertEquals(2, result.size());
        assertEquals("first line", result.get(0));
        assertEquals("last line", result.get(1));
    }

    @Test
    public void testReadFile_FileWithOnlyBlankLines(@TempDir Path tempDir) throws IOException {
        Path testFile = tempDir.resolve("test.txt");
        Files.write(testFile, List.of("", "   ", "\t"));

        assertThrows(WordArrayException.class, () -> {
            reader.readFile(testFile.toString());
        });
    }

    @Test
    public void testReadFile_SingleLineFile(@TempDir Path tempDir) throws IOException {
        Path testFile = tempDir.resolve("test.txt");
        Files.write(testFile, List.of("single line"));

        List<String> result = reader.readFile(testFile.toString());

        assertEquals(1, result.size());
        assertEquals("single line", result.get(0));
    }

    @Test
    public void testReadFile_FileWithSpecialCharacters(@TempDir Path tempDir) throws IOException {
        Path testFile = tempDir.resolve("test.txt");
        Files.write(testFile, List.of("line with @ symbols", "another line"));

        List<String> result = reader.readFile(testFile.toString());

        assertEquals(2, result.size());
        assertEquals("line with @ symbols", result.get(0));
        assertEquals("another line", result.get(1));
    }

    @Test
    public void testReadFile_FileWithSpacesAtEnds(@TempDir Path tempDir) throws IOException {
        Path testFile = tempDir.resolve("test.txt");
        Files.write(testFile, List.of("  line with spaces  ", "another line"));

        List<String> result = reader.readFile(testFile.toString());

        assertEquals(2, result.size());
        assertEquals("  line with spaces  ", result.get(0));
        assertEquals("another line", result.get(1));
    }
}