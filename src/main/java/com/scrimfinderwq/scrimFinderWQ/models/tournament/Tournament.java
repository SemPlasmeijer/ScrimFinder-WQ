package com.scrimfinderwq.scrimFinderWQ.models.tournament;

import com.scrimfinderwq.scrimFinderWQ.models.match.Match;
import com.scrimfinderwq.scrimFinderWQ.models.team.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class Tournament {
    public int tournament_id;
    public List<Match> matches;
    public List<Team> teams;
    public TournamentTypes type;

    @Autowired
    public Tournament(){

    }

    public Tournament(int tournament_id, List<Match> matches, List<Team> teams, TournamentTypes type) {
        this.tournament_id = tournament_id;
        this.matches = matches;
        this.teams = teams;
        this.type = type;
    }

    public Tournament(List<Team> teams, TournamentTypes type) {
        this.teams = teams;
        this.type = type;
    }

    public int getTournament_id() {
        return tournament_id;
    }

    public void setTournament_id(int tournament_id) {
        this.tournament_id = tournament_id;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public TournamentTypes getType() {
        return type;
    }

    public void setType(TournamentTypes type) {
        this.type = type;
    }
}
