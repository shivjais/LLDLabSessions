package GenericsCollection.InventoryMgmtSystem.StreamAndExceptionLab;

import GenericsCollection.InventoryMgmtSystem.Inventory;
import GenericsCollection.InventoryMgmtSystem.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Client {
    public static void main(String[] args) throws InvalidQuantityException {

        Inventory<Item> inventory = new Inventory<>();
        inventory.addItem(new Item("1", "Item1", 100, 10));
        inventory.addItem(new Item("2", "Item2", 2000, 20));
        inventory.addItem(new Item("3", "Item3", 1500, 30));
        inventory.addItem(new Item("4", "Item4", 500, 40));
        inventory.addItem(new Item("5", "Item5", 1100, 0));

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

        //Find all items priced above 1000 and print their details
        System.out.println("Items priced above 1000: ");
        allItems.stream().filter(item -> item.getPrice() > 1000).forEach(item -> System.out.println(item.getName()));

        //Check if any item in the inventory has a quantity of 0 using anyMatch
        boolean isAnyItemZero = allItems.stream().anyMatch(item -> item.getQuantity() == 0);
        System.out.println("Is any item quantity zero: "+isAnyItemZero);

        //Verify that all items have a price greater than 0 using allMatch
        boolean isAllItemsPricePositive = allItems.stream().allMatch(item -> item.getPrice() > 0);
        System.out.println("Are all items price positive: "+isAllItemsPricePositive);

        //Confirm that no item has a negative quantity using noneMatch
        boolean isNoItemNegative = allItems.stream().noneMatch(item -> item.getQuantity() < 0);
        System.out.println("Are no items negative: "+isNoItemNegative);

        //Filter items with a price greater than 1000 and a quantity greater than 0 (available stock).
        //Extract only the names of these items.
        //Remove duplicate names (if any).
        //Sort the names in alphabetical order.
        //Limit the result to the top 5 names.
        //Collect the final list into a List<String> and print it.
        List<String> list = allItems.stream()
                .filter(item -> item.getPrice() > 1000 && item.getQuantity() > 0)
                .map(Item::getName)
                .distinct()
                .sorted(String::compareTo)
                .limit(5)
                .collect(Collectors.toList());
        System.out.println("Filtered, sorted, distinct, limited to 5 items: "+list);

        //Calculate the total quantity of all items in the inventory
        Integer totalQuantity = allItems.stream()
                .map(Item::getQuantity)
                //.reduce(0, (totalSum, qty) -> totalSum + qty)
                .reduce(0, Integer::sum);
        System.out.println("Total quantity of all items: "+totalQuantity);


        //Find the most expensive item using reduce
        allItems.stream()
                .reduce((item1, item2) -> item1.getPrice() > item2.getPrice() ? item1 : item2)
                .ifPresent(item -> System.out.println("Most expensive item: "+item.getName()));

        //Concatenate all item names into a single comma-separated string
        //using Collectors.joining
        String names = allItems.stream()
                .map(Item::getName)
                .collect(Collectors.joining(", "));
        System.out.println("All item names: "+names);

        //Concatenate using reduce
        String names2 = allItems.stream()
                .map(Item::getName)
                .reduce((name1, name2) -> name1 + ", " + name2)
                .get();
        System.out.println("All item names using reduce: "+names2);

    }
}
