package com.valdisdot.sandbox.generate;

import java.util.function.Function;

public class CRC16ARCFunction implements Function<byte[], Integer> {
    // CRC16/ARC polynomial (0x8005) with initial value 0x0000
    private final int POLYNOMIAL = 0x8005;
    private final int INITIAL_VALUE = 0x0000;

    @Override
    public Integer apply(byte[] data) {
        int crc = INITIAL_VALUE;

        for (byte b : data) {
            crc ^= (b << 8);

            for (int i = 0; i < 8; i++) {
                if ((crc & 0x8000) != 0) {
                    crc = (crc << 1) ^ POLYNOMIAL;
                } else {
                    crc = crc << 1;
                }
            }
        }
        return crc & 0xFFFF;
    }
}
