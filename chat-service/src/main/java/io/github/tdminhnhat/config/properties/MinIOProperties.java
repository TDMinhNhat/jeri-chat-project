package io.github.tdminhnhat.config.properties;

import io.micronaut.context.annotation.ConfigurationProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@ConfigurationProperties(value = "minio")
@Data @NoArgsConstructor
@AllArgsConstructor @FieldDefaults(level = AccessLevel.PRIVATE)
public class MinIOProperties {

    String endpoint;

    String accessKey;

    String secretKey;

    String bucketName;
}
