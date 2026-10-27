package ec.edu.taller;

import javax.swing.SwingUtilities;

/** Completar manualmente la interfaz Swing e integrarla con GestorImpresiones. */
public class InterfazImpresiones {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            javax.swing.JFrame frame = new javax.swing.JFrame("Centro de Impresión Universitario");
            VentanaImpresiones ventana = new VentanaImpresiones();
            frame.setContentPane(ventana.panel1);
            frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 450);
            frame.setLocationRelativeTo(null); // Centrar en la pantalla
            frame.setVisible(true);

        });
    }
}
