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
public class cantonDB {
    private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;

    
    
    private LinkedList<canton> listaC = new LinkedList<canton>();

    public cantonDB(Connection conn) {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);
    }

    public cantonDB() {
    
    }

    public LinkedList<canton> moTodo() throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
        String select = "";
      LinkedList<canton> listaCan = new LinkedList<canton>();
          
          try {
    
              //Se instancia la clase de acceso a datos
              AccesoDatos accesoDatos = new AccesoDatos();  

              //Se crea la sentencia de búsqueda
              select = 
                      "SELECT COD_PROVINCIA,COD_CANTON,"
                      + "DSC_CANTON,LOG_ACTIVO FROM CANTONES";
              //Se ejecuta la sentencia SQL
              ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
             //Se llena el arryaList con los proyectos   
              while (rsPA.next()) {

                int codigoProvincia = rsPA.getInt("COD_PROVINCIA");
                int codigoCanton = rsPA.getInt("COD_CANTON");
                
                String dscCanton = rsPA.getString("DSC_CANTON"
                        );
               
                int logActivo= rsPA.getInt("LOG_ACTIVO");
                
                canton perCantones = new canton(codigoProvincia,codigoCanton, 
                       dscCanton,  logActivo  );
                listaCan.add(perCantones);
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
    
    public canton moBuscarCanton(float idProv, float idCanton) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
        String select = "";
        canton can = new canton();

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "SELECT COD_PROVINCIA, COD_CANTON,"
                    + "DSC_CANTON,LOG_ACTIVO FROM CANTONES where COD_PROVINCIA="+idProv+" AND COD_CANTON="+idCanton;
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {

                 int codigoProvincia = rsPA.getInt("COD_PROVINCIA");
                int codigoCanton = rsPA.getInt("COD_CANTON");
                String dscCanton = rsPA.getString("DSC_CANTON");
                int logActivo = rsPA.getInt("LOG_ACTIVO");

                can = new canton(codigoProvincia, codigoCanton, dscCanton, logActivo);
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

        return can;
    }
}
