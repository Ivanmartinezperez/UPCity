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
    
  
            
    public Barrio(String nombre,int tipo){
        Nombre = nombre;
        TipoBarrio = tipo;
        
        
    }
    
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
    
    public int getTipoBarrio(){
        return TipoBarrio;
    }
    
}
