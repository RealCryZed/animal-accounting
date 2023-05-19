package accounting;

import org.junit.Test;

import static org.junit.Assert.*;

public class FileHandlerTest {

    @Test
    public void getAnimalsFromFile() {
        assertTrue(FileHandler.getAnimalsFromFile("dataset.txt").size() > 0);
    }

    @Test
    public void getInstructionsFromFile() {
        assertTrue(FileHandler.getInstructionsFromFile("instructions.txt").size() > 0);
    }
}