/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

/**
 *
 * @author Ivan Martinez Perez y Artem Cherkashin
 */
public class Publico extends Elemento {
    /* Este parametro puede tomar los valores:
     *          0-General: Parques, plazas, polideportivos...
     *          1-Servicios de seguridad y emergencias: Policia, bomberos...
     *          2-Servicios sanitarios: hospitales, centros de atencion primaria...
     *          3- Servicios administrativos: Ayuntamiento, seguridad social...
     */
    private int TBarrio;
    private int tipo_servicio;
    private int Tamano_x;
    private int Tamano_y;
    private int Precio;
    
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
        Tamano_x = tam_x;
        Tamano_y = tam_y;
        Precio = precio;
        tipo_servicio = tipo_ser;
        capacidad_servicio_poblacion = cap_serv_pob;
    }
    
    ///////Modificadoras////////////
    public void Settipo(int tipo){
        tipo_servicio = tipo;
    }
    
    public void Setcapacidad_serv(int cap){
        capacidad_servicio_poblacion = cap;
    }
    
    public void setTamaño(int x,int y){
        Tamano_x=x;
        Tamano_y=y;
    }
     
    public void setTBarrio(int bar){
        TBarrio = bar;
    }
    
    
    //////Consultoras///////////
    public int Gettipo(){
        return tipo_servicio;
    }
    
    public int Getcapacidad_serv(){
        return capacidad_servicio_poblacion;
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
