/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.SNMPExceptions;
import Model.canton;
import Model.distrito;
import Model.persona;
import Model.personaDB;
import Model.provincia;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;

/**
 *
 * @author Josue A cC
 */
@Named(value = "beanMantePersonas")
@SessionScoped
public class beanMantePersonas implements Serializable {

    /**
     * Creates a new instance of beanMantePersonas
     */
    public beanMantePersonas() {
    }
       int IdPersona;
     String Nombre;
     String Apellido1;
     String Apellido2;
     String Contrasenna;
     Date  FechaNacimiento;
     
     String fecha2;

    public String getFecha2() {
        return fecha2;
    }

    public void setFecha2(String fecha2) {
        this.fecha2 = fecha2;
    }
     int Edad;
     String Correo;
     int ID_Provincia;
     int ID_Canton;
     int ID_Distrito;

     int IDBuscar;

    public int getIDBuscar() {
        return IDBuscar;
    }

    public void setIDBuscar(int IDBuscar) {
        this.IDBuscar = IDBuscar;
    }
      
    String Mensaje;

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }
    
     
     LinkedList<SelectItem> ComboProvincia = new LinkedList<SelectItem>();
    LinkedList<SelectItem> ComboCanton = new LinkedList<SelectItem>();
    LinkedList<SelectItem> ComboDistrito = new LinkedList<SelectItem>();
      public LinkedList<SelectItem> getComboProvincia() throws SNMPExceptions, SQLException {
        int Cod1;
        String Nombre1;

        LinkedList<provincia> lista = new LinkedList<provincia>();
        personaDB pDB = new personaDB();

        lista = pDB.provinciaTodo();

        LinkedList resultList = new LinkedList();
        resultList.add(new SelectItem(0,
                "Seleccione Provincia"));

        //siempre usar un iterador para recorrer listas 
        for (Iterator iter = lista.iterator();
                iter.hasNext();) {

            provincia pro = (provincia) iter.next();
            Cod1 = pro.getCod_Provincia();
            Nombre1 = pro.getDsc_Provincia();
            resultList.add(new SelectItem(Cod1,
                    Nombre1));
        }
        return resultList;
    }
  public void setComboProvincia(LinkedList<SelectItem> ComboProvincia) {
        this.ComboProvincia = ComboProvincia;
    }
   public LinkedList<SelectItem> getComboCanton() throws SNMPExceptions, SQLException {
        int Provincia;
        int Canton;
        String Nombre;

        personaDB f1 = new personaDB();
        canton can1 = new canton();
        can1.setCod_provincia(this.getID_Provincia());
        can1.setCod_canton(this.getID_Canton());
        can1.setDsc_canton(this.getNombre());

        LinkedList<canton> lista = f1.selCanton(this.getID_Provincia());

        LinkedList resultList = new LinkedList();
        resultList.add(new SelectItem(0,
                "Seleccione el Canton"));

        for (Iterator iter = lista.iterator();
                iter.hasNext();) {

            canton pro = (canton) iter.next();

            Provincia = pro.getCod_provincia();
            Canton = pro.getCod_canton();
            Nombre = pro.getDsc_canton();
            resultList.add(new SelectItem(Canton, Nombre));
        }
        return resultList;
    }

    public void setComboCanton(LinkedList<SelectItem> ComboCanton) {
        this.ComboCanton = ComboCanton;
    }

    public LinkedList<SelectItem> getComboDistrito() throws SNMPExceptions, SQLException {
        int Provincia = 0;
        int Canton = 0;
        int Distrito = 0;
        String Nombre = "";

        personaDB f1 = new personaDB();
        distrito dis1 = new distrito();
        dis1.setCod_provincia(this.getID_Provincia());
        dis1.setCod_canton(this.getID_Canton());
        dis1.setCod_distrito(this.getID_Distrito());
        dis1.setDsc_distrito(this.getNombre());

        LinkedList<distrito> lista = f1.selDistrito(this.getID_Provincia(), this.getID_Canton());

        LinkedList resultList = new LinkedList();
        resultList.add(new SelectItem(0,
                "Seleccione el Distrito"));

        for (Iterator iter = lista.iterator();
                iter.hasNext();) {

            distrito pro = (distrito) iter.next();

            Provincia = pro.getCod_provincia();
            Canton = pro.getCod_canton();
            Distrito = pro.getCod_distrito();
            Nombre = pro.getDsc_distrito();
            resultList.add(new SelectItem(Distrito, Nombre));
        }
        return resultList;
    }

    public void setComboDistrito(LinkedList<SelectItem> ComboDistrito) {
        this.ComboDistrito = ComboDistrito;
    }

    public void CargarCanton(AjaxBehaviorEvent event) throws SNMPExceptions, SQLException{
  if(this.ID_Provincia >0 ){
       
  this.setComboCanton(this.getComboCanton());
  
  }else{
  this.setMensaje("error");
  }
  
  }
   
public void CargarDistrito(AjaxBehaviorEvent event) throws SNMPExceptions, SQLException{
  if(this.ID_Canton >0 && this.ID_Provincia> 0 ){
       
  this.setComboCanton(this.getComboDistrito() );
  
  }else{
  this.setMensaje("error");
  }
  
  }  
   
    public LinkedList<persona> getListaDeDepotista() {
        return listaDeDepotista;
    }

    public void setListaDeDepotista(LinkedList<persona> listaDeDepotista) {
        this.listaDeDepotista = listaDeDepotista;
    }

       private LinkedList<persona> listaDeDepotista= new LinkedList<persona>();

    
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

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
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
    
    public LinkedList<persona> MostrarPersona()  throws SNMPExceptions, SQLException{
      LinkedList<persona> listaD = new LinkedList<persona>();
      personaDB dDB = new personaDB();
        
        listaD = dDB.moTodo();
         this.setListaDeDepotista(listaD);
   return listaD;
    }
     public void AsignaDatos(persona dp) throws SNMPExceptions, SQLException{
    
        this.setApellido1(dp.getApellido1());
       this.setApellido2(dp.getApellido2());
       this.setID_Provincia(dp.getID_Provincia());
       this.setContrasenna(dp.getContrasenna());
     
       this.setCorreo(dp.getCorreo());
       this.setEdad(dp.getEdad());
       dp.getFechaNacimiento();
      
       
       
       
       this.setFechaNacimiento(this.ParseFecha(dp.getFechaNacimiento()) );
       this.setID_Canton(dp.getID_Canton());
       this.setID_Distrito(dp.getID_Distrito());
       this.setIdPersona(dp.getIdPersona());
      
       this.setNombre(dp.getNombre());
        
      
    
    
    }
     public  Date ParseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }
     public void actualizar(){
       personaDB fDB = new personaDB();    persona f1 = new persona();
      try{
          if (validar() == false) {
     
        
             f1.setIdPersona(this.IdPersona);
             f1.setNombre(this.Nombre);
             f1.setApellido1(this.Apellido1);
             f1.setApellido2(this.Apellido2);
              
            f1.setContrasenna(this.Contrasenna);
       
             f1.setFechaNacimiento(this.validarFecha(this.FechaNacimiento));

             f1.setCorreo(this.Correo);
             f1.setEdad(this.Edad);
             f1.setID_Provincia(this.ID_Provincia);
             f1.setID_Canton(this.ID_Canton);
             f1.setID_Distrito(this.ID_Distrito);

            
             

             fDB.actualizar(f1);
             this.MostrarPersona();
             this.Limpiar();
             this.setMensaje("Persona registrada con  exito");
            

         

             
         }

        

     } catch (Exception ex) {
         this.Limpiar();
         this.setMensaje("Hubo un error en nuestro registro o esta identificacion no existe");
         
     }


     }
     public void BuscarPersona()throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException{
     
        try{
        persona dp = new persona();
        personaDB cDB= new personaDB();
        
        
        dp = cDB.selPerXCodP(this.IDBuscar);
       this.setApellido1(dp.getApellido1());
       this.setApellido2(dp.getApellido2());
       this.setID_Provincia(dp.getID_Provincia());
       this.setContrasenna(dp.getContrasenna());
     
       this.setCorreo(dp.getCorreo());
       this.setEdad(dp.getEdad());
       
      
      
       this.setFechaNacimiento( this.ParseFecha(dp.getFechaNacimiento()));
       this.setID_Canton(dp.getID_Canton());
       this.setID_Distrito(dp.getID_Distrito());
       this.setIdPersona(dp.getIdPersona());
      
       this.setNombre(dp.getNombre());
   
        }catch(Exception ex){
        this.setMensaje("Error!! Esta identificacion no Existe");
        }
     
     
     }
     
   public String validarFecha(Date fecha) {
   String fech="";
    Date det  = new Date();
    DateFormat fechaSis = new SimpleDateFormat("dd/MM/yyyy");
     try {  
       fech = fechaSis.format(fecha);
    
    }catch(Exception  ex){
     ex.printStackTrace();
    }
    return fech;
    }
     
        public boolean validar() {
        if (this.IdPersona == 0) {
            this.setMensaje("Campo Identificacion Obligatorio!");
            return true;
        }
        if (this.Nombre.equals("")) {
            this.setMensaje("Campo Nombre Obligatorio!");
            return true;
        }
        if (this.Apellido1.equals("")) {
            this.setMensaje("Campo Primer Apellido Obligatorio!");
            return true;
        }
        if (this.Apellido2.equals("")) {
            this.setMensaje("Campo Segundo Apellido Obligatorio!");
            return true;
        }
        if (this.Contrasenna.equals("")) {
            this.setMensaje("Campo Contraseña Obligatorio!");
            return true;
        }
        if (this.Correo.equals("")) {
            this.setMensaje("Campo Correo Obligatorio!");
            return true;
        }
        if (this.Edad == 0) {
            this.setMensaje("Campo Talla Obligatorio!");
            return true;
        }

        return false;

    }
      public void Limpiar(){
       this.setApellido1("");
       this.setApellido2("");
       this.setID_Provincia(0);
       this.setContrasenna("");
      
       this.setCorreo("");
       this.setEdad(0);
       Date det = null;
       this.setFechaNacimiento(det);
       this.setID_Canton(0);
       this.setID_Distrito(0);
       this.setIdPersona(0);
       this.setMensaje("");
       this.setNombre("");
       
       
       }
     
}
