package com.example.kafka.producer.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produce")
public class ProducerController {

	@Autowired
	KafkaTemplate<String, String> template;

	@PostMapping
	public void produce(@RequestParam String topic, @RequestParam String str) {
		template.send(Optional.ofNullable(topic).orElse("topic1"), str);
	}
}
