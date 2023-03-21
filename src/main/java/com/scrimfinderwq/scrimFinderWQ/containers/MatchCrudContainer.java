package com.scrimfinderwq.scrimFinderWQ.containers;

import com.scrimfinderwq.scrimFinderWQ.entities.MatchEntity;
import com.scrimfinderwq.scrimFinderWQ.entities.mappers.MatchMapper;
import com.scrimfinderwq.scrimFinderWQ.entities.repositories.MatchRepo;
import com.scrimfinderwq.scrimFinderWQ.models.match.Match;
import org.springframework.beans.factory.annotation.Autowired;

public class MatchCrudContainer {

    @Autowired
    private MatchRepo matchRepo;
    @Autowired
    private MatchMapper matchMapper;

    public MatchEntity createMatch(Match match) {
        MatchEntity matchEntity = matchMapper.toMatchEntity(match);
        matchEntity = matchRepo.save(matchEntity);
        return matchEntity;
    }
}
