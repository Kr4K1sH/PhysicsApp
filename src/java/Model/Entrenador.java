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
public class Entrenador {
    public Entrenador(){
    super();
    }

    public Entrenador(int IdPersona, int Telefono, int CodDisciplina) {
        this.IdPersona = IdPersona;
        this.Telefono = Telefono;
        this.CodDisciplina = CodDisciplina;
    }
   
    
      private int IdPersona ;
      private int Telefono ;

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }
      int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
      private int CodDisciplina ;

    public int getIdPersona() {
        return IdPersona;
    }

    public void setIdPersona(int IdPersona) {
        this.IdPersona = IdPersona;
    }

   

    public int getCodDisciplina() {
        return CodDisciplina;
    }

    public void setCodDisciplina(int CodDisciplina) {
        this.CodDisciplina = CodDisciplina;
    }
}
