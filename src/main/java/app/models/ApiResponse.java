package app.models;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Map;

@Data
@ApiModel(value = "Simple APIResponse Model")
public class ApiResponse<T> {

    private String message;
    private int total;

    /**
     * Constant Response element.
     */
    private T response;

    /**
     * The error identifier
     */
    private String msgid;

    /**
     * A map with parameters for msgid
     */
    private Map<String, String> msgparam;
}
