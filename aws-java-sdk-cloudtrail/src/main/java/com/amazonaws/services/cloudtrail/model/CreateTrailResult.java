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
package com.amazonaws.services.cloudtrail.model;

import java.io.Serializable;

/**
 * <p>
 * Returns the objects or data listed below if successful. Otherwise,
 * returns an error.
 * </p>
 */
public class CreateTrailResult implements Serializable, Cloneable {

    /**
     * Specifies the name of the trail.
     */
    private String name;

    /**
     * Specifies the name of the Amazon S3 bucket designated for publishing
     * log files.
     */
    private String s3BucketName;

    /**
     * Specifies the Amazon S3 key prefix that comes after the name of the
     * bucket you have designated for log file delivery. For more
     * information, see <a
     * href="http://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-find-log-files.html">Finding
     * Your CloudTrail Log Files</a>.
     */
    private String s3KeyPrefix;

    /**
     * Specifies the name of the Amazon SNS topic defined for notification of
     * log file delivery.
     */
    private String snsTopicName;

    /**
     * Specifies whether the trail is publishing events from global services
     * such as IAM to the log files.
     */
    private Boolean includeGlobalServiceEvents;

    /**
     * Specifies the ARN of the trail that was created.
     */
    private String trailARN;

    /**
     * Specifies whether log file integrity validation is enabled.
     */
    private Boolean logFileValidationEnabled;

    /**
     * Specifies the Amazon Resource Name (ARN) of the log group to which
     * CloudTrail logs will be delivered.
     */
    private String cloudWatchLogsLogGroupArn;

    /**
     * Specifies the role for the CloudWatch Logs endpoint to assume to write
     * to a user's log group.
     */
    private String cloudWatchLogsRoleArn;

    /**
     * Specifies the KMS key ID that encrypts the logs delivered by
     * CloudTrail. The value is a fully specified ARN to a KMS key in the
     * format:
     * <code>arn:aws:kms:us-east-1:123456789012:key/12345678-1234-1234-1234-123456789012</code>
     */
    private String kmsKeyId;

    /**
     * Specifies the name of the trail.
     *
     * @return Specifies the name of the trail.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Specifies the name of the trail.
     *
     * @param name Specifies the name of the trail.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Specifies the name of the trail.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param name Specifies the name of the trail.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public CreateTrailResult withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Specifies the name of the Amazon S3 bucket designated for publishing
     * log files.
     *
     * @return Specifies the name of the Amazon S3 bucket designated for publishing
     *         log files.
     */
    public String getS3BucketName() {
        return s3BucketName;
    }
    
    /**
     * Specifies the name of the Amazon S3 bucket designated for publishing
     * log files.
     *
     * @param s3BucketName Specifies the name of the Amazon S3 bucket designated for publishing
     *         log files.
     */
    public void setS3BucketName(String s3BucketName) {
        this.s3BucketName = s3BucketName;
    }
    
    /**
     * Specifies the name of the Amazon S3 bucket designated for publishing
     * log files.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param s3BucketName Specifies the name of the Amazon S3 bucket designated for publishing
     *         log files.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public CreateTrailResult withS3BucketName(String s3BucketName) {
        this.s3BucketName = s3BucketName;
        return this;
    }

    /**
     * Specifies the Amazon S3 key prefix that comes after the name of the
     * bucket you have designated for log file delivery. For more
     * information, see <a
     * href="http://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-find-log-files.html">Finding
     * Your CloudTrail Log Files</a>.
     *
     * @return Specifies the Amazon S3 key prefix that comes after the name of the
     *         bucket you have designated for log file delivery. For more
     *         information, see <a
     *         href="http://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-find-log-files.html">Finding
     *         Your CloudTrail Log Files</a>.
     */
    public String getS3KeyPrefix() {
        return s3KeyPrefix;
    }
    
    /**
     * Specifies the Amazon S3 key prefix that comes after the name of the
     * bucket you have designated for log file delivery. For more
     * information, see <a
     * href="http://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-find-log-files.html">Finding
     * Your CloudTrail Log Files</a>.
     *
     * @param s3KeyPrefix Specifies the Amazon S3 key prefix that comes after the name of the
     *         bucket you have designated for log file delivery. For more
     *         information, see <a
     *         href="http://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-find-log-files.html">Finding
     *         Your CloudTrail Log Files</a>.
     */
    public void setS3KeyPrefix(String s3KeyPrefix) {
        this.s3KeyPrefix = s3KeyPrefix;
    }
    
    /**
     * Specifies the Amazon S3 key prefix that comes after the name of the
     * bucket you have designated for log file delivery. For more
     * information, see <a
     * href="http://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-find-log-files.html">Finding
     * Your CloudTrail Log Files</a>.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param s3KeyPrefix Specifies the Amazon S3 key prefix that comes after the name of the
     *         bucket you have designated for log file delivery. For more
     *         information, see <a
     *         href="http://docs.aws.amazon.com/awscloudtrail/latest/userguide/cloudtrail-find-log-files.html">Finding
     *         Your CloudTrail Log Files</a>.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public CreateTrailResult withS3KeyPrefix(String s3KeyPrefix) {
        this.s3KeyPrefix = s3KeyPrefix;
        return this;
    }

    /**
     * Specifies the name of the Amazon SNS topic defined for notification of
     * log file delivery.
     *
     * @return Specifies the name of the Amazon SNS topic defined for notification of
     *         log file delivery.
     */
    public String getSnsTopicName() {
        return snsTopicName;
    }
    
    /**
     * Specifies the name of the Amazon SNS topic defined for notification of
     * log file delivery.
     *
     * @param snsTopicName Specifies the name of the Amazon SNS topic defined for notification of
     *         log file delivery.
     */
    public void setSnsTopicName(String snsTopicName) {
        this.snsTopicName = snsTopicName;
    }
    
    /**
     * Specifies the name of the Amazon SNS topic defined for notification of
     * log file delivery.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param snsTopicName Specifies the name of the Amazon SNS topic defined for notification of
     *         log file delivery.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public CreateTrailResult withSnsTopicName(String snsTopicName) {
        this.snsTopicName = snsTopicName;
        return this;
    }

    /**
     * Specifies whether the trail is publishing events from global services
     * such as IAM to the log files.
     *
     * @return Specifies whether the trail is publishing events from global services
     *         such as IAM to the log files.
     */
    public Boolean isIncludeGlobalServiceEvents() {
        return includeGlobalServiceEvents;
    }
    
    /**
     * Specifies whether the trail is publishing events from global services
     * such as IAM to the log files.
     *
     * @param includeGlobalServiceEvents Specifies whether the trail is publishing events from global services
     *         such as IAM to the log files.
     */
    public void setIncludeGlobalServiceEvents(Boolean includeGlobalServiceEvents) {
        this.includeGlobalServiceEvents = includeGlobalServiceEvents;
    }
    
    /**
     * Specifies whether the trail is publishing events from global services
     * such as IAM to the log files.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param includeGlobalServiceEvents Specifies whether the trail is publishing events from global services
     *         such as IAM to the log files.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public CreateTrailResult withIncludeGlobalServiceEvents(Boolean includeGlobalServiceEvents) {
        this.includeGlobalServiceEvents = includeGlobalServiceEvents;
        return this;
    }

    /**
     * Specifies whether the trail is publishing events from global services
     * such as IAM to the log files.
     *
     * @return Specifies whether the trail is publishing events from global services
     *         such as IAM to the log files.
     */
    public Boolean getIncludeGlobalServiceEvents() {
        return includeGlobalServiceEvents;
    }

    /**
     * Specifies the ARN of the trail that was created.
     *
     * @return Specifies the ARN of the trail that was created.
     */
    public String getTrailARN() {
        return trailARN;
    }
    
    /**
     * Specifies the ARN of the trail that was created.
     *
     * @param trailARN Specifies the ARN of the trail that was created.
     */
    public void setTrailARN(String trailARN) {
        this.trailARN = trailARN;
    }
    
    /**
     * Specifies the ARN of the trail that was created.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param trailARN Specifies the ARN of the trail that was created.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public CreateTrailResult withTrailARN(String trailARN) {
        this.trailARN = trailARN;
        return this;
    }

    /**
     * Specifies whether log file integrity validation is enabled.
     *
     * @return Specifies whether log file integrity validation is enabled.
     */
    public Boolean isLogFileValidationEnabled() {
        return logFileValidationEnabled;
    }
    
    /**
     * Specifies whether log file integrity validation is enabled.
     *
     * @param logFileValidationEnabled Specifies whether log file integrity validation is enabled.
     */
    public void setLogFileValidationEnabled(Boolean logFileValidationEnabled) {
        this.logFileValidationEnabled = logFileValidationEnabled;
    }
    
    /**
     * Specifies whether log file integrity validation is enabled.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param logFileValidationEnabled Specifies whether log file integrity validation is enabled.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public CreateTrailResult withLogFileValidationEnabled(Boolean logFileValidationEnabled) {
        this.logFileValidationEnabled = logFileValidationEnabled;
        return this;
    }

    /**
     * Specifies whether log file integrity validation is enabled.
     *
     * @return Specifies whether log file integrity validation is enabled.
     */
    public Boolean getLogFileValidationEnabled() {
        return logFileValidationEnabled;
    }

    /**
     * Specifies the Amazon Resource Name (ARN) of the log group to which
     * CloudTrail logs will be delivered.
     *
     * @return Specifies the Amazon Resource Name (ARN) of the log group to which
     *         CloudTrail logs will be delivered.
     */
    public String getCloudWatchLogsLogGroupArn() {
        return cloudWatchLogsLogGroupArn;
    }
    
    /**
     * Specifies the Amazon Resource Name (ARN) of the log group to which
     * CloudTrail logs will be delivered.
     *
     * @param cloudWatchLogsLogGroupArn Specifies the Amazon Resource Name (ARN) of the log group to which
     *         CloudTrail logs will be delivered.
     */
    public void setCloudWatchLogsLogGroupArn(String cloudWatchLogsLogGroupArn) {
        this.cloudWatchLogsLogGroupArn = cloudWatchLogsLogGroupArn;
    }
    
    /**
     * Specifies the Amazon Resource Name (ARN) of the log group to which
     * CloudTrail logs will be delivered.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param cloudWatchLogsLogGroupArn Specifies the Amazon Resource Name (ARN) of the log group to which
     *         CloudTrail logs will be delivered.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public CreateTrailResult withCloudWatchLogsLogGroupArn(String cloudWatchLogsLogGroupArn) {
        this.cloudWatchLogsLogGroupArn = cloudWatchLogsLogGroupArn;
        return this;
    }

    /**
     * Specifies the role for the CloudWatch Logs endpoint to assume to write
     * to a user's log group.
     *
     * @return Specifies the role for the CloudWatch Logs endpoint to assume to write
     *         to a user's log group.
     */
    public String getCloudWatchLogsRoleArn() {
        return cloudWatchLogsRoleArn;
    }
    
    /**
     * Specifies the role for the CloudWatch Logs endpoint to assume to write
     * to a user's log group.
     *
     * @param cloudWatchLogsRoleArn Specifies the role for the CloudWatch Logs endpoint to assume to write
     *         to a user's log group.
     */
    public void setCloudWatchLogsRoleArn(String cloudWatchLogsRoleArn) {
        this.cloudWatchLogsRoleArn = cloudWatchLogsRoleArn;
    }
    
    /**
     * Specifies the role for the CloudWatch Logs endpoint to assume to write
     * to a user's log group.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param cloudWatchLogsRoleArn Specifies the role for the CloudWatch Logs endpoint to assume to write
     *         to a user's log group.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public CreateTrailResult withCloudWatchLogsRoleArn(String cloudWatchLogsRoleArn) {
        this.cloudWatchLogsRoleArn = cloudWatchLogsRoleArn;
        return this;
    }

    /**
     * Specifies the KMS key ID that encrypts the logs delivered by
     * CloudTrail. The value is a fully specified ARN to a KMS key in the
     * format:
     * <code>arn:aws:kms:us-east-1:123456789012:key/12345678-1234-1234-1234-123456789012</code>
     *
     * @return Specifies the KMS key ID that encrypts the logs delivered by
     *         CloudTrail. The value is a fully specified ARN to a KMS key in the
     *         format:
     *         <code>arn:aws:kms:us-east-1:123456789012:key/12345678-1234-1234-1234-123456789012</code>
     */
    public String getKmsKeyId() {
        return kmsKeyId;
    }
    
    /**
     * Specifies the KMS key ID that encrypts the logs delivered by
     * CloudTrail. The value is a fully specified ARN to a KMS key in the
     * format:
     * <code>arn:aws:kms:us-east-1:123456789012:key/12345678-1234-1234-1234-123456789012</code>
     *
     * @param kmsKeyId Specifies the KMS key ID that encrypts the logs delivered by
     *         CloudTrail. The value is a fully specified ARN to a KMS key in the
     *         format:
     *         <code>arn:aws:kms:us-east-1:123456789012:key/12345678-1234-1234-1234-123456789012</code>
     */
    public void setKmsKeyId(String kmsKeyId) {
        this.kmsKeyId = kmsKeyId;
    }
    
    /**
     * Specifies the KMS key ID that encrypts the logs delivered by
     * CloudTrail. The value is a fully specified ARN to a KMS key in the
     * format:
     * <code>arn:aws:kms:us-east-1:123456789012:key/12345678-1234-1234-1234-123456789012</code>
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param kmsKeyId Specifies the KMS key ID that encrypts the logs delivered by
     *         CloudTrail. The value is a fully specified ARN to a KMS key in the
     *         format:
     *         <code>arn:aws:kms:us-east-1:123456789012:key/12345678-1234-1234-1234-123456789012</code>
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public CreateTrailResult withKmsKeyId(String kmsKeyId) {
        this.kmsKeyId = kmsKeyId;
        return this;
    }

    /**
     * Returns a string representation of this object; useful for testing and
     * debugging.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getName() != null) sb.append("Name: " + getName() + ",");
        if (getS3BucketName() != null) sb.append("S3BucketName: " + getS3BucketName() + ",");
        if (getS3KeyPrefix() != null) sb.append("S3KeyPrefix: " + getS3KeyPrefix() + ",");
        if (getSnsTopicName() != null) sb.append("SnsTopicName: " + getSnsTopicName() + ",");
        if (isIncludeGlobalServiceEvents() != null) sb.append("IncludeGlobalServiceEvents: " + isIncludeGlobalServiceEvents() + ",");
        if (getTrailARN() != null) sb.append("TrailARN: " + getTrailARN() + ",");
        if (isLogFileValidationEnabled() != null) sb.append("LogFileValidationEnabled: " + isLogFileValidationEnabled() + ",");
        if (getCloudWatchLogsLogGroupArn() != null) sb.append("CloudWatchLogsLogGroupArn: " + getCloudWatchLogsLogGroupArn() + ",");
        if (getCloudWatchLogsRoleArn() != null) sb.append("CloudWatchLogsRoleArn: " + getCloudWatchLogsRoleArn() + ",");
        if (getKmsKeyId() != null) sb.append("KmsKeyId: " + getKmsKeyId() );
        sb.append("}");
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        
        hashCode = prime * hashCode + ((getName() == null) ? 0 : getName().hashCode()); 
        hashCode = prime * hashCode + ((getS3BucketName() == null) ? 0 : getS3BucketName().hashCode()); 
        hashCode = prime * hashCode + ((getS3KeyPrefix() == null) ? 0 : getS3KeyPrefix().hashCode()); 
        hashCode = prime * hashCode + ((getSnsTopicName() == null) ? 0 : getSnsTopicName().hashCode()); 
        hashCode = prime * hashCode + ((isIncludeGlobalServiceEvents() == null) ? 0 : isIncludeGlobalServiceEvents().hashCode()); 
        hashCode = prime * hashCode + ((getTrailARN() == null) ? 0 : getTrailARN().hashCode()); 
        hashCode = prime * hashCode + ((isLogFileValidationEnabled() == null) ? 0 : isLogFileValidationEnabled().hashCode()); 
        hashCode = prime * hashCode + ((getCloudWatchLogsLogGroupArn() == null) ? 0 : getCloudWatchLogsLogGroupArn().hashCode()); 
        hashCode = prime * hashCode + ((getCloudWatchLogsRoleArn() == null) ? 0 : getCloudWatchLogsRoleArn().hashCode()); 
        hashCode = prime * hashCode + ((getKmsKeyId() == null) ? 0 : getKmsKeyId().hashCode()); 
        return hashCode;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (obj instanceof CreateTrailResult == false) return false;
        CreateTrailResult other = (CreateTrailResult)obj;
        
        if (other.getName() == null ^ this.getName() == null) return false;
        if (other.getName() != null && other.getName().equals(this.getName()) == false) return false; 
        if (other.getS3BucketName() == null ^ this.getS3BucketName() == null) return false;
        if (other.getS3BucketName() != null && other.getS3BucketName().equals(this.getS3BucketName()) == false) return false; 
        if (other.getS3KeyPrefix() == null ^ this.getS3KeyPrefix() == null) return false;
        if (other.getS3KeyPrefix() != null && other.getS3KeyPrefix().equals(this.getS3KeyPrefix()) == false) return false; 
        if (other.getSnsTopicName() == null ^ this.getSnsTopicName() == null) return false;
        if (other.getSnsTopicName() != null && other.getSnsTopicName().equals(this.getSnsTopicName()) == false) return false; 
        if (other.isIncludeGlobalServiceEvents() == null ^ this.isIncludeGlobalServiceEvents() == null) return false;
        if (other.isIncludeGlobalServiceEvents() != null && other.isIncludeGlobalServiceEvents().equals(this.isIncludeGlobalServiceEvents()) == false) return false; 
        if (other.getTrailARN() == null ^ this.getTrailARN() == null) return false;
        if (other.getTrailARN() != null && other.getTrailARN().equals(this.getTrailARN()) == false) return false; 
        if (other.isLogFileValidationEnabled() == null ^ this.isLogFileValidationEnabled() == null) return false;
        if (other.isLogFileValidationEnabled() != null && other.isLogFileValidationEnabled().equals(this.isLogFileValidationEnabled()) == false) return false; 
        if (other.getCloudWatchLogsLogGroupArn() == null ^ this.getCloudWatchLogsLogGroupArn() == null) return false;
        if (other.getCloudWatchLogsLogGroupArn() != null && other.getCloudWatchLogsLogGroupArn().equals(this.getCloudWatchLogsLogGroupArn()) == false) return false; 
        if (other.getCloudWatchLogsRoleArn() == null ^ this.getCloudWatchLogsRoleArn() == null) return false;
        if (other.getCloudWatchLogsRoleArn() != null && other.getCloudWatchLogsRoleArn().equals(this.getCloudWatchLogsRoleArn()) == false) return false; 
        if (other.getKmsKeyId() == null ^ this.getKmsKeyId() == null) return false;
        if (other.getKmsKeyId() != null && other.getKmsKeyId().equals(this.getKmsKeyId()) == false) return false; 
        return true;
    }
    
    @Override
    public CreateTrailResult clone() {
        try {
            return (CreateTrailResult) super.clone();
        
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() "
                    + "even though we're Cloneable!",
                    e);
        }
        
    }

}
    