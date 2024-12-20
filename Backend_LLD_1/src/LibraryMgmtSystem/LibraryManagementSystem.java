package LibraryMgmtSystem;

import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem {
    private static List<Book> bookInventory;
    private List<User> registeredUsers;

    public void addBook(Book book){
        bookInventory.add(book);
    }

    public void registeredUsers(User user){
        registeredUsers.add(user);
    }

    public static List<Book> searchBooks(String criteria){
        List<Book> result = new ArrayList<>();
        return result;
    }
}
