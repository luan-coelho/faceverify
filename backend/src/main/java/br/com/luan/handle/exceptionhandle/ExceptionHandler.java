package br.com.luan.handle.exceptionhandle;

import br.com.luan.exception.ErrorResponse;

public interface ExceptionHandler {

    void handleException(Exception exception, ErrorResponse errorResponse);

    Class<? extends Exception> getExceptionType();

    String getTitle();

    int getStatus();
}
