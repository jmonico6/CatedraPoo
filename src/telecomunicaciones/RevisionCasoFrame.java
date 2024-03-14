package telecomunicaciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RevisionCasoFrame extends JFrame {
    private Empleado jefeEmpleado;
    private List<Caso> casosPendientes;

    public RevisionCasoFrame(Empleado jefeEmpleado, List<Caso> casosPendientes) {
        this.jefeEmpleado = jefeEmpleado;
        this.casosPendientes = casosPendientes;

        setTitle("Revisar casos");
        setSize(400, 300);

        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(new GridLayout(0, 1));

        // Agregar botones para cada caso
        for (Caso caso : casosPendientes) {
            JButton casoButton = new JButton("Caso: " + caso.getDescripcion());
            panel.add(casoButton);

            casoButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int decision = JOptionPane.showConfirmDialog(null, "¿Aceptar este caso?", "Confirmar decisión", JOptionPane.YES_NO_OPTION);
                    if (decision == JOptionPane.YES_OPTION) {
                        caso.cambiarEstado("Aceptado");
                        JOptionPane.showMessageDialog(null, "Caso aceptado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        Main.actualizarEstadoCaso("Aceptado"); // Llamar al método estático para actualizar el estado del caso en la ventana principal
                        dispose(); // Cerrar la ventana de revisión de casos
                    } else if (decision == JOptionPane.NO_OPTION) {
                        String argumentoRechazo = jefeEmpleado.solicitarArgumentoRechazo();
                        caso.registrarArgumentoRechazo(argumentoRechazo);
                        caso.cambiarEstado("Denegado");
                        JOptionPane.showMessageDialog(null, "Caso denegado correctamente. Motivo: " + argumentoRechazo, "Denegado", JOptionPane.INFORMATION_MESSAGE);
                        Main.actualizarEstadoCaso("Denegado"); // Llamar al método estático para actualizar el estado del caso en la ventana principal
                        dispose(); // Cerrar la ventana de revisión de casos
                    }
                }
            });
        }
    }
}
