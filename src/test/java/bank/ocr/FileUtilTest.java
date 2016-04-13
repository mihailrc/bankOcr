package bank.ocr;

import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.Assert.*;

public class FileUtilTest {

    @Test
    public void copiesFromReaderToWriter() throws IOException {
        String text = "test";
        StringReader reader = new StringReader(text);
        StringWriter writer = new StringWriter();
        FileUtil.copy(reader, writer);
        assertEquals(text, writer.toString());
    }

    @Test
    public void stuff(){
    	throw new RuntimeException("Catch me!");
    }

    @Test
    public void stuff2(){
    	fail("just fail will you?");
    }
}
