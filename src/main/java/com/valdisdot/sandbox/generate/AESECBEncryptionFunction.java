package com.valdisdot.sandbox.generate;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.function.UnaryOperator;

public class AESECBEncryptionFunction implements UnaryOperator<byte[]> {
    // 16-character key for AES-128
    private final String secretKey;

    public AESECBEncryptionFunction(String secretKey) {
        this.secretKey = secretKey;
    }

    @Override
    public byte[] apply(byte[] data) {
        try {
            //create a secret key specification
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
            //create a cipher object and set it to encryption mode with ECB
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            //encrypt and return data
            return cipher.doFinal(data);
        } catch (Exception e) {
            return new byte[0];
        }
    }
}
