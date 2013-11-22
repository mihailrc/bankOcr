package bank.ocr;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DigitRecognizerTest {

    @Test
    public void recognizesValidSymbols() {
        DigitRecognizer digitRecognizer = new DigitRecognizer();
        for (Digits digits : Digits.values()) {
            assertEquals(digits.getDigit(), digitRecognizer.getDigit(digits.getSymbols()));
        }
    }

    @Test
    public void handlesInvalidSymbols() {
        DigitRecognizer digitRecognizer = new DigitRecognizer();
        assertEquals("?", digitRecognizer.getDigit("anything"));
    }

    @Test
    public void findsAlternativesForValidInput() {
        DigitRecognizer digitRecognizer = new DigitRecognizer();
        assertEquals(Arrays.asList("8"), digitRecognizer.getAlternatives(Digits.ZERO.getSymbols()));
        assertEquals(Arrays.asList("7"), digitRecognizer.getAlternatives(Digits.ONE.getSymbols()));
        assertEquals(Arrays.asList("6", "9"), digitRecognizer.getAlternatives(Digits.FIVE.getSymbols()));

    }

    @Test
    public void findsAlternativesForFixableInput() {
        DigitRecognizer digitRecognizer = new DigitRecognizer();
        String almostFourOrNine = "   " +
        "|_|" +
        " _|" +
        "   ";
        assertEquals(Arrays.asList("4", "9"), digitRecognizer.getAlternatives(almostFourOrNine));
    }

    @Test
    public void findsNoAlternativesForUnFixableInput() {
        DigitRecognizer digitRecognizer = new DigitRecognizer();
        String almostFourOrNine = "            ";
        assertTrue(digitRecognizer.getAlternatives(almostFourOrNine).isEmpty());
    }
}
