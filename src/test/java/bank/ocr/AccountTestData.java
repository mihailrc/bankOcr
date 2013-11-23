package bank.ocr;

import java.util.*;

public class AccountTestData {

    public static Map<String, String> accountsMap = new LinkedHashMap<String, String>();
    public static Map<String, String> accountsWithStatusMap = new LinkedHashMap<String, String>();
    public static Map<String, String> accountsInfoMap = new LinkedHashMap<String, String>();

    static {
        accountsMap.put(
        " _  _  _  _  _  _  _  _  _ \n" +
        "| || || || || || || || || |\n" +
        "|_||_||_||_||_||_||_||_||_|\n" +
        "                           \n", "000000000");
        accountsMap.put(
        "                           \n" +
        "  |  |  |  |  |  |  |  |  |\n" +
        "  |  |  |  |  |  |  |  |  |\n" +
        "                           \n", "111111111");
        accountsMap.put(
        " _  _  _  _  _  _  _  _  _ \n" +
        " _| _| _| _| _| _| _| _| _|\n" +
        "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n" +
        "                           \n", "222222222");
        accountsMap.put(
        " _  _  _  _  _  _  _  _  _ \n" +
        " _| _| _| _| _| _| _| _| _|\n" +
        " _| _| _| _| _| _| _| _| _|\n" +
        "                           \n", "333333333");
        accountsMap.put(
        "                           \n" +
        "|_||_||_||_||_||_||_||_||_|\n" +
        "  |  |  |  |  |  |  |  |  |\n" +
        "                           \n", "444444444");
        accountsMap.put(
        " _  _  _  _  _  _  _  _  _ \n" +
        "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n" +
        " _| _| _| _| _| _| _| _| _|\n" +
        "                           \n", "555555555");
        accountsMap.put(
        " _  _  _  _  _  _  _  _  _ \n" +
        "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n" +
        "|_||_||_||_||_||_||_||_||_|\n" +
        "                           \n", "666666666");
        accountsMap.put(
        " _  _  _  _  _  _  _  _  _ \n" +
        "  |  |  |  |  |  |  |  |  |\n" +
        "  |  |  |  |  |  |  |  |  |\n" +
        "                           \n", "777777777");
        accountsMap.put(
        " _  _  _  _  _  _  _  _  _ \n" +
        "|_||_||_||_||_||_||_||_||_|\n" +
        "|_||_||_||_||_||_||_||_||_|\n" +
        "                           \n", "888888888");
        accountsMap.put(
        " _  _  _  _  _  _  _  _  _ \n" +
        "|_||_||_||_||_||_||_||_||_|\n" +
        " _| _| _| _| _| _| _| _| _|\n" +
        "                           \n", "999999999");
        accountsMap.put(
        "    _  _     _  _  _  _  _ \n" +
        "  | _| _||_||_ |_   ||_||_|\n" +
        "  ||_  _|  | _||_|  ||_| _|\n" +
        "                           \n", "123456789");
        accountsWithStatusMap.put(
        " _  _  _  _  _  _  _  _    \n" +
        "| || || || || || || ||_   |\n" +
        "|_||_||_||_||_||_||_| _|  |\n" +
        "                           \n", "000000051");
        accountsWithStatusMap.put(
        "    _  _  _  _  _  _     _ \n" +
        "|_||_|| || ||_   |  |  | _ \n" +
        "  | _||_||_||_|  |  |  | _|\n" +
        "                           \n", "49006771? ILL");
        accountsWithStatusMap.put(
        "    _  _     _  _  _  _  _ \n" +
        "  | _| _||_| _ |_   ||_||_|\n" +
        "  ||_  _|  | _||_|  ||_| _ \n" +
        "                           \n", "1234?678? ILL");
        accountsInfoMap.put(
        "                           \n" +
        "  |  |  |  |  |  |  |  |  |\n" +
        "  |  |  |  |  |  |  |  |  |\n" +
        "                           \n", "711111111");
        accountsInfoMap.put(
        " _  _  _  _  _  _  _  _  _ \n" +
        "  |  |  |  |  |  |  |  |  |\n" +
        "  |  |  |  |  |  |  |  |  |\n" +
        "                           \n", "777777177");
        accountsInfoMap.put(
        " _  _  _  _  _  _  _  _  _ \n" +
        " _|| || || || || || || || |\n" +
        "|_ |_||_||_||_||_||_||_||_|\n" +
        "                           \n", "200800000");
        accountsInfoMap.put(
        " _  _  _  _  _  _  _  _  _ \n" +
        " _| _| _| _| _| _| _| _| _|\n" +
        " _| _| _| _| _| _| _| _| _|\n" +
        "                           \n", "333393333");
        accountsInfoMap.put(
        " _  _  _  _  _  _  _  _  _ \n" +
        "|_||_||_||_||_||_||_||_||_|\n" +
        "|_||_||_||_||_||_||_||_||_|\n" +
        "                           \n", "888888888 AMB ['888886888', '888888880', '888888988']");
        accountsInfoMap.put(
        " _  _  _  _  _  _  _  _  _ \n" +
        "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n" +
        " _| _| _| _| _| _| _| _| _|\n" +
        "                           \n", "555555555 AMB ['555655555', '559555555']");
        accountsInfoMap.put(
        " _  _  _  _  _  _  _  _  _ \n" +
        "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n" +
        "|_||_||_||_||_||_||_||_||_|\n" +
        "                           \n", "666666666 AMB ['666566666', '686666666']");
        accountsInfoMap.put(
        " _  _  _  _  _  _  _  _  _ \n" +
        "|_||_||_||_||_||_||_||_||_|\n" +
        " _| _| _| _| _| _| _| _| _|\n" +
        "                           \n", "999999999 AMB ['899999999', '993999999', '999959999']");
        accountsInfoMap.put(
        "    _  _  _  _  _  _     _ \n" +
        "|_||_|| || ||_   |  |  ||_ \n" +
        "  | _||_||_||_|  |  |  | _|\n" +
        "                           \n", "490067715 AMB ['490067115', '490067719', '490867715']");
        accountsInfoMap.put(
        "    _  _     _  _  _  _  _ \n" +
        " _| _| _||_||_ |_   ||_||_|\n" +
        "  ||_  _|  | _||_|  ||_| _|\n" +
        "                           \n", "123456789");
        accountsInfoMap.put(
        " _     _  _  _  _  _  _    \n" +
        "| || || || || || || ||_   |\n" +
        "|_||_||_||_||_||_||_| _|  |\n" +
        "                           \n", "000000051");
        accountsInfoMap.put(
        "    _  _  _  _  _  _     _ \n" +
        "|_||_|| ||_||_   |  |  | _ \n" +
        "  | _||_||_||_|  |  |  | _|\n" +
        "                           \n", "490867715");
        accountsInfoMap.put(
        "    _  _  _  _  _  _     _ \n" +
        "|_||_|| ||_||_   |  |  | _ \n" +
        "  | _||_||_||_|  |  |    _|\n" +
        "                           \n", "4908677?? ILL");
    }

    public static String getAccountSymbols(Map<String, String> map) {
        return listToString(new ArrayList<String>(map.keySet()));
    }

    public static List<String> getAccountInfo(Map<String, String> map) {
        return new ArrayList<String>(map.values());
    }

    public static String getAccountInfoAsString(Map<String, String> map) {
        return listToString(getAccountInfo(map));
    }

    private static String listToString(List<String> values) {
        List<String> accountNumbers = values;
        StringBuilder sb = new StringBuilder();
        for (String accountNumber : accountNumbers) {
            sb.append(accountNumber);
            sb.append("\n");
        }
        return sb.toString();
    }

}
