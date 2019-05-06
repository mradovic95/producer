package com.vezbe.producer.cronjob;

import com.vezbe.producer.dto.MessageDto;
import com.vezbe.producer.service.MessageSenderService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SendMessageWithHttpJob {

    private final MessageSenderService messageSenderService;

    public SendMessageWithHttpJob(@Qualifier("messageSenderServiceRestImpl") MessageSenderService messageSenderService) {
        this.messageSenderService = messageSenderService;
    }

    @Scheduled(fixedRate = 5000)
    public void sendMessage() {
        MessageDto messageDto = new MessageDto("Http message", "text", "author");
        messageSenderService.sendMessage(messageDto);
    }

}
