package pl.oczadly.ebs.demo.configuration

import com.amazonaws.auth.EnvironmentVariableCredentialsProvider
import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class DynamoDBConfig {
    @Value("\${amazon.dynamodb.endpoint}")
    private val amazonDynamoDBEndpoint: String? = null

    @Bean
    fun amazonDynamoDB(): AmazonDynamoDB {
        val amazonDynamoDB: AmazonDynamoDBClientBuilder = AmazonDynamoDBClientBuilder.standard()
        return amazonDynamoDB.withCredentials(EnvironmentVariableCredentialsProvider()).withEndpointConfiguration(
                AwsClientBuilder.EndpointConfiguration(amazonDynamoDBEndpoint, "us-east-1")).build()
    }
}