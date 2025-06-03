/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.DAOCoche;
import Modelo.POJOCoche;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Ernesto José Sevilla Inglés
 */
public class CocheControlador {

    private final DAOCoche cocheDAO;

    public CocheControlador() {
        this.cocheDAO = new DAOCoche();
    }

    public void crearCoche(String marca, String modelo, String placa, String color, String estado, int anio, Date fechaRegistro) {
        try {
            POJOCoche coche = new POJOCoche();
            coche.setMarca(marca);
            coche.setModelo(modelo);
            coche.setPlaca(placa);
            coche.setColor(color);
            coche.setEstado(estado);
            coche.setAnio(anio);
            coche.setFecha_Registro(fechaRegistro);
            cocheDAO.crearCoche(coche);
            JOptionPane.showMessageDialog(null, "Coche creado exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el coche: " + e.getMessage());
        }
    }

    public List<POJOCoche> obtenerTodosCoches() {
        try {
            return cocheDAO.leerTodosCoches();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los coches: " + e.getMessage());
            return null;
        }
    }

    public POJOCoche obtenerCochePorId(int idCoche) {
        try {
            return cocheDAO.leerCochePorId(idCoche);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el coche: " + e.getMessage());
            return null;
        }
    }

    public void actualizarCoche(int id, String marca, String modelo, String placa, String color, String estado, int anio, Date fechaRegistro) {
        try {
            POJOCoche coche = new POJOCoche();
            coche.setId_Coche(id);
            coche.setMarca(marca);
            coche.setModelo(modelo);
            coche.setPlaca(placa);
            coche.setColor(color);
            coche.setEstado(estado);
            coche.setAnio(anio);
            coche.setFecha_Registro(fechaRegistro);
            cocheDAO.actualizarCoche(coche);
            JOptionPane.showMessageDialog(null, "Coche actualizado exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el coche: " + e.getMessage());
        }
    }

    public void eliminarCoche(int id) {
        try {
            cocheDAO.eliminarCoche(id);
            JOptionPane.showMessageDialog(null, "Coche eliminado exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el coche: " + e.getMessage());
        }
    }

}
