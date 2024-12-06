package LibraryMgmtSystem;

public class Member extends User{
    private int borrowedBooksCount;
    private final static int MAX_BORROW_LIMIT = 5;

    public Member(){
        super();
        this.borrowedBooksCount=0;
    }
    public Member(String name, String contactInfo){
        super(name,contactInfo);
        this.borrowedBooksCount = 0;
    }

    @Override
    void displayDashboard() {
        System.out.println("Member Dashboard");
        System.out.println("Member Name: "+getName());
        System.out.println(borrowedBooksCount);
    }

    @Override
    boolean canBorrowBooks() {
        return borrowedBooksCount < MAX_BORROW_LIMIT;
    }
    void addNewBook(Book book){
        System.out.println("added book");
    }
    void removeBook(Book book){
        System.out.println("removed book");
    }
}
