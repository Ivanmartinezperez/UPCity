/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

/**
 *
 * @author ivanmartinez
 */
public abstract class Elementos {
    public String Nombre;
    public int Tamano_x;
    public int Tamano_y;
    public int Precio;
    public String Descripcion;
    public  int OID;
    
    
    ////////CREADORAS///////////////////
    abstract public Elementos();
    
    /*void Elementos(String nombre,int x, int y, int precio, String Des,int OID){
        this.Nombre=nombre;
        this.Tamano_x=x;
        this.Tamano_y=y;
        this.Precio=precio;
        this.Descripcion=Des;
        this.OID=OID;
    }*/
    //////////////////////////////////////
    
    ////////MODIFICADORAS////////////////
    
    /*Funciones para gestion de tamaños*/
    void setTamaño(int x,int y){
        this.Tamano_x=x;
        this.Tamano_y=y;
    }
    
    int getTamanoX(){
        return this.Tamano_x;
    }
    
    int getTamanoY(){
        return this.Tamano_y;
    }
    /*-------------------------------------*/
    
   /*Funciones para gestion de precios*/
   void setPrecio(int precio){
        this.Precio=precio;
   }
   
   int getPrecio(){
       return this.Precio;
   }
   /*----------------------------------------*/
   
   /*Funciones para gestion de Descripcion*/
   void setDescripcion(String Des){
       this.Descripcion=Des;
   }
   
   String getDescripcion(){
       return this.Descripcion;
   }
   /*----------------------------------------*/
   
   /* Funciones para gestion de OID*/
   int getOID(){
       return this.OID;
   }
   /*---------------------------------*/
   

    
}
