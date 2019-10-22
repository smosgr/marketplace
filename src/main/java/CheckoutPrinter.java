public class CheckoutPrinter {

    public static final String currency_GB = "£";

    public String print(String price, String items) {

        return "Basket: " + items + "\n"
                + "Price:  " + currency_GB + price;
    }
}
