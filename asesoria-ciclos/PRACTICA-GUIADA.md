# Práctica guiada — Control de calificaciones de un grupo

**Tema:** ciclos `while`, `for` y `do-while` en Java  
**Archivo a completar:** `src/mx/edu/utez/ciclos/practica/PracticaGuiada.java`  
**Cómo probarlo:** ejecuta `Main` y elige la opción **4. Práctica guiada (versión para completar)**

---

## ¿Qué vamos a construir?

Un programa de consola para que un profesor registre las calificaciones de su grupo y obtenga estadísticas:

```
===== Control de calificaciones =====
1. Registrar calificaciones del grupo
2. Ver resumen del grupo
3. Ver gráfica aprobados / reprobados
4. Ver tabla de estatus (10 a 0)
5. ¿Cuántos puntos extra le faltan a un alumno?
0. Regresar
```

La calificación aprobatoria es **8.0** (constante `CALIFICACION_APROBATORIA`).

Cada paso usa un ciclo distinto:

| Paso | Ciclo | Qué haces |
|---|---|---|
| 1 | `do-while` | El menú |
| 2 | `while` | Validar los datos que escribe el usuario |
| 3 | `for` | Capturar las calificaciones del grupo |
| 4 | — | Mostrar el resumen |
| 5 | `for` | Gráfica con asteriscos |
| 6 | `for` | Tabla de estatus del 10 al 0 |
| 7 | `while` | Calcular puntos extra para aprobar |

**Regla de oro:** después de cada paso, **compila y ejecuta**.

---

## Paso 1 — Menú con `do-while`

Método: `ejecutar(Scanner sc)`

1. Declara `int opcion;`
2. Dentro de un `do { ... } while (opcion != 0);`:
   - Imprime el menú.
   - Lee la opción con `leerEnteroEnRango(sc, "Opción: ", 0, 5)`.
   - Usa un `switch` para llamar a cada método (`registrarGrupo`, `mostrarResumen`, etc.).
3. No olvides el `;` después del `while (...)`.

**Para pensar:** ¿por qué un menú se hace con `do-while` y no con `while`?

✅ Al terminar: el menú aparece y sale con 0. (Las opciones todavía muestran “TODO”: es normal.)

---

## Paso 2 — Validar datos con `while`

### 2a. `leerEnteroEnRango(sc, mensaje, min, max)`

Debe repetir la pregunta **mientras** el dato no sea válido.

```java
int valor = 0;
boolean valido = false;
while (!valido) {
    // 1. imprime el mensaje
    // 2. si sc.hasNextInt():
    //        lee el valor; si está entre min y max → valido = true
    //        si no → avisa el rango
    // 3. si NO es entero:
    //        avisa y usa sc.next() para descartar lo que escribió
}
return valor;
```

⚠️ Si olvidas `sc.next()`, el programa se queda en un **ciclo infinito** (pruébalo y detenlo con Stop / Ctrl+C).

### 2b. `leerCalificacion(sc, mensaje)`

Igual que 2a, pero con `hasNextDouble()` / `nextDouble()` y rango **0 a 10**.  
Los decimales se escriben con **punto**: `8.5`.

✅ Al terminar: en el menú, escribir `hola` o `9` muestra error y vuelve a preguntar.

---

## Paso 3 — Capturar calificaciones con `for`

Método: `registrarGrupo(Scanner sc)`

1. Pide el total de alumnos (1 a 40) con `leerEnteroEnRango` y guárdalo en `totalAlumnos`.
2. **Antes del ciclo**, reinicia: `suma = 0;` y `aprobados = 0;`
3. Con `for (int i = 1; i <= totalAlumnos; i++)`:
   - Lee la calificación del alumno `i`.
   - **Acumulador:** súmala a `suma`.
   - **Mayor/menor:** si `i == 1`, ambos toman esa calificación; si no, actualízalos cuando corresponda.
   - **Contador:** si es `>= CALIFICACION_APROBATORIA`, incrementa `aprobados`.
4. Imprime cuántos alumnos se registraron.

**Para pensar:** ¿por qué aquí usamos `for` y no `while`?

---

## Paso 4 — Resumen del grupo

Método: `mostrarResumen()`

1. Si `totalAlumnos == 0`, avisa “Primero registra un grupo” y termina (`return`).
2. Calcula `promedio = suma / totalAlumnos` y `reprobados = totalAlumnos - aprobados`.
3. Imprime alumnos, promedio (2 decimales), mayor, menor, aprobados, reprobados y % de aprobación.

Tip para 2 decimales: `System.out.printf("Promedio: %.2f%n", promedio);`

---

## Paso 5 — Gráfica con `for`

### 5a. `mostrarGrafica()`

Valida que haya grupo y llama a:

```java
imprimirBarra("Aprobados ", aprobados);
imprimirBarra("Reprobados", totalAlumnos - aprobados);
```

### 5b. `imprimirBarra(etiqueta, cantidad)`

Debe imprimir:

```
Aprobados  | ** (2)
Reprobados | ** (2)
```

Usa un `for` que dé `cantidad` vueltas e imprima un `*` en cada una (con `print`, sin salto de línea).

---

## Paso 6 — Tabla de estatus con `for` descendente

Método: `mostrarTablaEstatus()`

Con un `for` que vaya **de 10 a 0** (restando 1), imprime cada calificación y si es “Aprobado” o “Reprobado”.

```
Calificación | Estatus
          10 | Aprobado
           9 | Aprobado
           8 | Aprobado
           7 | Reprobado
           ...
```

---

## Paso 7 — Puntos extra con `while`

Método: `calcularPuntosFaltantes(Scanner sc)`

Cada punto extra vale **0.5**. ¿Cuántos necesita un alumno para aprobar?

1. Lee la calificación actual.
2. Si ya aprueba, avísalo y termina.
3. Mientras la calificación simulada sea menor a 8.0, súmale 0.5 y cuenta un punto.
4. Muestra cuántos puntos necesita y a qué calificación llegaría.

**Para pensar:** ¿por qué aquí conviene `while` y no `for`?

---

## Datos de prueba

Registra **4** alumnos con: `9.5`, `7.3`, `10`, `6`

| Dato | Resultado esperado |
|---|---|
| Promedio | 8.20 |
| Mayor | 10.0 |
| Menor | 6.0 |
| Aprobados | 2 |
| Reprobados | 2 |
| % aprobación | 50.0% |
| Puntos extra para `7.3` | 2 (llegaría a 8.3) |

Prueba también datos inválidos: `hola`, `15`, `-3`, `0` alumnos.

---

## Retos extra (si terminas antes)

1. En el Paso 3, cuenta cuántos alumnos sacaron **10**.
2. En la gráfica, agrega una barra para los que sacaron **9 o más**.
3. Al salir de la práctica, pregunta “¿Seguro que deseas salir? (s/n)” con un `do-while`.
4. En el Paso 7, limita la calificación simulada a un máximo de 10.
