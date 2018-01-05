package WalletContents;

import java.util.Calendar;

public abstract class WalletItem{

    protected String name;
    protected double valueUSD;
    protected double amountOwned;   // double is accurate to up to 15 decimal digits
                                    // 1 USD in BTC requires about 10 decimal digits
    protected double valueDisplayed;
    protected Calendar dateUpdated;

    public WalletItem(String name, double amountOwned, double valueUSD, double valueDisplayed){
        this.name = name;
        this.amountOwned = amountOwned;
        this.valueUSD = valueUSD;
        this.valueDisplayed = valueDisplayed;

    }

    public void updateValue(String URL){
        System.out.println(URL);



        // sets the date to the current date and time
        dateUpdated = Calendar.getInstance();

    }





}