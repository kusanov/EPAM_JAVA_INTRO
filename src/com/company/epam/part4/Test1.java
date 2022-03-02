package com.company.epam.part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class Test1 {
    private int var1;
    private int var2;


    int sum1() {
        return this.var1 + this.var2;
    }

    int max1() {
        return var1 > var2 ? var1 : var2;
    }

    public int getVar1() {
        return var1;
    }

    public void setVar1(int var1) {
        this.var1 = var1;
    }

    public int getVar2() {
        return var2;
    }

    public void setVar2(int var2) {
        this.var2 = var2;
    }
}