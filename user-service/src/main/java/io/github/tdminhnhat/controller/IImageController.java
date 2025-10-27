package io.github.tdminhnhat.controller;

import io.github.tdminhnhat.model.vo.BaseVO;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.multipart.CompletedFileUpload;

import java.util.List;

public interface IImageController<P extends Number, R extends BaseVO> {

    HttpResponse<R> addImage(P id, CompletedFileUpload upload);

    HttpResponse<List<R>> addListImages(P id, List<CompletedFileUpload> images);
}
