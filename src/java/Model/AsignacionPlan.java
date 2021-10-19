/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author Estudiante
 */
public class AsignacionPlan {

    public AsignacionPlan() {
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

    public AsignacionPlan(int IdAsignacionPlan, int IdInstructores, int IdDeportistas, String Perioricidad, Date FechaInicio, Date FechaFinal, int CodDisciplina, String Explicacion, int Duracion, int Repeticiones) {
        this.IdAsignacionPlan = IdAsignacionPlan;
        this.IdInstructores = IdInstructores;
        this.IdDeportistas = IdDeportistas;
        this.Perioricidad = Perioricidad;
        this.FechaInicio = FechaInicio;
        this.FechaFinal = FechaFinal;
        this.CodDisciplina = CodDisciplina;
        this.Explicacion = Explicacion;
        this.Duracion = Duracion;
        this.Repeticiones = Repeticiones;
    }


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

   
}
