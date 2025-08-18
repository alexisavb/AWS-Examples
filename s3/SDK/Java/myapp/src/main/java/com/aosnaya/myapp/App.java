package com.aosnaya.myapp;

import java.util.concurrent.CompletableFuture;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import software.amazon.awssdk.services.s3.model.CreateBucketRequest;
import software.amazon.awssdk.services.s3.model.CreateBucketResponse;
import software.amazon.awssdk.services.s3.model.DeleteBucketRequest;
import software.amazon.awssdk.services.s3.model.DeleteBucketResponse;
import software.amazon.awssdk.services.s3.model.ListBucketsResponse;
import software.amazon.awssdk.services.s3.model.S3Exception;
import software.amazon.awssdk.services.s3.S3AsyncClient;

/**
 * Lambda function entry point. You can change to use other pojo type or implement
 * a different RequestHandler.
 *
 * @see <a href=https://docs.aws.amazon.com/lambda/latest/dg/java-handler.html>Lambda Java Handler</a> for more information
 */
public class App implements RequestHandler<S3Request, String> {
    private final S3AsyncClient s3Client;

    public App() {
        // Initialize the SDK client outside of the handler method so that it can be reused for subsequent invocations.
        // It is initialized when the class is loaded.
        s3Client = DependencyFactory.s3Client();
        // Consider invoking a simple api here to pre-warm up the application, eg: dynamodb#listTables
    }

    @Override
    public String handleRequest(final S3Request  input, final Context context) {
        switch (input.getAction().toLowerCase()) {
            case "create":
                return createBucket(input.getBucketName());
          /*case "delete":
                return deleteBucket(input.getBucketName());
            case "list":
                return listBuckets();*/
            default:
                return "❌ Unknown action: " + input.getAction();
        }
    }

    private String createBucket(String bucketName) {
        try {
            CompletableFuture<CreateBucketResponse> future = s3Client.createBucket(
                    CreateBucketRequest.builder().bucket(bucketName).build()
            );
            future.join();
            return "✅ Bucket created: " + bucketName;
        } catch (S3Exception e) {
            return "❌ Create failed: " + e.awsErrorDetails().errorMessage();
        }
    }
}
