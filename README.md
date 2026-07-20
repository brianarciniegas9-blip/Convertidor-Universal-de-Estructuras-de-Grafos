# Conversor Universal de Estructuras de Grafos

Aplicación de escritorio en Java (Swing) que permite ingresar un grafo mediante su **matriz de adyacencia** y convertirlo automáticamente a otras representaciones: **lista de adyacencia**, **lista de aristas** y **matriz de incidencia**. Además, calcula y compara el **consumo de memoria estimado** de cada una de estas cuatro estructuras, indicando cuál es la más eficiente.

## Características

- Generación dinámica de una tabla para ingresar la matriz de adyacencia (de 1 a 30 vértices).
- Soporte para grafos **dirigidos** y **no dirigidos**.
- Conversión a:
  - Lista de adyacencia
  - Lista de aristas
  - Matriz de incidencia
- Reporte comparativo de memoria (en bytes) entre las 4 estructuras, con fórmulas.
- Interfaz gráfica construida con Java Swing, siguiendo el patrón **MVC** (Modelo - Vista - Controlador).

## Arquitectura del proyecto

```
src/
├── principal/
│   └── Main.java              # Punto de entrada de la aplicación
├── modelo/
│   ├── Grafo.java              # Representa el grafo y su matriz de adyacencia
│   ├── Conversor.java          # Lógica de conversión entre estructuras
│   └── Memoria.java            # Cálculo del consumo de memoria estimado
├── vista/
│   └── VistaGrafo.java         # Interfaz gráfica (Swing)
└── controlador/
    └── ControladorGrafo.java   # Conecta la vista con el modelo
```

## Requisitos

- **JDK 25** o superior instalado y configurado en el `PATH`.
- (Opcional) **Apache NetBeans** con soporte para proyectos Ant/Java, si se desea abrir el proyecto con su IDE original.
- (Opcional) **Apache Ant**, si se desea compilar por línea de comandos usando el `build.xml` incluido.

Para verificar tu versión de Java:

```bash
java -version
```

## Instalación y configuración

### 1. Clonar el repositorio

```bash
git clone https://github.com/brianarciniegas9-blip/Convertidor-Universal-de-Estructuras-de-Grafos.git
cd Convertidor-Universal-de-Estructuras-de-Grafos
```

### 2. Ejecutar el proyecto

Hay tres formas de ejecutarlo, elige la que prefieras:

**Opción A — Ejecutar el .jar ya compilado (la más rápida):**

```bash
java -jar dist/ConversorGrafos.jar
```

**Opción B — Compilar y ejecutar con Ant (requiere Apache Ant instalado):**

```bash
ant clean
ant jar
java -jar dist/ConversorGrafos.jar
```

**Opción C — Abrir con NetBeans IDE:**

1. Abrir NetBeans.
2. `File > Open Project...`
3. Seleccionar la carpeta `ConversorGrafos` (la que contiene `build.xml`).
4. Ejecutar el proyecto con el botón ▶ (Run) o `Shift + F6`.

### 3. Uso de la aplicación

1. Indicar el número de vértices en el spinner y presionar **"Generar tabla"**.
2. Completar la matriz de adyacencia en la tabla (0 = sin arista, distinto de 0 = con arista).
3. Marcar la casilla **"Dirigido"** si el grafo es dirigido.
4. Presionar **"Convertir y analizar memoria"**.
5. Revisar en el panel derecho la lista de adyacencia, lista de aristas, matriz de incidencia y el reporte de consumo de memoria.

## Tecnologías utilizadas

- Java (JDK 25)
- Java Swing (interfaz gráfica)
- Apache Ant / NetBeans (build system)

## Autor

**Brian Arciniegas** — Ingenieria Informatica, UNEG
Asignatura: Tecnicas de Programación III — Prof. Dubraska Roca
- Sección  2
