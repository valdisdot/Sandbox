package com.valdisdot.sandbox.generate;

import org.junit.jupiter.api.Test;

public class QRGeneratorTest {
    @Test
    public void test(){
        String qrManual = "O33B21D56CEB132E4EE41DC5DCE591567S";
        String clientApiKey = "FAFAFAFAFAFAFAFAFAFAFAFAFAFAFAFA";

        QRGenerator generator = new QRGenerator(new CRC16ARCFunction(), new AESECBEncryptionFunction(CryptoUtil.readBytesFromHEXString(clientApiKey)));
        generator.setPrefix("O");
        generator.setQRCodeType((char) 0x83);
        generator.setCashRegister(0);
        generator.setSalesPoint(0);
        generator.setPseudoRandom(33);
        generator.setUnixTimeSecond(1692253450L);
        generator.setValidityDays(127);
        generator.setPrice(65500);
        generator.setPLUCell(0);
        generator.setPLURange(127);
        generator.setPostfix("S");
        System.out.println(generator.getQRCode());
    }
}
