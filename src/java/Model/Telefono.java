/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Josue A cC
 */
public class Telefono {
    
    public Telefono(){
    super();
    }
    public Telefono( int  NumeroTelefono,
  int  IDUsuario ){
        this.setNumeroTelefono(NumeroTelefono);
        this.setIDUsuario(IDUsuario);
 
    }
   int  NumeroTelefono;
  int  IDUsuario ;
  

    public int getNumeroTelefono() {
        return NumeroTelefono;
    }

    public void setNumeroTelefono(int NumeroTelefono) {
        this.NumeroTelefono = NumeroTelefono;
    }

    public int getIDUsuario() {
        return IDUsuario;
    }

    public void setIDUsuario(int IDUsuario) {
        this.IDUsuario = IDUsuario;
    }

  
   
   
}
