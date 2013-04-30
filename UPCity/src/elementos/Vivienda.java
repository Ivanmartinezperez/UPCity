/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

/**
 *
 * @author Ivan Martinez Perez y Artem Cherkashin
 */
public class Vivienda extends Elemento {
    
    private int TBarrio;
    private int capacidad_maxima;
    private int Tamano_x;
    private int Tamano_y;
    private int Precio;
    
    public Vivienda(int OID){
        super(OID);
    }
    
    public Vivienda (int OID,int cap_max, int tam_x, int tam_y,int precio,
                     int tbarr){
        super(OID);
        Tamano_x = tam_x;
        Tamano_y = tam_y;
        Precio = precio;
        capacidad_maxima = cap_max;
        TBarrio = tbarr;
    }
    
    ////ModificdoraS////
    
    public void Setcap_max(int cap_max){
        capacidad_maxima = cap_max;
    }
    
    public void setTamaño(int x,int y){
        Tamano_x=x;
        Tamano_y=y;
    }
    
    public void setTBarrio(int bar){
        TBarrio = bar;
    }
    
    
    ///Consultoras/////
    
    public int Getcap_max(){
        return capacidad_maxima;
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
}
