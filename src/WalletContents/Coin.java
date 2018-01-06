package WalletContents;

public class Coin extends Currency {

    private static final String priceListURL = "https://coinmarketcap.com/coins/";



    public Coin(String name, double amountOwned) {
        super(name, amountOwned);
    }

}