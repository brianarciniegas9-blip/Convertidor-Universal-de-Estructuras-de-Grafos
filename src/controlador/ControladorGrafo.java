package controlador;

import modelo.Conversor;
import modelo.Grafo;
import modelo.Memoria;
import vista.VistaGrafo;

import java.util.List;

//CONTROLADOR
public class ControladorGrafo {

    private final VistaGrafo vista;

    public ControladorGrafo(VistaGrafo vista) {
        this.vista = vista;
        vista.addConvertirListener(e -> convertir());
    }

    private void convertir() {
        try {
            int[][] matriz = vista.getMatrizIngresada();
            Grafo grafo = new Grafo(matriz, vista.isDirigido());

            if (grafo.esVacio()) {
                vista.mostrarAdvertencia("La matriz ingresada no tiene ninguna arista (todo en 0).\n"
                        + "El grafo se procesara igual, pero las 3 estructuras derivadas quedaran vacias.");
            }

            List<int[]> aristas = Conversor.obtenerAristas(grafo);

            StringBuilder resultado = new StringBuilder();
            resultado.append("=== LISTA DE ADYACENCIA ===\n");
            resultado.append(Conversor.aListaAdyacencia(grafo)).append("\n");

            resultado.append("=== LISTA DE ARISTAS ===\n");
            resultado.append(Conversor.aTextoListaAristas(aristas)).append("\n\n");

            resultado.append("=== MATRIZ DE INCIDENCIA ===\n");
            resultado.append(Conversor.aMatrizIncidencia(grafo, aristas)).append("\n");

            resultado.append("=== CONSUMO DE MEMORIA ===\n");
            resultado.append(Memoria.generarReporte(grafo.getVertices(), aristas.size(), grafo.isDirigido()));

            vista.mostrarResultado(resultado.toString());

        } catch (Exception ex) {
            vista.mostrarError("Ocurrio un error inesperado: " + ex.getMessage());
        }
    }
}