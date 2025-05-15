/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.DAOCoche;
import Modelo.Coche;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Estudiantes
 */
public class CocheControlador {

    private final DAOCoche cocheDAO;

    public CocheControlador() {
        this.cocheDAO = new DAOCoche();
    }

    public void crearCoche(String marca, String modelo, String placa, String color, String estado, int anio, Date fechaRegistro) {
        try {
            Coche coche = new Coche();
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

    public List<Coche> obtenerTodosCoches() {
        try {
            return cocheDAO.leerTodosCoches();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los coches: " + e.getMessage());
            return null;
        }
    }
    
    public Coche obtenerCochePorId(int idCoche) {
    try {
        return cocheDAO.leerCochePorId(idCoche);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener el coche: " + e.getMessage());
        return null;
    }
}


    public void actualizarCoche(int id, String marca, String modelo, String placa, String color, String estado, int anio, Date fechaRegistro) {
        try {
            Coche coche = new Coche();
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

    /*
    public static void main(String[] args) {
        CocheControlador controlador = new CocheControlador();
        /*
        // Probar metodo de crear coche
        controlador.crearCoche("Olpus", "Parlic", "1524ADMN", "Rojo", "Decente", 2000, Date.valueOf("2007-03-12"));
     */
 /*
        // Probar metodo de actualizar coche
        controlador.actualizarCoche(1, "Papaya", "Rum Rum", "452JKD", "Rojo", "Malo", 2023, Date.valueOf("2030-02-10"));
     */
 /*
        //Probar Leer Coches
        List<Coche> coches = controlador.obtenerTodosCoches();
        for (Coche co : coches) {
            System.out.println("ID: " + co.Id_Coche + "  Marca: " + co.getMarca()
                    + " Modelo: " + co.getModelo() + " Placa: " + co.getPlaca()
                    + " Color: " + co.getColor() + " Estado: " + co.getEstado()
                    + " Año: " + co.getAnio() + " Fecha: " + co.Fecha_Registro);
        }
     */
 /*
        //Probar Eliminar Coche
        controlador.eliminarCoche(1);
    }
     */
}
