package com.scrimfinderwq.scrimFinderWQ.models.match;

import com.scrimfinderwq.scrimFinderWQ.models.team.Team;

import java.util.ArrayList;
import java.util.List;

public class MatchContainer {
    public Match CreateMatch (Team home_team,  Team away_team) {
        return new Match(home_team, away_team);
    }
}
