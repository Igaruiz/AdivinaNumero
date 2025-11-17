package adivinador;

import java.util.Random;
import java.util.Scanner;

public class AdivinaNumero {

    public void iniciar() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int numeroSecreto = rand.nextInt(50) + 1; // número entre 1 y 50
        int intentosMaximos = 10;
        int intento;
        boolean acertado = false;

        System.out.println("=== Adivina el Número ===");
        System.out.println("Tenés que adivinar un número entre 1 y 50.");
        System.out.println("Tenés " + intentosMaximos + " intentos.\n");

        for (int i = 1; i <= intentosMaximos; i++) {
            System.out.print("Intento " + i + ": ");
            intento = sc.nextInt();

            if (intento > numeroSecreto) {
                System.out.println("Muy alto.");
            } else if (intento < numeroSecreto) {
                System.out.println("Muy bajo.");
            } else {
                System.out.println("\n¡Correcto! El número era " + numeroSecreto);
                acertado = true;
                break;
            }

            System.out.println("Te quedan " + (intentosMaximos - i) + " intentos.\n");
        }

        if (!acertado) {
            System.out.println("\nSe te acabaron los intentos.");
            System.out.println("El número correcto era: " + numeroSecreto);
        }
    }
}

