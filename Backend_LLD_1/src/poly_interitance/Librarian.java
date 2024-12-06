package poly_interitance;

public class Librarian extends User{
    private String employeeNumber;

    public Librarian(String name, String contactInfo, String employeeNumber){
        super(name,contactInfo);
        this.employeeNumber = employeeNumber;
    }

    @Override
    void displayDashboard() {
        System.out.println("Librarian Dashboard");
        System.out.println("Employee Number :"+employeeNumber);
    }

    @Override
    boolean canBorrowBooks() {
        return true;
    }
}
