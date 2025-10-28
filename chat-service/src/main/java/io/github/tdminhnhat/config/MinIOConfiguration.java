package io.github.tdminhnhat.config;

import io.github.tdminhnhat.config.properties.MinIOProperties;
import io.micronaut.context.annotation.Factory;
import io.minio.MinioClient;
import jakarta.inject.Singleton;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Factory
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MinIOConfiguration {

    MinIOProperties minIOProperties;

    @Singleton
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(minIOProperties.getEndpoint())
                .credentials(minIOProperties.getAccessKey(), minIOProperties.getSecretKey())
                .build();
    }
}
