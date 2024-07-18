package com.rj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rj.model.Person;
import com.rj.producer.service.RabbitMQProducerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/rabbit")
public class RabbitProducerController {

	@Autowired
	private RabbitMQProducerService service;

	@PostMapping("/publish")
	public ResponseEntity<?> sendMsg(@RequestParam("msg") String massage) {
		service.sendMassages(massage);
		log.info(String.format("In Controller massage send ", massage));
		return ResponseEntity.ok("massage Send SuccesFully " + massage);
	}
	@PostMapping("/person")
	public ResponseEntity<?> sendJsonMsg(@RequestBody Person p) {
		System.out.println(p);
		service.sendMassagesJson(p);
		log.info(String.format("In Controller massage send ", p.toString()));
		return ResponseEntity.ok("massage Send SuccesFully " + p);
	}
	
}
