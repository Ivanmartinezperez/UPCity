/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;



import Auxiliares.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import mapa.*;
import restricciones.*;
import elementos.*;
import java.util.TreeMap;

/**
 *
 * @author ArclorenSarth
 */
public class MainArtemPersistencia {
    
   
    
    public static void main(String arg[]) throws Exception{
        
        //Creamos restricciones
        Restriccion_ubicacion res12;
        res12 = new Restriccion_ubicacion("0","0",1,2,3);
        Restriccion_ubicacion res21;
        res21 = new Restriccion_ubicacion("0","0",2,1,3);
        Restriccion_ubicacion res34;
        res34 = new Restriccion_ubicacion("0","0",3,4,3);
        Restriccion_ubicacion res43;
        res43 = new Restriccion_ubicacion("0","0",4,3,3);
        Restriccion_ubicacion res31;
        res31 = new Restriccion_ubicacion("0","0",3,1,2);
        Restriccion_ubicacion res13;
        res13 = new Restriccion_ubicacion("0","0",1,3,2);
        Restriccion_ubicacion res14;
        res14 = new Restriccion_ubicacion("0","0",1,4,4);
        Restriccion_ubicacion res41;
        res41 = new Restriccion_ubicacion("0","0",4,1,4);
        Restriccion_ubicacion res11;
        res11 = new Restriccion_ubicacion("0","0",1,1,3);
        
        testfunciones tt = new testfunciones();
        
        TreeMap<String,Restriccion> CjtRest;
        CjtRest = new TreeMap();
        CjtRest.put("res11", res11);
        CjtRest.put("res34", res34);
        CjtRest.put("res31", res31);
        tt.escriuBinari ("CjtRest",CjtRest);
        TreeMap<String,Restriccion> CjtRest2 = new TreeMap();
        CjtRest2 =(TreeMap<String,Restriccion>) tt.llegeixBinari("CjtRest");
        if(CjtRest2.containsKey("res11"))System.out.println("true\n");
        if(CjtRest2.containsKey("res34"))System.out.println("true\n");
        if(CjtRest2.containsKey("res31")) System.out.println("true\n");
        Restriccion_ubicacion u =(Restriccion_ubicacion) CjtRest2.get("res11");
        System.out.println("el id: " + u.getId() + "\n");
        System.out.println("el oid1: " + u.consultar_OID1()+ "\n");
        System.out.println("el oid2: " + u.consultar_OID2() + "\n");
        System.out.println("el dist: " + u.consultar_distancia() + "\n");
    }
}
