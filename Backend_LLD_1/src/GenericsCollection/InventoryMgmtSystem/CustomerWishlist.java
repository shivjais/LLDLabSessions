package GenericsCollection.InventoryMgmtSystem;

import java.util.HashSet;
import java.util.Set;

public class CustomerWishlist<T extends Item>{
    private Set<T> wishlist;

    public CustomerWishlist() {
        this.wishlist = new HashSet<>();
    }

    public void addToWishlist(T item){
        wishlist.add(item);
    }
    public void removeFromWishlist(T item){
        wishlist.remove(item);
    }
    public void displayWishlistItems(){
        for (T item : wishlist) {
            System.out.println(item.getName());
        }
    }
}
