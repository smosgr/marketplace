public class Item {

    String productCode;
    String name;
    Double price;

    Item(String productCode, String name, double price) {
        this.productCode = productCode;
        this.name = name;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }
}
