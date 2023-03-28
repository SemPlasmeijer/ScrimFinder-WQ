package com.scrimfinderwq.scrimFinderWQ.models.team;

import com.scrimfinderwq.scrimFinderWQ.entities.TeamEntity;
import com.scrimfinderwq.scrimFinderWQ.entities.mappers.interfaces.TeamMapper;
import com.scrimfinderwq.scrimFinderWQ.entities.mappers.interfaces.TournamentMapper;
import com.scrimfinderwq.scrimFinderWQ.entities.repositories.TeamRepo;
import com.scrimfinderwq.scrimFinderWQ.interfaces.TeamInterface;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TeamContainer implements TeamInterface {
    private final TeamMapper teamMapper;

    @Autowired
    private TeamRepo teamRepo;

    @Override
    public List<Team> createMultipleTeams(List<Team> teams) {
        List<Team> saved_teams = new ArrayList<>();
        for (Team team: teams) {
            TeamEntity entity = teamRepo.save(teamMapper.toTeamEntity(team));

            saved_teams.add(teamMapper.toTeam(entity));
        }
        return saved_teams;
    }
}
