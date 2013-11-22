package bank.ocr;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileAccountParser extends AccountParser {

    public FileAccountParser(File input) throws IOException {
        super(FileUtil.readToString(input));
    }

    public void writeAccountNumbers(File out) throws IOException {
        FileUtil.writeToFile(allAccountNumbers(), out);
    }

    private String allAccountNumbers() {
        List<String> accountNumbers = parseAccounts();
        StringBuilder sb = new StringBuilder();
        for (String accountNumber : accountNumbers) {
            sb.append(accountNumber);
            sb.append("\n");
        }
        return sb.toString();
    }
}
