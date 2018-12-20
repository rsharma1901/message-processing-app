package com.jpm.myjmsapp.receiver;

import com.jpm.myjmsapp.processor.SalesEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component("receiver")
public class Receiver {
    int messageCount = 0;

    @Autowired
    SalesEngine engine;

    @JmsListener(destination = "messageReceiver", containerFactory = "myFactory")
    public void receiveMessage(String message) {
        String[] messageArray = message.split(" ");
        engine.process(messageArray, messageCount);
        messageCount++;
    }

}
