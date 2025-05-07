/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import DAO.DAOCliente;
import Modelo.Cliente;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClienteControlador {
    
    private final DAOCliente DAOcliente;

    public ClienteControlador(DAOCliente DAOcliente) {
        this.DAOcliente = DAOcliente;
    }

    // Crear un nuevo cliente
    public void crearCliente(String cedula, String Nombre, String Apellido,
                                  String Telefono, String Direccion,
                                  String Email, String Licencia) {
        Cliente cliente = new Cliente();
        cliente.setCedula(cedula);
        cliente.setNombre(Nombre);
        cliente.setApellido(Apellido);
        cliente.setTelefono(Telefono);
        cliente.setDireccion(Direccion);
        cliente.setEmail(Email);
        cliente.setLicencia(Licencia);

        try {
            DAOcliente.crearCliente(cliente);
            JOptionPane.showMessageDialog(null, "Cliente creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Obtener todos los clientes
    public List<Cliente> obtenerTodosClientes() {
        try {
            return DAOcliente.leerTodosClientes();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al leer los clientes: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Actualizar cliente existente
    public void actualizarCliente(int idCliente, String cedula, String Nombre, String Apellido,
                                  String Telefono, String Direccion,
                                  String Email, String Licencia) {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(idCliente);
        cliente.setCedula(cedula);
        cliente.setNombre(Nombre);
        cliente.setApellido(Apellido);
        cliente.setTelefono(Telefono);
        cliente.setDireccion(Direccion);
        cliente.setEmail(Email);
        cliente.setLicencia(Licencia);

        try {
            DAOcliente.actualizarCliente(cliente);
            JOptionPane.showMessageDialog(null, "Cliente actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Eliminar cliente
    public void eliminarCliente(int idCliente) {
        try {
            DAOcliente.eliminarCliente(idCliente);
            JOptionPane.showMessageDialog(null, "Cliente eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteControlador.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al eliminar cliente: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método main para pruebas
    public static void main(String[] args) {
        DAOCliente dao = new DAOCliente();
        ClienteControlador controlador = new ClienteControlador(dao);

        // Crear cliente
        controlador.crearCliente("1234567890", "Juan", "Pérez", "0999999999", "Calle Falsa 123", "juan@example.com", "LIC123456");

        // Leer clientes
        List<Cliente> clientes = controlador.obtenerTodosClientes();
        if (clientes != null) {
            System.out.println("Lista de clientes:");
            for (Cliente c : clientes) {
                System.out.println("ID: " + c.getIdCliente()
                        + ", Nombre: " + c.getNombre() + "Apellido " + c.getApellido()
                        + " " + c.getTelefono() + " " + c.getDireccion()
                        + ", Cédula: " + c.getCedula());
            }
        }

        // Actualizar cliente con ID 1 (ajustar ID según tu base de datos)
        controlador.actualizarCliente( 1,"1234567890","Juan","Pérez","0888888888","Avenida 456","juan@example.com","LIC123456" );

        // Eliminar cliente con ID 1
        controlador.eliminarCliente(1);
    }
}


