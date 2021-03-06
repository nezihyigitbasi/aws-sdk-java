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
package com.amazonaws.services.cloudtrail;

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

import com.amazonaws.services.cloudtrail.model.*;
import com.amazonaws.services.cloudtrail.model.transform.*;

/**
 * Client for accessing AWSCloudTrail.  All service calls made
 * using this client are blocking, and will not return until the service call
 * completes.
 * <p>
 * AWS CloudTrail <p>
 * This is the CloudTrail API Reference. It provides descriptions of
 * actions, data types, common parameters, and common errors for
 * CloudTrail.
 * </p>
 * <p>
 * CloudTrail is a web service that records AWS API calls for your AWS
 * account and delivers log files to an Amazon S3 bucket. The recorded
 * information includes the identity of the user, the start time of the
 * AWS API call, the source IP address, the request parameters, and the
 * response elements returned by the service.
 * </p>
 * <p>
 * <b>NOTE:</b> As an alternative to using the API, you can use one of
 * the AWS SDKs, which consist of libraries and sample code for various
 * programming languages and platforms (Java, Ruby, .NET, iOS, Android,
 * etc.). The SDKs provide a convenient way to create programmatic access
 * to AWSCloudTrail. For example, the SDKs take care of cryptographically
 * signing requests, managing errors, and retrying requests
 * automatically. For information about the AWS SDKs, including how to
 * download and install them, see the Tools for Amazon Web Services page.
 * </p>
 * <p>
 * See the CloudTrail User Guide for information about the data that is
 * included with each AWS API call listed in the log files.
 * </p>
 */
public class AWSCloudTrailClient extends AmazonWebServiceClient implements AWSCloudTrail {

    /** Provider for AWS credentials. */
    private AWSCredentialsProvider awsCredentialsProvider;

    private static final Log log = LogFactory.getLog(AWSCloudTrail.class);

    /**
     * List of exception unmarshallers for all AWSCloudTrail exceptions.
     */
    protected List<JsonErrorUnmarshaller> jsonErrorUnmarshallers;

    /**
     * Constructs a new client to invoke service methods on
     * AWSCloudTrail.  A credentials provider chain will be used
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
    public AWSCloudTrailClient() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AWSCloudTrail.  A credentials provider chain will be used
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
     *                       client connects to AWSCloudTrail
     *                       (ex: proxy settings, retry counts, etc.).
     *
     * @see DefaultAWSCredentialsProviderChain
     */
    public AWSCloudTrailClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    /**
     * Constructs a new client to invoke service methods on
     * AWSCloudTrail using the specified AWS account credentials.
     * 
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentials The AWS credentials (access key ID and secret key) to use
     *                       when authenticating with AWS services.
     */
    public AWSCloudTrailClient(AWSCredentials awsCredentials) {
        this(awsCredentials, new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AWSCloudTrail using the specified AWS account credentials
     * and client configuration options.
     * 
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentials The AWS credentials (access key ID and secret key) to use
     *                       when authenticating with AWS services.
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AWSCloudTrail
     *                       (ex: proxy settings, retry counts, etc.).
     */
    public AWSCloudTrailClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration) {
        super(adjustClientConfiguration(clientConfiguration));
        
        this.awsCredentialsProvider = new StaticCredentialsProvider(awsCredentials);
        
        init();
    }

    /**
     * Constructs a new client to invoke service methods on
     * AWSCloudTrail using the specified AWS account credentials provider.
     * 
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     */
    public AWSCloudTrailClient(AWSCredentialsProvider awsCredentialsProvider) {
        this(awsCredentialsProvider, new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AWSCloudTrail using the specified AWS account credentials
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
     *                       client connects to AWSCloudTrail
     *                       (ex: proxy settings, retry counts, etc.).
     */
    public AWSCloudTrailClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(awsCredentialsProvider, clientConfiguration, null);
    }

    /**
     * Constructs a new client to invoke service methods on
     * AWSCloudTrail using the specified AWS account credentials
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
     *                       client connects to AWSCloudTrail
     *                       (ex: proxy settings, retry counts, etc.).
     * @param requestMetricCollector optional request metric collector
     */
    public AWSCloudTrailClient(AWSCredentialsProvider awsCredentialsProvider,
            ClientConfiguration clientConfiguration,
            RequestMetricCollector requestMetricCollector) {
        super(adjustClientConfiguration(clientConfiguration), requestMetricCollector);
        
        this.awsCredentialsProvider = awsCredentialsProvider;
        
        init();
    }

    private void init() {
        jsonErrorUnmarshallers = new ArrayList<JsonErrorUnmarshaller>();
        jsonErrorUnmarshallers.add(new TrailAlreadyExistsExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new KmsKeyDisabledExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new TrailNotProvidedExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new UnsupportedOperationExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new KmsKeyNotFoundExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new InvalidMaxResultsExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new InvalidS3PrefixExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new InvalidTokenExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new InsufficientSnsTopicPolicyExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new TrailNotFoundExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new TagsLimitExceededExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new InvalidTrailNameExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new InsufficientEncryptionPolicyExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new InvalidCloudWatchLogsLogGroupArnExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new ResourceTypeNotSupportedExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new InvalidNextTokenExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new InvalidLookupAttributesExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new InsufficientS3BucketPolicyExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new InvalidTagParameterExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new InvalidS3BucketNameExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new InvalidSnsTopicNameExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new CloudTrailARNInvalidExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new MaximumNumberOfTrailsExceededExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new CloudWatchLogsDeliveryUnavailableExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new OperationNotPermittedExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new InvalidTimeRangeExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new ResourceNotFoundExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new S3BucketDoesNotExistExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new InvalidCloudWatchLogsRoleArnExceptionUnmarshaller());
        jsonErrorUnmarshallers.add(new InvalidKmsKeyIdExceptionUnmarshaller());
        
        jsonErrorUnmarshallers.add(new JsonErrorUnmarshaller());
        
        // calling this.setEndPoint(...) will also modify the signer accordingly
        this.setEndpoint("cloudtrail.us-east-1.amazonaws.com");
        
        HandlerChainFactory chainFactory = new HandlerChainFactory();
        requestHandler2s.addAll(chainFactory.newRequestHandlerChain(
                "/com/amazonaws/services/cloudtrail/request.handlers"));
        requestHandler2s.addAll(chainFactory.newRequestHandler2Chain(
                "/com/amazonaws/services/cloudtrail/request.handler2s"));
    }

    private static ClientConfiguration adjustClientConfiguration(ClientConfiguration orig) {
        ClientConfiguration config = orig;
        
        return config;
    }

    /**
     * <p>
     * Lists the tags for the trail in the current region.
     * </p>
     *
     * @param listTagsRequest Container for the necessary parameters to
     *           execute the ListTags service method on AWSCloudTrail.
     * 
     * @return The response from the ListTags service method, as returned by
     *         AWSCloudTrail.
     * 
     * @throws ResourceTypeNotSupportedException
     * @throws ResourceNotFoundException
     * @throws UnsupportedOperationException
     * @throws CloudTrailARNInvalidException
     * @throws InvalidTrailNameException
     * @throws InvalidTokenException
     * @throws OperationNotPermittedException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AWSCloudTrail indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListTagsResult listTags(ListTagsRequest listTagsRequest) {
        ExecutionContext executionContext = createExecutionContext(listTagsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListTagsRequest> request = null;
        Response<ListTagsResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListTagsRequestMarshaller().marshall(super.beforeMarshalling(listTagsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            Unmarshaller<ListTagsResult, JsonUnmarshallerContext> unmarshaller =
                new ListTagsResultJsonUnmarshaller();
            JsonResponseHandler<ListTagsResult> responseHandler =
                new JsonResponseHandler<ListTagsResult>(unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Returns a JSON-formatted list of information about the specified
     * trail. Fields include information on delivery errors, Amazon SNS and
     * Amazon S3 errors, and start and stop logging times for each trail.
     * This operation returns trail status from a single region. To return
     * trail status from all regions, you must call the operation on each
     * region.
     * </p>
     *
     * @param getTrailStatusRequest Container for the necessary parameters to
     *           execute the GetTrailStatus service method on AWSCloudTrail.
     * 
     * @return The response from the GetTrailStatus service method, as
     *         returned by AWSCloudTrail.
     * 
     * @throws InvalidTrailNameException
     * @throws TrailNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AWSCloudTrail indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetTrailStatusResult getTrailStatus(GetTrailStatusRequest getTrailStatusRequest) {
        ExecutionContext executionContext = createExecutionContext(getTrailStatusRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetTrailStatusRequest> request = null;
        Response<GetTrailStatusResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetTrailStatusRequestMarshaller().marshall(super.beforeMarshalling(getTrailStatusRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            Unmarshaller<GetTrailStatusResult, JsonUnmarshallerContext> unmarshaller =
                new GetTrailStatusResultJsonUnmarshaller();
            JsonResponseHandler<GetTrailStatusResult> responseHandler =
                new JsonResponseHandler<GetTrailStatusResult>(unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Removes the specified tags from a trail.
     * </p>
     *
     * @param removeTagsRequest Container for the necessary parameters to
     *           execute the RemoveTags service method on AWSCloudTrail.
     * 
     * @return The response from the RemoveTags service method, as returned
     *         by AWSCloudTrail.
     * 
     * @throws ResourceTypeNotSupportedException
     * @throws ResourceNotFoundException
     * @throws UnsupportedOperationException
     * @throws CloudTrailARNInvalidException
     * @throws InvalidTrailNameException
     * @throws InvalidTagParameterException
     * @throws OperationNotPermittedException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AWSCloudTrail indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public RemoveTagsResult removeTags(RemoveTagsRequest removeTagsRequest) {
        ExecutionContext executionContext = createExecutionContext(removeTagsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<RemoveTagsRequest> request = null;
        Response<RemoveTagsResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new RemoveTagsRequestMarshaller().marshall(super.beforeMarshalling(removeTagsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            Unmarshaller<RemoveTagsResult, JsonUnmarshallerContext> unmarshaller =
                new RemoveTagsResultJsonUnmarshaller();
            JsonResponseHandler<RemoveTagsResult> responseHandler =
                new JsonResponseHandler<RemoveTagsResult>(unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Deletes a trail. This operation must be called from the region in
     * which the trail was created.
     * </p>
     *
     * @param deleteTrailRequest Container for the necessary parameters to
     *           execute the DeleteTrail service method on AWSCloudTrail.
     * 
     * @return The response from the DeleteTrail service method, as returned
     *         by AWSCloudTrail.
     * 
     * @throws InvalidTrailNameException
     * @throws TrailNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AWSCloudTrail indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DeleteTrailResult deleteTrail(DeleteTrailRequest deleteTrailRequest) {
        ExecutionContext executionContext = createExecutionContext(deleteTrailRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteTrailRequest> request = null;
        Response<DeleteTrailResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteTrailRequestMarshaller().marshall(super.beforeMarshalling(deleteTrailRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            Unmarshaller<DeleteTrailResult, JsonUnmarshallerContext> unmarshaller =
                new DeleteTrailResultJsonUnmarshaller();
            JsonResponseHandler<DeleteTrailResult> responseHandler =
                new JsonResponseHandler<DeleteTrailResult>(unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Looks up API activity events captured by CloudTrail that create,
     * update, or delete resources in your account. Events for a region can
     * be looked up for the times in which you had CloudTrail turned on in
     * that region during the last seven days. Lookup supports five different
     * attributes: time range (defined by a start time and end time), user
     * name, event name, resource type, and resource name. All attributes are
     * optional. The maximum number of attributes that can be specified in
     * any one lookup request are time range and one other attribute. The
     * default number of results returned is 10, with a maximum of 50
     * possible. The response includes a token that you can use to get the
     * next page of results.
     * </p>
     * <p>
     * <b>IMPORTANT:</b>The rate of lookup requests is limited to one per
     * second per account. If this limit is exceeded, a throttling error
     * occurs.
     * </p>
     * <p>
     * <b>IMPORTANT:</b>Events that occurred during the selected time range
     * will not be available for lookup if CloudTrail logging was not enabled
     * when the events occurred.
     * </p>
     *
     * @param lookupEventsRequest Container for the necessary parameters to
     *           execute the LookupEvents service method on AWSCloudTrail.
     * 
     * @return The response from the LookupEvents service method, as returned
     *         by AWSCloudTrail.
     * 
     * @throws InvalidMaxResultsException
     * @throws InvalidNextTokenException
     * @throws InvalidLookupAttributesException
     * @throws InvalidTimeRangeException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AWSCloudTrail indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public LookupEventsResult lookupEvents(LookupEventsRequest lookupEventsRequest) {
        ExecutionContext executionContext = createExecutionContext(lookupEventsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<LookupEventsRequest> request = null;
        Response<LookupEventsResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new LookupEventsRequestMarshaller().marshall(super.beforeMarshalling(lookupEventsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            Unmarshaller<LookupEventsResult, JsonUnmarshallerContext> unmarshaller =
                new LookupEventsResultJsonUnmarshaller();
            JsonResponseHandler<LookupEventsResult> responseHandler =
                new JsonResponseHandler<LookupEventsResult>(unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Creates a trail that specifies the settings for delivery of log data
     * to an Amazon S3 bucket.
     * </p>
     *
     * @param createTrailRequest Container for the necessary parameters to
     *           execute the CreateTrail service method on AWSCloudTrail.
     * 
     * @return The response from the CreateTrail service method, as returned
     *         by AWSCloudTrail.
     * 
     * @throws InsufficientEncryptionPolicyException
     * @throws InvalidTrailNameException
     * @throws InvalidCloudWatchLogsLogGroupArnException
     * @throws TrailAlreadyExistsException
     * @throws InvalidS3BucketNameException
     * @throws KmsKeyDisabledException
     * @throws TrailNotProvidedException
     * @throws InvalidSnsTopicNameException
     * @throws S3BucketDoesNotExistException
     * @throws UnsupportedOperationException
     * @throws KmsKeyNotFoundException
     * @throws InvalidS3PrefixException
     * @throws InvalidCloudWatchLogsRoleArnException
     * @throws MaximumNumberOfTrailsExceededException
     * @throws InvalidKmsKeyIdException
     * @throws InsufficientSnsTopicPolicyException
     * @throws CloudWatchLogsDeliveryUnavailableException
     * @throws OperationNotPermittedException
     * @throws InsufficientS3BucketPolicyException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AWSCloudTrail indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public CreateTrailResult createTrail(CreateTrailRequest createTrailRequest) {
        ExecutionContext executionContext = createExecutionContext(createTrailRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateTrailRequest> request = null;
        Response<CreateTrailResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateTrailRequestMarshaller().marshall(super.beforeMarshalling(createTrailRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            Unmarshaller<CreateTrailResult, JsonUnmarshallerContext> unmarshaller =
                new CreateTrailResultJsonUnmarshaller();
            JsonResponseHandler<CreateTrailResult> responseHandler =
                new JsonResponseHandler<CreateTrailResult>(unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Updates the settings that specify delivery of log files. Changes to a
     * trail do not require stopping the CloudTrail service. Use this action
     * to designate an existing bucket for log delivery. If the existing
     * bucket has previously been a target for CloudTrail log files, an IAM
     * policy exists for the bucket.
     * </p>
     *
     * @param updateTrailRequest Container for the necessary parameters to
     *           execute the UpdateTrail service method on AWSCloudTrail.
     * 
     * @return The response from the UpdateTrail service method, as returned
     *         by AWSCloudTrail.
     * 
     * @throws InsufficientEncryptionPolicyException
     * @throws InvalidTrailNameException
     * @throws InvalidCloudWatchLogsLogGroupArnException
     * @throws InvalidS3BucketNameException
     * @throws KmsKeyDisabledException
     * @throws TrailNotProvidedException
     * @throws InvalidSnsTopicNameException
     * @throws S3BucketDoesNotExistException
     * @throws UnsupportedOperationException
     * @throws KmsKeyNotFoundException
     * @throws InvalidCloudWatchLogsRoleArnException
     * @throws InvalidS3PrefixException
     * @throws InvalidKmsKeyIdException
     * @throws InsufficientSnsTopicPolicyException
     * @throws CloudWatchLogsDeliveryUnavailableException
     * @throws OperationNotPermittedException
     * @throws TrailNotFoundException
     * @throws InsufficientS3BucketPolicyException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AWSCloudTrail indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public UpdateTrailResult updateTrail(UpdateTrailRequest updateTrailRequest) {
        ExecutionContext executionContext = createExecutionContext(updateTrailRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UpdateTrailRequest> request = null;
        Response<UpdateTrailResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UpdateTrailRequestMarshaller().marshall(super.beforeMarshalling(updateTrailRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            Unmarshaller<UpdateTrailResult, JsonUnmarshallerContext> unmarshaller =
                new UpdateTrailResultJsonUnmarshaller();
            JsonResponseHandler<UpdateTrailResult> responseHandler =
                new JsonResponseHandler<UpdateTrailResult>(unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Suspends the recording of AWS API calls and log file delivery for the
     * specified trail. Under most circumstances, there is no need to use
     * this action. You can update a trail without stopping it first. This
     * action is the only way to stop recording.
     * </p>
     *
     * @param stopLoggingRequest Container for the necessary parameters to
     *           execute the StopLogging service method on AWSCloudTrail.
     * 
     * @return The response from the StopLogging service method, as returned
     *         by AWSCloudTrail.
     * 
     * @throws InvalidTrailNameException
     * @throws TrailNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AWSCloudTrail indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public StopLoggingResult stopLogging(StopLoggingRequest stopLoggingRequest) {
        ExecutionContext executionContext = createExecutionContext(stopLoggingRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<StopLoggingRequest> request = null;
        Response<StopLoggingResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new StopLoggingRequestMarshaller().marshall(super.beforeMarshalling(stopLoggingRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            Unmarshaller<StopLoggingResult, JsonUnmarshallerContext> unmarshaller =
                new StopLoggingResultJsonUnmarshaller();
            JsonResponseHandler<StopLoggingResult> responseHandler =
                new JsonResponseHandler<StopLoggingResult>(unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Retrieves settings for the trail associated with the current region
     * for your account.
     * </p>
     *
     * @param describeTrailsRequest Container for the necessary parameters to
     *           execute the DescribeTrails service method on AWSCloudTrail.
     * 
     * @return The response from the DescribeTrails service method, as
     *         returned by AWSCloudTrail.
     * 
     * @throws UnsupportedOperationException
     * @throws OperationNotPermittedException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AWSCloudTrail indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeTrailsResult describeTrails(DescribeTrailsRequest describeTrailsRequest) {
        ExecutionContext executionContext = createExecutionContext(describeTrailsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeTrailsRequest> request = null;
        Response<DescribeTrailsResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeTrailsRequestMarshaller().marshall(super.beforeMarshalling(describeTrailsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            Unmarshaller<DescribeTrailsResult, JsonUnmarshallerContext> unmarshaller =
                new DescribeTrailsResultJsonUnmarshaller();
            JsonResponseHandler<DescribeTrailsResult> responseHandler =
                new JsonResponseHandler<DescribeTrailsResult>(unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Returns all public keys whose private keys were used to sign the
     * digest files within the specified time range. The public key is needed
     * to validate digest files that were signed with its corresponding
     * private key.
     * </p>
     * <p>
     * <b>NOTE:</b>CloudTrail uses different private/public key pairs per
     * region. Each digest file is signed with a private key unique to its
     * region. Therefore, when you validate a digest file from a particular
     * region, you must look in the same region for its corresponding public
     * key.
     * </p>
     *
     * @param listPublicKeysRequest Container for the necessary parameters to
     *           execute the ListPublicKeys service method on AWSCloudTrail.
     * 
     * @return The response from the ListPublicKeys service method, as
     *         returned by AWSCloudTrail.
     * 
     * @throws UnsupportedOperationException
     * @throws InvalidTokenException
     * @throws OperationNotPermittedException
     * @throws InvalidTimeRangeException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AWSCloudTrail indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListPublicKeysResult listPublicKeys(ListPublicKeysRequest listPublicKeysRequest) {
        ExecutionContext executionContext = createExecutionContext(listPublicKeysRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListPublicKeysRequest> request = null;
        Response<ListPublicKeysResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListPublicKeysRequestMarshaller().marshall(super.beforeMarshalling(listPublicKeysRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            Unmarshaller<ListPublicKeysResult, JsonUnmarshallerContext> unmarshaller =
                new ListPublicKeysResultJsonUnmarshaller();
            JsonResponseHandler<ListPublicKeysResult> responseHandler =
                new JsonResponseHandler<ListPublicKeysResult>(unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Adds one or more tags to a trail, up to a limit of 10. Tags must be
     * unique per trail. Overwrites an existing tag's value when a new value
     * is specified for an existing tag key. If you specify a key without a
     * value, the tag will be created with the specified key and a value of
     * null.
     * </p>
     *
     * @param addTagsRequest Container for the necessary parameters to
     *           execute the AddTags service method on AWSCloudTrail.
     * 
     * @return The response from the AddTags service method, as returned by
     *         AWSCloudTrail.
     * 
     * @throws ResourceTypeNotSupportedException
     * @throws TagsLimitExceededException
     * @throws ResourceNotFoundException
     * @throws UnsupportedOperationException
     * @throws CloudTrailARNInvalidException
     * @throws InvalidTrailNameException
     * @throws InvalidTagParameterException
     * @throws OperationNotPermittedException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AWSCloudTrail indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public AddTagsResult addTags(AddTagsRequest addTagsRequest) {
        ExecutionContext executionContext = createExecutionContext(addTagsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AddTagsRequest> request = null;
        Response<AddTagsResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AddTagsRequestMarshaller().marshall(super.beforeMarshalling(addTagsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            Unmarshaller<AddTagsResult, JsonUnmarshallerContext> unmarshaller =
                new AddTagsResultJsonUnmarshaller();
            JsonResponseHandler<AddTagsResult> responseHandler =
                new JsonResponseHandler<AddTagsResult>(unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Starts the recording of AWS API calls and log file delivery for a
     * trail.
     * </p>
     *
     * @param startLoggingRequest Container for the necessary parameters to
     *           execute the StartLogging service method on AWSCloudTrail.
     * 
     * @return The response from the StartLogging service method, as returned
     *         by AWSCloudTrail.
     * 
     * @throws InvalidTrailNameException
     * @throws TrailNotFoundException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AWSCloudTrail indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public StartLoggingResult startLogging(StartLoggingRequest startLoggingRequest) {
        ExecutionContext executionContext = createExecutionContext(startLoggingRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<StartLoggingRequest> request = null;
        Response<StartLoggingResult> response = null;
        
        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new StartLoggingRequestMarshaller().marshall(super.beforeMarshalling(startLoggingRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            Unmarshaller<StartLoggingResult, JsonUnmarshallerContext> unmarshaller =
                new StartLoggingResultJsonUnmarshaller();
            JsonResponseHandler<StartLoggingResult> responseHandler =
                new JsonResponseHandler<StartLoggingResult>(unmarshaller);

            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();
        } finally {
            
            endClientExecution(awsRequestMetrics, request, response, LOGGING_AWS_REQUEST_METRIC);
        }
    }

    /**
     * <p>
     * Looks up API activity events captured by CloudTrail that create,
     * update, or delete resources in your account. Events for a region can
     * be looked up for the times in which you had CloudTrail turned on in
     * that region during the last seven days. Lookup supports five different
     * attributes: time range (defined by a start time and end time), user
     * name, event name, resource type, and resource name. All attributes are
     * optional. The maximum number of attributes that can be specified in
     * any one lookup request are time range and one other attribute. The
     * default number of results returned is 10, with a maximum of 50
     * possible. The response includes a token that you can use to get the
     * next page of results.
     * </p>
     * <p>
     * <b>IMPORTANT:</b>The rate of lookup requests is limited to one per
     * second per account. If this limit is exceeded, a throttling error
     * occurs.
     * </p>
     * <p>
     * <b>IMPORTANT:</b>Events that occurred during the selected time range
     * will not be available for lookup if CloudTrail logging was not enabled
     * when the events occurred.
     * </p>
     * 
     * @return The response from the LookupEvents service method, as returned
     *         by AWSCloudTrail.
     * 
     * @throws InvalidMaxResultsException
     * @throws InvalidNextTokenException
     * @throws InvalidLookupAttributesException
     * @throws InvalidTimeRangeException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AWSCloudTrail indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public LookupEventsResult lookupEvents() throws AmazonServiceException, AmazonClientException {
        return lookupEvents(new LookupEventsRequest());
    }
    
    /**
     * <p>
     * Retrieves settings for the trail associated with the current region
     * for your account.
     * </p>
     * 
     * @return The response from the DescribeTrails service method, as
     *         returned by AWSCloudTrail.
     * 
     * @throws UnsupportedOperationException
     * @throws OperationNotPermittedException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AWSCloudTrail indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeTrailsResult describeTrails() throws AmazonServiceException, AmazonClientException {
        return describeTrails(new DescribeTrailsRequest());
    }
    
    /**
     * <p>
     * Returns all public keys whose private keys were used to sign the
     * digest files within the specified time range. The public key is needed
     * to validate digest files that were signed with its corresponding
     * private key.
     * </p>
     * <p>
     * <b>NOTE:</b>CloudTrail uses different private/public key pairs per
     * region. Each digest file is signed with a private key unique to its
     * region. Therefore, when you validate a digest file from a particular
     * region, you must look in the same region for its corresponding public
     * key.
     * </p>
     * 
     * @return The response from the ListPublicKeys service method, as
     *         returned by AWSCloudTrail.
     * 
     * @throws UnsupportedOperationException
     * @throws InvalidTokenException
     * @throws OperationNotPermittedException
     * @throws InvalidTimeRangeException
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AWSCloudTrail indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ListPublicKeysResult listPublicKeys() throws AmazonServiceException, AmazonClientException {
        return listPublicKeys(new ListPublicKeysRequest());
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
        