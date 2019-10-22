public class CheckoutPrinter {

    public static final String currency_GB = "£";

    public void print(String price, String items) {

        System.out.println("Basket: " + items + "\n"
                + "Price:  " + currency_GB + price);
    }
}
