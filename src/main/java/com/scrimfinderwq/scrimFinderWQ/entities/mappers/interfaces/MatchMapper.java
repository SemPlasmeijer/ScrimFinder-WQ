package com.scrimfinderwq.scrimFinderWQ.entities.mappers.interfaces;

import com.scrimfinderwq.scrimFinderWQ.entities.MatchEntity;
import com.scrimfinderwq.scrimFinderWQ.models.match.Match;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MatchMapper {
    MatchMapper INSTANCE = Mappers.getMapper(MatchMapper.class);

    Match toMatch(MatchEntity matchEntity);
    MatchEntity toMatchEntity(Match match);
}

