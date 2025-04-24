/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Estudiante
 */
public class Detalle_Mantenimiento {
    private int DetalleMantenimiento;
    private int Mantenimiento;
     private int Id_Empleado;
     private int Id_Coche;
     private String Observaciones;
     private String Recomentaciones;
     private String PartesCambiadas;

    public Detalle_Mantenimiento(int DetalleMantenimiento, int Mantenimiento, int Id_Empleado, int Id_Coche, String Observaciones, String Recomentaciones, String PartesCambiadas) {
        this.DetalleMantenimiento = DetalleMantenimiento;
        this.Mantenimiento = Mantenimiento;
        this.Id_Empleado = Id_Empleado;
        this.Id_Coche = Id_Coche;
        this.Observaciones = Observaciones;
        this.Recomentaciones = Recomentaciones;
        this.PartesCambiadas = PartesCambiadas;
    }

    public int getDetalleMantenimiento() {
        return DetalleMantenimiento;
    }

    public void setDetalleMantenimiento(int DetalleMantenimiento) {
        this.DetalleMantenimiento = DetalleMantenimiento;
    }

    public int getMantenimiento() {
        return Mantenimiento;
    }

    public void setMantenimiento(int Mantenimiento) {
        this.Mantenimiento = Mantenimiento;
    }

    public int getId_Empleado() {
        return Id_Empleado;
    }

    public void setId_Empleado(int Id_Empleado) {
        this.Id_Empleado = Id_Empleado;
    }

    public int getId_Coche() {
        return Id_Coche;
    }

    public void setId_Coche(int Id_Coche) {
        this.Id_Coche = Id_Coche;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public String getRecomentaciones() {
        return Recomentaciones;
    }

    public void setRecomentaciones(String Recomentaciones) {
        this.Recomentaciones = Recomentaciones;
    }

    public String getPartesCambiadas() {
        return PartesCambiadas;
    }

    public void setPartesCambiadas(String PartesCambiadas) {
        this.PartesCambiadas = PartesCambiadas;
    }

    public Detalle_Mantenimiento() {
    }
     
    
}
