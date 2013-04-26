/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import Pruebas.testfunciones;
import Vista.vistaComandos;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author ivanmartinez
 */
public class Mainprincipal {
    
    public static void main(String arg[]) throws IOException, FileNotFoundException, ClassNotFoundException, Exception{
        
        vistaComandos a = new vistaComandos();
        a.mainLoop();

        
    }
}
