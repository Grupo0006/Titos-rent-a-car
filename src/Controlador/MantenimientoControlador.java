package Controlador;

import DAO.DAOMantenimiento;
import Modelo.POJOMantenimiento;
import java.sql.SQLException;
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
            POJOMantenimiento m = new POJOMantenimiento();
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
            POJOMantenimiento m = new POJOMantenimiento();
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

    public List<POJOMantenimiento> obtenerTodosMantenimientos() {
        try {
            return mantenimientoDAO.leerTodosMantenimientos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al leer mantenimientos: " + e.getMessage());
            return null;
        }
    }
}

