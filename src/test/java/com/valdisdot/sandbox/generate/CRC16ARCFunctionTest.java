package com.valdisdot.sandbox.generate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CRC16ARCFunctionTest {
    @Test
    public void testCRC16ARC() {
        //generated online 'www.texttool.com/crc-online'
        Integer expectedCRC = 9551;
        byte[] inputData = "the test text".getBytes();
        assertEquals(expectedCRC, new CRC16ARCFunction().apply(inputData));
    }
}
