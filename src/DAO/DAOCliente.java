package DAO;

import Modelo.Cliente;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOCliente {

    public void crearCliente(Cliente cliente) throws SQLException {
        String sql = """
        INSERT INTO Clientes (
                 Cedula,
                 Nombre1,
                 Nombre2,
                 Apellido1,
                 Apellido2,    
                 Telefono,
                 Direccion,
                 Email,
                 Licencia
        ) VALUES (?, ?, ?, ?, ?, ?, ?)""";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {

            stmt.setString(1, cliente.getCedula());
            stmt.setString(2, cliente.getNombre1());
            stmt.setString(3, cliente.getNombre2());
            stmt.setString(4, cliente.getApellido1());
            stmt.setString(5, cliente.getApellido2());
            stmt.setString(6, cliente.getTelefono());
            stmt.setString(7, cliente.getDireccion());
            stmt.setString(8, cliente.getEmail());
            stmt.setString(9, cliente.getLicencia());
            stmt.executeUpdate();
        }
    }

    public void actualizarCliente(Cliente cliente) throws SQLException {
        String sql = "UPDATE Clientes SET cedula = ?, nombre1 = ?, nombre2 = ?, apellido1 = ?, apellido2 = ?,telefono = ?, direccion = ?, email= ?, licencia = ? WHERE id_cliente = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {

            stmt.setString(1, cliente.getCedula());
            stmt.setString(2, cliente.getNombre1());
            stmt.setString(3, cliente.getNombre2());
            stmt.setString(4, cliente.getApellido1());
            stmt.setString(5, cliente.getApellido2());
            stmt.setString(6, cliente.getTelefono());
            stmt.setString(7, cliente.getDireccion());
            stmt.setString(8, cliente.getEmail());
            stmt.setString(9, cliente.getLicencia());
            stmt.executeUpdate();
        }
    }

    public void eliminarCliente(int idCliente) throws SQLException {
        String sql = "DELETE FROM Clientes WHERE id_cliente = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);
            stmt.executeUpdate();
        }
    }

    public static void main(String[] args) {
        try {
            DAOCliente dao = new DAOCliente();

            // Crear un nuevo cliente
            Cliente cliente = new Cliente();
            cliente.setCedula("12345678");
            cliente.setNombre1("Juan");
            cliente.setApellido2("José");
            cliente.setApellido1("Mendosa");
            cliente.setApellido2("Pérez");
            cliente.setTelefono("1234567890");
            cliente.setDireccion("Calle 123");
            cliente.setEmail("juan.perez@email.com");
            cliente.setLicencia("B123456");

            dao.crearCliente(cliente); // Llamada al método para insertar el cliente en la base de datos
            System.out.println("Cliente creado.");

            // Leer y mostrar todos los clientes para verificar
            List<Cliente> clientes = dao.leerTodosClientes(); // Método para obtener todos los clientes
            System.out.println("Lista de clientes:");
            for (Cliente cli : clientes) {
                System.out.println("Cédula: " + cli.getCedula()
                        + ", Nombre: " + cli.getNombre1()
                        + ", Nombre: " + cli.getNombre2()
                        + ", Apellido: " + cli.getApellido1()
                        + ", Apellido: " + cli.getApellido2()
                        + ", Teléfono: " + cli.getTelefono()
                        + ", Dirección: " + cli.getDireccion()
                        + ", Email: " + cli.getEmail()
                        + ", Licencia: " + cli.getLicencia());
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public List<Cliente> leerTodosClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT id_cliente, cedula, nombre1,  nombre2, apellido1, apellido2, telefono, direccion, email, licencia FROM Clientes";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setCedula(rs.getString("cedula"));
                cliente.setNombre1(rs.getString("nombre1"));
                cliente.setNombre2(rs.getString("nombre2"));
                cliente.setApellido1(rs.getString("apellido1"));
                cliente.setApellido2(rs.getString("apellido2"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setEmail(rs.getString("email"));
                cliente.setLicencia(rs.getString("licencia"));
                clientes.add(cliente);
            }
        }

        return clientes;
    }
}
