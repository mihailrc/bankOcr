package bank.ocr;

import java.io.*;

public class FileUtil {

    public static final int BUFFER_SIZE = 4096;

    public static int copy(Reader in, Writer out) throws IOException {
        try {
            int byteCount = 0;
            char[] buffer = new char[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
                byteCount += bytesRead;
            }
            out.flush();
            return byteCount;
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
            }
            try {
                out.close();
            } catch (IOException ex) {
            }
        }
    }

    public static String readToString(File in) throws IOException {
        StringWriter out = new StringWriter();
        copy(new FileReader(in), out);
        return out.toString();
    }

    public static void writeToFile(String contents, File out) throws IOException {
        FileWriter fw = new FileWriter(out);
        StringReader sr = new StringReader(contents);
        copy(sr, fw);
    }
}
