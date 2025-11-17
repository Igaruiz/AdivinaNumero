package adivinador;

import java.util.Random;    // Importo Random porque lo necesito para generar el número secreto del juego.
                            // Sin esto, Java no puede crear números aleatorios.
import java.util.Scanner;   // Importo Scanner para poder leer lo que el usuario escribe en la consola.
                            // Es la forma en la que el jugador ingresa sus intentos.

public class AdivinaNumero {

    public void iniciar() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        // Acá se genera un número al azar entre 1 y 50. Este es el que hay que adivinar.
        int numeroSecreto = rand.nextInt(50) + 1;

        // La cantidad máxima de intentos que le vamos a dar al jugador.
        int intentosMaximos = 10;

        // Variable donde vamos a guardar lo que el usuario va escribiendo.
        int intento;

        // Esto nos sirve para saber si el jugador adivinó o no al final.
        boolean acertado = false;

        // Mensajitos de bienvenida del juego.
        System.out.println("=== Adivina el Número ===");
        System.out.println("Tenés que adivinar un número entre 1 y 50.");
        System.out.println("Tenés " + intentosMaximos + " intentos.\n");

        // Este for es el corazón del juego: cada vuelta es un intento.
        for (int i = 1; i <= intentosMaximos; i++) {

            // Le pedimos al usuario que escriba un número.
            System.out.print("Intento " + i + ": ");
            intento = sc.nextInt();

            // Comparamos lo que escribió con el número secreto.
            if (intento > numeroSecreto) {
                System.out.println("Muy alto."); 
            } else if (intento < numeroSecreto) {
                System.out.println("Muy bajo."); 
            } else {
               
                System.out.println("\n¡Correcto! El número era " + numeroSecreto);
                acertado = true;
                break; 
            }

            // Aviso de cuántos intentos le quedan.
            System.out.println("Te quedan " + (intentosMaximos - i) + " intentos.\n");
        }

        // Si nunca acertó, sale el número real al final.
        if (!acertado) {
            System.out.println("\nSe te acabaron los intentos.");
            System.out.println("El número correcto era: " + numeroSecreto);
        }
    }
}
