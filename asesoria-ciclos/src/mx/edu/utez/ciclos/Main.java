package mx.edu.utez.ciclos;

import mx.edu.utez.ciclos.ejemplos.EjemplosDoWhile;
import mx.edu.utez.ciclos.ejemplos.EjemplosFor;
import mx.edu.utez.ciclos.ejemplos.EjemplosWhile;
import mx.edu.utez.ciclos.practica.PracticaGuiada;
import mx.edu.utez.ciclos.practica.PracticaSolucion;
import mx.edu.utez.ciclos.util.Entrada;

import java.util.Locale;
import java.util.Scanner;

/**
 * Punto de entrada de la asesoría de ciclos.
 * El propio menú principal es un do-while: se muestra al menos una vez y se repite hasta elegir 0.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Decimales con punto (8.5), sin importar el idioma del sistema operativo.
        sc.useLocale(Locale.US);

        int opcion;
        do {
            System.out.println();
            System.out.println("========== ASESORÍA: CICLOS EN JAVA ==========");
            System.out.println("1. Ejemplos de while");
            System.out.println("2. Ejemplos de for");
            System.out.println("3. Ejemplos de do-while");
            System.out.println("4. Práctica guiada (versión para completar)");
            System.out.println("5. Práctica guiada (solución)");
            System.out.println("0. Salir");
            opcion = Entrada.leerEntero(sc, "Opción: ");

            switch (opcion) {
                case 1:
                    EjemplosWhile.menu(sc);
                    break;
                case 2:
                    EjemplosFor.menu(sc);
                    break;
                case 3:
                    EjemplosDoWhile.menu(sc);
                    break;
                case 4:
                    PracticaGuiada.ejecutar(sc);
                    break;
                case 5:
                    PracticaSolucion.ejecutar(sc);
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}
