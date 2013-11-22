package bank.ocr;

public enum Digits {

    ZERO(
    " _ " +
    "| |" +
    "|_|" +
    "   ", "0"),

    ONE(
    "   " +
    "  |" +
    "  |" +
    "   ", "1"),

    TWO(
    " _ " +
    " _|" +
    "|_ " +
    "   ", "2"),

    THREE(
    " _ " +
    " _|" +
    " _|" +
    "   ", "3"),

    FOUR(
    "   " +
    "|_|" +
    "  |" +
    "   ", "4"),

    FIVE(
    " _ " +
    "|_ " +
    " _|" +
    "   ", "5"),

    SIX(
    " _ " +
    "|_ " +
    "|_|" +
    "   ", "6"),

    SEVEN(
    " _ " +
    "  |" +
    "  |" +
    "   ", "7"),

    EIGHT(
    " _ " +
    "|_|" +
    "|_|" +
    "   ", "8"),

    NINE(
    " _ " +
    "|_|" +
    " _|" +
    "   ", "9");

    public static final String SYMBOLS_PATTERN = "[ _|]{12}";

    public static boolean hasExpectedPattern(String symbols) {
        return symbols != null && symbols.matches(SYMBOLS_PATTERN);
    }

    private String symbols;
    private String digit;

    private Digits(String symbols, String digit) {
        this.symbols = symbols;
        this.digit = digit;
    }

    public String getSymbols() {
        return symbols;
    }

    public String getDigit() {
        return digit;
    }

}
