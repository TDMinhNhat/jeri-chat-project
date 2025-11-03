package io.github.tdminhnhat.util;

import io.github.tdminhnhat.exception.FileExtensionException;
import io.micronaut.http.MediaType;
import io.micronaut.http.multipart.CompletedFileUpload;

import java.io.FileInputStream;
import java.io.InputStream;

public class Validate {
    public static boolean validateImage(CompletedFileUpload fileUpload) {
        if(fileUpload.getContentType().isPresent()) {
            MediaType contentType = fileUpload.getContentType().get();
            return contentType.equals(MediaType.IMAGE_JPEG_TYPE) ||
                    contentType.equals(MediaType.IMAGE_PNG_TYPE);
        } else {
            throw new FileExtensionException("File must be an image (JPEG or PNG)");
        }
    }
}
