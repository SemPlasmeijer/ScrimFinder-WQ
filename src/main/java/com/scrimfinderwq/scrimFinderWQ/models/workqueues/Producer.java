package com.scrimfinderwq.scrimFinderWQ.models.workqueues;

import com.scrimfinderwq.scrimFinderWQ.models.match.Match;
import com.scrimfinderwq.scrimFinderWQ.models.match.MatchContainer;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Producer {

    @Value("${spring.rabbitmq.template.routing-key}")
    private String routingkey;

    @Autowired
    private Queue queue;

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendMsg(final Match match) {
        rabbitTemplate.convertAndSend(routingkey,match);
        System.out.println("Sent: " + match.toString());
    }

}