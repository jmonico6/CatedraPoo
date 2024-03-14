package telecomunicaciones;

import javax.swing.*;
import java.awt.*;

public class Caso {
    private String descripcion;
    private String estado;
    private Empleado empleado;
    private String argumentoRechazo;

    public Caso(String descripcion, Empleado empleado) {
        this.descripcion = descripcion;
        this.empleado = empleado;
        this.estado = "En espera de respuesta";
    }

    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public void registrarArgumentoRechazo(String argumento) {
        this.argumentoRechazo = argumento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    // Método para mostrar un diálogo de argumento de rechazo
    public String solicitarArgumentoRechazo() {
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(500, 500));

        JOptionPane.showMessageDialog(null, scrollPane, "Registro de argumento de rechazo", JOptionPane.PLAIN_MESSAGE);

        return textArea.getText();
    }

    public void setDescripcion(String descripcion) {
    }
}
