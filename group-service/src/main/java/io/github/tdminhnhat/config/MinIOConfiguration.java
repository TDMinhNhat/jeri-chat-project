package io.github.tdminhnhat.config;

import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Value;
import io.minio.MinioClient;
import jakarta.inject.Singleton;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Factory
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MinIOConfiguration {

    @Value("${minio.endpoint}")
    String endpoint;

    @Value("${minio.access-key}")
    String accessKey;

    @Value("${minio.secret-key}")
    String secretKey;

    public MinIOConfiguration(String endpoint, String accessKey, String secretKey) {
        this.endpoint = endpoint;
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    @Singleton
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(this.endpoint)
                .credentials(this.accessKey, this.secretKey)
                .build();
    }
}
