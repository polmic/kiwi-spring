package app.exceptions;

/**
 * Super class for all API exception. This class avoid to throw too many
 * exception types for a method
 */
public abstract class ApiException extends Exception {

    private static final long serialVersionUID = 1L;
    private final String msgid;

    public ApiException(String message, String msgid) {
        super(message);
        this.msgid = msgid;
    }

    public ApiException(String message, String msgid, Exception e) {
        super(message, e);
        this.msgid = msgid;
    }

    public String getMsgid() {
        return msgid;
    }
}
