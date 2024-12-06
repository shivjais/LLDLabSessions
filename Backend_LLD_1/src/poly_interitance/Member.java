package poly_interitance;

public class Member extends User{
    private int borrowedBooksCount;
    private final int MAX_BORROW_LIMIT = 5;

    public Member(String name, String contactInfo, int borrowedBooksCount){
        super(name,contactInfo);
        this.borrowedBooksCount = borrowedBooksCount;
    }

    @Override
    void displayDashboard() {
        System.out.println(borrowedBooksCount);
    }

    @Override
    boolean canBorrowBooks() {
        return borrowedBooksCount < MAX_BORROW_LIMIT;
    }
}
