package com.citihive.payvote.config;
/**
 * @author Sreekanth Varidhireddy
 * Sep 21, 2023
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
public class DynamoDBConfiguration {
	
	@Bean
	public DynamoDBMapper dynamoDBMapper() {
		return new DynamoDBMapper(buildAmazonDynamoDB());
	}
	
	private AmazonDynamoDB buildAmazonDynamoDB() {
		return AmazonDynamoDBClientBuilder
				.standard()
				.withEndpointConfiguration(
						new AwsClientBuilder.EndpointConfiguration(
						//serviceEndpoint
								"dynamodb.us-east-1.amazonaws.com", 
						//signingRegion
								"us-east-1"
						)
				)
				.withCredentials(
						new AWSStaticCredentialsProvider(
								new BasicAWSCredentials(
										"AKIAVREPUWUWTYIAQQCO",
										"zSmp3Qp6H1KhD+S390nkGJMyyN1F8C010dkJCale"
										)
								)
						)
						.build();
	}
}
