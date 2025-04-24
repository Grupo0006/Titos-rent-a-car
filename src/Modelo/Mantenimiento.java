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
public class Mantenimiento {
    private int Id_Mantenimiento;
    private String Descripcion;
    private String Justificacion;
    private Date Fecha_Inicio;
    private Date Fecha_Fin;

    public Mantenimiento(int Id_Mantenimiento, String Descripcion, String Justificacion, Date Fecha_Inicio, Date Fecha_Fin) {
        this.Id_Mantenimiento = Id_Mantenimiento;
        this.Descripcion = Descripcion;
        this.Justificacion = Justificacion;
        this.Fecha_Inicio = Fecha_Inicio;
        this.Fecha_Fin = Fecha_Fin;
    }

    public Mantenimiento() {
    }

    public int getId_Mantenimiento() {
        return Id_Mantenimiento;
    }

    public void setId_Mantenimiento(int Id_Mantenimiento) {
        this.Id_Mantenimiento = Id_Mantenimiento;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getJustificacion() {
        return Justificacion;
    }

    public void setJustificacion(String Justificacion) {
        this.Justificacion = Justificacion;
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
