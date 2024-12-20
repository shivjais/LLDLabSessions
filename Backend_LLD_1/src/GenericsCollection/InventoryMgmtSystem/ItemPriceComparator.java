package GenericsCollection.InventoryMgmtSystem;

import java.util.Comparator;

public class ItemPriceComparator implements Comparator<Item> {
    @Override
    public int compare(Item i1, Item i2) {
        return (int) (i1.getPrice() - i2.getPrice());
    }
}
