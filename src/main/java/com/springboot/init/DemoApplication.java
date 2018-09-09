package com.springboot.init;

import com.springboot.vertx.handler.VertXRequestHandler;
import com.springboot.controllers.FIFA17ControllerVertX;
import io.vertx.core.Vertx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication(scanBasePackages = {"com.springboot"})
public class DemoApplication {

	@Autowired
	private FIFA17ControllerVertX a;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@PostConstruct
	public void deployVerticles() {
		Vertx vertx=Vertx.vertx();

		vertx.deployVerticle(a, VertXRequestHandler.deployStatusHandler);
	}
}
