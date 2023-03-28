package com.scrimfinderwq.scrimFinderWQ.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.scrimfinderwq.scrimFinderWQ.models.team.Team;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long team_id;
    @Column(unique = true)
    public String name;

}
