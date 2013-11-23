package bank.ocr;

import bank.ocr.exceptions.InvalidAccountPatternException;

import java.util.*;

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

    private boolean isIllegible() {
        return accountVerifier.isIllegible();
    }

    public List<String> findValidAlternatives() {
        List<String> alternatives = new ArrayList<String>();
        for (int i = 0; i < ACCOUNT_DIGITS; i++) {
            alternatives.addAll(findValidAlternativesForIndex(i));
        }
        Collections.sort(alternatives);
        return alternatives;
    }

    public String getAccountWithStatus() {
        StringBuilder info = new StringBuilder(accountNumber);
        if (isIllegible()) {
            info.append(" ILL");
        } else {
            if (!isValid()) {
                info.append(" ERR");
            }
        }
        return info.toString();
    }

    public String getAccountInfo() {
        StringBuilder accountInfo = new StringBuilder();
        if (isValid()) {
            accountInfo.append(accountNumber);
        } else {
            List<String> alternatives = findValidAlternatives();
            if (alternatives.isEmpty()) {
                accountInfo.append(getAccountWithStatus());
            }
            if (alternatives.size() == 1) {
                accountInfo.append(alternatives.get(0));
            }
            if (alternatives.size() > 1) {
                accountInfo.append(accountNumber);
                accountInfo.append(" AMB ");
                accountInfo.append(quotedStrings(alternatives));
            }
        }
        return accountInfo.toString();
    }

    private List<String> quotedStrings(List<String> strings) {
        List<String> quotedStrings = new ArrayList<String>();
        for (String string : strings) {
            quotedStrings.add("'" + string + "'");
        }
        return quotedStrings;
    }

    private void validateInput(String symbols) {
        if (!symbols.matches(SYMBOLS_PATTERN)) {
            String message = "Oops! " + symbols + " does not look like valid input. " +
            "Valid symbols need to match the following pattern" + SYMBOLS_PATTERN;
            throw new InvalidAccountPatternException(message);
        }
    }

    private List<String> findValidAlternativesForIndex(int index) {
        List<String> alternatives = new ArrayList<String>();
        String digitSymbols = extractSymbols(index);
        List<String> alternativeDigits = new DigitRecognizer().getAlternatives(digitSymbols);
        for (String alternativeDigit : alternativeDigits) {
            String alternativeAccountNumber = swapDigit(index, alternativeDigit);
            if (new AccountVerifier(alternativeAccountNumber).isValid()) {
                alternatives.add(alternativeAccountNumber);
            }
        }
        return alternatives;
    }

    private String swapDigit(int index, String alternativeDigit) {
        StringBuilder alternativeAccountNumber = new StringBuilder(accountNumber.substring(0, index));
        alternativeAccountNumber.append(alternativeDigit);
        if (index + 1 <= accountNumber.length()) {
            alternativeAccountNumber.append(accountNumber.substring(index + 1));

        }
        return alternativeAccountNumber.toString();
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
