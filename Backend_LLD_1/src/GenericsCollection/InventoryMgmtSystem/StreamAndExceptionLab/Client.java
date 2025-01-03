package GenericsCollection.InventoryMgmtSystem.StreamAndExceptionLab;

import GenericsCollection.InventoryMgmtSystem.Inventory;
import GenericsCollection.InventoryMgmtSystem.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Client {
    public static void main(String[] args) {

        Inventory<Item> inventory = new Inventory<>();
        inventory.addItem(new Item("1", "Item1", 100, 10));
        inventory.addItem(new Item("2", "Item2", 200, 20));
        inventory.addItem(new Item("3", "Item3", 300, 30));
        inventory.addItem(new Item("4", "Item4", 400, 40));
        inventory.addItem(new Item("5", "Item5", 500, 50));

        //Print all item IDs in the inventory using map
        ArrayList<Item> allItems = inventory.getAllItems();
        System.out.println("All item IDs:");
        allItems.stream().map(Item::getId).forEach(System.out::println);

        //Create a list of item names in lowercase and print it
        List<String> itemsName = allItems.stream().map(item -> item.getName().toLowerCase()).collect(Collectors.toList());
        System.out.println("Item names in lowercase:"+itemsName);

        //Generate a list of the lengths of item names
        List<Integer> ItemLen = allItems.stream().map(item -> item.getName().length()).collect(Collectors.toList());
        System.out.println("Length of item names: "+ItemLen);

    }
}
