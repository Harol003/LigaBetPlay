
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.betplayapp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Harol
 */
// Politecnico Internacional
// Programacion I
// Prof. Harol Torres
// Harol.Torres@pi.edu.co
// Ciclo: 27 de Julio, 2023

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

public class BetPlayApp {
    private List<Equipo> equipos;
    private JFrame frame;
    private JPanel panel;
    private DefaultListModel<String> equiposListModel;
    private JList<String> equiposList;
    private JTextArea infoTextArea;

    public BetPlayApp() {
        equipos = new ArrayList<>();
        frame = new JFrame("BetPlay - Aplicación de Fútbol Femenino");
        panel = new JPanel(new BorderLayout());

        equiposListModel = new DefaultListModel<>();
        equiposList = new JList<>(equiposListModel);
        equiposList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        equiposList.addListSelectionListener(e -> mostrarInformacionEquipo());
        JScrollPane listScrollPane = new JScrollPane(equiposList);
        listScrollPane.setPreferredSize(new Dimension(200, 300));

        infoTextArea = new JTextArea();
        infoTextArea.setEditable(false);
        JScrollPane textScrollPane = new JScrollPane(infoTextArea);

        JButton agregarEquipoButton = new JButton("Agregar Equipo");
        agregarEquipoButton.addActionListener(e -> agregarEquipo());

        JButton agregarJugadorButton = new JButton("Agregar Jugador");
        agregarJugadorButton.addActionListener(e -> agregarJugador());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(agregarEquipoButton);
        buttonPanel.add(agregarJugadorButton);

        panel.add(listScrollPane, BorderLayout.WEST);
        panel.add(textScrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.setContentPane(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void agregarEquipo() {
        String nombreEquipo = JOptionPane.showInputDialog(frame, "Ingrese el nombre del equipo:");
        if (nombreEquipo != null && !nombreEquipo.trim().isEmpty()) {
            Equipo nuevoEquipo = new Equipo(nombreEquipo);
            equipos.add(nuevoEquipo);
            equiposListModel.addElement(nombreEquipo);

            // Agregar goles y partidos para el nuevo equipo
            String golesAFavorStr = JOptionPane.showInputDialog(frame, "Ingrese la cantidad de goles a favor:");
            String golesEnContraStr = JOptionPane.showInputDialog(frame, "Ingrese la cantidad de goles en contra:");
            String partidosJugadosStr = JOptionPane.showInputDialog(frame, "Ingrese la cantidad de partidos jugados:");
            String partidosGanadosStr = JOptionPane.showInputDialog(frame, "Ingrese la cantidad de partidos ganados:");
            String partidosPerdidosStr = JOptionPane.showInputDialog(frame, "Ingrese la cantidad de partidos perdidos:");

            try {
                nuevoEquipo.golesAFavor = Integer.parseInt(golesAFavorStr);
                nuevoEquipo.golesEnContra = Integer.parseInt(golesEnContraStr);
                nuevoEquipo.partidosJugados = Integer.parseInt(partidosJugadosStr);
                nuevoEquipo.partidosGanados = Integer.parseInt(partidosGanadosStr);
                nuevoEquipo.partidosPerdidos = Integer.parseInt(partidosPerdidosStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Ingrese valores numéricos válidos para los goles y partidos.");
            }
        }
    }

    private void agregarJugador() {
        int equipoSeleccionado = equiposList.getSelectedIndex();
        if (equipoSeleccionado != -1) {
            String nombreJugador = JOptionPane.showInputDialog(frame, "Ingrese el nombre del jugador:");
            if (nombreJugador != null && !nombreJugador.trim().isEmpty()) {
                String edadJugadorStr = JOptionPane.showInputDialog(frame, "Ingrese la edad del jugador:");
                try {
                    int edadJugador = Integer.parseInt(edadJugadorStr);
                    Jugador nuevoJugador = new Jugador(nombreJugador, edadJugador);
                    equipos.get(equipoSeleccionado).agregarJugador(nuevoJugador);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "La edad debe ser un número entero.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Seleccione un equipo para agregar un jugador.");
        }
    }

    private void mostrarInformacionEquipo() {
        int equipoSeleccionado = equiposList.getSelectedIndex();
        if (equipoSeleccionado != -1) {
            Equipo equipo = equipos.get(equipoSeleccionado);
            String infoEquipo = equipo.toString() + "\n" +
                    "Goles a favor: " + equipo.golesAFavor + "\n" +
                    "Goles en contra: " + equipo.golesEnContra + "\n" +
                    "Partidos jugados: " + equipo.partidosJugados + "\n" +
                    "Partidos ganados: " + equipo.partidosGanados + "\n" +
                    "Partidos perdidos: " + equipo.partidosPerdidos;

            infoTextArea.setText(infoEquipo);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BetPlayApp::new);
    }
}
