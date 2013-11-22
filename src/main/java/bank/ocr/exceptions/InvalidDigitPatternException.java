package bank.ocr.exceptions;

public class InvalidDigitPatternException extends RuntimeException {

    public InvalidDigitPatternException() {
    }

    public InvalidDigitPatternException(String s) {
        super(s);
    }

    public InvalidDigitPatternException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public InvalidDigitPatternException(Throwable throwable) {
        super(throwable);
    }
}
