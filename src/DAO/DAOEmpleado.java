
package DAO;
import Modelo.Empleado;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DAOEmpleado {
     public void crearEmpleado(Empleado empleado) throws SQLException {
        String sql = "INSERT INTO Empleados (cedula, nombre, apellido, direccion, email) VALUES (?, ?, ?, ?, ?)";

        try (Connection c = ConexionDB.getConnection();
             PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, empleado.getCedula());
            stmt.setString(2, empleado.getNombre());
            stmt.setString(3, empleado.getApellido());
            stmt.setString(4, empleado.getDireccion());
            stmt.setString(5, empleado.getEmail());
            stmt.executeUpdate();
        }
    }

    public void actualizarEmpleado(Empleado empleado) throws SQLException {
        String sql = "UPDATE Empleados SET cedula = ?, nombre = ?, apellido = ?, direccion = ?, email = ? WHERE id_empleado = ?";

        try (Connection c = ConexionDB.getConnection();
             PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, empleado.getCedula());
            stmt.setString(2, empleado.getNombre());
            stmt.setString(3, empleado.getApellido());
            stmt.setString(4, empleado.getDireccion());
            stmt.setString(5, empleado.getEmail());
            stmt.setInt(6, empleado.getId_Empleado());
            stmt.executeUpdate();
        }
    }

    public void eliminarEmpleado(int idEmpleado) throws SQLException {
        String sql = "DELETE FROM Empleados WHERE id_empleado = ?";

        try (Connection c = ConexionDB.getConnection();
             PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, idEmpleado);
            stmt.executeUpdate();
        }
    }

    public List<Empleado> leerTodosEmpleados() throws SQLException {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM Empleados";

        try (Connection c = ConexionDB.getConnection();
             PreparedStatement stmt = c.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Empleado e = new Empleado();
                e.setId_Empleado(rs.getInt("id_empleado"));
                e.setCedula(rs.getString("cedula"));
                e.setNombre(rs.getString("nombre"));
                e.setApellido(rs.getString("apellido"));
                e.setDireccion(rs.getString("direccion"));
                e.setEmail(rs.getString("email"));
                lista.add(e);
            }
        }

        return lista;
    }
}

