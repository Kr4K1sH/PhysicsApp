/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.AccesoDatos;
import DAO.SNMPExceptions;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.naming.NamingException;
import Model.Cumplimiento;
/**
 *
 * @author Estudiante
 */
public class CumplimientoDB {
   private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;

     public CumplimientoDB(Connection conn) {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);
    }

    public CumplimientoDB() {
    }
  
    
      public LinkedList<Cumplimiento> ListaDeCumplimientos() throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
        String select = "";
      LinkedList<Cumplimiento> listaCumplimiento = new LinkedList<Cumplimiento>();
          
          try {
    
              //Se instancia la clase de acceso a datos
              AccesoDatos accesoDatos = new AccesoDatos();  

              //Se crea la sentencia de búsqueda
              select = 
                      "SELECT IdCumplimiento ,IdInstructures ,IdDeportistas,ActividadRealizada ,FechaenqueRealizo ,CantidadRepeticiones ,Duracion ,Observaciones  from Cumplimiento";
                      
              //Se ejecuta la sentencia SQL
              ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
             //Se llena el arryaList con los proyectos   
              while (rsPA.next()) {

                int  IdCumplimiento = rsPA.getInt("IdCumplimiento");
                int IdInstructures = rsPA.getInt("IdInstructures");
                int IdDeportistas = rsPA.getInt("IdDeportistas");
                String ActividadRealizada = rsPA.getString("ActividadRealizada");
                Date FechaenqueRealizo = rsPA.getDate("FechaenqueRealizo");
               int CantidadRepeticiones = rsPA.getInt("CantidadRepeticiones");
               int Duracion = rsPA.getInt("Duracion");
               String Observaciones = rsPA.getString("Observaciones");
               
               
               
                
                
                Cumplimiento perCumplimiento = new Cumplimiento(IdCumplimiento,IdInstructures,IdDeportistas,ActividadRealizada,FechaenqueRealizo,CantidadRepeticiones,Duracion,Observaciones);
                      
                listaCumplimiento.add(perCumplimiento);
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
          return listaCumplimiento;
    }
    
    
    
    
    
    
       public Cumplimiento IDCumplimiento(int Cumplimiento) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
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
        Cumplimiento listaCumplimiento = new Cumplimiento();

           
           int  IdCumplimiento ;
                int IdInstructures ;
                int IdDeportistas ;
                String ActividadRealizada;
                Date FechaenqueRealizo ;
               int CantidadRepeticiones ;
               int Duracion ;
               String Observaciones ;
        
        
        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select = "SELECT IdCumplimiento ,IdInstructures ,IdDeportistas,ActividadRealizada ,FechaenqueRealizo ,CantidadRepeticiones ,Duracion ,Observaciones from Cumplimiento where IdCumplimiento ="+Cumplimiento;
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {
                 IdCumplimiento = rsPA.getInt("IdCumplimiento");
                 IdInstructures = rsPA.getInt("IdInstructures");
                 IdDeportistas = rsPA.getInt("IdDeportistas");
                 ActividadRealizada = rsPA.getString("ActividadRealizada");
                 FechaenqueRealizo = rsPA.getDate("FechaenqueRealizo");
                 CantidadRepeticiones = rsPA.getInt("CantidadRepeticiones");
                 Duracion = rsPA.getInt("Duracion");
                 Observaciones = rsPA.getString("Observaciones");
                

                Cumplimiento perCumplimiento = new Cumplimiento(IdCumplimiento,IdInstructures,IdDeportistas,ActividadRealizada,FechaenqueRealizo,CantidadRepeticiones,Duracion,Observaciones);
                      
                listaCumplimiento= perCumplimiento;
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

        return listaCumplimiento;
    }
   
        public void GuardarCumplimiento
        (Cumplimiento Cumplimiento1) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
           //Se obtienen los valores del objeto Cliente
          
            String strSQL = "";
           try {
           Cumplimiento dep = new Cumplimiento();
           dep = Cumplimiento1;
           strSQL = "Insert into Cumplimiento IdCumplimiento ,IdInstructures ,IdDeportistas,ActividadRealizada ,FechaenqueRealizo ,CantidadRepeticiones ,Duracion ,Observaciones"
                    + "     VALUES\n"
                    + "           (" +  dep.getIdCumplimiento() +"'"
                    + "           ," +  dep.getIdInstructures()+"'"
                    + "           ,'" + dep.getIdDeportistas()+ "'"
                    + "           ,'" + dep.getActividadRealizada() + "'"
                    + "           ,'" + dep.getFechaenqueRealizo() + "'"
                    + "           ,'" + dep.getCantidadRepeticiones() + "'"
                    + "           ,'" + dep.getObservaciones() + "'"
                    + "           ,'" + dep.getDuracion() + "'"
                    + "           ," +  dep.getObservaciones() + ")";
           
           
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
