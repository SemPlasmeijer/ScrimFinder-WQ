package com.scrimfinderwq.scrimFinderWQ.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.scrimfinderwq.scrimFinderWQ.models.team.Team;
import com.scrimfinderwq.scrimFinderWQ.models.tournament.Tournament;
import com.scrimfinderwq.scrimFinderWQ.models.tournament.TournamentTypes;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    public TeamEntity home_team;
    @ManyToOne
    public TeamEntity away_team;

    @ManyToOne
    public TournamentEntity tournament;
    public int round;

}
