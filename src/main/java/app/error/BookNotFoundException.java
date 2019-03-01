package app.error;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(Long id) {
        super("app.models.Book id not found : " + id);
    }

}
