/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package barrio;

import java.io.Serializable;





/**
 *
 * @author ArclorenSarth
 */
public class Barrio implements Serializable{
    private String Nombre;
    private int TipoBarrio;
    private int Presupuesto;
    private int Poblacion;
    private int Gastado;
    private int Viviendo;
    private int Capacidad_comercio;
    
    
  
    /////CREADORAS/////
    
    public Barrio(){}
    
    
    public Barrio(String nombre,int tipo){
        Nombre = nombre;
        TipoBarrio = tipo;
    }
      
    
    /////MODIFICADORAS/////
    
    public void setNombreBarrio(String n){
        Nombre = n;
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
    
    public void anadirHabitantes(int hab){
        Viviendo = Viviendo + hab;
    }
    
    public void anadirComercio(int C){
        Capacidad_comercio = Capacidad_comercio + C;
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
    
    public int getCapacidad_comercio(){
        return Capacidad_comercio;
    }
    
}
