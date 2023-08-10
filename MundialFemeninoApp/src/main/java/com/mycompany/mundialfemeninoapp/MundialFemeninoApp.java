/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mundialfemeninoapp;

/**
 *
 * @author Harol
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MundialFemeninoApp {
    public static void main(String[] args) {
        // Crear una instancia de JFrame
        JFrame frame = new JFrame("Registro de Jugadoras - Mundial Femenino");

        // Configurar el tamaño de la ventana
        frame.setSize(300, 200);

        // Configurar la operación por defecto al cerrar la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear un panel para organizar los componentes con GridLayout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10)); // Filas, Columnas, Espacio horizontal y vertical

        // Crear etiquetas y campos de texto
        JLabel etiquetaNombre = new JLabel("Nombre:");
        JTextField campoNombre = new JTextField();

        JLabel etiquetaEdad = new JLabel("Edad:");
        JTextField campoEdad = new JTextField();

        // Crear botón para agregar jugador
        JButton botonAgregar = new JButton("Agregar Jugador");

        // Agregar etiquetas y campos al panel
        panel.add(etiquetaNombre);
        panel.add(campoNombre);
        panel.add(etiquetaEdad);
        panel.add(campoEdad);
        panel.add(new JLabel()); // Celda vacía para alinear el botón
        panel.add(botonAgregar);

        // Agregar el panel al centro de la ventana
        frame.add(panel, BorderLayout.CENTER);

        // Mostrar la ventana en la pantalla
        frame.setVisible(true);

        // Acción del botón para agregar jugador
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = campoNombre.getText();
                String edad = campoEdad.getText();

                JOptionPane.showMessageDialog(frame,
                        "Se ha registrado a " + nombre + " de " + edad + " años.",
                        "Jugadora Registrada", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
