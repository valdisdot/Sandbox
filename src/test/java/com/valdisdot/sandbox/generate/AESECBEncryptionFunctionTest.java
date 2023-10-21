package com.valdisdot.sandbox.generate;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AESECBEncryptionFunctionTest {
    @Test
    public void testAESEncryption() {
        String text = "the test text";
        String aesKey = "1234567890123456";
        //generated online 'devglan.com/online-tools/aes-encryption-decryption'
        String encryptedAsBase64 = "wsby+ih6HRD97UhveOWUpA==";
        String encryptedAsHEX = "C2C6F2FA287A1D10FDED486F78E594A4";

        UnaryOperator<byte[]> encryptor = new AESECBEncryptionFunction(aesKey);
        byte[] result = encryptor.apply(text.getBytes(StandardCharsets.US_ASCII));
        assertArrayEquals(CryptoUtil.readBytesFromHEXString(encryptedAsHEX), result);
        assertArrayEquals(CryptoUtil.readBytesFromBase64String(encryptedAsBase64), result);
    }
}
