/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

/**
 *
 * @author ivanmartinez
 */
public class Viviendas extends Elemento {
    
    public int capacidad_maxima;
    public int Tamano_x;
    public int Tamano_y;
    public int Precio;
    
    public Viviendas(int OID){
        super(OID);
    }
    
    public Viviendas (int OID,int cap_max, int tam_x, int tam_y,int precio){
        super(OID);
        this.Tamano_x = tam_x;
        this.Tamano_y = tam_y;
        this.Precio = precio;
        this.capacidad_maxima = cap_max;
    }
    
    ////ModificdoraS////
    
    public void Setcap_max(int cap_max){
        this.capacidad_maxima = cap_max;
    }
    
    void setTamaño(int x,int y){
        this.Tamano_x=x;
        this.Tamano_y=y;
    }
    
    
    ///Consultoras/////
    
    public int Getcap_max(){
        return this.capacidad_maxima;
    }
    
     int getTamanoX(){
        return this.Tamano_x;
    }
    
    int getTamanoY(){
        return this.Tamano_y;
    }
}
