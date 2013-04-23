/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package barrio;





/**
 *
 * @author elpueblo
 */
public class Barrio {
    private String Nombre;
    private int TipoBarrio;
    private int Presupuesto;
    private int Poblacion;
    private int Gastado;
    private int Viviendo;
    
  
    /////CREADORAS/////
    
    public Barrio(String nombre,int tipo){
        Nombre = nombre;
        TipoBarrio = tipo;
        
        
    }
    
    
    
    /////MODIFICADORAS/////
    
    public void setTipoBarrio(int t){
        TipoBarrio = t;
    }
    
    public void setPresupuesto(int pres){
        Presupuesto = pres;
    }
    
    public void setPoblacion(int pob){
        Poblacion = pob;
    }
    
    public void anadirGasto(int gasto){
        Gastado = Gastado + gasto;
    }
    
    public void anadirHabitantes(int hab){
        Viviendo = Viviendo + hab;
    }
    
    
    
    /////CONSULTORAS/////
    
    public String getNombreBarrio(){
        return Nombre;
    }
    
    public int getTipoBarrio(){
        return TipoBarrio;
    }
    
    public int getPresupuesto(){
        return Presupuesto;
    }
    
    public int getPoblacion(){
        return Poblacion;
    }
    
    public int getGastado(){
        return Gastado;
    }
    
    public int getViviendo(){
        return Viviendo;
    }
    
}
