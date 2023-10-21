package com.valdisdot.sandbox.generate;

import java.util.Base64;

public class CryptoUtil {
    public static String writeBytesAsHEXString(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) hexString.append(String.format("%02X", b));
        return hexString.toString();
    }

    public static String writeBytesAsBase64String(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static byte[] readBytesFromHEXString(String hexString) {
        int len = hexString.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
                    + Character.digit(hexString.charAt(i + 1), 16));
        }
        return data;
    }

    public static byte[] readBytesFromBase64String(String string) {
        return Base64.getDecoder().decode(string);
    }
}
