/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladors;

import elementos.*;
import java.util.*;

/**
 *
 * @author ivanmartinez
 */
public class CtrlDomElementos {
    
        private int OID;
        private HashMap<Integer,ArrayList<Elemento>> mapTipoElem;
        private TreeMap<String,Cjt_Elementos> mapCjtElem;
        private TreeMap<String,Elemento> mapElem;
        private static CtrlDomElementos INSTANCE = null;
        
        private CtrlDomElementos(){
            mapCjtElem = new TreeMap<>();
            mapElem = new TreeMap<>();
            mapTipoElem = new HashMap<>();
            OID=0;//Cada vez que se cree una instancia esto recibira el valor de la raiz
                  //del arbol de elementos +1, que sera el OID maximo del programa
        }
        
        private synchronized static void creaInstancia() {
            if (INSTANCE == null) {
                INSTANCE = new CtrlDomElementos();
            }
        }

        public static CtrlDomElementos getInstance() {
            if (INSTANCE == null) {
                creaInstancia();
            }
            return INSTANCE;
        }
        
        private boolean anadir_a_estructuras(Elemento e,int tipo){
            String nombre = e.getNom();
            if(!mapElem.containsKey(nombre)){
                //añadimos elemento a la estructura que contiene los elementos
                mapElem.put(nombre, e);
                //añadimos el elemento a la estructura que contiene los elementos 
                //clasificados por el tipo
                ArrayList<Elemento> aux = new ArrayList<>();
                aux.add(e);
                mapTipoElem.put((Integer) tipo, aux);
                
            }
            
            return true;
        }
        
        public boolean CrearElemento(String Nombre,String Des, int tipo){
            
                boolean ret=true;
            
                switch(tipo){
                    case 1 : Vivienda v = new Vivienda(OID);
                             v.setNom(Nombre);
                             v.setDescrpcio(Des);
                             anadir_a_estructuras(v,tipo);
                             break;
                    case 2 : Publico p = new Publico(OID);
                             p.setNom(Nombre);
                             p.setDescrpcio(Des);
                             anadir_a_estructuras(p,tipo);
                             break;
                    case 3 : Comercio c = new Comercio(OID);
                             c.setNom(Nombre);
                             c.setDescrpcio(Des);
                             anadir_a_estructuras(c,tipo);
                             break;
                    default: ret = false;
                }
                
                
                
                return ret;
        
        }
        
        

        
        
    
    
}
