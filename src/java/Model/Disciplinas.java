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
public class Disciplinas {
    String Descripcion;
    int IDCodDisciplina;
   public Disciplinas(){
   super();
   }
    public Disciplinas(String Descripcion,
    int IDCodDisciplina){
    
        this.setIDCodDisciplina(IDCodDisciplina);
    this.setDescripcion(Descripcion);
    }
    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getIDCodDisciplina() {
        return IDCodDisciplina;
    }

    public void setIDCodDisciplina(int IDCodDisciplina) {
        this.IDCodDisciplina = IDCodDisciplina;
    }
}
