package com.example.salt.configuration;


import com.toedter.spring.hateoas.jsonapi.JsonApiError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.RequiredArgsConstructor;

@ControllerAdvice
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ResponseEntityExceptionConfig extends ResponseEntityExceptionHandler {

    private static String getStatusString(HttpStatus status) {
        return status.series().name() + ":" + status.value() + ":" + status.name();
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {
        super.handleExceptionInternal(ex, body, headers, status, request);

        if (ex instanceof MethodArgumentNotValidException) {
            StringBuilder errorMessage = new StringBuilder();

            var manve = (MethodArgumentNotValidException) ex;
            manve.getBindingResult().getAllErrors().forEach(oe -> errorMessage.append(oe.getDefaultMessage()).append(";"));

            status = HttpStatus.BAD_REQUEST;
            body = JsonApiError.create()
                    .withStatus(getStatusString(status))
                    .withTitle(status.getReasonPhrase())
                    .withDetail(errorMessage.toString());
        }

        return ResponseEntity
                .status(status)
                .headers(headers)
                .body(body != null ? body
                        : JsonApiError.create()
                        .withStatus(getStatusString(status))
                        .withTitle(status.getReasonPhrase())
                        .withDetail(ex.getLocalizedMessage()));
    }

}

