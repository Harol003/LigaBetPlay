/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.campeonatofutbolapp2;

/*
 *
 * @author Harol
 */
// Politecnico Internacional
// Programacion I
// Prof. Harol Torres
// Harol.Torres@pi.edu.co
// Ciclo: 27 de Julio, 2023

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class CampeonatoFutbolApp2 {
    private static final String[] equipos = {"Millonarios", "Santa Fe", "Nacional", "Tolima", "Pasto"};
    private static final Map<String, String[]> estadisticas = new HashMap<>();
    private static final String USUARIO_CORRECTO = "poli";
    private static final String CONTRASENA_CORRECTA = "colombia";

    public static void main(String[] args) {
        // Inicializar simulación de estadísticas
        estadisticas.put("Millonarios", new String[]{"3", "1", "1", "8", "5"});
        estadisticas.put("Santa Fe", new String[]{"2", "2", "1", "6", "7"});
        estadisticas.put("Nacional", new String[]{"4", "0", "0", "12", "3"});
        estadisticas.put("Tolima", new String[]{"1", "3", "1", "5", "9"});
        estadisticas.put("Pasto", new String[]{"0", "4", "1", "3", "10"});

        // Interfaz de autenticación de usuario
        SwingUtilities.invokeLater(() -> {
            JFrame authFrame = new JFrame("Autenticación");
            authFrame.setSize(300, 150);
            authFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel authPanel = new JPanel();
            authPanel.setLayout(new GridLayout(3, 2));

            JLabel userLabel = new JLabel("Usuario:");
            JTextField userField = new JTextField();

            JLabel passLabel = new JLabel("Contraseña:");
            JPasswordField passField = new JPasswordField();

            JButton loginButton = new JButton("Iniciar Sesión");
            loginButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String usuario = userField.getText();
                    String contrasena = new String(passField.getPassword());

                    if (usuario.equals(USUARIO_CORRECTO) && contrasena.equals(CONTRASENA_CORRECTA)) {
                        authFrame.dispose(); // Cerrar ventana de autenticación
                        mostrarInterfazPrincipal();
                    } else {
                        JOptionPane.showMessageDialog(authFrame, "Usuario o contraseña incorrectos", "Error de Autenticación", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            authPanel.add(userLabel);
            authPanel.add(userField);
            authPanel.add(passLabel);
            authPanel.add(passField);
            authPanel.add(new JLabel()); // Espacio en blanco
            authPanel.add(loginButton);

            authFrame.add(authPanel);
            authFrame.setVisible(true);
        });
    }

    private static void mostrarInterfazPrincipal() {
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
            table.setForeground(Color.WHITE); // Letras en color blanco

            // Obtener estadísticas del equipo o "N/A" si no hay información
            String[] stats = estadisticas.getOrDefault(equipo, new String[]{"N/A", "N/A", "N/A", "N/A", "N/A"});
            int partidosGanados = Integer.parseInt(stats[0]);
            int puntos = partidosGanados * 3; // Cada partido ganado da 3 puntos
            tableModel.addRow(new Object[]{equipo, stats[0], stats[1], stats[2], stats[3], stats[4], puntos});

            // Configurar color de fondo de acuerdo al equipo
            if (equipo.equals("Santa Fe")) {
                table.setBackground(Color.RED);
            } else if (equipo.equals("Nacional")) {
                table.setBackground(Color.GREEN);
            } else if (equipo.equals("Millonarios")) {
                table.setBackground(Color.BLUE);
            } else if (equipo.equals("Pasto")) {
                table.setBackground(new Color(139, 69, 19)); // Color café
            } else if (equipo.equals("Tolima")) {
                table.setBackground(Color.BLACK); // Color negro
            } else {
                table.setBackground(Color.WHITE);
            }

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
            table.setForeground(Color.WHITE); // Letras en color blanco

            // Agregar estadísticas de todos los equipos
            for (String equipo : equipos) {
                String[] stats = estadisticas.getOrDefault(equipo, new String[]{"N/A", "N/A", "N/A", "N/A", "N/A"});
                int partidosGanados = Integer.parseInt(stats[0]);
                int puntos = partidosGanados * 3; // Cada partido ganado da 3 puntos
                tableModel.addRow(new Object[]{equipo, stats[0], stats[1], stats[2], stats[3], stats[4], puntos});
            }

            // Configurar colores de fondo
            table.setBackground(new Color(30, 30, 30)); // Color oscuro
            panel.setBackground(new Color(0, 0, 128)); // Color azul

            // Agregar tabla a un JScrollPane y al panel
            JScrollPane scrollPane = new JScrollPane(table);
            panel.add(scrollPane, BorderLayout.CENTER);

            // Redibujar el panel
            panel.revalidate();
            panel.repaint();
        }
    }
}
