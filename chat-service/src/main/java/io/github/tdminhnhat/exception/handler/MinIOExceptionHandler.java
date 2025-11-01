package io.github.tdminhnhat.exception.handler;

import io.github.tdminhnhat.exception.MinIOException;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;

@Produces
@Singleton
public class MinIOExceptionHandler implements ExceptionHandler<MinIOException, HttpResponse<String>> {

    @Override
    public HttpResponse<String> handle(HttpRequest request, MinIOException exception) {
        return HttpResponse.serverError(exception.getMessage());
    }
}
