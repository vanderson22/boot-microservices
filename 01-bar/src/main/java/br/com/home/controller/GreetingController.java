package br.com.home.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.home.Greeting;

@RestController()
public class GreetingController {

	private static final String template = "hello %s!";
	private static AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String param) {

		return new Greeting(counter.incrementAndGet(),   String.format(template, param) );
	}
}
