package io.github.tdminhnhat.test;

import io.minio.BucketExistsArgs;
import io.minio.MinioClient;

public class MinioTest {

    public static void main(String[] args) {
        try {
            MinioClient minioClient = MinioClient.builder()
                    .endpoint("http://localhost:9000")
                    .credentials("minioadmin", "minioadmin")
                    .build();

            boolean result = minioClient.bucketExists(BucketExistsArgs.builder()
                    .bucket("jeri-user-service").build());

            System.out.println("Bucket exists: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
