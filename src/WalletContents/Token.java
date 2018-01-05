package WalletContents;

public class Token extends WalletItem {

    private static final String priceListURL = "https://coinmarketcap.com/tokens/";


    public Token(String name, double amountOwned, double valueUSD, double valueDisplayed) {
        super(name, amountOwned, valueUSD, valueDisplayed);
        updateValue(priceListURL);
    }

    @Override
    public void updateValue(String URL) {
        super.updateValue(priceListURL);
    }
}