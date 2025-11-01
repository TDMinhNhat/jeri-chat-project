package io.github.tdminhnhat.config;

import io.github.tdminhnhat.config.properties.MinIOProperties;
import io.micronaut.context.annotation.Factory;
import io.minio.MinioClient;
import jakarta.inject.Singleton;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Factory
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MinIOConfiguration {

    MinIOProperties minIOProperties;

    @Singleton
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(minIOProperties.getUrl())
                .credentials(minIOProperties.getAccessKey(), minIOProperties.getSecretKey())
                .build();
    }
}
