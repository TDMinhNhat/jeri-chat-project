package io.github.tdminhnhat.exception.handle;

import io.github.tdminhnhat.exception.QueryNotFoundException;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;

@Produces
@Singleton
public class QueryNotFoundExceptionHandler implements ExceptionHandler<QueryNotFoundException, HttpResponse<String>> {

    @Override
    public HttpResponse<String> handle(HttpRequest request, QueryNotFoundException exception) {
        return HttpResponse.ok(exception.getMessage());
    }
}
