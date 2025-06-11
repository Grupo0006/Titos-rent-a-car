package DAO;

import Modelo.POJOCliente;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOCliente {

    public void crearCliente(POJOCliente cliente) throws SQLException {
        String sql = """
        INSERT INTO Cliente (
                 Cedula,
                 Nombre1,
                 Nombre2,
                 Apellido1,
                 Apellido2,    
                 Telefono,
                 Direccion,
                 Email,
                 Licencia
        ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)""";

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
    
    public POJOCliente obtenerClientePorId(int IdCliente) throws SQLException {
        String sql = "SELECT * FROM Cliente WHERE Id_Cliente = ?";
        POJOCliente cliente = null;

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, IdCliente);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    cliente = new POJOCliente();
                    cliente.setIdCliente(rs.getInt("Id_Cliente"));
                    cliente.setCedula(rs.getString("Cedula"));
                    cliente.setNombre1(rs.getString("Nombre1"));
                    cliente.setNombre2(rs.getString("Nombre2"));
                    cliente.setApellido1(rs.getString("Apellido1"));
                    cliente.setApellido2(rs.getString("Apellido2"));
                    cliente.setDireccion(rs.getString("Direccion"));
                    cliente.setTelefono(rs.getString("Telefono"));
                    cliente.setEmail(rs.getString("Email"));
                    cliente.setLicencia(rs.getString("Licencia"));
                }
            }
        }

        return cliente;
    }

    public void actualizarCliente(POJOCliente cliente) throws SQLException {
        String sql = "UPDATE Cliente SET Cedula = ?, Nombre1 = ?, Nombre2 = ?, Apellido1 = ?, Apellido2 = ?,Telefono = ?, Direccion = ?, Email= ?, Licencia = ? WHERE Id_Cliente = ?";

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
            stmt.setInt(10,cliente.getIdCliente());
            stmt.executeUpdate();
        }
    }

    public void eliminarCliente(int idCliente) throws SQLException {
        String sql = "DELETE FROM Cliente WHERE Id_Cliente = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);
            stmt.executeUpdate();
        }
    }

    public static void main(String[] args) {
        try {
            DAOCliente dao = new DAOCliente();

  
  

            // Leer y mostrar todos los clientes para verificar
            List<POJOCliente> clientes = dao.leerTodosClientes(); // Método para obtener todos los clientes
            System.out.println("Lista de clientes:");
            for (POJOCliente cli : clientes) {
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

    public List<POJOCliente> leerTodosClientes() throws SQLException {
        List<POJOCliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                POJOCliente cliente = new POJOCliente();
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
