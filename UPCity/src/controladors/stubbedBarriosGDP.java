/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladors;

/**
 *
 * @author ArclorenSarth
 */
public class stubbedBarriosGDP {
    
    private static stubbedBarriosGDP INSTANCE = null;
   
    public stubbedBarriosGDP(){
        
    }
    
    private synchronized static void creaInstancia() {
        if (INSTANCE == null) {
            INSTANCE = new stubbedBarriosGDP();
        }
    }

    public static stubbedBarriosGDP getInstance() {
        if (INSTANCE == null) {
            creaInstancia();
        }
        return INSTANCE;
    }
    
}
