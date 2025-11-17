package juego.logica;

import java.util.Random;
import java.util.Scanner;

public class JuegoAdivinanza {

    private int numeroSecreto;
    private int intentosPermitidos;
    private int maximo;
    private Scanner scanner;

    public JuegoAdivinanza(int max, int intentos) {
        if (max < 1) max = 50;
        if (intentos < 1) intentos = 10;

        this.maximo = max;
        this.intentosPermitidos = intentos;

        Random random = new Random();
        this.numeroSecreto = random.nextInt(maximo) + 1;

        scanner = new Scanner(System.in);
    }

    public void jugar() {
        System.out.println("\n--- Arranca el juego ---");
        System.out.println("Adiviná un número entre 1 y " + maximo + ".");
        System.out.println("Tenés " + intentosPermitidos + " intentos.\n");

        for (int i = 1; i <= intentosPermitidos; i++) {
            System.out.print("Intento " + i + ": ");
            int intento = leerNumero();

            if (intento == numeroSecreto) {
                System.out.println("\n¡Acertaste! El número era " + numeroSecreto + ".");
                return;
            } else if (intento < numeroSecreto) {
                System.out.println("El número es más ALTO.");
            } else {
                System.out.println("El número es más BAJO.");
            }
        }

        System.out.println("\nNo te quedaron intentos.");
        System.out.println("El número era: " + numeroSecreto);
        System.out.println("¡La próxima sale!\n");
    }

    private int leerNumero() {
        while (!scanner.hasNextInt()) {
            System.out.print("Ingresá un número válido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
