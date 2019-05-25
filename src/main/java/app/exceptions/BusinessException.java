package app.exceptions;

/**
 * Business Exception class. BusinessException are thrown when a functional
 * error occurs. The principal reasons are: - The given ID wasn't found into the
 * database or it doesn't exist, - Any missing field when requesting the API, -
 * Functional restrictions when creating an object.
 */
public class BusinessException extends ApiException {

    private static final long serialVersionUID = 1L;

    /**
     * Create a new Business Exception.
     *
     * @param message
     *         The message to define the exception.
     * @param msgid
     *         The message identifier
     */
    public BusinessException(String message, String msgid) {
        super(message, msgid);
    }

    public BusinessException(String message, String msgid, Exception e) {
        super(message, msgid, e);
    }
}