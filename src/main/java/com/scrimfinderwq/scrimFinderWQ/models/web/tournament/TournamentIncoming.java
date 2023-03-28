package com.scrimfinderwq.scrimFinderWQ.models.web.tournament;

import com.scrimfinderwq.scrimFinderWQ.entities.repositories.TournamentRepo;
import com.scrimfinderwq.scrimFinderWQ.models.tournament.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/in/tournament")
@Service
public class TournamentIncoming {
    @Autowired
    TournamentRepo tournamentRepo;
    @GetMapping("/{tournamentId}")
    public ResponseEntity getTournamentById(@PathVariable Long tournamentId) {
        return new ResponseEntity<>(tournamentRepo.findById(tournamentId), HttpStatus.OK);

    }
}
