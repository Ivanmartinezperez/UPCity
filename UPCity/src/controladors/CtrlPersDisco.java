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
        File Data = new File("./Data/Barrios/");
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
                System.out.println("\nDATA CORRUPTED!!!");
                System.out.println(ex.getMessage() + "\n");
            }
        }
    }
    
    
    /**
     * Esta funcion lista los directorios y archivos que contiene el directorio
     * representado por el path que llega por parametro.
     * @param path Path del directorio del cual queremos listar el contenido.
     * @return Retorna un Array de Strings con los nombres de los archivos o 
     * directorios que contiene el directorio que listamos.
     */
    public String[] listarDirectorio(String path) {
        File f = new File(path);
        return f.list(); 
    }
    
    
    /**
     * Esta funcion elimina el directorio representado por el path que le llega
     * como parametro.
     * @param path Path del directorio que queremos eliminar.
     * @return Retorna si se ha podido o no eliminar el directorio.
     */
    public boolean eliminarDirectorio(String path) {
        File f = new File(path);
        
        if (f.exists()){
            File f2;
            String[] files = f.list();
            for(int i = 0; i<files.length; ++i){
                f2 = new File(path + files[i]);
                f2.delete();
            }
            f.delete();
            return true;
        }
        else return false;
    }
    
    
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
            System.out.println("\nDATA CORRUPTED!!!");
            System.out.println(ex.getMessage() + "\n");
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
            System.out.println("\nDATA CORRUPTED!!!");
            System.out.println(ex.getMessage() + "\n");
        }
        
    }
    
    public void escribirObjeto (String path, String nom, Object ob) /*throws FileNotFoundException, IOException*/ {
        File f = new File("./Data/Barrios/" + path);
        if (!f.exists()) {
            f.mkdirs();
        }
        f = new File("./Data/Barrios/" + path + nom + ".o");
        try{
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ob);
            oos.close();
        }catch(Exception e){
            System.out.println("\nDATA CORRUPTED!!!");
            System.out.println(e.getMessage() + "\n");
        }
    }
    
    
    public Object leerObjeto (String path, String nom) /*throws FileNotFoundException, IOException*/ {
        Object ob = null;
        File f = new File("./Data/Barrios/" + path + nom + ".o");
        try{//FileWriter fw = new FileWriter(f);
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ob = ois.readObject();
	    ois.close();
        } catch(Exception e){
            System.out.println("\nDATA CORRUPTED!!!");
            System.out.println(e.getMessage() + "\n");
        }
        return ob;
	}
}