package io.github.tdminhnhat.config.properties;

import io.micronaut.context.annotation.ConfigurationProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@ConfigurationProperties(value = "${minio}")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data @AllArgsConstructor
public class MinIOProperties {
    String url;

    String accessKey;

    String secretKey;

    String bucketName;
}
