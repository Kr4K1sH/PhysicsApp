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
public class DisciplinasDB {
     public DisciplinasDB(){
   super();
   }
        private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;
    
      public DisciplinasDB(Connection conn){
     accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);
    
    } 
     
      
       public LinkedList<Disciplinas> listaDisciplinas() throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
       String select = "";
        LinkedList<Disciplinas> listaDisciplinas = new LinkedList<Disciplinas>();
  
  String Descripcion;
    int IDCodDisciplina;
       
        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select = "select CodDisciplina,Descripcion from Disciplinas";
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {
  
               Descripcion = rsPA.getString("Descripcion");
               IDCodDisciplina = rsPA.getInt("CodDisciplina");

                Disciplinas Dep = new Disciplinas(Descripcion,IDCodDisciplina);
               listaDisciplinas.add(Dep);
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

        return listaDisciplinas;
    }
      public void GuardarEntrenadorIDdisciplinas(int IDInstructor, int IDdisciplina) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
           //Se obtienen los valores del objeto Cliente
          
            String strSQL = "";
           try {
          
           strSQL = "Insert into DisciplinaInstructor (IdInstructores,CodDisciplina) "
                    + "     VALUES"
                    + "(" + IDInstructor
                    + "," + IDdisciplina + ")";
           
           
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
    
       
       
       
       
    public LinkedList<Disciplinas> disciplinasXInstructor(int IDInstructor) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException{
    
       String select = "";
        LinkedList<Disciplinas> listaDisciplinas = new LinkedList<Disciplinas>();
  
  String Descripcion;
    int IDCodDisciplina;
       
        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select = "SELECT Instructores.IdPersonas, Disciplinas.Descripcion, Disciplinas.CodDisciplina" +
                     "FROM Disciplinas INNER JOIN" +
                     " Instructores ON Disciplinas.CodDisciplina ="+ IDInstructor;
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {
  
               Descripcion = rsPA.getString("Descripcion");
               IDCodDisciplina = rsPA.getInt("CodDisciplina");

                Disciplinas Dep = new Disciplinas(Descripcion,IDCodDisciplina);
               listaDisciplinas.add(Dep);
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

        return listaDisciplinas;
    }
    
    
    
       
       
       
    public AccesoDatos getAccesoDatos() {
        return accesoDatos;
    }

    public void setAccesoDatos(AccesoDatos accesoDatos) {
        this.accesoDatos = accesoDatos;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
      
}
