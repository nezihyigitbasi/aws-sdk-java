/*
 * Copyright 2010-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.kinesis;

import java.net.*;
import java.util.*;

import org.apache.commons.logging.*;

import com.amazonaws.*;
import com.amazonaws.regions.*;
import com.amazonaws.auth.*;
import com.amazonaws.handlers.*;
import com.amazonaws.http.*;
import com.amazonaws.regions.*;
import com.amazonaws.internal.*;
import com.amazonaws.metrics.*;
import com.amazonaws.transform.*;
import com.amazonaws.util.*;
import com.amazonaws.util.AWSRequestMetrics.Field;
import com.amazonaws.util.json.*;

import com.amazonaws.services.kinesis.model.*;
import com.amazonaws.services.kinesis.model.transform.*;

/**
 * Client for accessing AmazonKinesis.  All service calls made
 * using this client are blocking, and will not return until the service call
 * completes.
 * <p>
 * Amazon Kinesis Service API Reference <p>
 * Amazon Kinesis is a managed service that scales elastically for real
 * time processing of streaming big data.
 * </p>
 */
public class AmazonKinesisClient extends AmazonWebServiceClient implements AmazonKinesis {

    /** Provider for AWS credentials. */
    private AWSCredentialsProvider awsCredentialsProvider;

    private static final Log log = LogFactory.getLog(AmazonKinesis.class);

    /**
     * List of exception unmarshallers for all AmazonKinesis exceptions.
     */
    protected List<JsonErrorUnmarshaller> jsonErrorUnmarshallers;

    /**
     * Constructs a new client to invoke service methods on
     * AmazonKinesis.  A credentials provider chain will be used
     * that searches for credentials in this order:
     * <ul>
     *  <li> Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY </li>
     *  <li> Java System Properties - aws.accessKeyId and aws.secretKey </li>
     *  <li> Instance profile credentials delivered through the Amazon EC2 metadata service </li>
     * </ul>
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @see DefaultAWSCredentialsProviderChain
     */
    public AmazonKinesisClient() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonKinesis.  A credentials provider chain will be used
     * that searches for credentials in this order:
     * <ul>
     *  <li> Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY </li>
     *  <li> Java System Properties - aws.accessKeyId and aws.secretKey </li>
     *  <li> Instance profile credentials delivered through the Amazon EC2 metadata service </li>
     * </ul>
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonKinesis
     *                       (ex: proxy settings, retry counts, etc.).
     *
     * @see DefaultAWSCredentialsProviderChain
     */
    public AmazonKinesisClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonKinesis using the specified AWS account credentials.
     * 
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentials The AWS credentials (access key ID and secret key) to use
     *                       when authenticating with AWS services.
     */
    public AmazonKinesisClient(AWSCredentials awsCredentials) {
        this(awsCredentials, new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonKinesis using the specified AWS account credentials
     * and client configuration options.
     * 
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentials The AWS credentials (access key ID and secret key) to use
     *                       when authenticating with AWS services.
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonKinesis
     *                       (ex: proxy settings, retry counts, etc.).
     */
    public AmazonKinesisClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration) {
        super(adjustClientConfiguration(clientConfiguration));
        
        this.awsCredentialsProvider = new StaticCredentialsProvider(awsCredentials);
        
        init();
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonKinesis using the specified AWS account credentials provider.
     * 
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     */
    public AmazonKinesisClient(AWSCredentialsProvider awsCredentialsProvider) {
        this(awsCredentialsProvider, new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonKinesis using the specified AWS account credentials
     * provider and client configuration options.
     * 
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonKinesis
     *                       (ex: proxy settings, retry counts, etc.).
     */
    public AmazonKinesisClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(awsCredentialsProvider, clientConfiguration, null);
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonKinesis using the specified AWS account credentials
     * provider, client configuration options and request metric collector.
     * 
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonKinesis
     *                       (ex: proxy settings, retry counts, etc.).
     * @param requestMetricCollector optional request metric collector
     */
    public AmazonKinesisClient(AWSCredentialsProvider awsCredentialsProvider,
            ClientConfiguration clientConfiguration,
            RequestMetricCollector requestMetricCollector) {
        super(adjustClientConfiguration(clientConfiguration), requestMetricCollector);
        
        this.awsCredentialsProvider = awsCredentialsProvider;
        
        init();
    }

    private void init() {
        jsonErrorUnmarshallers = new ArrayList<JsonErrorUnmarshaller>();
        jsonErrorUnmarshallers.add(new ResourceInUseExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new LimitExceededExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new InvalidArgumentExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new ExpiredIteratorExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new ProvisionedThroughputExceededExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new ResourceNotFoundExceptionUnmarshaller());
        
        jsonErrorUnmarshallers.add(new JsonErrorUnmarshaller());
        
        // calling this.setEndPoint(...) will also modify the signer accordingly
        this.setEndpoint("kinesis.us-east-1.amazonaws.com");
        
        HandlerChainFactory chainFactory = new HandlerChainFactory();
        requestHandler2s.addAll(chainFactory.newRequestHandlerChain(
                "/com/amazonaws/services/kinesis/request.handlers"));
        requestHandler2s.addAll(chainFactory.newRequestHandler2Chain(
                "/com/amazonaws/services/kinesis/request.handler2s"));
    }

    private static ClientConfiguration adjustClientConfiguration(ClientConfiguration orig) {
        ClientConfiguration config = orig;
        
        return config;
    }

    /**
     * <p>
     * Adds or updates tags for the specified Amazon Kinesis stream. Each
     * stream can have up to 10 tags.
     * </p>
     * <p>
     * If tags have already been assigned to the stream,
     * <code>AddTagsToStream</code> overwrites any existing tags that
     * correspond to the specified tag keys.
     * </p>
     *
     * @param addTagsToStreamRequest Container for the necessary parameters
     *           to execute the AddTagsToStream service method on AmazonKinesis.
     * 
     * 
     * @throws LimitExceededException
     * @throws ResourceInUseException
     * @throws InvalidArgumentException
     * @throws ResourceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonKinesis indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void addTagsToStream(AddTagsToStreamRequest addTagsToStreamRequest) {
        ExecutionContext executionContext = createExecutionContext(addTagsToStreamRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AddTagsToStreamRequest> request = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AddTagsToStreamRequestMarshaller().marshall(super.beforeMarshalling(addTagsToStreamRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);

        } finally {
            
            endClientExecution(awsRequestMetrics, request, null, LOGGING_AWS_REQUEST_METRIC);
        }
    }
    
    /**
     * <p>
     * Writes a single data record from a producer into an Amazon Kinesis
     * stream. Call <code>PutRecord</code> to send data from the producer
     * into the Amazon Kinesis stream for real-time ingestion and subsequent
     * processing, one record at a time. Each shard can support writes up to
     * 1,000 records per second, up to a maximum data write total of 1 MB per
     * second.
     * </p>
     * <p>
     * You must specify the name of the stream that captures, stores, and
     * transports the data; a partition key; and the data blob itself.
     * </p>
     * <p>
     * The data blob can be any type of data; for example, a segment from a
     * log file, geographic/location data, website clickstream data, and so
     * on.
     * </p>
     * <p>
     * The partition key is used by Amazon Kinesis to distribute data across
     * shards. Amazon Kinesis segregates the data records that belong to a
     * data stream into multiple shards, using the partition key associated
     * with each data record to determine which shard a given data record
     * belongs to.
     * </p>
     * <p>
     * Partition keys are Unicode strings, with a maximum length limit of
     * 256 characters for each key. An MD5 hash function is used to map
     * partition keys to 128-bit integer values and to map associated data
     * records to shards using the hash key ranges of the shards. You can
     * override hashing the partition key to determine the shard by
     * explicitly specifying a hash value using the
     * <code>ExplicitHashKey</code> parameter. For more information, see
     * <a href="http://docs.aws.amazon.com/kinesis/latest/dev/developing-producers-with-sdk.html#kinesis-using-sdk-java-add-data-to-stream"> Adding Data to a Stream </a>
     * in the <i>Amazon Kinesis Developer Guide</i> .
     * </p>
     * <p>
     * <code>PutRecord</code> returns the shard ID of where the data record
     * was placed and the sequence number that was assigned to the data
     * record.
     * </p>
     * <p>
     * Sequence numbers generally increase over time. To guarantee strictly
     * increasing ordering, use the <code>SequenceNumberForOrdering</code>
     * parameter. For more information, see
     * <a href="http://docs.aws.amazon.com/kinesis/latest/dev/developing-producers-with-sdk.html#kinesis-using-sdk-java-add-data-to-stream"> Adding Data to a Stream </a>
     * in the <i>Amazon Kinesis Developer Guide</i> .
     * </p>
     * <p>
     * If a <code>PutRecord</code> request cannot be processed because of
     * insufficient provisioned throughput on the shard involved in the
     * request, <code>PutRecord</code> throws
     * <code>ProvisionedThroughputExceededException</code> .
     * </p>
     * <p>
     * By default, data records are accessible for only 24 hours from the
     * time that they are added to an Amazon Kinesis stream. This retention
     * period can be modified using the DecreaseStreamRetentionPeriod and
     * IncreaseStreamRetentionPeriod operations.
     * </p>
     *
     * @param putRecordRequest Container for the necessary parameters to
     *           execute the PutRecord service method on AmazonKinesis.
     * 
     * @return The response from the PutRecord service method, as returned by
     *         AmazonKinesis.
     * 
     * @throws ProvisionedThroughputExceededException
     * @throws InvalidArgumentException
     * @throws ResourceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonKinesis indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public PutRecordResult putRecord(PutRecordRequest putRecordRequest) {
        ExecutionContext executionContext = createExecutionContext(putRecordRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<PutRecordRequest> request = null;
        Response<PutRecordResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new PutRecordRequestMarshaller().marshall(super.beforeMarshalling(putRecordRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            Unmarshaller<PutRecordResult, JsonUnmarshallerContext> unmarshaller =
                new PutRecordResultJsonUnmarshaller();
            JsonResponseHandler<PutRecordResult> responseHandler =
                new JsonResponseHandler<PutRecordResult>(unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Creates a Amazon Kinesis stream. A stream captures and transports
     * data records that are continuously emitted from different data sources
     * or <i>producers</i> . Scale-out within an Amazon Kinesis stream is
     * explicitly supported by means of shards, which are uniquely identified
     * groups of data records in an Amazon Kinesis stream.
     * </p>
     * <p>
     * You specify and control the number of shards that a stream is
     * composed of. Each shard can support reads up to 5 transactions per
     * second, up to a maximum data read total of 2 MB per second. Each shard
     * can support writes up to 1,000 records per second, up to a maximum
     * data write total of 1 MB per second. You can add shards to a stream if
     * the amount of data input increases and you can remove shards if the
     * amount of data input decreases.
     * </p>
     * <p>
     * The stream name identifies the stream. The name is scoped to the AWS
     * account used by the application. It is also scoped by region. That is,
     * two streams in two different accounts can have the same name, and two
     * streams in the same account, but in two different regions, can have
     * the same name.
     * </p>
     * <p>
     * <code>CreateStream</code> is an asynchronous operation. Upon
     * receiving a <code>CreateStream</code> request, Amazon Kinesis
     * immediately returns and sets the stream status to
     * <code>CREATING</code> . After the stream is created, Amazon Kinesis
     * sets the stream status to <code>ACTIVE</code> . You should perform
     * read and write operations only on an <code>ACTIVE</code> stream.
     * </p>
     * <p>
     * You receive a <code>LimitExceededException</code> when making a
     * <code>CreateStream</code> request if you try to do one of the
     * following:
     * </p>
     * 
     * <ul>
     * <li>Have more than five streams in the <code>CREATING</code> state at
     * any point in time.</li>
     * <li>Create more shards than are authorized for your account.</li>
     * 
     * </ul>
     * <p>
     * For the default shard limit for an AWS account, see
     * <a href="http://docs.aws.amazon.com/kinesis/latest/dev/service-sizes-and-limits.html"> Amazon Kinesis Limits </a> . If you need to increase this limit, <a href="http://docs.aws.amazon.com/general/latest/gr/aws_service_limits.html"> contact AWS Support </a>
     * .
     * </p>
     * <p>
     * You can use <code>DescribeStream</code> to check the stream status,
     * which is returned in <code>StreamStatus</code> .
     * </p>
     * <p>
     * CreateStream has a limit of 5 transactions per second per account.
     * </p>
     *
     * @param createStreamRequest Container for the necessary parameters to
     *           execute the CreateStream service method on AmazonKinesis.
     * 
     * 
     * @throws LimitExceededException
     * @throws ResourceInUseException
     * @throws InvalidArgumentException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonKinesis indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void createStream(CreateStreamRequest createStreamRequest) {
        ExecutionContext executionContext = createExecutionContext(createStreamRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateStreamRequest> request = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateStreamRequestMarshaller().marshall(super.beforeMarshalling(createStreamRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);

        } finally {
            
            endClientExecution(awsRequestMetrics, request, null, LOGGING_AWS_REQUEST_METRIC);
        }
    }
    
    /**
     * <p>
     * Decreases the stream's retention period, which is the length of time
     * data records are accessible after they are added to the stream. The
     * minimum value of a stream???s retention period is 24 hours.
     * </p>
     * <p>
     * This operation may result in lost data. For example, if the stream's
     * retention period is 48 hours and is decreased to 24 hours, any data
     * already in the stream that is older than 24 hours is inaccessible.
     * </p>
     *
     * @param decreaseStreamRetentionPeriodRequest Container for the
     *           necessary parameters to execute the DecreaseStreamRetentionPeriod
     *           service method on AmazonKinesis.
     * 
     * 
     * @throws LimitExceededException
     * @throws ResourceInUseException
     * @throws InvalidArgumentException
     * @throws ResourceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonKinesis indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void decreaseStreamRetentionPeriod(DecreaseStreamRetentionPeriodRequest decreaseStreamRetentionPeriodRequest) {
        ExecutionContext executionContext = createExecutionContext(decreaseStreamRetentionPeriodRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DecreaseStreamRetentionPeriodRequest> request = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DecreaseStreamRetentionPeriodRequestMarshaller().marshall(super.beforeMarshalling(decreaseStreamRetentionPeriodRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);

        } finally {
            
            endClientExecution(awsRequestMetrics, request, null, LOGGING_AWS_REQUEST_METRIC);
        }
    }
    
    /**
     * <p>
     * Deletes a stream and all its shards and data. You must shut down any
     * applications that are operating on the stream before you delete the
     * stream. If an application attempts to operate on a deleted stream, it
     * will receive the exception <code>ResourceNotFoundException</code> .
     * </p>
     * <p>
     * If the stream is in the <code>ACTIVE</code> state, you can delete it.
     * After a <code>DeleteStream</code> request, the specified stream is in
     * the <code>DELETING</code> state until Amazon Kinesis completes the
     * deletion.
     * </p>
     * <p>
     * <b>Note:</b> Amazon Kinesis might continue to accept data read and
     * write operations, such as PutRecord, PutRecords, and GetRecords, on a
     * stream in the <code>DELETING</code> state until the stream deletion is
     * complete.
     * </p>
     * <p>
     * When you delete a stream, any shards in that stream are also deleted,
     * and any tags are dissociated from the stream.
     * </p>
     * <p>
     * You can use the DescribeStream operation to check the state of the
     * stream, which is returned in <code>StreamStatus</code> .
     * </p>
     * <p>
     * DeleteStream has a limit of 5 transactions per second per account.
     * </p>
     *
     * @param deleteStreamRequest Container for the necessary parameters to
     *           execute the DeleteStream service method on AmazonKinesis.
     * 
     * 
     * @throws LimitExceededException
     * @throws ResourceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonKinesis indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void deleteStream(DeleteStreamRequest deleteStreamRequest) {
        ExecutionContext executionContext = createExecutionContext(deleteStreamRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteStreamRequest> request = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteStreamRequestMarshaller().marshall(super.beforeMarshalling(deleteStreamRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);

        } finally {
            
            endClientExecution(awsRequestMetrics, request, null, LOGGING_AWS_REQUEST_METRIC);
        }
    }
    
    /**
     * <p>
     * Merges two adjacent shards in a stream and combines them into a
     * single shard to reduce the stream's capacity to ingest and transport
     * data. Two shards are considered adjacent if the union of the hash key
     * ranges for the two shards form a contiguous set with no gaps. For
     * example, if you have two shards, one with a hash key range of
     * 276...381 and the other with a hash key range of 382...454, then you
     * could merge these two shards into a single shard that would have a
     * hash key range of 276...454. After the merge, the single child shard
     * receives data for all hash key values covered by the two parent
     * shards.
     * </p>
     * <p>
     * <code>MergeShards</code> is called when there is a need to reduce the
     * overall capacity of a stream because of excess capacity that is not
     * being used. You must specify the shard to be merged and the adjacent
     * shard for a stream. For more information about merging shards, see
     * <a href="http://docs.aws.amazon.com/kinesis/latest/dev/kinesis-using-sdk-java-resharding-merge.html"> Merge Two Shards </a>
     * in the <i>Amazon Kinesis Developer Guide</i> .
     * </p>
     * <p>
     * If the stream is in the <code>ACTIVE</code> state, you can call
     * <code>MergeShards</code> . If a stream is in the <code>CREATING</code>
     * , <code>UPDATING</code> , or <code>DELETING</code> state,
     * <code>MergeShards</code> returns a <code>ResourceInUseException</code>
     * . If the specified stream does not exist, <code>MergeShards</code>
     * returns a <code>ResourceNotFoundException</code> .
     * </p>
     * <p>
     * You can use DescribeStream to check the state of the stream, which is
     * returned in <code>StreamStatus</code> .
     * </p>
     * <p>
     * <code>MergeShards</code> is an asynchronous operation. Upon receiving
     * a <code>MergeShards</code> request, Amazon Kinesis immediately returns
     * a response and sets the <code>StreamStatus</code> to
     * <code>UPDATING</code> . After the operation is completed, Amazon
     * Kinesis sets the <code>StreamStatus</code> to <code>ACTIVE</code> .
     * Read and write operations continue to work while the stream is in the
     * <code>UPDATING</code> state.
     * </p>
     * <p>
     * You use DescribeStream to determine the shard IDs that are specified
     * in the <code>MergeShards</code> request.
     * </p>
     * <p>
     * If you try to operate on too many streams in parallel using
     * CreateStream, DeleteStream, <code>MergeShards</code> or SplitShard,
     * you will receive a <code>LimitExceededException</code> .
     * </p>
     * <p>
     * <code>MergeShards</code> has limit of 5 transactions per second per
     * account.
     * </p>
     *
     * @param mergeShardsRequest Container for the necessary parameters to
     *           execute the MergeShards service method on AmazonKinesis.
     * 
     * 
     * @throws LimitExceededException
     * @throws ResourceInUseException
     * @throws InvalidArgumentException
     * @throws ResourceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonKinesis indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void mergeShards(MergeShardsRequest mergeShardsRequest) {
        ExecutionContext executionContext = createExecutionContext(mergeShardsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<MergeShardsRequest> request = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new MergeShardsRequestMarshaller().marshall(super.beforeMarshalling(mergeShardsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);

        } finally {
            
            endClientExecution(awsRequestMetrics, request, null, LOGGING_AWS_REQUEST_METRIC);
        }
    }
    
    /**
     * <p>
     * Writes multiple data records from a producer into an Amazon Kinesis
     * stream in a single call (also referred to as a <code>PutRecords</code>
     * request). Use this operation to send data from a data producer into
     * the Amazon Kinesis stream for data ingestion and processing.
     * </p>
     * <p>
     * Each <code>PutRecords</code> request can support up to 500 records.
     * Each record in the request can be as large as 1 MB, up to a limit of 5
     * MB for the entire request, including partition keys. Each shard can
     * support writes up to 1,000 records per second, up to a maximum data
     * write total of 1 MB per second.
     * </p>
     * <p>
     * You must specify the name of the stream that captures, stores, and
     * transports the data; and an array of request <code>Records</code> ,
     * with each record in the array requiring a partition key and data blob.
     * The record size limit applies to the total size of the partition key
     * and data blob.
     * </p>
     * <p>
     * The data blob can be any type of data; for example, a segment from a
     * log file, geographic/location data, website clickstream data, and so
     * on.
     * </p>
     * <p>
     * The partition key is used by Amazon Kinesis as input to a hash
     * function that maps the partition key and associated data to a specific
     * shard. An MD5 hash function is used to map partition keys to 128-bit
     * integer values and to map associated data records to shards. As a
     * result of this hashing mechanism, all data records with the same
     * partition key map to the same shard within the stream. For more
     * information, see
     * <a href="http://docs.aws.amazon.com/kinesis/latest/dev/developing-producers-with-sdk.html#kinesis-using-sdk-java-add-data-to-stream"> Adding Data to a Stream </a>
     * in the <i>Amazon Kinesis Developer Guide</i> .
     * </p>
     * <p>
     * Each record in the <code>Records</code> array may include an optional
     * parameter, <code>ExplicitHashKey</code> , which overrides the
     * partition key to shard mapping. This parameter allows a data producer
     * to determine explicitly the shard where the record is stored. For more
     * information, see
     * <a href="http://docs.aws.amazon.com/kinesis/latest/dev/developing-producers-with-sdk.html#kinesis-using-sdk-java-putrecords"> Adding Multiple Records with PutRecords </a>
     * in the <i>Amazon Kinesis Developer Guide</i> .
     * </p>
     * <p>
     * The <code>PutRecords</code> response includes an array of response
     * <code>Records</code> . Each record in the response array directly
     * correlates with a record in the request array using natural ordering,
     * from the top to the bottom of the request and response. The response
     * <code>Records</code> array always includes the same number of records
     * as the request array.
     * </p>
     * <p>
     * The response <code>Records</code> array includes both successfully
     * and unsuccessfully processed records. Amazon Kinesis attempts to
     * process all records in each <code>PutRecords</code> request. A single
     * record failure does not stop the processing of subsequent records.
     * </p>
     * <p>
     * A successfully-processed record includes <code>ShardId</code> and
     * <code>SequenceNumber</code> values. The <code>ShardId</code> parameter
     * identifies the shard in the stream where the record is stored. The
     * <code>SequenceNumber</code> parameter is an identifier assigned to the
     * put record, unique to all records in the stream.
     * </p>
     * <p>
     * An unsuccessfully-processed record includes <code>ErrorCode</code>
     * and <code>ErrorMessage</code> values. <code>ErrorCode</code> reflects
     * the type of error and can be one of the following values:
     * <code>ProvisionedThroughputExceededException</code> or
     * <code>InternalFailure</code> . <code>ErrorMessage</code> provides more
     * detailed information about the
     * <code>ProvisionedThroughputExceededException</code> exception
     * including the account ID, stream name, and shard ID of the record that
     * was throttled. For more information about partially successful
     * responses, see
     * <a href="http://docs.aws.amazon.com/kinesis/latest/dev/kinesis-using-sdk-java-add-data-to-stream.html#kinesis-using-sdk-java-putrecords"> Adding Multiple Records with PutRecords </a>
     * in the <i>Amazon Kinesis Developer Guide</i> .
     * </p>
     * <p>
     * By default, data records are accessible for only 24 hours from the
     * time that they are added to an Amazon Kinesis stream. This retention
     * period can be modified using the DecreaseStreamRetentionPeriod and
     * IncreaseStreamRetentionPeriod operations.
     * </p>
     *
     * @param putRecordsRequest Container for the necessary parameters to
     *           execute the PutRecords service method on AmazonKinesis.
     * 
     * @return The response from the PutRecords service method, as returned
     *         by AmazonKinesis.
     * 
     * @throws ProvisionedThroughputExceededException
     * @throws InvalidArgumentException
     * @throws ResourceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonKinesis indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public PutRecordsResult putRecords(PutRecordsRequest putRecordsRequest) {
        ExecutionContext executionContext = createExecutionContext(putRecordsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<PutRecordsRequest> request = null;
        Response<PutRecordsResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new PutRecordsRequestMarshaller().marshall(super.beforeMarshalling(putRecordsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            Unmarshaller<PutRecordsResult, JsonUnmarshallerContext> unmarshaller =
                new PutRecordsResultJsonUnmarshaller();
            JsonResponseHandler<PutRecordsResult> responseHandler =
                new JsonResponseHandler<PutRecordsResult>(unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Describes the specified stream.
     * </p>
     * <p>
     * The information about the stream includes its current status, its
     * Amazon Resource Name (ARN), and an array of shard objects. For each
     * shard object, there is information about the hash key and sequence
     * number ranges that the shard spans, and the IDs of any earlier shards
     * that played in a role in creating the shard. A sequence number is the
     * identifier associated with every record ingested in the Amazon Kinesis
     * stream. The sequence number is assigned when a record is put into the
     * stream.
     * </p>
     * <p>
     * You can limit the number of returned shards using the
     * <code>Limit</code> parameter. The number of shards in a stream may be
     * too large to return from a single call to <code>DescribeStream</code>
     * . You can detect this by using the <code>HasMoreShards</code> flag in
     * the returned output. <code>HasMoreShards</code> is set to
     * <code>true</code> when there is more data available.
     * </p>
     * <p>
     * <code>DescribeStream</code> is a paginated operation. If there are
     * more shards available, you can request them using the shard ID of the
     * last shard returned. Specify this ID in the
     * <code>ExclusiveStartShardId</code> parameter in a subsequent request
     * to <code>DescribeStream</code> .
     * </p>
     * <p>
     * DescribeStream has a limit of 10 transactions per second per account.
     * </p>
     *
     * @param describeStreamRequest Container for the necessary parameters to
     *           execute the DescribeStream service method on AmazonKinesis.
     * 
     * @return The response from the DescribeStream service method, as
     *         returned by AmazonKinesis.
     * 
     * @throws LimitExceededException
     * @throws ResourceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonKinesis indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeStreamResult describeStream(DescribeStreamRequest describeStreamRequest) {
        ExecutionContext executionContext = createExecutionContext(describeStreamRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeStreamRequest> request = null;
        Response<DescribeStreamResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeStreamRequestMarshaller().marshall(super.beforeMarshalling(describeStreamRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            Unmarshaller<DescribeStreamResult, JsonUnmarshallerContext> unmarshaller =
                new DescribeStreamResultJsonUnmarshaller();
            JsonResponseHandler<DescribeStreamResult> responseHandler =
                new JsonResponseHandler<DescribeStreamResult>(unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Gets a shard iterator. A shard iterator expires five minutes after it
     * is returned to the requester.
     * </p>
     * <p>
     * A shard iterator specifies the position in the shard from which to
     * start reading data records sequentially. A shard iterator specifies
     * this position using the sequence number of a data record in a shard. A
     * sequence number is the identifier associated with every record
     * ingested in the Amazon Kinesis stream. The sequence number is assigned
     * when a record is put into the stream.
     * </p>
     * <p>
     * You must specify the shard iterator type. For example, you can set
     * the <code>ShardIteratorType</code> parameter to read exactly from the
     * position denoted by a specific sequence number by using the
     * <code>AT_SEQUENCE_NUMBER</code> shard iterator type, or right after
     * the sequence number by using the <code>AFTER_SEQUENCE_NUMBER</code>
     * shard iterator type, using sequence numbers returned by earlier calls
     * to PutRecord, PutRecords, GetRecords, or DescribeStream. You can
     * specify the shard iterator type <code>TRIM_HORIZON</code> in the
     * request to cause <code>ShardIterator</code> to point to the last
     * untrimmed record in the shard in the system, which is the oldest data
     * record in the shard. Or you can point to just after the most recent
     * record in the shard, by using the shard iterator type
     * <code>LATEST</code> , so that you always read the most recent data in
     * the shard.
     * </p>
     * <p>
     * When you repeatedly read from an Amazon Kinesis stream use a
     * GetShardIterator request to get the first shard iterator for use in
     * your first GetRecords request and then use the shard iterator returned
     * by the GetRecords request in <code>NextShardIterator</code> for
     * subsequent reads. A new shard iterator is returned by every GetRecords
     * request in <code>NextShardIterator</code> , which you use in the
     * <code>ShardIterator</code> parameter of the next GetRecords request.
     * </p>
     * <p>
     * If a GetShardIterator request is made too often, you receive a
     * <code>ProvisionedThroughputExceededException</code> . For more
     * information about throughput limits, see GetRecords.
     * </p>
     * <p>
     * If the shard is closed, the iterator can't return more data, and
     * GetShardIterator returns <code>null</code> for its
     * <code>ShardIterator</code> . A shard can be closed using SplitShard or
     * MergeShards.
     * </p>
     * <p>
     * GetShardIterator has a limit of 5 transactions per second per account
     * per open shard.
     * </p>
     *
     * @param getShardIteratorRequest Container for the necessary parameters
     *           to execute the GetShardIterator service method on AmazonKinesis.
     * 
     * @return The response from the GetShardIterator service method, as
     *         returned by AmazonKinesis.
     * 
     * @throws ProvisionedThroughputExceededException
     * @throws InvalidArgumentException
     * @throws ResourceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonKinesis indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetShardIteratorResult getShardIterator(GetShardIteratorRequest getShardIteratorRequest) {
        ExecutionContext executionContext = createExecutionContext(getShardIteratorRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetShardIteratorRequest> request = null;
        Response<GetShardIteratorResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetShardIteratorRequestMarshaller().marshall(super.beforeMarshalling(getShardIteratorRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            Unmarshaller<GetShardIteratorResult, JsonUnmarshallerContext> unmarshaller =
                new GetShardIteratorResultJsonUnmarshaller();
            JsonResponseHandler<GetShardIteratorResult> responseHandler =
                new JsonResponseHandler<GetShardIteratorResult>(unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists the tags for the specified Amazon Kinesis stream.
     * </p>
     *
     * @param listTagsForStreamRequest Container for the necessary parameters
     *           to execute the ListTagsForStream service method on AmazonKinesis.
     * 
     * @return The response from the ListTagsForStream service method, as
     *         returned by AmazonKinesis.
     * 
     * @throws LimitExceededException
     * @throws InvalidArgumentException
     * @throws ResourceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonKinesis indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListTagsForStreamResult listTagsForStream(ListTagsForStreamRequest listTagsForStreamRequest) {
        ExecutionContext executionContext = createExecutionContext(listTagsForStreamRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListTagsForStreamRequest> request = null;
        Response<ListTagsForStreamResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListTagsForStreamRequestMarshaller().marshall(super.beforeMarshalling(listTagsForStreamRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            Unmarshaller<ListTagsForStreamResult, JsonUnmarshallerContext> unmarshaller =
                new ListTagsForStreamResultJsonUnmarshaller();
            JsonResponseHandler<ListTagsForStreamResult> responseHandler =
                new JsonResponseHandler<ListTagsForStreamResult>(unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Gets data records from a shard.
     * </p>
     * <p>
     * Specify a shard iterator using the <code>ShardIterator</code>
     * parameter. The shard iterator specifies the position in the shard from
     * which you want to start reading data records sequentially. If there
     * are no records available in the portion of the shard that the iterator
     * points to, GetRecords returns an empty list. Note that it might take
     * multiple calls to get to a portion of the shard that contains records.
     * </p>
     * <p>
     * You can scale by provisioning multiple shards. Your application
     * should have one thread per shard, each reading continuously from its
     * stream. To read from a stream continually, call GetRecords in a loop.
     * Use GetShardIterator to get the shard iterator to specify in the first
     * GetRecords call. GetRecords returns a new shard iterator in
     * <code>NextShardIterator</code> . Specify the shard iterator returned
     * in <code>NextShardIterator</code> in subsequent calls to GetRecords.
     * Note that if the shard has been closed, the shard iterator can't
     * return more data and GetRecords returns <code>null</code> in
     * <code>NextShardIterator</code> . You can terminate the loop when the
     * shard is closed, or when the shard iterator reaches the record with
     * the sequence number or other attribute that marks it as the last
     * record to process.
     * </p>
     * <p>
     * Each data record can be up to 1 MB in size, and each shard can read
     * up to 2 MB per second. You can ensure that your calls don't exceed the
     * maximum supported size or throughput by using the <code>Limit</code>
     * parameter to specify the maximum number of records that GetRecords can
     * return. Consider your average record size when determining this limit.
     * </p>
     * <p>
     * The size of the data returned by GetRecords will vary depending on
     * the utilization of the shard. The maximum size of data that GetRecords
     * can return is 10 MB. If a call returns this amount of data, subsequent
     * calls made within the next 5 seconds throw
     * <code>ProvisionedThroughputExceededException</code> . If there is
     * insufficient provisioned throughput on the shard, subsequent calls
     * made within the next 1 second throw
     * <code>ProvisionedThroughputExceededException</code> . Note that
     * GetRecords won't return any data when it throws an exception. For this
     * reason, we recommend that you wait one second between calls to
     * GetRecords; however, it's possible that the application will get
     * exceptions for longer than 1 second.
     * </p>
     * <p>
     * To detect whether the application is falling behind in processing,
     * you can use the <code>MillisBehindLatest</code> response attribute.
     * You can also monitor the stream using CloudWatch metrics (see
     * <a href="http://docs.aws.amazon.com/kinesis/latest/dev/monitoring.html"> Monitoring Amazon Kinesis </a>
     * in the <i>Amazon Kinesis Developer Guide</i> ).
     * </p>
     * <p>
     * Each Amazon Kinesis record includes a value,
     * <code>ApproximateArrivalTimestamp</code> , that is set when an Amazon
     * Kinesis stream successfully receives and stores a record. This is
     * commonly referred to as a server-side timestamp, which is different
     * than a client-side timestamp, where the timestamp is set when a data
     * producer creates or sends the record to a stream. The timestamp has
     * millisecond precision. There are no guarantees about the timestamp
     * accuracy, or that the timestamp is always increasing. For example,
     * records in a shard or across a stream might have timestamps that are
     * out of order.
     * </p>
     *
     * @param getRecordsRequest Container for the necessary parameters to
     *           execute the GetRecords service method on AmazonKinesis.
     * 
     * @return The response from the GetRecords service method, as returned
     *         by AmazonKinesis.
     * 
     * @throws ProvisionedThroughputExceededException
     * @throws ExpiredIteratorException
     * @throws InvalidArgumentException
     * @throws ResourceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonKinesis indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetRecordsResult getRecords(GetRecordsRequest getRecordsRequest) {
        ExecutionContext executionContext = createExecutionContext(getRecordsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetRecordsRequest> request = null;
        Response<GetRecordsResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetRecordsRequestMarshaller().marshall(super.beforeMarshalling(getRecordsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            Unmarshaller<GetRecordsResult, JsonUnmarshallerContext> unmarshaller =
                new GetRecordsResultJsonUnmarshaller();
            JsonResponseHandler<GetRecordsResult> responseHandler =
                new JsonResponseHandler<GetRecordsResult>(unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Splits a shard into two new shards in the stream, to increase the
     * stream's capacity to ingest and transport data.
     * <code>SplitShard</code> is called when there is a need to increase the
     * overall capacity of stream because of an expected increase in the
     * volume of data records being ingested.
     * </p>
     * <p>
     * You can also use <code>SplitShard</code> when a shard appears to be
     * approaching its maximum utilization, for example, when the set of
     * producers sending data into the specific shard are suddenly sending
     * more than previously anticipated. You can also call
     * <code>SplitShard</code> to increase stream capacity, so that more
     * Amazon Kinesis applications can simultaneously read data from the
     * stream for real-time processing.
     * </p>
     * <p>
     * You must specify the shard to be split and the new hash key, which is
     * the position in the shard where the shard gets split in two. In many
     * cases, the new hash key might simply be the average of the beginning
     * and ending hash key, but it can be any hash key value in the range
     * being mapped into the shard. For more information about splitting
     * shards, see
     * <a href="http://docs.aws.amazon.com/kinesis/latest/dev/kinesis-using-sdk-java-resharding-split.html"> Split a Shard </a>
     * in the <i>Amazon Kinesis Developer Guide</i> .
     * </p>
     * <p>
     * You can use DescribeStream to determine the shard ID and hash key
     * values for the <code>ShardToSplit</code> and
     * <code>NewStartingHashKey</code> parameters that are specified in the
     * <code>SplitShard</code> request.
     * </p>
     * <p>
     * <code>SplitShard</code> is an asynchronous operation. Upon receiving
     * a <code>SplitShard</code> request, Amazon Kinesis immediately returns
     * a response and sets the stream status to <code>UPDATING</code> . After
     * the operation is completed, Amazon Kinesis sets the stream status to
     * <code>ACTIVE</code> . Read and write operations continue to work while
     * the stream is in the <code>UPDATING</code> state.
     * </p>
     * <p>
     * You can use <code>DescribeStream</code> to check the status of the
     * stream, which is returned in <code>StreamStatus</code> . If the stream
     * is in the <code>ACTIVE</code> state, you can call
     * <code>SplitShard</code> . If a stream is in <code>CREATING</code> or
     * <code>UPDATING</code> or <code>DELETING</code> states,
     * <code>DescribeStream</code> returns a
     * <code>ResourceInUseException</code> .
     * </p>
     * <p>
     * If the specified stream does not exist, <code>DescribeStream</code>
     * returns a <code>ResourceNotFoundException</code> . If you try to
     * create more shards than are authorized for your account, you receive a
     * <code>LimitExceededException</code> .
     * </p>
     * <p>
     * For the default shard limit for an AWS account, see
     * <a href="http://docs.aws.amazon.com/kinesis/latest/dev/service-sizes-and-limits.html"> Amazon Kinesis Limits </a> . If you need to increase this limit, <a href="http://docs.aws.amazon.com/general/latest/gr/aws_service_limits.html"> contact AWS Support </a>
     * .
     * </p>
     * <p>
     * If you try to operate on too many streams in parallel using
     * CreateStream, DeleteStream, MergeShards or SplitShard, you receive a
     * <code>LimitExceededException</code> .
     * </p>
     * <p>
     * <code>SplitShard</code> has limit of 5 transactions per second per
     * account.
     * </p>
     *
     * @param splitShardRequest Container for the necessary parameters to
     *           execute the SplitShard service method on AmazonKinesis.
     * 
     * 
     * @throws LimitExceededException
     * @throws ResourceInUseException
     * @throws InvalidArgumentException
     * @throws ResourceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonKinesis indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void splitShard(SplitShardRequest splitShardRequest) {
        ExecutionContext executionContext = createExecutionContext(splitShardRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<SplitShardRequest> request = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new SplitShardRequestMarshaller().marshall(super.beforeMarshalling(splitShardRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);

        } finally {
            
            endClientExecution(awsRequestMetrics, request, null, LOGGING_AWS_REQUEST_METRIC);
        }
    }
    
    /**
     * <p>
     * Increases the stream's retention period, which is the length of time
     * data records are accessible after they are added to the stream. The
     * maximum value of a stream???s retention period is 168 hours (7 days).
     * </p>
     * <p>
     * Upon choosing a longer stream retention period, this operation will
     * increase the time period records are accessible that have not yet
     * expired. However, it will not make previous data that has expired
     * (older than the stream???s previous retention period) accessible after
     * the operation has been called. For example, if a stream???s retention
     * period is set to 24 hours and is increased to 168 hours, any data that
     * is older than 24 hours will remain inaccessible to consumer
     * applications.
     * </p>
     *
     * @param increaseStreamRetentionPeriodRequest Container for the
     *           necessary parameters to execute the IncreaseStreamRetentionPeriod
     *           service method on AmazonKinesis.
     * 
     * 
     * @throws LimitExceededException
     * @throws ResourceInUseException
     * @throws InvalidArgumentException
     * @throws ResourceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonKinesis indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void increaseStreamRetentionPeriod(IncreaseStreamRetentionPeriodRequest increaseStreamRetentionPeriodRequest) {
        ExecutionContext executionContext = createExecutionContext(increaseStreamRetentionPeriodRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<IncreaseStreamRetentionPeriodRequest> request = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new IncreaseStreamRetentionPeriodRequestMarshaller().marshall(super.beforeMarshalling(increaseStreamRetentionPeriodRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);

        } finally {
            
            endClientExecution(awsRequestMetrics, request, null, LOGGING_AWS_REQUEST_METRIC);
        }
    }
    
    /**
     * <p>
     * Deletes tags from the specified Amazon Kinesis stream.
     * </p>
     * <p>
     * If you specify a tag that does not exist, it is ignored.
     * </p>
     *
     * @param removeTagsFromStreamRequest Container for the necessary
     *           parameters to execute the RemoveTagsFromStream service method on
     *           AmazonKinesis.
     * 
     * 
     * @throws LimitExceededException
     * @throws ResourceInUseException
     * @throws InvalidArgumentException
     * @throws ResourceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonKinesis indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void removeTagsFromStream(RemoveTagsFromStreamRequest removeTagsFromStreamRequest) {
        ExecutionContext executionContext = createExecutionContext(removeTagsFromStreamRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<RemoveTagsFromStreamRequest> request = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new RemoveTagsFromStreamRequestMarshaller().marshall(super.beforeMarshalling(removeTagsFromStreamRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            JsonResponseHandler<Void> responseHandler = new JsonResponseHandler<Void>(null);
            invoke(request, responseHandler, executionContext);

        } finally {
            
            endClientExecution(awsRequestMetrics, request, null, LOGGING_AWS_REQUEST_METRIC);
        }
    }
    
    /**
     * <p>
     * Lists your streams.
     * </p>
     * <p>
     * The number of streams may be too large to return from a single call
     * to <code>ListStreams</code> . You can limit the number of returned
     * streams using the <code>Limit</code> parameter. If you do not specify
     * a value for the <code>Limit</code> parameter, Amazon Kinesis uses the
     * default limit, which is currently 10.
     * </p>
     * <p>
     * You can detect if there are more streams available to list by using
     * the <code>HasMoreStreams</code> flag from the returned output. If
     * there are more streams available, you can request more streams by
     * using the name of the last stream returned by the
     * <code>ListStreams</code> request in the
     * <code>ExclusiveStartStreamName</code> parameter in a subsequent
     * request to <code>ListStreams</code> . The group of stream names
     * returned by the subsequent request is then added to the list. You can
     * continue this process until all the stream names have been collected
     * in the list.
     * </p>
     * <p>
     * ListStreams has a limit of 5 transactions per second per account.
     * </p>
     *
     * @param listStreamsRequest Container for the necessary parameters to
     *           execute the ListStreams service method on AmazonKinesis.
     * 
     * @return The response from the ListStreams service method, as returned
     *         by AmazonKinesis.
     * 
     * @throws LimitExceededException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonKinesis indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListStreamsResult listStreams(ListStreamsRequest listStreamsRequest) {
        ExecutionContext executionContext = createExecutionContext(listStreamsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListStreamsRequest> request = null;
        Response<ListStreamsResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListStreamsRequestMarshaller().marshall(super.beforeMarshalling(listStreamsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            Unmarshaller<ListStreamsResult, JsonUnmarshallerContext> unmarshaller =
                new ListStreamsResultJsonUnmarshaller();
            JsonResponseHandler<ListStreamsResult> responseHandler =
                new JsonResponseHandler<ListStreamsResult>(unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Lists your streams.
     * </p>
     * <p>
     * The number of streams may be too large to return from a single call
     * to <code>ListStreams</code> . You can limit the number of returned
     * streams using the <code>Limit</code> parameter. If you do not specify
     * a value for the <code>Limit</code> parameter, Amazon Kinesis uses the
     * default limit, which is currently 10.
     * </p>
     * <p>
     * You can detect if there are more streams available to list by using
     * the <code>HasMoreStreams</code> flag from the returned output. If
     * there are more streams available, you can request more streams by
     * using the name of the last stream returned by the
     * <code>ListStreams</code> request in the
     * <code>ExclusiveStartStreamName</code> parameter in a subsequent
     * request to <code>ListStreams</code> . The group of stream names
     * returned by the subsequent request is then added to the list. You can
     * continue this process until all the stream names have been collected
     * in the list.
     * </p>
     * <p>
     * ListStreams has a limit of 5 transactions per second per account.
     * </p>
     * 
     * @return The response from the ListStreams service method, as returned
     *         by AmazonKinesis.
     * 
     * @throws LimitExceededException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonKinesis indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListStreamsResult listStreams() throws AmazonServiceException, AmazonClientException {
        return listStreams(new ListStreamsRequest());
    }
    
    /**
     * <p>
     * Writes a single data record from a producer into an Amazon Kinesis
     * stream. Call <code>PutRecord</code> to send data from the producer
     * into the Amazon Kinesis stream for real-time ingestion and subsequent
     * processing, one record at a time. Each shard can support writes up to
     * 1,000 records per second, up to a maximum data write total of 1 MB per
     * second.
     * </p>
     * <p>
     * You must specify the name of the stream that captures, stores, and
     * transports the data; a partition key; and the data blob itself.
     * </p>
     * <p>
     * The data blob can be any type of data; for example, a segment from a
     * log file, geographic/location data, website clickstream data, and so
     * on.
     * </p>
     * <p>
     * The partition key is used by Amazon Kinesis to distribute data across
     * shards. Amazon Kinesis segregates the data records that belong to a
     * data stream into multiple shards, using the partition key associated
     * with each data record to determine which shard a given data record
     * belongs to.
     * </p>
     * <p>
     * Partition keys are Unicode strings, with a maximum length limit of
     * 256 characters for each key. An MD5 hash function is used to map
     * partition keys to 128-bit integer values and to map associated data
     * records to shards using the hash key ranges of the shards. You can
     * override hashing the partition key to determine the shard by
     * explicitly specifying a hash value using the
     * <code>ExplicitHashKey</code> parameter. For more information, see
     * <a href="http://docs.aws.amazon.com/kinesis/latest/dev/developing-producers-with-sdk.html#kinesis-using-sdk-java-add-data-to-stream"> Adding Data to a Stream </a>
     * in the <i>Amazon Kinesis Developer Guide</i> .
     * </p>
     * <p>
     * <code>PutRecord</code> returns the shard ID of where the data record
     * was placed and the sequence number that was assigned to the data
     * record.
     * </p>
     * <p>
     * Sequence numbers generally increase over time. To guarantee strictly
     * increasing ordering, use the <code>SequenceNumberForOrdering</code>
     * parameter. For more information, see
     * <a href="http://docs.aws.amazon.com/kinesis/latest/dev/developing-producers-with-sdk.html#kinesis-using-sdk-java-add-data-to-stream"> Adding Data to a Stream </a>
     * in the <i>Amazon Kinesis Developer Guide</i> .
     * </p>
     * <p>
     * If a <code>PutRecord</code> request cannot be processed because of
     * insufficient provisioned throughput on the shard involved in the
     * request, <code>PutRecord</code> throws
     * <code>ProvisionedThroughputExceededException</code> .
     * </p>
     * <p>
     * By default, data records are accessible for only 24 hours from the
     * time that they are added to an Amazon Kinesis stream. This retention
     * period can be modified using the DecreaseStreamRetentionPeriod and
     * IncreaseStreamRetentionPeriod operations.
     * </p>
     * 
     * @param streamName The name of the stream to put the data record into.
     * @param data The data blob to put into the record, which is
     * base64-encoded when the blob is serialized. When the data blob (the
     * payload before base64-encoding) is added to the partition key size,
     * the total size must not exceed the maximum record size (1 MB).
     * @param partitionKey Determines which shard in the stream the data
     * record is assigned to. Partition keys are Unicode strings with a
     * maximum length limit of 256 characters for each key. Amazon Kinesis
     * uses the partition key as input to a hash function that maps the
     * partition key and associated data to a specific shard. Specifically,
     * an MD5 hash function is used to map partition keys to 128-bit integer
     * values and to map associated data records to shards. As a result of
     * this hashing mechanism, all data records with the same partition key
     * will map to the same shard within the stream.
     * 
     * @return The response from the PutRecord service method, as returned by
     *         AmazonKinesis.
     * 
     * @throws ProvisionedThroughputExceededException
     * @throws InvalidArgumentException
     * @throws ResourceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonKinesis indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public PutRecordResult putRecord(String streamName, java.nio.ByteBuffer data, String partitionKey)
             throws AmazonServiceException, AmazonClientException  {
        PutRecordRequest putRecordRequest = new PutRecordRequest();
        putRecordRequest.setStreamName(streamName);
        putRecordRequest.setData(data);
        putRecordRequest.setPartitionKey(partitionKey);
        return putRecord(putRecordRequest);
    }
    
    /**
     * <p>
     * Writes a single data record from a producer into an Amazon Kinesis
     * stream. Call <code>PutRecord</code> to send data from the producer
     * into the Amazon Kinesis stream for real-time ingestion and subsequent
     * processing, one record at a time. Each shard can support writes up to
     * 1,000 records per second, up to a maximum data write total of 1 MB per
     * second.
     * </p>
     * <p>
     * You must specify the name of the stream that captures, stores, and
     * transports the data; a partition key; and the data blob itself.
     * </p>
     * <p>
     * The data blob can be any type of data; for example, a segment from a
     * log file, geographic/location data, website clickstream data, and so
     * on.
     * </p>
     * <p>
     * The partition key is used by Amazon Kinesis to distribute data across
     * shards. Amazon Kinesis segregates the data records that belong to a
     * data stream into multiple shards, using the partition key associated
     * with each data record to determine which shard a given data record
     * belongs to.
     * </p>
     * <p>
     * Partition keys are Unicode strings, with a maximum length limit of
     * 256 characters for each key. An MD5 hash function is used to map
     * partition keys to 128-bit integer values and to map associated data
     * records to shards using the hash key ranges of the shards. You can
     * override hashing the partition key to determine the shard by
     * explicitly specifying a hash value using the
     * <code>ExplicitHashKey</code> parameter. For more information, see
     * <a href="http://docs.aws.amazon.com/kinesis/latest/dev/developing-producers-with-sdk.html#kinesis-using-sdk-java-add-data-to-stream"> Adding Data to a Stream </a>
     * in the <i>Amazon Kinesis Developer Guide</i> .
     * </p>
     * <p>
     * <code>PutRecord</code> returns the shard ID of where the data record
     * was placed and the sequence number that was assigned to the data
     * record.
     * </p>
     * <p>
     * Sequence numbers generally increase over time. To guarantee strictly
     * increasing ordering, use the <code>SequenceNumberForOrdering</code>
     * parameter. For more information, see
     * <a href="http://docs.aws.amazon.com/kinesis/latest/dev/developing-producers-with-sdk.html#kinesis-using-sdk-java-add-data-to-stream"> Adding Data to a Stream </a>
     * in the <i>Amazon Kinesis Developer Guide</i> .
     * </p>
     * <p>
     * If a <code>PutRecord</code> request cannot be processed because of
     * insufficient provisioned throughput on the shard involved in the
     * request, <code>PutRecord</code> throws
     * <code>ProvisionedThroughputExceededException</code> .
     * </p>
     * <p>
     * By default, data records are accessible for only 24 hours from the
     * time that they are added to an Amazon Kinesis stream. This retention
     * period can be modified using the DecreaseStreamRetentionPeriod and
     * IncreaseStreamRetentionPeriod operations.
     * </p>
     * 
     * @param streamName The name of the stream to put the data record into.
     * @param data The data blob to put into the record, which is
     * base64-encoded when the blob is serialized. When the data blob (the
     * payload before base64-encoding) is added to the partition key size,
     * the total size must not exceed the maximum record size (1 MB).
     * @param partitionKey Determines which shard in the stream the data
     * record is assigned to. Partition keys are Unicode strings with a
     * maximum length limit of 256 characters for each key. Amazon Kinesis
     * uses the partition key as input to a hash function that maps the
     * partition key and associated data to a specific shard. Specifically,
     * an MD5 hash function is used to map partition keys to 128-bit integer
     * values and to map associated data records to shards. As a result of
     * this hashing mechanism, all data records with the same partition key
     * will map to the same shard within the stream.
     * @param sequenceNumberForOrdering Guarantees strictly increasing
     * sequence numbers, for puts from the same client and to the same
     * partition key. Usage: set the <code>SequenceNumberForOrdering</code>
     * of record <i>n</i> to the sequence number of record <i>n-1</i> (as
     * returned in the result when putting record <i>n-1</i>). If this
     * parameter is not set, records will be coarsely ordered based on
     * arrival time.
     * 
     * @return The response from the PutRecord service method, as returned by
     *         AmazonKinesis.
     * 
     * @throws ProvisionedThroughputExceededException
     * @throws InvalidArgumentException
     * @throws ResourceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonKinesis indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public PutRecordResult putRecord(String streamName, java.nio.ByteBuffer data, String partitionKey, String sequenceNumberForOrdering)
             throws AmazonServiceException, AmazonClientException  {
        PutRecordRequest putRecordRequest = new PutRecordRequest();
        putRecordRequest.setStreamName(streamName);
        putRecordRequest.setData(data);
        putRecordRequest.setPartitionKey(partitionKey);
        putRecordRequest.setSequenceNumberForOrdering(sequenceNumberForOrdering);
        return putRecord(putRecordRequest);
    }
    
    /**
     * <p>
     * Creates a Amazon Kinesis stream. A stream captures and transports
     * data records that are continuously emitted from different data sources
     * or <i>producers</i> . Scale-out within an Amazon Kinesis stream is
     * explicitly supported by means of shards, which are uniquely identified
     * groups of data records in an Amazon Kinesis stream.
     * </p>
     * <p>
     * You specify and control the number of shards that a stream is
     * composed of. Each shard can support reads up to 5 transactions per
     * second, up to a maximum data read total of 2 MB per second. Each shard
     * can support writes up to 1,000 records per second, up to a maximum
     * data write total of 1 MB per second. You can add shards to a stream if
     * the amount of data input increases and you can remove shards if the
     * amount of data input decreases.
     * </p>
     * <p>
     * The stream name identifies the stream. The name is scoped to the AWS
     * account used by the application. It is also scoped by region. That is,
     * two streams in two different accounts can have the same name, and two
     * streams in the same account, but in two different regions, can have
     * the same name.
     * </p>
     * <p>
     * <code>CreateStream</code> is an asynchronous operation. Upon
     * receiving a <code>CreateStream</code> request, Amazon Kinesis
     * immediately returns and sets the stream status to
     * <code>CREATING</code> . After the stream is created, Amazon Kinesis
     * sets the stream status to <code>ACTIVE</code> . You should perform
     * read and write operations only on an <code>ACTIVE</code> stream.
     * </p>
     * <p>
     * You receive a <code>LimitExceededException</code> when making a
     * <code>CreateStream</code> request if you try to do one of the
     * following:
     * </p>
     * 
     * <ul>
     * <li>Have more than five streams in the <code>CREATING</code> state at
     * any point in time.</li>
     * <li>Create more shards than are authorized for your account.</li>
     * 
     * </ul>
     * <p>
     * For the default shard limit for an AWS account, see
     * <a href="http://docs.aws.amazon.com/kinesis/latest/dev/service-sizes-and-limits.html"> Amazon Kinesis Limits </a> . If you need to increase this limit, <a href="http://docs.aws.amazon.com/general/latest/gr/aws_service_limits.html"> contact AWS Support </a>
     * .
     * </p>
     * <p>
     * You can use <code>DescribeStream</code> to check the stream status,
     * which is returned in <code>StreamStatus</code> .
     * </p>
     * <p>
     * CreateStream has a limit of 5 transactions per second per account.
     * </p>
     * 
     * @param streamName A name to identify the stream. The stream name is
     * scoped to the AWS account used by the application that creates the
     * stream. It is also scoped by region. That is, two streams in two
     * different AWS accounts can have the same name, and two streams in the
     * same AWS account, but in two different regions, can have the same
     * name.
     * @param shardCount The number of shards that the stream will use. The
     * throughput of the stream is a function of the number of shards; more
     * shards are required for greater provisioned throughput.
     * <p>DefaultShardLimit;
     * 
     * @return The response from the CreateStream service method, as returned
     *         by AmazonKinesis.
     * 
     * @throws LimitExceededException
     * @throws ResourceInUseException
     * @throws InvalidArgumentException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonKinesis indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void createStream(String streamName, Integer shardCount)
             throws AmazonServiceException, AmazonClientException  {
        CreateStreamRequest createStreamRequest = new CreateStreamRequest();
        createStreamRequest.setStreamName(streamName);
        createStreamRequest.setShardCount(shardCount);
        createStream(createStreamRequest);
    }
    
    /**
     * <p>
     * Deletes a stream and all its shards and data. You must shut down any
     * applications that are operating on the stream before you delete the
     * stream. If an application attempts to operate on a deleted stream, it
     * will receive the exception <code>ResourceNotFoundException</code> .
     * </p>
     * <p>
     * If the stream is in the <code>ACTIVE</code> state, you can delete it.
     * After a <code>DeleteStream</code> request, the specified stream is in
     * the <code>DELETING</code> state until Amazon Kinesis completes the
     * deletion.
     * </p>
     * <p>
     * <b>Note:</b> Amazon Kinesis might continue to accept data read and
     * write operations, such as PutRecord, PutRecords, and GetRecords, on a
     * stream in the <code>DELETING</code> state until the stream deletion is
     * complete.
     * </p>
     * <p>
     * When you delete a stream, any shards in that stream are also deleted,
     * and any tags are dissociated from the stream.
     * </p>
     * <p>
     * You can use the DescribeStream operation to check the state of the
     * stream, which is returned in <code>StreamStatus</code> .
     * </p>
     * <p>
     * DeleteStream has a limit of 5 transactions per second per account.
     * </p>
     * 
     * @param streamName The name of the stream to delete.
     * 
     * @return The response from the DeleteStream service method, as returned
     *         by AmazonKinesis.
     * 
     * @throws LimitExceededException
     * @throws ResourceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonKinesis indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void deleteStream(String streamName)
             throws AmazonServiceException, AmazonClientException  {
        DeleteStreamRequest deleteStreamRequest = new DeleteStreamRequest();
        deleteStreamRequest.setStreamName(streamName);
        deleteStream(deleteStreamRequest);
    }
    
    /**
     * <p>
     * Merges two adjacent shards in a stream and combines them into a
     * single shard to reduce the stream's capacity to ingest and transport
     * data. Two shards are considered adjacent if the union of the hash key
     * ranges for the two shards form a contiguous set with no gaps. For
     * example, if you have two shards, one with a hash key range of
     * 276...381 and the other with a hash key range of 382...454, then you
     * could merge these two shards into a single shard that would have a
     * hash key range of 276...454. After the merge, the single child shard
     * receives data for all hash key values covered by the two parent
     * shards.
     * </p>
     * <p>
     * <code>MergeShards</code> is called when there is a need to reduce the
     * overall capacity of a stream because of excess capacity that is not
     * being used. You must specify the shard to be merged and the adjacent
     * shard for a stream. For more information about merging shards, see
     * <a href="http://docs.aws.amazon.com/kinesis/latest/dev/kinesis-using-sdk-java-resharding-merge.html"> Merge Two Shards </a>
     * in the <i>Amazon Kinesis Developer Guide</i> .
     * </p>
     * <p>
     * If the stream is in the <code>ACTIVE</code> state, you can call
     * <code>MergeShards</code> . If a stream is in the <code>CREATING</code>
     * , <code>UPDATING</code> , or <code>DELETING</code> state,
     * <code>MergeShards</code> returns a <code>ResourceInUseException</code>
     * . If the specified stream does not exist, <code>MergeShards</code>
     * returns a <code>ResourceNotFoundException</code> .
     * </p>
     * <p>
     * You can use DescribeStream to check the state of the stream, which is
     * returned in <code>StreamStatus</code> .
     * </p>
     * <p>
     * <code>MergeShards</code> is an asynchronous operation. Upon receiving
     * a <code>MergeShards</code> request, Amazon Kinesis immediately returns
     * a response and sets the <code>StreamStatus</code> to
     * <code>UPDATING</code> . After the operation is completed, Amazon
     * Kinesis sets the <code>StreamStatus</code> to <code>ACTIVE</code> .
     * Read and write operations continue to work while the stream is in the
     * <code>UPDATING</code> state.
     * </p>
     * <p>
     * You use DescribeStream to determine the shard IDs that are specified
     * in the <code>MergeShards</code> request.
     * </p>
     * <p>
     * If you try to operate on too many streams in parallel using
     * CreateStream, DeleteStream, <code>MergeShards</code> or SplitShard,
     * you will receive a <code>LimitExceededException</code> .
     * </p>
     * <p>
     * <code>MergeShards</code> has limit of 5 transactions per second per
     * account.
     * </p>
     * 
     * @param streamName The name of the stream for the merge.
     * @param shardToMerge The shard ID of the shard to combine with the
     * adjacent shard for the merge.
     * @param adjacentShardToMerge The shard ID of the adjacent shard for the
     * merge.
     * 
     * @return The response from the MergeShards service method, as returned
     *         by AmazonKinesis.
     * 
     * @throws LimitExceededException
     * @throws ResourceInUseException
     * @throws InvalidArgumentException
     * @throws ResourceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonKinesis indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void mergeShards(String streamName, String shardToMerge, String adjacentShardToMerge)
             throws AmazonServiceException, AmazonClientException  {
        MergeShardsRequest mergeShardsRequest = new MergeShardsRequest();
        mergeShardsRequest.setStreamName(streamName);
        mergeShardsRequest.setShardToMerge(shardToMerge);
        mergeShardsRequest.setAdjacentShardToMerge(adjacentShardToMerge);
        mergeShards(mergeShardsRequest);
    }
    
    /**
     * <p>
     * Describes the specified stream.
     * </p>
     * <p>
     * The information about the stream includes its current status, its
     * Amazon Resource Name (ARN), and an array of shard objects. For each
     * shard object, there is information about the hash key and sequence
     * number ranges that the shard spans, and the IDs of any earlier shards
     * that played in a role in creating the shard. A sequence number is the
     * identifier associated with every record ingested in the Amazon Kinesis
     * stream. The sequence number is assigned when a record is put into the
     * stream.
     * </p>
     * <p>
     * You can limit the number of returned shards using the
     * <code>Limit</code> parameter. The number of shards in a stream may be
     * too large to return from a single call to <code>DescribeStream</code>
     * . You can detect this by using the <code>HasMoreShards</code> flag in
     * the returned output. <code>HasMoreShards</code> is set to
     * <code>true</code> when there is more data available.
     * </p>
     * <p>
     * <code>DescribeStream</code> is a paginated operation. If there are
     * more shards available, you can request them using the shard ID of the
     * last shard returned. Specify this ID in the
     * <code>ExclusiveStartShardId</code> parameter in a subsequent request
     * to <code>DescribeStream</code> .
     * </p>
     * <p>
     * DescribeStream has a limit of 10 transactions per second per account.
     * </p>
     * 
     * @param streamName The name of the stream to describe.
     * 
     * @return The response from the DescribeStream service method, as
     *         returned by AmazonKinesis.
     * 
     * @throws LimitExceededException
     * @throws ResourceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonKinesis indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeStreamResult describeStream(String streamName)
             throws AmazonServiceException, AmazonClientException  {
        DescribeStreamRequest describeStreamRequest = new DescribeStreamRequest();
        describeStreamRequest.setStreamName(streamName);
        return describeStream(describeStreamRequest);
    }
    
    /**
     * <p>
     * Describes the specified stream.
     * </p>
     * <p>
     * The information about the stream includes its current status, its
     * Amazon Resource Name (ARN), and an array of shard objects. For each
     * shard object, there is information about the hash key and sequence
     * number ranges that the shard spans, and the IDs of any earlier shards
     * that played in a role in creating the shard. A sequence number is the
     * identifier associated with every record ingested in the Amazon Kinesis
     * stream. The sequence number is assigned when a record is put into the
     * stream.
     * </p>
     * <p>
     * You can limit the number of returned shards using the
     * <code>Limit</code> parameter. The number of shards in a stream may be
     * too large to return from a single call to <code>DescribeStream</code>
     * . You can detect this by using the <code>HasMoreShards</code> flag in
     * the returned output. <code>HasMoreShards</code> is set to
     * <code>true</code> when there is more data available.
     * </p>
     * <p>
     * <code>DescribeStream</code> is a paginated operation. If there are
     * more shards available, you can request them using the shard ID of the
     * last shard returned. Specify this ID in the
     * <code>ExclusiveStartShardId</code> parameter in a subsequent request
     * to <code>DescribeStream</code> .
     * </p>
     * <p>
     * DescribeStream has a limit of 10 transactions per second per account.
     * </p>
     * 
     * @param streamName The name of the stream to describe.
     * @param exclusiveStartShardId The shard ID of the shard to start with.
     * 
     * @return The response from the DescribeStream service method, as
     *         returned by AmazonKinesis.
     * 
     * @throws LimitExceededException
     * @throws ResourceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonKinesis indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeStreamResult describeStream(String streamName, String exclusiveStartShardId)
             throws AmazonServiceException, AmazonClientException  {
        DescribeStreamRequest describeStreamRequest = new DescribeStreamRequest();
        describeStreamRequest.setStreamName(streamName);
        describeStreamRequest.setExclusiveStartShardId(exclusiveStartShardId);
        return describeStream(describeStreamRequest);
    }
    
    /**
     * <p>
     * Describes the specified stream.
     * </p>
     * <p>
     * The information about the stream includes its current status, its
     * Amazon Resource Name (ARN), and an array of shard objects. For each
     * shard object, there is information about the hash key and sequence
     * number ranges that the shard spans, and the IDs of any earlier shards
     * that played in a role in creating the shard. A sequence number is the
     * identifier associated with every record ingested in the Amazon Kinesis
     * stream. The sequence number is assigned when a record is put into the
     * stream.
     * </p>
     * <p>
     * You can limit the number of returned shards using the
     * <code>Limit</code> parameter. The number of shards in a stream may be
     * too large to return from a single call to <code>DescribeStream</code>
     * . You can detect this by using the <code>HasMoreShards</code> flag in
     * the returned output. <code>HasMoreShards</code> is set to
     * <code>true</code> when there is more data available.
     * </p>
     * <p>
     * <code>DescribeStream</code> is a paginated operation. If there are
     * more shards available, you can request them using the shard ID of the
     * last shard returned. Specify this ID in the
     * <code>ExclusiveStartShardId</code> parameter in a subsequent request
     * to <code>DescribeStream</code> .
     * </p>
     * <p>
     * DescribeStream has a limit of 10 transactions per second per account.
     * </p>
     * 
     * @param streamName The name of the stream to describe.
     * @param limit The maximum number of shards to return.
     * @param exclusiveStartShardId The shard ID of the shard to start with.
     * 
     * @return The response from the DescribeStream service method, as
     *         returned by AmazonKinesis.
     * 
     * @throws LimitExceededException
     * @throws ResourceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonKinesis indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeStreamResult describeStream(String streamName, Integer limit, String exclusiveStartShardId)
             throws AmazonServiceException, AmazonClientException  {
        DescribeStreamRequest describeStreamRequest = new DescribeStreamRequest();
        describeStreamRequest.setStreamName(streamName);
        describeStreamRequest.setLimit(limit);
        describeStreamRequest.setExclusiveStartShardId(exclusiveStartShardId);
        return describeStream(describeStreamRequest);
    }
    
    /**
     * <p>
     * Gets a shard iterator. A shard iterator expires five minutes after it
     * is returned to the requester.
     * </p>
     * <p>
     * A shard iterator specifies the position in the shard from which to
     * start reading data records sequentially. A shard iterator specifies
     * this position using the sequence number of a data record in a shard. A
     * sequence number is the identifier associated with every record
     * ingested in the Amazon Kinesis stream. The sequence number is assigned
     * when a record is put into the stream.
     * </p>
     * <p>
     * You must specify the shard iterator type. For example, you can set
     * the <code>ShardIteratorType</code> parameter to read exactly from the
     * position denoted by a specific sequence number by using the
     * <code>AT_SEQUENCE_NUMBER</code> shard iterator type, or right after
     * the sequence number by using the <code>AFTER_SEQUENCE_NUMBER</code>
     * shard iterator type, using sequence numbers returned by earlier calls
     * to PutRecord, PutRecords, GetRecords, or DescribeStream. You can
     * specify the shard iterator type <code>TRIM_HORIZON</code> in the
     * request to cause <code>ShardIterator</code> to point to the last
     * untrimmed record in the shard in the system, which is the oldest data
     * record in the shard. Or you can point to just after the most recent
     * record in the shard, by using the shard iterator type
     * <code>LATEST</code> , so that you always read the most recent data in
     * the shard.
     * </p>
     * <p>
     * When you repeatedly read from an Amazon Kinesis stream use a
     * GetShardIterator request to get the first shard iterator for use in
     * your first GetRecords request and then use the shard iterator returned
     * by the GetRecords request in <code>NextShardIterator</code> for
     * subsequent reads. A new shard iterator is returned by every GetRecords
     * request in <code>NextShardIterator</code> , which you use in the
     * <code>ShardIterator</code> parameter of the next GetRecords request.
     * </p>
     * <p>
     * If a GetShardIterator request is made too often, you receive a
     * <code>ProvisionedThroughputExceededException</code> . For more
     * information about throughput limits, see GetRecords.
     * </p>
     * <p>
     * If the shard is closed, the iterator can't return more data, and
     * GetShardIterator returns <code>null</code> for its
     * <code>ShardIterator</code> . A shard can be closed using SplitShard or
     * MergeShards.
     * </p>
     * <p>
     * GetShardIterator has a limit of 5 transactions per second per account
     * per open shard.
     * </p>
     * 
     * @param streamName The name of the stream.
     * @param shardId The shard ID of the shard to get the iterator for.
     * @param shardIteratorType Determines how the shard iterator is used to
     * start reading data records from the shard. <p>The following are the
     * valid shard iterator types: <ul> <li>AT_SEQUENCE_NUMBER - Start
     * reading exactly from the position denoted by a specific sequence
     * number.</li> <li>AFTER_SEQUENCE_NUMBER - Start reading right after the
     * position denoted by a specific sequence number.</li> <li>TRIM_HORIZON
     * - Start reading at the last untrimmed record in the shard in the
     * system, which is the oldest data record in the shard.</li> <li>LATEST
     * - Start reading just after the most recent record in the shard, so
     * that you always read the most recent data in the shard.</li> </ul>
     * 
     * @return The response from the GetShardIterator service method, as
     *         returned by AmazonKinesis.
     * 
     * @throws ProvisionedThroughputExceededException
     * @throws InvalidArgumentException
     * @throws ResourceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonKinesis indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetShardIteratorResult getShardIterator(String streamName, String shardId, String shardIteratorType)
             throws AmazonServiceException, AmazonClientException  {
        GetShardIteratorRequest getShardIteratorRequest = new GetShardIteratorRequest();
        getShardIteratorRequest.setStreamName(streamName);
        getShardIteratorRequest.setShardId(shardId);
        getShardIteratorRequest.setShardIteratorType(shardIteratorType);
        return getShardIterator(getShardIteratorRequest);
    }
    
    /**
     * <p>
     * Gets a shard iterator. A shard iterator expires five minutes after it
     * is returned to the requester.
     * </p>
     * <p>
     * A shard iterator specifies the position in the shard from which to
     * start reading data records sequentially. A shard iterator specifies
     * this position using the sequence number of a data record in a shard. A
     * sequence number is the identifier associated with every record
     * ingested in the Amazon Kinesis stream. The sequence number is assigned
     * when a record is put into the stream.
     * </p>
     * <p>
     * You must specify the shard iterator type. For example, you can set
     * the <code>ShardIteratorType</code> parameter to read exactly from the
     * position denoted by a specific sequence number by using the
     * <code>AT_SEQUENCE_NUMBER</code> shard iterator type, or right after
     * the sequence number by using the <code>AFTER_SEQUENCE_NUMBER</code>
     * shard iterator type, using sequence numbers returned by earlier calls
     * to PutRecord, PutRecords, GetRecords, or DescribeStream. You can
     * specify the shard iterator type <code>TRIM_HORIZON</code> in the
     * request to cause <code>ShardIterator</code> to point to the last
     * untrimmed record in the shard in the system, which is the oldest data
     * record in the shard. Or you can point to just after the most recent
     * record in the shard, by using the shard iterator type
     * <code>LATEST</code> , so that you always read the most recent data in
     * the shard.
     * </p>
     * <p>
     * When you repeatedly read from an Amazon Kinesis stream use a
     * GetShardIterator request to get the first shard iterator for use in
     * your first GetRecords request and then use the shard iterator returned
     * by the GetRecords request in <code>NextShardIterator</code> for
     * subsequent reads. A new shard iterator is returned by every GetRecords
     * request in <code>NextShardIterator</code> , which you use in the
     * <code>ShardIterator</code> parameter of the next GetRecords request.
     * </p>
     * <p>
     * If a GetShardIterator request is made too often, you receive a
     * <code>ProvisionedThroughputExceededException</code> . For more
     * information about throughput limits, see GetRecords.
     * </p>
     * <p>
     * If the shard is closed, the iterator can't return more data, and
     * GetShardIterator returns <code>null</code> for its
     * <code>ShardIterator</code> . A shard can be closed using SplitShard or
     * MergeShards.
     * </p>
     * <p>
     * GetShardIterator has a limit of 5 transactions per second per account
     * per open shard.
     * </p>
     * 
     * @param streamName The name of the stream.
     * @param shardId The shard ID of the shard to get the iterator for.
     * @param shardIteratorType Determines how the shard iterator is used to
     * start reading data records from the shard. <p>The following are the
     * valid shard iterator types: <ul> <li>AT_SEQUENCE_NUMBER - Start
     * reading exactly from the position denoted by a specific sequence
     * number.</li> <li>AFTER_SEQUENCE_NUMBER - Start reading right after the
     * position denoted by a specific sequence number.</li> <li>TRIM_HORIZON
     * - Start reading at the last untrimmed record in the shard in the
     * system, which is the oldest data record in the shard.</li> <li>LATEST
     * - Start reading just after the most recent record in the shard, so
     * that you always read the most recent data in the shard.</li> </ul>
     * @param startingSequenceNumber The sequence number of the data record
     * in the shard from which to start reading from.
     * 
     * @return The response from the GetShardIterator service method, as
     *         returned by AmazonKinesis.
     * 
     * @throws ProvisionedThroughputExceededException
     * @throws InvalidArgumentException
     * @throws ResourceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonKinesis indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetShardIteratorResult getShardIterator(String streamName, String shardId, String shardIteratorType, String startingSequenceNumber)
             throws AmazonServiceException, AmazonClientException  {
        GetShardIteratorRequest getShardIteratorRequest = new GetShardIteratorRequest();
        getShardIteratorRequest.setStreamName(streamName);
        getShardIteratorRequest.setShardId(shardId);
        getShardIteratorRequest.setShardIteratorType(shardIteratorType);
        getShardIteratorRequest.setStartingSequenceNumber(startingSequenceNumber);
        return getShardIterator(getShardIteratorRequest);
    }
    
    /**
     * <p>
     * Splits a shard into two new shards in the stream, to increase the
     * stream's capacity to ingest and transport data.
     * <code>SplitShard</code> is called when there is a need to increase the
     * overall capacity of stream because of an expected increase in the
     * volume of data records being ingested.
     * </p>
     * <p>
     * You can also use <code>SplitShard</code> when a shard appears to be
     * approaching its maximum utilization, for example, when the set of
     * producers sending data into the specific shard are suddenly sending
     * more than previously anticipated. You can also call
     * <code>SplitShard</code> to increase stream capacity, so that more
     * Amazon Kinesis applications can simultaneously read data from the
     * stream for real-time processing.
     * </p>
     * <p>
     * You must specify the shard to be split and the new hash key, which is
     * the position in the shard where the shard gets split in two. In many
     * cases, the new hash key might simply be the average of the beginning
     * and ending hash key, but it can be any hash key value in the range
     * being mapped into the shard. For more information about splitting
     * shards, see
     * <a href="http://docs.aws.amazon.com/kinesis/latest/dev/kinesis-using-sdk-java-resharding-split.html"> Split a Shard </a>
     * in the <i>Amazon Kinesis Developer Guide</i> .
     * </p>
     * <p>
     * You can use DescribeStream to determine the shard ID and hash key
     * values for the <code>ShardToSplit</code> and
     * <code>NewStartingHashKey</code> parameters that are specified in the
     * <code>SplitShard</code> request.
     * </p>
     * <p>
     * <code>SplitShard</code> is an asynchronous operation. Upon receiving
     * a <code>SplitShard</code> request, Amazon Kinesis immediately returns
     * a response and sets the stream status to <code>UPDATING</code> . After
     * the operation is completed, Amazon Kinesis sets the stream status to
     * <code>ACTIVE</code> . Read and write operations continue to work while
     * the stream is in the <code>UPDATING</code> state.
     * </p>
     * <p>
     * You can use <code>DescribeStream</code> to check the status of the
     * stream, which is returned in <code>StreamStatus</code> . If the stream
     * is in the <code>ACTIVE</code> state, you can call
     * <code>SplitShard</code> . If a stream is in <code>CREATING</code> or
     * <code>UPDATING</code> or <code>DELETING</code> states,
     * <code>DescribeStream</code> returns a
     * <code>ResourceInUseException</code> .
     * </p>
     * <p>
     * If the specified stream does not exist, <code>DescribeStream</code>
     * returns a <code>ResourceNotFoundException</code> . If you try to
     * create more shards than are authorized for your account, you receive a
     * <code>LimitExceededException</code> .
     * </p>
     * <p>
     * For the default shard limit for an AWS account, see
     * <a href="http://docs.aws.amazon.com/kinesis/latest/dev/service-sizes-and-limits.html"> Amazon Kinesis Limits </a> . If you need to increase this limit, <a href="http://docs.aws.amazon.com/general/latest/gr/aws_service_limits.html"> contact AWS Support </a>
     * .
     * </p>
     * <p>
     * If you try to operate on too many streams in parallel using
     * CreateStream, DeleteStream, MergeShards or SplitShard, you receive a
     * <code>LimitExceededException</code> .
     * </p>
     * <p>
     * <code>SplitShard</code> has limit of 5 transactions per second per
     * account.
     * </p>
     * 
     * @param streamName The name of the stream for the shard split.
     * @param shardToSplit The shard ID of the shard to split.
     * @param newStartingHashKey A hash key value for the starting hash key
     * of one of the child shards created by the split. The hash key range
     * for a given shard constitutes a set of ordered contiguous positive
     * integers. The value for <code>NewStartingHashKey</code> must be in the
     * range of hash keys being mapped into the shard. The
     * <code>NewStartingHashKey</code> hash key value and all higher hash key
     * values in hash key range are distributed to one of the child shards.
     * All the lower hash key values in the range are distributed to the
     * other child shard.
     * 
     * @return The response from the SplitShard service method, as returned
     *         by AmazonKinesis.
     * 
     * @throws LimitExceededException
     * @throws ResourceInUseException
     * @throws InvalidArgumentException
     * @throws ResourceNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonKinesis indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void splitShard(String streamName, String shardToSplit, String newStartingHashKey)
             throws AmazonServiceException, AmazonClientException  {
        SplitShardRequest splitShardRequest = new SplitShardRequest();
        splitShardRequest.setStreamName(streamName);
        splitShardRequest.setShardToSplit(shardToSplit);
        splitShardRequest.setNewStartingHashKey(newStartingHashKey);
        splitShard(splitShardRequest);
    }
    
    /**
     * <p>
     * Lists your streams.
     * </p>
     * <p>
     * The number of streams may be too large to return from a single call
     * to <code>ListStreams</code> . You can limit the number of returned
     * streams using the <code>Limit</code> parameter. If you do not specify
     * a value for the <code>Limit</code> parameter, Amazon Kinesis uses the
     * default limit, which is currently 10.
     * </p>
     * <p>
     * You can detect if there are more streams available to list by using
     * the <code>HasMoreStreams</code> flag from the returned output. If
     * there are more streams available, you can request more streams by
     * using the name of the last stream returned by the
     * <code>ListStreams</code> request in the
     * <code>ExclusiveStartStreamName</code> parameter in a subsequent
     * request to <code>ListStreams</code> . The group of stream names
     * returned by the subsequent request is then added to the list. You can
     * continue this process until all the stream names have been collected
     * in the list.
     * </p>
     * <p>
     * ListStreams has a limit of 5 transactions per second per account.
     * </p>
     * 
     * @param exclusiveStartStreamName The name of the stream to start the
     * list with.
     * 
     * @return The response from the ListStreams service method, as returned
     *         by AmazonKinesis.
     * 
     * @throws LimitExceededException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonKinesis indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListStreamsResult listStreams(String exclusiveStartStreamName)
             throws AmazonServiceException, AmazonClientException  {
        ListStreamsRequest listStreamsRequest = new ListStreamsRequest();
        listStreamsRequest.setExclusiveStartStreamName(exclusiveStartStreamName);
        return listStreams(listStreamsRequest);
    }
    
    /**
     * <p>
     * Lists your streams.
     * </p>
     * <p>
     * The number of streams may be too large to return from a single call
     * to <code>ListStreams</code> . You can limit the number of returned
     * streams using the <code>Limit</code> parameter. If you do not specify
     * a value for the <code>Limit</code> parameter, Amazon Kinesis uses the
     * default limit, which is currently 10.
     * </p>
     * <p>
     * You can detect if there are more streams available to list by using
     * the <code>HasMoreStreams</code> flag from the returned output. If
     * there are more streams available, you can request more streams by
     * using the name of the last stream returned by the
     * <code>ListStreams</code> request in the
     * <code>ExclusiveStartStreamName</code> parameter in a subsequent
     * request to <code>ListStreams</code> . The group of stream names
     * returned by the subsequent request is then added to the list. You can
     * continue this process until all the stream names have been collected
     * in the list.
     * </p>
     * <p>
     * ListStreams has a limit of 5 transactions per second per account.
     * </p>
     * 
     * @param limit The maximum number of streams to list.
     * @param exclusiveStartStreamName The name of the stream to start the
     * list with.
     * 
     * @return The response from the ListStreams service method, as returned
     *         by AmazonKinesis.
     * 
     * @throws LimitExceededException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonKinesis indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListStreamsResult listStreams(Integer limit, String exclusiveStartStreamName)
             throws AmazonServiceException, AmazonClientException  {
        ListStreamsRequest listStreamsRequest = new ListStreamsRequest();
        listStreamsRequest.setLimit(limit);
        listStreamsRequest.setExclusiveStartStreamName(exclusiveStartStreamName);
        return listStreams(listStreamsRequest);
    }

    @Override
    public void setEndpoint(String endpoint) {
        super.setEndpoint(endpoint);
    }

    @Override
    public void setEndpoint(String endpoint, String serviceName, String regionId) throws IllegalArgumentException {
        super.setEndpoint(endpoint, serviceName, regionId);
    }

    /**
     * Returns additional metadata for a previously executed successful, request, typically used for
     * debugging issues where a service isn't acting as expected.  This data isn't considered part
     * of the result data returned by an operation, so it's available through this separate,
     * diagnostic interface.
     * <p>
     * Response metadata is only cached for a limited period of time, so if you need to access
     * this extra diagnostic information for an executed request, you should use this method
     * to retrieve it as soon as possible after executing the request.
     *
     * @param request
     *            The originally executed request
     *
     * @return The response metadata for the specified request, or null if none
     *         is available.
     */
    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request) {
        return client.getResponseMetadataForRequest(request);
    }

    private <X, Y extends AmazonWebServiceRequest> Response<X> invoke(Request<Y> request,
            HttpResponseHandler<AmazonWebServiceResponse<X>> responseHandler,
            ExecutionContext executionContext) {
        request.setEndpoint(endpoint);
        request.setTimeOffset(timeOffset);

        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        AWSCredentials credentials;
        awsRequestMetrics.startEvent(Field.CredentialsRequestTime);
        try {
            credentials = awsCredentialsProvider.getCredentials();
        } finally {
            awsRequestMetrics.endEvent(Field.CredentialsRequestTime);
        }

        AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
        if (originalRequest != null && originalRequest.getRequestCredentials() != null) {
            credentials = originalRequest.getRequestCredentials();
        }

        executionContext.setCredentials(credentials);
        JsonErrorResponseHandler errorResponseHandler = new JsonErrorResponseHandler(jsonErrorUnmarshallers);
        Response<X> result = client.execute(request, responseHandler,
                errorResponseHandler, executionContext);
        return result;
    }
}
        