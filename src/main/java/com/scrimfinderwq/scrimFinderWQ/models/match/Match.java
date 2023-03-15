package com.scrimfinderwq.scrimFinderWQ.models.match;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.scrimfinderwq.scrimFinderWQ.models.team.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;
@Component
public class Match implements Serializable {
    @Serial
    private static final long serialVersionUID = -1138446817700416884L;
    @JsonProperty
    private int match_id;
    @JsonProperty
    public Team home_team;
    @JsonProperty
    public Team away_team;
    @JsonProperty
    public int round;

    @Autowired
    public Match() {

    }

    public Match(Team home_team, Team away_team) {
        this.away_team = away_team;
        this.home_team = home_team;
    }

    public Match(int match_id, Team home_team, Team away_team, int round) {
        this.match_id = match_id;
        this.home_team = home_team;
        this.away_team = away_team;
        this.round = round;
    }

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    public Team getHome_team() {
        return home_team;
    }

    public void setHome_team(Team home_team) {
        this.home_team = home_team;
    }

    public Team getAway_team() {
        return away_team;
    }

    public void setAway_team(Team away_team) {
        this.away_team = away_team;
    }

    @Override
    public String toString() {
        return "new Match Send" +
                " match_id=" + match_id +
                ", home_team=" + home_team.getTeam_id() +
                ", away_team=" + away_team.getTeam_id() +
                ", round=" + round +
                '}';
    }
}
