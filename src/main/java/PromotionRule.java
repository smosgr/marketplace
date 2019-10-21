public class PromotionRule {

    private double threshold;
    private double percentageApplied;
    private int itemsNumber;
    private DiscountType discount;

    private String productCode;

    enum DiscountType {
        Amount, Item;


    }
    public PromotionRule(DiscountType discountType, double percentageApplied, double threshold) {
        this.percentageApplied = percentageApplied;
        this.threshold = threshold;
        this.discount = discountType;
    }
    public PromotionRule(DiscountType discountType, double percentageApplied, int itemsNumber, String productCode) {
        this.percentageApplied = percentageApplied;
        this.itemsNumber = itemsNumber;
        this.discount = discountType;
        this.productCode = productCode;
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

    public int getItemsNumber() {
        return itemsNumber;
    }

    public String getProductCode() {
        return productCode;
    }
}
