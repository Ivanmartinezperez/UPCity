/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

/**
 *
 * @author ivanmartinez
 */
public class Vivienda extends Elemento {
    
    public int TBarrio;
    public int capacidad_maxima;
    public int Tamano_x;
    public int Tamano_y;
    public int Precio;
    
    public Vivienda(int OID){
        super(OID);
    }
    
    public Vivienda (int OID,int cap_max, int tam_x, int tam_y,int precio,
                     int tbarr){
        super(OID);
        this.Tamano_x = tam_x;
        this.Tamano_y = tam_y;
        this.Precio = precio;
        this.capacidad_maxima = cap_max;
        TBarrio = tbarr;
    }
    
    ////ModificdoraS////
    
    public void Setcap_max(int cap_max){
        this.capacidad_maxima = cap_max;
    }
    
    public void setTamaño(int x,int y){
        this.Tamano_x=x;
        this.Tamano_y=y;
    }
    
    public void setTBarrio(int bar){
        TBarrio = bar;
    }
    
    
    ///Consultoras/////
    
    public int Getcap_max(){
        return this.capacidad_maxima;
    }
    
    public int getPrecio(){
        return Precio;
    }
    
    public int getTamanoX(){
        return this.Tamano_x;
    }
    
    public int getTamanoY(){
        return this.Tamano_y;
    }
    
    public int getTBarrio(){
        return TBarrio;
    }
}
