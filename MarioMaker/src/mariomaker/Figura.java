/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariomaker;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Carlos Gomez
 */
public class Figura extends Thread{
    public JLabel heroe;
    int posx=0;
    Raiz matriz;
    int fila;
    int columna;
    int sentido =0;
    int gravedad =0;
    
    Thread t = new Thread();
    public Figura(JLabel etiqueta,Raiz matriz,int fila, int columna){
        this.heroe = etiqueta;
        this.matriz = matriz;
      
    }
    public void run(){
       
        while(true){
         try {
                    Personaje p;
                    Personaje otro;
                    Personaje h;
                    
                   //eje x
                    
                    if(sentido==0){ 
                       
                        columna = (heroe.getX()-50)/50;
                        fila = (heroe.getY()-340)/(-50);
                        p = matriz.getPersonaje(fila, columna);
                    if((p.tipo.compareTo("vacio")==0)|(p.tipo.compareTo("ficha")==0)|(p.tipo.compareTo("monstruo")==0)|(p.tipo.compareTo("tortuga")==0)|(p.tipo.compareTo("castillo")==0)|(p.tipo.compareTo("hongo")==0)){
 
                                otro=matriz.getPersonaje(fila, columna+1);
                                matriz.darPersonaje(fila,columna, otro);
                                matriz.darPersonaje(fila,columna+1, p);
                        
                         
                         sentido = 0;
                    }
                    if(p.tipo.compareTo("personaje")==0){
                                matriz.darPersonaje(fila,columna, p);
                                //otro=matriz.getPersonaje(fila, columna+1);
                                //matriz.darPersonaje(fila,columna, otro);
                                
                        sentido = 1;
                    }
                    
                    if((p.tipo.compareTo("pared")==0)|(p.tipo.compareTo("suelo")==0)){
                        sentido = 1;
                    }
                    h = matriz.getPersonaje(fila, columna+1);
                    if(h.tipo.compareTo("personaje")==0){
                            
                        sentido = 1;
                    }
                        
                        heroe.setLocation(heroe.getX()-50, heroe.getY());
                        //matriz.darPersonaje(heroe.getY(),heroe.getX(), p);
                    }
                    
                    if(sentido==1){
                        heroe.setLocation(heroe.getX()+50, heroe.getY());
                       
                        columna = (heroe.getX()+50)/50;
                        fila = (heroe.getY()-340)/(-50);
                        p = matriz.getPersonaje(fila, columna);
                        
                         
                         if((p.tipo.compareTo("vacio")==0)|(p.tipo.compareTo("ficha")==0)|(p.tipo.compareTo("monstruo")==0)|(p.tipo.compareTo("tortuga")==0)|(p.tipo.compareTo("castillo")==0)|(p.tipo.compareTo("hongo")==0)){
                                otro=matriz.getPersonaje(fila, columna-1);
                                matriz.darPersonaje(fila,columna, otro);
                                matriz.darPersonaje(fila,columna-1, p);
                           
                            sentido = 1;
                         }
                         if(p.tipo.compareTo("personaje")==0){
                             matriz.darPersonaje(fila,columna, p);
                                //otro=matriz.getPersonaje(fila, columna+1);
                                //matriz.darPersonaje(fila,columna, otro);
                                
                             
                             sentido = 0;
                         }
                          if((p.tipo.compareTo("pared")==0)|(p.tipo.compareTo("suelo")==0)){
                            
                            sentido = 0;
                            }
                          h = matriz.getPersonaje(fila, columna-1);
                          if(h.tipo.compareTo("personaje")==0){
                            sentido = 0;
                          }
                    }if((sentido==1)|(sentido==0)){
                        fila = (heroe.getY()-340+50)/(-50);
                        columna = (heroe.getX()/50);
                        p = matriz.getPersonaje(fila, columna);
                        if((p.tipo.compareTo("pared")==0)|(p.tipo.compareTo("suelo")==0)){
                            
                        }
                        else{
                            
                            heroe.setLocation(heroe.getX(),heroe.getY()+50);
                            if(p.tipo.compareTo("vacio")==0){
                                
                                  otro=matriz.getPersonaje(fila+1, columna);
                                  matriz.darPersonaje(fila,columna, otro);
                                  matriz.darPersonaje(fila+1,columna, p);
                         
                            }
                            
                        }
               
                    }
                System.out.println("    HERO X: "+heroe.getX());
                System.out.println("    HERO y: "+heroe.getY());
                t.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Figura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
