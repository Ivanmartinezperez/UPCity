/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.*;
import mapa.Plano;


/**
 *
 * @author daniel
 */
public class MapaVista extends javax.swing.JPanel {
    private ImageIcon agua, tocado;
    private boolean tipoTablero;
    private Casilla [][] casillas ;
    private int tamx, tamy, tamcx, tamcy;
    boolean cuadrado;
        
    public MapaVista() {
        initComponents();

    }

    public MapaVista(int x,  int y, boolean tipo) {
        if(x == y) {
            cuadrado = true;
            tamx = x;
            tamcx = 700/x;
            tamcy = 700/x;
            tamy = x;
            casillas = new Casilla[x][x];
        }
        else {
            tamx = x;
            tamy = y;
            cuadrado = false;
            if(x > y) {
                tamcx = x;
                tamcy = y;
            }
            else {
                tamcy = x;
                tamcx = y;
            }
            tamcx = 1000/tamcx;
            tamcy = 700/tamcy;
            casillas = new Casilla[tamcx][tamcy];
        }
        initComponents();
        setLayout(new java.awt.GridLayout(tamx, tamy));
        this.tipoTablero = tipo;
        agua = new ImageIcon("src/imatges/casa.jpg");
        tocado = new ImageIcon("src/imatges/comercio.jpg");
        for (int i = 0; i < tamx; i++){
            for (int j = 0; j < tamy; j++){
                casillas[i][j] = new Casilla(this); 
                casillas[i][j].setFondo(agua);
                x = (i * tamcx)+1;
                y = (j * tamcy)+1;
                casillas[i][j].setBounds(x, y, (tamcx)-2, (tamcy)-2);
                this.add(casillas[i][j]);
            }
        }
    }
    
    public boolean getTipoTablero(){
        return this.isTipoTablero();
    }
    
    public void pintar(int x, int y){
        this.casillas[x][y].setFondo(tocado);
        this.repaint();
    }

    public int[] getCoordenadas(Casilla casilla) {
        int [] coordenadas = new int[2];
        for (int i=0; i < this.casillas.length; i++) {
            for (int j=0; j < this.casillas.length; j++) {
                if (this.casillas[i][j] == casilla) {
                    coordenadas[0] = i;
                    coordenadas[1] = j;
                }
            }
        }
        return coordenadas;
    }
    
    public Casilla[][] getCasillas() {
        return casillas;
    }
    
    public void setCasillas(Casilla[][] casillas) {
        this.casillas = casillas;
    }
    
    public boolean isTipoTablero() {
        return tipoTablero;
    }    
    public void setTipoTablero(boolean tipoTablero) {
        this.tipoTablero = tipoTablero;
    }
    
    public void leerMapa(Plano p){
        for(int i = 0; i < tamx; ++i) {
            for(int j = 0; j < tamy; ++j) {
                
            }
        }
    }
                              
    private void initComponents() {

        setLayout(null);

        setBackground(new java.awt.Color(0, 0, 0));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        if(tamx == tamy) setPreferredSize(new java.awt.Dimension(700, 700));
        else setPreferredSize(new java.awt.Dimension(1000, 700));
    }                      
                     
}
