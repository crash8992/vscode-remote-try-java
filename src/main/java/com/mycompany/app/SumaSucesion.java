package com.mycompany.app;

import java.util.Scanner;

public class SumaSucesion {

    public static boolean esPrimo(int num) {
        // Función para verificar si un número es primo
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static double calcularTermino(int n) {
        // Función para calcular el valor del n-ésimo término
        int numerador = 2;
        int denominador = 1;
        double termino = 0;
        boolean suma = true;

        for (int i = 1; i <= n; i++) {
            if (esPrimo(numerador)) {
                termino += (suma ? 1 : -1) * (double) numerador / denominador;
                if (i >= 5 && i % 2 == 1) {
                    termino += (suma ? 1 : -1) * Math.sqrt((double) (numerador + 6) / (denominador + 1));
                }
                suma = !suma;
            }
            numerador += 2;
            denominador++;
        }

        return termino;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el valor de n: ");
        int n = scanner.nextInt();

        double sumaTotal = calcularTermino(n);
        System.out.println("La suma de los " + n + " primeros términos es: " + sumaTotal);
    }
}
