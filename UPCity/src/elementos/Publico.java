/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

/**
 *
 * @author ivanmartinez
 */
public class Publico extends Elemento {
    /* Este parametro puede tomar los valores:
     *          0-General: Parques, plazas, polideportivos...
     *          1-Servicios de seguridad y emergencias: Policia, bomberos...
     *          2-Servicios sanitarios: hospitales, centros de atencion primaria...
     *          3- Servicios administrativos: Ayuntamiento, seguridad social...
     */
    private int TBarrio;
    public int tipo_servicio;
    public int Tamano_x;
    public int Tamano_y;
    public int Precio;
    
    /* Indica a cuanta población puede ofrecer sus servicios*/
    public int capacidad_servicio_poblacion;
    
    ///Constructoras////////
    /* Por defecto*/
    public Publico(int OID){ 
        super(OID);
    }
    
    public Publico(int OID,int tipo_ser,int cap_serv_pob, int tam_x, int tam_y, 
                   int precio, int tbarr){
        super(OID);
        TBarrio = tbarr;
        this.Tamano_x = tam_x;
        this.Tamano_y = tam_y;
        this.Precio = precio;
        this.tipo_servicio = tipo_ser;
        this.capacidad_servicio_poblacion = cap_serv_pob;
    }
    
    ///////Modificadoras////////////
    public void Settipo(int tipo){
        this.tipo_servicio = tipo;
    }
    
    public void Setcapacidad_serv(int cap){
        this.capacidad_servicio_poblacion = cap;
    }
    
     void setTamaño(int x,int y){
        this.Tamano_x=x;
        this.Tamano_y=y;
    }
    
    
    //////Consultoras///////////
    public int Gettipo(){
        return this.tipo_servicio;
    }
    
    public int Getcapacidad_serv(){
        return this.capacidad_servicio_poblacion;
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
