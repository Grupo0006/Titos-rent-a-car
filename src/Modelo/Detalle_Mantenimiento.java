
package Modelo;

public class Detalle_Mantenimiento {
    private int idDetalleMantenimiento;
    private int idMantenimiento;
    private int idEmpleado;
    private int idCoche;
    private String observaciones;
    private String recomendaciones;
    private String partesCambiadas;

    
    public Detalle_Mantenimiento(int idDetalleMantenimiento, int idMantenimiento, int idEmpleado, int idCoche, String observaciones, String recomendaciones, String partesCambiadas) {
        this.idDetalleMantenimiento = idDetalleMantenimiento;
        this.idMantenimiento = idMantenimiento;
        this.idEmpleado = idEmpleado;
        this.idCoche = idCoche;
        this.observaciones = observaciones;
        this.recomendaciones = recomendaciones;
        this.partesCambiadas = partesCambiadas;
    }

    public Detalle_Mantenimiento() {
    }

    
    public int getIdDetalleMantenimiento() {
        return idDetalleMantenimiento;
    }

    public void setIdDetalleMantenimiento(int idDetalleMantenimiento) {
        this.idDetalleMantenimiento = idDetalleMantenimiento;
    }

    public int getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(int idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdCoche() {
        return idCoche;
    }

    public void setIdCoche(int idCoche) {
        this.idCoche = idCoche;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public String getPartesCambiadas() {
        return partesCambiadas;
    }

    public void setPartesCambiadas(String partesCambiadas) {
        this.partesCambiadas = partesCambiadas;
    }
}
