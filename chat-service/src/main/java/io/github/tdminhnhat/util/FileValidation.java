package io.github.tdminhnhat.util;

import io.github.tdminhnhat.exception.FileExtensionException;
import io.micronaut.http.MediaType;
import io.micronaut.http.multipart.CompletedFileUpload;

public final class FileValidation {

    public static boolean validateImageFile(CompletedFileUpload file) {
        MediaType mediaType = file.getContentType().orElseThrow(() -> new FileExtensionException("File must have a valid content type"));
        return MediaType.IMAGE_PNG_TYPE.equals(mediaType) || MediaType.IMAGE_JPEG_TYPE.equals(mediaType);
    }
}
