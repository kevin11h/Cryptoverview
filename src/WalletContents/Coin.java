package WalletContents;

public class Coin extends WalletItem {

    private static final String priceListURL = "https://coinmarketcap.com/coins/";



    public Coin(String name, double amountOwned, double USDperCoin, double valueDisplayed) {
        super(name, amountOwned, USDperCoin, valueDisplayed);
        updateValue(priceListURL);
    }

    @Override
    public void updateValue(String URL) {
        super.updateValue(priceListURL);
    }

}