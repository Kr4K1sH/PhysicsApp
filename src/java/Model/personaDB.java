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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import javax.naming.NamingException;

/**
 *
 * @author lrami
 */
public class personaDB {

    private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;

    public personaDB() {
        accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);
    }

    //metodo que se trae toda la lista de los clientes
    public LinkedList<persona> moTodo() throws SNMPExceptions, SQLException {
        String select = "";
        LinkedList<persona> listaPersonas = new LinkedList<persona>();

        try {
            //Se intancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de Busqueda
            select
                    = "Select IdPersona,Nombre,Apellido1,Apellido2,contrasenna,FechaNacimiento,Edad,IdProvincia,IdCanton,IdDistrito,CorreoElectronico from Personas";

            //se ejecuta la sentencia sql
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //se llama el array con los proyectos
            while (rsPA.next()) {

                int IdPersona = rsPA.getInt("IdPersona");
                String Nombre = rsPA.getString("Nombre");
                String Apellido1 = rsPA.getString("Apellido1");
                String Apellido2 = rsPA.getString("Apellido2");
                String contrasenna = rsPA.getString("contrasenna");
                String FechaNacimiento = rsPA.getString("FechaNacimiento");
                int Edad = rsPA.getInt("Edad");
                int IdProvincia = rsPA.getInt("IdProvincia");
                int IdCanton = rsPA.getInt("IdCanton");
                int IdDistrito = rsPA.getInt("IdDistrito");
                String CorreoElectronico = rsPA.getString("CorreoElectronico");

                //se construye el objeto.
                persona objPersona = new persona();
                 objPersona.setIdPersona(IdPersona);
                objPersona.setNombre(Nombre);
                objPersona.setApellido1(Apellido1);
                objPersona.setApellido2(Apellido2);
                objPersona.setContrasenna(contrasenna);
                objPersona.setFechaNacimiento(FechaNacimiento);
                objPersona.setCorreo(CorreoElectronico);
                objPersona.setEdad(Edad);
                objPersona.setID_Provincia(IdProvincia);
                objPersona.setID_Canton(IdCanton);
                objPersona.setID_Distrito(IdDistrito);
               
              
                

                listaPersonas.add(objPersona);
            }
            rsPA.close();//se cierra el ResultSeat.

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (SNMPExceptions | ClassNotFoundException | NamingException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } finally {

        }
        return listaPersonas;
    }

    public persona selPerXCodP(int idPersona) throws SNMPExceptions, SQLException {
        String select = "";
        persona listaPersonas = new persona();

        try {
            //Se intancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de Busqueda
            select
                    = "Select IdPersona,Nombre,Apellido1,Apellido2,contrasenna,FechaNacimiento,Edad,IdProvincia,IdCanton,IdDistrito,CorreoElectronico from Personas where idPersona=" + idPersona;

            //se ejecuta la sentencia sql
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //se llama el array con los proyectos
            while (rsPA.next()) {

                int IdPersona = rsPA.getInt("IdPersona");
                String Nombre = rsPA.getString("Nombre");
                String Apellido1 = rsPA.getString("Apellido1");
                String Apellido2 = rsPA.getString("Apellido2");
                String contrasenna = rsPA.getString("contrasenna");
                String FechaNacimiento = rsPA.getString("FechaNacimiento");
                int Edad = rsPA.getInt("Edad");
                int IdProvincia = rsPA.getInt("IdProvincia");
                int IdCanton = rsPA.getInt("IdCanton");
                int IdDistrito = rsPA.getInt("IdDistrito");
                String CorreoElectronico = rsPA.getString("CorreoElectronico");

                //se construye el objeto.
                persona objPersona = new persona();
                  objPersona.setNombre(Nombre);
                objPersona.setIdPersona(IdPersona);
                objPersona.setCorreo(CorreoElectronico);
                  objPersona.setApellido1(Apellido1);
                  objPersona.setApellido2(Apellido2);
                  objPersona.setContrasenna(contrasenna);
                     objPersona.setFechaNacimiento(FechaNacimiento);
                  objPersona.setEdad(Edad);
               
                  objPersona.setID_Canton(IdCanton);
                  objPersona.setID_Distrito(IdDistrito);
                  objPersona.setID_Provincia(IdProvincia);
                  
                 
                listaPersonas = objPersona;
            }
            rsPA.close();//se cierra el ResultSeat.

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (SNMPExceptions | ClassNotFoundException | NamingException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } finally {

        }
        return listaPersonas;
    }

    public LinkedList<provincia> provinciaTodo() throws SNMPExceptions, //para agregar parametros : agregarle el parametro de moTodo(etc.)
            SQLException {
        String select = "";
        LinkedList<provincia> listaPro = new LinkedList<provincia>();

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "SELECT COD_PROVINCIA,DSC_CORTA_PROVINCIA,DSC_PROVINCIA,LOG_ACTIVO FROM PROVINCIAS";
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {

                int codigoProvincia = rsPA.getInt("COD_PROVINCIA");
                String dscCortaProvincia = rsPA.getString("DSC_CORTA_PROVINCIA");
                String dscProvincia = rsPA.getString("DSC_PROVINCIA");
                int logActivo = rsPA.getInt("LOG_ACTIVO");

                provincia perProvincia = new provincia();
                
                perProvincia.setCod_Provincia(codigoProvincia);
                perProvincia.setDsc_Corta_Provincia(dscCortaProvincia);
                perProvincia.setDsc_Provincia(dscProvincia);
                perProvincia.setLog_Activo(logActivo);
                
                listaPro.add(perProvincia);
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
        return listaPro;
    }

    public LinkedList<canton> selCanton(int codProv) throws SNMPExceptions, SQLException {
        String select = "";
        LinkedList<canton> listaCan = new LinkedList<canton>();

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select
                    = "SELECT COD_PROVINCIA,COD_CANTON,"
                    + "DSC_CANTON,LOG_ACTIVO FROM CANTONES where cod_provincia="+codProv;
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {

                int codigoProvincia = rsPA.getInt("Cod_Provincia");
                int codigoCanton = rsPA.getInt("Cod_Canton");

                String dscCanton = rsPA.getString("Dsc_Canton"
                );

                int logActivo = rsPA.getInt("Log_Activo");

                canton perCantones = new canton(codigoProvincia, codigoCanton,
                        dscCanton, logActivo);
                listaCan.add(perCantones);
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
        return listaCan;
    }

    public LinkedList<distrito> selDistrito(int codProv, int codCan) throws SNMPExceptions,
            SQLException {
         String select = "";
      LinkedList<distrito> listaDistrito = new LinkedList<distrito>();
          
          try {
    
              //Se instancia la clase de acceso a datos
              AccesoDatos accesoDatos = new AccesoDatos();  

              //Se crea la sentencia de búsqueda
             
                 select = "SELECT COD_PROVINCIA, COD_CANTON, COD_DISTRITO, DSC_DISTRITO, LOG_ACTIVO FROM DISTRITOS where Cod_Provincia="+codProv+"and cod_canton="+codCan;
                              //Se ejecuta la sentencia SQL
              ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
             //Se llena el arryaList con los proyectos   
              while (rsPA.next()) {

                int codigoProvincia = rsPA.getInt("COD_PROVINCIA");
                int codigoCanton = rsPA.getInt("COD_CANTON");
                int codigodistrito = rsPA.getInt("COD_DISTRITO");
                String dscdistrito= rsPA.getString("DSC_DISTRITO");
               
                int logActivo= rsPA.getInt("LOG_ACTIVO");
                
               distrito perDistrito = new distrito();
               perDistrito.setCod_provincia(codigoProvincia);
               perDistrito.setCod_canton(codigoCanton);
                perDistrito.setCod_distrito(codigodistrito);
                perDistrito.setDsc_distrito(dscdistrito);
                perDistrito.setLog_activo(logActivo);
                
                listaDistrito.add(perDistrito);
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
          return listaDistrito;
        
    }

    public void insertar(persona oPersona) throws SNMPExceptions,
            SQLException {
        String select = "";
        String idCan;
        String idDis;
        if (oPersona.getID_Canton() < 10) {
            idCan = "0" + oPersona.getID_Canton();
        } else {
            idCan = "" + oPersona.getID_Canton();
        }

        if (oPersona.getID_Distrito() < 10) {
            idDis = "0" + oPersona.getID_Distrito();
        } else {
            idDis = "" + oPersona.getID_Distrito();
        }

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select = "INSERT INTO Personas(IdPersona,Nombre, Apellido1, Apellido2,contrasenna, "
                    + "FechaNacimiento,Edad,IdProvincia,IdCanton,IdDistrito,CorreoElectronico)VALUES("
                    + oPersona.getIdPersona() + ",'" 
                    + oPersona.getNombre() + "'"+",'" 
                    + oPersona.getApellido1() + "','"
                    + oPersona.getApellido2() + "','"
                    
                    + oPersona.getContrasenna() + "','"
                    + oPersona.getFechaNacimiento()+ "',"
                    + oPersona.getEdad() + "," 
                    + oPersona.getID_Provincia() + "," 
                    + oPersona.getID_Canton() + ","
                    + oPersona.getID_Distrito() + ",'"
                    + oPersona.getCorreo() + "')";

            accesoDatos.ejecutaSQL(select);

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage());
        } finally {

        }
    }

    public void actualizar(persona oPersona) throws SNMPExceptions,
            SQLException {
        String select = "";
        String idCan;
        String idDis;
        if (oPersona.getID_Canton() < 10) {
            idCan = "0" + oPersona.getID_Canton();
        } else {
            idCan = "" + oPersona.getID_Canton();
        }

        if (oPersona.getID_Distrito() < 10) {
            idDis = "0" + oPersona.getID_Distrito();
        } else {
            idDis = "" + oPersona.getID_Distrito();
        }

        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select = "UPDATE Personas SET Nombre ='"+oPersona.getNombre()+"'"+","+
                                      "Apellido1 ='"+oPersona.getApellido1()+"'"+","+
					"Apellido2 ='"+oPersona.getApellido2()+"'"+","+
					"FechaNacimiento ='"+oPersona.getFechaNacimiento()+"'"+","+
                                         "contrasenna ='"+ oPersona.getContrasenna() +"',"+
                                         "Edad="+oPersona.getEdad()+","+
					 "IdProvincia="+oPersona.getID_Provincia()+","+
                                        "IdCanton="+ oPersona.getID_Canton()+ ","+
					"IdDistrito="+oPersona.getID_Distrito()+","+
					"CorreoElectronico='"+oPersona.getCorreo()+"'"+
                                         "where IdPersona ="+oPersona.getIdPersona()+"";
                                         
                                              
            accesoDatos.ejecutaSQL(select);

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage());
        } finally {

        }
    }

    public boolean validarRepetido(int idPersona) throws SNMPExceptions,
            SQLException {

        boolean existe = false;
        String select = "";
        try {
            //Se intancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de Busqueda
            select = "SELECT * FROM Personas where IdPersona=" + idPersona;

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

}
