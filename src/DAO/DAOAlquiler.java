/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Modelo.POJOAlquiler;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kreiv
 */
public class DAOAlquiler {
    public void crearAlquiler(POJOAlquiler alquiler) throws SQLException {
        String sql = "INSERT INTO Alquiler (Fecha_Inicio, Fecha_Fin) VALUES (?, ?)";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setDate(1, alquiler.getFecha_Inicio());
            stmt.setDate(2, alquiler.getFecha_Fin());
            stmt.executeUpdate();
        }
    }
    
    public void actualizarAlquiler(POJOAlquiler alquiler) throws SQLException {
        String sql = "UPDATE Alquiler SET Fecha_Inicio = ?, Fecha_Fin = ? WHERE Id_Alquiler = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setDate(1, alquiler.getFecha_Inicio());
            stmt.setDate(2, alquiler.getFecha_Fin());
            stmt.setInt(3, alquiler.getId_Alquiler());
            stmt.executeUpdate();
        }
    }

    public void eliminarAlquiler(int idAlquiler) throws SQLException {
        String sql = "DELETE FROM Alquiler WHERE Id_Alquiler = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, idAlquiler);
            stmt.executeUpdate();
        }
    }

    public POJOAlquiler obtenerAlquilerPorId(int idAlquiler) throws SQLException {
        String sql = "SELECT Id_Alquiler, Fecha_Inicio, Fecha_Fin FROM Alquiler WHERE Id_Alquiler = ?";
        POJOAlquiler alquiler = null;

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, idAlquiler);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    alquiler = new POJOAlquiler();
                    alquiler.setId_Alquiler(rs.getInt("Id_Alquiler"));
                    alquiler.setFecha_Inicio(rs.getDate("Fecha_Inicio"));
                    alquiler.setFecha_Fin(rs.getDate("Fecha_Fin"));
                }
            }
        }

        return alquiler;
    }

    public List<POJOAlquiler> leerTodosAlquileres() throws SQLException {
        List<POJOAlquiler> lista = new ArrayList<>();
        String sql = "SELECT Id_Alquiler, Fecha_Inicio, Fecha_Fin FROM Alquiler";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                POJOAlquiler alquiler = new POJOAlquiler();
                alquiler.setId_Alquiler(rs.getInt("Id_Alquiler"));
                alquiler.setFecha_Inicio(rs.getDate("Fecha_Inicio"));
                alquiler.setFecha_Fin(rs.getDate("Fecha_Fin"));
                lista.add(alquiler);
            }
        }

        return lista;
    }

    public static void main(String[] args) {
        try {
            DAOAlquiler dao = new DAOAlquiler();

            // Crear nuevo alquiler
            POJOAlquiler nuevo = new POJOAlquiler();
            nuevo.setFecha_Inicio(Date.valueOf("2025-06-01"));
            nuevo.setFecha_Fin(Date.valueOf("2025-06-10"));
            dao.crearAlquiler(nuevo);
            System.out.println("Alquiler creado.");

            // Leer y mostrar todos los alquileres
            List<POJOAlquiler> lista = dao.leerTodosAlquileres();
            System.out.println("Lista de alquileres:");
            for (POJOAlquiler alq : lista) {
                System.out.println("ID: " + alq.getId_Alquiler()
                        + ", Inicio: " + alq.getFecha_Inicio()
                        + ", Fin: " + alq.getFecha_Fin());
            }

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
}
