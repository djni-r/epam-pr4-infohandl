package test.by.malinouski.infohandling.reader;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.BeforeClass;
import org.junit.Test;

import by.malinouski.infohandling.reader.TextReader;

public class TextReaderTest {
    
    // ????????????? How can I do this? what '@' to use? 
    private static final String FILE_DIR = "/files";
    private static final String TEXT = "some text";
    private static String FILENAME;

    @BeforeClass
    public void createTextFile() throws IOException {
        Path path = Files.createTempFile(new File(FILE_DIR).toPath(), null, null);
        Files.write(path, TEXT.getBytes());
        
        FILENAME = path.toString();
    }
    
    @Test
    public void readTest() {
        TextReader reader = new TextReader();
        String text = reader.read(FILENAME);
        assertEquals(text, TEXT);
    }

}
