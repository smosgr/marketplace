import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CheckoutTest {

    /*
     *
     * X - 1. Checkout single product
     * X - 2. Checkout 001, 002, 003
     * X - 3. Checkout 002, 003 and apply promotion (over £60)
     * X - 4. Checkout 001, 001 and apply promotion (2-4-minus10%)
     * X - 5. Checkout no product, total = 0
     *
     */

    @Test
    public void checkoutWithZeroItems() {

        //given
        Checkout checkout = new Checkout();
        //when
        double total = checkout.calculateTotal();
        //then
        assertEquals("Total cost of no items is zero", 0, total, 0);
    }

    @Test
    public void checkoutWithSingleItem() {

        //given
        Checkout checkout = new Checkout();
        Item item = new Item("001", "Travel Card Holder", 9.25);
        checkout.scan(item);
        //when
        double total = checkout.calculateTotal();
        //then
        assertEquals("Total cost of 1 travel card holder: ", 9.25, total, 0);
    }

    @Test
    public void checkoutWithMultipleItems() {

        //given
        Checkout checkout = new Checkout();
        Item item1 = new Item("001", "Travel Card Holder", 9.25);
        Item item2 = new Item("002", "Personalised cufflinks", 45.00);
        Item item3 = new Item("003", "Kids T-shirt", 19.95);
        checkout.scan(item1);
        checkout.scan(item2);
        checkout.scan(item3);
        //when
        double total = checkout.calculateTotal();
        //then
        assertEquals("Total cost of 1 travel card holder, 1 pair of personalised cufflinks and 1 kids t-shirt: ", 74.20, total, 0);
    }

    @Test
    public void checkoutGreaterThanSixtyPoundsGetsTenPercentOff() {

        //given
        Item item1 = new Item("001", "Travel Card Holder", 9.25);
        Item item2 = new Item("002", "Personalised cufflinks", 45.00);
        Item item3 = new Item("003", "Kids T-shirt", 19.95);

        List<PromotionRule> promos = new ArrayList<>();
        PromotionRule promotionRule = new PromotionRule(PromotionRule.DiscountType.Amount, 10.00, 60.00);
        promos.add(promotionRule);

        Checkout checkout = new Checkout(promos);
        checkout.scan(item1);
        checkout.scan(item2);
        checkout.scan(item3);

        //when
        Double total = checkout.calculateTotal();

        //then
        assertEquals("Total cost of 1 travel card holder, 1" +
                " pair of personalised cufflinks and 1 kids t-shirt with 10% off discount: ", 66.78, total, 0);
    }

    @Test
    public void checkoutTwoItemsTheItemPriceGetsReduced() {

        //given
        Item item1 = new Item("001", "Travel Card Holder", 9.25);

        List<PromotionRule> promos = new ArrayList<>();
        PromotionRule promotionRule = new PromotionRule(PromotionRule.DiscountType.Item, 8.5, 2, "001");
        promos.add(promotionRule);

        Checkout checkout = new Checkout(promos);
        checkout.scan(item1);
        checkout.scan(item1);
        //when
        Double total = checkout.calculateTotal();
        //then
        assertEquals("Total cost of 3 travel card holders with discount", 17, total, 0);
    }
}
