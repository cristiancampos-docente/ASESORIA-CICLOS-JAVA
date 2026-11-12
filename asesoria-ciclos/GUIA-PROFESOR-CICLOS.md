# Guía de estudio — Ciclos `while`, `for` y `do-while` en Java

> Para: alumnos de **primer cuatrimestre**.  
> Proyecto de apoyo: `JAVA/asesoria-ciclos` (Java puro, sin frameworks).  
> Práctica guiada: `PracticaGuiada.java` (la completas tú) / `PracticaSolucion.java` (para comparar al terminar).

En esta guía está todo lo que necesitas saber sobre ciclos para la asesoría: teoría, ejemplos, errores comunes y ejercicios para practicar.

---

## 1. ¿Qué vas a aprender?

Al terminar la asesoría podrás:

1. Explicar **qué es un ciclo** y para qué sirve.
2. Identificar las **3 partes** de todo ciclo: inicialización, condición y actualización.
3. Escribir un `while`, un `for` y un `do-while` sin copiar.
4. **Elegir** el ciclo correcto según el problema.
5. Usar los patrones básicos: **contador, acumulador, centinela, bandera, máximo/mínimo, validación y menú**.
6. Hacer una **prueba de escritorio** (seguir un ciclo a mano, vuelta por vuelta).
7. Reconocer y corregir un **ciclo infinito**.

La idea más importante, en tres líneas:

> **`while`** → “mientras se cumpla, repite” (puede ser 0 veces).  
> **`for`** → “repite N veces” (cuando sabes cuántas).  
> **`do-while`** → “hazlo y luego pregunta si repites” (mínimo 1 vez).

---

## 2. Antes de empezar: ¿qué es un ciclo?

### 2.1 El problema que resuelve

Sin ciclos, imprimir del 1 al 100 requiere 100 líneas:

```java
System.out.println(1);
System.out.println(2);
// ... 98 líneas más
```

Con un ciclo:

```java
for (int i = 1; i <= 100; i++) {
    System.out.println(i);
}
```

Un **ciclo repite un bloque de código mientras una condición sea verdadera.**

### 2.2 Vocabulario

| Término | Significado |
|---|---|
| **Iteración / vuelta** | Cada vez que se ejecuta el cuerpo del ciclo |
| **Condición** | Expresión `boolean` que decide si se da otra vuelta |
| **Cuerpo** | El bloque `{ ... }` que se repite |
| **Variable de control** | La variable que cambia y decide cuándo parar (`i`, `contador`, `opcion`) |
| **Ciclo infinito** | La condición nunca se vuelve falsa y el programa no termina |

### 2.3 Las 3 partes de TODO ciclo

```
1) Inicialización   →  int i = 1;
2) Condición        →  i <= 10
3) Actualización    →  i++
```

- Si falta la **actualización**, el ciclo es infinito.
- Si la **inicialización** está mal, empieza donde no debe.
- Si la **condición** está mal, da vueltas de más o de menos.

Recuerda esto: los tres ciclos tienen las mismas partes; solo las acomodan diferente.

---

## 3. Ciclo `while`

### 3.1 Sintaxis

```java
inicialización;
while (condición) {
    cuerpo;
    actualización;
}
```

### 3.2 Cómo se ejecuta

```
          ┌──────────────┐
          │ inicialización│
          └──────┬───────┘
                 ▼
          ┌─────────────┐   falso
   ┌────► │ ¿condición? │ ─────────► sale del ciclo
   │      └──────┬──────┘
   │             │ verdadero
   │             ▼
   │      ┌─────────────┐
   │      │   cuerpo    │
   │      │ actualización│
   │      └──────┬──────┘
   └─────────────┘
```

Clave: **pregunta primero**. Si la condición es falsa desde el inicio, el cuerpo se ejecuta **0 veces**.

### 3.3 ¿Cuándo usarlo?

Cuando **no sabes cuántas vueltas** habrá, porque depende de un dato o del usuario:

- Repetir mientras el usuario no escriba un dato válido.
- Sumar números hasta que escriba 0 (centinela).
- Calcular cuántos meses tardas en ahorrar $10,000.
- Contar los dígitos de un número.

### 3.4 Ejemplo base (`EjemplosWhile.contarDel1Al10`)

```java
int i = 1;
while (i <= 10) {
    System.out.print(i + " ");
    i++;
}
// Aquí i vale 11
```

Piénsalo: ¿cuánto vale `i` al salir? → **11**. Es la primera vez que la condición fue falsa.

---

## 4. Ciclo `for`

### 4.1 Sintaxis

```java
for (inicialización; condición; actualización) {
    cuerpo;
}
```

### 4.2 Orden exacto de ejecución

1. **Inicialización** → se ejecuta **una sola vez**.
2. **Condición** → si es falsa, termina.
3. **Cuerpo**.
4. **Actualización**.
5. Regresa al paso 2.

La actualización ocurre **después** del cuerpo, no antes.

### 4.3 ¿Cuándo usarlo?

Cuando **sabes (o puedes calcular) cuántas vueltas** habrá:

- Repetir algo 10 veces.
- Tabla de multiplicar (1 a 10).
- Capturar las calificaciones de N alumnos (N ya se conoce).
- Recorrer las letras de un `String` (de 0 a `length() - 1`).

### 4.4 Variaciones que debes conocer

```java
for (int i = 1; i <= 10; i++)      // ascendente
for (int i = 10; i >= 1; i--)      // descendente
for (int i = 2; i <= 20; i += 2)   // de 2 en 2
for (int i = 0; i < texto.length(); i++)  // recorrer un String
```

### 4.5 Alcance de la variable (scope)

```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
System.out.println(i); // ERROR: i no existe fuera del for
```

`i` nace y muere dentro del `for`. Si la necesitas después, declárala antes del ciclo (y en ese caso suele convenir un `while`).

### 4.6 Equivalencia `for` ↔ `while`

```java
for (int i = 1; i <= 5; i++) {        int i = 1;
    System.out.println(i);            while (i <= 5) {
}                                         System.out.println(i);
                                          i++;
                                      }
```

Todo `for` se puede escribir como `while`: es el mismo ciclo con las 3 partes en otro lugar. Compruébalo con `EjemplosFor.equivalenciaForWhile`.

---

## 5. Ciclo `do-while`

### 5.1 Sintaxis

```java
do {
    cuerpo;
} while (condición);   // ← lleva punto y coma
```

### 5.2 Cómo se ejecuta

```
   ┌──────────────┐
   │    cuerpo    │ ◄───────┐
   └──────┬───────┘         │
          ▼                 │ verdadero
   ┌─────────────┐          │
   │ ¿condición? │ ─────────┘
   └──────┬──────┘
          │ falso
          ▼
     sale del ciclo
```

Clave: **primero hace y después pregunta** → se ejecuta **mínimo 1 vez**.

### 5.3 ¿Cuándo usarlo?

Cuando la acción **debe ocurrir al menos una vez**:

- **Menús** (el menú siempre se muestra al menos una vez).
- “¿Deseas continuar? (s/n)”.
- Pedir un dato y repetir si es inválido.
- Juegos: adivinar un número (siempre hay por lo menos un intento).

### 5.4 La diferencia en un solo ejemplo

Misma condición falsa, dos resultados distintos:

```java
int saldo = 0;
while (saldo > 0) {           // 0 vueltas
    System.out.println("while");
}

do {                          // 1 vuelta
    System.out.println("do-while");
} while (saldo > 0);
```

Pruébalo en el proyecto: `EjemplosWhile.ceroVueltas()` vs `EjemplosDoWhile.unaVueltaGarantizada()`.

---

## 6. ¿Qué ciclo uso?

```
¿Sé cuántas veces se repite?
   ├── Sí → for
   └── No → ¿Debe ejecutarse al menos una vez?
              ├── Sí → do-while
              └── No → while
```

| | `while` | `for` | `do-while` |
|---|---|---|---|
| Evalúa la condición | Antes | Antes | Después |
| Vueltas mínimas | 0 | 0 | **1** |
| Ideal para | Cantidad desconocida | Cantidad conocida | Menús / validación |
| Punto y coma al final | No | No | **Sí** |
| Ejemplo típico | Centinela, ahorro | Tablas, N alumnos | Menú, “¿continuar?” |

Ojo: **cualquier problema se puede resolver con cualquiera de los tres**. Elegir bien hace tu código más claro, pero no significa que “solo uno funcione”.

---

## 7. Patrones que debes dominar

### 7.1 Contador

Cuenta cuántas veces pasa algo. Empieza en 0 y suma 1.

```java
int aprobados = 0;
// dentro del ciclo:
if (calificacion >= 8) {
    aprobados++;
}
```

### 7.2 Acumulador (suma)

Junta valores. Se inicializa en 0 **fuera** del ciclo.

```java
int suma = 0;
for (int i = 1; i <= 100; i++) {
    suma += i;
}
```

### 7.3 Acumulador (producto)

Se inicializa en **1** (si fuera 0, todo daría 0).

```java
long factorial = 1;
for (int i = 1; i <= n; i++) {
    factorial *= i;
}
```

### 7.4 Centinela

Un valor especial que indica “ya terminé” (por ejemplo 0 o -1).

```java
int numero = leer();
while (numero != 0) {
    suma += numero;
    numero = leer();   // se vuelve a leer al FINAL del cuerpo
}
```

Fíjate: se lee **una vez antes** del ciclo y **otra al final** del cuerpo; así el 0 nunca se suma.

### 7.5 Bandera (flag)

Una variable `boolean` que controla el ciclo.

```java
boolean valido = false;
while (!valido) {
    // ... si el dato es correcto:
    valido = true;
}
```

### 7.6 Máximo y mínimo

```java
if (i == 1) {               // el primer dato es el punto de partida
    mayor = dato;
    menor = dato;
} else {
    if (dato > mayor) mayor = dato;
    if (dato < menor) menor = dato;
}
```

Error típico: inicializar `menor = 0`. Con calificaciones positivas, el menor siempre saldría 0.

### 7.7 Validación de entrada

```java
int edad = leerEntero("Edad: ");
while (edad < 0 || edad > 120) {
    System.out.println("Fuera de rango.");
    edad = leerEntero("Edad: ");
}
```

Cuidado con la lógica: para detectar un dato fuera de rango se usa **`||`** (“menor que el mínimo **o** mayor que el máximo”). Con `&&` la condición nunca sería verdadera.

### 7.8 Menú

```java
int opcion;
do {
    mostrarMenu();
    opcion = leerEntero("Opción: ");
    switch (opcion) { ... }
} while (opcion != 0);
```

Todo el proyecto está construido así (`Main` y cada método `menu(...)`): úsalo como ejemplo.

---

## 8. Ciclos anidados

Un ciclo dentro de otro: **por cada vuelta del externo, el interno da todas sus vueltas.**

```java
for (int fila = 1; fila <= 3; fila++) {
    for (int col = 1; col <= fila; col++) {
        System.out.print("* ");
    }
    System.out.println();
}
```

Salida:

```
*
* *
* * *
```

Lo que debes entender:

- Total de vueltas = vueltas del externo × vueltas del interno (tablas del 1 al 5 → 5 × 10 = 50).
- El interno puede **depender** del externo (`col <= fila`).
- Dentro se usa `System.out.print` (sin salto de línea) y `println` al terminar cada fila.

Ejemplos en el proyecto: `EjemplosFor.tablasDel1Al5()` y `EjemplosFor.trianguloAsteriscos()`.

---

## 9. `break` y `continue`

| Instrucción | Qué hace |
|---|---|
| `break` | Termina el ciclo **por completo** |
| `continue` | Se salta **el resto de esta vuelta** y pasa a la siguiente |

```java
for (int i = 1; i <= 10; i++) {
    if (i % 3 == 0) continue;  // se salta 3, 6, 9
    if (i == 8) break;         // termina al llegar a 8
    System.out.print(i + " "); // 1 2 4 5 7
}
```

Úsalos con moderación: casi siempre una buena condición es más clara que un `break`. (El `break` dentro de un `switch` es otra cosa: solo sale del `switch`.)

---

## 10. Prueba de escritorio

Consiste en seguir a mano qué vale cada variable en cada vuelta. Hazla en tu cuaderno **antes** de ejecutar el programa.

Código:

```java
int suma = 0;
for (int i = 1; i <= 4; i++) {
    suma += i;
}
```

| Vuelta | `i` | ¿`i <= 4`? | `suma` después del cuerpo |
|---|---|---|---|
| 1 | 1 | sí | 1 |
| 2 | 2 | sí | 3 |
| 3 | 3 | sí | 6 |
| 4 | 4 | sí | 10 |
| — | 5 | **no** → sale | 10 |

Después ejecuta el código y compara tu tabla con el resultado real. Así entrenas a **leer código**, no solo a escribirlo.

---

## 11. Errores comunes (y cómo corregirlos)

| Error | Ejemplo | Qué pasa / cómo corregir |
|---|---|---|
| Olvidar la actualización | `while (i <= 10) { print(i); }` | Ciclo infinito. Falta `i++` |
| Punto y coma tras `while`/`for` | `while (i <= 10);` | El ciclo queda vacío (y suele ser infinito). Quita el `;` |
| Olvidar `;` en `do-while` | `} while (x > 0)` | Error de compilación |
| Una vuelta de más o de menos (`<` vs `<=`) | `for (i = 1; i < 10; i++)` | Da 9 vueltas, no 10 |
| Actualizar en sentido contrario | `for (i = 10; i >= 1; i++)` | Nunca llega a ser menor a 1 → infinito |
| Acumulador dentro del ciclo | `for (...) { int suma = 0; suma += i; }` | Se reinicia en cada vuelta. Va **antes** del ciclo |
| Producto iniciado en 0 | `long f = 0;` | Todo da 0. Debe iniciar en 1 |
| `&&` en lugar de `||` en rangos | `while (x < 0 && x > 10)` | Nunca es verdadero → no valida |
| Comparar `String` con `==` | `while (resp == "s")` | Usa `resp.equalsIgnoreCase("s")` |
| Usar `i` fuera del `for` | `System.out.println(i);` | Error de alcance: `i` solo existe en el `for` |
| Modificar `i` dentro del `for` | `for (...) { i = i + 2; }` | Confuso; usa la actualización del `for` |
| No descartar texto inválido en Scanner | `while (!sc.hasNextInt()) { }` | Infinito: falta `sc.next()` para descartar |
| Mezclar `nextInt()` y `nextLine()` | `nextLine()` “se salta” | `nextInt` deja el Enter. En el proyecto se usa `next()`/`nextInt()` para evitarlo |
| Decimales con coma | `8,5` | El proyecto usa `Locale.US` → escribe `8.5` |

¿Se te quedó el programa en un ciclo infinito? Detenlo con **Ctrl + C** en la terminal o con el botón **Stop** (cuadro rojo) en IntelliJ.

---

## 12. Scanner: lo mínimo que necesitas

| Método | Para qué |
|---|---|
| `sc.nextInt()` / `sc.nextDouble()` | Leer un número |
| `sc.next()` | Leer una palabra (o descartar lo que no sirve) |
| `sc.hasNextInt()` / `sc.hasNextDouble()` | ¿Lo siguiente es un número? (no lo consume) |
| `sc.useLocale(Locale.US)` | Decimales con punto |

Patrón seguro que se usa en el proyecto (es un `while` en sí mismo):

```java
while (!sc.hasNextInt()) {
    System.out.print("Eso no es un número: ");
    sc.next(); // descarta lo que escribió
}
int valor = sc.nextInt();
```

---

## 13. Recorrido del proyecto

| Archivo | Qué muestra |
|---|---|
| `Main.java` | Menú principal (do-while + switch) |
| `ejemplos/EjemplosWhile.java` | Contador, regresiva, 0 vueltas, dígitos, centinela, validación, ahorro |
| `ejemplos/EjemplosFor.java` | Ascendente, descendente, de 2 en 2, suma, tabla, factorial, String, anidados, break/continue, equivalencia |
| `ejemplos/EjemplosDoWhile.java` | 1 vuelta garantizada, validar opción, ¿continuar?, adivina el número, dígitos |
| `practica/PracticaGuiada.java` | La práctica que vas a completar (compila desde el inicio) |
| `practica/PracticaSolucion.java` | Solución completa, para comparar al terminar |
| `util/Entrada.java` | Lectura segura de enteros (usa while internamente) |

Cómo ejecutarlo: ver el `README.md` del proyecto (IntelliJ o `javac`/`java`).

---

## 14. Ruta de estudio sugerida

Sigue este orden; es el mismo que se usará en la asesoría.

### Parte A — ¿Por qué ciclos?

1. Intenta imprimir del 1 al 5 sin ciclo. Luego imagina del 1 al 1000.
2. Repasa la idea: **repetir mientras se cumpla una condición**.
3. Memoriza las **3 partes** de un ciclo (sección 2.3).

### Parte B — `while`

1. Ejecuta `contarDel1Al10` e identifica las 3 partes en el código.
2. Responde: ¿cuánto vale `i` al salir?
3. Haz su prueba de escritorio.
4. Quita el `i++` a propósito, ejecútalo y detén el ciclo infinito con Stop.
5. Prueba `sumarHastaCero` (centinela) y `validarEdad` (validación).
6. Prueba `mesesParaAhorrar`: aquí el número de vueltas es justo la respuesta.

### Parte C — `for`

1. Ejecuta `contarDel1Al10` con `for` y compáralo con el `while` (`equivalenciaForWhile`).
2. Repasa el orden de ejecución (sección 4.2).
3. Prueba las variaciones: descendente y de 2 en 2.
4. Ejecuta `tablaDeMultiplicar` y `sumaDel1Al100` (acumulador).
5. Ejecuta `factorial` y explica por qué inicia en 1.
6. Ciclos anidados: `trianguloAsteriscos` (haz su prueba de escritorio con 3 filas).

### Parte D — `do-while`

1. Compara `ceroVueltas` contra `unaVueltaGarantizada`.
2. Prueba `validarOpcion` y `deseasContinuar`.
3. Juega `adivinaElNumero`.
4. Observa que el propio menú del programa es un `do-while`.

### Parte E — Práctica guiada

Ver sección 15.

### Parte F — Repaso

Repasa la tabla de la sección 6 y responde las preguntas de la sección 17.

---

## 15. La práctica guiada

Enunciado completo: `PRACTICA-GUIADA.md`.  
Archivo que vas a completar: `PracticaGuiada.java` (opción 4 del menú principal).  
Solución: `PracticaSolucion.java` (opción 5). Intenta resolver cada paso por tu cuenta antes de verla.

| Paso | Ciclo | Qué haces | Tiempo aprox. |
|---|---|---|---|
| 1 | `do-while` | Menú de la práctica | 5 min |
| 2 | `while` + bandera | Validar enteros y calificaciones | 8 min |
| 3 | `for` + contador/acumulador/máx/mín | Capturar N calificaciones | 8 min |
| 4 | (sin ciclo) | Resumen: promedio, mayor, menor, % | 4 min |
| 5 | `for` | Gráfica de barras con `*` | 4 min |
| 6 | `for` descendente | Tabla de estatus 10 → 0 | 3 min |
| 7 | `while` | Puntos extra para aprobar | 3 min |

Consejos:

- Resuelve los pasos **en orden**.
- Después de cada paso: **compila y ejecuta**. Así detectas errores a tiempo.
- Si te atoras en un paso, revisa ese método en `PracticaSolucion.java`, entiéndelo y continúa con el siguiente.
- En el Paso 2, prueba qué pasa si olvidas `sc.next()`: verás un ciclo infinito.
- La calificación aprobatoria es la constante `CALIFICACION_APROBATORIA = 8.0`.

Datos de prueba (4 alumnos): `9.5`, `7.3`, `10`, `6`  
Resultado esperado: promedio **8.20**, mayor **10.0**, menor **6.0**, aprobados **2**, reprobados **2**, aprobación **50.0%**.  
Paso 7 con `7.3` → necesita **2** puntos extra (llegaría a **8.3**).

---

## 16. Ejercicios extra (con pista)

**Básico**

1. Imprimir los números impares del 1 al 50. → `for (int i = 1; i <= 50; i += 2)`
2. Pedir 5 números y mostrar la suma. → `for` + acumulador.
3. Cuenta regresiva desde un número que da el usuario. → `for` descendente o `while`.

**Intermedio**

4. Pedir números hasta que escriba un negativo; mostrar el mayor. → `while` + centinela + máximo.
5. Tabla de multiplicar de un número, pero solo mientras el resultado no pase de 100. → `while (n * i <= 100)`.
6. Pedir una contraseña hasta que sea `"utez2026"`, con máximo 3 intentos. → `do-while` + contador + `equals` + condición compuesta.

**Avanzado**

7. Determinar si un número es primo. → `for` de 2 a n-1 + bandera (o `break`).
8. Cuadrado de asteriscos hueco de tamaño N. → `for` anidado + `if` en los bordes.
9. Invertir los dígitos de un número (123 → 321). → `while` con `% 10` y `/ 10`.

---

## 17. Repaso: ponte a prueba

Intenta responder antes de ver la respuesta.

| Pregunta | Respuesta |
|---|---|
| ¿Cuáles son las 3 partes de un ciclo? | Inicialización, condición, actualización |
| ¿Qué ciclo puede ejecutarse 0 veces? | `while` y `for` |
| ¿Qué ciclo se ejecuta mínimo 1 vez? | `do-while` |
| ¿Qué ciclo usarías para un menú? | `do-while` |
| ¿Y para capturar 30 calificaciones? | `for` |
| ¿Y para pedir datos hasta que escriban 0? | `while` (centinela) |
| ¿Qué es un ciclo infinito y cómo se evita? | La condición nunca es falsa; actualiza bien la variable de control |
| ¿Por qué el factorial inicia en 1? | Es acumulador de producto; con 0 todo daría 0 |
| ¿Qué diferencia hay entre `break` y `continue`? | `break` termina el ciclo; `continue` salta a la siguiente vuelta |
| ¿Cuántas veces se ejecuta el interno en `for(1..3)` con `for(1..4)` dentro? | 12 |

---

## 18. Cómo se evaluará tu práctica

| Criterio | Peso |
|---|---|
| Menú con `do-while` funcionando y saliendo con 0 | 15% |
| Validación con `while` (rango + texto inválido sin ciclo infinito) | 20% |
| Captura con `for` + acumulador + contador | 20% |
| Mayor y menor correctos | 15% |
| Gráfica y tabla con `for` | 15% |
| Paso 7 con `while` | 10% |
| Código limpio (nombres claros, indentación) | 5% |

---

## 19. Autoevaluación

Antes de dar por terminado el tema, verifica que puedes:

- [ ] Explicar las 3 partes de un ciclo sin ver tus notas.
- [ ] Escribir un `while`, un `for` y un `do-while` desde cero.
- [ ] Decir qué ciclo usarías en un problema y por qué (sección 6).
- [ ] Hacer la prueba de escritorio de un ciclo sencillo.
- [ ] Reconocer y detener un ciclo infinito.
- [ ] Ejecutar tu práctica con los datos de prueba y obtener los resultados esperados.

---

## 20. Para recordar

> Todos los ciclos tienen las mismas tres partes. Si sabes **cuántas veces**, usa `for`; si **no sabes**, usa `while`; si **debe pasar al menos una vez**, usa `do-while`. Y antes de ejecutar, haz la prueba de escritorio: si la entiendes en papel, la entiendes en código.
