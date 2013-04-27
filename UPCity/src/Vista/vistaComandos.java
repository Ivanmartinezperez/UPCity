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
    
    
    /////////////////GESTION ELEMENTOS///////////////////////////
    private boolean crearElemento(){
        
        System.out.println("Que tipo de edificio desea crear:");
        System.out.println("1-Vivienda\n2-Publico\n3-Comercio\n4-Salir");
        
        Scanner action = new Scanner(System.in);
        
        int n=(int)action.nextInt();
        
        while(n!=4){
            Scanner parametros = new Scanner(System.in);
            switch(n){
                case 1: System.out.println("Escriba el nombre del edificio:");
                        String nombrev = parametros.nextLine();
                        System.out.println("Escriba la descripcion:");
                        String Desv = parametros.nextLine();
                        System.out.println("Eliga a que tipo de barrio asociaria este elemento:");
                        System.out.println("0-Cualquiera\n1-Gama baja\n2-Gama media\n3-Gama alta");
                        int TBv = (int) parametros.nextInt();
                        CtrlElem.CrearElemento(nombrev, Desv, 1, TBv);
                        System.out.println("Creado correctamente");
                        break;
                case 2: System.out.println("Escriba el nombre del edificio:");
                        String nombrep = parametros.nextLine();
                        System.out.println("Escriba la descripcion:");
                        String Desp = parametros.nextLine();
                        System.out.println("Eliga a que tipo de barrio asociaria este elemento:");
                        System.out.println("0-Cualquiera\n1-Gama baja\n2-Gama media\n3-Gama alta");
                        int TBp = (int) parametros.nextInt();
                        CtrlElem.CrearElemento(nombrep, Desp, 1, TBp);
                        System.out.println("Creado correctamente");
                        break;
                case 3: System.out.println("Escriba el nombre del edificio:");
                        String nombrec = parametros.nextLine();
                        System.out.println("Escriba la descripcion:");
                        String Desc = parametros.nextLine();
                        System.out.println("Eliga a que tipo de barrio asociaria este elemento:");
                        System.out.println("0-Cualquiera\n1-Gama baja\n2-Gama media\n3-Gama alta");
                        int TBc = (int) parametros.nextInt();
                        CtrlElem.CrearElemento(nombrec, Desc, 1, TBc);
                        System.out.println("Creado correctamente");
                        break;
                default: System.out.println("Opcio Invalida");    
            }
            System.out.println("Que tipo de edificio desea crear:");
            System.out.println("1-Vivienda\n2-Publico\n3-Comercio\n4-Salir");
            n = (int)action.nextInt();
        }
        
        
        return true;
    }
    
    private boolean eliminarElemento(){
        return true;
    }
    
    private boolean listarElementos(){
        System.out.println("\nLos elementos actuales en todo el sistema son:");
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
        
        System.out.println("Que desea hacer:\n1-Crear Edificio\n2-Eliminar Edificio\n3-Listar Edificio\n4-Salir");
        
        int n=(int)action.nextInt();
        
        while(n!=4){
            switch(n){
            
                case 1: crearElemento();
                        break;
                case 2: eliminarElemento();
                        break;
                case 3: listarElementos();
                        break;
                default: System.out.println("Opcio Invalida");    
            }
            System.out.println("Que desea hacer:\n1-Crear Edificio\n2-Eliminar Edificio\n3-Listar Edificios\n4-Salir");
            n = (int)action.nextInt();
        }
        
    }
    /////////////////////////////////////////////////////
    
    //////////////GESTION RESTRICCIONES///////////////////////////////////////
    private boolean crearRestriccion(){
        return false;
    }
    
    private boolean eliminarRestriccion(){
        return false;
    }
    
    private boolean listarRestricciones(){
        return false;
    }
    
    private void gestionRestricciones(){
        System.out.println("Seccion destinada a la creacion y eliminacion de Restricciones");
        Scanner action = new Scanner(System.in);
        
        System.out.println("Que desea hacer:\n1-Crear Restriccion\n2-Eliminar Restriccion\n3-Listar Restricciones\n4-Salir");
        
        int n=(int)action.nextInt();
        
        while(n!=4){
            switch(n){
            
                case 1: crearRestriccion();
                        break;
                case 2: eliminarRestriccion();
                        break;
                case 3: listarRestricciones();
                        break;
                default: System.out.println("Opcio Invalida");    
            }
            System.out.println("Que desea hacer:\n1-Crear Restriccion\n2-Eliminar Restriccion\n3-Listar Restricciones\n4-Salir");
            n = (int)action.nextInt();
        }
    }
    ///////////////////////////////////////////////////
    
    ////////////////////////GESTION BARRIOS//////////////////////////////////////
    private boolean crearBarrio(){
        return false;
    }
    
    private boolean cargarBarrio(){
        return false;
    }
    
    private boolean modificarBarrio(){
        return false;
    }
    
    private boolean eliminarBarrio(){
        return false;
    }
    
    
    
    
    private void gestionBarrios(){
        System.out.println("Seccion destinada a la gestion de barrios");
        Scanner action = new Scanner(System.in);
        
        System.out.println("Que desea hacer:\n1-Crear Barrio\n2-Cargar Barrio\n3-Modificar Barrio\n4-Eliminar Barrio\n5-Salir");
        
        int n=(int)action.nextInt();
        
        while(n!=5){
            switch(n){
            
                case 1: crearBarrio();
                        break;
                case 2: cargarBarrio();
                        break;
                case 3: modificarBarrio();
                        break;
                case 4: eliminarBarrio();
                default: System.out.println("Opcio Invalida");    
            }
            System.out.println("Que desea hacer:\n1-Crear Barrio\n2-Cargar Barrio\n3-Modificar Barrio\n4-Eliminar Barrio\n5-Salir");
            n = (int)action.nextInt();
        }
    }

    
    //////////////MAIN PRINCIPAL///////////////////////////////////////
    public void mainLoop() throws IOException, FileNotFoundException, ClassNotFoundException, Exception{
        
        System.out.println("Bienvenido al generador de barrios UPCity!\nESPERE MIENTRAS SE CARGA EL SISTEMA...");
        
        System.out.println("Esta usted ante una version beta, la carga de disco"
                + "esta totalemente simulada, por favor siga las instrucciones");
        
        CtrlBarrio = CtrlDomBarrios.getInstance();
        CtrlElem = CtrlDomElementos.getInstance();
        
        System.out.println("\n\nCUIDADO!!! Esta usted ante una version beta, no se han cargado elementos,ni restricciones");
        
        System.out.println("Que desea hacer:\n1-Gestion Barrios\n2-Gestion Elementos\n3-Gestion Restricciones\n4-Salir");
        
        Scanner action = new Scanner(System.in);
        
        int n=(int)action.nextInt();
        
        while(n!=4){
            switch(n){
            
                case 1: gestionBarrios();
                        break;
                case 2: gestionElementos();
                        break;
                case 3: gestionRestricciones();
                        break;
                default: System.out.println("Opcio Invalida");    
            }
            System.out.println("Que desea hacer:\n1-Gestion Barrios\n2-Gestion Elementos\n3-Gestion Restricciones\n4-Salir");
            n = (int)action.nextInt();
        }
        ////////////////////////////////////////////////////////
        System.out.println("ADIOOOOOOS");
        
        //while(true);
        
    } 
    
    
}
