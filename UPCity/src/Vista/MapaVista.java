/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.*;


/**
 *
 * @author daniel
 */
public class MapaVista extends javax.swing.JPanel {
    private ImageIcon agua, tocado;
    private boolean tipoTablero;
    private Casilla [][] casillas ;
    private int tamx, tamy, tamc;
    boolean cuadrado;
        
    public MapaVista() {
        initComponents();

    }

    public MapaVista(int x,  int y, boolean tipo) {
        if(x == y) {
            cuadrado = true;
            tamx = x;
            tamc = x;
            tamy = x;
        }
        else {
            tamx = x;
            tamy = y;
            cuadrado = false;
            if(x > y) tamc = x;
            else tamc = tamy;
        }
        initComponents();
        setLayout(new java.awt.GridLayout(tamx, tamy));
        this.tipoTablero = tipo;
        agua = new ImageIcon("src/imatges/casa.jpg");
        tocado = new ImageIcon("src/imatges/comercio.jpg");
        if(cuadrado == true) casillas = new Casilla[tamc][tamc];
        else casillas = new Casilla[tamx][tamy];
        for (int i = 0; i < tamx; i++){
            for (int j = 0; j < tamy; j++){
                casillas[i][j] = new Casilla(this); 
                casillas[i][j].setFondo(agua);
                x = (i * 1000/tamc)+1;
                y = (j * 700/tamc)+1;
                casillas[i][j].setBounds(x, y, (1000/tamc)-2, (700/tamc)-2);
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
                              
    private void initComponents() {

        setLayout(null);

        setBackground(new java.awt.Color(0, 0, 0));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setPreferredSize(new java.awt.Dimension(1000, 700));
    }                      
                     
}
