package com.scrimfinderwq.scrimFinderWQ.entities;

import com.scrimfinderwq.scrimFinderWQ.models.tournament.TournamentTypes;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TournamentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tournament_id;
    @OneToMany
    @JoinColumn(name = "tournament_id")
    public List<MatchEntity> matches;
    @ManyToMany
    public List<TeamEntity> teams;
    public TournamentTypes type;
}
