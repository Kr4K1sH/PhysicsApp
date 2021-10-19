/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.SNMPExceptions;
import Model.Administrador;
import Model.AdministradorDB;
import Model.persona;
import Model.personaDB;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import javax.faces.context.FacesContext;
import javax.naming.NamingException;

/**
 *
 * @author lrami
 */
@Named(value = "beanLogin")
@SessionScoped
public class beanLogin implements Serializable {

    int IdPersona;
    String Contrasenna;
    String TipoAcceso;
    String MensajeError;
    String MensajeAviso;

    public String getContrasenna() {
        return Contrasenna;
    }

    public void setContrasenna(String Contrasenna) {
        this.Contrasenna = Contrasenna;
    }

    public String getMensajeAviso() {
        return MensajeAviso;
    }

    public void setMensajeAviso(String MensajeAviso) {
        this.MensajeAviso = MensajeAviso;
    }

    public String getMensajeError() {
        return MensajeError;
    }

    public void setMensajeError(String MensajeError) {
        this.MensajeError = MensajeError;
    }

    public int getIdPersona() {
        return IdPersona;
    }

    public void setIdPersona(int IdPersona) {
        this.IdPersona = IdPersona;
    }

    public String getTipoAcceso() {
        return TipoAcceso;
    }

    public void setTipoAcceso(String TipoAcceso) {
        this.TipoAcceso = TipoAcceso;
    }

    public beanLogin() {
    }

    public boolean validarCred() throws IOException, SNMPExceptions, SQLException, NamingException, ClassNotFoundException {

        boolean flag = false;

        int IdPersona = 0;
        String Contrasenna = "";
        String Contrasenna2 = "";
        int idAdministrador = 0;

        LinkedList<persona> listaPer = new LinkedList<persona>();
        LinkedList<Administrador> listaAdm = new LinkedList<Administrador>();
        personaDB pDB = new personaDB();
        AdministradorDB aDB = new AdministradorDB();
        listaPer = pDB.moTodo();
        listaAdm = aDB.listaAdmin();
        for (Iterator iter = listaPer.iterator();
                iter.hasNext();) {
            for (Iterator iter2 = listaAdm.iterator();
                    iter2.hasNext();) {

                persona per = (persona) iter.next();
                IdPersona = per.getIdPersona();
                Contrasenna = per.getContrasenna();

                Administrador adm = (Administrador) iter2.next();
                idAdministrador = adm.getIdAdministrador();
                Contrasenna2 = adm.getContrasenna();
                if (this.TipoAcceso.equalsIgnoreCase("Administrador")) {
                    if (this.IdPersona == idAdministrador) {
                        this.setMensajeAviso("");
                        if (this.Contrasenna.equals(Contrasenna2)) {
                            this.setMensajeAviso("");

                            flag = true;
                            FacesContext.getCurrentInstance().getExternalContext().dispatch("indexAdmin.xhtml");
                            break;
                        } else {
                            this.setMensajeError("Información Incorrecta: Contraseña");
                            flag = false;
                        }
                    } else {
                        this.setMensajeError("Información Incorrecta: Usuario");
                        flag = false;
                    }
                    if (flag == false) {

                        this.setMensajeAviso("Datos Inválidos");

                    }
                }if(this.TipoAcceso.equalsIgnoreCase("Deportista")){
                     if (this.IdPersona == IdPersona) {
                        this.setMensajeAviso("");
                        if (this.Contrasenna.equals(Contrasenna)) {
                            this.setMensajeAviso("");

                            flag = true;
                            FacesContext.getCurrentInstance().getExternalContext().dispatch("indexPersona.xhtml");
                            break;
                        } else {
                            this.setMensajeError("Información Incorrecta: Contraseña");
                            flag = false;
                        }
                    } else {
                        this.setMensajeError("Información Incorrecta: Usuario");
                        flag = false;
                    }
                    if (flag == false) {

                        this.setMensajeAviso("Datos Inválidos");

                    }
                    
                    
                }
            }
        }
        return flag;
    }
    
     public  void cerrarSesion()throws IOException, SNMPExceptions, SQLException, NamingException, ClassNotFoundException{
         this.setIdPersona(0);
         this.setContrasenna("");
         FacesContext.getCurrentInstance().getExternalContext().dispatch("login.xhtml");
     }

}
