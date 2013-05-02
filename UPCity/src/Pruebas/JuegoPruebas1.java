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
public class JuegoPruebas1 {
    
    public static void main(String arg[]) throws Exception{
        
        
        System.out.println("----------------------------------------------------------------");
        System.out.println();
        System.out.println("Juego de pruebas 1 ");
        System.out.println("Primero comprovaremos que al expandir i desexpandir lo realize correctamente");
        System.out.println("para eso crearemos un barrio donde en la parte central este lleno de carreteras, dejando");
        System.out.println("solo espacio en los laterales del mapa. Queremos comprovar dos cosas con este juego de pruebas:");
        System.out.println("1.Que la funcion expande y desexpande funciona correctamente");
        System.out.println("2. Que la funcion expande y desexpande realiza las expansiones en todas las zonas de los limites");
        System.out.println("3.comprovamos el correcto funcionamiento del Backtracking, primero en una situacion sin solucion.");
        System.out.println("y despues en otra en la que si hay una solucion.");
        System.out.println();
        System.out.println("----------------------------------------------------------------");
        System.out.println();

        CtrlDomElementos CtrlElem;
        CtrlElem = CtrlDomElementos.getInstance();
        CtrlDomRestricciones CtrlRest;
        CtrlRest = CtrlDomRestricciones.getInstance();
        CtrlRest.inicializar();
        CtrlElem.inicializar();
        
        CtrlElem.CrearElemento("casa", "mola", 1, 0, 1, 1, 10, 10, 10);
        CtrlElem.CrearElemento("comercio", "mola", 1, 0, 1, 1, 10, 10, 10);
        CtrlRest.CrearRestriccion("1", "ubicacion", "casa", "casa", 1, 0, 0);
        
        CtrlDomBarrios CtrlBarrio;
        CtrlBarrio = CtrlDomBarrios.getInstance();
        CtrlBarrio.crearBarrio("VNG", 1);
        CtrlBarrio.crearMapaBarrio(8, 8);
        CtrlBarrio.anadirElemBarrio("casa", 15);
        CtrlBarrio.anadirElemBarrio("comercio", 15);
        for(int i=0;i<8;++i){
            for(int j=0;j<8;++j){
                if(i > 0 && j > 0 && i < 7 && j < 7) CtrlBarrio.insertarCarretera(i, j);
            }            
        }
        
        
        System.out.println();
        System.out.println("--------------------Caso1. Hay mas elementos que espacios vacios----------------------");
        System.out.println();
        System.out.println("Este es el barrio, antes de añadir elementos y restricciones");
        Integer mat[][] = CtrlBarrio.vistaMapa();
        for(int i=0;i < mat.length;++i){
            for(int j=0;j<mat[0].length;++j){
                if(mat[i][j] == -1) System.out.print("c   ");
                else System.out.print(mat[i][j] +"   ");
            }
            System.out.println("\n");    
        }
        
        CtrlBarrio.anadirRestBarrio("1");
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
        
        
        CtrlBarrio.quitarElemento("casa", 5);
        CtrlBarrio.quitarElemento("comercio", 5);
        
        System.out.println();
        System.out.println("------------caso 2: los elementos si que caben------------------");
        System.out.println();
        System.out.println("Este es el barrio, antes de añadir elementos y restricciones");
        mat = CtrlBarrio.vistaMapa();
        for(int i=0;i < mat.length;++i){
            for(int j=0;j<mat[0].length;++j){
                if(mat[i][j] == -1) System.out.print("c   ");
                else System.out.print(mat[i][j] +"   ");
            }
            System.out.println("\n");    
        }
        
                CtrlBarrio.generarBarrio();
        aux = CtrlBarrio.generarBarrio();
        
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

        
       

}
