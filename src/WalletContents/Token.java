package WalletContents;

public class Token extends WalletItem {

    private static final String priceListURL = "https://coinmarketcap.com/tokens/";


    public Token(String name, double amountOwned, double USDperToken, double valueDisplayed) {
        super(name, amountOwned, USDperToken, valueDisplayed);
    }

}