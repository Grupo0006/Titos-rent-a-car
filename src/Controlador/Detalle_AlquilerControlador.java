/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import DAO.DAODetalle_Alquiler;
import Modelo.POJODetalle_Alquiler;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author kreiv
 */
public class Detalle_AlquilerControlador {
    private final DAODetalle_Alquiler daoDetalle_Alquiler;

    public Detalle_AlquilerControlador() {
        this.daoDetalle_Alquiler = new DAODetalle_Alquiler();
    }

    public void crearDetalle_Alquiler(int idAlquiler, int idCoche, int idCliente, double precioTotal) {
        try {
            POJODetalle_Alquiler detalle = new POJODetalle_Alquiler();
            detalle.setId_Alquiler(idAlquiler);
            detalle.setId_Coche(idCoche);
            detalle.setId_Cliente(idCliente);
            detalle.setPrecio_Total(precioTotal);
            daoDetalle_Alquiler.crearDetalleAlquiler(detalle);
            JOptionPane.showMessageDialog(null, "Detalle_Alquiler creado exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el Detalle_Alquiler: " + e.getMessage());
        }
    }

    public void actualizarDetalle_Alquiler(int idDetalle, int idAlquiler, int idCoche, int idCliente, double precioTotal) {
        try {
            POJODetalle_Alquiler detalle = new POJODetalle_Alquiler();
            detalle.setId_DetalleAlquiler(idDetalle);
            detalle.setId_Alquiler(idAlquiler);
            detalle.setId_Coche(idCoche);
            detalle.setId_Cliente(idCliente);
            detalle.setPrecio_Total(precioTotal);
            daoDetalle_Alquiler.actualizarDetalleAlquiler(detalle);
            JOptionPane.showMessageDialog(null, "Detalle_Alquiler actualizado exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el Detalle_Alquiler: " + e.getMessage());
        }
    }

    public void eliminarDetalle_Alquiler(int idDetalle) {
        try {
            daoDetalle_Alquiler.eliminarDetalleAlquiler(idDetalle);
            JOptionPane.showMessageDialog(null, "Detalle_Alquiler eliminado exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el Detalle_Alquiler: " + e.getMessage());
        }
    }

    public POJODetalle_Alquiler obtenerDetalle_AlquilerPorId(int idDetalle) {
        try {
            return daoDetalle_Alquiler.obtenerDetallePorId(idDetalle);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el Detalle_Alquiler: " + e.getMessage());
            return null;
        }
    }

    public List<POJODetalle_Alquiler> obtenerTodosDetalle_Alquiler() {
        try {
            return daoDetalle_Alquiler.leerTodosDetalles();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los Detalle_Alquiler: " + e.getMessage());
            return null;
        }
    }
}

