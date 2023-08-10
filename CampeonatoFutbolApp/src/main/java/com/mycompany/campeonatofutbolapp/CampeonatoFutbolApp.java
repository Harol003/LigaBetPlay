/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.campeonatofutbolapp;

/**
 *
 * @author Harol
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class CampeonatoFutbolApp {
    private static final String[] equipos = {"Millonarios", "Santa Fe", "Nacional", "Tolima", "Pasto"};
    private static final Map<String, String[]> estadisticas = new HashMap<>();

    public static void main(String[] args) {
        // Lanzar la interfaz gráfica en el hilo de despacho de eventos
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Liga BetPlay - Futbol Femenino Colombiano 2023");
            frame.setSize(600, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());

            // Crear menú con los equipos y botón de estadísticas generales
            JMenuBar menuBar = new JMenuBar();
            JMenu menuEquipos = new JMenu("Equipos");

            // Agregar opciones de equipo al menú
            for (String equipo : equipos) {
                JMenuItem menuItem = new JMenuItem(equipo);
                menuItem.addActionListener(new EquipoMenuItemListener(equipo, panel));
                menuEquipos.add(menuItem);
            }

            // Agregar opción de estadísticas generales al menú
            JMenuItem menuItemEstadisticasGenerales = new JMenuItem("Estadísticas Generales");
            menuItemEstadisticasGenerales.addActionListener(new EstadisticasGeneralesMenuItemListener(panel));
            menuEquipos.add(menuItemEstadisticasGenerales);

            // Agregar menú al menú bar
            menuBar.add(menuEquipos);

            // Configurar la interfaz
            frame.setJMenuBar(menuBar);
            frame.add(panel, BorderLayout.CENTER);
            frame.setVisible(true);
        });

        // Inicializar simulación de estadísticas
        estadisticas.put("Millonarios", new String[]{"3", "1", "1", "8", "5"});
        estadisticas.put("Santa Fe", new String[]{"2", "2", "1", "6", "7"});
        estadisticas.put("Nacional", new String[]{"4", "0", "0", "12", "3"});
        estadisticas.put("Tolima", new String[]{"1", "3", "1", "5", "9"});
        estadisticas.put("Pasto", new String[]{"0", "4", "1", "3", "10"});
    }

    // Clase interna que maneja la acción de selección de un equipo
    static class EquipoMenuItemListener implements ActionListener {
        private final String equipo;
        private final JPanel panel;

        public EquipoMenuItemListener(String equipo, JPanel panel) {
            this.equipo = equipo;
            this.panel = panel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Limpiar el panel y configurar el diseño
            panel.removeAll();
            panel.setBackground(new Color(0, 0, 128));
            panel.setLayout(new BorderLayout());

            // Crear botón para regresar al menú
            JButton botonRegresar = new JButton("Regresar al Menú");
            botonRegresar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Limpiar el panel y redibujar
                    panel.removeAll();
                    panel.revalidate();
                    panel.repaint();
                }
            });
            panel.add(botonRegresar, BorderLayout.SOUTH);

            // Crear tabla de posiciones
            String[] columnNames = {"Equipo", "PG", "PP", "PE", "GF", "GC", "Puntos"};
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

            JTable table = new JTable(tableModel);
            table.setBackground(Color.WHITE);
            table.setForeground(Color.BLACK);

            // Obtener estadísticas del equipo o "N/A" si no hay información
            String[] stats = estadisticas.getOrDefault(equipo, new String[]{"N/A", "N/A", "N/A", "N/A", "N/A"});
            int partidosGanados = Integer.parseInt(stats[0]);
            int puntos = partidosGanados * 3; // Cada partido ganado da 3 puntos
            tableModel.addRow(new Object[]{equipo, stats[0], stats[1], stats[2], stats[3], stats[4], puntos});

            // Agregar tabla a un JScrollPane y al panel
            JScrollPane scrollPane = new JScrollPane(table);
            panel.add(scrollPane, BorderLayout.CENTER);

            // Redibujar el panel
            panel.revalidate();
            panel.repaint();
        }
    }

    // Clase interna que maneja la acción de estadísticas generales
    static class EstadisticasGeneralesMenuItemListener implements ActionListener {
        private final JPanel panel;

        public EstadisticasGeneralesMenuItemListener(JPanel panel) {
            this.panel = panel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Limpiar el panel y configurar el diseño
            panel.removeAll();
            panel.setBackground(new Color(0, 0, 128));
            panel.setLayout(new BorderLayout());

            // Crear botón para regresar al menú
            JButton botonRegresar = new JButton("Regresar al Menú");
            botonRegresar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Limpiar el panel y redibujar
                    panel.removeAll();
                    panel.revalidate();
                    panel.repaint();
                }
            });
            panel.add(botonRegresar, BorderLayout.SOUTH);

            // Crear tabla de estadísticas generales
            String[] columnNames = {"Equipo", "PG", "PP", "PE", "GF", "GC", "Puntos"};
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

            JTable table = new JTable(tableModel);
            table.setBackground(Color.WHITE);
            table.setForeground(Color.BLACK);

            // Agregar estadísticas de todos los equipos
            for (String equipo : equipos) {
                String[] stats = estadisticas.getOrDefault(equipo, new String[]{"N/A", "N/A", "N/A", "N/A", "N/A"});
                int partidosGanados = Integer.parseInt(stats[0]);
                int puntos = partidosGanados * 3; // Cada partido ganado da 3 puntos
                tableModel.addRow(new Object[]{equipo, stats[0], stats[1], stats[2], stats[3], stats[4], puntos});
            }

            // Agregar tabla a un JScrollPane y al panel
            JScrollPane scrollPane = new JScrollPane(table);
            panel.add(scrollPane, BorderLayout.CENTER);

            // Redibujar el panel
            panel.revalidate();
            panel.repaint();
        }
    }
}
