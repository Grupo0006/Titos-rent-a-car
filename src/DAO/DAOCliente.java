
package DAO;
import Modelo.Cliente;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DAOCliente {
    public void crearCliente(Cliente cliente) throws SQLException {
    String sql = """
        INSERT INTO Clientes (
                 Cedula,
                 Nombre,
                 Apellido,
                 Telefono,
                 Direccion,
                 Email,
                 Licencia
        ) VALUES (?, ?, ?, ?, ?, ?, ?)""";
    
    try (Connection c = ConexionDB.getConnection();
         PreparedStatement stmt = c.prepareStatement(sql)) {
        stmt.setString(1, cliente.getIdCliente());
        stmt.setString(2, cliente.getCedula());
        stmt.setString(3, cliente.getNombre());
        stmt.setString(4, cliente.getApellido());
        stmt.setString(5, cliente.getTelefono());
        stmt.setString(6, cliente.getDireccion());
        stmt.setString(7, cliente.getEmail());
        stmt.setString(8, cliente.getLicencia());
        stmt.executeUpdate();
    }
}
    
    public void actualizarCliente(Cliente cliente) throws SQLException {
    String sql = "UPDATE Clientes SET cedula = ?, nombre = ?, apellido = ?, telefono = ?, direccion = ?, email= ?, licencia = ? WHERE id_cliente = ?";
    
    try (Connection c = ConexionDB.getConnection();
        PreparedStatement stmt = c.prepareStatement(sql)) {
        stmt.setString(1, cliente.getIdCliente());
        stmt.setString(2, cliente.getCedula());
        stmt.setString(3, cliente.getNombre());
        stmt.setString(4, cliente.getApellido());
        stmt.setString(5, cliente.getTelefono());
        stmt.setString(6, cliente.getDireccion());
        stmt.setString(7, cliente.getEmail());
        stmt.setString(8, cliente.getLicencia());
        stmt.executeUpdate();
    }
}
    
    public void eliminarCliente(int idCliente) throws SQLException {
    String sql = "DELETE FROM Clientes WHERE id_cliente = ?";
    
    try (Connection c = ConexionDB.getConnection();
         PreparedStatement stmt = c.prepareStatement(sql)) {
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
        cliente.setNombre("Juan");
        cliente.setApellido("Pérez");
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
            System.out.println("Cédula: " + cli.getCedula() + 
                               ", Nombre: " + cli.getNombre() + 
                               ", Apellido: " + cli.getApellido() + 
                               ", Teléfono: " + cli.getTelefono() + 
                               ", Dirección: " + cli.getDireccion() + 
                               ", Email: " + cli.getEmail() + 
                               ", Licencia: " + cli.getLicencia());
        }
    } catch (SQLException e) {
        System.err.println("Error: " + e.getMessage());
    }
}

    private List<Cliente> leerTodosClientes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
