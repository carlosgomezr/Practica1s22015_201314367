/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariomaker;

/**
 *
 * @author Carlos Gomez
 */
public class NodoLista {
    Object datos;
    NodoLista siguienteNodo;
    NodoLista(Object objeto){
        this(objeto, null);
    }
    
    NodoLista(Object objeto, NodoLista nodo){
        datos = objeto;
        siguienteNodo = nodo;
       
    }
    
    Object obtenerObject(){
        return datos;
    }
    
    NodoLista obtenerSiguiente(){
        return siguienteNodo;
    }
    
  
    
}
