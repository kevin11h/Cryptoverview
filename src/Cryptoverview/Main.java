package Cryptoverview;

import WalletContents.Coin;
import WalletContents.Currency;
import WalletContents.CurrencyComparator;
import WalletContents.Token;

import java.util.Arrays;

public class Main {


    public static void main(String[] args){
        Coin coin1 = new Coin("bitcoin", 0.05198964);
        Token token1 = new Token("SALT", 15.892113);
        Coin coin2 = new Coin("ethereum", 2.772357);
        Coin coin3 = new Coin("litecoin", 1.2272922);
        Coin coin4 = new Coin("ripple", 389.17);

        Currency[] currencies = {coin1, token1, coin2, coin3, coin4};

        System.out.println("\nUNSORTED");
        printArray(currencies);

        System.out.println("\n\nNAME SORTED");
        Arrays.sort(currencies, new CurrencyComparator.NameComparator());
        printArray(currencies);

        System.out.println("\n\nAMOUNT SORTED");
        Arrays.sort(currencies, new CurrencyComparator.AmountComparator());
        printArray(currencies);

        System.out.println("\n\nPRICE SORTED (reversed)");
        Arrays.sort(currencies, new CurrencyComparator.PriceComparator().reversed());
        printArray(currencies);

        System.out.println("\n\nVALUE SORTED");
        Arrays.sort(currencies, new CurrencyComparator.ValueComparator());
        printArray(currencies);

    }

    public static void printArray(Object[] array){
        System.out.print("[ ");
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]);
            if(i != array.length-1)
                System.out.println(", ");
            else
                System.out.print(" ]");
        }

    }
}
