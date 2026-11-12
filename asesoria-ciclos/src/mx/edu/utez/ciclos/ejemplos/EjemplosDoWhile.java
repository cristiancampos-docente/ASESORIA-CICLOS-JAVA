package mx.edu.utez.ciclos.ejemplos;

import mx.edu.utez.ciclos.util.Entrada;

import java.util.Random;
import java.util.Scanner;

/**
 * Ciclo DO-WHILE: ejecuta el cuerpo PRIMERO y evalúa la condición DESPUÉS.
 * Garantiza al menos 1 vuelta.
 *
 *   do {
 *       cuerpo;
 *   } while (condición);   ← lleva punto y coma
 *
 * Se usa cuando la acción debe ocurrir al menos una vez: menús, "¿deseas continuar?", validaciones.
 */
public class EjemplosDoWhile {

    public static void menu(Scanner sc) {
        int opcion;
        do {
            System.out.println();
            System.out.println("----- Ejemplos DO-WHILE -----");
            System.out.println("1. Condición falsa desde el inicio (1 vuelta)");
            System.out.println("2. Validar una opción del 1 al 3");
            System.out.println("3. ¿Deseas continuar? (s/n)");
            System.out.println("4. Adivina el número");
            System.out.println("5. Contar dígitos (versión do-while, funciona con 0)");
            System.out.println("0. Regresar");
            opcion = Entrada.leerEntero(sc, "Opción: ");

            switch (opcion) {
                case 1:
                    unaVueltaGarantizada();
                    break;
                case 2:
                    validarOpcion(sc);
                    break;
                case 3:
                    deseasContinuar(sc);
                    break;
                case 4:
                    adivinaElNumero(sc);
                    break;
                case 5:
                    contarDigitos(sc);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    /** Misma condición que EjemplosWhile.ceroVueltas, pero aquí el cuerpo sí se ejecuta una vez. */
    public static void unaVueltaGarantizada() {
        int saldo = 0;
        int vueltas = 0;
        do {
            System.out.println("Mostrando saldo: $" + saldo);
            vueltas++;
        } while (saldo > 0);
        System.out.println("El do-while dio " + vueltas + " vuelta aunque saldo > 0 era falso.");
    }

    /** Primero se pide el dato y luego se revisa: no hace falta pedirlo antes del ciclo. */
    public static void validarOpcion(Scanner sc) {
        int opcion;
        do {
            opcion = Entrada.leerEntero(sc, "Elige 1, 2 o 3: ");
            if (opcion < 1 || opcion > 3) {
                System.out.println("Opción inválida.");
            }
        } while (opcion < 1 || opcion > 3);
        System.out.println("Elegiste la opción " + opcion);
    }

    /** Strings se comparan con equals / equalsIgnoreCase, nunca con ==. */
    public static void deseasContinuar(Scanner sc) {
        String respuesta;
        int saludos = 0;
        do {
            saludos++;
            System.out.println("¡Hola! (saludo #" + saludos + ")");
            respuesta = Entrada.leerPalabra(sc, "¿Deseas otro saludo? (s/n): ");
        } while (respuesta.equalsIgnoreCase("s"));
        System.out.println("Total de saludos: " + saludos);
    }

    /** Se combina con contador (intentos) y con una pista en cada vuelta. */
    public static void adivinaElNumero(Scanner sc) {
        int secreto = new Random().nextInt(50) + 1;
        int intento;
        int intentos = 0;

        System.out.println("Pensé un número del 1 al 50.");
        do {
            intento = Entrada.leerEnteroEnRango(sc, "Tu intento: ", 1, 50);
            intentos++;
            if (intento < secreto) {
                System.out.println("Es MAYOR.");
            } else if (intento > secreto) {
                System.out.println("Es MENOR.");
            }
        } while (intento != secreto);

        System.out.println("¡Correcto! Era " + secreto + ". Lo lograste en " + intentos + " intento(s).");
    }

    /** Como el cuerpo se ejecuta al menos una vez, el 0 cuenta como 1 dígito sin caso especial. */
    public static void contarDigitos(Scanner sc) {
        int numero = Entrada.leerEntero(sc, "Escribe un número entero: ");
        int copia = Math.abs(numero);
        int digitos = 0;
        do {
            copia = copia / 10;
            digitos++;
        } while (copia > 0);
        System.out.println(numero + " tiene " + digitos + " dígito(s).");
    }
}
