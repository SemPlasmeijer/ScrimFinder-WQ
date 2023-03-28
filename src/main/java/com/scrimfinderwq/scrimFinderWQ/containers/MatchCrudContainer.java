package com.scrimfinderwq.scrimFinderWQ.containers;

import com.scrimfinderwq.scrimFinderWQ.entities.MatchEntity;
import com.scrimfinderwq.scrimFinderWQ.entities.mappers.interfaces.MatchCrud;
import com.scrimfinderwq.scrimFinderWQ.entities.mappers.interfaces.MatchMapper;
import com.scrimfinderwq.scrimFinderWQ.entities.repositories.MatchRepo;
import com.scrimfinderwq.scrimFinderWQ.models.match.Match;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MatchCrudContainer implements MatchCrud {

    @Autowired
    private MatchRepo matchRepo;

    private final MatchMapper matchMapper;

    @Override
    public MatchEntity createMatch(Match match) {
        MatchEntity matchEntity = matchMapper.toMatchEntity(match);
        matchEntity = matchRepo.save(matchEntity);
        return matchEntity;
    }
}
