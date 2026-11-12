package mx.edu.utez.ciclos.ejemplos;

import mx.edu.utez.ciclos.util.Entrada;

import java.util.Scanner;

/**
 * Ciclo FOR: junta inicialización, condición y actualización en una sola línea.
 *
 *   for (inicialización; condición; actualización) {
 *       cuerpo;
 *   }
 *
 * Orden de ejecución:
 *   1) inicialización (solo una vez)
 *   2) condición → si es falsa, termina
 *   3) cuerpo
 *   4) actualización → regresa al paso 2
 *
 * Se usa cuando SÍ sabemos (o podemos calcular) cuántas vueltas habrá.
 */
public class EjemplosFor {

    public static void menu(Scanner sc) {
        int opcion;
        do {
            System.out.println();
            System.out.println("----- Ejemplos FOR -----");
            System.out.println("1. Contar del 1 al 10");
            System.out.println("2. Contar de 10 a 1 (descendente)");
            System.out.println("3. Números pares del 2 al 20 (incremento de 2)");
            System.out.println("4. Suma del 1 al 100 (acumulador)");
            System.out.println("5. Tabla de multiplicar");
            System.out.println("6. Factorial");
            System.out.println("7. Recorrer las letras de una palabra");
            System.out.println("8. Ciclos anidados: tablas del 1 al 5");
            System.out.println("9. Ciclos anidados: triángulo de asteriscos");
            System.out.println("10. break y continue");
            System.out.println("11. El mismo conteo con for y con while (equivalencia)");
            System.out.println("0. Regresar");
            opcion = Entrada.leerEntero(sc, "Opción: ");

            switch (opcion) {
                case 1:
                    contarDel1Al10();
                    break;
                case 2:
                    contarDescendente();
                    break;
                case 3:
                    paresDel2Al20();
                    break;
                case 4:
                    sumaDel1Al100();
                    break;
                case 5:
                    tablaDeMultiplicar(sc);
                    break;
                case 6:
                    factorial(sc);
                    break;
                case 7:
                    recorrerPalabra(sc);
                    break;
                case 8:
                    tablasDel1Al5();
                    break;
                case 9:
                    trianguloAsteriscos(sc);
                    break;
                case 10:
                    breakYContinue();
                    break;
                case 11:
                    equivalenciaForWhile();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    public static void contarDel1Al10() {
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        // La variable i solo existe dentro del for: aquí ya no se puede usar.
    }

    public static void contarDescendente() {
        for (int i = 10; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void paresDel2Al20() {
        for (int i = 2; i <= 20; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /** Acumulador: se inicializa en 0 antes del ciclo y se le suma en cada vuelta. */
    public static void sumaDel1Al100() {
        int suma = 0;
        for (int i = 1; i <= 100; i++) {
            suma += i;
        }
        System.out.println("La suma del 1 al 100 es " + suma);
    }

    public static void tablaDeMultiplicar(Scanner sc) {
        int n = Entrada.leerEntero(sc, "¿Qué tabla quieres? ");
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }
    }

    /** Acumulador de producto: se inicializa en 1 (si fuera 0, todo daría 0). */
    public static void factorial(Scanner sc) {
        int n = Entrada.leerEnteroEnRango(sc, "Número (0-20): ", 0, 20);
        long resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        System.out.println(n + "! = " + resultado);
    }

    /** Las posiciones de un String van de 0 a length() - 1, por eso la condición es i < length(). */
    public static void recorrerPalabra(Scanner sc) {
        String palabra = Entrada.leerPalabra(sc, "Escribe una palabra: ");
        int vocales = 0;

        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            System.out.println("Posición " + i + ": " + letra);
            if ("aeiouáéíóúAEIOUÁÉÍÓÚ".indexOf(letra) >= 0) {
                vocales++;
            }
        }
        System.out.println("La palabra tiene " + vocales + " vocal(es).");
    }

    /** Ciclo anidado: por cada vuelta del externo, el interno da TODAS sus vueltas (5 x 10 = 50). */
    public static void tablasDel1Al5() {
        for (int tabla = 1; tabla <= 5; tabla++) {
            System.out.println("Tabla del " + tabla + ":");
            for (int i = 1; i <= 10; i++) {
                System.out.print(tabla * i + "\t");
            }
            System.out.println();
        }
    }

    /** El interno depende del externo: en la fila 1 imprime 1 asterisco, en la fila 2 imprime 2... */
    public static void trianguloAsteriscos(Scanner sc) {
        int altura = Entrada.leerEnteroEnRango(sc, "Altura (1-15): ", 1, 15);
        for (int fila = 1; fila <= altura; fila++) {
            for (int col = 1; col <= fila; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    /**
     * continue: salta al SIGUIENTE ciclo (se brinca el resto del cuerpo).
     * break: termina el ciclo por completo.
     */
    public static void breakYContinue() {
        System.out.println("Del 1 al 15 saltando múltiplos de 3 (continue):");
        for (int i = 1; i <= 15; i++) {
            if (i % 3 == 0) {
                continue;
            }
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("Buscar el primer múltiplo de 7 mayor a 50 (break):");
        for (int i = 51; i <= 100; i++) {
            if (i % 7 == 0) {
                System.out.println("Encontrado: " + i);
                break;
            }
        }
    }

    /** Todo for se puede escribir como while: las mismas 3 partes, en otro lugar. */
    public static void equivalenciaForWhile() {
        System.out.print("for:   ");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.print("while: ");
        int i = 1;
        while (i <= 5) {
            System.out.print(i + " ");
            i++;
        }
        System.out.println();
    }
}
