package io.github.tdminhnhat.controller;

import io.github.tdminhnhat.model.vo.BaseVO;
import io.micronaut.http.multipart.CompletedFileUpload;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IImageController<P extends Number, R extends BaseVO> {

    Mono<R> uploadImage(Long id, CompletedFileUpload file);


    Flux<R> uploadImages(Long id, List<CompletedFileUpload> files);


    Mono<R> deleteImage(Long id, String imageId);


    Flux<R> deleteImages(Long id, List<String> imageIds);
}
