/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * 
 */
public class canton {
    
     private int cod_provincia;
    private int cod_canton;
    private String dsc_canton;
    private int log_activo;

    public canton(int cod_provincia, int cod_canton, String dsc_canton, int log_activo) {
        this.cod_provincia = cod_provincia;
        this.cod_canton = cod_canton;
        this.dsc_canton = dsc_canton;
        this.log_activo = log_activo;
    }

    public canton() {
    }
    

    public int getCod_provincia() {
        return cod_provincia;
    }

    public void setCod_provincia(int cod_provincia) {
        this.cod_provincia = cod_provincia;
    }

    public int getCod_canton() {
        return cod_canton;
    }

    public void setCod_canton(int cod_canton) {
        this.cod_canton = cod_canton;
    }

    public String getDsc_canton() {
        return dsc_canton;
    }

    public void setDsc_canton(String dsc_canton) {
        this.dsc_canton = dsc_canton;
    }

    public int getLog_activo() {
        return log_activo;
    }

    public void setLog_activo(int log_activo) {
        this.log_activo = log_activo;
    }

   
   
}
