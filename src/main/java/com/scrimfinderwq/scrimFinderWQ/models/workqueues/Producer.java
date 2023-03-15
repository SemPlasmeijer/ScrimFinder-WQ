package com.scrimfinderwq.scrimFinderWQ.models.workqueues;

import com.scrimfinderwq.scrimFinderWQ.models.match.Match;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class Producer {
    @Autowired
    private Queue queue;

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendMsg(final Match match) {
        rabbitTemplate.convertAndSend(queue.getName(), match);
        System.out.println("Sent: " + match.toString());
    }

}