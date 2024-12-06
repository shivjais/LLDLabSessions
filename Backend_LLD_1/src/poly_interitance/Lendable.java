package poly_interitance;

public interface Lendable {
    boolean lend(User user);
    void returnBook(User user);
    boolean isAvailable();

}
