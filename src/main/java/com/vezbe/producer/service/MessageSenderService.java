package com.vezbe.producer.service;

import com.vezbe.producer.dto.MessageDto;

public interface MessageSenderService {

    void sendMessage(MessageDto messageDto);

}
