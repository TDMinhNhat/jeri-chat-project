package io.github.tdminhnhat.util;

import io.github.tdminhnhat.exception.FileExtensionException;
import io.micronaut.http.MediaType;
import io.micronaut.http.multipart.CompletedFileUpload;
import lombok.AccessLevel;
import lombok.extern.slf4j.Slf4j;

@Slf4j(access = AccessLevel.PRIVATE)
public class ValidateFileUtil {

    public static boolean isIconFile(CompletedFileUpload file) {
        MediaType mediaType = file.getContentType().orElseThrow(() -> new FileExtensionException("File must have a valid content type"));
        log.info("Media Type - Extension - Name: {} - {} - {}", mediaType.getType(), mediaType.getExtension(), mediaType.getName());
        return true;
    }
}
