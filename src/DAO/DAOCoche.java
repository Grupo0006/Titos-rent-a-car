/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Coche;
import Util.ConexionDB;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author Estudiantes
 */
public class DAOCoche {

    public void crearCoche(Coche coche) throws SQLException {
        String sql = """
        INSERT INTO Coches (
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
            stmt.setDate(7,new java.sql.Date(coche.getFecha_Registro().getTime()));
            stmt.executeUpdate();
        }
    }

    public List<Coche> leerTodosCoches() throws SQLException {
        String sql = "SELECT * FROM Coches";
        List<Coche> coches = new ArrayList<>();

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Coche coche = new Coche();
                coche.setIdCoche(rs.getInt("id_coche"));
                coche.setMarca(rs.getString("marca"));
                coche.setModelo(rs.getString("modelo"));
                coche.setPlaca(rs.getString("placa"));
                coche.setColor(rs.getString("color"));
                coche.setEstado(rs.getString("estado"));
                coche.setAnio(rs.getInt("anio"));
                coche.setFechaRegistro(rs.getDate("fecha_registro"));
                coches.add(coche);
            }
        }
        return coches;
    }

    public void actualizarCoche(Coche coche) throws SQLException {
        String sql = """
        UPDATE Coches SET 
            marca = ?, modelo = ?, placa = ?, color = ?, 
            estado = ?, anio = ?, fecha_registro = ?
        WHERE id_coche = ?
        """;

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, coche.getMarca());
            stmt.setString(2, coche.getModelo());
            stmt.setString(3, coche.getPlaca());
            stmt.setString(4, coche.getColor());
            stmt.setString(5, coche.getEstado());
            stmt.setInt(6, coche.getAnio());
            stmt.setDate(7, new java.sql.Date(coche.getFecha_Registro().getTime()));
            stmt.setInt(8, coche.getIdCoche());
            stmt.executeUpdate();
        }
    }

    public void eliminarCoche(int idCoche) throws SQLException {
        String sql = "DELETE FROM Coches WHERE id_coche = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, idCoche);
            stmt.executeUpdate();
        }
    }

}
