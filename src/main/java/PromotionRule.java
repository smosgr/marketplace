public class PromotionRule {

    private String offerType;
    private double percentage;

    public PromotionRule(String offerType, double percentage) {
        this.offerType = offerType;
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }

    public String getOfferType() {
        return offerType;
    }
}
