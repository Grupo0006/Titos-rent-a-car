/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.Date;


/**
 *
 * @author Estudiante
 */
public class POJOAlquiler {
    private int Id_Alquiler;
    private Date Fecha_Inicio;
    private Date Fecha_Fin;

    public POJOAlquiler(int Id_Alquiler, Date Fecha_Inicio, Date Fecha_Fin) {
        this.Id_Alquiler = Id_Alquiler;
        this.Fecha_Inicio = Fecha_Inicio;
        this.Fecha_Fin = Fecha_Fin;
    }

    public POJOAlquiler() {
    }

    public int getId_Alquiler() {
        return Id_Alquiler;
    }

    public void setId_Alquiler(int Id_Alquiler) {
        this.Id_Alquiler = Id_Alquiler;
    }

    public Date getFecha_Inicio() {
        return Fecha_Inicio;
    }

    public void setFecha_Inicio(Date Fecha_Inicio) {
        this.Fecha_Inicio = Fecha_Inicio;
    }

    public Date getFecha_Fin() {
        return Fecha_Fin;
    }

    public void setFecha_Fin(Date Fecha_Fin) {
        this.Fecha_Fin = Fecha_Fin;
    }
    
}
