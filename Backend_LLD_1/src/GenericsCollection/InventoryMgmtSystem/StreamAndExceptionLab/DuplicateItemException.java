package GenericsCollection.InventoryMgmtSystem.StreamAndExceptionLab;

public class DuplicateItemException extends RuntimeException {
    public DuplicateItemException(String message) {
        super(message);
    }
}
