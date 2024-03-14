package telecomunicaciones;

import javax.swing.*;
import java.awt.*;

class Empleado {
    private String nombre;
    private String areaFuncional;

    public Empleado(String nombre, String areaFuncional) {
        this.nombre = nombre;
        this.areaFuncional = areaFuncional;
    }

    public Caso solicitarAperturaCaso(String descripcion) {
        return new Caso(descripcion, this);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAreaFuncional() {
        return areaFuncional;
    }

    public void setAreaFuncional(String areaFuncional) {
        this.areaFuncional = areaFuncional;
    }

    // Método para mostrar un diálogo de solicitud de descripción
    public String solicitarDescripcion() {
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(300, 200));

        JOptionPane.showMessageDialog(null, scrollPane, "Solicitud de apertura de caso", JOptionPane.PLAIN_MESSAGE);

        return textArea.getText();
    }

    // Método para obtener el estado "en espera de respuesta"
    public static String obtenerEstadoEsperaRespuesta() {
        return "En espera de respuesta";
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
