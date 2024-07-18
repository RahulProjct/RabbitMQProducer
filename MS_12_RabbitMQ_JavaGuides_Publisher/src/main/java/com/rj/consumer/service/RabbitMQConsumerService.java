package com.rj.consumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RabbitMQConsumerService {

	@Value("${rabbitmq.queue.name}")
	private String queue;
	
	//@RabbitListener(queues = {"{${rabbitmq.queue.name}"})
public void rabbitMsgListner(String massage) {
	System.out.println(massage);
	log.info("Consume Masg"+massage);
}
}
