package com.mutante.mutante.Exception;

import java.util.List;

public class RequestValidationException extends ApiRequestException {

    public RequestValidationException(String message) {
        super(message);
    }

    public RequestValidationException(String msg, List<String> errors) {
        super(msg, errors);
    }
}
