/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladors;

import java.util.ArrayList;
import java.util.TreeMap;
import restricciones.*;



/**
 *
 * @author ArclorenSarth
 */
public class stubbedRestriccionesGDP {
    
    private static stubbedRestriccionesGDP INSTANCE = null;
    CtrlPersDisco PERSDisco;
    
    
    /**
     * Creadora por defecto. Se encarga de crear el archivo Restricciones.o 
     * en caso de su ausencia dentro de la carpeta Data.
     */
    private stubbedRestriccionesGDP(){
        PERSDisco = CtrlPersDisco.getInstance();
        PERSDisco.crearArchivo("Restricciones");
        PERSDisco.crearArchivo("RestriccionesSistema");
        PERSDisco.crearArchivo("RestriccionesGenerales");
        
    }
    
    private static void creaInstancia() {
        if (INSTANCE == null) {
            INSTANCE = new stubbedRestriccionesGDP();
        }
    }

    public static stubbedRestriccionesGDP getInstance() {
        if (INSTANCE == null) {
            creaInstancia();
        }
        return INSTANCE;
    }
    
    
    
    /**
     * Lectura de datos persistentes del disco, lee todas las instancias de 
     * restriccion del disco y las pasa aun ArrayList de restricciones.
     * @return Retorna un ArrayList de Restricciones que contiene todas las 
     * Restricciones leidas del disco.
     */
    public ArrayList<Restriccion> leerRestricciones(){
        ArrayList<String> restPers = PERSDisco.leerArchivo("Restricciones");
        ArrayList<Restriccion> Rests = new ArrayList();
        String[] aux;
        for(int i=0; i<restPers.size(); ++i){
            aux = restPers.get(i).split("\t");
            Rests.add(crearRest(aux));
        }
        return Rests;
    }
    
    
    /**
     * Escritura de una Restriccion a disco.
     * @param r Restriccion que se quiere guardar en disco.
     */
    public void escribirRestriccion(Restriccion r){
        ArrayList<String> restPers = PERSDisco.leerArchivo("Restricciones");
        restPers.add(transRestString(r));
        PERSDisco.escribirArchivo("Restricciones", restPers);
    }
    
    
    /**
     * Escritura que guarda la restriccion con el nombre id como restriccion
     * general que se aplicara a todos los futuros barrios nuevos.
     * @param id Nombre de la Restriccion a ser restriccion general.
     * @throws Exception Lanza Exception si la restriccion ya es una restriccion
     * general.
     */
    public void guardarRestGeneral(String id) throws Exception{
        ArrayList<String>restPers = PERSDisco.leerArchivo("RestriccionesGenerales");
        String aux;
        boolean b=false;
        for(int i=0; i<restPers.size() && b==false; ++i){
            aux = restPers.get(i);
            if(aux.equals(id)){
                b = true;
            }
        }
        if(b){
            throw new Exception("\nEsta restriccion ya es una Restriccion General\n");
        }
        restPers.add(id);
        PERSDisco.escribirArchivo("RestriccionesGenerales", restPers);
    }
    
    
    /**
     * Escritura que borra la restriccion con el nombre id como restriccion
     * general y ya no se aplicara a los futuros barrios nuevos.
     * @param id Nombre de la Restriccion a ser quitade de restricciones generales.
     * @throws Exception Lanza Exception si la restriccion no es una restriccion
     * general.
     */
    public void borrarRestGeneral(String id) throws Exception{
        ArrayList<String>restPers = PERSDisco.leerArchivo("RestriccionesGenerales");
        String aux;
        boolean b=false;
        for(int i=0; i<restPers.size() && b==false; ++i){
            aux = restPers.get(i);
            if(aux.equals(id)){
                b = true;
                restPers.remove(i);
            }
        }
        if(!b){
            throw new Exception("\nEsta restriccion no es una Restriccion General\n");
        }
        PERSDisco.escribirArchivo("RestriccionesGenerales", restPers);
    }
    
    
    /**
     * Lectura de Restricciones Generales actuales.
     * @return Retorna un ArrayList con los nombres de las Restricciones Generales.
     */
    public ArrayList<String> leerRestGenerales(){
        return PERSDisco.leerArchivo("RestriccionesGenerales");
    }
    
    
    /**
     * Funcion que comprueba si una Restriccion es utilizada en algun Barrio.
     * @param id Nombre de la Restriccion que se quiere comprobar la existencia 
     * en barrios.
     * @return Retorna un booleano: true si la Restriccion existe en algun 
     * conjunto de Restricciones de un Barrio o false si la Restriccion no 
     * existe en ningun conjunto de Restricciones de ningun Barrio.
     */
    public boolean existeRestEnBarrios(String id) throws Exception{
        String[] bars = PERSDisco.listarDirectorio("./Data/Barrios/");
        TreeMap<String,Restriccion> cjt;
        boolean b=false;
        String men = "\nLa restriccion se usa en los siguientes Barrios:\n";
        for(int i=0; i<bars.length; ++i){
            cjt = (TreeMap<String,Restriccion>) 
                   PERSDisco.leerObjeto(bars[i] + "/" , bars[i] + "-CjtRest");
            if(cjt.containsKey(id)){
                b = true;
                men = men.concat(bars[i] + "\n");
            }
        }
        men = men.concat("Ha de eliminar la restriccion de todos los barrios antes de "
                + "poder eliminarla completamente del sistema.");
        if(b){
            throw new Exception(men);
        }
        return false;
    }
    
    
    /**
     * Borradora de una Restriccion del disco.
     * @param id Nombre de la Restriccion que se quiere borrar del disco.
     */
    public void eliminarRestDisco(String id) throws Exception{
        ArrayList<String> restPers = PERSDisco.leerArchivo("RestriccionesSistema");
        String aux2;
        boolean b=false;
        for(int i=0; i<restPers.size() && b==false; ++i){
            aux2= restPers.get(i);
            if(aux2.equals(id)){
                b = true;
            }
        }
        if(b){
            throw new Exception("\nEsta restriccion pertenece al sistema.\n"
                    + "Las Restricciones del sistema no se pueden eliminar\n");
        }
        
        restPers = PERSDisco.leerArchivo("Restricciones");
        String[] aux;
        b=false;
        for(int i=0; i<restPers.size() && b==false; ++i){
            aux = restPers.get(i).split("\t");
            if(aux[0].equals(id)){
                b = true;
                restPers.remove(i);
            }
        }
        PERSDisco.escribirArchivo("Restricciones", restPers);
        
        restPers = PERSDisco.leerArchivo("RestriccionesGenerales");
        b=false;
        for(int i=0; i<restPers.size() && b==false; ++i){
            aux2 = restPers.get(i);
            if(aux2.equals(id)){
                b = true;
                restPers.remove(i);
            }
        }
        if(b)PERSDisco.escribirArchivo("RestriccionesGenerales", restPers);
    }
    
    
    /**
     * Funcion privada auxiliar que transforma una Restriccion en un String con
     * toda la informacion de la Restriccion.
     * @param r Restriccion que se quiere transformar en String.
     * @return Retorna el String resultante de la informacion.
     */
    private String transRestString(Restriccion r){
        String line = String.valueOf(r.getId());
        line = line.concat("\t" + r.getTypeSU());
        if(r instanceof Restriccion_ubicacion){
            Restriccion_ubicacion u = (Restriccion_ubicacion) r;
            line = line.concat("\t" + String.valueOf(u.consultar_OID1()));
            line = line.concat("\t" + String.valueOf(u.consultar_OID2()));
            line = line.concat("\t" + String.valueOf(u.consultar_distancia()));
        }
        else if(r instanceof Restriccion_economica){
            Restriccion_economica e = (Restriccion_economica) r;
            line = line.concat("\t" + String.valueOf(e.consultar_saldo()));
            line = line.concat("\t" + String.valueOf(e.consultar_saldo_ind(1)));
            line = line.concat("\t" + String.valueOf(e.consultar_saldo_ind(2)));
            line = line.concat("\t" + String.valueOf(e.consultar_saldo_ind(0)));
        }
        else {
            Restriccion_demografica d = (Restriccion_demografica) r;
            line = line.concat("\t" + String.valueOf(d.consultar_OID()));
            line = line.concat("\t" + String.valueOf(d.consultar_habitantes()));
        }
        return line;
    }
    
    
    /**
     * Funcion privada auxiliar que crea una Restriccion a partir del array de
     * Strings que se le pasa como parametro, el cual ha de contener toda la
     * informacion necesaria para crear la Restriccion.
     * @param restStr array de Strings que contiene la informacion de la 
     * Restriccion.
     * @return Retorna la Restriccion que se ha creado.
     */
    private Restriccion crearRest(String[] restStr){
        Restriccion Rest=null;
        switch(restStr[1]){
            case "ubicacion":   
                Restriccion_ubicacion u;
                u = new Restriccion_ubicacion(restStr[0],restStr[1],
                                              Integer.parseInt(restStr[2]),
                                              Integer.parseInt(restStr[3]),
                                              Integer.parseInt(restStr[4]));
                Rest = u;
                break;
            case "economica":   
                Restriccion_economica e;
                e = new Restriccion_economica(restStr[0],restStr[1],
                                              Integer.parseInt(restStr[5]),
                                              Integer.parseInt(restStr[3]),
                                              Integer.parseInt(restStr[4]));
                Rest = e;
                break;
            case "demografica": 
                Restriccion_demografica d;
                d = new Restriccion_demografica(restStr[0],restStr[1],
                                                Integer.parseInt(restStr[2]),
                                                Integer.parseInt(restStr[3]));
                Rest = d;
                break;
            
        }
        return Rest;
    }
    
}
