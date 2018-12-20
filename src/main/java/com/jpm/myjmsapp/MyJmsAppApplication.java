package com.jpm.myjmsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MyJmsAppApplication {

	@Bean
	public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
													DefaultJmsListenerContainerFactoryConfigurer configurer) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		// This provides all boot's default to this factory, including the message converter
		configurer.configure(factory, connectionFactory);
		// You could still override some of Boot's default if necessary.
		return factory;
	}

	@Bean // Serialize message content to json using TextMessage
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MyJmsAppApplication.class, args);

		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

		//Hardcoding messages could be read from external file or put on queue directly
		List<String> listOfMessages = new ArrayList<>();
		listOfMessages.add("apple at 10p");
		listOfMessages.add("20 sales of apple at 10p each");
		listOfMessages.add("Add 20p apple");
		listOfMessages.add("banana at 10p");
		listOfMessages.add("20 sales of banana at 10p each");
		listOfMessages.add("Add 20p apple");
		listOfMessages.add("papaya at 100p");
		listOfMessages.add("500 sales of papaya at 10p each");
		listOfMessages.add("Add 20p apple");
		listOfMessages.add("orange at 10p");
		listOfMessages.add("apple at 10p");
		listOfMessages.add("20 sales of apple at 10p each");
		listOfMessages.add("Add 20p apple");
		listOfMessages.add("banana at 10p");
		listOfMessages.add("20 sales of banana at 10p each");
		listOfMessages.add("Add 20p apple");
		listOfMessages.add("papaya at 100p");
		listOfMessages.add("500 sales of papaya at 10p each");
		listOfMessages.add("Add 20p apple");
		listOfMessages.add("orange at 10p");listOfMessages.add("apple at 10p");
		listOfMessages.add("20 sales of apple at 10p each");
		listOfMessages.add("Add 20p apple");
		listOfMessages.add("banana at 10p");
		listOfMessages.add("20 sales of banana at 10p each");
		listOfMessages.add("Add 20p apple");
		listOfMessages.add("papaya at 100p");
		listOfMessages.add("500 sales of papaya at 10p each");
		listOfMessages.add("Add 20p apple");
		listOfMessages.add("orange at 10p");listOfMessages.add("apple at 10p");
		listOfMessages.add("20 sales of apple at 10p each");
		listOfMessages.add("Add 20p apple");
		listOfMessages.add("banana at 10p");
		listOfMessages.add("20 sales of banana at 10p each");
		listOfMessages.add("Add 20p apple");
		listOfMessages.add("papaya at 100p");
		listOfMessages.add("500 sales of papaya at 10p each");
		listOfMessages.add("Add 20p apple");
		listOfMessages.add("orange at 10p");listOfMessages.add("apple at 10p");
		listOfMessages.add("20 sales of apple at 10p each");
		listOfMessages.add("Add 20p apple");
		listOfMessages.add("banana at 10p");
		listOfMessages.add("20 sales of banana at 10p each");
		listOfMessages.add("Add 20p apple");
		listOfMessages.add("papaya at 100p");
		listOfMessages.add("500 sales of papaya at 10p each");
		listOfMessages.add("Add 20p apple");
		listOfMessages.add("orange at 10p");
		listOfMessages.add("20 sales of orange at 10p each");
		listOfMessages.add("Add 20p orange");

		listOfMessages.forEach( message -> {
			jmsTemplate.convertAndSend("messageReceiver", message);
		});


	}
}
