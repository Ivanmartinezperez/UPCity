/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa;

import java.util.TreeMap;
/**
 *
 * @author danielsans
 */
public class Parcela {
    int tamanyo;
    TreeMap<Integer, Integer> restriccionesP;
    int OID;
    
    Parcela(){
    }
    
    Parcela(int tam, int ID){
        tamanyo = tam;
        OID = ID;
        restriccionesP = new TreeMap<Integer, Integer>();
    }
    

    void anadirRestriccion(int id) {
        restriccionesP.put(id, id);
    }
    
    void modificarPar(int id, int tam) {
        tamanyo = tam;
        OID = id;
    }
    
    int getoid() {
        return OID;
    }
    
    boolean buscaRestriccion(int id){
        return restriccionesP.containsKey(id);
    }
}