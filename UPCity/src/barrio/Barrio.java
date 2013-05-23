/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package barrio;

import Auxiliares.Pair;
import java.io.Serializable;
import java.util.ArrayList;





/**
 *
 * @author ArclorenSarth
 */
public class Barrio implements Serializable{
    private String Nombre;
    private int TipoBarrio;
    private int Presupuesto;
    private int Poblacion;
    private int Gastado;
    private int Gastado_Viv;
    private int Gastado_Pub;
    private int Gastado_Com;
    private int Viviendo;
    private int CapSanidad;
    private int CapEducacion;
    private int CapSeguridad;
    private int CapComunicacion;
    private int CapOcio;
    private int Capacidad_comercio;
    private int PresAnterior;
    
    private ArrayList<Pair<Integer,Integer>> posiciones;
    private int Modo;
    
  
    /////CREADORAS/////
    
    public Barrio(){
        TipoBarrio = 0;
        Presupuesto = 0;
        Poblacion = 0;
        Gastado = 0;
        Gastado_Viv = 0;
        Gastado_Pub = 0;
        Gastado_Com = 0;
        Viviendo = 0;
        CapSanidad = 0;
        CapEducacion = 0;
        CapSeguridad = 0;
        CapComunicacion = 0;
        CapOcio = 0;
        Capacidad_comercio = 0;
        PresAnterior = 0;
        posiciones = new ArrayList();
        Modo = 0;
    }
    
    
    public Barrio(String nombre,int tipo){
        Nombre = nombre;
        TipoBarrio = tipo;
        Presupuesto = 0;
        Poblacion = 0;
        Gastado = 0;
        Gastado_Viv = 0;
        Gastado_Pub = 0;
        Gastado_Com = 0;
        Viviendo = 0;
        CapSanidad = 0;
        CapEducacion = 0;
        CapSeguridad = 0;
        CapComunicacion = 0;
        CapOcio = 0;
        Capacidad_comercio = 0;
        PresAnterior = 0;
        posiciones = new ArrayList();
        Modo = 0;
    }
      
    
    /////MODIFICADORAS/////
    
    public void setNombreBarrio(String n){
        Nombre = n;
    }
    
    public void setTipoBarrio(int t){
        TipoBarrio = t;
    }
    
    public void setPresupuesto(int pres){
        PresAnterior = Presupuesto;
        Presupuesto = pres;
    }
    
    public void setPoblacion(int pob){
        Poblacion = pob;
    }
    
    public void anadirGasto(int gasto){
        Gastado = Gastado + gasto;
    }
    
    public void anadirGastoViv(int gasto){
        Gastado_Viv = Gastado_Viv + gasto;
    }
    
    public void anadirGastoPub(int gasto){
        Gastado_Pub = Gastado_Pub + gasto;
    }
    
    public void anadirGastoCom(int gasto){
        Gastado_Com = Gastado_Com + gasto;
    }
    
    public void anadirHabitantes(int hab){
        Viviendo = Viviendo + hab;
    }
    
    public void anadirSanidad(int gasto){
        CapSanidad = CapSanidad + gasto;
    }
    
    public void anadirEducacion(int gasto){
        CapEducacion = CapEducacion + gasto;
    }
    
    public void anadirSeguridad(int gasto){
        CapSeguridad = CapSeguridad + gasto;
    }
    
    public void anadirComunicacion(int gasto){
        CapComunicacion = CapComunicacion + gasto;
    }
    
    public void anadirOcio(int gasto){
        CapOcio = CapOcio + gasto;
    }
    
    public void anadirComercio(int C){
        Capacidad_comercio = Capacidad_comercio + C;
    }
    
    public void volverPresAnterior(){
        Presupuesto = PresAnterior;
    }
    
    //0-Modo Generador, 1-Modo Drag&Drop//
    public void setModo(int m){
        Modo = m;
    }
    
    public void setPosiciones(ArrayList<Pair<Integer,Integer>> pos){
        posiciones = pos;
    }
    
    
    
    /////CONSULTORAS/////
    
    public String getNombreBarrio(){
        return Nombre;
    }
    
    public int getTipoBarrio(){
        return TipoBarrio;
    }
    
    public int getPresupuesto(){
        return Presupuesto;
    }
    
    public int getPoblacion(){
        return Poblacion;
    }
    
    public int getGastado(){
        return Gastado;
    }
    
    public int getGastadoViv(){
        return Gastado_Viv;
    }
    
    public int getGastadoPub(){
        return Gastado_Pub;
    }
    
    public int getGastadoCom(){
        return Gastado_Com;
    }
    
    public int getViviendo(){
        return Viviendo;
    }
    
    public int getCapSanidadCom(){
        return CapSanidad;
    }
    
    public int getCapEducacion(){
        return CapEducacion;
    }
    
    public int getCapSeguridad(){
        return CapSeguridad;
    }
    
    public int getCapComunicacion(){
        return CapComunicacion;
    }
    
    public int getCapOcio(){
        return CapOcio;
    }
    
    public int getCapacidad_comercio(){
        return Capacidad_comercio;
    }
    
    public int getModo(){
        return Modo;
    }
    
    public ArrayList<Pair<Integer,Integer>> getPosiciones(){
        return posiciones;
    }
    
}
