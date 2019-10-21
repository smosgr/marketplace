public class PromotionRule {

    private double threshold;
    private double discountValue;
    private int itemsNumber;
    private DiscountType discount;

    private String productCode;

    enum DiscountType {
        Amount, Item;
    }
    public PromotionRule(DiscountType discountType, double discountValue, double threshold) {
        this.discountValue = discountValue;
        this.threshold = threshold;
        this.discount = discountType;
    }
    public PromotionRule(DiscountType discountType, double discountValue, int itemsNumber, String productCode) {
        this.discountValue = discountValue;
        this.itemsNumber = itemsNumber;
        this.discount = discountType;
        this.productCode = productCode;
    }

    public DiscountType getDiscount() {
        return discount;
    }

    public double getDiscountValue() {
        return discountValue;
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
