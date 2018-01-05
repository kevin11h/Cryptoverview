package WalletContents;

import jdk.nashorn.internal.ir.Node;
import jdk.nashorn.internal.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Calendar;


public abstract class WalletItem{

    protected String baseURL = "https://api.coinmarketcap.com/v1/ticker/";
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
        updateValue();

    }

    public void updateValue(){
        Document doc = null;

        // get the document
        try {
            String json = Jsoup.connect(baseURL+name+"/").ignoreContentType(true).execute().body(); // gets a JSON
            System.out.println(json);

            for(String line : json.split("\n") ){

                line = line.trim();
                if(line.startsWith("\"price_usd\":")){
                    int len = line.length();
                    int start = "\"price_usd\": \"".length();
                    String price = line.substring(start,
                            len-"\",".length());            // the ", at the end
                                                                // should be excluded

                    USDperItem = Double.parseDouble(price);
                }
            }

        // in case retrieving data from the API fails
        } catch (IOException e) {
            System.out.println("Check your internet connection and that " +
                    "coinmarketcap.com is available");
            e.printStackTrace();
        }



        // sets the date to the current date and time
        dateUpdated = Calendar.getInstance();

    }





}