/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladors;

import Auxiliares.Pair;
import elementos.*;
import java.util.*;

/**
 *
 * @author ivanmartinez
 */
public class CtrlDomElementos {
    
        private int OID;
        private TreeMap<String,Cjt_Elementos> mapCjtElem;
        private HashMap<Integer,ArrayList<Elemento>> mapTipoElem1;
        private HashMap<Integer,ArrayList<Elemento>> mapTipoElem2;
        private HashMap<Integer,ArrayList<Elemento>> mapTipoElem3;
        private TreeMap<String,Elemento> mapElem1;
        private TreeMap<String,Elemento> mapElem2;
        private TreeMap<String,Elemento> mapElem3;
        private static CtrlDomElementos INSTANCE = null;
        
        /**
         * Creadora de la clase Controlador de elementos - DOMINIO
         * @param -
         * @return -
         */
        private CtrlDomElementos(){
            mapCjtElem = new TreeMap<>();
            mapElem1 = new TreeMap<>();
            mapElem2 = new TreeMap<>();
            mapElem3 = new TreeMap<>();
            mapTipoElem1 = new HashMap<>();
            mapTipoElem2 = new HashMap<>();
            mapTipoElem3 = new HashMap<>();
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
        
        /**
         * Encargado de mantener la consistencia de las estructuras de datos
         * @param e Elemento que se añade a las esructuras pertinentes
         * @param tipo Nos indica el tipo de elemento que es: 1-Vivienda 2-Publico 3-Comercio
         * @return Devuelve true si todo se ha realizado correctamente
         */
        
        private boolean anadir_a_estructuras(Elemento e,int tipo, int TB){
            String nombre = e.getNom();
            if(!mapElem1.containsKey(nombre) && !mapElem2.containsKey(nombre) 
                && !mapElem3.containsKey(nombre)){
                ArrayList<Elemento> aux = new ArrayList<>();
                //añadimos elemento a la estructura que contiene los elementos y
                //añadimos el elemento a la estructura que contiene los elementos 
                //clasificados por el tipo
                switch(TB){
                    case 1: mapElem1.put(nombre, e);
                            aux.add(e);
                            mapTipoElem1.put((Integer) tipo, aux);
                            break;
                    case 2: mapElem2.put(nombre, e);
                            aux.add(e);
                            mapTipoElem2.put((Integer) tipo, aux);
                            break;
                    case 3: mapElem3.put(nombre, e);
                            aux.add(e);
                            mapTipoElem3.put((Integer) tipo, aux);
                            break;
                }
                
                    
            }
            
            return true;
        }
        
        /**
         * Encargada de crear un elemento y añadirlo a las esucturas de datos
         * @param Nombre Nombre del elemento
         * @param Des Descripcion del elemento
         * @param tipo Tipo de elemento: Vivienda,publico,comercio
         * @return Devuelve true en caso de que todo se realize correctamente 
         */
        
        public boolean CrearElemento(String Nombre,String Des, int tipo, int TB){
            
            System.out.println("Entra");
                boolean ret=true;
            
                switch(tipo){
                    case 1 : Vivienda v = new Vivienda(OID);
                             v.setNom(Nombre);
                             v.setDescrpcio(Des);
                             v.setTBarrio(TB);
                             anadir_a_estructuras(v,tipo,TB);
                             break;
                    case 2 : Publico p = new Publico(OID);
                             p.setNom(Nombre);
                             p.setDescrpcio(Des);
                             p.setTBarrio(TB);
                             anadir_a_estructuras(p,tipo,TB);
                             break;
                    case 3 : Comercio c = new Comercio(OID);
                             c.setNom(Nombre);
                             c.setDescrpcio(Des);
                             c.setTBarrio(TB);
                             anadir_a_estructuras(c,tipo,TB);
                             break;
                    default: ret = false;
                }
                
                
                
                return ret;
        
        }
        
        /**
         * Crea un conjunto vacio y lo añade a las estructuras
         * @param Nombre Nombre del conjunto a crear
         * @return Devuelve true si todo se ha realizado correctamente
         */
        public boolean CrearConjunto(String Nombre){
            
            Cjt_Elementos cjt = new Cjt_Elementos();
            mapCjtElem.put(Nombre, cjt);
            return true;
            
        }
        
        /**
         * Añade la cantidad de elemento especificada al conjunto especificado
         * @param Nombre
         * @param e
         * @param cantidad
         * @return Devuelve true en caso de que todo se reaize correctamente
         */
        
        public boolean Anadir_elemento_al_conjunto(String Nombre,Elemento e, Integer cantidad){
            
            if(mapElem.containsKey(e.getNom()) && mapCjtElem.containsKey(Nombre)){
                Pair p = new Pair(cantidad,e);
                mapCjtElem.get(Nombre).insertar_elementos(e.getId(), p);
                return true;
            }
            return false;
        }
        
        
        
        /**
         * Listado de los elementos del sistema
         * @return Array de todos los elementos del sistema
         */
         public ArrayList<Elemento> ListaElementos(){
             
            ArrayList<Elemento> aux;
            aux = (ArrayList<Elemento>) mapElem.values();
            return aux;
            
         }
         
         
         /**
          * Listado de nombres de los elementos del sistema
          * @return Devuelve un set con los nombres de los elementos del sistema 
          */
         public Set<String> ListaNombreElementos(){
             
            Set<String> aux = new HashSet();
            if(!mapElem.isEmpty()){
                aux.addAll(mapElem.keySet());
                return aux;
                
            }
            return null;
         }
         
         
        
        

        
        
    
    
}
