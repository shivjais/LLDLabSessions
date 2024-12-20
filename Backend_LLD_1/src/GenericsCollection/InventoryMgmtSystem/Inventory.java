package GenericsCollection.InventoryMgmtSystem;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory<T extends Item> {
    private HashMap<String, T> items;

    public Inventory() {
        items = new HashMap<>();
    }

    public void addItem(T item) {
        if(items.containsKey(item.getId())){
            System.out.println("Item already exists: "+item.getId());
            return;
        }
        items.put(item.getId(), item);
    }
    public void removeItem(String id) {
        if(!items.containsKey(id)){
            System.out.println("Item not found: "+id);
            return;
        }
        items.remove(id);
    }

    public T getItem(String id) {
        if(!items.containsKey(id)){
            System.out.println("Item not found: "+id);
            return null;
        }
        return items.get(id);
    }
    public ArrayList<T> getAllItems() {
        return new ArrayList<>(items.values());
    }
}
