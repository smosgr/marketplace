public class PromotionRule {

    private double threshold;
    private double percentageApplied;
    private DiscountType discount;

    enum DiscountType {
        Amount, Item;
    }

    public PromotionRule(DiscountType discountType, double percentageApplied, double threshold) {
        this.percentageApplied = percentageApplied;
        this.threshold = threshold;
        this.discount = discountType;
    }

    public DiscountType getDiscount() {
        return discount;
    }

    public double getPercentageApplied() {
        return percentageApplied;
    }

    public double getThreshold() {
        return threshold;
    }
}
