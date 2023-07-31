/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.betplaymvc;

/**
 *
 * @author Harol
 */
public class Team {
    private String name;
    private int matchesPlayed;
    private int matchesLost;
    private int goalsFor;
    private int goalsAgainst;

    public Team(String name, int matchesPlayed, int matchesLost, int goalsFor, int goalsAgainst) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.matchesLost = matchesLost;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
}
    
    // Getters
    public String getName() {
        return name;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public int getMatchesLost() {
        return matchesLost;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    // Setters (Optional, only if you need to update the attributes)
    public void setName(String name) {
        this.name = name;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public void setMatchesLost(int matchesLost) {
        this.matchesLost = matchesLost;
    }

    public void setGoalsFor(int goalsFor) {
        this.goalsFor = goalsFor;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    
}