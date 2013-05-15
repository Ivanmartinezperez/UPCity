/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

import java.io.Serializable;

/**
 *
 * @author Pinkii
 */
public abstract class  Elemento implements Serializable{
    /*Declaracion de Variables */
    private int id;
    private String nom;
    private String descripcio;
    
    
    /*
     * Creadora por defecto
     * Pre : Ident es un int valido
     * Post: Crea un objeto Elemento con id inicializado
     */
    Elemento(int ident){
        id = ident;
    }
    
    /*
     * Creadora con parametros
     * Pre : Ident es un int valido y nombre un string valido
     * Post: Crea un objeto Elemento con id y nom inicializados
     */
    Elemento(int ident, String nombre) {
        id = ident;
        nom = nombre;
    }
    
    /*
     * Consultoras
     */
    
    /* 
     * Consultora de ID
     * Pre : id no nulo.
     * Post: Devuelve la Id del objeto
     */
    
    public int getId() {
        return this.id;
    }
    
    /* 
     * Consultora de Nom
     * Pre : nom no nulo.
     * Post: Devuelve el nom del objeto
     */
    
    public String getNom() {
        return this.nom;
    }
    
    /* 
     * Consultora de Descripcio
     * Pre : descripcio no nulo.
     * Post: Devuelve la descripcio del objeto
     */
    
    public String getDescripcio() {
        return this.descripcio;
    }
    
    /* 
     * Modificadoras
     */
    
    /*
     * Modificadora de id
     * Pre : ident es un int valido
     * Post: Modifica la id del objeto por ident
     */
    
    public void setId(int ident) {
        this.id = ident;
    }
    
    /*
     * Modificadora de nom
     * Pre : nombre es un string valido
     * Post: Modifica el nom del objeto por nombre
     */
    
    public void setNom(String nombre) {
        this.nom = nombre;
    }
    
    /*
     * Modificadora de descripcio
     * Pre : desc es un string valido
     * Post: modifica la descripcio del objeto por desc
     */
    
    public void setDescrpcio(String desc){
        this.descripcio = desc;
    }
    
    
}
