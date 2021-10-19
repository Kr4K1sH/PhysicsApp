/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Entrenador;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Josue A cC
 */
@Named(value = "beanAsignacionPlan")
@SessionScoped
public class beanAsignacionPlan implements Serializable {

    /**
     * Creates a new instance of beanAsignacionPlan
     */
    public beanAsignacionPlan() {
    }
    int IdAsignacionPlan;
int IdInstructores;
int IdDeportistas;
String Perioricidad;
Date FechaInicio;
Date FechaFinal;
int CodDisciplina;
String Explicacion;
int Duracion;
int Repeticiones;

    public int getIdAsignacionPlan() {
        return IdAsignacionPlan;
    }

    public void setIdAsignacionPlan(int IdAsignacionPlan) {
        this.IdAsignacionPlan = IdAsignacionPlan;
    }

    public int getIdInstructores() {
        return IdInstructores;
    }

    public void setIdInstructores(int IdInstructores) {
        this.IdInstructores = IdInstructores;
    }

    public int getIdDeportistas() {
        return IdDeportistas;
    }

    public void setIdDeportistas(int IdDeportistas) {
        this.IdDeportistas = IdDeportistas;
    }

    public String getPerioricidad() {
        return Perioricidad;
    }

    public void setPerioricidad(String Perioricidad) {
        this.Perioricidad = Perioricidad;
    }

    public Date getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(Date FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public Date getFechaFinal() {
        return FechaFinal;
    }

    public void setFechaFinal(Date FechaFinal) {
        this.FechaFinal = FechaFinal;
    }

    public int getCodDisciplina() {
        return CodDisciplina;
    }

    public void setCodDisciplina(int CodDisciplina) {
        this.CodDisciplina = CodDisciplina;
    }

    public String getExplicacion() {
        return Explicacion;
    }

    public void setExplicacion(String Explicacion) {
        this.Explicacion = Explicacion;
    }

    public int getDuracion() {
        return Duracion;
    }

    public void setDuracion(int Duracion) {
        this.Duracion = Duracion;
    }

    public int getRepeticiones() {
        return Repeticiones;
    }

    public void setRepeticiones(int Repeticiones) {
        this.Repeticiones = Repeticiones;
    }
    
    
    public void AsignarDatosInstructor(Entrenador ins){
    
        
    
    
    
    }
    
    
    
    
    
    
    
    
    
}
