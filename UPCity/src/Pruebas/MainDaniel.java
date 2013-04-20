/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import Auxiliares.Pair;
import Pruebas.testfunciones;
import java.util.ArrayList;
import mapa.Plano;

/**
 *
 * @author ivanmartinez
 */
public class MainDaniel {
    
    public static void main(String arg[]) throws Exception{
        
        
        Plano plan = new Plano(10, 10);
        ArrayList<Pair<Integer, Integer> > lista = new ArrayList<Pair<Integer, Integer> >();
        Pair<Integer, Integer> aux = new Pair<Integer, Integer>(2,3);
        lista.add(aux);
        System.out.println("antes de expande");
        plan.expande(3, 3, 1, lista);
        System.out.println("Fin del programa");
        
    }
}
