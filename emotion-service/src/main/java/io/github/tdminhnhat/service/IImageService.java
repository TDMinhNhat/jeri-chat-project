package io.github.tdminhnhat.service;

import io.micronaut.http.multipart.CompletedFileUpload;
import reactor.core.publisher.Mono;

public interface IImageService<P extends Number> {
    
    Mono<?> addImage(P id, CompletedFileUpload file) throws Exception;
    
    Mono<?> updateImage(P id, CompletedFileUpload file) throws Exception;
    
    Mono<?> deleteImage(P id) throws Exception;
}
