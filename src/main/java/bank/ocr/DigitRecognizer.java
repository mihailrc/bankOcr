package bank.ocr;

public class DigitRecognizer {

    public String getDigit(String symbols) {
        for (Digits digit : Digits.values()) {
            if (digit.getSymbols().equals(symbols)) {
                return digit.getDigit();
            }
        }
        return "?";
    }
}
