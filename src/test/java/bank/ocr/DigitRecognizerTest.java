package bank.ocr;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DigitRecognizerTest {

    @Test
    public void recognizesValidSymbols() {
        DigitRecognizer digitRecognizer = new DigitRecognizer();
        for (Digits digits : Digits.values()) {
            assertEquals(digits.getDigit(), digitRecognizer.getDigit(digits.getSymbols()));
        }
    }

    @Test
    public void handlesInvalidSymbols(){
        DigitRecognizer digitRecognizer = new DigitRecognizer();
        assertEquals("?", digitRecognizer.getDigit("anything"));
    }
}
