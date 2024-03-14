package telecomunicaciones;

import javax.swing.*;
import java.awt.*;

class JefeDesarrollo extends Empleado {
    public JefeDesarrollo(String nombre, String areaFuncional) {
        super(nombre, areaFuncional);
    }

    public void revisarSolicitud(Caso caso, boolean aceptar, String argumentoRechazo) {
        if (aceptar) {
            JOptionPane.showMessageDialog(null, "Solicitud aceptada");
            caso.cambiarEstado("En proceso");
        } else {
            caso.registrarArgumentoRechazo(argumentoRechazo);
            caso.cambiarEstado("Solicitud rechazada");
            JOptionPane.showMessageDialog(null, "Solicitud rechazada. Motivo: " + argumentoRechazo);
        }
    }

    // Método para mostrar un cuadro de diálogo de argumento de rechazo
    public String solicitarArgumentoRechazo() {
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(300, 200));

        JOptionPane.showMessageDialog(null, scrollPane, "Motivo del rechazo", JOptionPane.PLAIN_MESSAGE);

        return textArea.getText();
    }
}
