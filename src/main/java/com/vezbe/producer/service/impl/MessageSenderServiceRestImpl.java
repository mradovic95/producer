package com.vezbe.producer.service.impl;

import com.vezbe.producer.dto.MessageDto;
import com.vezbe.producer.service.MessageSenderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MessageSenderServiceRestImpl implements MessageSenderService {

    private final RestTemplate restTemplate;
    private final String consumerUrl;

    public MessageSenderServiceRestImpl(RestTemplate restTemplate, @Value("${consumer.message.url}") String consumerUrl) {
        this.restTemplate = restTemplate;
        this.consumerUrl = consumerUrl;
    }

    @Override
    public void sendMessage(MessageDto messageDto) {
        restTemplate.postForEntity(consumerUrl, messageDto, Object.class);
    }

}
