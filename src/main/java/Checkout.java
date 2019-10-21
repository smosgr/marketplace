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
        } else if (promotion.getDiscount().toString().equals("Item")) {

            long count = getProductCodeCount(promotion);

            if (count >= promotion.getItemsNumber()) {
                System.out.println("-----------------------");

                //item price drops to 8.5
                // for each item with code = 001
                // update item price to 8.5
                // calculate total again!

            }
        }
        return total;
    }

    private long getProductCodeCount(PromotionRule promotion) {
        return items.stream()
                .map(items -> items.productCode)
                .filter(items -> items.equals(promotion.getProductCode()))
                .count();
    }

    private double applyDiscount(double total, PromotionRule promotion) {
        if (total > promotion.getThreshold()) {
            total -= (total * promotion.getPercentageApplied()) / 100;
        }
        return total;
    }
}





