package bank.ocr.exceptions;

public class InvalidAccountPatternException extends RuntimeException {

    public InvalidAccountPatternException() {
    }

    public InvalidAccountPatternException(String s) {
        super(s);
    }

    public InvalidAccountPatternException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public InvalidAccountPatternException(Throwable throwable) {
        super(throwable);
    }
}
