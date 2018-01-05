package WalletContents;

public class Coin extends WalletItem {

    private static final String priceListURL = "https://coinmarketcap.com/coins/";



    public Coin(String name, double amountOwned, double valueUSD, double valueDisplayed) {
        super(name, amountOwned, valueUSD, valueDisplayed);
        updateValue(priceListURL);
    }

    @Override
    public void updateValue(String URL) {
        super.updateValue(priceListURL);
    }

}