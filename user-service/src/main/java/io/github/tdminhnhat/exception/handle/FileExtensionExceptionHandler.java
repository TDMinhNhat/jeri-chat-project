package io.github.tdminhnhat.exception.handle;

import io.github.tdminhnhat.exception.FileExtensionException;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;

@Produces
@Singleton
public class FileExtensionExceptionHandler implements ExceptionHandler<FileExtensionException, HttpResponse<String>> {

    @Override
    public HttpResponse<String> handle(HttpRequest request, FileExtensionException exception) {
        return HttpResponse.badRequest(exception.getMessage());
    }
}
