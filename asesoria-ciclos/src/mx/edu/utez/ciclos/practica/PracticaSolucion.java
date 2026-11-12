package mx.edu.utez.ciclos.practica;

import java.util.Scanner;

/**
 * SOLUCIÓN de la práctica guiada: "Control de calificaciones de un grupo".
 * Versión del profesor. Los alumnos trabajan en PracticaGuiada.java.
 *
 * Cada paso usa un ciclo distinto:
 *   Paso 1 → do-while  (menú)
 *   Paso 2 → while     (validar datos de entrada)
 *   Paso 3 → for       (capturar N calificaciones + acumuladores)
 *   Paso 4 → (sin ciclo) mostrar resultados calculados
 *   Paso 5 → for       (gráfica de barras con asteriscos)
 *   Paso 6 → for       (tabla descendente de estatus)
 *   Paso 7 → while     (¿cuántos puntos extra le faltan para aprobar?)
 */
public class PracticaSolucion {

    private static final double CALIFICACION_APROBATORIA = 8.0;
    private static final int MAX_ALUMNOS = 40;

    // Datos del grupo registrado (los actualiza registrarGrupo).
    private static int totalAlumnos = 0;
    private static double suma = 0;
    private static double mayor = 0;
    private static double menor = 0;
    private static int aprobados = 0;

    // ===================== PASO 1: menú con do-while =====================
    public static void ejecutar(Scanner sc) {
        int opcion;
        do {
            System.out.println();
            System.out.println("===== Control de calificaciones (SOLUCIÓN) =====");
            System.out.println("1. Registrar calificaciones del grupo");
            System.out.println("2. Ver resumen del grupo");
            System.out.println("3. Ver gráfica aprobados / reprobados");
            System.out.println("4. Ver tabla de estatus (10 a 0)");
            System.out.println("5. ¿Cuántos puntos extra le faltan a un alumno?");
            System.out.println("0. Regresar");
            opcion = leerEnteroEnRango(sc, "Opción: ", 0, 5);

            switch (opcion) {
                case 1:
                    registrarGrupo(sc);
                    break;
                case 2:
                    mostrarResumen();
                    break;
                case 3:
                    mostrarGrafica();
                    break;
                case 4:
                    mostrarTablaEstatus();
                    break;
                case 5:
                    calcularPuntosFaltantes(sc);
                    break;
                case 0:
                    System.out.println("Saliendo de la práctica...");
                    break;
            }
        } while (opcion != 0);
    }

    // ===================== PASO 2: validación con while =====================

    /** Bandera (valido) + while: se repite MIENTRAS el dato no sea válido. */
    public static int leerEnteroEnRango(Scanner sc, String mensaje, int min, int max) {
        int valor = 0;
        boolean valido = false;

        while (!valido) {
            System.out.print(mensaje);
            if (sc.hasNextInt()) {
                valor = sc.nextInt();
                if (valor >= min && valor <= max) {
                    valido = true;
                } else {
                    System.out.println("Debe estar entre " + min + " y " + max + ".");
                }
            } else {
                System.out.println("Eso no es un número entero.");
                sc.next(); // descarta lo que escribió para no quedar en ciclo infinito
            }
        }
        return valor;
    }

    /** Misma idea, pero con decimales y rango fijo de 0 a 10. */
    public static double leerCalificacion(Scanner sc, String mensaje) {
        double calificacion = 0;
        boolean valido = false;

        while (!valido) {
            System.out.print(mensaje);
            if (sc.hasNextDouble()) {
                calificacion = sc.nextDouble();
                if (calificacion >= 0 && calificacion <= 10) {
                    valido = true;
                } else {
                    System.out.println("La calificación debe estar entre 0 y 10.");
                }
            } else {
                System.out.println("Eso no es un número (usa punto decimal, ej. 8.5).");
                sc.next();
            }
        }
        return calificacion;
    }

    // ===================== PASO 3: captura con for + acumuladores =====================
    public static void registrarGrupo(Scanner sc) {
        totalAlumnos = leerEnteroEnRango(sc, "¿Cuántos alumnos tiene el grupo? (1-" + MAX_ALUMNOS + "): ",
                1, MAX_ALUMNOS);

        // Los acumuladores se reinician ANTES del ciclo (si no, se sumaría el grupo anterior).
        suma = 0;
        aprobados = 0;

        for (int i = 1; i <= totalAlumnos; i++) {
            double calificacion = leerCalificacion(sc, "Calificación del alumno " + i + ": ");

            suma += calificacion;

            // Máximo / mínimo: la primera calificación es el punto de partida.
            if (i == 1) {
                mayor = calificacion;
                menor = calificacion;
            } else {
                if (calificacion > mayor) {
                    mayor = calificacion;
                }
                if (calificacion < menor) {
                    menor = calificacion;
                }
            }

            if (calificacion >= CALIFICACION_APROBATORIA) {
                aprobados++;
            }
        }
        System.out.println("Grupo registrado: " + totalAlumnos + " alumno(s).");
    }

    // ===================== PASO 4: resumen =====================
    public static void mostrarResumen() {
        if (totalAlumnos == 0) {
            System.out.println("Primero registra un grupo (opción 1).");
            return;
        }

        double promedio = suma / totalAlumnos;
        int reprobados = totalAlumnos - aprobados;

        System.out.println();
        System.out.println("----- Resumen del grupo -----");
        System.out.println("Alumnos:      " + totalAlumnos);
        System.out.printf("Promedio:     %.2f%n", promedio);
        System.out.println("Mayor:        " + mayor);
        System.out.println("Menor:        " + menor);
        System.out.println("Aprobados:    " + aprobados);
        System.out.println("Reprobados:   " + reprobados);
        System.out.printf("%% aprobación: %.1f%%%n", aprobados * 100.0 / totalAlumnos);
    }

    // ===================== PASO 5: gráfica con for =====================
    public static void mostrarGrafica() {
        if (totalAlumnos == 0) {
            System.out.println("Primero registra un grupo (opción 1).");
            return;
        }

        System.out.println();
        imprimirBarra("Aprobados ", aprobados);
        imprimirBarra("Reprobados", totalAlumnos - aprobados);
    }

    /** Un for que se repite "cantidad" veces imprime "cantidad" asteriscos. */
    public static void imprimirBarra(String etiqueta, int cantidad) {
        System.out.print(etiqueta + " | ");
        for (int i = 0; i < cantidad; i++) {
            System.out.print("*");
        }
        System.out.println(" (" + cantidad + ")");
    }

    // ===================== PASO 6: tabla descendente con for =====================
    public static void mostrarTablaEstatus() {
        System.out.println();
        System.out.println("Calificación | Estatus");
        for (int calificacion = 10; calificacion >= 0; calificacion--) {
            String estatus;
            if (calificacion >= CALIFICACION_APROBATORIA) {
                estatus = "Aprobado";
            } else {
                estatus = "Reprobado";
            }
            System.out.printf("%12d | %s%n", calificacion, estatus);
        }
    }

    // ===================== PASO 7: while con cantidad de vueltas desconocida =====================

    /**
     * Cada punto extra vale 0.5. No sabemos cuántos necesita: el while repite
     * MIENTRAS la calificación simulada siga siendo reprobatoria.
     */
    public static void calcularPuntosFaltantes(Scanner sc) {
        double calificacion = leerCalificacion(sc, "Calificación actual del alumno: ");

        if (calificacion >= CALIFICACION_APROBATORIA) {
            System.out.println("Ya está aprobado, no necesita puntos extra.");
            return;
        }

        double simulada = calificacion;
        int puntosExtra = 0;
        while (simulada < CALIFICACION_APROBATORIA) {
            simulada += 0.5;
            puntosExtra++;
        }

        System.out.printf("Necesita %d punto(s) extra de 0.5 para aprobar (llegaría a %.1f).%n",
                puntosExtra, simulada);
    }
}
