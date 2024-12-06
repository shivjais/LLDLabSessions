package poly_interitance;

public class Member extends User{
    private int borrowedBooksCount;
    private final int MAX_BORROW_LIMIT = 5;


    @Override
    void displayDashboard() {
        System.out.println(getBorrowedBooksCount());
    }

    @Override
    boolean canBorrowBooks() {
        return borrowedBooksCount < MAX_BORROW_LIMIT;
    }

    public int getBorrowedBooksCount() {
        return borrowedBooksCount;
    }

    public void setBorrowedBooksCount(int borrowedBooksCount) {
        this.borrowedBooksCount = borrowedBooksCount;
    }
}
