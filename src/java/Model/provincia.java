/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Alberto
 */
public class provincia {
 int Cod_Provincia;
String Dsc_Corta_Provincia;
String Dsc_Provincia;
int Log_Activo;

    public provincia() {
    }

    public provincia(int Cod_Provincia, String Dsc_Corta_Provincia, String Dsc_Provincia, int Log_Activo) {
        this.Cod_Provincia = Cod_Provincia;
        this.Dsc_Corta_Provincia = Dsc_Corta_Provincia;
        this.Dsc_Provincia = Dsc_Provincia;
        this.Log_Activo = Log_Activo;
    }

    public int getCod_Provincia() {
        return Cod_Provincia;
    }

    public void setCod_Provincia(int Cod_Provincia) {
        this.Cod_Provincia = Cod_Provincia;
    }

    public String getDsc_Corta_Provincia() {
        return Dsc_Corta_Provincia;
    }

    public void setDsc_Corta_Provincia(String Dsc_Corta_Provincia) {
        this.Dsc_Corta_Provincia = Dsc_Corta_Provincia;
    }

    public String getDsc_Provincia() {
        return Dsc_Provincia;
    }

    public void setDsc_Provincia(String Dsc_Provincia) {
        this.Dsc_Provincia = Dsc_Provincia;
    }

    public int getLog_Activo() {
        return Log_Activo;
    }

    public void setLog_Activo(int Log_Activo) {
        this.Log_Activo = Log_Activo;
    }

    
}
