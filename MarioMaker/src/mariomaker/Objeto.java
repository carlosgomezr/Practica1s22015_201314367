/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariomaker;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Carlos Gomez
 */
public class Objeto extends Thread{
    public JLabel ob;
    int posx=0;
    Raiz matriz;
    int fila;
    int columna;
    int sentido =0;
    int gravedad =0;
    
    Thread t = new Thread();
    public Objeto(JLabel etiqueta,Raiz matriz,int fila, int columna){
        this.ob = etiqueta;
        this.matriz = matriz;
      
    }
    public void run(){
       
        while(true){
         try {
                   Personaje p;
                   columna = (ob.getX())/50;
                   fila = (ob.getY()-340)/(-50);
                   p = matriz.getPersonaje(fila, columna);
                   
                   if(p.tipo.compareTo("personaje")==0){
                       ob.setVisible(false);
                       matriz.darPersonaje(fila, columna, p);
                   }
                t.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Figura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
