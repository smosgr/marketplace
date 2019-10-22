import java.util.ArrayList;
import java.util.List;

public class Checkout {

    List<Item> items = new ArrayList<>();
    List<PromotionRule> promos;

    public Checkout(List<PromotionRule> promos) {
        this.promos = promos;
    }

    public void scan(Item item) {
        items.add(item);
    }

    public Double calculateTotal() {

        Double total = getSum();

        if (promos.size() > 0) {
            total = getTotalWithDiscount(total);
        }
        return total;
    }

    private Double getSum() {
        return items.stream()
                .map(Item::getPrice)
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    private Double getTotalWithDiscount(Double total) {

        for (PromotionRule promotionRule : promos) {

            if (promotionRule.getDiscount().toString().equals("Amount")) {

                total = applyDiscount(total, promotionRule);
            } else if (promotionRule.getDiscount().toString().equals("Item")) {

                applyDiscount(promotionRule);
                total = getSum();
            }
        }

        return total;
    }

    private void applyDiscount(PromotionRule promotion) {
        long productCodeCount = getProductCodeCount(promotion);

        if (productCodeCount >= promotion.getItemsNumber()) {

            for (Item item : items) {

                if (item.getProductCode().equals(promotion.getProductCode())) {
                    item.setPrice(promotion.getDiscountValue());
                }
            }

        }
    }

    private Double applyDiscount(Double total, PromotionRule promotion) {
        if (total > promotion.getThreshold()) {
            total -= (total * promotion.getDiscountValue()) / 100;
        }
        return total;
    }

    private long getProductCodeCount(PromotionRule promotion) {
        return items.stream()
                .map(items -> items.productCode)
                .filter(items -> items.equals(promotion.getProductCode()))
                .count();
    }
}
