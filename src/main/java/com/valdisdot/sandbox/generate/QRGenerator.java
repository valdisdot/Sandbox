package com.valdisdot.sandbox.generate;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class QRGenerator {
    Function<byte[], Integer> checksumFunction;
    UnaryOperator<byte[]> encryptFunction;
    private String prefix;
    private long type;
    private long cashRegisterNumber;
    private long salesPoint;
    private long pseudoRandom;
    private long unixTime;
    private long days;
    private long price;
    private long cell;
    private long range;
    private String postfix;

    public QRGenerator(Function<byte[], Integer> checksumFunction, UnaryOperator<byte[]> encryptFunction) {
        this.checksumFunction = checksumFunction;
        this.encryptFunction = encryptFunction;
    }


    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setQRCodeType(char type) {
        this.type = type;
    }

    public void setCashRegister(int cashRegisterNumber) {
        this.cashRegisterNumber = cashRegisterNumber;
    }

    public void setSalesPoint(int salesPoint) {
        this.salesPoint = salesPoint;
    }

    public void setPseudoRandom(int pseudoRandom) {
        this.pseudoRandom = pseudoRandom;
    }

    public void setUnixTimeSecond(long seconds) {
        unixTime = seconds;
    }

    public void setValidityDays(int days) {
        this.days = days;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPLUCell(int cell) {
        this.cell = cell;
    }

    public void setPLURange(int range) {
        this.range = range;
    }

    public void setPostfix(String postfix) {
        this.postfix = postfix;
    }

    public String getQRCode() {
        int shift = 8 * 13;
        long holder = type << shift;
        shift -= 6;
        holder += cashRegisterNumber << shift;
        shift -= 10;
        holder += salesPoint << shift;
        shift -= 8;
        holder += pseudoRandom << shift;
        shift -= 32;
        holder += unixTime << shift;
        shift -= 8;
        holder += days << shift;
        shift -= 16;
        holder += price << shift;
        shift -= 16;
        holder += cell << shift;
        holder += range;
        holder = holder << 16;
        holder += checksumFunction.apply(CryptoUtil.getBytes(holder));
        return prefix + CryptoUtil.writeBytesAsHEXString(encryptFunction.apply(CryptoUtil.getBytes(holder))) + postfix;
    }
}
