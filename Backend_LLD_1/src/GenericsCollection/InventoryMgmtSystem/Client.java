package GenericsCollection.InventoryMgmtSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Book book1 = new Book("B001", "Java Programming", 100, 10, "James Gosling");
        Book book2 = new Book("B002", "Python Programming", 200, 20, "Guido van Rossum");
        Clothing clothing1 = new Clothing("C001", "T-Shirt", 50, 5, "M");
        Clothing clothing2 = new Clothing("C002", "Jeans", 150, 15, "32");
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
    }
}
