package bank.ocr;

import java.util.ArrayList;
import java.util.List;

public class DigitRecognizer {

    public String getDigit(String symbols) {
        for (Digits digit : Digits.values()) {
            if (digit.getSymbols().equals(symbols)) {
                return digit.getDigit();
            }
        }
        return "?";
    }

    public List<String> getAlternatives(String symbols) {
        List<String> alternatives = new ArrayList<String>();
        if (!Digits.hasExpectedPattern(symbols)) {
            return alternatives;
        } else {
            DigitDistance distance = new DigitDistance();
            for (Digits digit : Digits.values()) {
                if (distance.getDistance(symbols, digit.getSymbols()) == 1) {
                    alternatives.add(digit.getDigit());
                }
            }
        }
        return alternatives;
    }
}
