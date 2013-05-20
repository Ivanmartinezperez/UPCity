package Vista;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import controladors.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ivanmartinez
 */
public class vistaGrafica extends JFrame {
    
    private DefaultTableModel tablaVivienda;
    private DefaultTableModel tablaPublico;
    private DefaultTableModel tablaComercio;
    private DefaultTableModel tablaUbic;
    private DefaultTableModel tablaDem;
    private DefaultTableModel tablaEco;
    private DefaultTableModel tablaViviendaUser;
    private DefaultTableModel tablaPublicoUser;
    private DefaultTableModel tablaComercioUser;
    private DefaultTableModel tablaUbicUser;
    private DefaultTableModel tablaDemUser;
    private DefaultTableModel tablaEcoUser;
    private int indiceV;
    private int indiceC;
    private int indiceP;
    private CtrlDomBarrios CtrlBarrio;
    private CtrlDomElementos CtrlElem;
    private CtrlDomRestricciones CtrlRest;
        

    /**
     * Creates new form vistaGrafica
     */
    public vistaGrafica() {
        CtrlBarrio = CtrlDomBarrios.getInstance();
        CtrlElem = CtrlDomElementos.getInstance();
        CtrlRest = CtrlDomRestricciones.getInstance();
        initComponents();
        jToolBar1.setFloatable(false);
        setResizable(false);
        Console.setText("Cargando el Sistema...\n");
        initViviendas();
        initPublicos();
        initComercios();
        tabViv.setModel(tablaVivienda);
        tabPub.setModel(tablaPublico);
        tabCom.setModel(tablaComercio);
        Console.setText("Bienvenido a UPcity\n");
        
    }
    
    private void initViviendas(){
        tablaVivienda=new DefaultTableModel();
        tablaVivienda.addColumn("Nombre");
        tablaVivienda.addColumn("TBar");
        tablaVivienda.addColumn("Precio");
        tablaVivienda.addColumn("Capacidad");
        tablaVivienda.addColumn("TamX");
        tablaVivienda.addColumn("TamY");
        tablaVivienda.setNumRows(50);
        
        String[][] viv1;
        for(int j=0;j<=3;++j){
            viv1 = CtrlElem.listarElemTipo(j, 1);
            if(viv1!=null){
                for(int i=0;i<viv1.length;++i){
                    tablaVivienda.setValueAt(viv1[i][0], i, 0);
                    tablaVivienda.setValueAt(viv1[i][1], i, 1);
                    tablaVivienda.setValueAt(viv1[i][2], i, 2);
                    tablaVivienda.setValueAt(viv1[i][3], i, 3);
                    tablaVivienda.setValueAt(viv1[i][4], i, 4);
                    tablaVivienda.setValueAt(viv1[i][5], i, 5);
                }
                indiceV+=viv1.length;
            }
        }   
    }
    
    private void initPublicos(){
        tablaPublico=new DefaultTableModel();
        tablaPublico.addColumn("Nombre");
        tablaPublico.addColumn("TBar");
        tablaPublico.addColumn("Precio");
        tablaPublico.addColumn("TipoPub");
        tablaPublico.addColumn("Capacidad");
        tablaPublico.addColumn("TamX");
        tablaPublico.addColumn("TamY");
        tablaPublico.setNumRows(50);
        String[][] viv1;
        for(int j=0;j<=3;++j){
            viv1 = CtrlElem.listarElemTipo(j, 2);
            if(viv1!=null){
                for(int i=0;i<viv1.length;++i){
                    tablaPublico.setValueAt(viv1[i][0], i, 0);
                    tablaPublico.setValueAt(viv1[i][1], i, 1);
                    tablaPublico.setValueAt(viv1[i][2], i, 2);
                    tablaPublico.setValueAt(viv1[i][3], i, 3);
                    tablaPublico.setValueAt(viv1[i][4], i, 4);
                    tablaPublico.setValueAt(viv1[i][5], i, 5);
                    tablaPublico.setValueAt(viv1[i][6], i, 6);
                }
                indiceP+=viv1.length;
            }
        }
        
    }
    
    private void initComercios(){
        tablaComercio=new DefaultTableModel();
        tablaComercio.addColumn("Nombre");
        tablaComercio.addColumn("TBar");
        tablaComercio.addColumn("Precio");
        tablaComercio.addColumn("Capacidad");
        tablaComercio.addColumn("TamX");
        tablaComercio.addColumn("TamY");
        tablaComercio.setNumRows(50);
        String[][] viv1;
        for(int j=0;j<=3;++j){
            viv1 = CtrlElem.listarElemTipo(j, 3);
            if(viv1!=null){
                for(int i=0;i<viv1.length;++i){
                    tablaComercio.setValueAt(viv1[i][0], i, 0);
                    tablaComercio.setValueAt(viv1[i][1], i, 1);
                    tablaComercio.setValueAt(viv1[i][2], i, 2);
                    tablaComercio.setValueAt(viv1[i][3], i, 3);
                    tablaComercio.setValueAt(viv1[i][4], i, 4);
                    tablaComercio.setValueAt(viv1[i][5], i, 5);
                }
                indiceC+=viv1.length;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jToolBar1 = new javax.swing.JToolBar();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(12, 0), new java.awt.Dimension(14, 0), new java.awt.Dimension(9, 32767));
        addElem = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        ScrollsysRest = new javax.swing.JScrollPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        elemSisTab = new javax.swing.JTabbedPane();
        jScrollPane15 = new javax.swing.JScrollPane();
        tabViv = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabPub = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabCom = new javax.swing.JTable();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jSplitPane3 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        Console = new javax.swing.JTextPane();
        viewBarrio = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jSplitPane4 = new javax.swing.JSplitPane();
        ScrollsysRest1 = new javax.swing.JScrollPane();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        jTabbedPane7 = new javax.swing.JTabbedPane();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable11 = new javax.swing.JTable();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTable12 = new javax.swing.JTable();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 3), new java.awt.Dimension(0, 3), new java.awt.Dimension(32767, 3));
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        newBar = new javax.swing.JMenuItem();
        modBar = new javax.swing.JMenuItem();
        Eliminar_barrio = new javax.swing.JMenuItem();
        newElem = new javax.swing.JMenu();
        CreaElem = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        newRes = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1115, 625));

        jToolBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.gray));
        jToolBar1.setForeground(new java.awt.Color(51, 51, 51));
        jToolBar1.setRollover(true);
        jToolBar1.add(filler3);

        addElem.setText("+E");
        addElem.setFocusable(false);
        addElem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addElem.setMaximumSize(new java.awt.Dimension(57, 18));
        addElem.setMinimumSize(new java.awt.Dimension(57, 18));
        addElem.setPreferredSize(new java.awt.Dimension(57, 18));
        addElem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addElem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anadirElemento(evt);
            }
        });
        jToolBar1.add(addElem);

        jButton2.setText("-E");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setMaximumSize(new java.awt.Dimension(57, 18));
        jButton2.setMinimumSize(new java.awt.Dimension(57, 18));
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);

        jButton3.setText("+R");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setMaximumSize(new java.awt.Dimension(57, 18));
        jButton3.setMinimumSize(new java.awt.Dimension(57, 18));
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton3);

        jButton4.setText("-R");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setMaximumSize(new java.awt.Dimension(57, 18));
        jButton4.setMinimumSize(new java.awt.Dimension(57, 18));
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton4);

        jButton5.setText("+C");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setMaximumSize(new java.awt.Dimension(57, 18));
        jButton5.setMinimumSize(new java.awt.Dimension(57, 18));
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton5);

        jButton6.setText("-C");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setMaximumSize(new java.awt.Dimension(57, 18));
        jButton6.setMinimumSize(new java.awt.Dimension(57, 18));
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton6);

        jButton7.setText("Info barrio");
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton7);

        jButton8.setText("jButton8");
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton8);

        jButton9.setText("jButton9");
        jButton9.setFocusable(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton9);

        jButton10.setText("jButton10");
        jButton10.setFocusable(false);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton10);

        jSplitPane1.setDividerLocation(292);
        jSplitPane1.setDividerSize(2);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setMinimumSize(new java.awt.Dimension(125, 125));

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 100, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(33, 33, 33)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(39, 39, 39)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab1", jPanel1);

        ScrollsysRest.setViewportView(jTabbedPane2);

        jSplitPane1.setRightComponent(ScrollsysRest);

        tabViv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabViv.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane15.setViewportView(tabViv);

        elemSisTab.addTab("VIV", jScrollPane15);

        tabPub.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabPub.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(tabPub);

        elemSisTab.addTab("PUB", jScrollPane2);

        tabCom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabCom.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabCom.setAutoscrolls(false);
        jScrollPane3.setViewportView(tabCom);

        elemSisTab.addTab("COM", jScrollPane3);

        jSplitPane1.setTopComponent(elemSisTab);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Edificio 1", "Edificio 2", "Distancia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane5.setViewportView(jTable1);

        jTabbedPane4.addTab("UBI", jScrollPane5);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre", "Poblacion Minima"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(jTable2);

        jTabbedPane4.addTab("DEM", jScrollPane6);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "P.V", "P.P", "P.C"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane7.setViewportView(jTable3);

        jTabbedPane4.addTab("ECO", jScrollPane7);

        jSplitPane1.setRightComponent(jTabbedPane4);

        jLayeredPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 3, true));

        jSplitPane3.setDividerLocation(450);
        jSplitPane3.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        Console.setEditable(false);
        jScrollPane1.setViewportView(Console);

        jSplitPane3.setBottomComponent(jScrollPane1);

        jScrollPane14.setViewportView(jTextPane1);

        org.jdesktop.layout.GroupLayout viewBarrioLayout = new org.jdesktop.layout.GroupLayout(viewBarrio);
        viewBarrio.setLayout(viewBarrioLayout);
        viewBarrioLayout.setHorizontalGroup(
            viewBarrioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, viewBarrioLayout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane14, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                .addContainerGap())
        );
        viewBarrioLayout.setVerticalGroup(
            viewBarrioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, viewBarrioLayout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane14, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane3.setLeftComponent(viewBarrio);

        jSplitPane3.setBounds(4, 3, 600, 550);
        jLayeredPane1.add(jSplitPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jSplitPane4.setDividerLocation(292);
        jSplitPane4.setDividerSize(2);
        jSplitPane4.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane4.setMinimumSize(new java.awt.Dimension(125, 125));

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 100, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(33, 33, 33)
                .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(39, 39, 39)
                .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("tab1", jPanel3);

        ScrollsysRest1.setViewportView(jTabbedPane5);

        jSplitPane4.setRightComponent(ScrollsysRest1);

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Precio", "Nº H Max", "Tipo Barrio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable7.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane8.setViewportView(jTable7);

        jTabbedPane6.addTab("VIV", jScrollPane8);

        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable8.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane9.setViewportView(jTable8);

        jTabbedPane6.addTab("PUB", jScrollPane9);

        jTable9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Precio", "Nº H Max", "Tipo Barrio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable9.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane10.setViewportView(jTable9);

        jTabbedPane6.addTab("COM", jScrollPane10);

        jSplitPane4.setTopComponent(jTabbedPane6);

        jTable10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Edificio 1", "Edificio 2", "Distancia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable10.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane11.setViewportView(jTable10);

        jTabbedPane7.addTab("UBI", jScrollPane11);

        jTable11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre", "Poblacion Minima"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane12.setViewportView(jTable11);

        jTabbedPane7.addTab("DEM", jScrollPane12);

        jTable12.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "P.V", "P.P", "P.C"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable12.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane13.setViewportView(jTable12);

        jTabbedPane7.addTab("ECO", jScrollPane13);

        jSplitPane4.setRightComponent(jTabbedPane7);

        jMenu1.setText("Barrios");

        newBar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newBar.setText("Crear Barrio");
        newBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBarActionPerformed(evt);
            }
        });
        jMenu1.add(newBar);

        modBar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        modBar.setText("Modificar Barrio");
        modBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modBarActionPerformed(evt);
            }
        });
        jMenu1.add(modBar);

        Eliminar_barrio.setText("Eliminar Barrio");
        Eliminar_barrio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Eliminar_barrioActionPerformed(evt);
            }
        });
        jMenu1.add(Eliminar_barrio);

        jMenuBar1.add(jMenu1);

        newElem.setText("Elementos");

        CreaElem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        CreaElem.setText("Nuevo Elemento");
        CreaElem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreaElemActionPerformed(evt);
            }
        });
        newElem.add(CreaElem);

        jMenuItem1.setText("Eliminar Elemento");
        newElem.add(jMenuItem1);

        jMenuBar1.add(newElem);

        newRes.setText("Restricciones");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Nueva Restriccion");
        newRes.add(jMenuItem4);

        jMenuItem2.setText("Eliminar Restriccion");
        newRes.add(jMenuItem2);

        jMenuBar1.add(newRes);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jSplitPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 240, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jLayeredPane1)
                            .add(jToolBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 611, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jSplitPane4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 240, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(492, 492, 492)
                        .add(filler1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(layout.createSequentialGroup()
                        .add(jToolBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLayeredPane1))
                    .add(jSplitPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 590, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jSplitPane4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 590, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(filler1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newBarActionPerformed

    private void modBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modBarActionPerformed

    private void CreaElemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreaElemActionPerformed
        formNewElem formulario = new formNewElem(this,true);
        formulario.setVisible(true);
        boolean b;
        if(formulario.aceptado()){
            String nombre = formulario.getNombre();
            String des = formulario.getDesc();
            int TE = formulario.getTE();
            int TB = formulario.getTB();
            int x = formulario.get_X();
            int y = formulario.get_Y();
            int precio = formulario.getPrecio();
            int capacidad = formulario.getCapacidad();
            if(TE==1){
                try {
                    b = CtrlElem.CrearElemento(nombre, des, TE, TB, x, y, precio, capacidad,0);
                    if(b){
                        tabViv.setValueAt(nombre, indiceP, 0);
                        tabViv.setValueAt(TB, indiceP, 1);
                        tabViv.setValueAt(precio, indiceP, 2);
                        tabViv.setValueAt(capacidad, indiceP, 3);
                        tabViv.setValueAt(x, indiceP, 4);
                        tabViv.setValueAt(y, indiceP, 5);
                        ++indiceV;
                    }
                } catch (Exception ex) {
                    Logger.getLogger(vistaGrafica.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(TE==2){
                int TEP = formulario.tipoDePublico();
                try {
                    b = CtrlElem.CrearElemento(nombre, des, TE, TB, x, y, precio, capacidad, TEP);
                    if(b){
                        tabPub.setValueAt(nombre, indiceP, 0);
                        tabPub.setValueAt(TB, indiceP, 1);
                        tabPub.setValueAt(precio, indiceP, 2);
                        tabPub.setValueAt(TEP, indiceP, 3);
                        tabPub.setValueAt(capacidad, indiceP, 4);
                        tabPub.setValueAt(x, indiceP, 5);
                        tabPub.setValueAt(y, indiceP, 6);
                        ++indiceP;
                    }
                } catch (Exception ex) {
                    Logger.getLogger(vistaGrafica.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(TE==3){
                try {
                    b = CtrlElem.CrearElemento(nombre, des, TE, TB, x, y, precio, capacidad,0);
                    if(b){
                        tabCom.setValueAt(nombre, indiceP, 0);
                        tabCom.setValueAt(TB, indiceP, 1);
                        tabCom.setValueAt(precio, indiceP, 2);
                        tabCom.setValueAt(capacidad, indiceP, 3);
                        tabCom.setValueAt(x, indiceP, 4);
                        tabCom.setValueAt(y, indiceP, 5);
                        ++indiceC;
                    }
                } catch (Exception ex) {
                    Logger.getLogger(vistaGrafica.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
           
        }
    }//GEN-LAST:event_CreaElemActionPerformed

    private void Eliminar_barrioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Eliminar_barrioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Eliminar_barrioActionPerformed

    private void anadirElemento(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anadirElemento
          addElemBar formulario = new addElemBar(this,true);
          if(formulario.Aceptado()){
                String id = formulario.getNombre();
                int cant = formulario.getCantidad();
            try{
                CtrlBarrio.anadirElemBarrio(id, cant);
                System.out.println("Elemento añadido correctamente");
            }catch(Exception e){
                System.out.println("No se pudo añadir el elemento");
                System.out.println(e.getMessage());
            }
          }
    }//GEN-LAST:event_anadirElemento

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vistaGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaGrafica().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane Console;
    private javax.swing.JMenuItem CreaElem;
    private javax.swing.JMenuItem Eliminar_barrio;
    private javax.swing.JScrollPane ScrollsysRest;
    private javax.swing.JScrollPane ScrollsysRest1;
    private javax.swing.JButton addElem;
    private javax.swing.JTabbedPane elemSisTab;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JSplitPane jSplitPane4;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JTabbedPane jTabbedPane7;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable10;
    private javax.swing.JTable jTable11;
    private javax.swing.JTable jTable12;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem modBar;
    private javax.swing.JMenuItem newBar;
    private javax.swing.JMenu newElem;
    private javax.swing.JMenu newRes;
    private javax.swing.JTable tabCom;
    private javax.swing.JTable tabPub;
    private javax.swing.JTable tabViv;
    private javax.swing.JPanel viewBarrio;
    // End of variables declaration//GEN-END:variables
}
