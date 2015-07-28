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
public class nodo {
    Personaje personaje;
    nodo next;
    nodo ant;
    nodo(Personaje a)
    {
        this.personaje=a;
        this.next=null;
        this.ant=null;
    }
}
