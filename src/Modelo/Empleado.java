/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Estudiante
 */
public class Empleado {
    private int Id_eMpleado;
     private String Cedula;
    private String Nombre;
    private String Apellido;
    private String Direccion;
    private String Email;

    public Empleado(int Id_eMpleado, String Cedula, String Nombre, String Apellido, String Direccion, String Email) {
        this.Id_eMpleado = Id_eMpleado;
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Direccion = Direccion;
        this.Email = Email;
    }

    public Empleado() {
    }

    public int getId_eMpleado() {
        return Id_eMpleado;
    }

    public void setId_eMpleado(int Id_eMpleado) {
        this.Id_eMpleado = Id_eMpleado;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
   
}
