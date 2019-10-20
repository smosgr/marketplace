import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckoutTest {

    /*
     *
     * 1. Checkout single product
     * 2. Checkout 001, 002, 003
     * 3. Checkout 002, 003 and apply promotion (over £60)
     * 4. Checkout 001, 001 and apply promotion (2-4-minus10%) and print total
     *
     */

    @Test
    public void whenSingleItemIsScannedTotalPriceIsUpdated() {

        Checkout checkout = new Checkout();
        Item item = new Item("001", "Travel Card Holder", 9.25);
        checkout.scan(item);
        double total = checkout.calculateTotal();
        assertEquals("", 9.25, total, 1);
    }
}
