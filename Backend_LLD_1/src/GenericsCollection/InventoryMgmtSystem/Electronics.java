package GenericsCollection.InventoryMgmtSystem;

public class Electronics extends Item implements Comparable<Item> {
    private   int warranty;

    public Electronics(String id, String name, double price, int quantity, int warranty) {
        super(id, name, price, quantity);
        this.warranty = warranty;
    }

    @Override
    public String toString() {
        return "Electronics{" +
                "name=" + getName() +
                '}';
    }
}
