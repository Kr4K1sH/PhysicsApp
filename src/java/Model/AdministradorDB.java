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
 * @author lrami
 */
public class AdministradorDB {
    
 private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;

    public AdministradorDB() {
        super();
    }
    

    public AdministradorDB(Connection conn) {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);

    }

    public LinkedList<Administrador> listaAdmin() throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
        String select = "";
        LinkedList<Administrador> listaAdmin = new LinkedList<Administrador>();

 

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select = "select idAdministrador,Nombre,Apellido1,Apellido2,contrasenna from administrador";
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {

                int IdAdministrador=rsPA.getInt("idAdministrador");
                String Nombre=rsPA.getString("Nombre");
                String Apellido1=rsPA.getString("Apellido1");
                String Apellido2=rsPA.getString("Apellido2");
                String contrasenna=rsPA.getString("contrasenna");

                Administrador adm = new Administrador(IdAdministrador,Nombre,Apellido1,Apellido2,contrasenna);
                listaAdmin.add(adm);
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

        return listaAdmin;
    }

}

