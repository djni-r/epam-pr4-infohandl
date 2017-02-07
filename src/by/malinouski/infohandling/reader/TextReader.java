/**
 * Makary Malinouski
 *
 * EPAM 
 * Java Web Development
 * Task 4 
 * Information Handling
 *
 * An application that parses text
 * and allows three different operations on it

 */
package by.malinouski.infohandling.reader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * @author makarymalinouski
 * 
 * Class for reading text from file
 */
public class TextReader {

    private static final Logger LOGGER = LogManager.getLogger(TextReader.class);
    /**
     * Reads text from fileName returing it as one String
     */
    public String read(final String fileName) {
        try {
            return new String(Files.readAllBytes(new File(fileName).toPath()));
        } catch (IOException e) {
            LOGGER.fatal("Couldn't read file " + e.getMessage());
            throw new RuntimeException("Couldn't read file");
        }
    }

}
