package bank.ocr;

import bank.ocr.exceptions.InvalidDigitPatternException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class DigitDistanceTest {

    DigitDistance distance = new DigitDistance();

    @Test
    public void calculatesDistanceBetweenTwoDigits() {
        assertEquals(0, distance.getDistance(Digits.ZERO.getSymbols(), Digits.ZERO.getSymbols()));
        assertEquals(1, distance.getDistance(Digits.ZERO.getSymbols(), Digits.EIGHT.getSymbols()));
        assertEquals(1, distance.getDistance(Digits.EIGHT.getSymbols(), Digits.NINE.getSymbols()));
        assertEquals(1, distance.getDistance(Digits.ONE.getSymbols(), Digits.SEVEN.getSymbols()));
        assertEquals(1, distance.getDistance(Digits.FIVE.getSymbols(), Digits.NINE.getSymbols()));
        assertEquals(1, distance.getDistance(Digits.FIVE.getSymbols(), Digits.SIX.getSymbols()));
        assertEquals(2, distance.getDistance(Digits.ZERO.getSymbols(), Digits.NINE.getSymbols()));

    }

    @Test(expected = InvalidDigitPatternException.class)
    public void throwsExceptionForNullInput() {
        distance.getDistance(null, null);
        fail();
    }

    @Test(expected = InvalidDigitPatternException.class)
    public void throwsExceptionForInvalidInputPattern() {
        distance.getDistance("abc", "|_   ");
        fail();
    }


}
