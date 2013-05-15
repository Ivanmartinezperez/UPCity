/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa;

import java.io.Serializable;
import java.util.TreeMap;
/**
 *
 * @author danielsans
 */
public class Parcela implements Serializable{
    int tamanyo;
    TreeMap<Integer, Integer> restriccionesP;
    int OID;
    
    /**
     * Creadora de Parcela, inicializa el treemap.
     */
    Parcela(){
        restriccionesP = new TreeMap<Integer, Integer>();
        OID = 0;
    }
    
    Parcela(Parcela p) {
        restriccionesP = new TreeMap(p.restriccionesP);
        OID = p.getoid();
    }
    
    /**
     * Creadora de una Parcela, con valores tam i ID
     * @param tam
     * @param ID 
     */
    public Parcela(int tam, int ID){
        tamanyo = tam;
        OID = ID;
        restriccionesP = new TreeMap<Integer, Integer>();
    }
    
    /**
     * Añade una Restriccion a esta parcela con ID. Si la Restriccion ya existe, 
     * le anade uno a la cantidad que havia antes.
     * @param id 
     */
    public void anadirRestriccion(int id) {
        int a = 1;
        if(restriccionesP.containsKey(id)) a += restriccionesP.get(id);
        restriccionesP.put(id, a);
    }
    /**
     * Quita una restriccion del arbol. Si hay mas de una, la decrementa.
     * PRE: tiene que existir un objeto ID en el treemap.
     * @param id 
     */
    public void quitarRestriccion(int id) {
        int a = restriccionesP.get(id);
        if(a == 1) restriccionesP.remove(id);
        else restriccionesP.put(id, a-1);
    }
    
    /**
     * Modifica una parcela, tanto su ID como su tamano
     * @param id
     * @param tam 
     */
    public void modificarPar(int id, int tam) {
        tamanyo = tam;
        OID = id;
    }
    
    /**
     * consultora de id
     * @return 
     */
    public int getoid() {
        return OID;
    }
    
    /**
     * Consultora de una Restriccion. Si es true, ese elemento no puede
     * ir en la parcela.
     * @param id
     * @return 
     */
    public boolean buscaRestriccion(int id){
        return restriccionesP.containsKey(id);
    }
}