package bank.ocr;

import bank.ocr.exceptions.InvalidAccountPatternException;

public class Account {

    public static final int DIGIT_WIDTH = 3;
    public static final int ACCOUNT_DIGITS = 9;
    //three lines of 27 spaces _ or | followed by one line of 27 spaces
    public static final String SYMBOLS_PATTERN = "([ _|]{27}\n){3} {27}\n";

    private String symbols;
    private String accountNumber;
    private AccountVerifier accountVerifier;

    public Account(String symbols) {
        validateInput(symbols);
        this.symbols = symbols;
        this.accountNumber = symbolsToDigits();
        this.accountVerifier = new AccountVerifier(accountNumber);
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public boolean isValid() {
        return accountVerifier.isValid();
    }

    public boolean isIllegible() {
        return accountVerifier.isIllegible();
    }

    public String getAccountInfo() {
        StringBuilder sb = new StringBuilder(accountNumber);
        if (isIllegible()) {
            sb.append(" ILL");
        } else {
            if (!isValid()) {
                sb.append(" ERR");
            }
        }
        return sb.toString();
    }

    private void validateInput(String symbols) {
        if (!symbols.matches(SYMBOLS_PATTERN)) {
            String message = "Oops! " + symbols + " does not look like valid input. " +
            "Valid symbols need to match the following pattern" + SYMBOLS_PATTERN;
            throw new InvalidAccountPatternException(message);
        }
    }

    private String symbolsToDigits() {
        DigitRecognizer digitRecognizer = new DigitRecognizer();
        StringBuilder accountString = new StringBuilder();
        for (int i = 0; i < ACCOUNT_DIGITS; i++) {
            accountString.append(digitRecognizer.getDigit(extractSymbols(i)));
        }
        return accountString.toString();
    }

    private String extractSymbols(int digitIndex) {
        StringBuilder digitString = new StringBuilder();
        String[] lines = symbols.split("\n");
        for (String line : lines) {
            digitString.append(line.substring(digitIndex * DIGIT_WIDTH, (digitIndex + 1) * DIGIT_WIDTH));
        }
        return digitString.toString();
    }
}
