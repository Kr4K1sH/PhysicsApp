/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author Josue A cC
 */
public class Cumplimiento {
    int IdCumplimiento ;
  int IdInstructures;
  int IdDeportistas;
 String ActividadRealizada;
  Date FechaenqueRealizo;
  int CantidadRepeticiones;
  int Duracion;
  String Observaciones;

    public Cumplimiento(int IdCumplimiento, int IdInstructures, int IdDeportistas, String ActividadRealizada, Date FechaenqueRealizo, int CantidadRepeticiones, int Duracion, String Observaciones) {
        this.IdCumplimiento = IdCumplimiento;
        this.IdInstructures = IdInstructures;
        this.IdDeportistas = IdDeportistas;
        this.ActividadRealizada = ActividadRealizada;
        this.FechaenqueRealizo = FechaenqueRealizo;
        this.CantidadRepeticiones = CantidadRepeticiones;
        this.Duracion = Duracion;
        this.Observaciones = Observaciones;
    }

    public Cumplimiento() {
    }
  
     
  
  
  
     
    public int getIdCumplimiento() {
        return IdCumplimiento;
    }

    public void setIdCumplimiento(int IdCumplimiento) {
        this.IdCumplimiento = IdCumplimiento;
    }

    public int getIdInstructures() {
        return IdInstructures;
    }

    public void setIdInstructures(int IdInstructures) {
        this.IdInstructures = IdInstructures;
    }

    public int getIdDeportistas() {
        return IdDeportistas;
    }

    public void setIdDeportistas(int IdDeportistas) {
        this.IdDeportistas = IdDeportistas;
    }

    public String getActividadRealizada() {
        return ActividadRealizada;
    }

    public void setActividadRealizada(String ActividadRealizada) {
        this.ActividadRealizada = ActividadRealizada;
    }

    public Date getFechaenqueRealizo() {
        return FechaenqueRealizo;
    }

    public void setFechaenqueRealizo(Date FechaenqueRealizo) {
        this.FechaenqueRealizo = FechaenqueRealizo;
    }

    public int getCantidadRepeticiones() {
        return CantidadRepeticiones;
    }

    public void setCantidadRepeticiones(int CantidadRepeticiones) {
        this.CantidadRepeticiones = CantidadRepeticiones;
    }

    public int getDuracion() {
        return Duracion;
    }

    public void setDuracion(int Duracion) {
        this.Duracion = Duracion;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }
 
}
