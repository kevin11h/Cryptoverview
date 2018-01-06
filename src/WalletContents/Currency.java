package WalletContents;


import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.Calendar;


public abstract class Currency {

    protected String baseURL = "https://api.coinmarketcap.com/v1/ticker/";

    protected String name;          // name of coin/token as displayed on coinmarketcap
    protected double USDperUnit;    // how much each coin/token is worth in USD
    protected double amountOwned;   // double is accurate to up to 15 decimal digits
                                    // 1 USD in BTC requires about 10 decimal digits
    protected double valueDisplayed; // can be displayed in USD, EUR, SEK or BTC for instance
    protected Calendar dateUpdated; // last time the value was refreshed (contains timestamp too)

    public Currency(String name, double amountOwned){
        this.name = name;
        this.amountOwned = amountOwned;
        updateValue(); // sets USDperUnit, valueDisplayed and dateUpdated

    }

    public String toString(){
        return "<" + name + ": " + amountOwned + ", price: " + USDperUnit + ", total value: " + valueDisplayed + ">";
    }

    /**
     * Updates the value of the USDperUnit field, also updates the valueDisplayed field and
     * refreshes the date of the most recent update.
     */
    public void updateValue(){

        // get the document
        try {
            String json = Jsoup.connect(baseURL+name+"/")
                    .ignoreContentType(true).execute().body(); // gets a JSON file
                    // from coinmarketcap, containing info about the cryptocurrency

            for(String line : json.split("\n") ){ // iterate through the json-fields

                line = line.trim(); // remove whitespace
                if(line.startsWith("\"price_usd\":")){ // selects the price field
                    int len = line.length();
                    int start = "\"price_usd\": \"".length();

                    String price = line.substring(start,
                            len - ("\",".length())          // the ", at the end
                    );                                          // should be excluded


                    USDperUnit = Double.parseDouble(price); // updates the instance variable
                }
            }

        // in case retrieving data from the API fails
        } catch (IOException e) {
            System.out.println("Check your internet connection and that " +
                    "coinmarketcap.com is available");
            e.printStackTrace();
        }


        // update the total value of amount and price/unit
        valueDisplayed = USDperUnit*amountOwned; //TODO see setValueDisplayed metod below

        // sets the date to the current date and time
        dateUpdated = Calendar.getInstance();

    }

    public void setValueDisplayed(double valueDisplayed){
        //TODO change to convert between fiat currencies (mby even BTC)?
    }





}