package GenericsCollection.InventoryMgmtSystem.M2;

import GenericsCollection.InventoryMgmtSystem.M1.Item;

import java.util.HashMap;
import java.util.Map;

public class Inventory<T extends Item> {
    private HashMap<String, T> items;

    public Inventory() {
        items = new HashMap<>();
    }

    public void addItem(T item) {
        items.put(item.getId(), item);
    }
    public void removeItem(String id) {
        items.remove(id);
    }

    public T getItems(String id) {
        return items.get(id);
    }
    public Map<String,T> getAllItems() {
        return items;
    }
}
