package com.gooddata.dojo.springxd;

public class GoodDataActivator {

    public void loadToGoodData(String payload) {
        System.out.println("Incomming message:\n" + payload);
    }
}
