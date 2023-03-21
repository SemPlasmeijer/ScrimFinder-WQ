package com.scrimfinderwq.scrimFinderWQ.entities.mappers;

import com.scrimfinderwq.scrimFinderWQ.entities.MatchEntity;
import com.scrimfinderwq.scrimFinderWQ.models.match.Match;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MatchMapper {
    Match toMatch(MatchEntity matchEntity);
    MatchEntity toMatchEntity(Match match);
}

