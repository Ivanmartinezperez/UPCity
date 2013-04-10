/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Auxiliares.*;
import elementos.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapa.*;


/**
 *
 * @author ivanmartinez
 */
public class Tests {
    
    public  void main(String arg[]){
        try {
            Viviendas a = new Viviendas(1);
            Comercio b = new Comercio(2);
            Publico c = new Publico (3);
        
            Cjt_Elementos cjt = new Cjt_Elementos();
        
            Pair p1 = new Pair(1,a);
            Pair p2 = new Pair(5,b);
            Pair p3 = new Pair(2,c);
            
            Parcela par1 = new Parcela(1,7);
    
            Parcela par2 = new Parcela(1,0);
            
            cjt.insertar_elementos(1, p1);
            cjt.insertar_elementos(2, p2);
            cjt.insertar_elementos(3, p3);
            Plano map;
            try {
                map = new Plano(8,8);
                 for(int i=0;i<map.tama();++i){
                    for(int j=0;j<map.tamb();++j){
                    if(j==0) map.modifica(i, j, par2);
                    else map.modifica(i, j, par1);
                }
                    backtracking(cjt,map);
            }
            } catch (Exception ex) {
                Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
            }
           
         
            
            a.setDescrpcio("Soy una Vivienda");
            b.setDescrpcio("Soy un Comercio");
            c.setDescrpcio("Soy uno publico");
            
            while(!cjt.isEmpty()){
                Elemento w = (Elemento) cjt.primer_elemento().getSecond();
                System.out.println(w.getId()+" "+w.getDescripcio());
            }
        } catch (Exception ex) {
            Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        public Pair troba_buida(Plano map){
        try {
            for(int i=0;i<map.tama();++i)
                for(int j=0;j<map.tamb();++j){
                    if(map.pos(i, j).getoid()==0){
                        Pair p = new Pair(i,j);
                        return p;
                    }
                }
            return null;
        } catch (Exception ex) {
            Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        }
        
        private Plano backtracking(Cjt_Elementos cjt,Plano map){
        
                if(cjt.isEmpty()) return map;
                
                int x;
                int y;
                
                Pair p = troba_buida(map);
                
                x = (int)p.getFirst();
                y=(int) p.getSecond();
               
                map.modifica(x, y, new Parcela(1,(int)((Elemento)cjt.primer_elemento().getSecond()).getId()));
                return backtracking(cjt,map);
                    
         }
}

    