import java.util.ArrayList;
import java.util.List;

public class Checkout {

    List<Item> items = new ArrayList<>();
    List<PromotionRule> promos = new ArrayList<>();

    Checkout() {
    }

    public Checkout(List<PromotionRule> promotionRules) {
        this.promos = promotionRules;
        System.out.println(promos.get(0));

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





