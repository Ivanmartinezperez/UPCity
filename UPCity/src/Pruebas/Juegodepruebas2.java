/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import Auxiliares.Pair;
import Pruebas.testfunciones;
import controladors.CtrlDomBarrios;
import controladors.CtrlDomElementos;
import controladors.CtrlDomRestricciones;
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
public class Juegodepruebas2 {
    
    public static void main(String arg[]) throws Exception{
        
        
        CtrlDomBarrios CtrlBarrio;
        CtrlDomElementos CtrlElem;
        CtrlDomRestricciones CtrlRest;
        
        CtrlElem = CtrlDomElementos.getInstance();
        CtrlRest = CtrlDomRestricciones.getInstance();
        CtrlRest.inicializar();
        CtrlElem.inicializar();
        
        CtrlElem.CrearElemento("casa", "mola", 1, 0, 1, 1, 10, 10, 10);
        CtrlElem.CrearElemento("comercio", "mola", 1, 0, 1, 1, 10, 10, 10);
        CtrlRest.CrearRestriccion("1", "ubicacion", "casa", "casa", 1, 0, 0);
        
        System.out.println("----------------------------------------------------------------");
        System.out.println();
        System.out.println("Juego de pruebas 2 ");
        System.out.println("En el primer juego de pruebas comprovaremos que el backtracking funcione correctamente");
        System.out.println("aunque los conjuntos de espacios vacios no esten conexos y esten vacios");
        System.out.println("En el segundo juego de pruebas comprovaremos que el backtracking funciona correctamente con");
        System.out.println("las restricciones de ubicacion, primero se podra generar el barrio, y en el segundo caso, no se podra");
        System.out.println("porque no va a caber a causa de las restricciones");
        System.out.println();
        System.out.println("----------------------------------------------------------------");
        System.out.println();
        
        CtrlBarrio = CtrlDomBarrios.getInstance();
        CtrlBarrio.crearBarrio("VNG", 1);
        CtrlBarrio.crearMapaBarrio(8, 8);
        CtrlBarrio.anadirElemBarrio("casa", 8);
        CtrlBarrio.anadirElemBarrio("comercio", 10);
        for(int i=0;i<8;++i){
            for(int j=0;j<8;++j){
                if(i == 6 || j == 6 || i == 1 || j == 1|| i == 5 || j == 5) CtrlBarrio.insertarCarretera(i, j);
            }            
        }
        
        System.out.println();
        System.out.println("-----------------juego de pruebas 1--------------------------------");
        System.out.println("Casas: 8");
        System.out.println("Comercios: 10");
        System.out.println("Restriccion de ubicacion: las casas deben estar a 1 de distancia.");
        System.out.println();
        System.out.println("Este es el barrio, antes del backtracking");        
        Integer mat[][] = CtrlBarrio.vistaMapa();
        for(int i=0;i < mat.length;++i){
            for(int j=0;j<mat[0].length;++j){
                if(mat[i][j] == -1) System.out.print("c   ");
                else System.out.print(mat[i][j] +"   ");
            }
            System.out.println("\n");    
        }
        
        CtrlBarrio.anadirElemBarrio("casa", 2);
        CtrlBarrio.anadirElemBarrio("comercio", 2);
        CtrlBarrio.generarBarrio();
        boolean aux = CtrlBarrio.generarBarrio();
        
        if(aux == true) System.out.println("todo ha ido bien con el back");
        else System.out.println("no ha ido bien el back");
        
        System.out.println();
        System.out.println("----------------------------------------------------------------");
        System.out.println();
        System.out.println("Este es el barrio, despues del backtracking");        
        mat = CtrlBarrio.vistaMapa();
        for(int i=0;i < mat.length;++i){
            for(int j=0;j<mat[0].length;++j){
                if(mat[i][j] == -1) System.out.print("c   ");
                else System.out.print(mat[i][j] +"   ");
            }
            System.out.println("\n");    
        }
        
        System.out.println("Como podemos ver, el backtracking funciona igualmente, aunque las zonas vacias no esten conexas.");
        
        
        CtrlDomBarrios CtrlBarrio2;
        CtrlBarrio2 = CtrlDomBarrios.getInstance();
        CtrlBarrio2.crearBarrio("VNG", 1);
        CtrlBarrio2.crearMapaBarrio(4, 4);
        CtrlBarrio2.anadirElemBarrio("casa", 4);

        
        System.out.println();
        System.out.println("------------juego de pruebas 2--------------------------------------");
        System.out.println();
        System.out.println("Este es el barrio, antes del backtracking");
        System.out.println("Casas: 4");
        System.out.println("Restriccion de ubicacion: las casas deben estar a 1 de distancia.");
        mat = CtrlBarrio2.vistaMapa();
        for(int i=0;i < mat.length;++i){
            for(int j=0;j<mat[0].length;++j){
                if(mat[i][j] == -1) System.out.print("c   ");
                else System.out.print(mat[i][j] +"   ");
            }
            System.out.println("\n");    
        }
        
        
        CtrlBarrio2.anadirRestBarrio("1");
        aux = CtrlBarrio2.generarBarrio();
        

        
        if(aux == true) System.out.println("todo ha ido bien con el back");
        else System.out.println("no ha ido bien el back");
        
        System.out.println();
        System.out.println("----------------------------------------------------------------");
        System.out.println();
        System.out.println("Este es el barrio, despues del backtracking");        
        mat = CtrlBarrio2.vistaMapa();
        for(int i=0;i < mat.length;++i){
            for(int j=0;j<mat[0].length;++j){
                if(mat[i][j] == -1) System.out.print("c   ");
                else System.out.print(mat[i][j] +"   ");
            }
            System.out.println("\n");    
        }
        
        System.out.println("En este caso podemos ver perfectamente que la funcion expande funciona bien, ");
        System.out.println("y que el backtracking cumple bien las restricciones.");
        
        System.out.println();
        System.out.println("------------juego de pruebas 3--------------------------------------");
        System.out.println();
        System.out.println("Este es el barrio, antes del backtracking");
        System.out.println("Casas: 5");
        System.out.println("Restriccion de ubicacion: las casas deben estar a 1 de distancia.");
        mat = CtrlBarrio2.vistaMapa();
        for(int i=0;i < mat.length;++i){
            for(int j=0;j<mat[0].length;++j){
                if(mat[i][j] == -1) System.out.print("c   ");
                else System.out.print(mat[i][j] +"   ");
            }
            System.out.println("\n");    
        }
        
        CtrlBarrio2.anadirElemBarrio("casa", 1);
        
        aux = CtrlBarrio2.generarBarrio();
        if(aux == true) System.out.println("todo ha ido bien con el back");
        else System.out.println("no ha ido bien el back");
        
        System.out.println();
        System.out.println("----------------------------------------------------------------");
        System.out.println();
        System.out.println("Este es el barrio, despues del backtracking");        
        mat = CtrlBarrio2.vistaMapa();
        for(int i=0;i < mat.length;++i){
            for(int j=0;j<mat[0].length;++j){
                if(mat[i][j] == -1) System.out.print("c   ");
                else System.out.print(mat[i][j] +"   ");
            }
            System.out.println("\n");    
        }
        
        System.out.println("en este caso, el backtracking falla porque no hay espacio para todas las casas");
        System.out.println("a causa de las resctriccion.");
        
        
        
    }
        
       

}






 