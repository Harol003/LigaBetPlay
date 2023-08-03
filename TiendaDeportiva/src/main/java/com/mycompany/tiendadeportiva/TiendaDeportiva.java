/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tiendadeportiva;

/**
 *
 * @author Harol
 */
// Politecnico Internacional
// Programacion I
// Prof. Harol Torres
// Harol.Torres@pi.edu.co
// Ciclo: 27 de Julio, 2023

import java.util.Scanner;

public class TiendaDeportiva {

 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] modelos;
        double[] precios;
        double precioTotal = 0;

        System.out.println("Bienvenido a la tienda deportiva de bicicletas");

        System.out.print("¿Cuántas bicicletas desea comprar?: ");
        int cantidadBicicletas = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea después de leer la cantidad.

        modelos = new String[cantidadBicicletas];
        precios = new double[cantidadBicicletas];

        for (int i = 0; i < cantidadBicicletas; i++) {
            System.out.print("Ingrese el modelo de la bicicleta " + (i + 1) + ": ");
            modelos[i] = sc.nextLine();

            System.out.print("Ingrese el precio de la bicicleta " + (i + 1) + ": ");
            precios[i] = sc.nextDouble();
            sc.nextLine(); // Consumir el salto de línea después de leer el precio.

            precioTotal += precios[i];
        }

        System.out.println("\nResumen de la compra:");
        System.out.println("----------------------");
        for (int i = 0; i < cantidadBicicletas; i++) {
            System.out.println("Modelo: " + modelos[i] + ", Precio: $" + precios[i]);
        }
        System.out.println("----------------------");
        System.out.println("Precio total de la compra: $" + precioTotal);
        System.out.println("----------------------");
        System.out.println("Gracias por su compra. ¡Vuelva pronto!");
    }
    
    
    
    
    }

