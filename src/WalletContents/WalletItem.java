package WalletContents;

import java.util.Calendar;

public abstract class WalletItem{

    protected String name;          // name of coin/token as displayed on coinmarketcap
    protected double USDperItem;    // how much each coin/token is worth in USD
    protected double amountOwned;   // double is accurate to up to 15 decimal digits
                                    // 1 USD in BTC requires about 10 decimal digits
    protected double valueDisplayed; // can be displayed in USD, EUR, SEK or BTC for instance
    protected Calendar dateUpdated; // last time the value was refreshed (contains timestamp too)

    public WalletItem(String name, double amountOwned, double USDperItem, double valueDisplayed){
        this.name = name;
        this.amountOwned = amountOwned;
        this.USDperItem = USDperItem;
        this.valueDisplayed = valueDisplayed;

    }

    public void updateValue(String URL){
        System.out.println(URL); //debug



        // sets the date to the current date and time
        dateUpdated = Calendar.getInstance();

    }





}