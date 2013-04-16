/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package barrio;


import Auxiliares.Pair;
import java.util.TreeMap;
import mapa.Plano;
import elementos.Cjt_Elementos;
//import restricciones.Restriccion;


/**
 *
 * @author elpueblo
 */
public class Barrio {
    private String Nombre;
    private int TipoBarrio;
    private Plano Mapa;
    private Cjt_Elementos CjtElem;
    private TreeMap<String,Integer> CjtRest;
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
    
    public void putRestriccion(String rest){
        CjtRest.put(rest,1);
    }
    
    public void putElemento(int oid, Pair val){
        
    }
    
    public void anadirGasto(int gasto){
        Gastado = Gastado + gasto;
    }
    
    public void modificarPlano(){
//        Hay que tener una o varias de estas, porque como el backtracking,
//        seguramente se hara en el CtrlDomBarrios, tendra que acceder al plano
//        mediante el barrio. Aunque ya veremos mas adelante...
    }
    
    
    
    public int getTipoBarrio(){
        return TipoBarrio;
    }
    
}
