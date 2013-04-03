/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa;


/**
 *
 * @author ivanmartinez
 */
public class Plano {
    private Parcela[][]mat;

    //Creadora de Plano. Crea un plano de axa.
    public Plano(int a, int b) throws Exception {
        mat = new Parcela[a][b];
    }
    
    public int tama() throws Exception {
        return mat.length;
    }
    
    public int tamb() throws Exception {
        return mat[0].length;
    }
    
    public Parcela pos(int x, int y) {
        return mat[x][y];
    }

    public void modifica (int x, int y, Parcela p) {
        mat[x][y] = p;
    }
    
    public void copia(Plano p) throws Exception {
       	int n = p.tama();
        int m = p.tamb();
	mat = new Parcela[n][n];
	for(int i = 0;i < n; ++i) {
		for(int j = 0; j < m; ++j) {
			mat[i][j] = p.pos(i, j);
		}
	}
    }
}
