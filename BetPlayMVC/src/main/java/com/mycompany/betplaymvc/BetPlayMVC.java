/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.betplaymvc;

/**
 *
 * @author Harol
 */
public class BetPlayMVC {

    public static void main(String[] args) {
       BetPlayController controller = new BetPlayController();

        // Agregar equipos
        controller.addTeam("SantaFe", 10, 2, 10, 5);
        controller.addTeam("Millonarios", 10, 1, 8, 3);
        controller.addTeam("Nacional", 10, 4, 7, 9);

        // Mostrar información en pantalla
        controller.displayTeams();
    }
}
