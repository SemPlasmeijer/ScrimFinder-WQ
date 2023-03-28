package com.scrimfinderwq.scrimFinderWQ.entities.mappers.interfaces;

import com.scrimfinderwq.scrimFinderWQ.entities.TeamEntity;
import com.scrimfinderwq.scrimFinderWQ.models.team.Team;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TeamMapper {
    Team toTeam(TeamEntity teamEntity);
    TeamEntity toTeamEntity(Team team);
}

