package com.scrimfinderwq.scrimFinderWQ.entities.mappers.interfaces;

import com.scrimfinderwq.scrimFinderWQ.entities.MatchEntity;
import com.scrimfinderwq.scrimFinderWQ.models.match.Match;

public interface MatchCrud {
    MatchEntity createMatch(Match match);
}
