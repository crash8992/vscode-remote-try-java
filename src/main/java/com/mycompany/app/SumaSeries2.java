package com.mycompany.app;

import java.util.Scanner;

public class SumaSeries2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ingresamos el # de terminos
        System.out.print("Ingrese los números a sumar: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Los números deben ser mayor a 0.");
        } else {
            double suma = 0.0;
            int signo = 1; // Verifica si el término es positivo o negativo
            int contadorPrimos = 0;
            int numero = 2;

            for (int i = 1; i <= n; i++) {
                // Buscar el siguiente número primo
                while (true) {
                    boolean esPrimo = true;
                    for (int j = 2; j <= Math.sqrt(numero); j++) {
                        if (numero % j == 0) {
                            esPrimo = false;
                            break;
                        }
                    }
                    if (esPrimo) {
                        contadorPrimos = numero;
                        numero++;
                        break;
                    }
                    numero++;
                }

                // Calcular los término en la sucesión
                double termino;
                if (i % 4 == 2 || i % 4 == 3) { // Patrón para términos con raíz cuadrada
                    termino = signo * Math.sqrt((double) contadorPrimos / i);
                } else {
                    termino = signo * ((double) contadorPrimos / i);
                }

                // Sumar el término a la sumatoria
                suma += termino;

                // Cambio de signo
                signo *= -1;
            }

            System.out.printf("La sumatoria de los primeros %d términos es: %.5f\n", n, suma);
        }

        scanner.close();
    }
}
