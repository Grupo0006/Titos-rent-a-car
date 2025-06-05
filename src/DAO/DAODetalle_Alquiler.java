/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Modelo.POJODetalle_Alquiler;
import Util.ConexionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estudiantes
 */
public class DAODetalle_Alquiler {
    
    public void crearDetalleAlquiler(POJODetalle_Alquiler detalle) throws SQLException {
        String sql = """
            INSERT INTO Detalle_Alquiler (Id_Alquiler, Id_Coche, Id_Cliente, Precio_Total)
            VALUES (?, ?, ?, ?)
        """;

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, detalle.getId_Alquiler());
            stmt.setInt(2, detalle.getId_Coche());
            stmt.setInt(3, detalle.getId_Cliente());
            stmt.setDouble(4, detalle.getPrecio_Total());
            stmt.executeUpdate();
        }
    }

    public void actualizarDetalleAlquiler(POJODetalle_Alquiler detalle) throws SQLException {
        String sql = """
            UPDATE Detalle_Alquiler
            SET Id_Alquiler = ?, Id_Coche = ?, Id_Cliente = ?, Precio_Total = ?
            WHERE Id_DetalleAlquiler = ?
        """;

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, detalle.getId_Alquiler());
            stmt.setInt(2, detalle.getId_Coche());
            stmt.setInt(3, detalle.getId_Cliente());
            stmt.setDouble(4, detalle.getPrecio_Total());
            stmt.setInt(5, detalle.getId_DetalleAlquiler());
            stmt.executeUpdate();
        }
    }

    public void eliminarDetalleAlquiler(int idDetalle) throws SQLException {
        String sql = "DELETE FROM Detalle_Alquiler WHERE Id_DetalleAlquiler = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, idDetalle);
            stmt.executeUpdate();
        }
    }

    public POJODetalle_Alquiler obtenerDetallePorId(int idDetalle) throws SQLException {
        String sql = "SELECT * FROM Detalle_Alquiler WHERE Id_DetalleAlquiler = ?";
        POJODetalle_Alquiler detalle = null;

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, idDetalle);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    detalle = new POJODetalle_Alquiler();
                    detalle.setId_DetalleAlquiler(rs.getInt("Id_DetalleAlquiler"));
                    detalle.setId_Alquiler(rs.getInt("Id_Alquiler"));
                    detalle.setId_Coche(rs.getInt("Id_Coche"));
                    detalle.setId_Cliente(rs.getInt("Id_Cliente"));
                    detalle.setPrecio_Total(rs.getDouble("Precio_Total"));
                }
            }
        }

        return detalle;
    }

    public List<POJODetalle_Alquiler> leerTodosDetalles() throws SQLException {
        List<POJODetalle_Alquiler> lista = new ArrayList<>();
        String sql = "SELECT * FROM Detalle_Alquiler";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                POJODetalle_Alquiler detalle = new POJODetalle_Alquiler();
                detalle.setId_DetalleAlquiler(rs.getInt("Id_DetalleAlquiler"));
                detalle.setId_Alquiler(rs.getInt("Id_Alquiler"));
                detalle.setId_Coche(rs.getInt("Id_Coche"));
                detalle.setId_Cliente(rs.getInt("Id_Cliente"));
                detalle.setPrecio_Total(rs.getDouble("Precio_Total"));
                lista.add(detalle);
            }
        }

        return lista;
    }

    public static void main(String[] args) {
        try {
            DAODetalle_Alquiler dao = new DAODetalle_Alquiler();

            // Crear nuevo detalle de alquiler
            POJODetalle_Alquiler detalle = new POJODetalle_Alquiler();
            detalle.setId_Alquiler(1);
            detalle.setId_Coche(2);
            detalle.setId_Cliente(3);
            detalle.setPrecio_Total(1500.75);
            dao.crearDetalleAlquiler(detalle);
            System.out.println("Detalle de alquiler creado.");

            // Listar todos los detalles
            List<POJODetalle_Alquiler> detalles = dao.leerTodosDetalles();
            for (POJODetalle_Alquiler d : detalles) {
                System.out.println("ID: " + d.getId_DetalleAlquiler()
                        + ", Alquiler: " + d.getId_Alquiler()
                        + ", Coche: " + d.getId_Coche()
                        + ", Cliente: " + d.getId_Cliente()
                        + ", Precio: " + d.getPrecio_Total());
            }

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
}
