/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author lrami
 */
public class persona {

    private int IdPersona;
    private String Nombre;
    private String Apellido1;
    private String Apellido2;
    private String Contrasenna;
    private String  FechaNacimiento;
    private int Edad;
    private String Correo;
    private int ID_Provincia;
    private int ID_Canton;
    private int ID_Distrito;

    public persona(){
        
    }
    public persona(int IdPersona, String Nombre, String Apellido1, String Apellido2, String Contrasenna, String FechaNacimiento, int Edad, String Correo, int ID_Provincia, int ID_Canton, int ID_Distrito) {
        this.IdPersona = IdPersona;
        this.Nombre = Nombre;
        this.Apellido1 = Apellido1;
        this.Apellido2 = Apellido2;
        this.Contrasenna = Contrasenna;
        this.FechaNacimiento = FechaNacimiento;
        this.Edad = Edad;
        this.Correo = Correo;
        this.ID_Provincia = ID_Provincia;
        this.ID_Canton = ID_Canton;
        this.ID_Distrito = ID_Distrito;
    }

    public int getIdPersona() {
        return IdPersona;
    }

    public void setIdPersona(int IdPersona) {
        this.IdPersona = IdPersona;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido1() {
        return Apellido1;
    }

    public void setApellido1(String Apellido1) {
        this.Apellido1 = Apellido1;
    }

    public String getApellido2() {
        return Apellido2;
    }

    public void setApellido2(String Apellido2) {
        this.Apellido2 = Apellido2;
    }

    public String getContrasenna() {
        return Contrasenna;
    }

    public void setContrasenna(String Contrasenna) {
        this.Contrasenna = Contrasenna;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public int getID_Provincia() {
        return ID_Provincia;
    }

    public void setID_Provincia(int ID_Provincia) {
        this.ID_Provincia = ID_Provincia;
    }

    public int getID_Canton() {
        return ID_Canton;
    }

    public void setID_Canton(int ID_Canton) {
        this.ID_Canton = ID_Canton;
    }

    public int getID_Distrito() {
        return ID_Distrito;
    }

    public void setID_Distrito(int ID_Distrito) {
        this.ID_Distrito = ID_Distrito;
    }
    
    
}
