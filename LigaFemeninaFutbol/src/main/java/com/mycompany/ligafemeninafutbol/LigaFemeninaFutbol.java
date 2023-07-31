/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ligafemeninafutbol;

import java.util.Scanner;
/**
 *
 * @author Harol
 */
// Politecnico Internacional
// Programacion I
// Prof. Harol Torres
// Harol.Torres@pi.edu.co
// Ciclo: 27 de Julio, 2023
public class LigaFemeninaFutbol {

        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] equipos;
        int[] partidosJugados;
        int totalPartidos = 0;

        System.out.println("Bienvenido a la Liga Femenina de Fútbol de Colombia");

        System.out.print("¿Cuántos equipos desea ingresar?: ");
        int cantidadEquipos = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea después de leer la cantidad.

        equipos = new String[cantidadEquipos];
        partidosJugados = new int[cantidadEquipos];

        for (int i = 0; i < cantidadEquipos; i++) {
            System.out.print("Ingrese el nombre del equipo " + (i + 1) + ": ");
            equipos[i] = sc.nextLine();

            System.out.print("Ingrese la cantidad de partidos jugados por el equipo " + (i + 1) + ": ");
            partidosJugados[i] = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea después de leer la cantidad.

            totalPartidos += partidosJugados[i];
        }

        System.out.println("\nResumen de la Liga Femenina de Fútbol de Colombia:");
        System.out.println("----------------------");
        for (int i = 0; i < cantidadEquipos; i++) {
            System.out.println("Equipo: " + equipos[i] + ", Partidos jugados: " + partidosJugados[i]);
        }
        System.out.println("----------------------");
        System.out.println("Total de partidos jugados en la liga: " + totalPartidos);
        System.out.println("----------------------");
        System.out.println("¡Gracias por participar en la Liga Femenina de Fútbol!");
    }
}
