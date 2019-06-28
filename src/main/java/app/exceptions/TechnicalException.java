package app.exceptions;

import java.util.Map;

/**
 * Technical Exception class. TechnicalException are thrown when an API error
 * occurs. The principal reasons are: - All MongoDB errors and MongoExceptions,
 * - All Java errors, - other exception like RestClientException, IOException
 * ... Default http status : 500.
 */
@SuppressWarnings("serial")
public class TechnicalException extends ApiException {

    /**
     * Create a new Technical Exception.
     *
     * @param message
     *         The message to define the exception.
     * @param msgid
     *         The id of the error
     */
    public TechnicalException(String message, String msgid) {
        super(message, msgid);
    }

    /**
     * Create a new Technical Exception.
     *
     * @param message
     *         The message to define the exception.
     * @param msgid
     *         The id of the error
     * @param e
     *         The Exception.
     */
    public TechnicalException(String message, String msgid, Exception e) {
        super(message, msgid, e);
    }

}
