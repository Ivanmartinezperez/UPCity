/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import Vista.vistaComandos;
import Vista.vistaGrafica;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author ivanmartinez
 */
public class UPCity {
    
    public static void main(String arg[]) throws IOException, FileNotFoundException, ClassNotFoundException, Exception{
        
        if(arg.length==0){
            vistaGrafica.main(arg);
        }
        else if(arg.length==1 && "-c".equals(arg[0])){
            vistaComandos a = new vistaComandos();
            a.mainLoop();
        }

        
    }
}
