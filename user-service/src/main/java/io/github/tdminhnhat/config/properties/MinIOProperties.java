package io.github.tdminhnhat.config.properties;

import io.micronaut.context.annotation.ConfigurationProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@ConfigurationProperties(value = "minio")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MinIOProperties {
    String endpoint;

    String accessKey;

    String secretKey;
}
