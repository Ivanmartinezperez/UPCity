/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import controladors.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ivanmartinez
 */
public class vistaComandos {
    
    private CtrlDomBarrios CtrlBarrio;

    
    
    public void mainloop() throws IOException, FileNotFoundException, ClassNotFoundException, Exception{
        
        System.out.println("Bienvenido al generador de barrios UPCity!\nESPERE MIENTRAS SE CARGA EL SISTEMA...");
        
        System.out.println("Esta usted ante una version beta, la carga de disco esta totalemente simulada, por favor siga las instrucciones");
        
        CtrlBarrio = CtrlDomBarrios.getInstance();
        
        System.out.println("\n\n CUIDADO!!! Esta usted ante una version beta, no se han cargado elementos,ni restricciones");
        
        System.out.println("Que desea hacer:\n1-Crear Barrio\n2-Cargar Barrio\3-Crear Elemento\n4-Crear Restriccion");
        while(true);
        
    } 
    
    
}
