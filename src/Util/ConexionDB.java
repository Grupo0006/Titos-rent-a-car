/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Estudiantes
 */
public class ConexionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/BD_rentacar_G3?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "123456789";
    
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL,USER,PASSWORD);
        }   catch (ClassNotFoundException e){
                throw new SQLException ("Driver de MySQL no encontrado", e);
            }
    }
}
