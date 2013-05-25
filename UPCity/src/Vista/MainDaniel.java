/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Vista.MapaVista;

/**
 *
 * @author DanielSans
 */
public class MainDaniel extends javax.swing.JFrame {
    
    public MainDaniel() {
        initComponents();
    }
                          
    private void initComponents() {
        String[][] mapa = new String[8][6];
        for(int i = 0; i < 8; ++i){
            for(int j = 0; j < 6; ++j) {
                if(i%2 == 0)mapa[i][j] = "0";
                else mapa[i][j] = "1";
            }
        }
        mapa[0][0] = "20";
        mapa[1][1] = "21";
        mapa[2][2] = "22";
        mapa[3][3] = "23";
        mapa[4][4] = "24";
        tableroGUI1 = new MapaVista(8, 6 ,true);
        tableroGUI1.leerMapa(mapa);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        javax.swing.GroupLayout tableroGUI1Layout = new javax.swing.GroupLayout(tableroGUI1);
        tableroGUI1.setLayout(tableroGUI1Layout);
        tableroGUI1Layout.setHorizontalGroup(
            tableroGUI1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        tableroGUI1Layout.setVerticalGroup(
            tableroGUI1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableroGUI1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(175, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tableroGUI1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainDaniel().setVisible(true);
            }
        });
    }
                        
    private MapaVista tableroGUI1;                
    
}
