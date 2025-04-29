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

    public static void main(String[] args) {
        CocheControlador controlador = new CocheControlador();

        // Crear coche
        
        controlador.crearCoche("Toyota", "Corolla", "M123456", "Blanco", "Disponible", 2020, );

        // Actualizar coche
        controlador.actualizarCoche(1, "Toyota", "Corolla SE", "M123456", "Negro", "Mantenimiento", 2020, fechaActual);

        // Eliminar coche
        controlador.eliminarCoche(3); // Asegúrate que exista el ID

        // Leer todos los coches y mostrarlos en consola
        List<Coche> lista = controlador.obtenerTodosCoches();
        if (lista != null) {
            for (Coche coche : lista) {
                System.out.println("ID: " + coche.getId_Coche()
                        + ", Marca: " + coche.getMarca()
                        + ", Modelo: " + coche.getModelo()
                        + ", Placa: " + coche.getPlaca()
                        + ", Color: " + coche.getColor()
                        + ", Estado: " + coche.getEstado()
                        + ", Año: " + coche.getAnio()
                        + ", Fecha Registro: " + coche.getFecha_Registro());
            }
        }
    }
}

