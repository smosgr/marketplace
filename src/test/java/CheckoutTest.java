import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckoutTest {

    /*
     *
     * 1. Checkout single product
     * 2. Checkout 001, 002, 003
     * 3. Checkout 002, 003 and apply promotion (over £60)
     * 4. Checkout 001, 001 and apply promotion (2-4-minus10%) and print total
     * 5. Checkout no product, total = 0
     *
     */

    @Test
    public void whenNoItemIsScannedTotalPriceIsZero() {

        Checkout checkout = new Checkout();
        double total = checkout.calculateTotal();
        System.out.println(total);
        assertEquals("Total cost of no items is zero ", 0, total, 0);
    }

    @Test
    public void whenSingleItemIsScannedTotalPriceIsUpdated() {

        Checkout checkout = new Checkout();
        Item item = new Item("001", "Travel Card Holder", 9.25);
        checkout.scan(item);
        double total = checkout.calculateTotal();
        System.out.println(total);
        assertEquals("Total cost of 1 travel card holder: ", 9.25, total, 0);
    }

    @Test
    public void whenMultipleItemsAreScannedTotalPriceIsUpdated() {

        Checkout checkout = new Checkout();
        Item item1 = new Item("001", "Travel Card Holder", 9.25);
        Item item2 = new Item("002", "Personalised cufflinks", 45.00);
        Item item3 = new Item("003", "Kids T-shirt", 19.95);

        checkout.scan(item1);
        checkout.scan(item2);
        checkout.scan(item3);

        double total = checkout.calculateTotal();
        System.out.println(total);
        assertEquals("Total cost of 1 travel card holder, 1 pair of personalised cufflinks and 1 kids t-shirt: ", 74.20, total, 0);
    }

    @Test
    public void whenTotalPriceIsCalculatedPromotionRulesGetApplied() {

        //given
        PromotionRules promotionRules = new PromotionRules();
        Checkout checkout = new Checkout(promotionRules);
        Item item1 = new Item("001", "Travel Card Holder", 9.25);
        Item item2 = new Item("002", "Personalised cufflinks", 45.00);
        Item item3 = new Item("003", "Kids T-shirt", 19.95);

        //when
        checkout.scan(item1);
        checkout.scan(item2);
        checkout.scan(item3);

        //then
        double total = checkout.calculateTotal();
        System.out.println(total);
        assertEquals("Total cost of 1 travel card holder, 1" +
                " pair of personalised cufflinks and 1 kids t-shirt with 10% off discount: ", 66.78, total, 0);
    }
}
