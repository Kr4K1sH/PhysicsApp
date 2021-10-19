/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.AccesoDatos;
import DAO.SNMPExceptions;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import javax.naming.NamingException;

/**
 *
 * @author Josue A cC
 */
public class TelefonoDB {
    public TelefonoDB(){
    super();
    }
    
    public TelefonoDB(Connection conn){
     accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);
    
    }
    
    private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;
    
    public LinkedList<Telefono> listaTelefono() throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
       String select = "";
        LinkedList<Telefono> listaTel = new LinkedList<Telefono>();
  int  NumeroTelefono;
  int  IDUsuario ;
   int CodTipoTel;

       
        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select = "select NumeroTelefono,IDUsuario,CodTipoTel from Telefono ";
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {
  
                NumeroTelefono = rsPA.getInt("NumeroTelefono");
                IDUsuario = rsPA.getInt("IDUsuario");
                CodTipoTel = rsPA.getInt("CodTipoTel");

                Telefono Dep = new Telefono(NumeroTelefono,IDUsuario);
               listaTel.add(Dep);
            }
            rsPA.close();

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage());
        } finally {

        }

        return listaTel;
    }
    
  public LinkedList<Telefono> TelPorIDPersona(int IdPersona) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
      //////////////////////////////////////////////////////////////////////
      ////////////POSIBLE IMPLEMENTACION DE BUSQUEDA ID PERSONA//////////
      //////////////////////////////////////////
      /////////////////////
      ////////////////
      ///////////
      /////
      ///
      //
             String select = "";  
         LinkedList<Telefono> listaTel = new LinkedList<Telefono>();
  int  NumeroTelefono;
  int  IDUsuario ;
   int CodTipoTel;

       
        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select = "select NumeroTelefono,IDUsuario,CodTipoTel from Telefono where IDUsuario = "+IdPersona;
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {
  
                NumeroTelefono = rsPA.getInt("NumeroTelefono");
                IDUsuario = rsPA.getInt("IDUsuario");
                CodTipoTel = rsPA.getInt("CodTipoTel");

                Telefono Dep = new Telefono(NumeroTelefono,IDUsuario);
               listaTel.add(Dep);
            }
            rsPA.close();

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage());
        } finally {

        }

        return listaTel;
    }
  
   public void GuardarTelefono (Telefono ent) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
           //Se obtienen los valores del objeto Cliente
          
            String strSQL = "";
           try {
           Telefono dep = new Telefono();
           dep = ent;
           strSQL = "Insert into Telefono (IdPersona,NumeroTelefono) "
                    + "     VALUES"
                    + "           (" +  dep.getIDUsuario()
                    + "," + dep.getNumeroTelefono()+ ")";
                  
                   
           
           
             accesoDatos.ejecutaSQL(strSQL/*, sqlBitacora*/);
        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage());
        } finally {
        }
        }
     public void actualizarTelefono(Telefono tel) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
           //Se obtienen los valores del objeto Cliente
           Telefono d = new Telefono();
           d = tel;
           
           //Datos de CLiente         
            int id = d.getIDUsuario();
            int te = d.getNumeroTelefono();
            
           

            
         
           //Se crea la sentencia de actualización
           String update = 
                   "UPDATE telefono SET Numerotelefono = " + te  +" where IdPersona ="+ id;
           //Se ejecuta la sentencia SQL
           accesoDatos.ejecutaSQL(update);
               
     }
}
