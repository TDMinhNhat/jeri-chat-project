package io.github.tdminhnhat.config;

import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Value;
import io.minio.MinioClient;
import jakarta.inject.Singleton;

@Factory
public class MinIOConfiguration {

    @Value("${minio.url}")
    private String host;

    @Value("${minio.access-key}")
    private String accessKey;

    @Value("${minio.secret-key}")
    private String secretKey;

    @Singleton
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(host)
                .credentials(accessKey, secretKey)
                .build();
    }
}
