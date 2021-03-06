/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import controladors.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author ivanmartinez y ron y Artem Cherkashin
 */
public class vistaComandos {
    
    private CtrlDomBarrios CtrlBarrio;
    private CtrlDomElementos CtrlElem;
    private CtrlDomRestricciones CtrlRest;
    
    
    //////////AUXILIAR DE ENTRADA DE ENTEROS/////
    private int getInt(){
        boolean entero=false;
        int res=0;
       // Scanner lec = new Scanner(System.in);
        while(!entero){
            try{
                Scanner lec = new Scanner(System.in);
                res = (int) lec.nextInt();
                entero=true;
            }catch(Exception e){
                System.out.println("Ha de introducir un entero!");
            }
        }
        return res;
    }
    
    
    /////////////////GESTION ELEMENTOS///////////////////////////
    private boolean crearElemento(){
        
        System.out.println("Que tipo de edificio desea crear:");
        System.out.println("1-Vivienda\n2-Publico\n3-Comercio\n4-Salir");
        int x;
        int y;
        Scanner action = new Scanner(System.in);
        
        int n=getInt();
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
                        int TBv = getInt();
                        System.out.println("Indique la cantidad de personas que puede albergar la Vivienda");
                        int cantperv = getInt();
                        System.out.println("Indique el precio de la vivienda");
                        int preciov = getInt();
                        System.out.println("Indique el numero de parcelas del edificio en el eje X");
                        x = getInt();
                        System.out.println("Indique el numero de parcelas del edificio en el eje Y");
                        y = getInt();
                        
                        try{
                            aux = CtrlElem.CrearElemento(nombrev, Desv, 1, TBv,x,y,preciov,cantperv,0);
                            System.out.println("Creado correctamente");
                        }catch(Exception e){
                            System.out.println("\nEl edificio no se pudo crear");
                            System.out.println(e.getMessage());
                        }
                        break;
                case 2: System.out.println("Escriba el nombre del edificio:");
                        String nombrep = parametros.nextLine();
                        System.out.println("Elija a que tipo de servicio publico pertenece:");
                        System.out.println("1-Sanidad\n2-Educacion\n3-Seguridad\n4-Comunicacion\n5-Ocio\n");
                        int TP = getInt();
                        System.out.println("Escriba la descripcion:");
                        String Desp = parametros.nextLine();
                        System.out.println("Elija a que tipo de barrio asociaria este elemento:");
                        System.out.println("0-Cualquiera\n1-Gama baja\n2-Gama media\n3-Gama alta");
                        int TBp = getInt();
                        System.out.println("Indique la cantidad de personas a las que puede ofrecer el servicio");
                        int cantperp = getInt();
                        System.out.println("Indique el precio de la construccion");
                        int preciop = getInt();
                        System.out.println("Indique el numero de parcelas del edificio en el eje X");
                        x = getInt();
                        System.out.println("Indique el numero de parcelas del edificio en el eje Y");
                        y = getInt();
                        
                        try{
                            aux = CtrlElem.CrearElemento(nombrep, Desp, 2, TBp,x,y,preciop,cantperp,TP);
                            System.out.println("Creado correctamente");
                        }catch(Exception e){
                            System.out.println("\nEl edificio no se pudo crear");
                            System.out.println(e.getMessage());
                        }
                        break;
                case 3: System.out.println("Escriba el nombre del edificio:");
                        String nombrec = parametros.nextLine();
                        System.out.println("Escriba la descripcion:");
                        String Desc = parametros.nextLine();
                        System.out.println("Eliga a que tipo de barrio asociaria este elemento:");
                        System.out.println("0-Cualquiera\n1-Gama baja\n2-Gama media\n3-Gama alta");
                        int TBc = getInt();
                        System.out.println("Indique la cantidad de personas las que puede atender");
                        int cantperc = getInt();
                        System.out.println("Indique el precio del Comercio");
                        int precioc = getInt();
                        System.out.println("Indique el numero de parcelas del edificio en el eje X");
                        x = getInt();
                        System.out.println("Indique el numero de parcelas del edificio en el eje Y");
                        y = getInt();
                        
                        try{
                            aux = CtrlElem.CrearElemento(nombrec, Desc, 3, TBc,x,y,precioc,cantperc,0);
                            System.out.println("Creado correctamente");
                        }catch(Exception e){
                            System.out.println("\nEl edificio no se pudo crear");
                            System.out.println(e.getMessage());
                        }
                        break;
                default: System.out.println("Opcio Invalida");   
            }
            System.out.println("Que tipo de edificio desea crear:");
            System.out.println("1-Vivienda\n2-Publico\n3-Comercio\n4-Salir");
            n = getInt();
        }
        
        
        return true;
    }
    
    private void eliminarElemento(){
        
        Scanner action = new Scanner(System.in);
        listarElementos(0);
        System.out.println("Escriba el nombre del elemento que desea eliminar:");
        String nombre = action.nextLine();
        try{
            CtrlElem.eliminarElemento(nombre);
            System.out.println("Elemento eliminado correctamente");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
    private boolean listarElemAux(int TB, int tipo){
        
        String[][] lista;
        lista = CtrlElem.listarElemTipo(TB,tipo);
        if(lista == null) return false;
        switch(tipo){
            case 1: 
                if(lista.length>0)
                    System.out.println("VIVIENDAS  TBarrios  Precio  Capacidad  TamX TamY");
                break;
            case 3:
                if(lista.length>0)
                    System.out.println("COMERCIOS  TBarrios  Precio  Capacidad  TamX TamY");
                break;
            case 2:
                if(lista.length>0)
                    System.out.println("PUBLICOS  TBarrios  Precio  TServicio  Capacidad  TamX TamY");
                break;
        }
        for(int i=0; i<lista.length; ++i){
            if(tipo==2) System.out.println(lista[i][0] + "        " + lista[i][1] + "        " + lista[i][2] + "        "
                    + lista[i][3] + "        " + lista[i][4] + "        " + lista[i][5] + "    " + lista[i][6]);
            else System.out.println(lista[i][0] + "        " + lista[i][1] + "        " + lista[i][2] + "        "
                    + lista[i][3] + "        " + lista[i][4] + "    " + lista[i][5]);
        }
        return true;
    }
    
    private boolean listarElementos(int TB){
        System.out.println("\n\nLOS ELEMENTOS ACTUALES QUE CONTIENE EL SISTEMA SON:");
        System.out.println("\nELEMENTOS PARA CUALQUIER TIPO DE BARRIO:");
        listarElemAux(0,1);
        listarElemAux(0,3);
        listarElemAux(0,2);
        System.out.println("------------------------------------------------");
        switch(TB){
            case 0:
                System.out.println("\nELEMENTOS PARA BARRIOS DE GAMA BAJA:");
                listarElemAux(1,1);
                listarElemAux(1,3);
                listarElemAux(1,2);
                System.out.println("------------------------------------------------");
                System.out.println("\nELEMENTOS PARA BARRIOS DE GAMA MEDIA:");
                listarElemAux(2,1);
                listarElemAux(2,3);
                listarElemAux(2,2);
                System.out.println("------------------------------------------------");
                System.out.println("\nELEMENTOS PARA BARRIOS DE GAMA ALTA:");
                listarElemAux(3,1);
                listarElemAux(3,3);
                listarElemAux(3,2);
                System.out.println("------------------------------------------------");
                break;
            case 1:
                System.out.println("\nELEMENTOS PARA BARRIOS DE GAMA BAJA:");
                listarElemAux(1,1);
                listarElemAux(1,3);
                listarElemAux(1,2);
                System.out.println("------------------------------------------------");
                break;
            case 2:
                System.out.println("\nELEMENTOS PARA BARRIOS DE GAMA MEDIA:");
                listarElemAux(2,1);
                listarElemAux(2,3);
                listarElemAux(2,2);
                System.out.println("------------------------------------------------");
                break;
            case 3:
                System.out.println("\nELEMENTOS PARA BARRIOS DE GAMA ALTA:");
                listarElemAux(3,1);
                listarElemAux(3,3);
                listarElemAux(3,2);
                System.out.println("------------------------------------------------");
                break;
                
        }
        System.out.println("\n");
        return true;
    }
    
    private void gestionElementos(){
        System.out.println("Seccion destinada a la creacion y eliminacion de elementos urbanisticos");
        Scanner action = new Scanner(System.in);
        
        System.out.println("\nQue desea hacer:\n1-Crear Edificio\n2-Eliminar Edificio\n3-Listar Edificio\n4-Salir");
        
        int n=getInt();
        
        while(n!=4){
            switch(n){
            
                case 1: crearElemento();
                        break;
                case 2: eliminarElemento();
                        break;
                case 3: listarElementos(0);
                        break;
                default: System.out.println("Opcio Invalida");    
            }
            System.out.println("\nQue desea hacer:\n1-Crear Edificio\n2-Eliminar Edificio\n3-Listar Edificios\n4-Salir");
            n = getInt();
        }
        
    }
    /////////////////////////////////////////////////////
    
    //////////////GESTION RESTRICCIONES///////////////////////////////////////
    private boolean crearRestriccion(){
        System.out.println("Que tipo de restriccion desea crear:");
        System.out.println("1-Ubicacion\n2-Economica\n3-Demografica\n4-Salir");
        
        Scanner action = new Scanner(System.in);
        
        int n=getInt();
        boolean aux;
        while(n!=4){
            Scanner parametros = new Scanner(System.in);
            switch(n){
                case 1: System.out.println("Escriba el primer elemento de restriccion");
                        String OID1 = parametros.nextLine();
                        System.out.println("Escriba el segundo elemento de restriccion");
                        String OID2 = parametros.nextLine();
                        System.out.println("Eliga la distancia de restriccion");
                        int distancia = getInt();
                        // para hacer id por ahora
                        System.out.println("Escriba el id de la restriccion");
                        Scanner idscann = new Scanner(System.in);
                        String id = idscann.nextLine();
                        try{
                            CtrlRest.CrearRestriccion(id, "ubicacion", OID1, OID2, distancia, -1, -1);
                            System.out.println("\nRestriccion creada correctamente\n");
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;
                case 2: System.out.println("Escriba cantidad de dinero para comercios");
                        int com = getInt();
                        System.out.println("Escriba cantidad de dinero para viviendas");
                        int viv = getInt();
                        System.out.println("Escriba cantidad de dinero para espacio publico");
                        int pub = getInt();
                        System.out.println("Escriba el id de la restriccion");
                        Scanner idscann0 = new Scanner(System.in);
                        String id0 = idscann0.nextLine();
                        try{
                            CtrlRest.CrearRestriccion(id0, "economica", "-1", "-1", com, viv, pub);
                            System.out.println("\nRestriccion creada correctamente\n");
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;
                case 3: System.out.println("Escriba el elemento de restriccion");
                        String OID = parametros.nextLine();
                        System.out.println("Escriba la cantidad minima de habitantes");
                        int habitantes = getInt();
                        // para hacer id por ahora
                        System.out.println("Escriba el id de la restriccion");
                        Scanner idscann1 = new Scanner(System.in);
                        String id1 = idscann1.nextLine();
                        try{
                            CtrlRest.CrearRestriccion(id1, "demografica", OID, "-1", habitantes, -1, -1);
                            System.out.println("\nRestriccion creada correctamente\n");
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;
                default: System.out.println("Opcio Invalida");    
            }
            System.out.println("Que tipo de restriccion desea crear:");
            System.out.println("1-Ubicacion\n2-Economica\n3-Demografica\n4-Salir");
            n = getInt();
        }
        return true;
    }
    
    private void eliminarRestriccion(){
        
        Scanner action = new Scanner(System.in);
        listarRestricciones();
        System.out.println("Escriba el nombre de la Restriccion que desea eliminar:");
        String nombre = action.nextLine();
        try{
            CtrlRest.Eliminar_Restriccion(nombre);
            System.out.println("Restriccion eliminada  correctamente");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
    private void anadirGeneral(){
        Scanner parametros = new Scanner(System.in);
        System.out.println("Escriba el nombre de la restriccion que desea "
                + "anadir a Restricciones Generales:");
        String id = parametros.nextLine();
        try{
            CtrlRest.anadirRestGeneral(id);
            System.out.println("Restriccion anadida a Restricciones generales");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    
    private void quitarGeneral(){
        Scanner parametros = new Scanner(System.in);
        System.out.println("Escriba el nombre de la restriccion que desea "
                + "quitar de Restricciones Generales:");
        String id = parametros.nextLine();
        try{
            CtrlRest.quitarRestGeneral(id);
            System.out.println("Restriccion eliminada de Restricciones generales");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    
    private void listarRestGenerales(){
        System.out.println("\nLAS RESTRICCIONES GENERALES ACTUALES SON:\n");
        ArrayList<String> res = CtrlRest.listarRestGenerales();
        for(int i = 0; i<res.size(); ++i){
            System.out.println(res.get(i));
        }
        System.out.println("\n");
    }
    
    
    private boolean listarRestAux(String tipo){
        
        String[][] lista;
        lista = CtrlRest.listarRestTipo(tipo);
        if(lista == null) return false;
        for(int i=0; i<lista.length; ++i){
            switch(tipo){
                case "ubicacion":
                    System.out.println(lista[i][0] + "        "
                    + lista[i][1] + "        " + lista[i][2] + "        " + lista[i][3]);
                    break;
                case "demografica": 
                    System.out.println(lista[i][0] + "        " 
                    + lista[i][1] + "        " + lista[i][2]);
                    break;
                case "economica":
                    System.out.println(lista[i][0] + "        " + lista[i][1] + "        " 
                    + lista[i][2] + "        " + lista[i][3] + "        " + lista[i][4]);
                    break;
            }
        }
        return true;
    }
    
    
    private boolean listarRestricciones(){
        System.out.println("\n\nLAS RESTRICCIONES ACTUALES QUE CONTIENE EL SISTEMA SON:");
        System.out.println("\nRESTRICCIONES DE UBICACION:");
        System.out.println("NombreRest  NombreElem1  NombreElem2  Distancia");
        listarRestAux("ubicacion");
        System.out.println("------------------------------------------------");
        System.out.println("\nRESTRICCIONES DEMOGRAFICAS:");
        System.out.println("NombreRest  NombreElem  Habitantes_minimos");
        listarRestAux("demografica");
        System.out.println("------------------------------------------------");
        System.out.println("\nRESTRICCIONES ECONOMICAS:");
        System.out.println("NombreRest  PresTotal  PresViviendas  PresPublicos  PresComercios");
        listarRestAux("economica");
        System.out.println("------------------------------------------------");
        System.out.println("\n");
        return true;
    }
    
    private void gestionRestricciones(){
        System.out.println("Seccion destinada a la creacion y eliminacion de Restricciones");
        Scanner action = new Scanner(System.in);
        
        System.out.println("\nQue desea hacer:\n1-Crear Restriccion\n2-Eliminar Restriccion\n3-Anadir Restriccion General\n4-Quitar Restriccion General\n5-Listar Restricciones\n6-Listar Restriciones Generales\n0-Salir");
        
        int n=getInt();
        
        while(n!=0){
            switch(n){
            
                case 1: crearRestriccion();
                        break;
                case 2: eliminarRestriccion();
                        break;
                case 3: listarRestricciones();
                        anadirGeneral();
                        break;
                case 4: listarRestGenerales();
                        quitarGeneral();
                        break;
                case 5: listarRestricciones();
                        break;
                case 6: listarRestGenerales();
                        break;
                default: System.out.println("Opcio Invalida");    
            }
            System.out.println("\nQue desea hacer:\n1-Crear Restriccion\n2-Eliminar Restriccion\n3-Anadir Restriccion General\n4-Quitar Restriccion General\n5-Listar Restricciones\n6-Listar Restriciones Generales\n0-Salir");
            n = getInt();
        }
    }
    ///////////////////////////////////////////////////
    
    ////////////////////////GESTION BARRIOS//////////////////////////////////////
    private void mostrarBarrios(){
        ArrayList<String> bars = CtrlBarrio.listarBarrios();
        System.out.println("\nLos barrios que hay disponibles son: ");
        for(int i=0; i<bars.size(); ++i){
            System.out.println(bars.get(i));
        }
        System.out.println("------------------------------------\n");
    }
    
    
    private boolean mostrarBarrio(){
        Integer mat[][] = CtrlBarrio.vistaMapa();
        for(int i=0;i < mat.length;++i){
            for(int j=0;j<mat[0].length;++j){
                System.out.print(mat[i][j] +"   ");
            }
            System.out.println("\n");    
        }
        return true;
    }
    
    
    private boolean mostrarInfoBarrio(){
        String[] info = CtrlBarrio.getInfoBarrio();
        int t = (int) Integer.parseInt(info[1]);
        String tipo=null;
        switch(t){
            case 0: tipo = "Sin Tipo";
                break;
            case 1: tipo = "Gama Baja";
                break;
            case 2: tipo = "Gama Media";
                break;
            case 3: tipo = "Gama Alta";
                break;
        }
        System.out.println("\nLA INFORMACION ACTUAL DEL BARRIO ES LA SIGUIENTE:");
        System.out.println("Nombre del Barrio: " + info[0]);
        System.out.println("Tipo de Barrio: " + tipo);
        System.out.println("Poblacion deseada: " + info[3]);
        System.out.println("Poblacion posible: " + info[8]);
        System.out.println("Presupuesto total: " + info[2]);
        System.out.println("Presupuesto gastado: " + info[4]);
        System.out.println("---Presupuesto gastado en Viviendas: " + info[5]);
        System.out.println("---Presupuesto gastado en Servicios Publicos: " + info[6]);
        System.out.println("---Presupuesto gastado en Comercios: " + info[7]);
        System.out.println("Capacidad de Servicios de Sanidad: " + info[9]);
        System.out.println("Capacidad de Servicios de Educacion: " + info[10]);
        System.out.println("Capacidad de Servicios de Seguridad: " + info[11]);
        System.out.println("Capacidad de Servicios de Comunicacion: " + info[12]);
        System.out.println("Capacidad de Servicios de Ocio: " + info[13]);
        System.out.println("Capacidad de Comercio: " + info[14]);
        System.out.println("\n");
        
        return true;
    }
    
    private boolean mostrarCjtElem(){
        System.out.println("\nEL CONJUNTO DE ELEMENTOS DEL BARRIO CONTIENE LOS SIGUIENTES ELEMENTOS:");
        String[][] lista;
        lista = CtrlBarrio.listarCjtElemBarrio();
        if(lista == null) return false;
        System.out.println("\nVIVIENDAS:");
        System.out.println("Cantidad  OID  Nombre  TBarrios  Precio  Capacidad  TamX TamY");
        for(int i=0; i<lista.length; ++i){
            if(lista[i][0].contentEquals("v")) System.out.println(lista[i][1] + "        " + lista[i][2] + "        " + lista[i][3] + "        "
                    + lista[i][4] + "        " + lista[i][5] + "        " + lista[i][6] + "        " + lista[i][7] + "    " + lista[i][8] );
        }
        System.out.println("\nCOMERCIOS:");
        System.out.println("Cantidad  OID  Nombre  TBarrios  Precio  Capacidad  TamX TamY");
        for(int i=0; i<lista.length; ++i){
            if(lista[i][0].contentEquals("c")) System.out.println(lista[i][1] + "        " + lista[i][2] + "        " + lista[i][3] + "        "
                    + lista[i][4] + "        " + lista[i][5] + "        " + lista[i][6] + "        " + lista[i][7] + "    " + lista[i][8] );
        }
        System.out.println("\nPUBLICOS:");
        System.out.println("Cantidad  OID  Nombre  TBarrios  Precio  TServicio  Capacidad  TamX TamY");
        for(int i=0; i<lista.length; ++i){
            if(lista[i][0].contentEquals("p")) System.out.println(lista[i][1] + "        " + lista[i][2] + "        " + lista[i][3] + "        "
                    + lista[i][4] + "        " + lista[i][5] + "        " + lista[i][6] + "        " + lista[i][7] + "        " + lista[i][8] + "    " + lista[i][9] );
        }
        System.out.println("\n");
        return true;
    }
    
    
    private boolean mostrarCjtRest(){
        System.out.println("\nEL CONJUNTO DE RESTRICCIONES DEL BARRIO CONTIENE LAS SIGUIENTES RESTRICCIONES:");
        String[][] lista;
        lista = CtrlBarrio.listarCjtRestBarrio();
        if(lista == null) return false;
        System.out.println("\nUBICACION  NombreElem1  NombreElem2  Distancia");
        for(int i=0; i<lista.length; ++i){
            if(lista[i][0].contentEquals("u")) System.out.println(lista[i][1] + "        " + lista[i][2] + "        " + lista[i][3] + "        "
                    + lista[i][4]);
        }
        System.out.println("\nDEMOGRAFICAS  NombreElem  Habitantes_minimos");
        for(int i=0; i<lista.length; ++i){
            if(lista[i][0].contentEquals("d")) System.out.println(lista[i][1] + "        " + lista[i][2] + "        " + lista[i][3]);
        }
        System.out.println("\nECONOMICAS  PresTotal  PresViviendas  PresPublicos  PresComercios");
        for(int i=0; i<lista.length; ++i){
            if(lista[i][0].contentEquals("e")) System.out.println(lista[i][1] + "        " + lista[i][2] + "        " + lista[i][3] + "        "
                    + lista[i][4] + "        " + lista[i][5]);
        }
        System.out.println("\n");
        return true;
    }
    
    
    private void crearBarrio(){
        System.out.println("Crear barrio:");
        System.out.println("Introduzca el nombre del Barrio:");
        Scanner parametros = new Scanner(System.in);
        String nombre = parametros.nextLine();
        System.out.println("Introduzca el tipo de barrio:");
        System.out.println("(0-3)");
        int tipo = getInt();
        try{
        CtrlBarrio.crearBarrio(nombre, tipo,0);
        
        System.out.println("Introduzca el presupuesto disponible para el barrio:");
        System.out.println("Nota: Si no quiere limitar su barrio a un presupuesto, introduzca un 0,\n"
                + "asi simplmente se le mostrara el presupuesto gastado como valor informativo");
        int Presupuesto;
        boolean b=false;
        while(!b){
            Presupuesto = getInt();
            try{
                CtrlBarrio.setPresupuestoBarrio(Presupuesto);
                b = true;
                System.out.println("Presupuesto modificado correctamente");
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Introduzca la poblacion del barrio:");
        System.out.println("Nota: Si no quiere limitar el barrio a una poblacion, introduzca un 0\n"
                + "asi simplemente se le mostrara la poblacion posible como valor informativo");
        int Poblacion;
        b=false;
        while(!b){
            Poblacion = getInt();
            try{
                CtrlBarrio.setPoblacionbarrio(Poblacion);
                b = true;
                System.out.println("Poblacion modificada correctamente");
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        boolean b2=false;
        while(!b2){
            try{
                System.out.println("Introduzca el numero de parcelas horizontales del barrio:");
                int x = getInt();
                System.out.println("Introduzca el numero de parcelas verticales del barrio:");
                int y = getInt();
                CtrlBarrio.crearMapaBarrio(x, y);
                System.out.println("Mapa creado correctamente");
                b2 = true;
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        
        System.out.println("\nQue desea hacer:\n1-Añadir edificio a mi barrio\n2-Eliminar edificio de mi barrio\n"
                + "3-Añadir restriccion a mi barrio\n4-Eliminar restriccion de mi barrio\n5-Crear Elemento\n"
                + "6-Crear Restriccion\n7-Generar mi barrio\n8-Mostrar mi barrio\n9-Mostrar informacion del Barrio\n"
                + "10-Modificar Presupuesto del Barrio\n11-Modificar Poblacion del Barrio\n"
                + "12-Mostrar Conjunto de Elementos\n13-Mostrar Conjunto de Restricciones\n14-Guardar mi barrio\n"
                + "15-Insertar carretera\n16-Eliminar Carretera\n0-Salir");
        Scanner action = new Scanner(System.in);
        int n=getInt();
        boolean aux1;
        boolean generado = false;
        while(n!=0){
            String id;
            switch(n){
            
                case 1: listarElementos(CtrlBarrio.getTipoBarrio());
                        System.out.println("Escriba el nombre del elemento que desea añadir al barrio: ");
                        Scanner param = new Scanner(System.in);
                        id = param.nextLine();
                        System.out.println("Escriba la cantidad que quieres de este elemento en el barrio: ");
                        int cant = getInt();
                        try{
                            CtrlBarrio.anadirElemBarrio(id, cant);
                            System.out.println("Elemento añadido correctamente");
                        }catch(Exception e){
                            System.out.println("No se pudo añadir el elemento");
                            System.out.println(e.getMessage());
                        }
                        break;
                case 2: mostrarCjtElem();
                        System.out.println("Escriba el nombre del elemento que desea quitar del barrio: ");
                        Scanner param2 = new Scanner(System.in);
                        id = param2.nextLine();
                        System.out.println("Escriba la cantidad que quieres quitar de este elemento en el barrio: ");
                        cant = getInt();
                        try{
                            CtrlBarrio.quitarElemento(id, cant);
                            System.out.println("Elemento eliminado correctamente");
                        }catch(Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                case 3: listarRestricciones();
                        System.out.println("Escriba el nombre de restriccion que desea añadir al barrio: ");
                        Scanner param3 = new Scanner(System.in);
                        id = param3.nextLine();              
                        try{
                            CtrlBarrio.anadirRestBarrio(id);
                            System.out.println("Restriccion añadido correctamente");
                        }catch(Exception e){
                            System.out.println("No se pudo añadir la restriccion");
                            System.out.println(e.getMessage());
                        }
                        System.out.println("No se pudo añadir la restriccion");
                        break;
                case 4: mostrarCjtRest();
                        System.out.println("Escriba el nombre de restriccion que desea quitar del barrio: ");
                        Scanner param4 = new Scanner(System.in);
                        id = param4.nextLine();               
                        try{
                            CtrlBarrio.quitarRestBarrio(id);
                            System.out.println("Restriccion eliminado correctamente");
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;
                case 5: crearElemento();
                        break;
                case 6: crearRestriccion();
                        break;
                case 7: System.out.println("\nDesea generar el barrio?\nLa distribucion actual se perderia, desea continuar?\n1-Si\n2-Volver");
                        int opc = getInt();
                        while(opc != 2){
                            switch(opc){
                                case 1: System.out.println("\nDesea comprobar la suficiencia de los Servicios Publicos?\n1-Si\n2-No");
                                        opc = getInt();
                                        while(opc!=1 && opc!=2){
                                            System.out.println("Opcio Invalida");
                                            opc = getInt();
                                        }
                                        boolean comp;
                                        if(opc==1)
                                            comp = true;
                                        else 
                                            comp = false;
                                        System.out.println("\nGENERANDO BARRIO...\n"
                                        + "Esta operacion puede tardar varios minutos.....");
                                        try{
                                            CtrlBarrio.generarBarrio(comp);
                                            System.out.println("El barrio se genero correctamente");
                                        }catch(Exception e){
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                default: System.out.println("Opcio Invalida");
                             }
                            if(!generado){ 
                                System.out.println("Desea generar el barrio?\n1-Si\n2-Volver");
                                opc = getInt();
                            }
                            else opc = 2;
                         }
                         break;
                case 8:  System.out.println("Mostrando barrio:");
                         mostrarBarrio();
                         break;
                case 9:  mostrarInfoBarrio();
                         break;
                case 10: System.out.println("Introduzca el presupuesto disponible para el barrio:");
                         System.out.println("Nota: Si no quiere limitar su barrio a un presupuesto, introduzca un 0,\n"
                         + "asi simplmente se le mostrara el presupuesto gastado como valor informativo");
                         Presupuesto = getInt();
                         try{
                             CtrlBarrio.setPresupuestoBarrio(Presupuesto);
                             System.out.println("Presupuesto modificado correctamente");
                         }catch(Exception e){
                             System.out.println(e.getMessage());
                         }
                         break;
                case 11: System.out.println("Introduzca la poblacion del barrio:");
                         System.out.println("Nota: Si no quiere limitar el barrio a una poblacion, introduzca un 0\n"
                         + "asi simplemente se le mostrara la poblacion posible como valor informativo");
                         Poblacion = getInt();
                         try{
                             CtrlBarrio.setPoblacionbarrio(Poblacion);
                             System.out.println("Poblacion modificada correctamente");
                         }catch(Exception e){
                             System.out.println(e.getMessage());
                         }
                         break;
                case 12: mostrarCjtElem();
                         break;
                case 13: mostrarCjtRest();
                         break;
                case 14: System.out.println("Guardando barrio");
                         CtrlBarrio.guardarBarrio();
                         break;
                case 15: mostrarBarrio();
                         System.out.println("Inserte la fila donde quiere posicionar la carretera:");
                         Scanner param5 = new Scanner(System.in);
                         int f = getInt();
                         System.out.println("Inserte la columna donde quiere posicionar la carretera:");
                         int c = getInt();
                         try{
                            CtrlBarrio.insertarCarretera(f, c);
                            System.out.println("La carretera se ha insertado correctamente");
                         }catch(Exception e){
                            System.out.println(e.getMessage());
                         }
                         break;
               case 16: mostrarBarrio();
                         System.out.println("Inserte la fila de donde quiere eliminar la carretera:");
                         Scanner param6 = new Scanner(System.in);
                         f = getInt();
                         System.out.println("Inserte la columna de donde quiere eliminar la carretera:");
                         c = getInt();
                         try{
                            CtrlBarrio.eliminarCarretera(f, c);
                            System.out.println("La carretera se ha eliminado correctamente");
                         }catch(Exception e){
                            System.out.println(e.getMessage());
                         }          
                         break;
                default: System.out.println("Opcio Invalida");    
            }
          System.out.println("\nQue desea hacer:\n1-Añadir edificio a mi barrio\n2-Eliminar edificio de mi barrio\n"
                + "3-Añadir restriccion a mi barrio\n4-Eliminar restriccion de mi barrio\n5-Crear Elemento\n"
                + "6-Crear Restriccion\n7-Generar mi barrio\n8-Mostrar mi barrio\n9-Mostrar informacion del Barrio\n"
                + "10-Modificar Presupuesto del Barrio\n11-Modificar Poblacion del Barrio\n"
                + "12-Mostrar Conjunto de Elementos\n13-Mostrar Conjunto de Restricciones\n14-Guardar mi barrio\n"
                + "15-Insertar carretera\n16-Eliminar carretera\n0-Salir");
          n = getInt();
         }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
    private void cargarBarrio(){
        Scanner parametros = new Scanner(System.in);
        boolean aux;
        
        System.out.println("Barrio cargado correctamente");

        System.out.println("\nQue desea hacer:\n1-Añadir edificio a mi barrio\n2-Eliminar edificio de mi barrio\n"
            + "3-Añadir restriccion a mi barrio\n4-Eliminar restriccion de mi barrio\n5-Crear Elemento\n"
            + "6-Crear Restriccion\n7-Generar mi barrio\n8-Mostrar mi barrio\n9-Mostrar informacion del Barrio\n"
            + "10-Modificar Presupuesto del Barrio\n11-Modificar Poblacion del Barrio\n"
            + "12-Mostrar Conjunto de Elementos\n13-Mostrar Conjunto de Restricciones\n14-Guardar mi barrio\n"
            + "15-Insertar carretera\n16-Eliminar Carretera\n0-Salir");

        Scanner action = new Scanner(System.in);
        int n=getInt();
        boolean aux1;
        boolean generado = false;
        while(n!=0){
            String id;
            switch(n){

                case 1: listarElementos(CtrlBarrio.getTipoBarrio());
                        System.out.println("Escriba el nombre del elemento que desea añadir al barrio: ");
                        Scanner param = new Scanner(System.in);
                        id = param.nextLine();
                        System.out.println("Escriba la cantidad que quieres de este elemento en el barrio: ");
                        int cant = getInt();
                        try{
                            CtrlBarrio.anadirElemBarrio(id, cant);
                            System.out.println("Elemento añadido correctamente");
                        }catch(Exception e){
                            System.out.println("No se pudo añadir el elemento");
                            System.out.println(e.getMessage());
                        }
                        break;
                case 2: mostrarCjtElem();
                        System.out.println("Escriba el nombre del elemento que desea quitar del barrio: ");
                        Scanner param2 = new Scanner(System.in);
                        id = param2.nextLine();
                        System.out.println("Escriba la cantidad que quieres quitar de este elemento en el barrio: ");
                        cant = getInt();
                        try{
                            CtrlBarrio.quitarElemento(id, cant);
                            System.out.println("Elemento eliminado correctamente");
                        }catch(Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                case 3: listarRestricciones();
                        System.out.println("Escriba el nombre de restriccion que desea añadir al barrio: ");
                        Scanner param3 = new Scanner(System.in);
                        id = param3.nextLine();              
                        try{
                            CtrlBarrio.anadirRestBarrio(id);
                            System.out.println("Restriccion añadido correctamente");
                        }catch(Exception e){
                            System.out.println("No se pudo añadir la restriccion");
                            System.out.println(e.getMessage());
                        }
                        break;
                case 4: mostrarCjtRest();
                        System.out.println("Escriba el nombre de restriccion que desea quitar del barrio: ");
                        Scanner param4 = new Scanner(System.in);
                        id = param4.nextLine();               
                        try{
                            CtrlBarrio.quitarRestBarrio(id);
                            System.out.println("Restriccion eliminado correctamente");
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;
                case 5: crearElemento();
                        break;
                case 6: crearRestriccion();
                        break;
                case 7: System.out.println("\nDesea generar el barrio?\nLa distribucion actual se perderia, desea continuar?\n1-Si\n2-Volver");
                        int opc = getInt();
                        while(opc != 2){
                            switch(opc){
                                case 1: System.out.println("\nDesea comprobar la suficiencia de los Servicios Publicos?\n1-Si\n2-No");
                                    opc = getInt();
                                    while(opc!=1 && opc!=2){
                                        System.out.println("Opcio Invalida");
                                        opc = getInt();
                                    }
                                    boolean comp;
                                    if(opc==1)
                                        comp = true;
                                    else 
                                        comp = false;
                                    System.out.println("\nGENERANDO BARRIO...\n"
                                    + "Esta operacion puede tardar varios minutos.....");
                                    try{
                                        CtrlBarrio.generarBarrio(comp);
                                        System.out.println("El barrio se genero correctamente");
                                    }catch(Exception e){
                                        System.out.println(e.getMessage());
                                    }
                                    break;
                                default: System.out.println("Opcio Invalida");
                             }
                            if(!generado){ 
                                System.out.println("Desea generar el barrio?\n1-Si\n2-Volver");
                                opc = getInt();
                            }
                            else opc = 2;
                         }
                         break;
                case 8:  System.out.println("Mostrando barrio:");
                         mostrarBarrio();
                         break;
                case 9:  mostrarInfoBarrio();
                         break;
                case 10: System.out.println("Introduzca el presupuesto disponible para el barrio:");
                         System.out.println("Nota: Si no quiere limitar su barrio a un presupuesto, introduzca un 0,\n"
                         + "asi simplmente se le mostrara el presupuesto gastado como valor informativo");
                         int Presupuesto = getInt();
                         try{
                             CtrlBarrio.setPresupuestoBarrio(Presupuesto);
                             System.out.println("Presupuesto modificado correctamente");
                         }catch(Exception e){
                             System.out.println(e.getMessage());
                         }
                     break;
                case 11: System.out.println("Introduzca la poblacion del barrio:");
                         System.out.println("Nota: Si no quiere limitar el barrio a una poblacion, introduzca un 0\n"
                         + "asi simplemente se le mostrara la poblacion posible como valor informativo");
                         int Poblacion = getInt();
                         try{
                             CtrlBarrio.setPoblacionbarrio(Poblacion);
                             System.out.println("Poblacion modificada correctamente");
                         }catch(Exception e){
                             System.out.println(e.getMessage());
                         }
                         break;    


                case 12: mostrarCjtElem();
                         break;
                case 13: mostrarCjtRest();
                         break;
                case 14: System.out.println("Guardando barrio");
                         CtrlBarrio.guardarBarrio();
                         break;
                case 15: mostrarBarrio();
                         System.out.println("Inserte la fila donde quiere posicionar la carretera:");
                         Scanner param5 = new Scanner(System.in);
                         int f = getInt();
                         System.out.println("Inserte la columna donde quiere posicionar la carretera:");
                         int c = getInt();
                        try{
                            CtrlBarrio.insertarCarretera(f, c);
                            System.out.println("La carretera se ha insertado correctamente");
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;
                case 16: mostrarBarrio();
                         System.out.println("Inserte la fila de donde quiere eliminar la carretera:");
                         Scanner param6 = new Scanner(System.in);
                         f = getInt();
                         System.out.println("Inserte la columna de donde quiere eliminar la carretera:");
                         c = getInt();
                         try{
                            CtrlBarrio.eliminarCarretera(f, c);
                            System.out.println("La carretera se ha eliminado correctamente");
                         }catch(Exception e){
                            System.out.println(e.getMessage());
                         }
                        break;
                default: System.out.println("Opcio Invalida");    
            }
          System.out.println("\nQue desea hacer:\n1-Añadir edificio a mi barrio\n2-Eliminar edificio de mi barrio\n"
            + "3-Añadir restriccion a mi barrio\n4-Eliminar restriccion de mi barrio\n5-Crear Elemento\n"
            + "6-Crear Restriccion\n7-Generar mi barrio\n8-Mostrar mi barrio\n9-Mostrar informacion del Barrio\n"
            + "10-Modificar Presupuesto del Barrio\n11-Modificar Poblacion del Barrio\n"
            + "12-Mostrar Conjunto de Elementos\n13-Mostrar Conjunto de Restricciones\n14-Guardar mi barrio\n"
            + "15-Insertar carretera\n16-Eliminar carretera\n0-Salir");
          n = getInt();
     }        
        
        
        
        
    }
    
    
    private void crearBarrioDrag(){
        
        System.out.println("Crear barrio:");
        System.out.println("Introduzca el nombre del Barrio:");
        Scanner parametros = new Scanner(System.in);
        String nombre = parametros.nextLine();
        try{
            CtrlBarrio.crearBarrio(nombre, 0,1);
            System.out.println("Introduzca el presupuesto disponible para el barrio:");
            System.out.println("Nota: Si no quiere limitar su barrio a un presupuesto, introduzca un 0,\n"
                    + "asi simplmente se le mostrara el presupuesto gastado como valor informativo");
            int Presupuesto;
            boolean b=false;
            while(!b){
                Presupuesto = getInt();
                try{
                    CtrlBarrio.setPresupuestoBarrio(Presupuesto);
                    b = true;
                    System.out.println("Presupuesto modificado correctamente");
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("Introduzca la poblacion del barrio:");
            System.out.println("Nota: Si no quiere limitar el barrio a una poblacion, introduzca un 0\n"
                    + "asi simplemente se le mostrara la poblacion posible como valor informativo");
            int Poblacion;
            b=false;
            while(!b){
                Poblacion = getInt();
                try{
                    CtrlBarrio.setPoblacionbarrio(Poblacion);
                    b = true;
                    System.out.println("Poblacion modificada correctamente");
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
            int x,y;
            boolean b2=false;
            while(!b2){
                try{
                    System.out.println("Introduzca el numero de parcelas horizontales del barrio:");
                    x = getInt();
                    System.out.println("Introduzca el numero de parcelas verticales del barrio:");
                    y = getInt();
                    CtrlBarrio.crearMapaBarrio(x, y);
                    System.out.println("Mapa creado correctamente");
                    b2 = true;
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
             
             
             System.out.println("Barrio creado correctamente");
             System.out.println("\nQue desea hacer:\n1-Añadir edificio a mi barrio\n2-Eliminar edificio de mi barrio\n"
                 + "3-Crear Elemento\n4-Insertar carretera\n5-Eliminar carretera\n6-Mostrar mi barrio\n7-Mostrar informacion del Barrio\n"
                 + "8-Modificar Presupuesto del Barrio\n9-Modificar Poblacion del Barrio\n"
                 + "10-Mostrar Conjunto de Elementos\n11-Guardar mi barrio\n0-Salir");
             
             Scanner action = new Scanner(System.in);
             int n=getInt();
             Scanner param = new Scanner(System.in);
             while(n!=0){
                String id;
                switch(n){

                    case 1: listarElementos(CtrlBarrio.getTipoBarrio());
                            mostrarBarrio();
                            System.out.println("Escriba el nombre del elemento que desea añadir al barrio: ");
                            Scanner param2 = new Scanner(System.in);
                            id = param2.nextLine();
                            System.out.println("Escriba la fila donde quiere ubicar el Elemento:");
                            x = getInt();
                            System.out.println("Escriba la columna donde quiere ubicar el Elemento:");
                            y = getInt();
                            try{
                                CtrlBarrio.draguearElemBarrio(id, x, y);
                                System.out.println("\nEl elemento se ha añadido correctamente");
                            }catch(Exception e){
                                System.out.println(e.getMessage());
                            }
                            break;
                    case 2: mostrarCjtElem();
                            mostrarBarrio();
                            System.out.println("Escriba la fila donde se ubica el Elemento que desea retirar:");
                            x = getInt();
                            System.out.println("Escriba la columna donde se ubica el Elemento que desea retirar:");
                            y = getInt();
                            try{
                                CtrlBarrio.takearElemBarrio(x, y);
                                System.out.println("\nElemento eliminado correctamente");
                            }catch(Exception e){
                                System.out.println(e.getMessage());
                            }
                            break;
                    case 3: crearElemento();
                            break;
                    case 4: mostrarBarrio();
                            System.out.println("Inserte la fila donde quiere posicionar la carretera:");
                            Scanner param5 = new Scanner(System.in);
                            int f = getInt();
                            System.out.println("Inserte la columna donde quiere posicionar la carretera:");
                            int c = getInt();
                            try{
                                CtrlBarrio.insertarCarretera(f, c);
                                System.out.println("La carretera se ha insertado correctamente");
                            }catch(Exception e){
                                System.out.println(e.getMessage());
                            }
                            break;
                    case 5: mostrarBarrio();
                         System.out.println("Inserte la fila de donde quiere eliminar la carretera:");
                         Scanner param6 = new Scanner(System.in);
                         f = getInt();
                         System.out.println("Inserte la columna de donde quiere eliminar la carretera:");
                         c = getInt();
                         try{
                            CtrlBarrio.eliminarCarretera(f, c);
                            System.out.println("La carretera se ha eliminado correctamente");
                         }catch(Exception e){
                            System.out.println(e.getMessage());
                         }
                         break;
                   case 6:  System.out.println("Mostrando barrio:");
                            mostrarBarrio();
                            break;
                   case 7:  mostrarInfoBarrio();
                            break;
                   case 8:  System.out.println("Introduzca el presupuesto disponible para el barrio:");
                            System.out.println("Nota: Si no quiere limitar su barrio a un presupuesto, introduzca un 0,\n"
                            + "asi simplmente se le mostrara el presupuesto gastado como valor informativo");
                            Presupuesto = getInt();
                            try{
                                CtrlBarrio.setPresupuestoBarrio(Presupuesto);
                                System.out.println("Presupuesto modificado correctamente");
                            }catch(Exception e){
                                System.out.println(e.getMessage());
                            }
                            break;
                   case 9:  System.out.println("Introduzca la poblacion del barrio:");
                            System.out.println("Nota: Si no quiere limitar el barrio a una poblacion, introduzca un 0\n"
                            + "asi simplemente se le mostrara la poblacion posible como valor informativo");
                            Poblacion = getInt();
                            try{
                                CtrlBarrio.setPoblacionbarrio(Poblacion);
                                System.out.println("Poblacion modificada correctamente");
                            }catch(Exception e){
                                System.out.println(e.getMessage());
                            }
                            break;    
                    case 10: mostrarCjtElem();
                            break;
                    case 11: System.out.println("Guardando barrio");
                             CtrlBarrio.guardarBarrio();
                             break;
                    default: System.out.println("Opcio Invalida");    
                }
                System.out.println("\nQue desea hacer:\n1-Añadir edificio a mi barrio\n2-Eliminar edificio de mi barrio\n"
                 + "3-Crear Elemento\n4-Insertar carretera\n5-Eliminar carretera\n6-Mostrar mi barrio\n7-Mostrar informacion del Barrio\n"
                 + "8-Modificar Presupuesto del Barrio\n9-Modificar Poblacion del Barrio\n"
                 + "10-Mostrar Conjunto de Elementos\n11-Guardar mi barrio\n0-Salir");
                n=getInt();
             }
         }catch(Exception e){
             System.out.println(e.getMessage());
         }
    }
    
    
    private void cargarBarrioDrag(){
        Scanner parametros = new Scanner(System.in);
         
             
         System.out.println("Barrio cargado correctamente");
         System.out.println("\nQue desea hacer:\n1-Añadir edificio a mi barrio\n2-Eliminar edificio de mi barrio\n"
             + "3-Crear Elemento\n4-Insertar carretera\n5-Eliminar carretera\n6-Mostrar mi barrio\n7-Mostrar informacion del Barrio\n"
             + "8-Modificar Presupuesto del Barrio\n9-Modificar Poblacion del Barrio\n"
             + "10-Mostrar Conjunto de Elementos\n11-Guardar mi barrio\n0-Salir");

         Scanner action = new Scanner(System.in);
         int n=getInt();
         Scanner param = new Scanner(System.in);
         while(n!=0){
            String id;
            switch(n){

                case 1: listarElementos(CtrlBarrio.getTipoBarrio());
                        mostrarBarrio();
                        System.out.println("Escriba el nombre del elemento que desea añadir al barrio: ");
                        Scanner param2 = new Scanner(System.in);
                        id = param2.nextLine();
                        System.out.println("Escriba la fila donde quiere ubicar el Elemento:");
                        int x = getInt();
                        System.out.println("Escriba la columna donde quiere ubicar el Elemento:");
                        int y = getInt();
                        try{
                            CtrlBarrio.draguearElemBarrio(id, x, y);
                            System.out.println("\nEl elemento se ha añadido correctamente");
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;
                case 2: mostrarCjtElem();
                        mostrarBarrio();
                        System.out.println("Escriba la fila donde se ubica el Elemento que desea retirar:");
                        x = getInt();
                        System.out.println("Escriba la columna donde se ubica el Elemento que desea retirar:");
                        y = getInt();
                        try{
                            CtrlBarrio.takearElemBarrio(x, y);
                            System.out.println("\nElemento eliminado correctamente");
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;
                case 3: crearElemento();
                        break;
                case 4: mostrarBarrio();
                        System.out.println("Inserte la fila donde quiere posicionar la carretera:");
                        Scanner param5 = new Scanner(System.in);
                        int f = getInt();
                        System.out.println("Inserte la columna donde quiere posicionar la carretera:");
                        int c = getInt();
                        try{
                            CtrlBarrio.insertarCarretera(f, c);
                            System.out.println("La carretera se ha insertado correctamente");
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;
                case 5: mostrarBarrio();
                         System.out.println("Inserte la fila de donde quiere eliminar la carretera:");
                         Scanner param6 = new Scanner(System.in);
                         f = getInt();
                         System.out.println("Inserte la columna de donde quiere eliminar la carretera:");
                         c = getInt();
                         try{
                            CtrlBarrio.eliminarCarretera(f, c);
                            System.out.println("La carretera se ha eliminado correctamente");
                         }catch(Exception e){
                            System.out.println(e.getMessage());
                         }
                        break;
               case 6:  System.out.println("Mostrando barrio:");
                        mostrarBarrio();
                        break;
               case 7:  mostrarInfoBarrio();
                        break;
               case 8:  System.out.println("Introduzca el presupuesto disponible para el barrio:");
                        System.out.println("Nota: Si no quiere limitar su barrio a un presupuesto, introduzca un 0,\n"
                        + "asi simplmente se le mostrara el presupuesto gastado como valor informativo");
                        int Presupuesto = getInt();
                        try{
                            CtrlBarrio.setPresupuestoBarrio(Presupuesto);
                            System.out.println("Presupuesto modificado correctamente");
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;
               case 9:  System.out.println("Introduzca la poblacion del barrio:");
                        System.out.println("Nota: Si no quiere limitar el barrio a una poblacion, introduzca un 0\n"
                        + "asi simplemente se le mostrara la poblacion posible como valor informativo");
                        int Poblacion = getInt();
                        try{
                            CtrlBarrio.setPoblacionbarrio(Poblacion);
                            System.out.println("Poblacion modificada correctamente");
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;    
                case 10: mostrarCjtElem();
                        break;
                case 11: System.out.println("Guardando barrio");
                         CtrlBarrio.guardarBarrio();
                         break;
                default: System.out.println("Opcio Invalida");    
            }
            System.out.println("\nQue desea hacer:\n1-Añadir edificio a mi barrio\n2-Eliminar edificio de mi barrio\n"
             + "3-Crear Elemento\n4-Insertar carretera\n5-Eliminar carretera\n6-Mostrar mi barrio\n7-Mostrar informacion del Barrio\n"
             + "8-Modificar Presupuesto del Barrio\n9-Modificar Poblacion del Barrio\n"
             + "10-Mostrar Conjunto de Elementos\n11-Guardar mi barrio\n0-Salir");
            n=getInt();
         }
         
    }
    
    private boolean eliminarBarrio(){
        System.out.println("\nIntroduzca el nombre del Barrio que desea eliminar:");
        Scanner par = new Scanner(System.in);
        String nombre = par.nextLine();
        try{
            CtrlBarrio.eliminarBarrio(nombre);
            System.out.println("Se ha eliminado el Barrio correctamente\n");
        }catch(Exception e){
            System.out.println(e.getMessage());
            
        }
        return true;
    }
    
    
    
    
    private void gestionBarrios() throws Exception{
        System.out.println("Seccion destinada a la gestion de barrios");
        Scanner action = new Scanner(System.in);
        
        System.out.println("\nQue desea hacer:\n1-Crear Barrio\n2-Cargar Barrio\n3-Eliminar Barrio\n4-Mostrar Barrios Creados\n5-Salir");
        
        int n=getInt();
        
        while(n!=5){
            switch(n){
            
                case 1: System.out.println("\nQue modo desea utilizar en la creacion?\n"
                        + "nota: El modo no se puede modificar y ambos modos son incompatibles entre si\n"
                        + "Si se crea un barrio en un modo solo se puede cargar con ese mismo modo.\n"
                        + "1-Modo Generador\n2-Modo Drah&Drop\n");
                        int m = getInt();
                        switch(m){
                            case 1: crearBarrio();
                                    break;
                            case 2: crearBarrioDrag();
                                    break;
                            default: System.out.println("Opcio Invalida");
                        }
                        break;
                case 2: mostrarBarrios();
                        System.out.println("Introduzca el nombre del Barrio:");
                        System.out.println("nota: Los Barrios se cargan segun el modo con el cual fueron creados.");
                        Scanner parametros = new Scanner(System.in);
                        String nombre = parametros.nextLine();
                        
                        try{
                            m = CtrlBarrio.cargarBarrio(nombre);
                            switch(m){
                                case 0: cargarBarrio();
                                        break;
                                case 1: cargarBarrioDrag();
                                        break;
                                default: System.out.println("Modo Barrio Erroneo");
                            }
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;
                case 3: eliminarBarrio();
                        break;
                case 4: mostrarBarrios();
                        break;
                default: System.out.println("Opcio Invalida");    
            }
            System.out.println("\nQue desea hacer:\n1-Crear Barrio\n2-Cargar Barrio\n3-Eliminar Barrio\n4-Mostrar Barrios Creados\n5-Salir");
            n = getInt();
        }
    }

    
    //////////////MAIN PRINCIPAL///////////////////////////////////////
    public void mainLoop() throws IOException, FileNotFoundException, ClassNotFoundException, Exception{
        
        System.out.println("Bienvenido al generador de barrios UPCity!\nESPERE MIENTRAS SE CARGA EL SISTEMA...");
        
       
        
        CtrlBarrio = CtrlDomBarrios.getInstance();
        CtrlElem = CtrlDomElementos.getInstance();
        CtrlRest = CtrlDomRestricciones.getInstance();
        
        System.out.println("LISTO!\n");
        
        
        System.out.println("Que desea hacer:\n1-Gestion Barrios\n2-Gestion Elementos\n3-Gestion Restricciones\n4-Salir");
        
        Scanner action = new Scanner(System.in);
        
        int n=getInt();
        
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
            n = getInt();
        }
        ////////////////////////////////////////////////////////
        System.out.println("ADIOOOOOOS");
        
        //while(true);
        
    } 
    
    
}
