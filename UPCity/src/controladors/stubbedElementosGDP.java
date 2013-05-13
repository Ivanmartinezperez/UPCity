/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladors;

import java.util.TreeMap;
import elementos.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author ArclorenSarth
 */
public class stubbedElementosGDP {
    
    private static stubbedElementosGDP INSTANCE = null;
    CtrlPersDisco PERSDisco;
   
    
    private stubbedElementosGDP(){
        PERSDisco = new CtrlPersDisco();
        PERSDisco.crearArchivo("Elementos");
    }
    
    private static void creaInstancia() {
        if (INSTANCE == null) {
            INSTANCE = new stubbedElementosGDP();
        }
    }

    public static stubbedElementosGDP getInstance() {
        if (INSTANCE == null) {
            creaInstancia();
        }
        return INSTANCE;
    }
    
    
    
    
    /**
     * Lectura de datos persistentes del disco, lee todas las instancias de 
     * elemento del disco y las pasa al TreeMap TablaElem que le llega como 
     * parametro.
     * @param TablaElem 
     */     
    public void leerElementos(ArrayList<Elemento> Elems,
                              ArrayList<Integer> Tipos,
                              ArrayList<Integer> TBarrios){
        
        ArrayList<String> elemPers = PERSDisco.leerArchivo("Elementos");
        String[] aux;
        int tipo = 0;
        for(int i=0; i<elemPers.size(); ++i){
            aux = elemPers.get(i).split("\t");
            Elems.add(crearElem(aux));
            Tipos.add(Integer.parseInt(aux[3]));
            TBarrios.add(Integer.parseInt(aux[4]));
        }
    }
    
    
    private Elemento crearElem(String[] elemStr){
        Elemento e = null;
        switch(elemStr[3]){
            case "1" : 
                Vivienda v = new Vivienda(Integer.parseInt(elemStr[0]),
                                          Integer.parseInt(elemStr[6]),
                                          Integer.parseInt(elemStr[7]),
                                          Integer.parseInt(elemStr[8]),
                                          Integer.parseInt(elemStr[5]),
                                          Integer.parseInt(elemStr[4]));
                v.setNom(elemStr[1]);
                v.setDescrpcio(elemStr[2]);
                e = v;
                break;
            case "2" : 
                Publico p = new Publico(Integer.parseInt(elemStr[0]),
                                        Integer.parseInt(elemStr[6]),
                                        Integer.parseInt(elemStr[7]),
                                        Integer.parseInt(elemStr[8]),
                                        Integer.parseInt(elemStr[9]),
                                        Integer.parseInt(elemStr[5]),
                                        Integer.parseInt(elemStr[4]));
                p.setNom(elemStr[1]);
                p.setDescrpcio(elemStr[2]);
                e = p;
                break;
            case "3" : 
                Comercio c = new Comercio(Integer.parseInt(elemStr[0]),
                                          Integer.parseInt(elemStr[6]),
                                          Integer.parseInt(elemStr[7]),
                                          Integer.parseInt(elemStr[8]),
                                          Integer.parseInt(elemStr[5]),
                                          Integer.parseInt(elemStr[4]));
                c.setNom(elemStr[1]);
                c.setDescrpcio(elemStr[2]);
                e = c;
                break;
                
            }
        return e;
    }
    
    
    private String transElemString(Elemento e){
        String line = String.valueOf(e.getId());
        line = line.concat("\t" + e.getNom());
        line = line.concat("\t" + e.getDescripcio());
        if(e instanceof Vivienda){
            Vivienda v = (Vivienda) e;
            line = line.concat("\t" + "1");
            line = line.concat("\t" + String.valueOf(v.getTBarrio()));
            line = line.concat("\t" + String.valueOf(v.getPrecio()));
            line = line.concat("\t" + String.valueOf(v.Getcap_max()));
            line = line.concat("\t" + String.valueOf(v.getTamanoX()));
            line = line.concat("\t" + String.valueOf(v.getTamanoY()));
        }
        else if(e instanceof Publico){
            Publico p = (Publico) e;
            line = line.concat("\t" + "2");
            line = line.concat("\t" + String.valueOf(p.getTBarrio()));
            line = line.concat("\t" + String.valueOf(p.getPrecio()));
            line = line.concat("\t" + String.valueOf(p.Gettipo()));
            line = line.concat("\t" + String.valueOf(p.Getcapacidad_serv()));
            line = line.concat("\t" + String.valueOf(p.getTamanoX()));
            line = line.concat("\t" + String.valueOf(p.getTamanoY()));
        }
        else {
            Comercio c = (Comercio) e;
            line = line.concat("\t" + "3");
            line = line.concat("\t" + String.valueOf(c.getTBarrio()));
            line = line.concat("\t" + String.valueOf(c.getPrecio()));
            line = line.concat("\t" + String.valueOf(c.getCapacidad()));
            line = line.concat("\t" + String.valueOf(c.getTamanoX()));
            line = line.concat("\t" + String.valueOf(c.getTamanoY()));
            
        }
        return line;
    }
    
    public void escribirElemento(Elemento e){
        ArrayList<String> elemPers = PERSDisco.leerArchivo("Elementos");
        elemPers.add(transElemString(e));
        PERSDisco.escribirArchivo("Elementos", elemPers);
    }
        
    
    
    public boolean existeElemEnBarrios(String Elem){
        System.out.println("Simulando lectura de disco...Buscando Elemento en"
                + "barrios\n"
                + "Error! Disco NOT FOUND!\n Don't be alarm, our technicals are"
                + " working on to solve this problem just before the third "
                + "installment\n");
        return false;
    }
    
    
    public void eliminarElemDisco(String Elem){
        ArrayList<String> elemPers = PERSDisco.leerArchivo("Elementos");
        String[] aux;
        boolean b=false;
        for(int i=0; i<elemPers.size() && b==false; ++i){
            aux = elemPers.get(i).split("\t");
            if(aux[1].equals(Elem)){
                b = true;
                elemPers.remove(i);
            }
        }
        PERSDisco.escribirArchivo("Elementos", elemPers);
    }
    
}
