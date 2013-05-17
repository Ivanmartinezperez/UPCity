/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa;

import Auxiliares.Pair;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import restricciones.*;


/**
 *
 * @author danielsans
 */
public class Plano implements Serializable{
    private Parcela[][]mat;

    /**
     * Creadora de plano. Crea un plano sin inicializar la matriz.(OJO)
     */
    public Plano() {
        
    }
    
    /**
     * Creadora de plano. Crea un plano identico a p.
     * @param p
     * @throws Exception 
     */
    public Plano(Plano p){
        int n = p.tama();
        int m = p.tamb();
	mat = new Parcela[n][m];
	for(int i = 0;i < n; ++i) {
		for(int j = 0; j < m; ++j) {
			mat[i][j] = new Parcela(p.pos(i, j));
		}
	}
        
    }
    
    /**
     * Creadora de Plano. Crea un plano de axb dimensiones.
     * @param a
     * @param b
     * @throws Exception 
     */
    public Plano(int a, int b) {
        mat = new Parcela[a][b];
        for(int i = 0; i < a; ++i) {
            for(int j = 0; j < b; ++j) {
                mat[i][j] = new Parcela();
            }
        }
    }
    
    /**
     * Consultora del tamano de las filas
     * @return in con el tamano
     * @throws Exception 
     */
    public int tama() {
        return mat.length;
    }
    
    /**
     * consultora del tamano de las columnas
     * @return int con el tamano
     * @throws Exception 
     */
    public int tamb(){
        return mat[0].length;
    }
    
    /**
     * consultora de una posicion del plano
     * @param x
     * @param y
     * @return la parcela en la posicion [x][y]
     */
    public Parcela pos(int x, int y) {
        return mat[x][y];
    }
    
    /**
     * Funcion para saber si una parcela esta fuera de la matriz.
     * @param x
     * @param y
     * @return si es false, esta fuera, si es true esta dentro de la matriz
     */
    private boolean limite(int x, int y) {
        if (x < 0 || x >= mat.length) return false;
        if (y < 0 || y >= mat[0].length) return false;
        return true;
    }
 
     /**
     * Esta funcion Expande el elemento oid, junto con su lista de restricciones.
     * Tambien modifica esa parcela con el oid.
     * PRE: El elemento oid cabe y puede estar en la posicion X Y
     * PRE: tama > 0 i tamb > 0
     * @param x pos x del elemento oid
     * @param y pos y del elemento oid
     * @param tama tamaño de la x
     * @param tamb tamaño de la y
     * @param oid id del elemento a insertar en xy, y del que se expandiran sus restr.
     * @param lista es una lista con Pair, donde el first es OID i el second es distancia.
     * @param exp True = expandir. False = desexpande.
     */
    public void expande(int x, int y, int tama, int tamb, int oid, ArrayList<Restriccion_ubicacion> restricciones, boolean exp) {
            Queue<Pair <Integer, Integer> > cola;
            cola = new LinkedList <Pair<Integer, Integer> >();
            Pair<Integer, Integer> par;
            //par = new Pair<Integer,Integer> (x, y);
            Pair<Integer, Integer>[][] visitats = new Pair[mat.length][mat[0].length];
            for(int i = 0; i < mat.length;++i) {
                for(int j = 0; j < mat[0].length; ++j) {
                    visitats[i][j] = new Pair<Integer, Integer>(0,0);
                }
            }
            //System.out.println("MODIFICANDO MAPA");
            for(int i = 0; i < tama; ++i){
                for(int j = 0; j < tamb; ++j){
                    //System.out.println(""+(x+i)+" "+(y+j));
                    if(exp == true) mat[x+i][y+j].modificarPar(oid, 1);
                    else mat[x+i][y+j].modificarPar(0, 1);
                    par = new Pair<Integer,Integer> (x+i, y+j);
                    visitats[x+i][y+j].setFirst(1);
                    visitats[x+i][y+j].setSecond(0);
                    cola.add(par);
                    
                }
            }
        if(restricciones !=null){
            while(cola.isEmpty() == false) {
                par = cola.poll();
                int a = par.getFirst();
                int b = par.getSecond();
                int dist = visitats[a][b].getSecond();
                //System.out.print(restricciones.size());
                for (int z = 0; z < restricciones.size(); ++z) {
                    Restriccion_ubicacion aux = (Restriccion_ubicacion) restricciones.get(z);
                    int bb = aux.consultar_distancia();
                    if(bb >= dist) {
                            if(exp == true) mat[a][b].anadirRestriccion(aux.consultar_OID2());
                            else mat[a][b].quitarRestriccion(aux.consultar_OID2());
                    }
                }
                //visitats[a][b].setFirst(1);//marco la posicion como visitada.
                if(restricciones.isEmpty() == false) {
                    if(limite(a-1, b-1) == true && visitats[a-1][b-1].getFirst() == 0) {
                        par = new Pair<Integer, Integer>(a-1, b-1);
                        //System.out.println(par.getFirst()+" "+par.getSecond());
                        cola.add(par);
                        visitats[a-1][b-1].setSecond(dist+1);
                        visitats[a-1][b-1].setFirst(1);
                    }
                    if(limite(a-1, b) == true && visitats[a-1][b].getFirst() == 0) {
                        par = new Pair<Integer, Integer>(a-1, b);
                       // System.out.println(par.getFirst()+" "+par.getSecond());
                        cola.add(par);
                        visitats[a-1][b].setSecond(dist+1);
                        visitats[a-1][b].setFirst(1);
                    }
                    if(limite(a-1, b+1) == true && visitats[a-1][b+1].getFirst() == 0) {
                        par = new Pair<Integer, Integer>(a-1, b+1);
                       // System.out.println(par.getFirst()+" "+par.getSecond());
                        cola.add(par);
                        visitats[a-1][b+1].setSecond(dist+1);
                        visitats[a-1][b+1].setFirst(1);
                    }
                    if(limite(a, b-1) == true && visitats[a][b-1].getFirst() == 0) {
                        par = new Pair<Integer, Integer>(a, b-1);
                       // System.out.println(par.getFirst()+" "+par.getSecond());
                        cola.add(par);
                        visitats[a][b-1].setSecond(dist+1);
                        visitats[a][b-1].setFirst(1);
                    }
                    if(limite(a, b+1) == true && visitats[a][b+1].getFirst() == 0) {
                        par = new Pair<Integer, Integer>(a, b+1);
                      //  System.out.println(par.getFirst()+" "+par.getSecond());
                        cola.add(par);
                        visitats[a][b+1].setSecond(dist+1);
                        visitats[a][b+1].setFirst(1);
                    }
                    if(limite(a+1, b-1) == true && visitats[a+1][b-1].getFirst() == 0) {
                        par = new Pair<Integer, Integer>(a+1, b-1);
                      //  System.out.println(par.getFirst()+" "+par.getSecond());
                        cola.add(par);
                        visitats[a+1][b-1].setSecond(dist+1);
                        visitats[a+1][b-1].setFirst(1);
                    }
                    if(limite(a+1, b) == true && visitats[a+1][b].getFirst() == 0) {
                        par = new Pair<Integer, Integer>(a+1, b);
                       // System.out.println(par.getFirst()+" "+par.getSecond());
                        cola.add(par);
                        visitats[a+1][b].setSecond(dist+1);
                        visitats[a+1][b].setFirst(1);
                    }
                    if(limite(a+1, b+1) == true && visitats[a+1][b+1].getFirst() == 0) {
                        par = new Pair<Integer, Integer>(a+1, b+1);
                      //  System.out.println(par.getFirst()+" "+par.getSecond());
                        cola.add(par);
                        visitats[a+1][b+1].setSecond(dist+1);
                        visitats[a+1][b+1].setFirst(1);
                    }
                }
            }
        }
    }
    
    
    
    /*
    public void expande(int x, int y, int oid, ArrayList<Restriccion_ubicacion> restricciones, boolean exp) {
       // int contador = 0;
        mat[x][y].modificarPar(oid, 1);
        if(restricciones!=null){
        Queue<Pair <Integer, Integer> > cola;
        cola = new LinkedList <Pair<Integer, Integer> >();
        Pair<Integer, Integer> par;
        par = new Pair<Integer,Integer> (x, y);
        cola.add(par);
        Pair<Integer, Integer>[][] visitats = new Pair[mat.length][mat[0].length];
        for(int i = 0; i < mat.length;++i) {
            for(int j = 0; j < mat[0].length; ++j) {
                visitats[i][j] = new Pair<Integer, Integer>(0,0);
            }
        }
        visitats[x][y].setSecond(0);
        while(cola.isEmpty() == false) {
            par = cola.poll();
            int a = par.getFirst();
            int b = par.getSecond();
            int dist = visitats[a][b].getSecond();
            //System.out.print(restricciones.size());
            for (int z = 0; z < restricciones.size(); ++z) {
                Restriccion_ubicacion aux = (Restriccion_ubicacion) restricciones.get(z);
                int bb = aux.consultar_distancia();
                if(bb >= dist) {
                        if(exp == true) mat[a][b].anadirRestriccion(aux.consultar_OID2());
                        else mat[a][b].quitarRestriccion(aux.consultar_OID2());
                }
            }
            visitats[a][b].setFirst(1);//marco la posicion como visitada.
            if(restricciones.isEmpty() == false) {
                if(limite(a-1, b-1) == true && visitats[a-1][b-1].getFirst() == 0) {
                    par = new Pair<Integer, Integer>(a-1, b-1);
                    //System.out.println(par.getFirst()+" "+par.getSecond());
                    cola.add(par);
                    visitats[a-1][b-1].setSecond(dist+1);
                    visitats[a-1][b-1].setFirst(1);
                }
                if(limite(a-1, b) == true && visitats[a-1][b].getFirst() == 0) {
                    par = new Pair<Integer, Integer>(a-1, b);
                   // System.out.println(par.getFirst()+" "+par.getSecond());
                    cola.add(par);
                    visitats[a-1][b].setSecond(dist+1);
                    visitats[a-1][b].setFirst(1);
                }
                if(limite(a-1, b+1) == true && visitats[a-1][b+1].getFirst() == 0) {
                    par = new Pair<Integer, Integer>(a-1, b+1);
                   // System.out.println(par.getFirst()+" "+par.getSecond());
                    cola.add(par);
                    visitats[a-1][b+1].setSecond(dist+1);
                    visitats[a-1][b+1].setFirst(1);
                }
                if(limite(a, b-1) == true && visitats[a][b-1].getFirst() == 0) {
                    par = new Pair<Integer, Integer>(a, b-1);
                   // System.out.println(par.getFirst()+" "+par.getSecond());
                    cola.add(par);
                    visitats[a][b-1].setSecond(dist+1);
                    visitats[a][b-1].setFirst(1);
                }
                if(limite(a, b+1) == true && visitats[a][b+1].getFirst() == 0) {
                    par = new Pair<Integer, Integer>(a, b+1);
                  //  System.out.println(par.getFirst()+" "+par.getSecond());
                    cola.add(par);
                    visitats[a][b+1].setSecond(dist+1);
                    visitats[a][b+1].setFirst(1);
                }
                if(limite(a+1, b-1) == true && visitats[a+1][b-1].getFirst() == 0) {
                    par = new Pair<Integer, Integer>(a+1, b-1);
                  //  System.out.println(par.getFirst()+" "+par.getSecond());
                    cola.add(par);
                    visitats[a+1][b-1].setSecond(dist+1);
                    visitats[a+1][b-1].setFirst(1);
                }
                if(limite(a+1, b) == true && visitats[a+1][b].getFirst() == 0) {
                    par = new Pair<Integer, Integer>(a+1, b);
                   // System.out.println(par.getFirst()+" "+par.getSecond());
                    cola.add(par);
                    visitats[a+1][b].setSecond(dist+1);
                    visitats[a+1][b].setFirst(1);
                }
                if(limite(a+1, b+1) == true && visitats[a+1][b+1].getFirst() == 0) {
                    par = new Pair<Integer, Integer>(a+1, b+1);
                  //  System.out.println(par.getFirst()+" "+par.getSecond());
                    cola.add(par);
                    visitats[a+1][b+1].setSecond(dist+1);
                    visitats[a+1][b+1].setFirst(1);
                }
            }
        }
      }
      //  System.out.println("contador: "+contador);
    }*/
        
    
    /**
     * consulta si un elemento id puede ir en la posicion [x][y]
     * @param id
     * @param x
     * @param y
     * @return si es false puede ir. si vale true, el elemento id no puede ir.
     */
    public boolean consultaPar(int id, int x, int y) {
        return ((mat[x][y].getoid() != 0) || (mat[x][y].buscaRestriccion(id)));
    }
     /**
      * copia un plano.
      * @param p
      * @throws Exception 
      */
    public void copia(Plano p) {
       	int n = p.tama();
        int m = p.tamb();
	mat = new Parcela[n][m];
	for(int i = 0;i < n; ++i) {
		for(int j = 0; j < m; ++j) {
			mat[i][j] = new Parcela(p.pos(i, j));
		}
	}
    }
}