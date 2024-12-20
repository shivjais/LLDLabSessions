package GenericsCollection.InventoryMgmtSystem.M2;

import GenericsCollection.InventoryMgmtSystem.M1.Book;
import GenericsCollection.InventoryMgmtSystem.M1.Clothing;

public class Client {
    public static void main(String[] args) {
        Inventory<Book> bookInventory = new Inventory<>();
        Inventory<Clothing> clothingInventory = new Inventory<>();

        Book book1 = new Book("1", "Book1", 10.0, 10, "Author1");
        Book book2 = new Book("2", "Book2", 20.0, 20, "Author2");
        Clothing clothing1 = new Clothing("3", "Clothing1", 30.0, 30, "M");
        Clothing clothing2 = new Clothing("4", "Clothing2", 40.0, 40, "L");

        bookInventory.addItem(book1);
        bookInventory.addItem(book2);
        clothingInventory.addItem(clothing1);
        clothingInventory.addItem(clothing2);

        System.out.println("All books: "+bookInventory.getAllItems());
        bookInventory.addItem(new Book("5", "Book3", 50.0, 50, "Author3"));
        System.out.println("All books: "+bookInventory.getAllItems());
        bookInventory.addItem(new Book("5", "Book4", 50.0, 50, "Author3"));
        System.out.println("All books: "+bookInventory.getAllItems());
    }
}
