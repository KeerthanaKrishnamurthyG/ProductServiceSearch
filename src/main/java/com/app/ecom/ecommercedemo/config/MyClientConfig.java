package com.app.ecom.ecommercedemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.support.HttpHeaders;


@Configuration
public class MyClientConfig extends ElasticsearchConfiguration {

    @Override
    public ClientConfiguration clientConfiguration() {

        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .usingSsl("602b71ffb8e345c153899d78e2b1131ae685da1ef631237937b5a76b9531aa63")
                .withBasicAuth("elastic","JMauclgiTeWcVSF3T_AA")
                .build();
        return clientConfiguration;
    }
}