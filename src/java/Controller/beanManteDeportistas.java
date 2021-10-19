/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AccesoDatos;
import DAO.SNMPExceptions;
import Model.DeportistaDB;
import Model.Depotista;
import Model.Telefono;
import Model.TelefonoDB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;

/**
 *
 * @author Josue A cC
 */
@Named(value = "beanManteDeportistas")
@SessionScoped
public class beanManteDeportistas implements Serializable {

    /**
     * Creates a new instance of beanManteDeportistas
     */
    public beanManteDeportistas() {
    }
      int IdPersonas = 0;
    String EstadoUsuario = "";
    int Peso = 0;
    int Talla = 0;
    double Altura;
    double IMC ;
    String GradoObesidad = "";
    String Obejtivos = "";
    int Telefono = 0;
    int CodDisciplina = 0;

     private LinkedList<Depotista> listaDeDepotista= new LinkedList<Depotista>();

    public LinkedList<Depotista> getListaDeDepotista() throws SNMPExceptions, SQLException{
        return this.listaDeDepotista;
    }

    public void setListaDeDepotista(LinkedList<Depotista> listaDeDepotista) {
        this.listaDeDepotista = listaDeDepotista;
    }
    
    public int getIdPersonas() {
        return IdPersonas;
    }

    public void setIdPersonas(int IdPersonas) {
        this.IdPersonas = IdPersonas;
    }

    public String getEstadoUsuario() {
        return EstadoUsuario;
    }

    public void setEstadoUsuario(String EstadoUsuario) {
        this.EstadoUsuario = EstadoUsuario;
    }

    public int getPeso() {
        return Peso;
    }

    public void setPeso(int Peso) {
        this.Peso = Peso;
    }

    public int getTalla() {
        return Talla;
    }

    public void setTalla(int Talla) {
        this.Talla = Talla;
    }

    public double getAltura() {
        return Altura;
    }

    public void setAltura(double Altura) {
        this.Altura = Altura;
    }

    public double getIMC() {
        return IMC;
    }

    public void setIMC(double IMC) {
        this.IMC = IMC;
    }

    public String getGradoObesidad() {
        return GradoObesidad;
    }

    public void setGradoObesidad(String GradoObesidad) {
        this.GradoObesidad = GradoObesidad;
    }

    public String getObejtivos() {
        return Obejtivos;
    }

    public void setObejtivos(String Obejtivos) {
        this.Obejtivos = Obejtivos;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public int getCodDisciplina() {
        return CodDisciplina;
    }

    public void setCodDisciplina(int CodDisciplina) {
        this.CodDisciplina = CodDisciplina;
    }
    
    String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
   
    
   
    public LinkedList<Depotista> MostrarDeportistas()  throws SNMPExceptions, SQLException{
      LinkedList<Depotista> listaD = new LinkedList<Depotista>();
      DeportistaDB dDB = new DeportistaDB();
        
        listaD = dDB.listaDeportistas();
         this.setListaDeDepotista(listaD);
   return listaD;
    }
    
    public void BuscarDeportista() throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException{
   
        try{
        Depotista dp = new Depotista();
    DeportistaDB cDB= new DeportistaDB();
    dp = cDB.IDDeportista(IdPersonas);
    
    this.setAltura(dp.getAltura());
    this.setCodDisciplina(dp.getCodDisciplina());
    this.setEstadoUsuario(dp.getEstadoUsuario());
    this.setGradoObesidad(dp.getGradoObesidad());
    this.setIMC(dp.getIMC());
    this.setIdPersonas(IdPersonas);
    this.setObejtivos(dp.getObejtivos());
    this.setPeso(dp.getPeso());
    this.setTalla(dp.getTalla());
    this.setTelefono(dp.getTelefono());
        }catch(Exception ex){
        this.setMensaje("Error!! Esta identificacion no Existe");
        }
    }
    
    public void AsignaDatos(Depotista dp) throws SNMPExceptions, SQLException{
    
        
        
        this.setIdPersonas(dp.getIdPersonas());
      this.setAltura(dp.getAltura());
    this.setCodDisciplina(dp.getCodDisciplina());
    this.setEstadoUsuario(dp.getEstadoUsuario());
    this.setGradoObesidad(dp.getGradoObesidad());
    this.setIMC(dp.getIMC());
    
    this.setObejtivos(dp.getObejtivos());
    this.setPeso(dp.getPeso());
    this.setTalla(dp.getTalla());
    this.setTelefono(dp.getTelefono());
    
    
    }
    public void ObtenerIMC() {
        if (this.getPeso() == 0  || this.getAltura() == 0 || this.getAltura() == this.getAltura()/100) {
            this.setMensaje("Debe de insertar valores netos y mayores a 0 en Altura(Cm) y Peso(KG)");
            this.setIMC(0);
            this.setAltura(0);
            this.setPeso(0);
        } else {

            double imc = 0;
            double p = (double) this.getAltura() / 100;
            double c = (double) p * p;
            imc = (double) this.getPeso() / c;
            if (imc < 18.5) {

                this.setGradoObesidad("Bajo peso");
                this.setIMC(imc);

            } else if (imc <= 18.5 || imc <= 24.9) {
                this.setGradoObesidad("Peso normal");
               this.setIMC(imc);

            } else if (imc <= 25 || imc <= 29.9) {
                this.setGradoObesidad("Sobrepeso ");
               this.setIMC(imc);

            } else if (imc <= 30 || imc <= 34.9) {
                this.setGradoObesidad("Obesidad grado I ");

              this.setIMC(imc);
            } else if (imc <= 35 || imc <= 39.99) {
                this.setGradoObesidad("Obesidad grado II");

               this.setIMC(imc);

            } else if (imc >= 40) {
                this.setGradoObesidad("Obesidad grado III");

              this.setIMC(imc);

            }

        }
     }
     public void Actualizar()throws SNMPExceptions, SQLException{
     
         try{
       

        TelefonoDB tel = new TelefonoDB();
        Telefono tel1 = new Telefono();
        
        if(this.getTelefono() == 0 || this.getIdPersonas() == 0){
        this.setMensaje("Los campos Telefono y Identicacion son Obligatorios ");
        }else{
         tel1 = new Telefono( this.getTelefono(),
         this.getIdPersonas());
         tel.actualizarTelefono(tel1);
        
        }
        
       
        if(validar()== false){
  
        Depotista voto = new Depotista();
        double p = this.Altura/100;
        voto.setAltura(p);
        voto.setCodDisciplina(this.CodDisciplina);
        voto.setEstadoUsuario(this.EstadoUsuario);
        voto.setGradoObesidad(this.GradoObesidad);
        voto.setIMC(this.IMC);
        voto.setIdPersonas(this.IdPersonas);
        voto.setObejtivos(this.Obejtivos);
        voto.setPeso(this.Peso);
        voto.setTalla(this.Talla);
        voto.setTelefono(this.Telefono);

        DeportistaDB vDB = new DeportistaDB();
        vDB.actualizarDeportistas(voto);
        this.MostrarDeportistas();
        this.Limpiar();
        }
   
       
       }catch(Exception ex){
       
     this.setMensaje("Hubo un error en nuestro registro o esta identificacion no existe");
       }
        

    }
         
         
     
      public boolean validar(){
    if( this.IdPersonas == 0 || this.EstadoUsuario.equals("")){
    this.setMensaje("Campo Identificacion Obligatorio!");
    return true;
    }
    if(this.CodDisciplina == 0){
    this.setMensaje("Campo CodDisciplina Obligatorio!");
   return true;
    } 
    if(this.Peso ==0){
    this.setMensaje("Campo Peso Obligatorio!");
    return true;
    }
    if(this.Talla ==0){
    this.setMensaje("Campo Talla Obligatorio!");
   return true;
    } 
    if(this.Altura == 0.0){
    this.setMensaje("Campo Altura Obligatorio!");
   return true;
    
    }
     if(this.IMC == 0){
    this.setMensaje("Campo IMC Obligatorio!");
    return true;
    }
    if(this.GradoObesidad.equals("")){
    this.setMensaje("Campo GradoObesidad Obligatorio!");
   return true;
    }
     if(this.Obejtivos.equals("")){
    this.setMensaje("Campo Obejtivos Obligatorio!");
   return true;
    }
        if(this.Telefono==0){
    this.setMensaje("Campo Telefono Obligatorio!");
   return true;
    }
        
   return false;
     
    }
    
public void Limpiar(){
this.setAltura(0);
this.setCodDisciplina(0);
this.setEstadoUsuario("");
this.setGradoObesidad("");
this.setIMC(0);
this.setIdPersonas(0);
this.setMensaje("");
this.setObejtivos("");
this.setPeso(0);
this.setTalla(0);
this.setTelefono(0);
}
}
