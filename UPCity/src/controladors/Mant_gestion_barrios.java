/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladors;

/**
 *
 * @author arclorensarth
 */
public class Mant_gestion_barrios {
    VistaMenuMantBarrios VMMB;
    VistaMantBarrios VMB;
    CDMantBarrios CDMB;
    
    public Mant_gestion_barrios() {
        int OP;
        VMMB = new VistaMenuMantBarrios();
        VMMB.visualizar();
        OP = VMMB.preguntar("Elige la opcion que desea?");
        
        while(OP != 0) {
            switch(OP) {
                case 1: alta();
                        break;
                case 2: baja();
                        break;
                case 3: modificacion();
                        break;
                case 4: consulta();
                        break;
            }
            VMMB.visualizar();
            OP = VMMB.preguntar("Elige la opcion que desea?");
        }
    }
    
    
    private void alta(){
        
    }
    
    
    private void baja(){
        
    }
    
    
    private void modificacion(){
        
    }
    
    
    private void consulta(){
        
    }
}
