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
        String sql = "INSERT INTO Empleado (cedula, nombre, apellido, direccion, email) VALUES (?, ?, ?, ?, ?)";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, empleado.getCedula());
            stmt.setString(2, empleado.getNombre());
            stmt.setString(3, empleado.getApellido());
            stmt.setString(4, empleado.getDireccion());
            stmt.setString(5, empleado.getEmail());
            stmt.executeUpdate();
        }
    }

       public List<Empleado> leerTodosEmpleados() throws SQLException {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM Empleado";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
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
    
    public void actualizarEmpleado(Empleado empleado) throws SQLException {
        String sql = "UPDATE Empleado SET cedula = ?, nombre = ?, apellido = ?, direccion = ?, email = ? WHERE id_empleado = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
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
        String sql = "DELETE FROM Empleado WHERE id_empleado = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, idEmpleado);
            stmt.executeUpdate();
        }
    }

    
    public static void main(String[] args) {
        try {
            DAOEmpleado dao = new DAOEmpleado();
 /*
            // Crear un nuevo empleado
            Empleado nuevoEmpleado = new Empleado();
            nuevoEmpleado.setCedula("0801199912345");
            nuevoEmpleado.setNombre("Carlos");
            nuevoEmpleado.setApellido("Ramírez");
            nuevoEmpleado.setDireccion("Calle Falsa 123");
            nuevoEmpleado.setEmail("carlos@correo.com");
            dao.crearEmpleado(nuevoEmpleado);
            System.out.println("Empleado creado exitosamente.");
            
            // Actualizar un empleado
            Empleado empleadoActualizado = new Empleado();
            empleadoActualizado.setId_Empleado(1); // Asegúrate que este ID exista
            empleadoActualizado.setCedula("0801199912345");
            empleadoActualizado.setNombre("Carlos Andrés");
            empleadoActualizado.setApellido("Ramírez López");
            empleadoActualizado.setDireccion("Calle Nueva 456");
            empleadoActualizado.setEmail("carlosnuevo@correo.com");
            dao.actualizarEmpleado(empleadoActualizado);
            System.out.println("Empleado actualizado exitosamente.");

            // Eliminar un empleado
            dao.eliminarEmpleado(2); // Cambia el ID si es necesario
            System.out.println("Empleado eliminado exitosamente.");
*/
            // Leer todos los empleados
            List<Empleado> empleados = dao.leerTodosEmpleados();
            System.out.println("Lista de empleados:");
            for (Empleado emp : empleados) {
                System.out.println("ID: " + emp.getId_Empleado()
                        + ", Cedula: " + emp.getCedula()
                        + ", Nombre: " + emp.getNombre()
                        + ", Apellido: " + emp.getApellido()
                        + ", Dirección: " + emp.getDireccion()
                        + ", Email: " + emp.getEmail());
            }
           
        } catch (SQLException e) {
            System.err.println("Error en operación DAO: " + e.getMessage());
        }
    }
}



