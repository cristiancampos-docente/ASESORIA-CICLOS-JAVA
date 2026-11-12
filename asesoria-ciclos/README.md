# Asesoría Java — Ciclos `while`, `for` y `do-while`

Proyecto en **Java puro** (sin frameworks, sin Maven) para una asesoría de primer cuatrimestre.

## Contenido

| Archivo | Para quién | Qué es |
|---|---|---|
| [`GUIA-PROFESOR-CICLOS.md`](./GUIA-PROFESOR-CICLOS.md) | Alumnos | Guía de estudio: teoría, patrones, errores comunes, ruta de estudio, ejercicios y evaluación |
| [`PRACTICA-GUIADA.md`](./PRACTICA-GUIADA.md) | Alumnos | Enunciado paso a paso de la práctica |
| `src/.../ejemplos/` | Demo en clase | Ejemplos de cada ciclo |
| `src/.../practica/PracticaGuiada.java` | Alumnos | Práctica con TODOs (compila desde el inicio) |
| `src/.../practica/PracticaSolucion.java` | Profesor | Solución completa |

## Estructura

```
asesoria-ciclos/
└── src/mx/edu/utez/ciclos/
    ├── Main.java                  ← menú principal
    ├── ejemplos/
    │   ├── EjemplosWhile.java
    │   ├── EjemplosFor.java
    │   └── EjemplosDoWhile.java
    ├── practica/
    │   ├── PracticaGuiada.java    ← para completar
    │   └── PracticaSolucion.java  ← solución
    └── util/
        └── Entrada.java           ← lectura segura de datos
```

## Cómo ejecutarlo

### IntelliJ IDEA

1. **File → Open** y elige la carpeta `asesoria-ciclos`.
2. Clic derecho en `src` → **Mark Directory as → Sources Root** (si no lo detecta solo).
3. Abre `Main.java` y da clic en ▶ (Run).

### Terminal

```bash
cd JAVA/asesoria-ciclos
javac -encoding UTF-8 -d out $(find src -name "*.java")
java -cp out mx.edu.utez.ciclos.Main
```

## Menú principal

```
1. Ejemplos de while
2. Ejemplos de for
3. Ejemplos de do-while
4. Práctica guiada (versión para completar)
5. Práctica guiada (solución)
0. Salir
```

Los decimales se escriben con punto (`8.5`).
