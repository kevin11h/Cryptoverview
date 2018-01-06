package WalletContents;

import java.util.Comparator;

public class CurrencyComparator {


    // NAME COMPARATOR
    public static class NameComparator implements Comparator<Currency> {
        @Override
        public Comparator<Currency> reversed() {
            return (c1, c2) -> c2.name.compareToIgnoreCase(c1.name);
            // lambda notation for reverse comparisons
        }

        @Override
        public int compare(Currency c1, Currency c2) {
            return c1.name.compareToIgnoreCase(c2.name);
        }
    }



    // AMOUNT COMPARATOR
    public static class AmountComparator implements Comparator<Currency>{
        @Override
        public Comparator<Currency> reversed() {
            return Comparator.comparingDouble(c -> c.amountOwned);
            // lambda notation for reverse comparisons
        }

        @Override
        public int compare(Currency c1, Currency c2) {
            return Double.compare(c2.amountOwned, c1.amountOwned);
            // Double.compare naturally orders the smallest first
            // we want larger first
        }
    }


    // PRICE COMPARATOR
    public static class PriceComparator implements Comparator<Currency>{
        @Override
        public Comparator<Currency> reversed() {
            return Comparator.comparingDouble(c -> c.USDperUnit);
            // lambda notation for reverse comparisons
        }

        @Override
        public int compare(Currency c1, Currency c2) {
            return Double.compare(c2.USDperUnit, c1.USDperUnit);
            // see AmountComparator.compare for why c1 and c2 are flipped
        }
    }


    // VALUE COMPARATOR
    public static class ValueComparator implements Comparator<Currency>{
        @Override
        public Comparator<Currency> reversed() {
            return Comparator.comparingDouble(c -> c.valueDisplayed);
            // lambda notation for reverse comparisons
        }

        @Override
        public int compare(Currency c1, Currency c2) {
            return Double.compare(c2.valueDisplayed, c1.valueDisplayed);
            // see AmountComparator.compare for why c1 and c2 are flipped
        }
    }
}


