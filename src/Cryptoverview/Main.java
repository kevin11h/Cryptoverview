package Cryptoverview;

import WalletContents.Coin;

public class Main {


    public static void main(String[] args){
        Coin test = new Coin("boi", 5.0, 10.0, 10.01);

        test.updateValue();


    }
}