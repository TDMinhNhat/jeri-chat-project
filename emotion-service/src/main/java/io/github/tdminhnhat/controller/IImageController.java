package io.github.tdminhnhat.controller;

import io.github.tdminhnhat.model.vo.BaseVO;
import io.micronaut.http.multipart.CompletedFileUpload;
import reactor.core.publisher.Mono;

public interface IImageController<P extends Number, R extends BaseVO> {

    Mono<R> addImage(P id, CompletedFileUpload upload) throws Exception;

    Mono<R> updateImage(P id, CompletedFileUpload upload) throws Exception;

    Mono<R> deleteImage(P id) throws Exception;
}
