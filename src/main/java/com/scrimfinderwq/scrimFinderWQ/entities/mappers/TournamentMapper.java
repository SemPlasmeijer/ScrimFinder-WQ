package com.scrimfinderwq.scrimFinderWQ.entities.mappers;

import com.scrimfinderwq.scrimFinderWQ.entities.TournamentEntity;
import com.scrimfinderwq.scrimFinderWQ.models.tournament.Tournament;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TournamentMapper {
    Tournament toTournament(TournamentEntity tournamentEntity);
    TournamentEntity toTournamentEntity(Tournament tournament);
}

