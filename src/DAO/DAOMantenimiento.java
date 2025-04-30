package DAO;

import Modelo.Mantenimiento;
import Util.ConexionDB;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.List;

public class DAOMantenimiento {

    public void crearMantenimiento(Mantenimiento m) throws SQLException {
        String sql = "INSERT INTO Mantenimiento (Descripcion, Justificacion, Fecha_Inicio, Fecha_Fin, Costo) VALUES (?, ?, ?, ?, ?)";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, m.getDescripcion());
            stmt.setString(2, m.getJustificacion());
            stmt.setDate(3, new java.sql.Date(m.getFecha_Inicio().getTime()));
            stmt.setDate(4, new java.sql.Date(m.getFecha_Fin().getTime()));
            stmt.setDouble(5, m.getCosto());
            stmt.executeUpdate();
        }
    }

    public List<Mantenimiento> leerTodosMantenimientos() throws SQLException {
        List<Mantenimiento> lista = new ArrayList<>();
        String sql = "SELECT * FROM Mantenimiento";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Mantenimiento m = new Mantenimiento();
                m.setId_Mantenimiento(rs.getInt("id_mantenimiento"));
                m.setDescripcion(rs.getString("descripcion"));
                m.setJustificacion(rs.getString("justificacion"));
                m.setFecha_Inicio(rs.getDate("fecha_inicio"));
                m.setFecha_Fin(rs.getDate("fecha_fin"));
                m.setCosto(rs.getInt("Costo"));
                lista.add(m);
            }
        }
        return lista;
    }

    public void actualizarMantenimiento(Mantenimiento m) throws SQLException {
        String sql = "UPDATE Mantenimiento SET Descripcion = ?, Justificacion = ?, Fecha_Inicio = ?, Fecha_Fin = ?, Costo=? WHERE Id_Mantenimiento = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, m.getDescripcion());
            stmt.setString(2, m.getJustificacion());
            stmt.setDate(3, new java.sql.Date(m.getFecha_Inicio().getTime()));
            stmt.setDate(4, new java.sql.Date(m.getFecha_Fin().getTime()));
            stmt.setDouble(5, m.getCosto());
            stmt.setInt(6, m.getId_Mantenimiento());
            stmt.executeUpdate();
        }
    }

    public void eliminarMantenimiento(int id) throws SQLException {
        String sql = "DELETE FROM Mantenimiento WHERE Id_Mantenimiento = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public static void main(String[] args) {
        try {
            DAOMantenimiento dao = new DAOMantenimiento();

            // Crear
            Mantenimiento nuevo = new Mantenimiento();
            nuevo.setDescripcion("Revisión del sistema eléctrico");
            nuevo.setJustificacion("Prevención de fallos");
            nuevo.setFecha_Inicio(new java.util.Date());
            nuevo.setFecha_Fin(new java.util.Date());
            nuevo.setCosto(2000);
            dao.crearMantenimiento(nuevo);
            System.out.println("Mantenimiento creado.");

            // Actualizar
            Mantenimiento actualizado = new Mantenimiento();
            actualizado.setId_Mantenimiento(1); // Asegúrate de usar un ID existente
            actualizado.setDescripcion("Mantenimiento de rutina");
            actualizado.setJustificacion("Seguimiento mensual");
            actualizado.setFecha_Inicio(new java.util.Date());
            actualizado.setFecha_Fin(new java.util.Date());
            actualizado.setCosto(1000);
            dao.actualizarMantenimiento(actualizado);
            System.out.println("Mantenimiento actualizado.");

            // Eliminar
            dao.eliminarMantenimiento(2); // Cambia según el ID
            System.out.println("Mantenimiento eliminado.");

            // Leer
            List<Mantenimiento> lista = dao.leerTodosMantenimientos();
            System.out.println("Lista de mantenimiento:");
            for (Mantenimiento m : lista) {
                System.out.println("ID: " + m.getId_Mantenimiento()
                        + ", Descripción: " + m.getDescripcion()
                        + ", Justificación: " + m.getJustificacion()
                        + ", Inicio: " + m.getFecha_Inicio()
                        + ", Fin: " + m.getFecha_Fin()
                        + ", Costo: " + m.getCosto());
            }

        } catch (SQLException e) {
            System.err.println("Error en DAO: " + e.getMessage());
        }
    }
}

