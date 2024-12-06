package com.mycompany.app;

import java.util.Scanner;

public class SumatoriaSeries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Ingreso del # de terminos a sumar
        System.out.print("Ingrese el número de términos a sumar: ");
        int n = scanner.nextInt();
        
        if (n <= 0) {
            System.out.println("El número de términos debe ser mayor a 0.");
        } else {
            double suma = calcularSumatoria(n);
            System.out.printf("La sumatoria de los primeros %d términos es: %.5f\n", n, suma);
        }
        
        scanner.close(); 
    }

    public static double calcularSumatoria(int n) {
        double suma = 0.0;
        int signo = 1; // Se debe iniciar con signo positivo
        int[] primos = generarPrimos(n);
        
        for (int i = 0; i < n; i++) {
            int numerador = primos[i];
            int denominador = i + 1;
            
            if (i % 4 == 1 || i % 4 == 2) { // Definimos la raíz cuadrada
                suma += signo * Math.sqrt((double) numerador / denominador);
            } else {
                suma += signo * ((double) numerador / denominador);
            }
            
            signo *= -1; // Cambiamos signo para evitar errores
        }
        
        return suma;
    }

    // Generamos los # primos 
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

    // Para verificar si el # es primo
    public static boolean esPrimo(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
