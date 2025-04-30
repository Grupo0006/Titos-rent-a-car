package Controlador;

import DAO.DAOMantenimiento;
import Modelo.Mantenimiento;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Maryi
 */
public class MantenimientoControlador {

    private final DAOMantenimiento mantenimientoDAO;

    public MantenimientoControlador() {
        this.mantenimientoDAO = new DAOMantenimiento();
    }

    public void crearMantenimiento(String descripcion, String justificacion, java.util.Date fechaInicio, java.util.Date fechaFin, double costo) {
        try {
            Mantenimiento m = new Mantenimiento();
            m.setDescripcion(descripcion);
            m.setJustificacion(justificacion);
            m.setFecha_Inicio(fechaInicio);
            m.setFecha_Fin(fechaFin);
            m.setCosto(costo);
            mantenimientoDAO.crearMantenimiento(m);
            JOptionPane.showMessageDialog(null, "Mantenimiento creado exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el mantenimiento: " + e.getMessage());
        }
    }

    public void actualizarMantenimiento(int id, String descripcion, String justificacion, java.util.Date fechaInicio, java.util.Date fechaFin, Double costo) {
        try {
            Mantenimiento m = new Mantenimiento();
            m.setId_Mantenimiento(id);
            m.setDescripcion(descripcion);
            m.setJustificacion(justificacion);
            m.setFecha_Inicio(fechaInicio);
            m.setFecha_Fin(fechaFin);
            m.setCosto(costo);
            mantenimientoDAO.actualizarMantenimiento(m);
            JOptionPane.showMessageDialog(null, "Mantenimiento actualizado exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el mantenimiento: " + e.getMessage());
        }
    }

    public void eliminarMantenimiento(int id) {
        try {
            mantenimientoDAO.eliminarMantenimiento(id);
            JOptionPane.showMessageDialog(null, "Mantenimiento eliminado exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el mantenimiento: " + e.getMessage());
        }
    }

    public List<Mantenimiento> obtenerTodosMantenimientos() {
        try {
            return mantenimientoDAO.leerTodosMantenimientos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al leer mantenimientos: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        MantenimientoControlador controlador = new MantenimientoControlador();

        // Crear
        controlador.crearMantenimiento("Limpieza general", "Mantenimiento trimestral", new java.util.Date(), new java.util.Date(), 70.00);

        // Actualizar
        controlador.actualizarMantenimiento(1, "Revisión de aire acondicionado", "Por fallos de temperatura", new java.util.Date(), new java.util.Date(), 70.00 );

        // Eliminar
        controlador.eliminarMantenimiento(3);

        // Leer
        List<Mantenimiento> lista = controlador.obtenerTodosMantenimientos();
        if (lista != null) {
            for (Mantenimiento m : lista) {
                System.out.println("ID: " + m.getId_Mantenimiento()
                        + ", Descripción: " + m.getDescripcion()
                        + ", Justificación: " + m.getJustificacion()
                        + ", Fecha Inicio: " + m.getFecha_Inicio()
                        + ", Fecha Fin: " + m.getFecha_Fin()
                        + ", Costo: " + m.getCosto());
            }
        }
    }

}

