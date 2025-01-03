package GenericsCollection.InventoryMgmtSystem;

import GenericsCollection.InventoryMgmtSystem.StreamAndExceptionLab.DuplicateItemException;
import GenericsCollection.InventoryMgmtSystem.StreamAndExceptionLab.InvalidQuantityException;
import GenericsCollection.InventoryMgmtSystem.StreamAndExceptionLab.ItemNotFoundException;

import java.util.*;

public class Inventory<T extends Item> {
    private HashMap<String, T> items;

    public Inventory() {
        items = new HashMap<>();
    }

    public void addItem(T item) throws InvalidQuantityException {
        if(items.containsKey(item.getId())){
            throw new DuplicateItemException("Item already exists: "+item.getId());
        }
        if(item.getQuantity() < 0){
            throw new InvalidQuantityException("Invalid quantity: "+item.getQuantity());
        }
        items.put(item.getId(), item);
    }
    public void removeItem(String id) {
        if(!items.containsKey(id)){
            throw new ItemNotFoundException("Item not found: "+id);
        }
        items.remove(id);
    }

    public T getItem(String id) {
        if(!items.containsKey(id)){
            throw new ItemNotFoundException("Item not found: "+id);
        }
        return items.get(id);
    }
    public ArrayList<T> getAllItems() {
        return new ArrayList<>(items.values());
    }

    public List<Item> filterByPriceRange(int min,int max){
        List<Item> filteredItems = new ArrayList<>();
        for (Item item : items.values()) {
            if(item.getPrice() >= min && item.getPrice() <= max){
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }
    public List<Item> filterByAvailability(){
        List<Item> filteredItems = new ArrayList<>();
        for (Item item : items.values()) {
            if(item.getQuantity() > 0){
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }
    public List<T> sortInventory(Comparator<T> comparator){
        List<T> sortedItems = new ArrayList<>(items.values());
        Collections.sort(sortedItems,comparator);
        return sortedItems;
    }
}
