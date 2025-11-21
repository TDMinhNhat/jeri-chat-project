package io.github.tdminhnhat.config;

import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Value;
import io.minio.MinioClient;
import jakarta.inject.Singleton;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Factory
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MinIOConfig {

    @Value("${minio.endpoint}")
    String endpoint;

    @Value("${minio.access-key}")
    String accessKey;

    @Value("${minio.secret-key}")
    String secretKey;

    @Value("${minio.bucket-name}")
    String bucketName;

    @Singleton
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, secretKey)
                .build();
    }
}
