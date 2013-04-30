/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

/**
 *
 * @author Ivan Martinez Perez y Artem Cherkashin
 */
public class Comercio extends Elemento {
    private int TBarrio;
    private int capacidad_del_comercio;
    private int Tamano_x;
    private int Tamano_y;
    private int Precio;
    
    
    /////Cradoras////////
    public Comercio(int OID){
        super(OID);
    }
    
    public Comercio(int OID, int cap, int tam_x, int tam_y, int precio, 
                    int tbarr){
        super(OID);
        TBarrio = tbarr;
        Tamano_x = tam_x;
        Tamano_y = tam_y;
        Precio = precio;
        capacidad_del_comercio=cap;
        
    }
    /////////////////////
    
    ///Modificadoras////////////
    public void setCapacidad(int cap){
        capacidad_del_comercio=cap;
    }
    
    public void setTamaño(int x,int y){
        Tamano_x=x;
        Tamano_y=y;
    }
    
    public void setTBarrio(int bar){
        TBarrio = bar;
    }
    ///////////////////////////
    
    ////Consultoras/////
    public int getCapacidad(){
        return capacidad_del_comercio;
    }
    
    public int getPrecio(){
        return Precio;
    }
    
    public int getTamanoX(){
        return Tamano_x;
    }
    
    public int getTamanoY(){
        return Tamano_y;
    }
    
    public int getTBarrio(){
        return TBarrio;
    }
    
    //////////////////////////
    
}
