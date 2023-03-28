package com.scrimfinderwq.scrimFinderWQ.models.tournament;

import com.scrimfinderwq.scrimFinderWQ.entities.TournamentEntity;
import com.scrimfinderwq.scrimFinderWQ.entities.mappers.interfaces.TournamentMapper;
import com.scrimfinderwq.scrimFinderWQ.entities.repositories.TournamentRepo;
import com.scrimfinderwq.scrimFinderWQ.interfaces.TournamentInterface;
import com.scrimfinderwq.scrimFinderWQ.models.match.Match;
import com.scrimfinderwq.scrimFinderWQ.models.team.Team;
import com.scrimfinderwq.scrimFinderWQ.models.workqueues.Producer;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class TournamentContainer implements TournamentInterface {
    private final TournamentMapper tournamentMapper;
    @Autowired
    private TournamentRepo tournamentRepo;
    @Autowired
    private Producer producer;

    @Override
    public Tournament createTournamentMatches(Tournament tournament) {
        //add matches and return it
        TournamentEntity entity = tournamentRepo.save(tournamentMapper.toTournamentEntity(tournament));
        tournament = tournamentMapper.toTournament(entity);

        tournament.setMatches(
                createMatches(getCorrectAmountOfTeamIds(tournament), tournament.getType(), tournament)
        );

        for (Match match : tournament.getMatches()) {
            producer.sendMsg(match);
        }

        return tournament;
    }

    public List<Match> createMatches(List<Integer> team_ids, TournamentTypes type, Tournament tournament) {
        List<Match> matches = new ArrayList<>();
        switch (type) {
            case ROUND_ROBIN:
                /*
                create a copy of this team ids, so we can cycle through one list this list has the first entry removed
                if a tournament has 6 teams the following tournament will be created with x being the key team and the rest of the tournament being 0-5
                Round 0: x-0, 1-4, 2-3
                Round 1: x-1, 0-2, 4-3
                Round 2: x-2, 1-3, 0-4
                Round 3: x-3, 2-4, 1-0
                Round 4: x-4, 3-0, 2-1
                */
                List<Integer> copied_teams = copyListAndRemoveFirstEntry(team_ids);
                int number_of_rounds = (team_ids.size() - 1);        //The amount of rounds is the amount of teams - 1
                int amount_of_matches_per_round = team_ids.size() / 2;   //THe amount matches in each round is half the amount of teams

                for (int round = 0; round < number_of_rounds; round++) {
                    Match firstMatch = calcFirstMatchOfRoundRobin(team_ids, copied_teams, round, new Tournament(tournament.getTournament_id()));
                    if (!skipMatch(firstMatch)) {
                        matches.add(firstMatch);
                    }
                    // the rest of the matches in a round
                    for (int round_match = 1; round_match < amount_of_matches_per_round; round_match++) {
                        Match nextMatch = calcNextMatchOfRoundRobin(copied_teams, round, round_match, new Tournament(tournament.getTournament_id()));
                        if (!skipMatch(nextMatch)) {
                            matches.add(nextMatch);
                        }
                    }
                }
                break;
            case BRACKET:
                // code block
                break;
            case LEAGUE:
                // code block
                break;
        }

        return matches;
    }

    public List<Integer> getCorrectAmountOfTeamIds(Tournament tournament) {
        List<Integer> team_ids = getTeamIds(tournament);
        switch (tournament.getType()) {
            case ROUND_ROBIN:
                if (team_ids.size() % 2 != 0) team_ids.add(-1);
                break;
            case BRACKET:
                // code block
                break;
            case LEAGUE:
                // code block
                break;
        }
        return team_ids;
    }

    public boolean skipMatch(Match match) {
        return ((match.home_team.team_id == -1) || (match.away_team.team_id == -1));
    }

    public List<Integer> getTeamIds(Tournament tournament) {
        List<Integer> teamIds = new ArrayList<>();
        for (Team team_id : tournament.getTeams()) {
            teamIds.add(team_id.team_id);
        }
        return teamIds;
    }

    public List<Integer> copyListAndRemoveFirstEntry(List<Integer> original_teams) {
        original_teams.remove(0);
        return original_teams;
    }

    public Match calcFirstMatchOfRoundRobin(List<Integer> original_teams, List<Integer> copied_teams, int round, Tournament tournament) {
        Team home_team = new Team(original_teams.get(0));

        int away_team_index = round % copied_teams.size();
        Team away_team = new Team(original_teams.get(away_team_index));
        Random rand = new Random();

        return new Match(home_team, away_team, round, tournament);
    }

    public Match calcNextMatchOfRoundRobin(List<Integer> copied_teams, int round, int round_match, Tournament tournament) {
        int home_team_index = (round + copied_teams.size() - round_match) % copied_teams.size();
        int away_team_index = (round + round_match) % copied_teams.size();

        Team home_team = new Team(copied_teams.get(home_team_index));
        Team away_team = new Team(copied_teams.get(away_team_index));

        Random rand = new Random();

        return new Match(home_team, away_team, round, tournament);
    }
}
