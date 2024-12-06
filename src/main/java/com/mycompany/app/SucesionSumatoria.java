package com.mycompany.app;

import java.util.Scanner;

public class SucesionSumatoria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar el número de términos al usuario
        System.out.print("Ingrese el número de términos a sumar: ");
        int n = scanner.nextInt();
        
        if (n <= 0) {
            System.out.println("El número de términos debe ser mayor a 0.");
        } else {
            double suma = calcularSumatoria(n);
            System.out.printf("La sumatoria de los primeros %d términos es: %.5f\n", n, suma);
        }
        
        scanner.close(); // Cerrar el scanner
    }

    public static double calcularSumatoria(int n) {
        double suma = 0.0;
        int signo = 1; // Inicia con signo positivo
        int[] primos = generarPrimos(n);
        
        for (int i = 0; i < n; i++) {
            int numerador = primos[i];
            int denominador = i + 1;
            
            if (i % 4 == 1 || i % 4 == 2) { // Patrón para raíz cuadrada en ciertos términos
                suma += signo * Math.sqrt((double) numerador / denominador);
            } else {
                suma += signo * ((double) numerador / denominador);
            }
            
            signo *= -1; // Alternar signo
        }
        
        return suma;
    }

    // Función para generar los primeros n números primos
    public static int[] generarPrimos(int n) {
        int[] primos = new int[n];
        int contador = 0;
        int numero = 2;
        
        while (contador < n) {
            if (esPrimo(numero)) {
                primos[contador++] = numero;
            }
            numero++;
        }
        return primos;
    }

    // Función para verificar si un número es primo
    public static boolean esPrimo(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
