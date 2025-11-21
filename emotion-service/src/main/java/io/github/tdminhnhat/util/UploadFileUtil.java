package io.github.tdminhnhat.util;

import io.micronaut.context.annotation.Value;
import io.micronaut.http.multipart.CompletedFileUpload;
import io.minio.GetObjectArgs;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.http.Method;
import jakarta.inject.Singleton;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.concurrent.TimeUnit;

@Singleton
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UploadFileUtil {

    String bucketName;
    MinioClient minioClient;

    public UploadFileUtil(@Value("${minio.bucket-name}") String bucketName, MinioClient minioClient) {
        this.bucketName = bucketName;
        this.minioClient = minioClient;
    }

    public String uploadFile(String objectName, CompletedFileUpload file) throws Exception {
        minioClient.putObject(PutObjectArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .contentType(file.getContentType().get().getType())
                .stream(file.getInputStream(), file.getSize(), -1)
                .build());
        return getUrlFile(objectName);
    }

    public String getUrlFile(String objectName) throws Exception {
        return minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .expiry(24, TimeUnit.HOURS)
                .method(Method.GET)
                .build());
    }
}
