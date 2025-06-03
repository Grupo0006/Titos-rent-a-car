package DAO;

import Modelo.POJOEmpleado;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOEmpleado {

    public void crearEmpleado(POJOEmpleado empleado) throws SQLException {
        String sql = "INSERT INTO Empleado (Cedula, Nombre1,Nombre2, Apellido1,Apellido2, Direccion, Email) VALUES (?, ?, ?, ?, ?,?,?)";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, empleado.getCedula());
            stmt.setString(2, empleado.getNombre1());
            stmt.setString(3, empleado.getNombre2());
            stmt.setString(4, empleado.getApellido1());
            stmt.setString(5, empleado.getApellido2());
            stmt.setString(6, empleado.getDireccion());
            stmt.setString(7, empleado.getEmail());
            stmt.executeUpdate();
        }
    }

    public List<POJOEmpleado> leerTodosEmpleados() throws SQLException {
        List<POJOEmpleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM Empleado";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                POJOEmpleado e = new POJOEmpleado();
                e.setId_Empleado(rs.getInt("id_empleado"));
                e.setCedula(rs.getString("Cedula"));
                e.setNombre1(rs.getString("Nombre1"));
                e.setNombre2(rs.getString("Nombre2"));
                e.setApellido1(rs.getString("Apellido1"));
                e.setApellido2(rs.getString("Apellido2"));
                e.setDireccion(rs.getString("Direccion"));
                e.setEmail(rs.getString("Email"));
                lista.add(e);
            }
        }

        return lista;
    }
    
        //Obtener Empleados por Id
    public POJOEmpleado obtenerEmpleadoPorId(int idEmpleado) throws SQLException {
        String sql = "SELECT * FROM Empleado WHERE Id_Empleado = ?";
        POJOEmpleado empleado = null;

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, idEmpleado);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    empleado = new POJOEmpleado();
                    empleado.setId_Empleado(rs.getInt("Id_Empleado"));
                    empleado.setCedula(rs.getString("Cedula"));
                    empleado.setNombre1(rs.getString("Nombre1"));
                    empleado.setNombre2(rs.getString("Nombre2"));
                    empleado.setApellido1(rs.getString("Apellido1"));
                    empleado.setApellido2(rs.getString("Apellido2"));
                    empleado.setDireccion(rs.getString("Direccion"));
                    empleado.setEmail(rs.getString("Email"));
                }
            }
        }

        return empleado;
    }

    public void actualizarEmpleado(POJOEmpleado empleado) throws SQLException {
        String sql = "UPDATE Empleado SET Cedula = ?, Nombre1 = ?, Nombre2 = ?, Apellido1 = ?, Apellido2 = ?, Direccion = ?, Email = ? WHERE Id_Empleado = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, empleado.getCedula());
            stmt.setString(2, empleado.getNombre1());
            stmt.setString(3, empleado.getNombre2());
            stmt.setString(4, empleado.getApellido1());
            stmt.setString(5, empleado.getApellido2());
            stmt.setString(6, empleado.getDireccion());
            stmt.setString(7, empleado.getEmail());
            stmt.setInt(8, empleado.getId_Empleado());
            stmt.executeUpdate();
        }
    }

    public void eliminarEmpleado(int idEmpleado) throws SQLException {
        String sql = "DELETE FROM Empleado WHERE Id_Empleado = ?";

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
            POJOEmpleado nuevoEmpleado = new POJOEmpleado();
            nuevoEmpleado.setCedula("0801199912345");
            nuevoEmpleado.setNombre("Carlos");
            nuevoEmpleado.setApellido("Ramírez");
            nuevoEmpleado.setDireccion("Calle Falsa 123");
            nuevoEmpleado.setEmail("carlos@correo.com");
            dao.crearEmpleado(nuevoEmpleado);
            System.out.println("POJOEmpleado creado exitosamente.");
            
            // Actualizar un empleado
            POJOEmpleado empleadoActualizado = new POJOEmpleado();
            empleadoActualizado.setId_Empleado(1); // Asegúrate que este ID exista
            empleadoActualizado.setCedula("0801199912345");
            empleadoActualizado.setNombre("Carlos Andrés");
            empleadoActualizado.setApellido("Ramírez López");
            empleadoActualizado.setDireccion("Calle Nueva 456");
            empleadoActualizado.setEmail("carlosnuevo@correo.com");
            dao.actualizarEmpleado(empleadoActualizado);
            System.out.println("POJOEmpleado actualizado exitosamente.");

            // Eliminar un empleado
            dao.eliminarEmpleado(2); // Cambia el ID si es necesario
            System.out.println("POJOEmpleado eliminado exitosamente.");
             */
            // Leer todos los empleados
            List<POJOEmpleado> empleados = dao.leerTodosEmpleados();
            System.out.println("Lista de empleados:");
            for (POJOEmpleado emp : empleados) {
                System.out.println("ID: " + emp.getId_Empleado()
                        + ", Cedula: " + emp.getCedula()
                        + ", Nombre1: " + emp.getNombre1()
                        + ", Nombre2: " + emp.getNombre2()
                        + ", Apellido1: " + emp.getApellido1()
                        + ", Apellido2: " + emp.getApellido2()
                        + ", Dirección: " + emp.getDireccion()
                        + ", Email: " + emp.getEmail());
            }

        } catch (SQLException e) {
            System.err.println("Error en operación DAO: " + e.getMessage());
        }
    }
}
