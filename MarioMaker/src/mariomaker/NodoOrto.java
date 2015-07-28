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
public class NodoOrto {
    int numero;
    int c;
    int f;
    String imagen;
    NodoOrto siguiente;
    NodoOrto anterior;
    NodoOrto abajo;
    NodoOrto arriba;
    NodoOrto derecha;
    NodoOrto izquierda;
    NodoOrto(int numero,int c, int f, String imagen)
    {
        this.numero = numero;
        this.c = c;
        this.f = f;
        this.imagen = imagen;
        this.siguiente = null;
        this.anterior = null;
        this.abajo = null;
        this.arriba = null;
        this.derecha = null;
        this.izquierda = null;
    }
    
}
