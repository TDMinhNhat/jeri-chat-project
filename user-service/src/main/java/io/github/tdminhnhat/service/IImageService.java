package io.github.tdminhnhat.service;

import io.github.tdminhnhat.model.vo.BaseVO;
import io.micronaut.http.multipart.CompletedFileUpload;

import java.util.List;

public interface IImageService<P extends Number> {

    Object addImage(P id, CompletedFileUpload upload);

    List<? extends BaseVO> addListImages(P id, List<CompletedFileUpload> uploads);
}
