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
public class Depotista {
    
    public Depotista(){
super();
}
    public Depotista(int IdPersonas, String EstadoUsuario,int Peso,int Talla,double Altura,double IMC,String GradoObesidad,String Obejtivos,int Telefono,int CodDisciplina  ){
this.setIdPersonas(IdPersonas);
this.setEstadoUsuario(EstadoUsuario);
this.setPeso(Peso);
this.setTalla(Talla);
this.setIMC(IMC);
this.setGradoObesidad(GradoObesidad);
this.setObejtivos(Obejtivos);
this.setTelefono(Telefono);
    this.setCodDisciplina(CodDisciplina);
    }
    
   private int IdPersonas ;
 private   String EstadoUsuario ;
  private int Peso ;
  private int Talla;
 private double Altura ;
 private double IMC ;
 private String GradoObesidad ;
private String Obejtivos ; 
private int Telefono ;
private int CodDisciplina ;

    public int getIdPersonas() {
        return IdPersonas;
    }

    public void setIdPersonas(int IdPersonas) {
        this.IdPersonas = IdPersonas;
    }

    public String getEstadoUsuario() {
        return EstadoUsuario;
    }

    public void setEstadoUsuario(String EstadoUsuario) {
        this.EstadoUsuario = EstadoUsuario;
    }

    public int getPeso() {
        return Peso;
    }

    public void setPeso(int Peso) {
        this.Peso = Peso;
    }

    public int getTalla() {
        return Talla;
    }

    public void setTalla(int Talla) {
        this.Talla = Talla;
    }

    public double getAltura() {
        return Altura;
    }

    public void setAltura(double Altura) {
        this.Altura = Altura;
    }

    public double getIMC() {
        return IMC;
    }

    public void setIMC(double IMC) {
        this.IMC = IMC;
    }

    public String getGradoObesidad() {
        return GradoObesidad;
    }

    public void setGradoObesidad(String GradoObesidad) {
        this.GradoObesidad = GradoObesidad;
    }

    public String getObejtivos() {
        return Obejtivos;
    }

    public void setObejtivos(String Obejtivos) {
        this.Obejtivos = Obejtivos;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public int getCodDisciplina() {
        return CodDisciplina;
    }

    public void setCodDisciplina(int CodDisciplina) {
        this.CodDisciplina = CodDisciplina;
    }
 
 
 
}
