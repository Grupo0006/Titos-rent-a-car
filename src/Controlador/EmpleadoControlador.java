package Controlador;

import DAO.DAOEmpleado;
import Modelo.Empleado;
import java.sql.SQLException;
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

    public void crearEmpleado(String cedula, String nombre1,String nombre2, String apellido1,String apellido2, String direccion, String email) {
        try {
            Empleado empleado = new Empleado();
            empleado.setCedula(cedula);
            empleado.setNombre1(nombre1);
            empleado.setNombre2(nombre2);
            empleado.setApellido1(apellido1);
            empleado.setApellido2(apellido2);
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

    public void actualizarEmpleado(int id, String cedula, String nombre1,String nombre2, String apellido1,String apellido2, String direccion, String email) {
        try {
            Empleado empleado = new Empleado();
            empleado.setId_Empleado(id);
            empleado.setCedula(cedula);
            empleado.setNombre1(nombre1);
            empleado.setNombre2(nombre2);
            empleado.setApellido1(apellido1);
            empleado.setApellido2(apellido2);
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

    public static void main(String[] args) {
        EmpleadoControlador controlador = new EmpleadoControlador();
        
        // Crear empleado
        controlador.crearEmpleado("0501198712345", "Luis","Fernando","Diaz", "González", "Colonia Centro", "luis@correo.com");

        // Actualizar empleado
        controlador.actualizarEmpleado(1, "0501198712345", "Luis", "Alberto", "González", "Pérez", "Colonia Moderna", "luisalberto@correo.com");

        // Eliminar empleado
        controlador.eliminarEmpleado(3); // Asegúrate que exista el ID

        // Leer todos los empleados y mostrarlos en consola
        List<Empleado> lista = controlador.obtenerTodosEmpleados();
        if (lista != null) {
            for (Empleado emp : lista) {
                System.out.println("ID: " + emp.getId_Empleado()
                        + ", Cedula: " + emp.getCedula()
                        + ", Nombre1: " + emp.getNombre1()
                        + ", Nombre2: " + emp.getNombre2()
                        + ", Apellido1: " + emp.getApellido1()
                        + ", Apellido2: " + emp.getApellido2()
                        + ", Dirección: " + emp.getDireccion()
                        + ", Email: " + emp.getEmail());
            }
        }
    }
    
    public Empleado obtenerEmpleadoPorId(int Id_Empleado) {
        try {
            DAOEmpleado DAO = new DAOEmpleado();
            return DAO.obtenerEmpleadoPorId(Id_Empleado);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el Empleado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
}


