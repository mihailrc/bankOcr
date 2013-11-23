package bank.ocr;

import bank.ocr.exceptions.InvalidDigitPatternException;

public class DigitDistance {

    public int getDistance(String first, String second) {
        validateInput(first, second);
        int distance = 0;
        for (int i = 0; i < first.length(); i++) {
            if (!first.substring(i, i + 1).equals(second.substring(i, i + 1))) {
                distance++;
            }
        }
        return distance;
    }

    private void validateInput(String first, String second) {
        if (!(Digits.hasExpectedPattern(first) && Digits.hasExpectedPattern(second))) {
            String message = "Oops! " + first + " or " + second + " does not look like valid input. " +
            "Valid symbols need to match the following pattern" + Digits.SYMBOLS_PATTERN;
            throw new InvalidDigitPatternException(message);
        }
    }
}
