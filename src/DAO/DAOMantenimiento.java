package DAO;

import Modelo.POJOMantenimiento;
import Util.ConexionDB;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.List;

public class DAOMantenimiento {

    public void crearMantenimiento(POJOMantenimiento m) throws SQLException {
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

    public List<POJOMantenimiento> leerTodosMantenimientos() throws SQLException {
        List<POJOMantenimiento> lista = new ArrayList<>();
        String sql = "SELECT * FROM Mantenimiento";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                POJOMantenimiento m = new POJOMantenimiento();
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

    public void actualizarMantenimiento(POJOMantenimiento m) throws SQLException {
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
}

