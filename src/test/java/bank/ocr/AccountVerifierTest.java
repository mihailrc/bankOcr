package bank.ocr;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class AccountVerifierTest {

    static Map<String, Integer> checksums = new HashMap<String, Integer>();

    {
        checksums.put("000000000", 0);
        checksums.put("457508000", 0);
        checksums.put("557508000", 9);
        checksums.put("457508005", 5);
    }

    @Test
    public void calculatesChecksum() {
        for (String accountNumber : checksums.keySet()) {
            assertEquals("Wrong checksum for " + accountNumber, checksums.get(accountNumber).intValue(),
            new AccountVerifier(accountNumber).checksum());
        }
    }

    @Test(expected = IllegibleAccountNumberException.class)
    public void throwsExceptionWhenCalculatingChecksumForIllegibleAccountNumber() {
        new AccountVerifier("abc").checksum();
        fail("Should throw exception");
    }

    @Test
    public void detectsValidAccountNumber() {
        assertTrue(new AccountVerifier("000000000").isValid());
        assertTrue(new AccountVerifier("457508000").isValid());
    }

    @Test
    public void detectsInvalidAccountNumber() {
        assertFalse(new AccountVerifier("???").isValid());
        assertFalse(new AccountVerifier("557508000").isValid());
    }
}