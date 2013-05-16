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
 * @author ivanmartinez y ron y Artem Cherkashin
 */
public class vistaComandos {
    
    private CtrlDomBarrios CtrlBarrio;
    private CtrlDomElementos CtrlElem;
    private CtrlDomRestricciones CtrlRest;
    
    
    /////////////////GESTION ELEMENTOS///////////////////////////
    private boolean crearElemento(){
        
        System.out.println("Que tipo de edificio desea crear:");
        System.out.println("1-Vivienda\n2-Publico\n3-Comercio\n4-Salir");
        int x;
        int y;
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
                        System.out.println("Indique el numero de parcelas del edificio en el eje X");
                        x = parametros.nextInt();
                        System.out.println("Indique el numero de parcelas del edificio en el eje Y");
                        y = parametros.nextInt();
                        
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
                        int TP = (int) parametros.nextInt();
                        System.out.println("Escriba la descripcion:");
                        String Desp = parametros.nextLine();
                        System.out.println("Elija a que tipo de barrio asociaria este elemento:");
                        System.out.println("0-Cualquiera\n1-Gama baja\n2-Gama media\n3-Gama alta");
                        int TBp = (int) parametros.nextInt();
                        System.out.println("Indique la cantidad de personas a las que puede ofrecer el servicio");
                        int cantperp = (int) parametros.nextInt();
                        System.out.println("Indique el precio de la construccion");
                        int preciop = parametros.nextInt();
                        System.out.println("Indique el numero de parcelas del edificio en el eje X");
                        x = parametros.nextInt();
                        System.out.println("Indique el numero de parcelas del edificio en el eje Y");
                        y = parametros.nextInt();
                        
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
                        int TBc = (int) parametros.nextInt();
                        System.out.println("Indique la cantidad de personas las que puede atender");
                        int cantperc = (int) parametros.nextInt();
                        System.out.println("Indique el precio del Comercio");
                        int precioc = parametros.nextInt();
                        System.out.println("Indique el numero de parcelas del edificio en el eje X");
                        x = parametros.nextInt();
                        System.out.println("Indique el numero de parcelas del edificio en el eje Y");
                        y = parametros.nextInt();
                        
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
            n = (int)action.nextInt();
        }
        
        
        return true;
    }
    
    private boolean eliminarElemento(){
        
        Scanner action = new Scanner(System.in);
        listarElementos(0);
        System.out.println("Escriba el nombre del elemento que desea eliminar:");
        String nombre = action.nextLine();
        return CtrlElem.EliminarElemento(nombre);
        
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
        
        int n=(int)action.nextInt();
        
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
                        String OID1 = parametros.nextLine();
                        System.out.println("Escriba el segundo elemento de restriccion");
                        String OID2 = parametros.nextLine();
                        System.out.println("Eliga la distancia de restriccion");
                        int distancia = (int) parametros.nextInt();
                        // para hacer id por ahora
                        System.out.println("Escriba el id de la restriccion");
                        Scanner idscann = new Scanner(System.in);
                        String id = idscann.nextLine();
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
                        System.out.println("Escriba el id de la restriccion");
                        Scanner idscann0 = new Scanner(System.in);
                        String id0 = idscann0.nextLine();
                        aux = CtrlRest.CrearRestriccion(id0, "economica", "-1", "-1", com, viv, pub);
                        if (aux) System.out.println("Creado correctamente");
                        else System.out.println("La restriccion no se pudo crear");
                        break;
                case 3: System.out.println("Escriba el elemento de restriccion");
                        String OID = parametros.nextLine();
                        System.out.println("Escriba la cantidad minima de habitantes");
                        int habitantes = (int) parametros.nextInt();
                        // para hacer id por ahora
                        System.out.println("Escriba el id de la restriccion");
                        Scanner idscann1 = new Scanner(System.in);
                        String id1 = idscann1.nextLine();
                        aux = CtrlRest.CrearRestriccion(id1, "demografica", OID, "-1", habitantes, -1, -1);
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
        boolean b;
        Scanner action = new Scanner(System.in);
        listarRestricciones();
        System.out.println("Escriba el nombre de la Restriccion que desea eliminar:");
        String nombre = action.nextLine();
        b = CtrlRest.Eliminar_Restriccion(nombre);
        if(b) System.out.println("Restriccion eliminada");
        else System.out.println("No se pudo eliminar restriccion");
        return b;
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
        
        System.out.println("\nQue desea hacer:\n1-Crear Restriccion\n2-Eliminar Restriccion\n3-Listar Restricciones\n4-Salir");
        
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
            System.out.println("\nQue desea hacer:\n1-Crear Restriccion\n2-Eliminar Restriccion\n3-Listar Restricciones\n4-Salir");
            n = (int)action.nextInt();
        }
    }
    ///////////////////////////////////////////////////
    
    ////////////////////////GESTION BARRIOS//////////////////////////////////////
    private boolean mostrarBarrio() throws Exception {
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
    
    
    private boolean crearBarrio() throws Exception{
        System.out.println("Crear barrio:");
        System.out.println("Introduzca el nombre del Barrio:");
        Scanner parametros = new Scanner(System.in);
        String nombre = parametros.nextLine();
        System.out.println("Introduzca el tipo de barrio:");
        System.out.println("(0-3)");
        int tipo = (int)parametros.nextInt();
        boolean aux = CtrlBarrio.crearBarrio(nombre, tipo);
        
        if(aux){
        
        System.out.println("Introduzca el numero de parcelas horizontales del barrio:");
        int x = (int)parametros.nextInt();
        System.out.println("Introduzca el numero de parcelas verticales del barrio:");
        int y = (int)parametros.nextInt();
        aux = CtrlBarrio.crearMapaBarrio(x, y);
        
        System.out.println("\nQue desea hacer:\n1-Añadir edificio a mi barrio\n2-Eliminar edificio de mi barrio\n"
                + "3-Añadir restriccion a mi barrio\n4-Eliminar restriccion de mi barrio\n5-Crear Elemento\n"
                + "6-Crear Restriccion\n7-Generar mi barrio\n8-Mostrar mi barrio\n9-Mostrar informacion del Barrio\n"
                + "10-Mostrar Conjunto de Elementos\n11-Mostrar Conjunto de Restricciones\n12-Guardar mi barrio\n13-Insertar carretera\n0-Salir");
        Scanner action = new Scanner(System.in);
        int n=(int)action.nextInt();
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
                        int cant = (int)action.nextInt();
                        aux1 = CtrlBarrio.anadirElemBarrio(id, cant);
                        if (aux1) System.out.println("Elemento añadido correctamente");
                        else System.out.println("No se pudo añadir el elemento");
                        break;
                case 2: mostrarCjtElem();
                        System.out.println("Escriba el nombre del elemento que desea quitar del barrio: ");
                        Scanner param2 = new Scanner(System.in);
                        id = param2.nextLine();
                        System.out.println("Escriba la cantidad que quieres quitar de este elemento en el barrio: ");
                        cant = (int)action.nextInt();
                        aux1 = CtrlBarrio.quitarElemento(id, cant);
                        if (aux1) System.out.println("Elemento eliminado correctamente");
                        else System.out.println("No se pudo eliminar el elemento");
                        break;
                case 3: listarRestricciones();
                        System.out.println("Escriba el nombre de restriccion que desea añadir al barrio: ");
                        Scanner param3 = new Scanner(System.in);
                        id = param3.nextLine();              
                        aux1 = CtrlBarrio.anadirRestBarrio(id);
                        if (aux1) System.out.println("Restriccion añadido correctamente");
                        else System.out.println("No se pudo añadir la restriccion");
                        break;
                case 4: mostrarCjtRest();
                        System.out.println("Escriba el nombre de restriccion que desea quitar del barrio: ");
                        Scanner param4 = new Scanner(System.in);
                        id = param4.nextLine();               
                        aux1 = CtrlBarrio.quitarRestBarrio(id);
                        if (aux1) System.out.println("Restriccion eliminado correctamente");
                        else System.out.println("No se pudo eliminar la restriccion");             
                        break;
                case 5: crearElemento();
                        break;
                case 6: crearRestriccion();
                        break;
                case 7: System.out.println("\nDesea generar el barrio?\nLa distribucion actual se perderia, desea continuar?\n1-Si\n2-Volver");
                        int opc = (int) action.nextInt();
                        while(opc != 2){
                            switch(opc){
                                case 1: System.out.println("\nGENERANDO BARRIO...\n"
                                        + "Esta operacion puede tardar varios minutos.....");
                                        generado = CtrlBarrio.generarBarrio();
                                        if (generado) System.out.println("El barrio se genero correctamente");
                                        else System.out.println("No se pudo generar el barrio");
                                        break;
                                default: System.out.println("Opcio Invalida");
                             }
                            if(!generado){ 
                                System.out.println("Desea generar el barrio?\n1-Si\n2-Volver");
                                opc = (int) action.nextInt();
                            }
                            else opc = 2;
                         }
                         break;
                case 8:  System.out.println("Mostrando barrio:");
                         mostrarBarrio();
                         break;
                case 9:  mostrarInfoBarrio();
                         break;
                case 10: mostrarCjtElem();
                         break;
                case 11: mostrarCjtRest();
                         break;
                case 12: System.out.println("Guardando barrio");
                         CtrlBarrio.guardarBarrio();
                         break;
                case 13: System.out.println("Inserte la fila donde quiere posicionar la carretera:");
                         Scanner param5 = new Scanner(System.in);
                         int f = param5.nextInt();
                         System.out.println("Inserte la columna donde quiere posicionar la carretera:");
                         int c = param5.nextInt();
                         boolean b =CtrlBarrio.insertarCarretera(f, c);
                         if(!b)System.out.println("No se pudo insertar la carretera en la posicion especificada");
                         break;
                default: System.out.println("Opcio Invalida");    
            }
          System.out.println("\nQue desea hacer:\n1-Añadir edificio a mi barrio\n2-Eliminar edificio de mi barrio\n"
                + "3-Añadir restriccion a mi barrio\n4-Eliminar restriccion de mi barrio\n5-Crear Elemento\n"
                + "6-Crear Restriccion\n7-Generar mi barrio\n8-Mostrar mi barrio\n9-Mostrar informacion del Barrio\n"
                + "10-Mostrar Conjunto de Elementos\n11-Mostrar Conjunto de Restricciones\n12-Guardar mi barrio\n13-Insertar carretera\n0-Salir");
          n = (int)action.nextInt();
         }
        }
        else System.out.println("No se ha podido crear Barrio");
        return true;
    }
    
    private boolean cargarBarrio()throws Exception{
        System.out.println("Introduzca el nombre del Barrio:");
        Scanner parametros = new Scanner(System.in);
        String nombre = parametros.nextLine();
        boolean aux = CtrlBarrio.cargarBarrio(nombre);
        if (aux) {
            System.out.println("Barrio cargado correctamente");
            
            System.out.println("\nQue desea hacer:\n1-Añadir edificio a mi barrio\n2-Eliminar edificio de mi barrio\n"
                + "3-Añadir restriccion a mi barrio\n4-Eliminar restriccion de mi barrio\n5-Crear Elemento\n"
                + "6-Crear Restriccion\n7-Generar mi barrio\n8-Mostrar mi barrio\n9-Mostrar informacion del Barrio\n"
                + "10-Mostrar Conjunto de Elementos\n11-Mostrar Conjunto de Restricciones\n12-Guardar mi barrio\n13-Insertar carretera\n0-Salir");
            Scanner action = new Scanner(System.in);
            int n=(int)action.nextInt();
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
                            int cant = (int)action.nextInt();
                            aux1 = CtrlBarrio.anadirElemBarrio(id, cant);
                            if (aux1) System.out.println("Elemento añadido correctamente");
                            else System.out.println("No se pudo añadir el elemento");
                            break;
                    case 2: mostrarCjtElem();
                            System.out.println("Escriba el nombre del elemento que desea quitar del barrio: ");
                            Scanner param2 = new Scanner(System.in);
                            id = param2.nextLine();
                            System.out.println("Escriba la cantidad que quieres quitar de este elemento en el barrio: ");
                            cant = (int)action.nextInt();
                            aux1 = CtrlBarrio.quitarElemento(id, cant);
                            if (aux1) System.out.println("Elemento eliminado correctamente");
                            else System.out.println("No se pudo eliminar el elemento");
                            break;
                    case 3: listarRestricciones();
                            System.out.println("Escriba el nombre de restriccion que desea añadir al barrio: ");
                            Scanner param3 = new Scanner(System.in);
                            id = param3.nextLine();              
                            aux1 = CtrlBarrio.anadirRestBarrio(id);
                            if (aux1) System.out.println("Restriccion añadido correctamente");
                            else System.out.println("No se pudo añadir la restriccion");
                            break;
                    case 4: mostrarCjtRest();
                            System.out.println("Escriba el nombre de restriccion que desea quitar del barrio: ");
                            Scanner param4 = new Scanner(System.in);
                            id = param4.nextLine();               
                            aux1 = CtrlBarrio.quitarRestBarrio(id);
                            if (aux1) System.out.println("Restriccion eliminado correctamente");
                            else System.out.println("No se pudo eliminar la restriccion");             
                            break;
                    case 5: crearElemento();
                            break;
                    case 6: crearRestriccion();
                            break;
                    case 7: System.out.println("\nDesea generar el barrio?\nLa distribucion actual se perderia, desea continuar?\n1-Si\n2-Volver");
                            int opc = (int) action.nextInt();
                            while(opc != 2){
                                switch(opc){
                                    case 1: System.out.println("\nGENERANDO BARRIO...\n"
                                            + "Esta operacion puede tardar varios minutos.....");
                                            generado = CtrlBarrio.generarBarrio();
                                            if (generado) System.out.println("El barrio se genero correctamente");
                                            else System.out.println("No se pudo generar el barrio");
                                            break;
                                    default: System.out.println("Opcio Invalida");
                                 }
                                if(!generado){ 
                                    System.out.println("Desea generar el barrio?\n1-Si\n2-Volver");
                                    opc = (int) action.nextInt();
                                }
                                else opc = 2;
                             }
                             break;
                    case 8:  System.out.println("Mostrando barrio:");
                             mostrarBarrio();
                             break;
                    case 9:  mostrarInfoBarrio();
                             break;
                    case 10: mostrarCjtElem();
                             break;
                    case 11: mostrarCjtRest();
                             break;
                    case 12: System.out.println("Guardando barrio");
                             CtrlBarrio.guardarBarrio();
                             break;
                    case 13: System.out.println("Inserte la fila donde quiere posicionar la carretera:");
                             Scanner param5 = new Scanner(System.in);
                             int f = param5.nextInt();
                             System.out.println("Inserte la columna donde quiere posicionar la carretera:");
                             int c = param5.nextInt();
                             boolean b =CtrlBarrio.insertarCarretera(f, c);
                             if(!b)System.out.println("No se pudo insertar la carretera en la posicion especificada");
                             break;
                    default: System.out.println("Opcio Invalida");    
                }
              System.out.println("\nQue desea hacer:\n1-Añadir edificio a mi barrio\n2-Eliminar edificio de mi barrio\n"
                    + "3-Añadir restriccion a mi barrio\n4-Eliminar restriccion de mi barrio\n5-Crear Elemento\n"
                    + "6-Crear Restriccion\n7-Generar mi barrio\n8-Mostrar mi barrio\n9-Mostrar informacion del Barrio\n"
                    + "10-Mostrar Conjunto de Elementos\n11-Mostrar Conjunto de Restricciones\n12-Guardar mi barrio\n13-Insertar carretera\n0-Salir");
              n = (int)action.nextInt();
         }        
        
        }
        else System.out.println("No se encuentra el barrio");
        
        return aux;
    }
    
    private boolean modificarBarrio(){
        return false;
    }
    
    private boolean eliminarBarrio(){
        return false;
    }
    
    
    
    
    private void gestionBarrios() throws Exception{
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
        CtrlRest = CtrlDomRestricciones.getInstance();
        
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
