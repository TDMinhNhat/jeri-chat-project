package io.github.tdminhnhat.exception.handler;

import io.github.tdminhnhat.exception.BadRequestException;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;

@Produces
@Singleton
public class BadRequestExceptionHandler implements ExceptionHandler<BadRequestException, HttpResponse<String>> {

    @Override
    public HttpResponse<String> handle(HttpRequest request, BadRequestException exception) {
        return HttpResponse.badRequest(exception.getMessage());
    }
}
