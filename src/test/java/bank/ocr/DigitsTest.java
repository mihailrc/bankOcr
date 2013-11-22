package bank.ocr;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DigitsTest {

    @Test
    public void identifiesExpectedPattern() {
        assertTrue(Digits.hasExpectedPattern(Digits.ZERO.getSymbols()));
        assertTrue(Digits.hasExpectedPattern("            "));
    }

    @Test
    public void identifiesUnexpectedPattern() {
        assertFalse(Digits.hasExpectedPattern(null));
        assertFalse(Digits.hasExpectedPattern("abc"));
    }
}
