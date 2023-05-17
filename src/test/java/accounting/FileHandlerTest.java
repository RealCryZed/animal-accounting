package accounting;

import org.junit.Test;

import static org.junit.Assert.*;

public class FileHandlerTest {

    @Test
    public void getAnimalsFromFile() {
        assertTrue(FileHandler.getAnimalsFromFile("dataset.txt").size() > 0);
    }
}