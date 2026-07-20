package principal;

import controlador.ControladorGrafo;
import vista.VistaGrafo;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VistaGrafo vista = new VistaGrafo();
            new ControladorGrafo(vista);
            vista.setVisible(true);
        });
    }
}
