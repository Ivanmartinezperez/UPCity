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
 * @author ivanmartinez y ron
 */
public class vistaComandos {
    
    private CtrlDomBarrios CtrlBarrio;
    private CtrlDomElementos CtrlElem;
    private CtrlDomRestricciones CtrlRest;
    
    
    /////////////////GESTION ELEMENTOS///////////////////////////
    private boolean crearElemento(){
        
        System.out.println("Que tipo de edificio desea crear:");
        System.out.println("1-Vivienda\n2-Publico\n3-Comercio\n4-Salir");
        
        Scanner action = new Scanner(System.in);
        
        int n=(int)action.nextInt();
        boolean aux;
        while(n!=4){
            Scanner parametros = new Scanner(System.in);
            switch(n){
               case 1: System.out.println("Indique el nombre del edificio:");
                        String nombrev = parametros.nextLine();
                        System.out.println("Escriba la descripcion de este:");
                        String Desv = parametros.nextLine();
                        System.out.println("Eliga a que tipo de barrio asociaria este elemento:");
                        System.out.println("0-Cualquiera\n1-Gama baja\n2-Gama media\n3-Gama alta");
                        int TBv = (int) parametros.nextInt();
                        System.out.println("Indique la cantidad de personas que puede albergar la Vivienda");
                        int cantperv = (int) parametros.nextInt();
                        System.out.println("Indique el precio de la vivienda");
                        int preciov = parametros.nextInt();
                        CtrlElem.CrearElemento(nombrev, Desv, 1, TBv,1,1,preciov,cantperv,0);
                        System.out.println("Creado correctamente");
                        break;
                case 2: System.out.println("Escriba el nombre del edificio:");
                        String nombrep = parametros.nextLine();
                        System.out.println("Escriba la descripcion:");
                        String Desp = parametros.nextLine();
                        System.out.println("Eliga a que tipo de barrio asociaria este elemento:");
                        System.out.println("0-Cualquiera\n1-Gama baja\n2-Gama media\n3-Gama alta");
                        int TBp = (int) parametros.nextInt();
                        System.out.println("Indique la cantidad de personas que puede albergar la construccion");
                        int cantperp = (int) parametros.nextInt();
                        System.out.println("Indique el precio de la vivienda");
                        int preciop = parametros.nextInt();
                        CtrlElem.CrearElemento(nombrep, Desp, 1, TBp,1,1,preciop,cantperp,0);//Tipo de servicio no implementado(irrelevante de momento);
                        System.out.println("Creado correctamente");
                        break;
                case 3: System.out.println("Escriba el nombre del edificio:");
                        String nombrec = parametros.nextLine();
                        System.out.println("Escriba la descripcion:");
                        String Desc = parametros.nextLine();
                        System.out.println("Eliga a que tipo de barrio asociaria este elemento:");
                        System.out.println("0-Cualquiera\n1-Gama baja\n2-Gama media\n3-Gama alta");
                        int TBc = (int) parametros.nextInt();
                        System.out.println("Indique la cantidad de personas que puede albergar la construccion");
                        int cantperc = (int) parametros.nextInt();
                        System.out.println("Indique el precio de la vivienda");
                        int precioc = parametros.nextInt();
                        CtrlElem.CrearElemento(nombrec, Desc, 1, TBc,1,1,precioc,cantperc,0);
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
        System.out.println("Que tipo de restriccion desea crear:");
        System.out.println("1-Ubicacion\n2-Economica\n3-Demografica\n4-Salir");
        
        Scanner action = new Scanner(System.in);
        
        int n=(int)action.nextInt();
        boolean aux;
        while(n!=4){
            Scanner parametros = new Scanner(System.in);
            switch(n){
                case 1: System.out.println("Escriba el primer elemento de restriccion");
                        Integer OID1 = (int) parametros.nextInt();
                        System.out.println("Escriba el segundo elemento de restriccion");
                        Integer OID2 = (int) parametros.nextInt();
                        System.out.println("Eliga la distancia de restriccion");
                        int distancia = (int) parametros.nextInt();
                        // para hacer id por ahora
                        System.out.println("Escriba el id de la restriccion");
                        String id = parametros.nextLine();
                        aux = CtrlRest.CrearRestriccion(id, "ubicacion", OID1, OID2, distancia, -1, -1);
                        if (aux) System.out.println("Creado correctamente");
                        else System.out.println("La restriccion no se pudo crear");
                        break;
                case 2: System.out.println("Escriba cantidad de dinero para comercios");
                        int com = (int) parametros.nextInt();
                        System.out.println("Escriba cantidad de dinero para viviendas");
                        int viv = (int) parametros.nextInt();
                        System.out.println("Escriba cantidad de dinero para espacio publico");
                        int pub = (int) parametros.nextInt();
                        aux = CtrlRest.CrearRestriccion("economica1", "economica", -1, -1, com, viv, pub);
                        if (aux) System.out.println("Creado correctamente");
                        else System.out.println("La restriccion no se pudo crear");
                        break;
                case 3: System.out.println("Escriba el elemento de restriccion");
                        Integer OID = (int) parametros.nextInt();
                        System.out.println("Escriba la cantidad minima de habitantes");
                        int habitantes = (int) parametros.nextInt();
                        // para hacer id por ahora
                        System.out.println("Escriba el id de la restriccion");
                        String id1 = parametros.nextLine();
                        aux = CtrlRest.CrearRestriccion(id1, "demografica", OID, -1, habitantes, -1, -1);
                        if (aux) System.out.println("Creado correctamente");
                        else System.out.println("La restriccion no se pudo crear");
                        break;
                default: System.out.println("Opcio Invalida");    
            }
            System.out.println("Que tipo de restriccion desea crear:");
            System.out.println("1-Ubicacion\n2-Economica\n3-Demografica\n4-Salir");
            n = (int)action.nextInt();
        }
        return true;
    }
    
    private boolean eliminarRestriccion(){
        System.out.println("Eliminar Restriccion:");
        System.out.println("1-Proceder a eliminacion/2-Salir");
        
        Scanner action = new Scanner(System.in);
        
        int n=(int)action.nextInt();
        
        while(n == 1){
            Scanner parametros = new Scanner(System.in);
            String id = parametros.nextLine();
            boolean aux = CtrlRest.Eliminar_Restriccion(id);
            if (aux) System.out.println("Restriccion eliminada");
            else System.out.println("No se pudo eliminar restriccion (error de id)");
            System.out.println("Eliminar Restriccion:");
            System.out.println("1-Proceder a eliminacion/2-Salir");
            n = (int)action.nextInt();
        }
       return true; 
    }
    
    private boolean listarRestricciones(){
        System.out.println("Introduzca el tipo de restricciones que desea:");
        System.out.println("0-todos/1-ubicacion/2-demografica/3-economica");
        
        Scanner action = new Scanner(System.in);
        
        int n=(int)action.nextInt();
        boolean aux = true;
        
        switch(n){
            
            case 0: Set<String> lista = CtrlRest.ListaNombreRestricciones();
                    Iterator it = lista.iterator();
                    while(it.hasNext()) System.out.println(""+it.next());        
            case 1: Set<String> lista1 = CtrlRest.ListaNombreRestriccionesTipo("ubicacion");
                    Iterator it1 = lista1.iterator();
                    while(it1.hasNext()) System.out.println(""+it1.next());
            case 2: Set<String> lista2 = CtrlRest.ListaNombreRestriccionesTipo("demografica");
                    Iterator it2 = lista2.iterator();
                    while(it2.hasNext()) System.out.println(""+it2.next());
            case 3: Set<String> lista3 = CtrlRest.ListaNombreRestriccionesTipo("economica");
                    Iterator it3 = lista3.iterator();
                    while(it3.hasNext()) System.out.println(""+it3.next());
            default: aux = false; 
        }
        return aux;
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
        System.out.println("Crear barrio:");
        System.out.println("Introduzca el nombre del Barrio:");
        Scanner parametros = new Scanner(System.in);
        String nombre = parametros.nextLine();
        System.out.println("Introduzca el tipo de barrio:");
        System.out.println("(0-3)");
        int tipo = (int)parametros.nextInt();
        boolean aux = CtrlBarrio.crearBarrio(nombre, tipo);
        if (aux) System.out.println("Barrio creado");
        else System.out.println("Barrio no se pudo crear");
        return aux;
    }
    
    private boolean cargarBarrio(){
        System.out.println("Introduzca el nombre del Barrio:");
        Scanner parametros = new Scanner(System.in);
        String nombre = parametros.nextLine();
        boolean aux = CtrlBarrio.cargarBarrio(nombre);
        if (aux) System.out.println("Barrio cargado correctamente");
        else System.out.println("No se encuentra el barrio");
        return aux;
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
