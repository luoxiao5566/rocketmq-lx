package com.example.rocket.demo.controller;

import java.math.BigInteger;

public class demo {
    public static void main(String[] args) {
        long big = 123456789987654321L;
        String str = new BigInteger(String.valueOf(big),10).toString(32);
        String rstr = new BigInteger(str,32).toString(10);
        System.out.println("转换后：" + str + "恢复后" + rstr);
    }
}
