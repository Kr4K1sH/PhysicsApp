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
 * @author Marc GarNav
 */
public class distritoDB {
    private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;

    private LinkedList<distrito> listaD = new LinkedList<distrito>();

    public distritoDB(Connection conn) {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);
    }

    public distritoDB() {
        super();
    }

    public LinkedList<distrito> moTodo() throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
       String select = "";
      LinkedList<distrito> listaCan = new LinkedList<distrito>();
          
          try {
    
              //Se instancia la clase de acceso a datos
              AccesoDatos accesoDatos = new AccesoDatos();  

              //Se crea la sentencia de búsqueda
              select = 
                 "SELECT COD_PROVINCIA, COD_CANTON,COD_DISTRITO,"
                    + "DSC_DISTRITO,LOG_ACTIVO FROM DISTRITOS ";
                              //Se ejecuta la sentencia SQL
              ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
             //Se llena el arryaList con los proyectos   
              while (rsPA.next()) {

                int codigoProvincia = rsPA.getInt("COD_PROVINCIA");
                int codigoCanton = rsPA.getInt("COD_CANTON");
                int codigodistrito = rsPA.getInt("COD_DISTRITO");
                String dscdistrito= rsPA.getString("DSC_DISTRITO");
               
                int logActivo= rsPA.getInt("LOG_ACTIVO");
                
               distrito perDistrito = new distrito(codigoProvincia,codigoCanton,codigodistrito,dscdistrito,logActivo);
                
                listaCan.add(perDistrito);
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
          return listaCan;
    }
    
    public distrito moBuscarDistrito(float idProv, float idCanton, float idDistrito) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
        String select = "";
        distrito dis = new distrito();

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "SELECT COD_PROVINCIA, COD_CANTON,COD_DISTRITO,"
                    + "DSC_DISTRITO,LOG_ACTIVO FROM DISTRITOS where COD_PROVINCIA="+idProv+" AND COD_CANTON="+idCanton+" AND COD_DISTRITO="+idDistrito;
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {

                int codigoProvincia = rsPA.getInt("COD_PROVINCIA");
                int codigoCanton = rsPA.getInt("COD_CANTON");
                int codigoDistrito = rsPA.getInt("COD_DISTRITO");
                String dscCanton = rsPA.getString("DSC_DISTRITO");
                int logActivo = rsPA.getInt("LOG_ACTIVO");

                dis= new distrito(codigoProvincia, codigoCanton, codigoDistrito, dscCanton, logActivo);
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

        return dis;
    }
}
