package modelo;

//MODELO: calcula el consumo de memoria ESTIMADO de cada estructura
public class Memoria {

    private static final int BYTES_POR_ENTERO = 4;

    public static String generarReporte(int v, int e, boolean dirigido) {
        long celdasMatrizAdy = (long) v * v;
        long referenciasListaAdy = dirigido ? e : 2L * e;
        long celdasMatrizInc = (long) v * e;
        long valoresListaAristas = 2L * e; // origen, destino por cada arista (ya no hay peso)

        long bytesMatrizAdy = celdasMatrizAdy * BYTES_POR_ENTERO;
        long bytesListaAdy = referenciasListaAdy * BYTES_POR_ENTERO;
        long bytesMatrizInc = celdasMatrizInc * BYTES_POR_ENTERO;
        long bytesListaAristas = valoresListaAristas * BYTES_POR_ENTERO;

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-22s %-12s %-10s %s%n", "Estructura", "Elementos", "Bytes", "Formula"));
        sb.append("--------------------------------------------------------------------\n");
        sb.append(String.format("%-22s %-12d %-10d V x V = %d x %d%n",
                "Matriz de adyacencia", celdasMatrizAdy, bytesMatrizAdy, v, v));
        sb.append(String.format("%-22s %-12d %-10d %s = %d%n",
                "Lista de adyacencia", referenciasListaAdy, bytesListaAdy,
                dirigido ? "E" : "2E", referenciasListaAdy));
        sb.append(String.format("%-22s %-12d %-10d V x E = %d x %d%n",
                "Matriz de incidencia", celdasMatrizInc, bytesMatrizInc, v, e));
        sb.append(String.format("%-22s %-12d %-10d 2E = %d%n",
                "Lista de aristas", valoresListaAristas, bytesListaAristas, valoresListaAristas));

        long minimo = Math.min(Math.min(bytesMatrizAdy, bytesListaAdy),
                Math.min(bytesMatrizInc, bytesListaAristas));

        // Se revisan las 4 estructuras (no solo la primera que coincida), para
        // poder avisar si hay empate entre dos o mas de ellas.
        java.util.List<String> mejores = new java.util.ArrayList<>();
        if (bytesMatrizAdy == minimo) mejores.add("Matriz de adyacencia");
        if (bytesListaAdy == minimo) mejores.add("Lista de adyacencia");
        if (bytesMatrizInc == minimo) mejores.add("Matriz de incidencia");
        if (bytesListaAristas == minimo) mejores.add("Lista de aristas");

        if (mejores.size() == 1) {
            sb.append("\nEstructura mas eficiente en memoria para este grafo: ").append(mejores.get(0));
        } else {
            sb.append("\nHay un empate en ").append(minimo).append(" bytes entre: ")
                    .append(String.join(", ", mejores));
        }
        return sb.toString();
    }
}