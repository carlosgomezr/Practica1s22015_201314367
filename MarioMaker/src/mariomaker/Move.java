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
public class Move extends Thread{
public JLabel heroe;

    int posx=0;
    Raiz matriz;
    int fila;
    int columna;
    int sentido =-1;
    Thread t = new Thread();
    public void run(){
       
        while(true){

            try {
             
                   
                   //eje x
                    Personaje p;
                    
                    if(sentido==0){ 
                       
                        columna = (heroe.getX()-50)/50;
                        fila = (heroe.getY()-340)/(-50);
                        p = matriz.getPersonaje(fila, columna);
                    if((p.tipo.compareTo("vacio")==0)|(p.tipo.compareTo("moneda")==0)|(p.tipo.compareTo("moneda")==0)|(p.tipo.compareTo("monstruo")==0)){
                         
                         sentido = 0;
                    }
                    
                    if((p.tipo.compareTo("pared")==0)|(p.tipo.compareTo("suelo")==0)){
                        sentido = 1;
                    }
                        heroe.setLocation(heroe.getX()-50, heroe.getY());
                        matriz.darPersonaje(heroe.getY(),heroe.getX(), p);
                    }
                    
                    if(sentido==1){
                        heroe.setLocation(heroe.getX()+50, heroe.getY());
                       
                        columna = (heroe.getX()+50)/50;
                        fila = (heroe.getY()-340)/(-50);
                        p = matriz.getPersonaje(fila, columna);
                        matriz.darPersonaje(heroe.getY(),heroe.getX(), p);
                         
                         if((p.tipo.compareTo("vacio")==0)|(p.tipo.compareTo("moneda")==0)|(p.tipo.compareTo("moneda")==0)|(p.tipo.compareTo("monstruo")==0)){
                           
                            sentido = 1;
                         }
                          if((p.tipo.compareTo("pared")==0)|(p.tipo.compareTo("suelo")==0)){
                            
                            sentido = 0;
                            }
                        
                    }
                   
                    
                    //eje y
                    fila = (heroe.getY()-340+50)/(-50);
                    columna = (heroe.getX()/50);
                    p = matriz.getPersonaje(fila, columna);
                    if((p.tipo.compareTo("pared")==0)|(p.tipo.compareTo("suelo")==0)){
                           
                    }
                    else{
                        heroe.setLocation(heroe.getX(),heroe.getY()+50);
                    }
                                
                System.out.println("    HERO X: "+heroe.getX());
                System.out.println("    HERO y: "+heroe.getY());
                t.sleep(1500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Figura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

