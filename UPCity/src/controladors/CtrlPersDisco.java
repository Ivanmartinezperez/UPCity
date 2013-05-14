/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladors;

import java.io.*;
import java.util.ArrayList;


/**
 *
 * @author ArclorenSarth
 */
public class CtrlPersDisco {
    
    private static CtrlPersDisco INSTANCE = null;
    
    
    /**
     * Creadora por defecto. Se encarga de crear la carpeta de los datos 
     * persistentes en el directorio del programa, llamada Data, en el caso de 
     * de que no exista.
     */
    private CtrlPersDisco() {
        File Data = new File("./Data");
        if (!Data.exists()) {
            Data.mkdirs();
        }
    }
    
    private static void creaInstancia() {
        if (INSTANCE == null) {
            INSTANCE = new CtrlPersDisco();
        }
    }

    public static CtrlPersDisco getInstance() {
        if (INSTANCE == null) {
            creaInstancia();
        }
        return INSTANCE;
    }

    
    /**
     * Crea un archivo .txt dentro de la carpeta Data con el nombre nombre.
     * @param nombre Nombre del archivo que se desea crear.
     */
    public void crearArchivo(String nombre){
        File arch = new File("./Data/" + nombre + ".o");
        if(!arch.exists()){
            try{
                arch.createNewFile();
            } catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    
    
    
   /* public int numArxius() {
        return (int) new File("./Data/").length();
    }

    
    public ArrayList llistaDirectori(String paraula) {
        File f = new File("./Data/");
        int numArxius = f.list().length;
        String llistaArxius[] = f.list(); // llista amb els noms de tots els arxius
        ArrayList llista = new ArrayList();

        for (int i = 0; i < numArxius; ++i) {
            if (llistaArxius[i].contains(paraula)) {
                llista.add(llistaArxius[i]);
            }
        }

        return llista;
    }
    */
    
    
    /**
     * Lectora de un archivo del disco. La funcion lee linia a linia el archivo
     * con el nombre nombre y añade todas las linias leidas a un ArrayList.
     * @param nombre Nombre del archivo que se quiere leer.
     * @return Retorna un ArrayList de todas las linias leidas del archivo.
     */
    public ArrayList<String> leerArchivo(String nombre) {
        ArrayList<String> datos = new ArrayList();
        try {
            FileReader fr = new FileReader("./Data/" + nombre + ".o");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null){  
                datos.add(line);
            }
            fr.close();          
        } catch (FileNotFoundException ex) {
            crearArchivo(nombre);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return datos;
    }
    
    
    /**
     * Escritora de un archivo del disco. La funcion escribe en el archivo con
     * el nombre nombre, linia a linea, el contenido del ArrayList datos.
     * @param nombre Nombre del archivo sobre el que se quiere escribir.
     * @param datos ArrayList con los datos que se quieren escribir.
     */
    public void escribirArchivo(String nombre, ArrayList<String> datos) {
        try {
            FileWriter fw = new FileWriter("./Data/" + nombre + ".o");
            PrintWriter pw = new PrintWriter(fw);
            for(int i=0; i<datos.size(); ++i){ 
                pw.println(datos.get(i));
            }
            fw.close();           
        } catch (FileNotFoundException ex) {
            crearArchivo(nombre);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
}
