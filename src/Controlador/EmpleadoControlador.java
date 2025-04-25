
package Controlador;

import DAO.DAOEmpleado;
import Modelo.Empleado;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Maryi 
 */
public class EmpleadoControlador {
  
    private final DAOEmpleado empleadoDAO;

    public EmpleadoControlador() {
        this.empleadoDAO = new DAOEmpleado();
    }

    public void crearEmpleado(String cedula, String nombre, String apellido, String direccion, String email) {
        try {
            Empleado empleado = new Empleado();
            empleado.setCedula(cedula);
            empleado.setNombre(nombre);
            empleado.setApellido(apellido);
            empleado.setDireccion(direccion);
            empleado.setEmail(email);
            empleadoDAO.crearEmpleado(empleado);
            JOptionPane.showMessageDialog(null, "Empleado creado exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el empleado: " + e.getMessage());
        }
    }

    public List<Empleado> obtenerTodosEmpleados() {
        try {
            return empleadoDAO.leerTodosEmpleados();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los empleados: " + e.getMessage());
            return null;
        }
    }

    public void actualizarEmpleado(int id, String cedula, String nombre, String apellido, String direccion, String email) {
        try {
            Empleado empleado = new Empleado();
            empleado.setId_Empleado(id);
            empleado.setCedula(cedula);
            empleado.setNombre(nombre);
            empleado.setApellido(apellido);
            empleado.setDireccion(direccion);
            empleado.setEmail(email);
            empleadoDAO.actualizarEmpleado(empleado);
            JOptionPane.showMessageDialog(null, "Empleado actualizado exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el empleado: " + e.getMessage());
        }
    }

    public void eliminarEmpleado(int id) {
        try {
            empleadoDAO.eliminarEmpleado(id);
            JOptionPane.showMessageDialog(null, "Empleado eliminado exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el empleado: " + e.getMessage());
        }
    }
}


