package mx.edu.utez.ciclos.practica;

import java.util.Scanner;

/**
 * PRÁCTICA GUIADA: "Control de calificaciones de un grupo".
 * Versión para completar en clase, paso por paso (ver PRACTICA-GUIADA.md).
 *
 * El archivo compila desde el inicio: cada método tiene un TODO con la instrucción.
 * Ve resolviendo los pasos en orden y ejecuta el programa después de cada uno.
 *
 *   Paso 1 → do-while  (menú)
 *   Paso 2 → while     (validar datos de entrada)
 *   Paso 3 → for       (capturar N calificaciones + acumuladores)
 *   Paso 4 → (sin ciclo) mostrar resultados calculados
 *   Paso 5 → for       (gráfica de barras con asteriscos)
 *   Paso 6 → for       (tabla descendente de estatus)
 *   Paso 7 → while     (¿cuántos puntos extra le faltan para aprobar?)
 */
public class PracticaGuiada {

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
        // TODO Paso 1:
        //  1. Declara una variable int opcion.
        //  2. Con un do-while muestra este menú:
        //       1. Registrar calificaciones del grupo
        //       2. Ver resumen del grupo
        //       3. Ver gráfica aprobados / reprobados
        //       4. Ver tabla de estatus (10 a 0)
        //       5. ¿Cuántos puntos extra le faltan a un alumno?
        //       0. Regresar
        //  3. Lee la opción con leerEnteroEnRango(sc, "Opción: ", 0, 5).
        //  4. Usa un switch para llamar al método de cada opción.
        //  5. La condición del do-while: repetir mientras opcion != 0.
        //  Pregunta para pensar: ¿por qué un menú se hace con do-while y no con while?

        System.out.println("TODO Paso 1: implementa el menú con do-while en PracticaGuiada.ejecutar");
    }

    // ===================== PASO 2: validación con while =====================

    /**
     * Debe regresar un entero entre min y max (incluidos).
     * Si el usuario escribe algo inválido, se vuelve a preguntar.
     */
    public static int leerEnteroEnRango(Scanner sc, String mensaje, int min, int max) {
        // TODO Paso 2a:
        //  1. Declara: int valor = 0;  boolean valido = false;
        //  2. while (!valido) {
        //       - imprime el mensaje
        //       - si sc.hasNextInt():
        //             valor = sc.nextInt();
        //             si está entre min y max → valido = true
        //             si no → imprime "Debe estar entre ... y ..."
        //       - si no es entero:
        //             imprime "Eso no es un número entero."
        //             sc.next();   ← ¡importante! descarta el texto o el ciclo será infinito
        //     }
        //  3. return valor;

        return min;
    }

    /** Igual que el anterior, pero con decimales (hasNextDouble / nextDouble) y rango 0 a 10. */
    public static double leerCalificacion(Scanner sc, String mensaje) {
        // TODO Paso 2b: copia la lógica de leerEnteroEnRango usando double y el rango 0 a 10.
        //  Mensaje de error sugerido: "Eso no es un número (usa punto decimal, ej. 8.5)."

        return 0;
    }

    // ===================== PASO 3: captura con for + acumuladores =====================
    public static void registrarGrupo(Scanner sc) {
        // TODO Paso 3:
        //  1. totalAlumnos = leerEnteroEnRango(sc, "¿Cuántos alumnos tiene el grupo? (1-40): ", 1, MAX_ALUMNOS);
        //  2. Reinicia los acumuladores ANTES del ciclo: suma = 0; aprobados = 0;
        //  3. for (int i = 1; i <= totalAlumnos; i++) {
        //       - lee la calificación con leerCalificacion(sc, "Calificación del alumno " + i + ": ")
        //       - súmala a suma (acumulador)
        //       - si i == 1 → mayor y menor toman esa calificación
        //         si no   → actualiza mayor / menor si corresponde
        //       - si calificacion >= CALIFICACION_APROBATORIA → aprobados++ (contador)
        //     }
        //  4. Imprime "Grupo registrado: N alumno(s)."

        System.out.println("TODO Paso 3: implementa registrarGrupo con un for");
    }

    // ===================== PASO 4: resumen =====================
    public static void mostrarResumen() {
        // TODO Paso 4:
        //  1. Si totalAlumnos == 0 → "Primero registra un grupo (opción 1)." y return.
        //  2. Calcula promedio = suma / totalAlumnos  y  reprobados = totalAlumnos - aprobados.
        //  3. Imprime: alumnos, promedio (2 decimales con printf), mayor, menor,
        //     aprobados, reprobados y % de aprobación.

        System.out.println("TODO Paso 4: implementa mostrarResumen");
    }

    // ===================== PASO 5: gráfica con for =====================
    public static void mostrarGrafica() {
        // TODO Paso 5a:
        //  1. Valida que exista un grupo (igual que en el Paso 4).
        //  2. Llama a imprimirBarra("Aprobados ", aprobados);
        //     y a imprimirBarra("Reprobados", totalAlumnos - aprobados);

        System.out.println("TODO Paso 5: implementa mostrarGrafica");
    }

    /** Ejemplo de salida:  Aprobados  | ***** (5) */
    public static void imprimirBarra(String etiqueta, int cantidad) {
        // TODO Paso 5b:
        //  1. Imprime la etiqueta y " | " (con print, sin salto de línea).
        //  2. Con un for de 0 a cantidad - 1 imprime un "*" en cada vuelta.
        //  3. Al final imprime " (" + cantidad + ")" con println.
    }

    // ===================== PASO 6: tabla descendente con for =====================
    public static void mostrarTablaEstatus() {
        // TODO Paso 6:
        //  Con un for que vaya de 10 hasta 0 (decrementando) imprime por cada calificación
        //  si es "Aprobado" (>= CALIFICACION_APROBATORIA) o "Reprobado".
        //  Ejemplo:   10 | Aprobado
        //              9 | Aprobado
        //              ...
        //              7 | Reprobado

        System.out.println("TODO Paso 6: implementa mostrarTablaEstatus con un for descendente");
    }

    // ===================== PASO 7: while con cantidad de vueltas desconocida =====================
    public static void calcularPuntosFaltantes(Scanner sc) {
        // TODO Paso 7:
        //  1. Lee la calificación actual con leerCalificacion.
        //  2. Si ya es aprobatoria → avisa y return.
        //  3. double simulada = calificacion;  int puntosExtra = 0;
        //  4. while (simulada < CALIFICACION_APROBATORIA) { simulada += 0.5; puntosExtra++; }
        //  5. Imprime cuántos puntos de 0.5 necesita y a qué calificación llegaría.
        //  Pregunta para pensar: ¿por qué aquí conviene while y no for?

        System.out.println("TODO Paso 7: implementa calcularPuntosFaltantes con un while");
    }
}
