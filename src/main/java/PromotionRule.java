public class PromotionRule {

    private Double threshold;
    private Double discountValue;
    private int itemsNumber;
    private DiscountType discount;

    private String productCode;

    public PromotionRule(DiscountType discountType, Double discountValue, Double threshold) {
        this.discountValue = discountValue;
        this.threshold = threshold;
        this.discount = discountType;
    }

    public PromotionRule(DiscountType discountType, Double discountValue, int itemsNumber, String productCode) {
        this.discountValue = discountValue;
        this.itemsNumber = itemsNumber;
        this.discount = discountType;
        this.productCode = productCode;
    }

    public DiscountType getDiscount() {
        return discount;
    }

    public Double getDiscountValue() {
        return discountValue;
    }

    public Double getThreshold() {
        return threshold;
    }

    public int getItemsNumber() {
        return itemsNumber;
    }

    public String getProductCode() {
        return productCode;
    }

    enum DiscountType {
        Amount, Item;
    }
}
