package io.github.tdminhnhat.config;

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Value;
import io.minio.MinioClient;
import jakarta.inject.Singleton;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Factory
@Data
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MinIOConfiguration {

    String endpoint;

    String accessKey;

    String secretKey;

    public MinIOConfiguration(@Value("${minio.endpoint}") String endpoint,
                              @Value("${minio.accessKey}") String accessKey,
                              @Value("${minio.secretKey}") String secretKey) {
        this.endpoint = endpoint;
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    @Singleton
    public MinioClient minioClient() {
        return MinioClient.builder().endpoint(endpoint)
                .credentials(accessKey, secretKey).build();
    }
}
