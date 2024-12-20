package GenericsCollection.InventoryMgmtSystem;

public class Clothing extends Item {
    private String size;


    public Clothing(String id, String name, double price, int quantity, String size) {
        super(id, name, price, quantity);
        this.size = size;

    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Clothing{" +
                "name='" + getName() + '\'' +
                '}';
    }
}
