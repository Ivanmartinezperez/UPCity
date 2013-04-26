/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import controladors.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author ivanmartinez
 */
public class vistaComandos {
    
    private CtrlDomBarrios CtrlBarrio;
    private CtrlDomElementos CtrlElem;
    
    private boolean crearElemento(){
        
        return CtrlElem.CrearElemento("Casa", "MOLA", 1, 0);
        
    }
    
    private boolean eliminarElemento(){
        return true;
    }
    
    private boolean listarElementos(){
        Set<String> lista = CtrlElem.ListaNombreElementos();
        Iterator it = lista.iterator();
        while(it.hasNext()){
            System.out.println(""+it.next());
        }
        return true;
    }
    
    private void gestionElementos(){
        System.out.println("Seccion destinada a la creacion y eliminacion de elementos urbanisticos");
        Scanner action = new Scanner(System.in);
        
        System.out.println("Que desea hacer:\n1-Crear Elemento\n2-Eliminar Elemento\n3-Listar Elementos\n4-Salir");
        
        int n=action.nextInt();
        
        while(n!=4){
            switch(n){
            
                case 1: crearElemento();
                case 2: eliminarElemento();
                case 3: listarElementos();
                default: System.out.println("Opcio Invalida");    
            }
            System.out.println("Que desea hacer:\n1-Crear Elemento\n2-Eliminar Elemento\n3-Listar Elementos\n4-Salir");
            n = action.nextInt();
        }
        
    }
    
    private void gestionRestricciones(){
        
    }
    
    private void gestionBarrios(){
        
    }

    
    
    public void mainLoop() throws IOException, FileNotFoundException, ClassNotFoundException, Exception{
        
        System.out.println("Bienvenido al generador de barrios UPCity!\nESPERE MIENTRAS SE CARGA EL SISTEMA...");
        
        System.out.println("Esta usted ante una version beta, la carga de disco esta totalemente simulada, por favor siga las instrucciones");
        
        CtrlBarrio = CtrlDomBarrios.getInstance();
        CtrlElem = CtrlDomElementos.getInstance();
        
        System.out.println("\n\n CUIDADO!!! Esta usted ante una version beta, no se han cargado elementos,ni restricciones");
        
        System.out.println("Que desea hacer:\n1-Gestion Barrios\n2-Gestion Elementos\n3-Gestion Restricciones\n4-Salir");
        
        Scanner action = new Scanner(System.in);
        
        int n=action.nextInt();
        
        while(n!=4){
            switch(n){
            
                case 1: gestionBarrios();
                case 2: gestionElementos();
                case 3: gestionRestricciones();
                default: System.out.println("Opcio Invalida");    
            }
            System.out.println("Que desea hacer:\n1-Gestion Barrios\n2-Gestion Elementos\n3-Gestion Restricciones\n4-Salir");
            n = action.nextInt();
        }
        
        System.out.println("ADIOOOOOOS");
        
        //while(true);
        
    } 
    
    
}
