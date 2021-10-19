/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Marc GarNav
 */
public class distrito {
  
     private int cod_provincia;
    private int cod_canton;
    private int cod_distrito;
    private String dsc_distrito;
    private int log_activo;

    public distrito(int cod_provincia, int cod_canton, int cod_distrito, String dsc_distrito, int log_activo) {
        this.cod_provincia = cod_provincia;
        this.cod_canton = cod_canton;
        this.cod_distrito = cod_distrito;
        this.dsc_distrito = dsc_distrito;
        this.log_activo = log_activo;
    }

    public distrito() {
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

    public int getCod_distrito() {
        return cod_distrito;
    }

    public void setCod_distrito(int cod_distrito) {
        this.cod_distrito = cod_distrito;
    }

    public String getDsc_distrito() {
        return dsc_distrito;
    }

    public void setDsc_distrito(String dsc_distrito) {
        this.dsc_distrito = dsc_distrito;
    }

    public int getLog_activo() {
        return log_activo;
    }

    public void setLog_activo(int log_activo) {
        this.log_activo = log_activo;
    }

}
