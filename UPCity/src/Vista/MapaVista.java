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
    private boolean tipoTablero;
    private Casilla [][] casillas ;
    private int tamx, tamy, tamcx, tamcy;
    private boolean cuadrado, inverso;
    private ImageIcon[] imagenespre;
    private ImageIcon[] imagenesusu;
    private ImageIcon calle;
        
    public MapaVista() {
        initComponents();

    }

    public MapaVista(int x,  int y, boolean tipo) {
        inverso = false;
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
            if(tamx < tamy) {
                inverso = true;
                int aux = tamx;
                tamx = tamy;
                tamy = aux;
            }
            tamcx = 1000/tamcx;
            tamcy = 700/tamcy;
            casillas = new Casilla[tamx][tamy];
        }
        initComponents();
        setLayout(new java.awt.GridLayout(tamx, tamy));
        this.tipoTablero = tipo;
        calle = new ImageIcon("src/imatges/calle.jpg");
        imagenespre = new ImageIcon[10];
        imagenesusu = new ImageIcon[10];
        imagenespre[0] = new ImageIcon("src/imatges/casa.jpg");
        imagenespre[1] = new ImageIcon("src/imatges/comercio.jpg");
        imagenespre[2] = new ImageIcon("src/imatges/Hospital_Final.jpg");
        imagenespre[3] = new ImageIcon("src/imatges/Police.jpg");
        imagenespre[4] = new ImageIcon("src/imatges/firestation.jpg");
        imagenespre[5] = new ImageIcon("src/imatges/school.jpg");
        imagenespre[6] = new ImageIcon("src/imatges/uni.jpg");
        imagenesusu[0] = new ImageIcon("src/imatges/1.jpg");
        imagenesusu[1] = new ImageIcon("src/imatges/2.jpg");
        imagenesusu[2] = new ImageIcon("src/imatges/3.jpg");
        imagenesusu[3] = new ImageIcon("src/imatges/4.jpg");
        imagenesusu[4] = new ImageIcon("src/imatges/5.jpg");
        
        for (int i = 0; i < tamx; i++){
            for (int j = 0; j < tamy; j++){
                casillas[i][j] = new Casilla(this); 
                casillas[i][j].setFondo(calle);
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
        this.casillas[x][y].setFondo(imagenesusu[1]);
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
    
    public void leerMapa(String[][] mapa){
        for(int i = 0; i < tamx; ++i) {
            for(int j = 0; j < tamy; ++j) {
                int aux = 0;
                if(inverso == true) {
                    aux = Integer.parseInt(mapa[j][i]);
                }
                else aux = Integer.parseInt(mapa[i][j]);
                if(aux == -1)  casillas[i][j].setFondo(calle);
                else if(aux < 20) {
                    casillas[i][j].setFondo(imagenespre[aux]);
                }
                else {
                    aux = aux%20;
                    casillas[i][j].setFondo(imagenesusu[aux]);
                }
            }
        }
        this.repaint();
    }
                              
    private void initComponents() {

        setLayout(null);

        setBackground(new java.awt.Color(0, 0, 0));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        if(tamx == tamy) setPreferredSize(new java.awt.Dimension(700, 700));
        else setPreferredSize(new java.awt.Dimension(1000, 700));
    }                      
                     
}
