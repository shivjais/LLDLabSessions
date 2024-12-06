package poly_interitance;

public abstract class User {
    private String userId;
    private String name;
    private String contactInfo;
    private static int totalUser = 0;

    abstract void displayDashboard();
    abstract boolean canBorrowBooks();


    public User(){

        userId = generateUniqueId();
    }
    public User(String name, String contactInfo){

        this.userId = generateUniqueId();
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public User(User user){

        this.userId = generateUniqueId();
        this.name = user.name;
        this.contactInfo = user.contactInfo;
    }

    private static int getTotalUsers(){
        return totalUser;
    }
    private final String generateUniqueId() {
        totalUser++;
        return "User-" + totalUser;
    }
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
}
