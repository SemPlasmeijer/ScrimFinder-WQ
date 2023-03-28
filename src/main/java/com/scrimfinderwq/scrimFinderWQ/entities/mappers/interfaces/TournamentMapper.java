package com.scrimfinderwq.scrimFinderWQ.entities.mappers.interfaces;

import com.scrimfinderwq.scrimFinderWQ.entities.TournamentEntity;
import com.scrimfinderwq.scrimFinderWQ.models.tournament.Tournament;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TournamentMapper {
    TournamentMapper INSTANCE = Mappers.getMapper(TournamentMapper.class);
    Tournament toTournament(TournamentEntity tournamentEntity);
    TournamentEntity toTournamentEntity(Tournament tournament);
}

