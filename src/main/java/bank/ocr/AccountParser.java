package bank.ocr;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountParser {

    public List<String> parseAccounts(String accountsSymbols) {
        List<String> allMatches = new ArrayList<String>();
        Matcher m = Pattern.compile(Account.SYMBOLS_PATTERN).matcher(accountsSymbols);
        while (m.find()) {
            Account account = new Account(m.group());
            allMatches.add(account.getAccountNumber());
        }
        return allMatches;
    }
}
