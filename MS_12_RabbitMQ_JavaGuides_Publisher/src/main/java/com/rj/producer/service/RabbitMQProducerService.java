package com.rj.producer.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rj.model.Person;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RabbitMQProducerService {

	@Value("${rabbitmq.queue.name}")
	private String queue;
	@Value("${rabbitmq.exchange.name}")
	private String exchange;

	@Value("${rabbitmq.routing.key}")
	private String routingKey;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	// sending massages to exchange
	public void sendMassages(String msg) {
		log.info(String.format("massage send -> %s", msg));
		rabbitTemplate.convertAndSend(exchange, routingKey, msg);
	}

	public void sendMassagesJson(Person p) {
		rabbitTemplate.convertAndSend(exchange,routingKey, p);
		log.trace("json mag sended "+ p);
	}
}
