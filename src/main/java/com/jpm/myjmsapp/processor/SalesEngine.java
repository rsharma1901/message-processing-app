package com.jpm.myjmsapp.processor;

import com.jpm.myjmsapp.model.OperationType;
import com.jpm.myjmsapp.model.Product;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SalesEngine {
    Map<String, List<Product>> product = new HashMap<>();
    public void process(String[] messageArray, int messageCount){
        verifyMessageCountLimit(messageCount);
        switch (messageArray.length) {
            case 3:
                int messageTypeThree = 0;
                for (OperationType operation : OperationType.values()) {
                    if(operation.name().equalsIgnoreCase(   messageArray[0]))
                        messageTypeThree++;
                }
                if (messageTypeThree!=0) {
                    MessageProcessor.typeThreeMessageProcessor(product, messageArray);
                } else {
                    MessageProcessor.typeOneMessageProcessor(product, messageArray);
                }
                break;
            case 7:
                MessageProcessor.typeTwoMessageProcessor(product, messageArray);
                break;
            default:
                System.out.print("Invalid message Skipping it.");
        }
    }

    private void verifyMessageCountLimit(int messageCount) {
        if(messageCount == 50){
            System.out.println("Exiting");
            System.exit(1);
        }else if(messageCount %10 == 0){
            for (Map.Entry map : product.entrySet()) {
                List<Product> list = (List) map.getValue();
                list.forEach( product1 -> {
                    System.out.println(String.format("%s at price %sp quantity %s"
                            , map.getKey(), product1.getRatePerItem(),product1.getQuantity()));
                });
            }
        }
    }
}
