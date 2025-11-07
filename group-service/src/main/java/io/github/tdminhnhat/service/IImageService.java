package io.github.tdminhnhat.service;

import io.github.tdminhnhat.model.vo.BaseVO;
import io.micronaut.http.multipart.CompletedFileUpload;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IImageService<P extends Number, R extends BaseVO> {

    Mono<R> uploadImage(P id, CompletedFileUpload file) throws Exception;

    Flux<R> uploadImages(P id, List<CompletedFileUpload> files) throws Exception;

    Mono<R> deleteImage(P id, String imageId) throws Exception;

    Flux<R> deleteImages(P id, List<String> imageIds) throws Exception;
}
