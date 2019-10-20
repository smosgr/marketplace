import java.util.ArrayList;
import java.util.List;

public class Checkout {

    private PromotionRules promotionRules;

    Checkout(PromotionRules promotionRules) {
        this.promotionRules = promotionRules;
    }

    Checkout() {
    }

    List<Item> items = new ArrayList<>();

    public void scan(Item item) {
        items.add(item);
    }

    public Double calculateTotal() {

        return items.stream()
                .map(Item::getPrice)
                .mapToDouble(Double::doubleValue)
                .sum();
    }
}
