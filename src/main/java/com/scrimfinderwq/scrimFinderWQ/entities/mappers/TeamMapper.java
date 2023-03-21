package com.scrimfinderwq.scrimFinderWQ.entities.mappers;

import com.scrimfinderwq.scrimFinderWQ.entities.TeamEntity;
import com.scrimfinderwq.scrimFinderWQ.models.team.Team;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeamMapper {
    Team toTeam(TeamEntity teamEntity);
    TeamEntity toTeamEntity(Team team);
}

