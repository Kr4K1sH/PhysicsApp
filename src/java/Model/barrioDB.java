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
public class barrioDB {
    private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;

    private LinkedList<barrio> listaD = new LinkedList<barrio>();

    public barrioDB(Connection conn) {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);
    }

    public barrioDB() {
        super();
    }

    public LinkedList<barrio> moTodo() throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
       String select = "";
        LinkedList<barrio> listaBar = new LinkedList<barrio>();

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select = "SELECT COD_PROVINCIA,COD_CANTON,COD_DISTRITO,COD_BARRIO,DSC_BARRIO,LOG_ACTIVO FROM BARRIO";
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {

                float codigoProvincia = rsPA.getFloat("COD_PROVINCIA");
                float codigoCanton = rsPA.getFloat("COD_CANTON");
                float codigoDistrito = rsPA.getFloat("COD_DISTRITO");
                float codigoBarrio = rsPA.getFloat("COD_BARRIO");
                String dscBarrio = rsPA.getString("DSC_BARRIO");
                float logActivo = rsPA.getFloat("LOG_ACTIVO");

                barrio perdBarrio= new barrio(codigoProvincia, codigoCanton, codigoDistrito, codigoBarrio, dscBarrio, logActivo);
                listaBar.add(perdBarrio);
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

        return listaBar;
    }
    
    
    public barrio moBuscarBarrio(float pro, float can, float dis, float bar) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
        String select = "";
        barrio nubarrio = new barrio();

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "SELECT COD_PROVINCIA, COD_CANTON,COD_DISTRITO,COD_BARRIO,"
                    + "DSC_BARRIO,LOG_ACTIVO FROM BARRIOS where COD_PROVINCIA="+pro+" AND COD_CANTON="+can+" AND COD_DISTRITO="+dis+" AND COD_BARRIO="+bar;
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {

                float codigoProvincia = rsPA.getFloat("COD_PROVINCIA");
                float codigoCanton = rsPA.getFloat("COD_CANTON");
                float codigoDistrito = rsPA.getFloat("COD_DISTRITO");
                float codigoBarrio = rsPA.getFloat("COD_BARRIO");
                String dscBarrio = rsPA.getString("DSC_BARRIO");
                float logActivo = rsPA.getFloat("LOG_ACTIVO");

                nubarrio= new barrio(codigoProvincia, codigoCanton, codigoDistrito, codigoBarrio, dscBarrio, logActivo);
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

        return nubarrio;
    }
}
