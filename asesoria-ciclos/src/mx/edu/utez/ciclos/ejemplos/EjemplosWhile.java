package mx.edu.utez.ciclos.ejemplos;

import mx.edu.utez.ciclos.util.Entrada;

import java.util.Scanner;

/**
 * Ciclo WHILE: evalúa la condición ANTES de cada vuelta.
 * Si la condición es falsa desde el inicio, el cuerpo se ejecuta 0 veces.
 *
 *   inicialización;
 *   while (condición) {
 *       cuerpo;
 *       actualización;
 *   }
 *
 * Se usa cuando NO sabemos cuántas vueltas habrá (depende de un dato o del usuario).
 */
public class EjemplosWhile {

    public static void menu(Scanner sc) {
        int opcion;
        do {
            System.out.println();
            System.out.println("----- Ejemplos WHILE -----");
            System.out.println("1. Contar del 1 al 10 (contador)");
            System.out.println("2. Cuenta regresiva");
            System.out.println("3. Condición falsa desde el inicio (0 vueltas)");
            System.out.println("4. Contar los dígitos de un número");
            System.out.println("5. Sumar números hasta capturar 0 (centinela + acumulador)");
            System.out.println("6. Validar una edad (repetir hasta que sea válida)");
            System.out.println("7. Ahorro: ¿cuántos meses para llegar a la meta?");
            System.out.println("0. Regresar");
            opcion = Entrada.leerEntero(sc, "Opción: ");

            switch (opcion) {
                case 1:
                    contarDel1Al10();
                    break;
                case 2:
                    cuentaRegresiva();
                    break;
                case 3:
                    ceroVueltas();
                    break;
                case 4:
                    contarDigitos(sc);
                    break;
                case 5:
                    sumarHastaCero(sc);
                    break;
                case 6:
                    validarEdad(sc);
                    break;
                case 7:
                    mesesParaAhorrar(sc);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    /** Los 3 elementos de todo ciclo: inicialización, condición y actualización. */
    public static void contarDel1Al10() {
        int i = 1;                    // 1) inicialización
        while (i <= 10) {             // 2) condición
            System.out.print(i + " ");
            i++;                      // 3) actualización: sin ella el ciclo sería infinito
        }
        System.out.println();
        System.out.println("Al salir del ciclo, i vale " + i + " (la condición i <= 10 ya fue falsa).");
    }

    public static void cuentaRegresiva() {
        int segundos = 5;
        while (segundos > 0) {
            System.out.println(segundos + "...");
            segundos--;
        }
        System.out.println("¡Despegue!");
    }

    /** Diferencia clave contra do-while: aquí el cuerpo puede NO ejecutarse nunca. */
    public static void ceroVueltas() {
        int saldo = 0;
        int vueltas = 0;
        while (saldo > 0) {
            System.out.println("Retirando $100...");
            saldo -= 100;
            vueltas++;
        }
        System.out.println("El while dio " + vueltas + " vueltas: saldo > 0 fue falso desde el inicio.");
    }

    /** No sabemos cuántas vueltas habrá: depende del tamaño del número. */
    public static void contarDigitos(Scanner sc) {
        int numero = Entrada.leerEntero(sc, "Escribe un número entero: ");
        int copia = Math.abs(numero);
        int digitos = 0;

        while (copia > 0) {
            copia = copia / 10;      // quita el último dígito
            digitos++;
        }

        // Con 0 el while no entra; la versión do-while de EjemplosDoWhile no tiene este problema.
        if (numero == 0) {
            digitos = 1;
        }
        System.out.println(numero + " tiene " + digitos + " dígito(s).");
    }

    /**
     * Centinela: un valor especial (0) indica cuándo detenerse.
     * Acumulador: la suma se inicializa en 0 FUERA del ciclo.
     */
    public static void sumarHastaCero(Scanner sc) {
        int suma = 0;
        int cantidad = 0;

        int numero = Entrada.leerEntero(sc, "Número (0 para terminar): ");
        while (numero != 0) {
            suma += numero;
            cantidad++;
            numero = Entrada.leerEntero(sc, "Número (0 para terminar): ");
        }

        System.out.println("Capturaste " + cantidad + " número(s). Suma = " + suma);
        if (cantidad > 0) {
            double promedio = (double) suma / cantidad;
            System.out.printf("Promedio = %.2f%n", promedio);
        }
    }

    /** Validación: repetir la pregunta MIENTRAS el dato sea inválido. */
    public static void validarEdad(Scanner sc) {
        int edad = Entrada.leerEntero(sc, "Edad (0-120): ");
        while (edad < 0 || edad > 120) {
            System.out.println("Edad fuera de rango, intenta de nuevo.");
            edad = Entrada.leerEntero(sc, "Edad (0-120): ");
        }
        System.out.println("Edad válida: " + edad);
    }

    /** Problema real: la cantidad de vueltas (meses) es justo lo que queremos averiguar. */
    public static void mesesParaAhorrar(Scanner sc) {
        int meta = Entrada.leerEnteroEnRango(sc, "Meta de ahorro ($): ", 1, 1_000_000);
        int ahorroMensual = Entrada.leerEnteroEnRango(sc, "Ahorro por mes ($): ", 1, 1_000_000);

        int ahorrado = 0;
        int meses = 0;
        while (ahorrado < meta) {
            ahorrado += ahorroMensual;
            meses++;
            System.out.println("Mes " + meses + ": $" + ahorrado);
        }
        System.out.println("Necesitas " + meses + " mes(es) para llegar a $" + meta + ".");
    }
}
