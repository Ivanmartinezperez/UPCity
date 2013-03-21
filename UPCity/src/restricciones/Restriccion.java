/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restricciones;

import elementos.Cjt_Elementos;

/**
 *
 * @author Gotha229
 */
public abstract class Restriccion {
    /* Declaración de variables */
    private String id;
    private String typeSU;
    /* End Variables */
   
    /*Creadora por defecto
     * Pre : -
     * Post : Crea un objeto Restriction vacio
     */
    Restriccion(){
        
    }
    /*Creadora con parametros
     * Pre : identificador y tipoSU son String validos
     * Post : Crea un objeto Restriction con valores
     */
    Restriccion(String identificador, String tipoSU){
        id = identificador;
        typeSU = tipoSU;
    }
    /*Getter del ID
     * Pre : -
     * Post : Devuelve el identificador del objeto deseado
     */
    public String getId(){
        return id;
    }
    /*Getter del tipo
     * Pre : - 
     * Post : Devuelve si la restriccion es del tipo Sistema / Usuario
     */
    public String getTypeSU(){
        return typeSU;
    }
    
    /*Setter del Tipo
     * Pre : String type es un tipo valido "S/U"
     * Post : Modifica el valor del atributo typeSU del objeto indicado
     */
    public void setTypeSU(String type){
        typeSU = type;
    }
    
    abstract boolean checkRestriction(Cjt_Elementos cE);
    
    
}
