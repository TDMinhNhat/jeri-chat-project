package io.github.tdminhnhat.config;

import io.github.tdminhnhat.config.properties.MinIOProperties;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.minio.MinioClient;
import jakarta.inject.Inject;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Factory
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MinIOConfiguration {

    MinIOProperties minIOProperties;

    @Inject
    public MinIOConfiguration(MinIOProperties minIOProperties) {
        this.minIOProperties = minIOProperties;
    }

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(minIOProperties.getEndpoint())
                .credentials(minIOProperties.getAccessKey(), minIOProperties.getSecretKey())
                .build();
    }
}
