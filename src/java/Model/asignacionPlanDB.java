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

/**
 *
 * @author Estudiante
 */
public class asignacionPlanDB {
        private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;

    private LinkedList<AsignacionPlan> listaAsignacion = new LinkedList<AsignacionPlan>();

    public asignacionPlanDB(Connection conn) {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);
    }

    public asignacionPlanDB() {
        super();
    }

    public LinkedList<AsignacionPlan> ListaDeAsignaciones() throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
       String select = "";
        LinkedList<AsignacionPlan> listaAsig = new LinkedList<AsignacionPlan>();

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select = "SELECT IdAsignacionPlan, IdInstructures, IdDeportistas, Perioricidad, FechaInicio, FechaFinal, Explicacion, CodDisciplina, Duracion, Repeticiones\n" +
                            "FROM AsignacionPlan";
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {

                int IdAsignacionPlan = rsPA.getInt("IdAsignacionPlan");
                int IdInstructores = rsPA.getInt("IdInstructores");
                int IdDeportistas = rsPA.getInt("IdDeportistas");
                String Perioricidad = rsPA.getString("Perioricidad");
                Date FechaInicio = rsPA.getDate("FechaIncio");
                Date FechaFinal = rsPA.getDate("FechaFinal");
                String Explicacion = rsPA.getString("Explicacion");
                int codDisciplina = rsPA.getInt("CodDisciplina");
                int Duracion = rsPA.getInt("Duracion");
                int Repeticiones = rsPA.getInt("Repeticiones");

                AsignacionPlan asigPlan= new AsignacionPlan(IdAsignacionPlan, IdInstructores, IdDeportistas,Perioricidad, FechaInicio,FechaFinal,codDisciplina,Explicacion,Duracion,Repeticiones);
                listaAsig.add(asigPlan);
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

        return listaAsig;
    }
    
      public AsignacionPlan IDAsignacionPlan(int IDAsignacionPlan) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
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
        AsignacionPlan Asignacion = new AsignacionPlan();

           
           
        
        
        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select = "SELECT IdAsignacionPlan, IdInstructures, IdDeportistas, Perioricidad, FechaInicio, FechaFinal, Explicacion, CodDisciplina, Duracion, Repeticiones" +
                            "FROM AsignacionPlan where IdAsignacionPlan="+IDAsignacionPlan;
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {
              
                int IdAsignacionPlan = rsPA.getInt("IdAsignacionPlan");
                int IdInstructores = rsPA.getInt("IdInstructores");
                int IdDeportistas = rsPA.getInt("IdDeportistas");
                String Perioricidad = rsPA.getString("Perioricidad");
                Date FechaInicio = rsPA.getDate("FechaIncio");
                Date FechaFinal = rsPA.getDate("FechaFinal");
                String Explicacion = rsPA.getString("Explicacion");
                int codDisciplina = rsPA.getInt("CodDisciplina");
                int Duracion = rsPA.getInt("Duracion");
                int Repeticiones = rsPA.getInt("Repeticiones");
                

                AsignacionPlan perAsignacionPlan = new AsignacionPlan(IdAsignacionPlan,IdInstructores,IdDeportistas,Perioricidad,FechaInicio,FechaFinal,codDisciplina,Explicacion,Duracion,Repeticiones);
                      
                Asignacion = perAsignacionPlan;
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

        return Asignacion;
    }
   
  public void GuardarAsignacionPlan
        (AsignacionPlan AsignacionPlan1) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
           //Se obtienen los valores del objeto Cliente
          
            String strSQL = "";
           try {
           AsignacionPlan dep = new AsignacionPlan();
           dep = AsignacionPlan1;
           strSQL = "Insert into  IdAsignacionPlan, IdInstructures, IdDeportistas, Perioricidad, FechaInicio, FechaFinal, Explicacion, CodDisciplina, Duracion, Repeticiones"
                    + "     VALUES\n"
                    + "           (" +  dep.getIdAsignacionPlan() +"'"
                    + "           ," +  dep.getIdInstructores()+"'"
                    + "           ,'" + dep.getIdDeportistas()+ "'"
                    + "           ,'" + dep.getPerioricidad() + "'"
                    + "           ,'" + dep.getFechaInicio() + "'"
                    + "           ,'" + dep.getFechaFinal() + "'"
                    + "           ,'" + dep.getExplicacion() + "'"
                    + "           ,'" + dep.getCodDisciplina() + "'"
                   + "           ,'" + dep.getDuracion() + "'"
                    + "           ," +  dep.getRepeticiones() + ")";
           
           
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
