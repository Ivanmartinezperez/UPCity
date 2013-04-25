/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladors;


import elementos.*;
import java.util.*;

/**
 *
 * @author ivanmartinez y ArclorenSarth
 */
public class CtrlDomElementos {
    
        private int OID;
        private HashMap<Integer,ArrayList<Elemento>> mapTipoElem0;
        private HashMap<Integer,ArrayList<Elemento>> mapTipoElem1;
        private HashMap<Integer,ArrayList<Elemento>> mapTipoElem2;
        private HashMap<Integer,ArrayList<Elemento>> mapTipoElem3;
        private TreeMap<String,Elemento> mapElem0;
        private TreeMap<String,Elemento> mapElem1;
        private TreeMap<String,Elemento> mapElem2;
        private TreeMap<String,Elemento> mapElem3;
        private stubbedElementosGDP GDPElem;
        private static CtrlDomElementos INSTANCE = null;
        
        /**
         * Creadora de la clase Controlador de elementos - DOMINIO
         * @return -
         */
        private CtrlDomElementos(){
            GDPElem = stubbedElementosGDP.getInstance();
            GDPElem.leerElementos(mapElem0,mapTipoElem0,mapElem1,mapTipoElem1,
                                  mapElem2,mapTipoElem2,mapElem3,mapTipoElem3);
            
            OID=0;//Cada vez que se cree una instancia esto recibira el valor 
                  //de la raiz del arbol de elementos +1, que sera el OID 
                  //maximo del programa
        }
        
        private static void creaInstancia() {
           
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
         * @param tipo Nos indica el tipo de elemento que es: 1-Vivienda 
         * 2-Publico 3-Comercio
         * @param TB Nos indica el tipo de barrio al que pertenece:
         * 0-Cualquier barrio, 0-Culquier barrio 1-Barrio bajo, 2-Barrio medio,
         * 3-Barrio alto 
         * @return Devuelve true si todo se ha realizado correctamente
         */
        
        private boolean anadir_a_estructuras(Elemento e,int tipo, int TB){
            String nombre = e.getNom();
            if(!mapElem0.containsKey(nombre) && !mapElem1.containsKey(nombre) &&
               !mapElem2.containsKey(nombre) && !mapElem3.containsKey(nombre)){
                
                ArrayList<Elemento> aux;
                //añadimos elemento a la estructura que contiene los elementos y
                //añadimos el elemento a la estructura que contiene los elementos 
                //clasificados por el tipo
                switch(TB){
                    case 0: mapElem0.put(nombre, e);
                            aux = mapTipoElem0.get((Integer)tipo);
                            aux.add(e);
                            mapTipoElem0.put((Integer) tipo, aux);
                            break;
                    case 1: mapElem1.put(nombre, e);
                            aux = mapTipoElem1.get((Integer)tipo);
                            aux.add(e);
                            mapTipoElem1.put((Integer) tipo, aux);
                            break;
                    case 2: mapElem2.put(nombre, e);
                            aux = mapTipoElem2.get((Integer)tipo);
                            aux.add(e);
                            mapTipoElem2.put((Integer) tipo, aux);
                            break;
                    case 3: mapElem3.put(nombre, e);
                            aux = mapTipoElem3.get((Integer)tipo);
                            aux.add(e);
                            mapTipoElem3.put((Integer) tipo, aux);
                            break;
                }
                return true;         
            }
            else return false;
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
                             GDPElem.escribirElemento(v);
                             break;
                    case 2 : Publico p = new Publico(OID);
                             p.setNom(Nombre);
                             p.setDescrpcio(Des);
                             p.setTBarrio(TB);
                             anadir_a_estructuras(p,tipo,TB);
                             GDPElem.escribirElemento(p);
                             break;
                    case 3 : Comercio c = new Comercio(OID);
                             c.setNom(Nombre);
                             c.setDescrpcio(Des);
                             c.setTBarrio(TB);
                             anadir_a_estructuras(c,tipo,TB);
                             GDPElem.escribirElemento(c);
                             break;
                    default: ret = false;
                }
                
                
                
                return ret;
        
        }
        
        public Elemento getElemento(String Elem){
            Elemento e;
            if((e=mapElem0.get(Elem))!=null){}
            else if((e=mapElem1.get(Elem))!=null){}
            else if((e=mapElem2.get(Elem))!=null){}
            else if((e=mapElem3.get(Elem))!=null){}
            else e=null;
            return e;
        }
        
        
        /**
         * Consulta en que tipo de Barrio puede ir el elemento e 
         * @param e Elemente del cual queremos consultar el tipo de barrio
         * @return TBarrio del elemento
         */
        public int getTBElemento(Elemento e){
            int tipoel;
            if(e instanceof Vivienda){
                Vivienda e2 = (Vivienda) e;
                tipoel = e2.getTBarrio();
            }
            else if(e instanceof Publico){
                Publico e2 = (Publico) e;
                tipoel = e2.getTBarrio();
            }
            else {
                Comercio e2 = (Comercio) e;
                tipoel = e2.getTBarrio();
            }
            return tipoel;
        }
        
        /**
         * Listado de los elementos del sistema
         * @return Array de todos los elementos del sistema
         */
         public ArrayList<Elemento> ListaElementos(){
             
            ArrayList<Elemento> aux = new ArrayList();
            aux.addAll((ArrayList<Elemento>) mapElem0.values());
            aux.addAll((ArrayList<Elemento>) mapElem1.values());
            aux.addAll((ArrayList<Elemento>) mapElem2.values());
            aux.addAll((ArrayList<Elemento>) mapElem3.values());
            return aux;
            
         }
         
         
         /**
          * Listado de nombres de los elementos del sistema
          * @return Devuelve un set con los nombres de los elementos del sistema 
          */
         public Set<String> ListaNombreElementos(){
             
            Set<String> aux = new HashSet();
            if(!mapElem0.isEmpty())
                aux.addAll(mapElem0.keySet());
            if(!mapElem1.isEmpty())
                aux.addAll(mapElem1.keySet());
            if(!mapElem2.isEmpty())
                aux.addAll(mapElem2.keySet());
            if(!mapElem3.isEmpty())
                aux.addAll(mapElem3.keySet());
            
            return aux;
         }

}
