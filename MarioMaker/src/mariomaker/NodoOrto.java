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
public class nodoorto {
    int a;
    int fila;
    int columna;
    nodoorto next;
    nodoorto ant;
    nodoorto arriba;
    nodoorto abajo;
    nodoorto derecha;
    nodoorto izquierda;
    nodoorto(int a,int c,int f)
    {
        this.a=a;
        this.fila = f;
        this.columna = c;
        this.next=null;
        this.ant=null;
        this.arriba=null;
        this.abajo=null;
        this.derecha=null;
        this.izquierda=null;
    }
}
