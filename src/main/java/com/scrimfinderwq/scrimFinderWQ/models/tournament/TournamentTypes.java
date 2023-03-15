package com.scrimfinderwq.scrimFinderWQ.models.tournament;

public enum TournamentTypes {
    ROUND_ROBIN(1),
    BRACKET(2),
    LEAGUE(3);

    private final int id;

    TournamentTypes(int id) {
        this.id = id;
    }
}
