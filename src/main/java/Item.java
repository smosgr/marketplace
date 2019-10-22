public class Item {

    String productCode;
    String name;
    Double price;

    Item(String productCode, String name, Double price) {
        this.productCode = productCode;
        this.name = name;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProductCode() {
        return productCode;
    }
}