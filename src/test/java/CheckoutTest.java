import org.junit.Before;
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
     * X - 6. Checkout several products and apply both promotions
     *
     */

    Item item1;
    Item item2;
    Item item3;
    PromotionRule promotionAbove60;
    PromotionRule promotionOnItem;
    List<PromotionRule> promos;
    Checkout checkout;

    @Before
    public void init() {
        item1 = new Item("001", "Travel Card Holder", 9.25);
        item2 = new Item("002", "Personalised cufflinks", 45.00);
        item3 = new Item("003", "Kids T-shirt", 19.95);

        promotionOnItem = new PromotionRule(PromotionRule.DiscountType.Item, 8.5, 2, "001");
        promotionAbove60 = new PromotionRule(PromotionRule.DiscountType.Amount, 10.00, 60.00);

        promos = new ArrayList<>();
        checkout = new Checkout(promos);
    }

    @Test
    public void checkoutWithZeroItems() {
        //when
        Double total = checkout.calculateTotal();
        //then
        assertEquals("Total cost of no items is zero", 0.00, total, 0);
    }

    @Test
    public void checkoutWithSingleItem() {
        //given
        checkout.scan(item1);
        //when
        Double total = checkout.calculateTotal();
        //then
        assertEquals("Total cost of 1 travel card holder: ", 9.25, total, 0);
    }

    @Test
    public void checkoutWithMultipleItems() {
        //given
        checkout.scan(item1);
        checkout.scan(item2);
        checkout.scan(item3);
        //when
        Double total = checkout.calculateTotal();
        //then
        assertEquals("Total cost of 1 travel card holder, 1 pair of personalised cufflinks and 1 kids t-shirt: ", 74.21, total, 0);
    }

    @Test
    public void checkoutGreaterThanSixtyPoundsGetsTenPercentOff() {

        //given
        promos.add(promotionAbove60);
        checkout.scan(item1);
        checkout.scan(item2);
        checkout.scan(item3);

        //when
        Double total = checkout.calculateTotal();

        //then
        assertEquals("Total cost of 1 travel card holder, 1" +
                " pair of personalised cufflinks and 1 kids t-shirt with 10% off discount: ", 66.79, total, 0);
    }

    @Test
    public void checkoutTwoItemsTheItemPriceGetsReduced() {

        //given
        promos.add(promotionOnItem);
        checkout.scan(item1);
        checkout.scan(item1);
        //when
        Double total = checkout.calculateTotal();
        //then
        assertEquals("Total cost of 2 travel card holders with discount", 17.00, total, 0);
    }

    @Test
    public void checkoutSeveralItemsAndBothPromotionsAreApplied() {

        //given
        promos.add(promotionOnItem);
        promos.add(promotionAbove60);
        checkout.scan(item1);
        checkout.scan(item1);
        checkout.scan(item2);
        checkout.scan(item3);
        //when
        Double total = checkout.calculateTotal();

        //then
        assertEquals("", 73.76, total, 0);
    }

    @Test
    public void checkoutSeveralItemsAndBothPromotionsAreApplied_rounded() {

        //given
        promos.add(promotionOnItem);
        promos.add(promotionAbove60);
        checkout.scan(item1);
        checkout.scan(item2);
        checkout.scan(item1);
        checkout.scan(item3);
        //when
        Double total = checkout.calculateTotal();

        //then
        assertEquals("", 73.76, total, 0);
    }
}
