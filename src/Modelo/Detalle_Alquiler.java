/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Estudiante
 */
public class Detalle_Alquiler {
    private int Id_DetalleAlquiler;
    private int Id_Alquiler;
    private int Id_Coche;
    private int Id_Cliente;
    private double Precio_Total;

    public Detalle_Alquiler(int Id_DetalleAlquiler, int Id_Alquiler, int Id_Coche, int Id_Cliente, double Precio_Total) {
        this.Id_DetalleAlquiler = Id_DetalleAlquiler;
        this.Id_Alquiler = Id_Alquiler;
        this.Id_Coche = Id_Coche;
        this.Id_Cliente = Id_Cliente;
        this.Precio_Total = Precio_Total;
    }

    public Detalle_Alquiler() {
    }

    public int getId_DetalleAlquiler() {
        return Id_DetalleAlquiler;
    }

    public void setId_DetalleAlquiler(int Id_DetalleAlquiler) {
        this.Id_DetalleAlquiler = Id_DetalleAlquiler;
    }

    public int getId_Alquiler() {
        return Id_Alquiler;
    }

    public void setId_Alquiler(int Id_Alquiler) {
        this.Id_Alquiler = Id_Alquiler;
    }

    public int getId_Coche() {
        return Id_Coche;
    }

    public void setId_Coche(int Id_Coche) {
        this.Id_Coche = Id_Coche;
    }

    public int getId_Cliente() {
        return Id_Cliente;
    }

    public void setId_Cliente(int Id_Cliente) {
        this.Id_Cliente = Id_Cliente;
    }

    public double getPrecio_Total() {
        return Precio_Total;
    }

    public void setPrecio_Total(double Precio_Total) {
        this.Precio_Total = Precio_Total;
    }
    
    
}
