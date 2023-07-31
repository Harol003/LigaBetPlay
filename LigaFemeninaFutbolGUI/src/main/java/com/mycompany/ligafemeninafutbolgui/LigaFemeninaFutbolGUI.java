/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ligafemeninafutbolgui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Harol
 */
// Politecnico Internacional
// Programacion I
// Prof. Harol Torres
// Harol.Torres@pi.edu.co
// Ciclo: 27 de Julio, 2023
public class LigaFemeninaFutbolGUI extends JFrame {

   private JTextField equipoTextField;
    private JTextField partidosTextField;
    private JButton agregarButton;
    private JLabel resumenLabel;

    private int totalPartidos = 0;

    public LigaFemeninaFutbolGUI() {
        setTitle("Liga Femenina de Fútbol de Colombia");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel formularioPanel = new JPanel(new GridLayout(3, 2));
        formularioPanel.add(new JLabel("Nombre del equipo:"));
        equipoTextField = new JTextField();
        formularioPanel.add(equipoTextField);
        formularioPanel.add(new JLabel("Partidos jugados:"));
        partidosTextField = new JTextField();
        formularioPanel.add(partidosTextField);
        agregarButton = new JButton("Agregar equipo");
        formularioPanel.add(agregarButton);
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String equipo = equipoTextField.getText();
                int partidos = Integer.parseInt(partidosTextField.getText());
                totalPartidos += partidos;
                resumenLabel.setText("Total de partidos jugados: " + totalPartidos);
            }
        });

        resumenLabel = new JLabel("Total de partidos jugados: " + totalPartidos);
        resumenLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(formularioPanel, BorderLayout.CENTER);
        add(resumenLabel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LigaFemeninaFutbolGUI ligaFemeninaFutbolGUI = new LigaFemeninaFutbolGUI();
                ligaFemeninaFutbolGUI.setVisible(true);
            }
        });
    }
    
    
    
    
}
