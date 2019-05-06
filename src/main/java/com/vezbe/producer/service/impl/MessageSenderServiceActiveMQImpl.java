package com.vezbe.producer.service.impl;

import com.vezbe.producer.dto.MessageDto;
import com.vezbe.producer.service.MessageSenderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageSenderServiceActiveMQImpl implements MessageSenderService {

    private final JmsTemplate jmsTemplate;
    private final String messageDestination;

    public MessageSenderServiceActiveMQImpl(JmsTemplate jmsTemplate, @Value("${destination.message}") String messageDestination) {
        this.jmsTemplate = jmsTemplate;
        this.messageDestination = messageDestination;
    }

    @Override
    public void sendMessage(MessageDto messageDto) {
        jmsTemplate.convertAndSend(messageDestination, messageDto);
    }

}
