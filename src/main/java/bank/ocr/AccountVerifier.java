package bank.ocr;

import bank.ocr.exceptions.IllegibleAccountNumberException;

public class AccountVerifier {

    private String accountNumber;

    public AccountVerifier(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int checksum() {
        validateInput();
        int checksum = 0;
        for (int i = 0; i < 9; i++) {
            checksum = checksum + Integer.valueOf(accountNumber.substring(i, i + 1)) * (9 - i);
        }
        return checksum % 11;
    }


    public boolean isIllegible() {
        return !isLegible();
    }


    public boolean isValid() {
        return isLegible() && checksum() == 0;
    }

    private boolean isLegible() {
        return accountNumber.matches("\\d{9}");

    }

    private void validateInput() {
        if (isIllegible()) {
            throw new IllegibleAccountNumberException("Cannot calculate checksum for " + accountNumber);
        }
    }


}
