package com.scrimfinderwq.scrimFinderWQ.models.web.tournament;

import com.scrimfinderwq.scrimFinderWQ.interfaces.TournamentInterface;
import com.scrimfinderwq.scrimFinderWQ.models.tournament.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.rmi.ServerException;
import java.util.List;

@RestController
@RequestMapping("/api/out/tournament")
@Service
public class TournamentOutgoing {
    private TournamentInterface tournamentInterface;

    @Autowired
    public void setTournamentInterface(TournamentInterface tournamentInterface) {
        this.tournamentInterface = tournamentInterface;
    }

    @PostMapping ("/create")
    public ResponseEntity createTournament(@RequestBody Tournament tournament) throws ServerException {
        if (tournament == null) {
            throw new ServerException("Null");
        } else {
            tournament = tournamentInterface.createTournamentMatches(tournament);
            return new ResponseEntity<>(tournament, HttpStatus.CREATED);
        }
    }
}