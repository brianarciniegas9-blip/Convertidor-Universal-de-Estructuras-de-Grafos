package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

//VISTA

public class VistaGrafo extends JFrame {

    private final JSpinner spinnerVertices;
    private final JButton btnGenerarTabla;
    private final JCheckBox chkDirigido;
    private final JButton btnConvertir;
    private final JTable tablaMatriz;
    private DefaultTableModel modeloTabla;
    private final JTextArea txtSalida;

    public VistaGrafo() {
        super("Conversor Universal de Estructuras de Grafos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // ---- Panel izquierdo: entrada ----
        JPanel panelEntrada = new JPanel(new BorderLayout(5, 5));
        panelEntrada.setBorder(BorderFactory.createTitledBorder("Matriz de adyacencia"));

        JPanel panelConfig = new JPanel(new FlowLayout(FlowLayout.LEFT));
        spinnerVertices = new JSpinner(new SpinnerNumberModel(4, 1, 30, 1));
        btnGenerarTabla = new JButton("Generar tabla");
        panelConfig.add(new JLabel("Numero de vertices:"));
        panelConfig.add(spinnerVertices);
        panelConfig.add(btnGenerarTabla);
        panelEntrada.add(panelConfig, BorderLayout.NORTH);

        modeloTabla = new DefaultTableModel(4, 4);
        tablaMatriz = new JTable(modeloTabla);
        generarTabla(4);
        panelEntrada.add(new JScrollPane(tablaMatriz), BorderLayout.CENTER);

        JPanel panelOpciones = new JPanel(new FlowLayout(FlowLayout.LEFT));
        chkDirigido = new JCheckBox("Dirigido");
        btnConvertir = new JButton("Convertir y analizar memoria");
        panelOpciones.add(chkDirigido);
        panelOpciones.add(btnConvertir);
        panelEntrada.add(panelOpciones, BorderLayout.SOUTH);

        // ---- Panel derecho: resultados ----
        txtSalida = new JTextArea();
        txtSalida.setEditable(false);
        txtSalida.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        JScrollPane scrollSalida = new JScrollPane(txtSalida);
        scrollSalida.setBorder(BorderFactory.createTitledBorder("Resultados"));

        add(panelEntrada, BorderLayout.WEST);
        add(scrollSalida, BorderLayout.CENTER);

        setSize(1000, 550);
        setLocationRelativeTo(null);

        btnGenerarTabla.addActionListener(e -> generarTabla((Integer) spinnerVertices.getValue()));
    }

    /** Reconstruye la tabla de entrada con una matriz N x N vacia (llena de 0). */
    private void generarTabla(int n) {
        String[] columnas = new String[n];
        for (int i = 0; i < n; i++) {
            columnas[i] = String.valueOf(i);
        }
        modeloTabla = new DefaultTableModel(columnas, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                modeloTabla.setValueAt(0, i, j);
            }
        }
        tablaMatriz.setModel(modeloTabla);
    }

    /** Lee la matriz actualmente escrita en la tabla, celda por celda. */
    public int[][] getMatrizIngresada() {
        int n = modeloTabla.getRowCount();
        int[][] matriz = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Object valor = modeloTabla.getValueAt(i, j);
                matriz[i][j] = parsearEntero(valor);
            }
        }
        return matriz;
    }

    private int parsearEntero(Object valor) {
        if (valor == null) return 0;
        try {
            return Integer.parseInt(valor.toString().trim());
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

    public boolean isDirigido() {
        return chkDirigido.isSelected();
    }

    public void mostrarResultado(String texto) {
        txtSalida.setText(texto);
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarAdvertencia(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Aviso", JOptionPane.WARNING_MESSAGE);
    }

    public void addConvertirListener(ActionListener l) {
        btnConvertir.addActionListener(l);
    }
}