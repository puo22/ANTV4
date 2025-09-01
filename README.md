# Proyecto Calculadora - Libro, Java y Python

Este proyecto contiene una **calculadora** implementada en Java y Python usando **ANTLR4**, junto con archivos de referencia en la carpeta `libro`.  
El proyecto está organizado para ser portable y ejecutable en cualquier máquina.


---
## Estructura del proyecto
Proyecto
libro/ # Archivos base de ejemplo, referencia del proyecto
Java/ # Código Java de la calculadora
Python/ # Código Python de la calculadora


---

## Carpeta `libro`

- Contiene archivos de referencia y ejemplos base para entender la implementación.  
- No es ejecutable, pero sirve como guía de cómo se resolvieron los ejercicios en Java y Python.

---

## Carpeta `Java`

### Contenido importante

- Calc.java → Clase principal que ejecuta la calculadora.
- EvalVisitor.java → Implementación de la evaluación de expresiones.
- LabeledExpr*.java → Archivos generados por ANTLR4 (Lexer, Parser, Visitor, Listener).
- LabeledExpr.g4 → Gramática ANTLR4 usada para generar los archivos Java.
- *.class → Archivos compilados.
- test.calc → Archivo de ejemplo para pruebas.

### Requisitos

- Java JDK 11+ instalado
- Terminal o IDE como IntelliJ, Eclipse o VS Code
- ANTLR4 instalado o configurado (opcional si quieres regenerar los archivos .java desde la gramática)

### Ejecución

1. Compilar los archivos Java
Desde la carpeta Java:

```bash
javac *.java
```
Esto compilará todos los archivos .java y generará los .class correspondientes.

2.Ejecutar la calculadora:
Ejecuta la clase principal Calc:
```bash
java Calc
```
La calculadora iniciará y mostrará el prompt, permitiendo ingresar expresiones para evaluar.

3. Opcional - Regenerar archivos desde la gramática ANTLR4

Si quieres regenerar los archivos .java desde LabeledExpr.g4:
- Asegúrate de tener ANTLR4 instalado.
- Ejecuta:
```bash
antlr4 LabeledExpr.g4
javac *.java
```
Esto generará automáticamente Lexer, Parser, Visitor, y Listener en Java.

4. Ejecutar pruebas

- Puedes usar el archivo test.calc como entrada de prueba.
- Por ejemplo, redirigiendo la entrada:
```bash
java Calc 
```
La calculadora iniciará y funcionará según el código Java incluido.

## Carpeta `Python`

- `Python/` → Código Python de la calculadora:
  - `calc.py` → Script principal de la calculadora.
  - `LabeledExpr*.py` → Archivos generados y auxiliares de ANTLR.
  - `requirements.txt` → Lista de librerías necesarias.

> Nota: No se incluye la carpeta `venv/` en el repositorio. Se debe crear un entorno virtual en cada máquina.

---

## Requisitos

- Python 3.13 o superior
- pip
- `antlr4-python3-runtime` (se instalará dentro del entorno virtual)

---

## Configuración y ejecución en Python

### 1️⃣ Clonar el proyecto

```bash
git clone <URL-del-repositorio>
cd <proyecto>/Python
````

### 2️⃣ Crear un entorno virtual

```bash
python3 -m venv venv
```

> Esto creará la carpeta `venv/` con un Python aislado para el proyecto.

### 3️⃣ Activar el entorno virtual

En Linux / WSL / macOS:

```bash
source venv/bin/activate
```

En Windows:

```bat
venv\Scripts\activate
```

> Verás `(venv)` al inicio del prompt, indicando que el entorno está activo.

### 4️⃣ Instalar las dependencias

```bash
pip install -r requirements.txt
```

* Esto instalará todas las librerías necesarias, en este caso:

```
antlr4-python3-runtime==4.13.2
```

---

### 5️⃣ Ejecutar la calculadora

```bash
python3 calc.py
```

* La calculadora iniciará y mostrará el prompt:

```
Calculadora ANTLR4 (Python)
Escribe 'exit' para salir
Modo actual: GRADOS
Comandos: mode=deg | mode=rad
>
```

---

### 6️⃣ Desactivar el entorno virtual

Cuando termines de trabajar:

```bash
deactivate
```

* Esto devuelve Python al intérprete del sistema.
* No afecta los archivos Java ni otros directorios del proyecto.

---

## Uso en otro dispositivo

1. Clonar el repositorio.
2. Ir a la carpeta `Python/`.
3. Crear un nuevo entorno virtual (`python3 -m venv venv`).
4. Activar el entorno virtual.
5. Instalar las dependencias (`pip install -r requirements.txt`).
6. Ejecutar la calculadora (`python3 calc.py`).

> De esta forma, tu proyecto es **totalmente portable** y funciona igual en cualquier máquina sin interferir con otros proyectos Python.

---

## Autor

Paula Alejandra Ortiz Salon

```
