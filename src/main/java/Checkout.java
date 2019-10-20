import java.util.ArrayList;
import java.util.List;

public class Checkout {

    List<Item> items = new ArrayList<>();

    Checkout(PromotionRules promotionRules) {
    }

    Checkout() {
    }

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
