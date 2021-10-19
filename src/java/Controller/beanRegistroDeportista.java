/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.SNMPExceptions;
import Model.DeportistaDB;
import Model.Depotista;
import Model.Disciplinas;
import Model.DisciplinasDB;
import Model.Entrenador;
import Model.EntrenadorDB;
import Model.Telefono;
import Model.TelefonoDB;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;

/**
 *
 * @author Josue A cC
 */
@Named(value = "beanRegistroDeportista")
@SessionScoped
public class beanRegistroDeportista implements Serializable {

    /**
     * Creates a new instance of beanRegistroDeportista
     */
    public beanRegistroDeportista() {
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
    
   int nombre;

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
    
   
   
   String Mensaje;

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
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

    public LinkedList<SelectItem> getListaDisciplinas() throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {

        String Descripcion = "";
        int CodDisciplina = 0;

        LinkedList<Disciplinas> lista = new LinkedList<Disciplinas>();

        DisciplinasDB pDB = new DisciplinasDB();

        lista = pDB.listaDisciplinas();

        LinkedList resultList = new LinkedList();
        resultList.add(new SelectItem(0, "Seleccione Disciplina"));

        for (Iterator iter = lista.iterator();
                iter.hasNext();) {

            Disciplinas pro = (Disciplinas) iter.next();
            Descripcion = pro.getDescripcion();

            CodDisciplina = pro.getIDCodDisciplina();

            resultList.add(new SelectItem(Integer.toString(CodDisciplina), Descripcion));
        }
        return resultList;

    }

    public void insertarDeportista() throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
       try{
       this.EstadoUsuario = "1";

        TelefonoDB tel = new TelefonoDB();
        Telefono tel1 = new Telefono();
        
        if(this.getTelefono() == 0 || this.getIdPersonas() == 0){
        this.setMensaje("Los campos Telefono y Identicacion son Obligatorios ");
        }else{
         tel1 = new Telefono( this.getTelefono(),
         this.getIdPersonas());
         tel.GuardarTelefono(tel1);
        
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
        vDB.GuardarDeportista(voto);
        this.Limpiar();
        }
   
       
       }catch(Exception ex){
       this.Limpiar();
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

public void LimpiarEntrenador(){
this.setCodDisciplina(0);
this.setIdPersonas(0);
this.setNombre(0);
}

public void GuardarEntrenador() throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException{
  
    
     if(this.getNombre() ==0|| this.getIdPersonas() == 0 || this.CodDisciplina == 0){
       this.setMensaje("Campos Obligatorios!");
     
     }
         Entrenador ent = new Entrenador();
         EntrenadorDB db = new EntrenadorDB();
     
       try{
         if(!db.ValidarEntrenador(this.IdPersonas, this.CodDisciplina)){
             ent.setCodDisciplina(CodDisciplina);
        ent.setIdPersona(IdPersonas);
        ent.setTelefono(nombre);

        db.GuardarEntrenador(ent);
   this.LimpiarEntrenador();
        
         }else{
        
             this.LimpiarEntrenador();
             this.setMensaje("Este entrenador ya se encuentra registrado");
         
         }
       }catch(Exception ex){
       this.LimpiarEntrenador();
       this.setMensaje("Este entrenador ya se encuentra registrado en esa disciplina");
       }
     
        
        
    
    }

}
