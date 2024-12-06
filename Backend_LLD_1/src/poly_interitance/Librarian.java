package poly_interitance;

public class Librarian extends User{
    private String employeeNumber;

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    @Override
    void displayDashboard() {
        System.out.println(getEmployeeNumber());
    }

    @Override
    boolean canBorrowBooks() {
        return true;
    }
}
