package telecomunicaciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static JLabel labelEstadoValor; // Agregamos este JLabel como atributo estático para que sea accesible desde la clase RevisionCasoFrame

    public static void main(String[] args) {
        Empleado jefeEmpleado = new Empleado("Juan", "Jefatura");
        List<Caso> casosPendientes = new ArrayList<>(); // Crear una lista para almacenar los casos pendientes

        JFrame frame = new JFrame("Solicitud de apertura de caso");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel, casosPendientes, jefeEmpleado);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel, List<Caso> casosPendientes, Empleado jefeEmpleado) {
        panel.setLayout(null);

        JLabel labelDescripcion = new JLabel("Descripción del caso:");
        labelDescripcion.setBounds(10, 20, 150, 25);
        panel.add(labelDescripcion);

        JTextArea textAreaDescripcion = new JTextArea();
        textAreaDescripcion.setBounds(170, 20, 200, 60);
        panel.add(textAreaDescripcion);

        JLabel labelEstado = new JLabel("Estado:");
        labelEstado.setBounds(10, 100, 150, 25);
        panel.add(labelEstado);

        labelEstadoValor = new JLabel("");
        labelEstadoValor.setBounds(170, 100, 200, 25);
        panel.add(labelEstadoValor);

        JButton enviarButton = new JButton("Enviar solicitud");
        enviarButton.setBounds(100, 140, 200, 25);
        panel.add(enviarButton);

        JButton revisarButton = new JButton("Revisar casos");
        revisarButton.setBounds(100, 180, 200, 25);
        panel.add(revisarButton);

        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String descripcion = textAreaDescripcion.getText();
                Caso nuevoCaso = jefeEmpleado.solicitarAperturaCaso(descripcion);
                casosPendientes.add(nuevoCaso); // Agregar el nuevo caso a la lista de casos pendientes
                labelEstadoValor.setText(nuevoCaso.getEstado());
                JOptionPane.showMessageDialog(null, "Descripción del caso enviada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        revisarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RevisionCasoFrame revisionCasoFrame = new RevisionCasoFrame(jefeEmpleado, casosPendientes);
                revisionCasoFrame.setVisible(true);
            }
        });
    }

    // Método estático para actualizar el estado del caso en la ventana principal
    public static void actualizarEstadoCaso(String nuevoEstado) {
        labelEstadoValor.setText(nuevoEstado);
    }
}
