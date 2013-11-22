package bank.ocr;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountParser {

    //three lines of 27 spaces _ or | followed by one line of 27 spaces
    public static final String ACCOUNT_SYMBOLS_PATTERN = "([ _|]{27}\n){3} {27}\n";

    public List<String> parseAccounts(String accountsSymbols) {
        List<String> allMatches = new ArrayList<String>();
        Matcher m = Pattern.compile(ACCOUNT_SYMBOLS_PATTERN).matcher(accountsSymbols);
        while (m.find()) {
            Account account = new Account(m.group());
            allMatches.add(account.getAccountNumber());
        }
        return allMatches;
    }
}
