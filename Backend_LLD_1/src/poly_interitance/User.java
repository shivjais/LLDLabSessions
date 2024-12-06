package poly_interitance;

public abstract class User {
    private String userId;
    private String name;
    private String contactInfo;

    abstract void displayDashboard();
    abstract boolean canBorrowBooks();
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
    public User(){
        userId = generateUniqueId();
    }
    public User(String name, String contactInfo){
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public User(User user){
        this.userId = user.userId;
        this.name = user.name;
        this.contactInfo = user.contactInfo;
    }

    private String generateUniqueId() {
        return "0";
    }
}
