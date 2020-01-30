package app.exceptions;

import app.models.ApiResponse;
import app.toolkit.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * Exceptions Handler.
 */
public class ExceptionsController {

    /**
     * Constant for Log4j.
     */
    private static final Logger LOG = LoggerFactory.getLogger(ExceptionsController.class.getName());


    /**
     * Exceptions are thrown when a java error occurs, it's a global
     * exception.
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse<Object> handleException(Exception ex) {
        LOG.error("handler of Exceptions :", ex);
        return createErrorResponse(ex.getMessage(), Constants.MessageIds.UNKNOWN_ERROR);
    }


    /**
     * BusinessException are thrown when a functional error occurs.
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Object> handleException(BusinessException ex) {
        LOG.warn("handler of BusinessException :", ex);
        return createErrorResponse(ex.getMessage(), ex.getMsgid());
    }


    /**
     * TechnicalException which is thrown when an API error occurs.
     */
    @ExceptionHandler(TechnicalException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse<Object> handleException(TechnicalException ex) {
        LOG.error("handler of TechnicalException :", ex);
        return createErrorResponse(ex.getMessage(), ex.getMsgid());
    }

    /**
     * Utility method to create an ApiResponse in case of error
     */
    private ApiResponse<Object> createErrorResponse(String message, String msgid) {
        ApiResponse<Object> resp = new ApiResponse<>();
        resp.setMessage(message);
        resp.setTotal(-1);
        resp.setMsgid(msgid);
        return resp;
    }

}
