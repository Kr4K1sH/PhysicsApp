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
public class DeportistaDB {
    public DeportistaDB(){super();
}
    
    public DeportistaDB(Connection conn){
     accesoDatos = new AccesoDatos();
        accesoDatos.setDbConn(conn);
    
    }
    
    private AccesoDatos accesoDatos = new AccesoDatos();
    private Connection conn;

     public LinkedList<Depotista> listaDeportistas() throws SNMPExceptions, SQLException {
       String select = "";
        LinkedList<Depotista> listaDep = new LinkedList<Depotista>();

        int IdPersonas ;
    String EstadoUsuario ;
   int Peso ;
   int Talla;
  double Altura ;
  double IMC ;
  String GradoObesidad ;
 String Obejtivos ; 
 int Telefono ;
 int CodDisciplina ;
        
        
        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select = "select IdPersona,EstadoUsuario,Peso,Talla,Altura,IMC,GradoObesidad,Obejtivos,Telefono,CodDisciplina" +
" from Deportistas";
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {
  IdPersonas = rsPA.getInt("IdPersona");
     EstadoUsuario=rsPA.getString("EstadoUsuario") ;
    Peso = rsPA.getInt("Peso") ;
    Talla= rsPA.getInt("Talla");
   Altura = rsPA.getDouble("Altura") ;
   IMC = rsPA.getDouble("IMC") ;
   GradoObesidad=rsPA.getString("GradoObesidad") ;
  Obejtivos = rsPA.getString("Obejtivos") ; 
  Telefono= rsPA.getInt("Telefono") ;
  CodDisciplina= rsPA.getInt("CodDisciplina") ;
                

                Depotista Dep = new Depotista();
               Dep.setAltura(Altura);
               Dep.setCodDisciplina(CodDisciplina);
               Dep.setEstadoUsuario(EstadoUsuario);
               Dep.setGradoObesidad(GradoObesidad);
               Dep.setIMC(IMC);
               Dep.setIdPersonas(IdPersonas);
               Dep.setObejtivos(Obejtivos);
               Dep.setPeso(Peso);
               Dep.setTalla(Talla);
               Dep.setTelefono(Telefono);
               
                listaDep.add(Dep);
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

        return listaDep;
    }
   
    
       public Depotista IDDeportista(int IdPersona) throws SNMPExceptions, SQLException  {
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
       Depotista listaDep = new Depotista();

        int IdPersonas ;
    String EstadoUsuario ;
   int Peso ;
   int Talla;
  double Altura ;
  double IMC ;
  String GradoObesidad ;
 String Obejtivos ; 
 int Telefono ;
 int CodDisciplina ;
        
        
        try {

            //Se instancia la clase de acceso a datos
            AccesoDatos accesoDatos = new AccesoDatos();

            //Se crea la sentencia de búsqueda
            select = "select IdPersona,EstadoUsuario,Peso,Talla,Altura,IMC,GradoObesidad,Obejtivos,Telefono,CodDisciplina" +
" from Deportistas where IdPersona ="+IdPersona;
            //Se ejecuta la sentencia SQL
            ResultSet rsPA = accesoDatos.ejecutaSQLRetornaRS(select);
            //Se llena el arryaList con los proyectos   
            while (rsPA.next()) {
  IdPersonas = rsPA.getInt("IdPersona");
     EstadoUsuario=rsPA.getString("EstadoUsuario") ;
    Peso = rsPA.getInt("Peso") ;
    Talla= rsPA.getInt("Talla");
   Altura = rsPA.getDouble("Altura") ;
   IMC = rsPA.getDouble("IMC") ;
   GradoObesidad=rsPA.getString("GradoObesidad") ;
  Obejtivos = rsPA.getString("Obejtivos") ; 
  Telefono= rsPA.getInt("Telefono") ;
  CodDisciplina= rsPA.getInt("CodDisciplina") ;
                

                Depotista Dep = new Depotista(IdPersonas,EstadoUsuario, Peso, Talla, Altura, IMC,GradoObesidad,Obejtivos,Telefono,CodDisciplina);
                listaDep = Dep;
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

        return listaDep;
    }
   
       public void GuardarDeportista
        (Depotista Deportista) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
           //Se obtienen los valores del objeto Cliente
          
            String strSQL = "";
           try {
           
          
           strSQL = "Insert into Deportistas "
                   + "(IdPersona,EstadoUsuario,"
                   + "Peso,Talla,Altura,"
                   + "IMC,"
                   + "GradoObesidad,"
                   + "Obejtivos,Telefono,CodDisciplina)"
                    + "VALUES"
                    + "(" +  Deportista.getIdPersonas() + "," 
                    + "'" + Deportista.getEstadoUsuario()+"'"+ ","
                   
                    +   Deportista.getPeso()+ ","
                    +   Deportista.getTalla()  +"," 
                    + Deportista.getAltura()+ ","
                    + Deportista.getIMC() + ","
                    + "'" +  Deportista.getGradoObesidad() +"'"+ ","
                    + "'" +  Deportista.getObejtivos() +"'"+ ","
                    +   Deportista.getTelefono()+ ","
                    + Deportista.getCodDisciplina() + ")";
           
           
             accesoDatos.ejecutaSQL(strSQL);
        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage());
        } finally {
        }
        }
        
        public void EditarDeportista
        (Depotista Deportista) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
           //Se obtienen los valores del objeto Cliente
          
            String strSQL = "";
           try {
           
          
           strSQL = "Update  Deportistas "
                   + "(IdPersonas,EstadoUsuario,"
                   + "Peso,Talla,Altura,"
                   + "IMC,"
                   + "GradoObesidad,"
                   + "Obejtivos,Telefono,CodDisciplina)"
                    + "VALUES"
                    + "(" +  Deportista.getIdPersonas() + "," 
                    + "'" + Deportista.getEstadoUsuario()+"'"+ ","
                   
                    +   Deportista.getPeso()+ ","
                    +   Deportista.getTalla()  +"," 
                    + Deportista.getAltura()+ ","
                    + Deportista.getIMC() + ","
                    + "'" +  Deportista.getGradoObesidad() +"'"+ ","
                    + "'" +  Deportista.getObejtivos() +"'"+ ","
                    +   Deportista.getTelefono()+ ","
                    + Deportista.getCodDisciplina() + ")";
           
           
             accesoDatos.ejecutaSQL(strSQL);
        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION,
                    e.getMessage());
        } finally {
        }
        }
     public void actualizarDeportistas(Depotista dp) throws SNMPExceptions, SQLException, NamingException, ClassNotFoundException {
           //Se obtienen los valores del objeto Cliente
           Depotista d = new Depotista();
           d = dp;
           
           //Datos de CLiente         
           int IdPersonas = d.getIdPersonas() ;
    String EstadoUsuario = d.getEstadoUsuario();
   int Peso = d.getPeso();
   int Talla= d.getTalla();
  double Altura = d.getAltura();
  double IMC =d.getIMC();
  String GradoObesidad =d.getGradoObesidad();
 String Obejtivos =d.getObejtivos(); 
 int Telefono =d.getTelefono();
 int CodDisciplina = d.getCodDisciplina() ;
        
           

            
         
           //Se crea la sentencia de actualización
           String update = 
                   " update Deportistas set EstadoUsuario= '"
                   +EstadoUsuario+"',peso ="+ Peso+", Talla ="+ Talla+", Altura="
                   + Altura+", IMC="+IMC+" , GradoObesidad = '"
                   +GradoObesidad+"',Obejtivos='"+Obejtivos+"',Telefono="+Telefono+
                   ", CodDisciplina="+CodDisciplina+" where IdPersona ="+IdPersonas;
           //Se ejecuta la sentencia SQL
           accesoDatos.ejecutaSQL(update);
               
     }    
}
