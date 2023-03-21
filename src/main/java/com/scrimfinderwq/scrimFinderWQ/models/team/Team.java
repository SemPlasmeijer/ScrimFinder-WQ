package com.scrimfinderwq.scrimFinderWQ.models.team;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Team {
    public int team_id;
    public String name;

    public Team(int team_id) {
        this.team_id = team_id;
    }
}
