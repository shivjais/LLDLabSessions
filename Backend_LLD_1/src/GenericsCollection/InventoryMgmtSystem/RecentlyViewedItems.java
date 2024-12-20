package GenericsCollection.InventoryMgmtSystem;

import java.util.LinkedList;

public class RecentlyViewedItems {
    private final LinkedList<Item> items;
    private final int LAST_RECENTLY_VIEWED_ITEMS = 10;

    public RecentlyViewedItems() {
        items = new LinkedList<>();
    }

    public void addRecentlyViewedItem(Item item) {
        //remove the last item if the item is present in the list
        items.remove(item);
        //add the recently viewed item to the first position
        items.addFirst(item);
        //remove the last item if the list size exceeds the limit
        if(items.size() > LAST_RECENTLY_VIEWED_ITEMS){
            items.removeLast();
        }
    }
    public LinkedList<Item> getRecentlyViewedItems() {
        return items;
    }
}
