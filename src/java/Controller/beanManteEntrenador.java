/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.SNMPExceptions;
import Model.DeportistaDB;
import Model.Depotista;
import Model.Entrenador;
import Model.EntrenadorDB;
import Model.Telefono;
import Model.TelefonoDB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.naming.NamingException;

/**
 *
 * @author Josue A cC
 */
@Named(value = "beanManteEntrenador")
@SessionScoped
public class beanManteEntrenador implements Serializable {

    /**
     * Creates a new instance of beanManteEntrenador
     */
    public beanManteEntrenador() {
    }
   
      private int IdPersona ;
      private int Nombre ;
     int idInstructor;

    public int getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(int idInstructor) {
        this.idInstructor = idInstructor;
    }
      private int CodDisciplina ;    
     String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
      
    public int getIdPersona() {
        return IdPersona;
    }

    public void setIdPersona(int IdPersona) {
        this.IdPersona = IdPersona;
    }

    public int getNombre() {
        return Nombre;
    }

    public void setNombre(int Nombre) {
        this.Nombre = Nombre;
    }

    public int getCodDisciplina() {
        return CodDisciplina;
    }

    public void setCodDisciplina(int CodDisciplina) {
        this.CodDisciplina = CodDisciplina;
    }

      
      
   
    LinkedList<Entrenador> listaEn = new LinkedList<Entrenador>();

  

    public LinkedList<Entrenador> getListaEn() throws SNMPExceptions, SQLException {
        this.listaEn = this.MostrarEntrenadores();
        return listaEn;
    }

    public LinkedList<Entrenador> setListaEn(LinkedList<Entrenador> listaEn) {
        this.listaEn = listaEn;
        return this.listaEn;
    }

    public LinkedList<Entrenador> MostrarEntrenadores() throws SNMPExceptions, SQLException {
        LinkedList<Entrenador> listaD = new LinkedList<Entrenador>();
        EntrenadorDB dDB = new EntrenadorDB();

        listaD = dDB.listaEntrenador();
        this.setListaEn(listaD);
        return listaD;
    }

    public void Limpiar() {
    this.setCodDisciplina(0);
this.setIdPersona(0);
this.setNombre(0);
this.setIdInstructor(0);

    }

    public void AsignaDatos(Entrenador dp) throws SNMPExceptions, SQLException {
  this.setCodDisciplina(dp.getCodDisciplina());
  this.setIdPersona(dp.getIdPersona());
  this.setNombre(dp.getTelefono());
  this.setIdInstructor(dp.getID());
    }

    public void GuardarEntrenador() throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
        try {
            
            if (this.getCodDisciplina() == 0 || this.getIdPersona() == 0 || this.getNombre() == 0 ) {
                this.setMensaje("alert( Campos Obligatorios!)");

            } else {
               if(this.idInstructor >0) {
                 Entrenador ent = new Entrenador();
                EntrenadorDB entdb = new EntrenadorDB();
                ent.setCodDisciplina(CodDisciplina);
                ent.setID(idInstructor);
                ent.setIdPersona(IdPersona);
                ent.setTelefono(this.Nombre);
                
                Telefono tel = new Telefono();
                TelefonoDB tdb = new TelefonoDB();
                
                tel.setIDUsuario(IdPersona);
                tel.setNumeroTelefono(this.Nombre);
                
                tdb.GuardarTelefono(tel);
                
                entdb.ActualizaEntrenador(ent);
               this.Limpiar();
               }else{

                
                
                Entrenador ent = new Entrenador();
                EntrenadorDB entdb = new EntrenadorDB();
                entdb.GuardarEntrenador(ent);
                this.Limpiar();
            }
            }
        } catch (Exception ex) {
            this.setMensaje("Hubo un error en nuestro registro o esta identificacion no existe");

        }

    }

    public void BuscarEntrenador() throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
     
        Entrenador dp = new Entrenador();
        EntrenadorDB cDB = new EntrenadorDB();
     
        if (this.IdPersona == 0) {
            this.setMensaje("Se debe de ingresar una identificacion");
        } else {
          this.listaEn = cDB.IdEntrenador(IdPersona);
          
        }

    }

}
