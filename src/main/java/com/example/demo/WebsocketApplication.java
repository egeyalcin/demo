package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

@SpringBootApplication
public class WebsocketApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebsocketApplication.class, args);
	}

	@Bean
	public WebSocketHandler webSocketHandler() {
		return new WebsocketHandler();
	}

	public static class WebsocketHandler extends AbstractWebSocketHandler {

		private static final Logger log = LoggerFactory.getLogger(WebsocketHandler.class);

		@Override
		public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
			log.info("Received message: {}", message.getPayload());
			session.sendMessage(message);
		}
	}
}

