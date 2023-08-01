/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.betplaylistabs;

/**
 *
 * @author Harol
 */

import java.util.ArrayList;

// Clase abstracta Grupo que define la estructura común de todos los grupos
abstract class Grupo {
    private String nombre;
    private ArrayList<String> equipos;

    // Constructor de la clase Grupo que recibe el nombre del grupo y la lista de equipos
    public Grupo(String nombre, ArrayList<String> equipos) {
        this.nombre = nombre;
        this.equipos = equipos;
    }

    // Método para obtener el nombre del grupo
    public String getNombre() {
        return nombre;
    }

    // Método para obtener la lista de equipos del grupo
    public ArrayList<String> getEquipos() {
        return equipos;
    }

    // Método abstracto para mostrar la información del grupo (debe ser implementado en las clases hijas)
    public abstract void mostrarInformacion();
}

// Clase GrupoA que extiende la clase abstracta Grupo
class GrupoA extends Grupo {
    // Constructor de la clase GrupoA que llama al constructor de la clase padre y establece el nombre del grupo
    public GrupoA(ArrayList<String> equipos) {
        super("Grupo A", equipos);
    }

    // Implementación del método abstracto para mostrar la información del grupo A
    @Override
    public void mostrarInformacion() {
        System.out.println("Grupo A: " + String.join(", ", getEquipos()));
    }
}

// Clase GrupoB que extiende la clase abstracta Grupo
class GrupoB extends Grupo {
    // Constructor de la clase GrupoB que llama al constructor de la clase padre y establece el nombre del grupo
    public GrupoB(ArrayList<String> equipos) {
        super("Grupo B", equipos);
    }

    // Implementación del método abstracto para mostrar la información del grupo B
    @Override
    public void mostrarInformacion() {
        System.out.println("Grupo B: " + String.join(", ", getEquipos()));
    }
}

// Repetir el patrón anterior para definir las clases para los demás grupos (GrupoC, GrupoD, ..., GrupoH).
// Cada clase debe extender la clase abstracta Grupo y proporcionar una implementación del método mostrarInformacion().

public class BetPlayListAbs {
    public static void main(String[] args) {
        // Crear los equipos para cada grupo
        ArrayList<String> grupoAEquipos = new ArrayList<>();
        grupoAEquipos.add("Nueva Zelanda");
        grupoAEquipos.add("Noruega");
        grupoAEquipos.add("Filipinas");
        grupoAEquipos.add("Suiza");

        ArrayList<String> grupoBEquipos = new ArrayList<>();
        grupoBEquipos.add("Australia");
        grupoBEquipos.add("República de Irlanda");
        grupoBEquipos.add("Nigeria");
        grupoBEquipos.add("Canadá");

        // Crear instancias de los grupos
        GrupoA grupoA = new GrupoA(grupoAEquipos);
        GrupoB grupoB = new GrupoB(grupoBEquipos);
        // Crear instancias para los demás grupos (grupoC, ..., grupoH).

        // Mostrar la información de los grupos en pantalla
        grupoA.mostrarInformacion();
        grupoB.mostrarInformacion();
        // Mostrar la información para los demás grupos (grupoC.mostrarInformacion(), ..., grupoH.mostrarInformacion()).
    }
}