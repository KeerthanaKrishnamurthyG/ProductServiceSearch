package com.app.ecom.ecommercedemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.support.HttpHeaders;


@Configuration
public class MyClientConfig extends ElasticsearchConfiguration {

    @Value("${elasticsearch.host}")
    private String elasticHost;

    @Value("${elasticsearch.ca.fingerprint}")
    private String caFingerprint;

    @Value("${elasticsearch.username}")
    private String elasticsearchUsername;
    @Value("${elasticsearch.password}")
    private String elasticsearchPassword;
    @Override
    public ClientConfiguration clientConfiguration() {

        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(elasticHost)
                .usingSsl(caFingerprint)
                .withBasicAuth(elasticsearchUsername,elasticsearchPassword)
                .build();
        return clientConfiguration;
    }
}