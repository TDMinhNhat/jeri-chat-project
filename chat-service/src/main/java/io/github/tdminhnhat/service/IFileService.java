package io.github.tdminhnhat.service;

import io.micronaut.http.multipart.CompletedFileUpload;

import java.util.List;

public interface IFileService<P extends Number> {
    Object uploadImage(P id, CompletedFileUpload file);

    Object uploadImages(P id, List<CompletedFileUpload> files);

    Object deleteImage(P id, String imageId);

    Object deleteImages(P id, List<String> imageIds);
}
