/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa;

/**
 *
 * @author ivanmartinez
 */
public class Parcela {
    int cordenada_x;
    int cordenada_y;
    String Estado;
    
    Parcela(int x, int y, String estado){
        cordenada_x = x;
        cordenada_y = y;
        Estado = estado;
    }
    
    // si x o y son menores que 0, solo se modifica su estado y no es necesario
    //modificar su posicion.
    void setParcela(int x, int y, String estado){
        if(x >= 0) cordenada_x = x;
        if(y >= 0) cordenada_y = y;
        Estado = estado;
    }
    
    int getx(){
        return cordenada_x;
    }
    
    int gety() {
        return cordenada_y;
    }
    
    String getestado() {
        return Estado;
    }
    void getParcela(){
        
    }
}
  
