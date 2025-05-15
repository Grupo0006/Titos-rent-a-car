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
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Estudiantes Ernesto
 */
public class DAOCoche {

    public void crearCoche(Coche coche) throws SQLException {
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

    public List<Coche> leerTodosCoches() throws SQLException {
        String sql = "SELECT * FROM Coche";
        List<Coche> coches = new ArrayList<>();

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Coche coche = new Coche();
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

    public void actualizarCoche(Coche coche) throws SQLException {
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
    
    public Coche leerCochePorId(int idCoche) throws SQLException {
    Coche coche = null;
    String sql = "SELECT * FROM Coche WHERE Id_Coche = ?";
    
    try (Connection c = ConexionDB.getConnection();
         PreparedStatement stmt = c.prepareStatement(sql)) {
        
        stmt.setInt(1, idCoche);
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            coche = new Coche();
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


    //Metodo Main para probar crear coche
    /*public static void main(String[] args) {
        try {
            DAOCoche dao = new DAOCoche();
            Coche co = new Coche();
            co.setMarca("Rum Rum");
            co.setModelo("Pupupupupu");
            co.setAnio(2024);
            co.setPlaca("JSDH252");
            co.setColor("Rojo");
            
            String fechaTexto = "2024-12-15";
            Date fechaSQL = Date.valueOf(fechaTexto);
            co.setFecha_Registro(fechaSQL);
            co.setFecha_Registro(fechaSQL);
            
            dao.crearCoche(co);
            System.out.println("Coche creado con éxito!");
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }*/
    // Metodo Main para mostrar lista de coches
    /*
    public static void main(String[] args) {
        try {
            DAOCoche dao = new DAOCoche();
            List<Coche> coches = dao.leerTodosCoches();
            System.out.println("Lista de coches:");
            for (Coche co : coches) {
                System.out.println("Id_Coche: " + co.getId_Coche() + 
                                 ", Marca: " + co.getMarca() + 
                                 ", Modelo: " + co.getModelo() + 
                                 ", Anio: " + co.getAnio() +
                                 ", Placa: " + co.getPlaca() + 
                                 ", Color: " + co.getColor() + 
                                 ", Fecha_Registro: " + co.getFecha_Registro());
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }*/
    //Metodo Main para Actualizar, eliminar Coche
    /*
        public static void main(String[] args) {
            
            
            try {
                DAOCoche dao = new DAOCoche();
                

                // Actualizar un coche
                Coche coche = new Coche();
                coche.setId_Coche(1); // ID existente
                coche.setMarca("Toyota");
                coche.setModelo("Corolla X");
                coche.setPlaca("XYZ123");
                coche.setColor("Negro");
                coche.setEstado("Disponible");
                coche.setAnio(2022);
                coche.setFecha_Registro(Date.valueOf("2023-05-10")); // Fecha manual

                dao.actualizarCoche(coche);
                System.out.println("Coche actualizado correctamente.");
            

                
                
                // ️Eliminar un coche
                dao.eliminarCoche(2); // Id de la base de datos
                System.out.println("Coche eliminado correctamente.");

                /*
                // Leer todos los coches
                List<Coche> coches = dao.leerTodosCoches();
                System.out.println("\n🚘 Lista de coches:");
                for (Coche c : coches) {
                    System.out.println("ID: " + c.getIdCoche()
                            + ", Marca: " + c.getMarca()
                            + ", Modelo: " + c.getModelo()
                            + ", Placa: " + c.getPlaca()
                            + ", Color: " + c.getColor()
                            + ", Estado: " + c.getEstado()
                            + ", Año: " + c.getAnio()
                            + ", Fecha Registro: " + c.getFecha_Registro());
                }

            } catch (SQLException e) {
                System.err.println("Error SQL: " + e.getMessage());
            }
        }
     */
}
