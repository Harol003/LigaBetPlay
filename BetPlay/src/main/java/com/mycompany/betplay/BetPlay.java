/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.betplay;

/**
 *
 * @author Harol
 */
// Politecnico Internacional
// Programacion I
// Prof. Harol Torres
// Harol.Torres@pi.edu.co
// Ciclo: 27 de Julio, 2023

import java.util.*;

class Jugador {
    String nombre;
    int edad;

    public Jugador(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return nombre + " (" + edad + " años)";
    }
}

class Equipo {
    String nombre;
    List<Jugador> jugadores;
    int golesAFavor;
    int golesEnContra;
    int partidosJugados;
    int partidosGanados;
    int partidosPerdidos;

    public Equipo(String nombre) {
        this.nombre = nombre;
        jugadores = new ArrayList<>();
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    @Override
    public String toString() {
        return nombre + "\n" +
                "Jugadores: " + jugadores + "\n" +
                "Goles a favor: " + golesAFavor + "\n" +
                "Goles en contra: " + golesEnContra + "\n" +
                "Partidos jugados: " + partidosJugados + "\n" +
                "Partidos ganados: " + partidosGanados + "\n" +
                "Partidos perdidos: " + partidosPerdidos;
    }
}

/**
 *
 * @author Harol
 */
// Politecnico Internacional
// Programacion I
// Prof. Harol Torres
// Harol.Torres@pi.edu.co
// Ciclo: 27 de Julio, 2023


public class BetPlay {

   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Equipo> equipos = new ArrayList<>();

        while (true) {
            System.out.println("¿Qué acción desea realizar?");
            System.out.println("1. Ingresar un nuevo equipo");
            System.out.println("2. Ingresar jugador a un equipo");
            System.out.println("3. Ingresar estadísticas de un equipo");
            System.out.println("4. Mostrar información de los equipos");
            System.out.println("5. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del equipo:");
                    String nombreEquipo = scanner.nextLine();
                    Equipo nuevoEquipo = new Equipo(nombreEquipo);
                    equipos.add(nuevoEquipo);
                    System.out.println("Equipo ingresado correctamente.");
                    break;

                case 2:
                    if (equipos.isEmpty()) {
                        System.out.println("No hay equipos registrados.");
                    } else {
                        System.out.println("Ingrese el nombre del equipo al que desea agregar un jugador:");
                        String nombreEquipoJugador = scanner.nextLine();
                        Equipo equipoJugador = buscarEquipo(nombreEquipoJugador, equipos);
                        if (equipoJugador == null) {
                            System.out.println("Equipo no encontrado.");
                        } else {
                            System.out.println("Ingrese el nombre del jugador:");
                            String nombreJugador = scanner.nextLine();
                            System.out.println("Ingrese la edad del jugador:");
                            int edadJugador = scanner.nextInt();
                            scanner.nextLine();
                            Jugador nuevoJugador = new Jugador(nombreJugador, edadJugador);
                            equipoJugador.agregarJugador(nuevoJugador);
                            System.out.println("Jugador agregado correctamente.");
                        }
                    }
                    break;

                case 3:
                    if (equipos.isEmpty()) {
                        System.out.println("No hay equipos registrados.");
                    } else {
                        System.out.println("Ingrese el nombre del equipo al que desea ingresar estadísticas:");
                        String nombreEquipoEstadisticas = scanner.nextLine();
                        Equipo equipoEstadisticas = buscarEquipo(nombreEquipoEstadisticas, equipos);
                        if (equipoEstadisticas == null) {
                            System.out.println("Equipo no encontrado.");
                        } else {
                            System.out.println("Ingrese los goles a favor:");
                            int golesAFavor = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Ingrese los goles en contra:");
                            int golesEnContra = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Ingrese el número de partidos jugados:");
                            int partidosJugados = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Ingrese el número de partidos ganados:");
                            int partidosGanados = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Ingrese el número de partidos perdidos:");
                            int partidosPerdidos = scanner.nextInt();
                            scanner.nextLine();

                            equipoEstadisticas.golesAFavor = golesAFavor;
                            equipoEstadisticas.golesEnContra = golesEnContra;
                            equipoEstadisticas.partidosJugados = partidosJugados;
                            equipoEstadisticas.partidosGanados = partidosGanados;
                            equipoEstadisticas.partidosPerdidos = partidosPerdidos;
                            System.out.println("Estadísticas ingresadas correctamente.");
                        }
                    }
                    break;

                case 4:
                    if (equipos.isEmpty()) {
                        System.out.println("No hay equipos registrados.");
                    } else {
                        for (Equipo equipo : equipos) {
                            System.out.println(equipo);
                            System.out.println("---------");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Saliendo de la aplicación...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    private static Equipo buscarEquipo(String nombre, List<Equipo> equipos) {
        for (Equipo equipo : equipos) {
            if (equipo.nombre.equalsIgnoreCase(nombre)) {
                return equipo;
            }
        }
        return null;
    }
}
