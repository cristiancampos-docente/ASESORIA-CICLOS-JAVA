package mx.edu.utez.ciclos.util;

import java.util.Scanner;

/**
 * Lectura segura de datos para los ejemplos.
 * Internamente también usa ciclos while: repite la pregunta hasta recibir un dato válido.
 */
public class Entrada {

    private Entrada() {
    }

    /** Pide un entero; si el usuario escribe texto, lo descarta y vuelve a preguntar. */
    public static int leerEntero(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextInt()) {
            System.out.print("Eso no es un número entero. " + mensaje);
            sc.next();
        }
        return sc.nextInt();
    }

    /** Pide un entero y repite mientras esté fuera de [min, max]. */
    public static int leerEnteroEnRango(Scanner sc, String mensaje, int min, int max) {
        int valor = leerEntero(sc, mensaje);
        while (valor < min || valor > max) {
            System.out.println("Debe estar entre " + min + " y " + max + ".");
            valor = leerEntero(sc, mensaje);
        }
        return valor;
    }

    /** Lee una sola palabra (sin espacios). */
    public static String leerPalabra(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        return sc.next();
    }
}
