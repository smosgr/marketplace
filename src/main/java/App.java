import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Item item1 = new Item("001", "Travel Card Holder", 9.25);
        Item item2 = new Item("002", "Personalised cufflinks", 45.00);
        Item item3 = new Item("003", "Kids T-shirt", 19.95);

        PromotionRule promotionOnItem = new PromotionRule(PromotionRule.DiscountType.Item, 8.5, 2, "001");
        PromotionRule promotionAbove60 = new PromotionRule(PromotionRule.DiscountType.Amount, 10.00, 60.00);
        List<PromotionRule> promos = new ArrayList<>();
        promos.add(promotionOnItem);
        promos.add(promotionAbove60);

        Checkout co = new Checkout(promos);
        co.scan(item1);
        co.scan(item2);
        co.scan(item1);
        co.scan(item3);

        Double price = co.calculateTotal();
        String items = co.listItems();

        CheckoutPrinter cp = new CheckoutPrinter();
        cp.print(price.toString(), items);
    }
}
