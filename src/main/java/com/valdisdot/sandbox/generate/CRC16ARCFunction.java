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
            //refIn for ARC is true
            b = reflectByte(b);
            crc ^= (b << 8) & 0xffff;

            for (int i = 0; i < 8; i++) {
                if ((crc & 0x8000) != 0) {
                    crc = ((crc << 1) ^ POLYNOMIAL) & 0xffff;
                } else {
                    crc = (crc << 1) & 0xffff;
                }
            }
        }
        //refOut for ARC is true
        return reflectInt(crc & 0xFFFF);
    }

    private byte reflectByte(byte value) {
        byte reflectedValue = 0;
        for (int i = 0; i < 8; i++) {
            if ((value & (1 << i)) != 0) {
                reflectedValue |= (byte) (1 << (7 - i));
            }
        }
        return reflectedValue;
    }

    private int reflectInt(int value) {
        int reflectedValue = 0;
        for (int i = 0; i < 16; i++) {
            if ((value & (1 << i)) != 0) {
                reflectedValue |= (1 << (15 - i));
            }
        }
        return reflectedValue;
    }
}
