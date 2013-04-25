/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import Auxiliares.Pair;
import Pruebas.testfunciones;
import elementos.*;
import java.util.ArrayList;
import java.util.HashMap;
import mapa.*;
import restricciones.*;
import restricciones.Restriccion;

/**
 *
 * @author ivanmartinez
 */
public class MainIvan {
    
    public static void main(String arg[]) throws Exception{
        
        //Crea 4 elementos del 0 al 4
        ArrayList<Integer> elementos = new ArrayList<>();
        for(int i=1;i<=4;++i){
            elementos.add(i);
        }
        
        System.out.println("Printo mi elementos\n");
        for(int i=0;i<4;++i){
            System.out.println(elementos.get(i)+" ");
        }
        System.out.println("\n");
        
        System.out.println("Printo su vector de ultima posiciones visitadas\n");
        //Crea el vector de ultimas visitas, para controlar los valores del dominio(pos en el mapa) que toman los elementos
        Pair[] lastVisited = new Pair[5];
        for(int i=1;i<=4;++i){
            Pair p = new Pair(0,0);
            lastVisited[i]=p;
        }
        
        for(int i=1;i<=4;++i){
            System.out.println(lastVisited[i].getFirst()+""+lastVisited[i].getSecond()+" ");
        }
        System.out.println("\n");
        
        
        //creamos las estrcuturas para las restricciones
        HashMap<Integer,ArrayList<Restriccion_ubicacion>> res = new HashMap<>();
        
        ArrayList<Restriccion_ubicacion> r0 = new ArrayList();
        ArrayList<Restriccion_ubicacion> r1 = new ArrayList();
        ArrayList<Restriccion_ubicacion> r2 = new ArrayList();
        ArrayList<Restriccion_ubicacion> r3 = new ArrayList();
        
        //Creamos restricciones
        Restriccion_ubicacion res12;
        res12 = new Restriccion_ubicacion("0","0",1,2,35);
        Restriccion_ubicacion res21;
        res21 = new Restriccion_ubicacion("0","0",2,1,35);
        Restriccion_ubicacion res34;
        res34 = new Restriccion_ubicacion("0","0",3,4,1);
        Restriccion_ubicacion res43;
        res43 = new Restriccion_ubicacion("0","0",4,3,1);
        Restriccion_ubicacion res31;
        res31 = new Restriccion_ubicacion("0","0",3,1,1);
        Restriccion_ubicacion res13;
        res13 = new Restriccion_ubicacion("0","0",1,3,1);
        Restriccion_ubicacion res14;
        res14 = new Restriccion_ubicacion("0","0",1,4,1);
        Restriccion_ubicacion res41;
        res41 = new Restriccion_ubicacion("0","0",4,1,1);
        
        
        //Añadimos las restricciones a su conjunto
        r0.add(res12);
        r0.add(res13);
        r0.add(res14);
        r1.add(res21);
        r2.add(res34);
        r2.add(res31);
        r3.add(res43);
        r3.add(res41);
        
        //añadimos todo al hashMap
        res.put(1, r0);
        res.put(2, r1);
        res.put(3, r2);
        res.put(4, r3);
        
        for(int i=1;i<=res.size();++i){
            System.out.println(""+res.get(i).get(0).consultar_OID1()+""+res.get(i).get(0).consultar_OID2()+""+res.get(i).get(0).consultar_distancia());
        }
        
        Plano p = new Plano(50,50);
        
        p.pos(0, 0).modificarPar(9, 0);
        p.pos(1, 0).modificarPar(9, 0);
        p.pos(2, 0).modificarPar(9, 0);
        p.pos(3, 0).modificarPar(9, 0);
        p.pos(4, 0).modificarPar(9, 0);
        p.pos(4, 0).modificarPar(9, 0);
        p.pos(4, 1).modificarPar(9, 0);
        p.pos(4, 2).modificarPar(9, 0);
        p.pos(4, 3).modificarPar(9, 0);
        p.pos(4, 4).modificarPar(9, 0);
        /*p.pos(9, 0).modificarPar(9, 0);
        p.pos(9, 1).modificarPar(9, 0);
        p.pos(9, 2).modificarPar(9, 0);
        p.pos(9, 3).modificarPar(9, 0);
        p.pos(9, 4).modificarPar(9, 0);
        p.pos(9, 5).modificarPar(9, 0);
        p.pos(9, 6).modificarPar(9, 0);
        p.pos(9, 7).modificarPar(9, 0);
        p.pos(9, 8).modificarPar(9, 0);
        p.pos(9, 9).modificarPar(9, 0);*/
   
            
        for(int i=0;i<p.tama();++i){
            for(int j=0;j<p.tamb();++j){
                System.out.print(""+p.pos(i, j).getoid());
            }
            System.out.println("\n");
            
        }
     
        testfunciones tt = new testfunciones();
        System.out.println("Llamo al backtracking");
        boolean b=tt.bactracking(0,elementos,lastVisited,res,p);
        if(b)System.out.println("Generado barrio satisfactoriamente");
        
        for(int i=0;i<p.tama();++i){
            for(int j=0;j<p.tamb();++j){
                System.out.print(p.pos(i, j).getoid() +"");
            }
            System.out.println("\n");    
        }
        
    }
}
