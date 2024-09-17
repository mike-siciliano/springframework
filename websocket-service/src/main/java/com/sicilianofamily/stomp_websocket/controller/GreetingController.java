package com.sicilianofamily.stomp_websocket.controller;

import com.sicilianofamily.stomp_websocket.model.Greeting;
import com.sicilianofamily.stomp_websocket.model.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
   public Greeting greeting(HelloMessage message) throws Exception {
        long sleep = (long) (1000 + (Math.random() * (2000 - 1000))); // between 1 and 2 seconds to simulate a delay
        Thread.sleep(sleep);
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.name()) + "!");
   }
}
