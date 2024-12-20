package GenericsCollection.InventoryMgmtSystem;

public class Order implements Comparable<Order> {
    private String orderId;
    //true - express Order, false - regular order
    private boolean isExpress;

    public Order(String orderId, boolean isExpress) {
        this.orderId = orderId;
        this.isExpress = isExpress;
    }

    public String getOrderId() {
        return orderId;
    }

    //sort express orders first & if both are express or both are regular, process based on orderId
    @Override
    public int compareTo(Order o) {
        if(this.isExpress && !o.isExpress){
            return -1;
        }else if(!this.isExpress && o.isExpress){
            return 1;
        }
        return this.orderId.compareTo(o.orderId);
    }
}
