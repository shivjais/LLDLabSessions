package GenericsCollection.InventoryMgmtSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Book book1 = new Book("B001", "Java Programming", 100, 10, "James Gosling");
        Book book2 = new Book("B002", "Python Programming", 200, 20, "Guido van Rossum");
        Clothing clothing1 = new Clothing("C001", "T-Shirt", 50, 5, "M");
        Clothing clothing2 = new Clothing("C002", "Jeans", 150, 0, "32");
        Electronics electronics1 = new Electronics("E001", "Laptop", 500, 2, 1);
        Electronics electronics2 = new Electronics("E002", "Mobile", 300, 3, 2);
        List<Item> items = new ArrayList<>(List.of(book1, book2, clothing1, clothing2, electronics1, electronics2));
        Collections.sort(items);
        System.out.println(items);


        Inventory<Book> bookInventory = new Inventory<>();
        Inventory<Clothing> clothingInventory = new Inventory<>();
        bookInventory.addItem(book1);
        bookInventory.addItem(book2);
        clothingInventory.addItem(clothing1);
        clothingInventory.addItem(clothing2);

        System.out.println("All books: "+bookInventory.getAllItems());
        bookInventory.addItem(new Book("B003", "Book3", 50.0, 50, "Author3"));
        System.out.println("All books: "+bookInventory.getAllItems());
        bookInventory.addItem(new Book("B003", "Book4", 50.0, 50, "Author3"));
        System.out.println("Books: "+bookInventory.getItem("B003"));
        clothingInventory.removeItem("C001");
        System.out.println("All clothing: "+clothingInventory.getAllItems());

        RecentlyViewedItems recentlyViewedItems = new RecentlyViewedItems();


        OrderProcessor orderProcessor = new OrderProcessor();
        orderProcessor.addOrder(new Order("O001", false));
        orderProcessor.addOrder(new Order("O002", true));
        orderProcessor.addOrder(new Order("O003", false));
        orderProcessor.addOrder(new Order("O004", true));
        orderProcessor.processOrders();

        //Sorting & filtering
        Inventory<Item> inventory = new Inventory<>();
        inventory.addItem(book1);
        inventory.addItem(book2);
        inventory.addItem(clothing1);
        inventory.addItem(clothing2);
        inventory.addItem(electronics1);

        List<Item> sortByPrice = inventory.sortInventory(new ItemPriceComparator());
        System.out.println("Sorted by price:");
        for(Item item: sortByPrice){
            System.out.println("Item: "+item.getName()+" Price: "+item.getPrice());
        }
        List<Item> sortByQuantity =inventory.sortInventory(new ItemQuantityComparator());
        System.out.println("Sorted by quantity:");
        for(Item item: sortByQuantity){
            System.out.println(item);
            System.out.println("Item: "+item.getName()+" Quantity: "+item.getQuantity());
        }

        //Filtering
        List<Item> affordableItems = inventory.filterByPriceRange(50, 100);
        System.out.println("affordableItems:");
        for(Item item: affordableItems){
            System.out.println("Item: "+item.getName()+" Price: "+item.getPrice());
        }

        List<Item> availableItems = inventory.filterByAvailability();
        System.out.println("availableItems:");
        for(Item item: availableItems){
            System.out.println("Item: "+item.getName()+" Quantity: "+item.getQuantity());
        }

        //Adding unique item to wishlist
        CustomerWishlist<Item> wishlist = new CustomerWishlist<>();
        Book book3 = new Book("B003", "Book3", 50.0, 50, "Author3");
        Electronics electronics3 = new Electronics("E003", "Tablet", 200, 5, 3);
        Clothing clothing3 = new Clothing("C003", "Shirt", 30, 10, "M");
        Book book4 = new Book("B003", "Book4", 40.0, 20, "Author4");

        wishlist.addToWishlist(book3);
        wishlist.addToWishlist(book1);
        wishlist.addToWishlist(electronics3);
        wishlist.addToWishlist(clothing3);
        //adding duplicate item
        wishlist.addToWishlist(book4);
        System.out.println("Wishlist items:");
        wishlist.displayWishlistItems();
        wishlist.removeFromWishlist(book4);
        System.out.println("Wishlist items after removing book4:");
        wishlist.displayWishlistItems();

    }


}
