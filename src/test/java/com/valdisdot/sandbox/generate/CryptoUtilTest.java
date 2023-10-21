package com.valdisdot.sandbox.generate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CryptoUtilTest {
    @Test
    public void testCryptoUtils() {
        String givenHEXString = "0102";
        String givenBase64String = "AQI="; //generated online with 'base64.guru/converter/encode/hex'
        byte[] givenByteArray = new byte[]{1, 2};

        //test reads from string
        assertArrayEquals(givenByteArray, CryptoUtil.readBytesFromBase64String(givenBase64String));
        assertArrayEquals(givenByteArray, CryptoUtil.readBytesFromHEXString(givenHEXString));
        //test writes into string
        assertEquals(givenHEXString, CryptoUtil.writeBytesAsHEXString(givenByteArray));
        assertEquals(givenBase64String, CryptoUtil.writeBytesAsBase64String(givenByteArray));
    }
}
