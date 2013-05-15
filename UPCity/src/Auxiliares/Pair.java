/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Auxiliares;

import java.io.Serializable;

/**
 *
 * @author ivanmartinez
 */
public class Pair<A,B> implements Serializable{
    private A first;
    private B second;
    
    public Pair(A a, B b){
        this.first = a;
        this.second = b;
    }
    
  public A getFirst() { return first; }
  public B getSecond() { return second; }
 
  public void setFirst(A v) { first = v; }
  public void setSecond(B v) { second = v; }
    
}
