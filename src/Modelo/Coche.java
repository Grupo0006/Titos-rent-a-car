/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.Date;
/**
 *
 * @author Ernesto José Sevilla Inglés
 */
// Declaramos Variables
public class Coche {
    public String Marca;
    public String Modelo;
    public String placa;
    public String color;
    public String Estado;
    public int Anio;
    public int Id_Coche;
    public Date Fecha_Registro;

    // Creamos constructor
    public Coche(String Marca, String Modelo, String placa, String color, String Estado, int Anio, int Id_Coche, Date Fecha_Registro) {
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.placa = placa;
        this.color = color;
        this.Estado = Estado;
        this.Anio = Anio;
        this.Id_Coche = Id_Coche;
        this.Fecha_Registro = Fecha_Registro;
    }
    // Creamos constructor vacio
    public Coche() {
    }

    // Cremos get y set para las variables
    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getAnio() {
        return Anio;
    }

    public void setAnio(int Anio) {
        this.Anio = Anio;
    }

    public int getId_Coche() {
        return Id_Coche;
    }

    public void setId_Coche(int Id_Coche) {
        this.Id_Coche = Id_Coche;
    }

    public Date getFecha_Registro() {
        return Fecha_Registro;
    }

    public void setFecha_Registro(Date Fecha_Registro) {
        this.Fecha_Registro = Fecha_Registro;
    }

}