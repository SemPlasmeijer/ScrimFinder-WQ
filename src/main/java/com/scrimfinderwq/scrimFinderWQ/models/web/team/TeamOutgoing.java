package com.scrimfinderwq.scrimFinderWQ.models.web.team;

import com.scrimfinderwq.scrimFinderWQ.interfaces.TeamInterface;
import com.scrimfinderwq.scrimFinderWQ.interfaces.TournamentInterface;
import com.scrimfinderwq.scrimFinderWQ.models.team.Team;
import com.scrimfinderwq.scrimFinderWQ.models.team.TeamContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.ServerException;
import java.util.List;

@RestController
@RequestMapping("/api/out/team")
@Service
public class TeamOutgoing {
    public TeamInterface teamInterface;
    @Autowired
    public void setTournamentInterface(TeamInterface teamInterface) {
        this.teamInterface = teamInterface;
    }
    @PostMapping("/MassCreate")
    public ResponseEntity createMultipleTeams(@RequestBody List<Team> teams) throws ServerException  {
        if (teams.isEmpty()) {
            throw new ServerException("Null");
        } else {
           teams = teamInterface.createMultipleTeams(teams);
           return new ResponseEntity<>(teams, HttpStatus.CREATED);
        }
    }
}
