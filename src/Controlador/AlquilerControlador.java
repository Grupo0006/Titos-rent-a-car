/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import DAO.DAOAlquiler;
import Modelo.POJOAlquiler;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author kreiv
 */
public class AlquilerControlador {
    private final DAOAlquiler alquilerDAO;
    
     public AlquilerControlador() {
        this.alquilerDAO = new DAOAlquiler();
     }
     
      public void crearAlquiler(Date fechaInicio, Date fechaFin) {
        try {
            POJOAlquiler alquiler = new POJOAlquiler();
            alquiler.setFecha_Inicio(fechaInicio);
            alquiler.setFecha_Fin(fechaFin);
            alquilerDAO.crearAlquiler(alquiler);
            JOptionPane.showMessageDialog(null, "Alquiler creado exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el alquiler: " + e.getMessage());
        }
    }
      
       public List<POJOAlquiler> obtenerTodosAlquileres() {
        try {
            return alquilerDAO.leerTodosAlquileres();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los alquileres: " + e.getMessage());
            return null;
        }
    }

    public POJOAlquiler obtenerAlquilerPorId(int idAlquiler) {
        try {
            return alquilerDAO.obtenerAlquilerPorId(idAlquiler);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el alquiler: " + e.getMessage());
            return null;
        }
    }

    public void actualizarAlquiler(int id, Date fechaInicio, Date fechaFin) {
        try {
            POJOAlquiler alquiler = new POJOAlquiler();
            alquiler.setId_Alquiler(id);
            alquiler.setFecha_Inicio(fechaInicio);
            alquiler.setFecha_Fin(fechaFin);
            alquilerDAO.actualizarAlquiler(alquiler);
            JOptionPane.showMessageDialog(null, "Alquiler actualizado exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el alquiler: " + e.getMessage());
        }
    }

    public void eliminarAlquiler(int id) {
        try {
            alquilerDAO.eliminarAlquiler(id);
            JOptionPane.showMessageDialog(null, "Alquiler eliminado exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el alquiler: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        AlquilerControlador controlador = new AlquilerControlador();

        // Crear un nuevo alquiler
        controlador.crearAlquiler(Date.valueOf("2025-06-01"), Date.valueOf("2025-06-10"));

        // Actualizar un alquiler existente
        controlador.actualizarAlquiler(1, Date.valueOf("2025-06-02"), Date.valueOf("2025-06-12"));

        // Eliminar un alquiler por ID
        controlador.eliminarAlquiler(3);

        // Listar todos los alquileres
        List<POJOAlquiler> lista = controlador.obtenerTodosAlquileres();
        if (lista != null) {
            for (POJOAlquiler alq : lista) {
                System.out.println("ID: " + alq.getId_Alquiler()
                        + ", Fecha Inicio: " + alq.getFecha_Inicio()
                        + ", Fecha Fin: " + alq.getFecha_Fin());
            }
        }
    }
}


