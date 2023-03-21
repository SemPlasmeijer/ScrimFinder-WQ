package com.scrimfinderwq.scrimFinderWQ.models.workqueues;

import java.math.BigInteger;

import com.scrimfinderwq.scrimFinderWQ.containers.MatchCrudContainer;
import com.scrimfinderwq.scrimFinderWQ.entities.mappers.MatchMapper;
import com.scrimfinderwq.scrimFinderWQ.models.match.Match;
import com.scrimfinderwq.scrimFinderWQ.models.match.MatchContainer;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@RabbitListener(queues = "${queue.name}")
public class Consumer {
    public MatchCrudContainer matchCrudContainer;
    public MatchMapper matchMapper;

    private final int srNo;

    public Consumer(int srNo) {
        this.srNo = srNo;
    }

    @RabbitHandler
    public void receiveMsg(final Match match) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        System.out.println("Received (" + srNo + "): " + match.getMatch_id());

        Match new_match = createMatch(match);

        System.out.println("Next Match Number: " + new_match.getMatch_id());

        stopWatch.stop();

        System.out.println("Consumer(" + srNo + ") Done in " + stopWatch.getTotalTimeSeconds() + "s");
    }

    private Match fakeMatchInsert(Match match) {
        BigInteger veryBig = new BigInteger(String.valueOf(match.getMatch_id()));
        veryBig.nextProbablePrime();
        return match;
    }

    private Match createMatch(Match match) {
        return matchMapper.toMatch(matchCrudContainer.createMatch(match));
    }
}