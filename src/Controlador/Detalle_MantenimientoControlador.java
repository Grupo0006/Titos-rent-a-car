package Controlador;

import DAO.DAODetalle_Mantenimiento;
import Modelo.POJODetalle_Mantenimiento;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Maryi
 */
public class Detalle_MantenimientoControlador {

    private final DAODetalle_Mantenimiento detalleDAO;

    public Detalle_MantenimientoControlador() {
        this.detalleDAO = new DAODetalle_Mantenimiento();
    }

    // Crear un nuevo detalle
    public void crearDetalle(int idMantenimiento, int idEmpleado, int idCoche, String observaciones, String recomendaciones, String partesCambiadas) {
        try {
            POJODetalle_Mantenimiento detalle = new POJODetalle_Mantenimiento();
            detalle.setIdMantenimiento(idMantenimiento);
            detalle.setIdEmpleado(idEmpleado);
            detalle.setIdCoche(idCoche);
            detalle.setObservaciones(observaciones);
            detalle.setRecomendaciones(recomendaciones);
            detalle.setPartesCambiadas(partesCambiadas);
            detalleDAO.crearDetalleMantenimiento(detalle);
            JOptionPane.showMessageDialog(null, "Detalle de mantenimiento creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el detalle: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Leer un detalle por ID
    public POJODetalle_Mantenimiento obtenerDetalle(int id) {
        try {
            return detalleDAO.leerDetallePorId(id);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el detalle: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Actualizar un detalle
    public void actualizarDetalle(int idDetalle, int idMantenimiento, int idEmpleado, int idCoche, String observaciones, String recomendaciones, String partesCambiadas) {
        try {
            POJODetalle_Mantenimiento detalle = new POJODetalle_Mantenimiento();
            detalle.setIdDetalleMantenimiento(idDetalle);
            detalle.setIdMantenimiento(idMantenimiento);
            detalle.setIdEmpleado(idEmpleado);
            detalle.setIdCoche(idCoche);
            detalle.setObservaciones(observaciones);
            detalle.setRecomendaciones(recomendaciones);
            detalle.setPartesCambiadas(partesCambiadas);
            detalleDAO.actualizarDetalleMantenimiento(detalle);
            JOptionPane.showMessageDialog(null, "Detalle de mantenimiento actualizado.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el detalle: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Eliminar un detalle
    public void eliminarDetalle(int id) {
        try {
            detalleDAO.eliminarDetalleMantenimiento(id);
            JOptionPane.showMessageDialog(null, "Detalle de mantenimiento eliminado.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el detalle: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Prueba rápida
    public static void main(String[] args) {
        Detalle_MantenimientoControlador controlador = new Detalle_MantenimientoControlador();

        // Crear
        controlador.crearDetalle(1, 101, 202, "Cambio de pastillas de freno", "Revisión en 10 días", "Pastillas, aceite");

        // Leer
        POJODetalle_Mantenimiento detalle = controlador.obtenerDetalle(1); // Asegúrate de que el ID existe
        if (detalle != null) {
            System.out.println("Detalle leído:");
            System.out.println("Empleado: " + detalle.getIdEmpleado());
            System.out.println("Observaciones: " + detalle.getObservaciones());
        }

        // Actualizar
        controlador.actualizarDetalle(1, 1, 101, 202, "Cambio completo de frenos", "Chequeo mensual", "Discos, pastillas");

        // Eliminar
        controlador.eliminarDetalle(1);
    }

}
