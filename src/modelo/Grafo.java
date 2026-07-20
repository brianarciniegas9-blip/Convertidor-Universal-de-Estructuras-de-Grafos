package modelo;

//MODELO
public class Grafo {

    private final int[][] matriz;
    private final int vertices;
    private final boolean dirigido;

    public Grafo(int[][] matriz, boolean dirigido) {
        this.matriz = matriz;
        this.vertices = matriz.length;
        this.dirigido = dirigido;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public int getVertices() {
        return vertices;
    }

    public boolean isDirigido() {
        return dirigido;
    }

    /** Devuelve true si la matriz no tiene ninguna arista (todo en 0). */
    public boolean esVacio() {
        for (int[] fila : matriz) {
            for (int valor : fila) {
                if (valor != 0) return false;
            }
        }
        return true;
    }
}