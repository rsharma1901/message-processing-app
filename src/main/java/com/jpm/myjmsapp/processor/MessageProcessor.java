package com.jpm.myjmsapp.processor;

import com.jpm.myjmsapp.model.OperationType;
import com.jpm.myjmsapp.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MessageProcessor {

    public static void typeOneMessageProcessor(Map<String, List<Product>> productMap, String[] messageArray) {
        List<Product> productList = productMap.get(messageArray[0]);
        Product product = Product.builder()
                .quantity(1)
                .ratePerItem(Float.valueOf(messageArray[2].substring(0, messageArray[2].length() - 1)))
                .build();
        if (productList == null) {
            productList = new ArrayList<>();
            productList.add(product);
        } else {
            productList.add(product);
        }
        productMap.put(messageArray[0].toLowerCase(), productList);
    }

    public static void typeTwoMessageProcessor(Map<String, List<Product>> productMap, String[] messageArray) {
        String key = messageArray[3];
        List<Product> productList = productMap.get(key);
        Product product = Product.builder()
                .quantity(Integer.valueOf(messageArray[0]))
                .ratePerItem(Float.valueOf(messageArray[5].substring(0, messageArray[5].length() - 1)))
                .build();
        if (productList == null) {
            productList = new ArrayList<>();
            productList.add(product);
        } else {
            productList.add(product);
        }
        productMap.put(key, productList);
    }

    public static void typeThreeMessageProcessor(Map<String, List<Product>> productMap, String[] messageArray) {
        String key = messageArray[2];
        List<Product> productList = productMap.get(key);
        if (productList != null) {
            switch (OperationType.valueOf(messageArray[0])) {
                case Add:
                    productList.forEach(product -> {
                        int quantity = product.getQuantity();
                        product.setQuantity(quantity
                                + Integer.valueOf(messageArray[1].substring(0, messageArray[1].length() - 1)));
                    });
                    break;
                case Subtract:
                    productList.forEach(product -> {
                        int quantity = product.getQuantity();
                        product.setQuantity(quantity
                                - Integer.valueOf(messageArray[1].substring(0, messageArray[1].length() - 1)));
                    });
                    break;
                case Multiply:
                    productList.forEach(product -> {
                        int quantity = product.getQuantity();
                        product.setQuantity(quantity
                                * Integer.valueOf(messageArray[1].substring(0, messageArray[1].length() - 1)));
                    });
                    break;
            }
            productMap.put(key, productList);

        }
    }

}
