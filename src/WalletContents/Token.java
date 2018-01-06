package WalletContents;

public class Token extends Currency {

    private static final String priceListURL = "https://coinmarketcap.com/tokens/";


    public Token(String name, double amountOwned) {
        super(name, amountOwned);
    }

}