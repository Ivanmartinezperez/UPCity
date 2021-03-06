/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladors;

import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import restricciones.*;

/**
 *
 * @author ron y ArclorenSarth
 */
public class CtrlDomRestricciones {
    private TreeMap<String, Restriccion_ubicacion> restubicacion;
    private TreeMap<String, Restriccion_demografica> restdemografica;
    private TreeMap<String, Restriccion_economica> resteconomica;
    private CtrlDomElementos DOMElem;
    private stubbedRestriccionesGDP RestGDP;
    private static CtrlDomRestricciones INSTANCE=null;
    private static boolean init=false;
    
    
    /**
     * Creadora de la clase controlador de dominio de restricciones
     * @param ubicacion estructura que contiene las restricciones de ubicacion
     * @param demografica estructura que contiene las restricciones demograficas
     */
    private CtrlDomRestricciones(){
        RestGDP = stubbedRestriccionesGDP.getInstance();
        restubicacion = new TreeMap();
        restdemografica = new TreeMap();
        resteconomica = new TreeMap();
        ArrayList<Restriccion> restPers;
        restPers = RestGDP.leerRestricciones();
        for(int i=0; i<restPers.size(); ++i){
            Restriccion r = restPers.get(i);
            switch(r.getTypeSU()){
                case "ubicacion":
                    restubicacion.put(r.getId(),(Restriccion_ubicacion)r);
                    break;
                case "economica":
                    resteconomica.put(r.getId(),(Restriccion_economica)r);
                    break;
                case "demografica":
                    restdemografica.put(r.getId(),(Restriccion_demografica)r);
                    break;
            }
        }
    }
    
    
    private static void creaInstancia() {
        if (INSTANCE == null) {
            INSTANCE = new CtrlDomRestricciones();
        }
    }

    public static CtrlDomRestricciones getInstance() {
        if (INSTANCE == null) {
            creaInstancia();
        }
        return INSTANCE;
    }
    
    public void inicializar(){
        if(!init){
            init = true;
            DOMElem = CtrlDomElementos.getInstance();
            DOMElem.inicializar();
        }
    }
    
    
    /**
     * Encargado de crear una restriccion e ingresarla en la estructura deseada
     * @param id id de la nueva restriccion
     * @param tipo tipo de restriccion
     * @param nombre1 se utiliza en el caso de crear restriccion de ubicacion y 
     * restriccion demografica. Es el nombre del primer elemento en caso de 
     * ubicacion y es el nombre del elemento a restringir en caso demografica
     * @param nombre2 se utiliza solo en el caso de crear restriccion de ubicacion.
     * Es el nombre del segundo elemento
     * @param aux1 en caso ubicacion es la distancia, en caso demografica es 
     * habitantes, y en caso economica es cantidad de dinero para comercios
     * @param aux2 se utiliza solo en caso de restriccion economica. Es la 
     * cantidad de dinero que se utliza en viviendas 
     * @param aux3 se utiliza solo en caso de restriccion economica. Es la 
     * cantidad de dinero que se utliza en servicios publicos
     * @return retorna booleano si se ha hecho la creacion e insercion 
     * correctamente
     */
    public boolean CrearRestriccion(String id, String tipo, String nombre1, 
                                    String nombre2, int aux1, int aux2, int aux3) throws Exception{
        
        boolean ret = true;
        if(restubicacion.containsKey(id) || resteconomica.containsKey(id) ||
           restdemografica.containsKey(id)){ 
            throw new Exception("\nYa existe una Restriccion con este nombre\n");
        }
        Integer OID1 = DOMElem.getOID(nombre1);
        Integer OID2 = DOMElem.getOID(nombre2); 
        switch(tipo){
            case "ubicacion":   
                if(OID1==null){
                    throw new Exception("\nEl primer elemento de la restriccion"
                            + " de ubicacion no existe.\n");
                }
                if(OID2==null){
                    throw new Exception("\nEl segundo elemento de la restriccion"
                            + " de ubicacion no existe.\n");
                }
                if(aux1<=0){
                    throw new Exception("\nLa distancia de la restriccion de "
                            + "ubicacion ha de ser mayor que 0.\n");
                }
                Restriccion_ubicacion u = new Restriccion_ubicacion(id, 
                                              tipo,OID1, OID2, aux1);
                restubicacion.put(id, u);
                RestGDP.escribirRestriccion(u);
                break;
            
            case "economica":   
                if(aux1<0){
                    throw new Exception("\nEl presupuesto en comercios de la "
                            + "restriccion economica ha de ser mayor o igual a 0.\n");
                }
                if(aux2<0){
                    throw new Exception("\nEl presupuesto en viviendas de la "
                            + "restriccion economica ha de ser mayor o igual a 0.\n");
                } 
                if(aux3<0){
                    throw new Exception("\nEl presupuesto en servicios publicos de la "
                            + "restriccion economica ha de ser mayor o igual a 0.\n");
                }
                Restriccion_economica e = new Restriccion_economica(id, 
                                              tipo,aux1, aux2, aux3);
                resteconomica.put(id, e);
                RestGDP.escribirRestriccion(e);
                
                
                break;
            
            case "demografica": 
                if(OID1==null){
                    throw new Exception("\nEl elemento de la restriccion"
                            + " demografica no existe.\n");
                }
                if(aux1<=0){
                    throw new Exception("\nLa poblacion minima de la restriccion "
                            + "demografica ha de ser mayor 0.\n");
                }   
                Restriccion_demografica d = new Restriccion_demografica(id, 
                                            tipo, OID1, aux1);
                restdemografica.put(id, d);
                RestGDP.escribirRestriccion(d);
                RestGDP.guardarRestGeneral(id);
                break;
            
            default: ret = false;
        }
        return ret;
    }
       
    
    /**
     * Añade una nueva Restriccion General, que se aplicara en los futuros 
     * barrios nuevos.
     * @param id Nombre de la Restriccion que se convierte en general.
     * @throws Exception Lanza Exception si la retriccion no existe.
     */
    public void anadirRestGeneral(String id) throws Exception{
        if(!restubicacion.containsKey(id) && !resteconomica.containsKey(id) &&
           !restdemografica.containsKey(id)){
            throw new Exception("\nLa restriccion no existe\n");
        }
        RestGDP.guardarRestGeneral(id);
    }
    
    
    /**
     * Quita una Restriccion General, que ya no se aplicara en los futuros 
     * barrios nuevos.
     * @param id Nombre de la Restriccion que se quita de las restricciones 
     * generales.
     * @throws Exception Lanza Exception si la retriccion no existe.
     */
    public void quitarRestGeneral(String id) throws Exception{
        if(!restubicacion.containsKey(id) && !resteconomica.containsKey(id) &&
           !restdemografica.containsKey(id)){
            throw new Exception("\nLa restriccion no existe\n");
        }
        RestGDP.borrarRestGeneral(id);
    }
    
    
    /**
     * Lista las Restricciones Generales actuales.
     * @return Retorna un ArrayList con los nombres de las restricciones 
     * generales que hay actualmente.
     */
    public ArrayList<String> listarRestGenerales(){
        return RestGDP.leerRestGenerales();
    }
    
    
    /**
     * Encargado de eliminar una restriccion de la estructura
     * @param id id de la restriccion que hay que eliminar
     * @param tipo tipo de la restriccion que hay que eliminar
     * @return retorna booleano si se ha hecho la eliminacion correctamente
     */
    public boolean Eliminar_Restriccion(String id) throws Exception{
        boolean ret = false;
        if(restubicacion.containsKey(id)){
            if(!RestGDP.existeRestEnBarrios(id)){
                RestGDP.eliminarRestDisco(id);
                restubicacion.remove(id);
                ret = true;
            }
            
        }
        else if(resteconomica.containsKey(id)){
            if(!RestGDP.existeRestEnBarrios(id)){
                RestGDP.eliminarRestDisco(id);
                resteconomica.remove(id);
                ret = true;
            }
            
        }
        else if(restdemografica.containsKey(id)) {
            if(!RestGDP.existeRestEnBarrios(id)){
                RestGDP.eliminarRestDisco(id);
                restdemografica.remove(id);
                ret = true;
            }
            
        }
        else 
            throw new Exception("\nLa restriccion no existe\n");
        return ret;
        
    }
    
    
    /**
     * Funcion que busca la Restriccion con el nombre Rest entre las 
     * Restricciones dentro del sistema, si esta la retorna y si no esta 
     * retorna null.
     * @param Rest Nombre de la Restriccion deseada.
     * @return Retorna la Restriccion buscada si la ha encontrado, o sino 
     * retorna null.
     */
    public Restriccion getRestriccion(String Rest){
        Restriccion r = null;
        if(restubicacion.containsKey(Rest))
            r = restubicacion.get(Rest);
        else if(restdemografica.containsKey(Rest))
            r = restdemografica.get(Rest);
        else if(resteconomica.containsKey(Rest))
            r = resteconomica.get(Rest);
        return r;
    }
    
    
    /**
     * Funcion que comprueba si existe alguna Restriccion de ubicacion o 
     * demografica que se aplique sobre el Elemento con identificador ID.
     * @param ID Identificador del Elemento del cual comprobamos la existencia
     * de Restricciones.
     * @return Retorna si existe alguna Restriccion que se aplique al Elemento
     * con el identificador ID.
     */
    public boolean existeRestElem(Integer ID) throws Exception{
        boolean ret = false;
        ArrayList<Restriccion> Rest = new ArrayList();
        Rest.addAll(restubicacion.values());
        Rest.addAll(restdemografica.values());
        boolean b = false;
        String men = "\nExisten las siguientes restricciones "
                + "sobre el elemento:";
        for(int i = 0; i < Rest.size(); ++i){
            Restriccion r;
            r = Rest.get(i);
            if(r instanceof Restriccion_ubicacion){
                Restriccion_ubicacion r2 = (Restriccion_ubicacion) r;
                if(ID == r2.consultar_OID1() || ID == r2.consultar_OID2()){
                    b = true;
                    men = men.concat("\n" + r2.getId());
                }
            }
            else if(r instanceof Restriccion_demografica){
                Restriccion_demografica r2 = (Restriccion_demografica) r;
                if(ID == r2.consultar_OID()){
                    b = true;
                    men = men.concat("\n" + r2.getId());
                }
            }
        }
        men = men.concat("\nHa de eliminar las restricciones sobre el elemento "
                + "antes de poder eliminar el elemento completamente del sistema.");
        if(b)
            throw new Exception(men);
        return false;
    }
    
    
    /**
     * Array de instancias Restricciones del sistema.
     * @return Devuelve un Array de Restricciones del sistema.
     */
    private ArrayList<Restriccion> arrayRest(){
             
            ArrayList<Restriccion> aux = new ArrayList();
            aux.addAll(restubicacion.values());
            aux.addAll(resteconomica.values());
            aux.addAll(restdemografica.values());
            return aux;
            
         }
    
    
    /**
     * Array de instancias de un tipo determinado de Restricciones del sistema
     * @param tipo El nombre del tipo de Restricciones que se desea.
     * @return Devuelve un Array de Restricciones del tipo deseado.
     */
    private ArrayList<Restriccion> arrayRestTipo(String tipo){
             
            ArrayList<Restriccion> aux = new ArrayList();
            
            switch(tipo){
            case "ubicacion":
                aux.addAll(restubicacion.values());
                break;
            case "economica":
            aux.addAll(resteconomica.values());
                break;
            case "demografica":
                aux.addAll(restdemografica.values());
                break;
            }
            return aux;
            
    }
    
    
    /**
     * Funcion que lista un tipo de Restricciones que tiene el sistema.
     * @param tipo Tipo de Restricciones que se quiere listar.
     * @return Retorna un matriz de Strings que contiene los parametros de las
     * Restricciones deseadas.
     */
    public String[][] listarRestTipo(String tipo){
         ArrayList<Restriccion> rest = arrayRestTipo(tipo);
         String[][] mat = null;
         if(!rest.isEmpty()) mat = new String[rest.size()][5];
         Restriccion_ubicacion u;
         Restriccion_economica e;
         Restriccion_demografica d;
         
         for(int i=0; i<rest.size(); ++i){
             switch(tipo){
                 case "ubicacion":
                     u = (Restriccion_ubicacion) rest.get(i);
                     mat[i][0] = u.getId();
                     mat[i][1] = String.valueOf(DOMElem.NombreElemento(u.consultar_OID1()));
                     mat[i][2] = String.valueOf(DOMElem.NombreElemento(u.consultar_OID2()));
                     mat[i][3] = String.valueOf(u.consultar_distancia());
                     mat[i][4] = "-1";
                     break;

                 case "economica":
                     e = (Restriccion_economica) rest.get(i);
                     mat[i][0] = e.getId();
                     mat[i][1] = String.valueOf(e.consultar_saldo());
                     mat[i][2] = String.valueOf(e.consultar_saldo_ind(1));
                     mat[i][3] = String.valueOf(e.consultar_saldo_ind(2));
                     mat[i][4] = String.valueOf(e.consultar_saldo_ind(0));
                     break;

                 case "demografica":
                     d = (Restriccion_demografica) rest.get(i);
                     mat[i][0] = d.getId();
                     mat[i][1] = String.valueOf(DOMElem.NombreElemento(d.consultar_OID()));
                     mat[i][2] = String.valueOf(d.consultar_habitantes());
                     mat[i][3] = "-1";
                     mat[i][4] = "-1";
                     break;
             }
         }
         return mat;
    }
    
    
    public String[] restParams(String Rest){
        String[] par = new String[5];
        if(restubicacion.containsKey(Rest)){
             Restriccion_ubicacion r = restubicacion.get(Rest);
             par[0] = "u";
             par[1] = String.valueOf((int)r.consultar_OID1());
             par[2] = String.valueOf((int)r.consultar_OID2());
             par[3] = String.valueOf(r.consultar_distancia());
             par[4] = "none";
        }
        else if (restdemografica.containsKey(Rest)){
             Restriccion_demografica r = restdemografica.get(Rest);
             par[0] = "d";
             par[1] = String.valueOf((int)r.consultar_OID());
             par[2] = String.valueOf(r.consultar_habitantes());
             par[3] = "none";
             par[4] = "none";
        }
        else{ 
             Restriccion_economica r = resteconomica.get(Rest);
             par[0] = "e";
             par[1] = String.valueOf(r.consultar_saldo());
             par[2] = String.valueOf(r.consultar_saldo_ind(1));
             par[3] = String.valueOf(r.consultar_saldo_ind(2));
             par[4] = String.valueOf(r.consultar_saldo_ind(0));
        }
        return par;   
    }
    
    
     /**
      * Listado de nombres de las restricciones del sistema.
      * @return Devuelve un set con los nombres de las restricciones del 
      * sistema. 
      */
     public Set<String> ListaNombreRestricciones(){

            Set<String> aux = new HashSet();
            if(!restubicacion.isEmpty())
                aux.addAll(restubicacion.keySet());
            if(!resteconomica.isEmpty())
                aux.addAll(resteconomica.keySet());
            if(!restdemografica.isEmpty())
                aux.addAll(restdemografica.keySet());

            return aux;
         }


     /**
      * Listado de nombres de un tipo determinado de Restricciones del sistema.
      * @param tipo El nombre del tipo de Restricciones que se desea.
      * @return Retorna un set de Restricciones de un determinado tipo.
      */
     public Set<String> ListaNombreRestriccionesTipo(String tipo){

            Set<String> aux = new HashSet();
            switch(tipo){
                    case "ubicacion":
                        if(!restubicacion.isEmpty())
                            aux.addAll(restubicacion.keySet());
                        break;
                    case "economica":
                        if(!resteconomica.isEmpty())
                            aux.addAll(resteconomica.keySet());
                        break;
                    case "demografica":
                        if(!restdemografica.isEmpty())
                            aux.addAll(restdemografica.keySet());
                        break;
            }

            return aux;
         }
         
    
    
    
}

