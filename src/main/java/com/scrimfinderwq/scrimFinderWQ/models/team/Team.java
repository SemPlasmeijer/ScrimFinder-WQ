package com.scrimfinderwq.scrimFinderWQ.models.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Team {
    public int team_id;
    public String name;

    @Autowired
    public Team(){

    }
    public Team(int team_id, String name) {
        this.team_id = team_id;
        this.name = name;
    }

    public Team(int team_id) {
        this.team_id = team_id;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
