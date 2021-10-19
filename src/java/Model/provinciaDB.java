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

/**
 *
 * @author Alberto
 */
public class provinciaDB {
    private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;  

    private LinkedList<provincia> listaP = 
            new LinkedList<provincia>();
    
    public provinciaDB (Connection conn) {
        accesoDatos = new AccesoDatos();    
        accesoDatos.setDbConn(conn);
    }
    
    public provinciaDB() {
        super();
    }
    
    public  LinkedList<provincia> moTodo() throws SNMPExceptions, 
            SQLException {
      String select = "";
      LinkedList<provincia> listaPro = new LinkedList<provincia>();
          
          try {
    
              //Se instancia la clase de acceso a datos
              AccesoDatos accesoDatos = new AccesoDatos();  

              //Se crea la sentencia de búsqueda
              select = 
                      "SELECT Cod_Provincia,Dsc_Corta_Provincia,Dsc_Provincia,Log_Activo FROM Provincias";
              //Se ejecuta la sentencia SQL
              ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
             //Se llena el arryaList con los proyectos   
              while (rsPA.next()) {

                int codigoProvincia = rsPA.getInt("Cod_Provincia");
                String dscCortaProvincia = rsPA.getString("Dsc_Corta_Provincia");
                String dscProvincia = rsPA.getString("Dsc_Provincia");
                int logActivo= rsPA.getInt("Log_Activo");
                
                provincia perProvincia = new provincia(codigoProvincia, 
                            dscCortaProvincia, dscProvincia,logActivo);
                listaPro.add(perProvincia);
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
          return listaPro;
      }
    
    
    public provincia moBuscarProv(float IDProv) throws SNMPExceptions, SQLException {
        String select = "";
      provincia pro = new provincia();

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "SELECT COD_PROVINCIA,DSC_CORTA_PROVINCIA,"
                    + "DSC_PROVINCIA,LOG_ACTIVO FROM PROVINCIAS WHERE COD_PROVINCIA="+IDProv;
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {

                int codigoProvincia = rsPA.getInt("COD_PROVINCIA");
                String dscCortaProvincia = rsPA.getString("DSC_CORTA_PROVINCIA");
                String dscProvincia = rsPA.getString("DSC_PROVINCIA");
                int logActivo = rsPA.getInt("LOG_ACTIVO");

                pro = new provincia(codigoProvincia, dscCortaProvincia, dscProvincia, logActivo);
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

        return pro;
    }
    
 
  
    
    
}
