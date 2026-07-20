package modelo;

import java.util.ArrayList;
import java.util.List;

public class Conversor {

    public static String aListaAdyacencia(Grafo g) {
        int n = g.getVertices();
        int[][] m = g.getMatriz();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(i).append(" -> [");
            boolean primero = true;
            for (int j = 0; j < n; j++) {
                if (m[i][j] != 0) {
                    if (!primero) sb.append(", ");
                    sb.append(j);
                    primero = false;
                }
            }
            sb.append("]\n");
        }
        return sb.toString();
    }

    public static List<int[]> obtenerAristas(Grafo g) {
        int n = g.getVertices();
        int[][] m = g.getMatriz();
        List<int[]> aristas = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int jInicio = g.isDirigido() ? 0 : i + 1;
            for (int j = jInicio; j < n; j++) {
                if (m[i][j] != 0) {
                    aristas.add(new int[]{i, j});
                }
            }
        }
        return aristas;
    }

    public static String aTextoListaAristas(List<int[]> aristas) {
        StringBuilder sb = new StringBuilder("[");
        for (int k = 0; k < aristas.size(); k++) {
            int[] a = aristas.get(k);
            sb.append("(").append(a[0]).append(", ").append(a[1]).append(")");
            if (k < aristas.size() - 1) sb.append(", ");
        }
        return sb.append("]").toString();
    }

    public static String aMatrizIncidencia(Grafo g, List<int[]> aristas) {
        int n = g.getVertices();
        int e = aristas.size();
        int[][] incidencia = new int[n][e];

        for (int col = 0; col < e; col++) {
            int origen = aristas.get(col)[0];
            int destino = aristas.get(col)[1];
            if (g.isDirigido()) {
                incidencia[origen][col] = -1;
                incidencia[destino][col] = 1;
            } else {
                incidencia[origen][col] = 1;
                incidencia[destino][col] = 1;
            }
        }

        StringBuilder sb = new StringBuilder("     ");
        for (int col = 0; col < e; col++) sb.append(String.format("e%-3d", col));
        sb.append("\n");
        for (int i = 0; i < n; i++) {
            sb.append(i).append(" [ ");
            for (int col = 0; col < e; col++) sb.append(String.format("%3d ", incidencia[i][col]));
            sb.append("]\n");
        }
        return sb.toString();
    }
}