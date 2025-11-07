package io.github.tdminhnhat.exception.handle;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;

@Produces
@Singleton
public class RuntimeExceptionHandler implements ExceptionHandler<RuntimeException, HttpResponse<String>> {

    @Override
    public HttpResponse<String> handle(HttpRequest request, RuntimeException exception) {
        return HttpResponse.serverError(exception.getMessage());
    }
}
