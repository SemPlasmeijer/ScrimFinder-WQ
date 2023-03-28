package com.scrimfinderwq.scrimFinderWQ.models.workqueues;

import java.math.BigInteger;

import com.scrimfinderwq.scrimFinderWQ.entities.MatchEntity;
import com.scrimfinderwq.scrimFinderWQ.entities.TournamentEntity;
import com.scrimfinderwq.scrimFinderWQ.entities.mappers.interfaces.MatchMapper;
import com.scrimfinderwq.scrimFinderWQ.entities.repositories.MatchRepo;
import com.scrimfinderwq.scrimFinderWQ.entities.repositories.TournamentRepo;
import com.scrimfinderwq.scrimFinderWQ.models.match.Match;
import lombok.NoArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.util.StopWatch;
@NoArgsConstructor
@RabbitListener(queues = "${queue.name}")
public class Consumer {
    public MatchMapper matchMapper = Mappers.getMapper(MatchMapper.class);

    @Autowired
    TournamentRepo tournamentRepo;
    @Autowired
    MatchRepo matchRepo;

    private int srNo;

    public Consumer(int srNo) {
        this.srNo = srNo;
    }

    @RabbitHandler
    public void receive(final Match match) throws InterruptedException {
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
        MatchEntity new_match = matchRepo.save(matchMapper.INSTANCE.toMatchEntity(match));

        try {
            TournamentEntity tournament = new_match.getTournament();
            assert tournament != null;
            tournament.matches.add(new_match);
            tournamentRepo.save(tournament);

            return matchMapper.INSTANCE.toMatch(new_match);
        }
        catch (Exception e) {
            //add error idk
            return matchMapper.INSTANCE.toMatch(new_match);
        }
    }
}