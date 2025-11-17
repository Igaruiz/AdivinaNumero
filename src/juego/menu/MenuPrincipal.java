package juego.menu;

import juego.logica.JuegoAdivinanza;
import java.util.Scanner;

public class MenuPrincipal {

    private Scanner scanner;

    public MenuPrincipal() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;

        do {
            System.out.println("=== JUEGO: ADIVINA EL NÚMERO ===");
            System.out.println("1. Jugar");
            System.out.println("2. Salir");
            System.out.print("Elegí una opción: ");
            opcion = leerNumero();

            switch (opcion) {
                case 1:
                    iniciarJuego();
                    break;
                case 2:
                    System.out.println("¡Gracias por jugar!");
                    break;
                default:
                    System.out.println("Opción inválida, probá otra vez.");
            }

            System.out.println();

        } while (opcion != 2);
    }

    private void iniciarJuego() {
        System.out.print("Número máximo del rango: ");
        int max = leerNumero();

        System.out.print("Cantidad de intentos: ");
        int intentos = leerNumero();

        JuegoAdivinanza juego = new JuegoAdivinanza(max, intentos);
        juego.jugar();
    }

    private int leerNumero() {
        while (!scanner.hasNextInt()) {
            System.out.print("Ingresá un número válido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
