/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.POJOCoche;
import Util.ConexionDB;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Ernesto José Sevilla Inglés
 */
public class DAOCoche {

    public void crearCoche(POJOCoche coche) throws SQLException {
        String sql = """
        INSERT INTO Coche (
            marca, modelo, placa, color, estado, anio, fecha_registro
        ) VALUES (?, ?, ?, ?, ?, ?, ?)
        """;

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, coche.getMarca());
            stmt.setString(2, coche.getModelo());
            stmt.setString(3, coche.getPlaca());
            stmt.setString(4, coche.getColor());
            stmt.setString(5, coche.getEstado());
            stmt.setInt(6, coche.getAnio());
            stmt.setDate(7, new java.sql.Date(coche.getFecha_Registro().getTime()));
            stmt.executeUpdate();
        }
    }

    public List<POJOCoche> leerTodosCoches() throws SQLException {
        String sql = "SELECT * FROM Coche";
        List<POJOCoche> coches = new ArrayList<>();

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                POJOCoche coche = new POJOCoche();
                coche.setId_Coche(rs.getInt("id_coche"));
                coche.setMarca(rs.getString("marca"));
                coche.setModelo(rs.getString("modelo"));
                coche.setPlaca(rs.getString("placa"));
                coche.setColor(rs.getString("color"));
                coche.setEstado(rs.getString("estado"));
                coche.setAnio(rs.getInt("anio"));
                coche.setFecha_Registro(rs.getDate("fecha_registro"));
                coches.add(coche);
            }
        }
        return coches;
    }

    public void actualizarCoche(POJOCoche coche) throws SQLException {
        String sql = """
        UPDATE Coche SET 
            Marca = ?, Modelo = ?, Placa = ?, Color = ?, 
            Estado = ?, Anio = ?, Fecha_Registro = ?
        WHERE Id_Coche = ?
        """;

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, coche.getMarca());
            stmt.setString(2, coche.getModelo());
            stmt.setString(3, coche.getPlaca());
            stmt.setString(4, coche.getColor());
            stmt.setString(5, coche.getEstado());
            stmt.setInt(6, coche.getAnio());
            stmt.setDate(7, new java.sql.Date(coche.getFecha_Registro().getTime()));
            stmt.setInt(8, coche.getId_Coche());
            stmt.executeUpdate();
        }
    }

    public void eliminarCoche(int idCoche) throws SQLException {
        String sql = "DELETE FROM Coche WHERE Id_Coche = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, idCoche);
            stmt.executeUpdate();
        }
    }
    
    public POJOCoche leerCochePorId(int idCoche) throws SQLException {
    POJOCoche coche = null;
    String sql = "SELECT * FROM Coche WHERE Id_Coche = ?";
    
    try (Connection c = ConexionDB.getConnection();
         PreparedStatement stmt = c.prepareStatement(sql)) {
        
        stmt.setInt(1, idCoche);
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            coche = new POJOCoche();
            coche.setId_Coche(rs.getInt("Id_Coche"));
            coche.setMarca(rs.getString("Marca"));
            coche.setModelo(rs.getString("Modelo"));
            coche.setPlaca(rs.getString("Placa"));
            coche.setColor(rs.getString("Color"));
            coche.setEstado(rs.getString("Estado"));
            coche.setAnio(rs.getInt("Anio"));
            coche.setFecha_Registro(rs.getDate("Fecha_Registro"));
        }
    }
    
    return coche;
    }
}
