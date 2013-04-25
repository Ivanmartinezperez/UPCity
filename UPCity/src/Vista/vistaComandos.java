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
    private CtrlDomElementos CtrlElementos;
    private CtrlDomRestricciones CtrlRestricciones;
    private stubbedBarriosGDP SimBarrioGdp;
    private stubbedElementosGDP SimElemGdp;
    private stubbedRestriccionesGDP SimResGdp;
    
    
    public void mainloop() throws IOException, FileNotFoundException, ClassNotFoundException, Exception{
        
        System.out.println("Bienvenido al generador de barrios UPCity!\nESPERE MIENTRAS SE CARGA EL SISTEMA...");
        
        System.out.println("Esta usted ante una version beta, la carga de disco esta totalemente simulada, por favor siga las instrucciones");
        
        System.out.println("Introduccion de elementos:\n1-Introducir Elemento\n2-Acabar la introduccion de elementos");
        int n=0;
        Scanner action = new Scanner(System.in);
        
        
    } 
    
    
}
