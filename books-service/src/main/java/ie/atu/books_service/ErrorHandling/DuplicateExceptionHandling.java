package ie.atu.books_service.ErrorHandling;

public class DuplicateExceptionHandling extends RuntimeException {
    public DuplicateExceptionHandling(String message) {
        super(message);
    }
}
