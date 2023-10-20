package com.valdisdot.sandbox.generate;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.function.UnaryOperator;

public class AESECBEncryptionFunction implements UnaryOperator<String> {
    // 16-character key for AES-128
    private String secretKey;

    public AESECBEncryptionFunction(String secretKey){
        this.secretKey = secretKey;
    }

    @Override
    public String apply(String plaintext) {
        try {
            // Create a secret key specification
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
            // Create a cipher object and set it to encryption mode with ECB
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            // Encrypt, convert and return the encrypted bytes to a base64-encoded string
            return Base64.getEncoder().encodeToString(cipher.doFinal(plaintext.getBytes("UTF-8")));
        } catch (Exception e){
            return "";
        }
    }
}
