package com.scrimfinderwq.scrimFinderWQ.models.match;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.scrimfinderwq.scrimFinderWQ.models.team.Team;
import com.scrimfinderwq.scrimFinderWQ.models.tournament.Tournament;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Match implements Serializable {
    @Serial
    private static final long serialVersionUID = -1138446817700416884L;
    @JsonProperty
    private Long match_id;
    @JsonProperty
    public Team home_team;
    @JsonProperty
    public Team away_team;
    @JsonProperty
    public int round;

    public Tournament tournament;

    public Match(Team home_team, Team away_team, int round,Tournament tournament) {
        this.away_team = away_team;
        this.home_team = home_team;
        this.round = round;
        this.tournament = tournament;
    }

    @Override
    public String toString() {
        return "new Match Send" +
                " match_id=" + match_id +
                ", home_team=" + home_team.getTeam_id() +
                ", away_team=" + away_team.getTeam_id() +
                ", round=" + round +
                ", tournament=" + tournament.getTournament_id() +
                '}';
    }
}
