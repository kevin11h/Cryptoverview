package Cryptoverview;

import WalletContents.*;

import java.util.HashMap;

public class Wallet {
    HashMap<String, Currency> currencies;


    public Wallet(){
        currencies = new HashMap<>();
    }



    public Currency[] toArray(){
        return (Currency[])currencies.entrySet().toArray();
    }
}
