
package Modelo;
import java.util.Date;

public class POJOMantenimiento {
    private int Id_Mantenimiento;
    private String Descripcion;
    private String Justificacion;
    private Date Fecha_Inicio;
    private Date Fecha_Fin;
    private double Costo;

    public POJOMantenimiento() {
    }

    public POJOMantenimiento(int Id_Mantenimiento, String Descripcion, String Justificacion, Date Fecha_Inicio, Date Fecha_Fin, double Costo) {
        this.Id_Mantenimiento = Id_Mantenimiento;
        this.Descripcion = Descripcion;
        this.Justificacion = Justificacion;
        this.Fecha_Inicio = Fecha_Inicio;
        this.Fecha_Fin = Fecha_Fin;
        this.Costo = Costo;
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

    public double getCosto() {
        return Costo;
    }

    public void setCosto(double Costo) {
        this.Costo = Costo;
    }

}
