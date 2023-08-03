/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.betplaymvc;


/**
 *
 * @author Harol
 */
// Politecnico Internacional
// Programacion I
// Prof. Harol Torres
// Harol.Torres@pi.edu.co
// Ciclo: 27 de Julio, 2023

import java.util.ArrayList;
import java.util.List;

public class BetPlayController {
    private List<Team> teams;
    private BetPlayView view;

    public BetPlayController() {
        this.teams = new ArrayList<>();
        this.view = new BetPlayView();
    }

    public void addTeam(String name, int matchesPlayed, int matchesLost, int goalsFor, int goalsAgainst) {
        Team team = new Team(name, matchesPlayed, matchesLost, goalsFor, goalsAgainst);
        teams.add(team);
    }

    public void displayTeams() {
        view.displayTeams(teams);
    }
}
