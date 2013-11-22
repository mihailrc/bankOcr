package bank.ocr.exceptions;

public class IllegibleAccountNumberException extends RuntimeException {
    public IllegibleAccountNumberException() {
    }

    public IllegibleAccountNumberException(String s) {
        super(s);
    }

    public IllegibleAccountNumberException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public IllegibleAccountNumberException(Throwable throwable) {
        super(throwable);
    }
}
