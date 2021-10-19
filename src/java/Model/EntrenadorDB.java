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
import java.util.LinkedList;
import javax.naming.NamingException;

/**
 *
 * @author Josue A cC
 */
   public class EntrenadorDB {
    private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;  
    
    public EntrenadorDB(){
    super();
    }
    public EntrenadorDB(Connection conn){
     accesoDatos = new AccesoDatos();    
        accesoDatos.setDbConn(conn);
    }
    public  LinkedList<Entrenador> listaEntrenador() throws SNMPExceptions, SQLException {
          String select = "";
          LinkedList<Entrenador> listaEntr = new LinkedList<Entrenador>();
         int id;
          int IdPersona ;
       int Nombre ;
     
       int CodDisciplina ;
        
       try {
             //open();
              //Se instancia la clase de acceso a datos
              AccesoDatos accesoDatos = new AccesoDatos();  

              //Se crea la sentencia de búsqueda
              select = 
   "select IdInstructor,Telefono,IdPersona,CodDisciplina" +
" from Instructores";
             
              //Se ejecuta la sentencia SQL
              ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
              //Se llena el arryaList con los catálogos   
              while (rsPA.next()) {
         id= rsPA.getInt("IdInstructor");
           Nombre = rsPA.getInt("Telefono");
               
                IdPersona = rsPA.getInt("IdPersona");
                        
                CodDisciplina = rsPA.getInt("CodDisciplina");
               
                    Entrenador cOL = new Entrenador();
                  cOL.setID(id);
                  cOL.setTelefono(Nombre);
                  cOL.setIdPersona(IdPersona);

                  cOL.setCodDisciplina(CodDisciplina);

               
                
               listaEntr.add(cOL);
              }
              rsPA.close();

          } catch (SQLException e) {
              throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                      e.getMessage(), e.getErrorCode());
          }catch (Exception e) {
              throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                      e.getMessage());
          } finally {

          }      
          return listaEntr;
      }
    
    public boolean ValidarEntrenador(int id,int dic) throws SNMPExceptions, SQLException {
    
      boolean existe = false;
        String select = "";
        try {
            //Se intancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de Busqueda
            select = "SELECT * FROM instructores where idpersona=" + id+"and CodDisciplina="+dic;

            //se ejecuta la sentencia sql
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //se llama el array con los proyectos
            if (rsPA.next()) {

                existe = true;
            }

            rsPA.close();

   return existe;
        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } finally {
            
        }
       
    }
    
    
    
    
     public LinkedList<Entrenador>  IdEntrenador(int IdPersona) throws SNMPExceptions, SQLException {
          String select = "";
        
          int IdPerson ;
       int Nombre ;
     int Id;
       int CodDisciplina ;
       
       LinkedList<Entrenador> listaEntr = new LinkedList<Entrenador>();
         
         Entrenador Entr = new Entrenador();
          try {
             //open();
              //Se instancia la clase de acceso a datos
              AccesoDatos accesoDatos = new AccesoDatos();  

              //Se crea la sentencia de búsqueda
               select = 
   "select IdInstructor,Telefono,IdPersona,CodDisciplina" +
" from Instructores where IdPersona = "+IdPersona;
  
              //Se ejecuta la sentencia SQL
              ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
              //Se llena el arryaList con los catálogos   
              while (rsPA.next()) {
                  Id = rsPA.getInt("IdInstructor");   Nombre = rsPA.getInt("Telefono");
                  IdPerson = rsPA.getInt("IdPersona");
               
                  CodDisciplina = rsPA.getInt("CodDisciplina");
                  
                  Entr.setID(Id);
                  
                  Entr.setCodDisciplina(CodDisciplina);
                  Entr.setIdPersona(IdPerson);
                  Entr.setTelefono(Nombre);
                         
                listaEntr.add(Entr);
             
              }
              rsPA.close();

          } catch (SQLException e) {
              throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                      e.getMessage(), e.getErrorCode());
          }catch (Exception e) {
              throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                      e.getMessage());
          } finally {

          }      
          return listaEntr;
      }
     public void ActualizaEntrenador(Entrenador ent) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException{
     
     String strSQL = "";
           try {
           Entrenador dep = new Entrenador();
           dep = ent;
           strSQL="update Instructores set Telefono ='"+ent.getTelefono()+"'"+","+
                   "CodDisciplina =" +ent.getCodDisciplina()+
                    "where IdInstructor ="+ent.getID() +"and IdPersona = "+ent.getIdPersona()+"";
           
           
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
    
      public void GuardarEntrenador
        (Entrenador ent) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
           //Se obtienen los valores del objeto Cliente
          
            String strSQL = "";
           try {
           Entrenador dep = new Entrenador();
           dep = ent;
           strSQL = "Insert into Instructores (Telefono,IdPersona,CodDisciplina) "
                    + "     VALUES"
                    + "(" + dep.getTelefono()
                    + "," +dep.getIdPersona() + "," 
                     + dep.getCodDisciplina() + ")";
           
           
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
    
}
