import java.util.ArrayList;
import java.util.List;

public class Checkout {

    List<Item> items = new ArrayList<>();
    List<PromotionRule> promos = new ArrayList<>();

    Checkout() {
    }

    public Checkout(List<PromotionRule> promos) {
        this.promos = promos;
    }

    public void scan(Item item) {
        items.add(item);
    }

    public Double calculateTotal() {

        double total = items.stream()
                .map(Item::getPrice)
                .mapToDouble(Double::doubleValue)
                .sum();

        if (promos.size() > 0) {
            total = getTotalWithDiscount(total);
        }
        return total;
    }

    private double getTotalWithDiscount(double total) {
        PromotionRule promotion = promos.get(0);

        if (promotion.getDiscount().toString().equals("Amount")) {
            total = applyDiscount(total, promotion);
        }
        return total;
    }

    private double applyDiscount(double total, PromotionRule promotion) {
        if (total > promotion.getThreshold()) {
            total -= (total * promotion.getPercentageApplied()) / 100;
        }
        return total;
    }
}





