package com.scrimfinderwq.scrimFinderWQ.models.tournament;

import com.scrimfinderwq.scrimFinderWQ.models.match.Match;
import com.scrimfinderwq.scrimFinderWQ.models.team.Team;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tournament {
    public Long tournament_id;
    public List<Match> matches;
    public List<Team> teams;
    public TournamentTypes type;

    public Tournament(List<Team> teams, TournamentTypes type) {
        this.teams = teams;
        this.type = type;
    }

    public Tournament(Long id){
        tournament_id = id;
    }
}
