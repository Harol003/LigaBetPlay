/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.betplaymvc;
import java.util.List;
/**
 *
 * @author Harol
 */
public class BetPlayView {
    public void displayTeams(List<Team> teams) {
        
        System.out.println("------------------------------------------------------------------");
        System.out.println("LIGA DE FUTBOL FEMENINO 2023 | BETPLAY COLOMBIA | POLITECNICO INTERNACIONAL");
        System.out.println("------------------------------------------------------------------");
        System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s |%n", 
            "Equipo", "Partidos Jugados", "Partidos Perdidos", "Goles a Favor", "Goles en Contra");
        System.out.println("------------------------------------------------------------------");
        
        for (Team team : teams) {
            System.out.printf("| %-15s | %-15d | %-17d | %-13d | %-16d |%n",
                team.getName(), team.getMatchesPlayed(), team.getMatchesLost(),
                team.getGoalsFor(), team.getGoalsAgainst());
        }
        System.out.println("------------------------------------------------------------------");
        System.out.println("Prof. Harol H. Torres | Harol.Torres@pi.edu.co");
         System.out.println("------------------------------------------------------------------");
    }
        
        
        
    }

